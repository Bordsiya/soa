<script setup>

import OtherError from "@/components/data-details/errors/OtherError.vue";
import ViolationErrors from "../../../data-details/errors/ViolationError.vue";
import ValidationError from "@/components/data-details/errors/ValidationError.vue";
</script>

<template>
  <div class="container">
    <div class="left-side">
      <p class="description_text">Получение организаций с фильтрами и сортировками</p>
      <form @submit="submitForm" class="form">
        <div class="form-group">
          <div class="another-field">
            <label for="pageNumber">Page Number</label>
            <input type="number" id="pageNumber" v-model="formData.pageNumber">
          </div>
          <div class="another-field">
            <label for="pageSize">Page Size</label>
            <input type="number" id="pageSize" v-model="formData.pageSize">
          </div>
          <div class="field-sort-or-filter">
            <!-- Фильтры (можно добавлять динамически) -->
            <div v-for="(filter, index) in formData.filters" :key="index" class="sort-field">
              <label :for="'filter_' + index">Filter {{ index + 1 }}</label>
              <input :id="'filter_' + index" v-model="formData.filters[index]">
              <button type="button" @click="removeFilter(index)">Удалить фильтр</button>
            </div>
            <button type="button" @click="addFilter">Добавить фильтр</button>
          </div>
          <div class="field-sort-or-filter">
            <!-- Сортировка (можно добавлять динамически) -->
            <div v-for="(sort, index) in formData.sortBy" :key="index" class="sort-field">
              <label :for="'sort_' + index">Sort {{ index + 1 }}</label>
              <select :id="'sort_' + index" v-model="formData.sortBy[index]">
                <option value="id">ID</option>
                <option value="name">Name</option>
                <option value="coordinates.x">Coordinates X</option>
                <option value="coordinates.y">Coordinates Y</option>
                <option value="creationDate">Creation Date</option>
                <option value="annualTurnover">Annual Turnover</option>
                <option value="type">Type</option>
                <option value="officialAddress.street">Official Address Street</option>
                <option value="officialAddress.zipCode">Official Address Zip Code</option>
              </select>
              <button type="button" @click="removeSort(index)">Удалить сортировку</button>
            </div>
            <button type="button" @click="addSort">Добавить сортировку</button>
          </div>
        </div>
        <button type="submit">Поиск организаций с настройкой</button>
      </form>
    </div>
    <div class="right-side">
      <div v-if="errorAll" class="error-message">
        <div v-if="errorAll.violations">
          <ViolationErrors :errors="errorAll.violations"/>
        </div>

        <div v-else-if="errorAll.validations">
          <ValidationError :errors="errorAll.validations"/>
        </div>

        <div v-else-if="errorAll.status" class="other-message">
          <OtherError :error="errorAll"/>
        </div>

        <div v-else>
          <ErrorDto :error="errorAll"/>
        </div>
      </div>
      <div v-else>
        <div v-for="(organization, index) in organizations" :key="index">
          <OrganizationFromDto :organization="organization" />
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import OrganizationFromDto from "@/components/data-details/OrganizationFromDto.vue";
import ErrorDto from "@/components/data-details/errors/ErrorDto.vue";
import {headers, urls} from "@/configs/Config";
import {handleAxiosError} from "@/components/requests/ErrorHandler";
import '@/assets/requets.css';
import {addToValidationsAnotherError, validateOrganizationFilters, validatePageNumberOrPageSize, validateId} from "@/components/utils/validate";

export default {

  components: {
    OrganizationFromDto,
    ErrorDto
  },

  data() {
    return {
      formData: {
        pageNumber: '1',
        pageSize: '5',
        filters: [],
        sortBy: [],
      },

      errorAll: null,
      organizations: null
      //     [
      //   {
      //     name: "123",
      //     id: "123",
      //     coordinates: {
      //       x: "123",
      //       y: "3"
      //     },
      //     creationDate: "123",
      //     annualTurnover: 5,
      //     type: "123",
      //     officialAddress: {
      //       zipcode: "123",
      //       street: "3"
      //     }
      //   },
      //   {
      //     name: "123123131314авпуквпв123123131314авпуквпв123123131314авпуквпв АБОБА АБОБА ОДИН МАНУЛ ДВА МАНУЛА ТРИ МАНУЛААБОБА АБОБА ОДИН МАНУЛ ДВА МАНУЛА ТРИ МАНУЛААБОБА АБОБА ОДИН МАНУЛ ДВА МАНУЛА ТРИ МАНУЛА",
      //     id: "123",
      //     coordinates: {
      //       x: "123",
      //       y: "3"
      //     },
      //     creationDate: "123",
      //     annualTurnover: 5,
      //     type: "123",
      //     officialAddress: {
      //       zipcode: "123",
      //       street: "3"
      //     }
      //   }
      // ]
    };
  },

  methods: {
    validateAll() {
      if (!validatePageNumberOrPageSize(this.formData.pageNumber)) {
        const validError = {
          fieldName: 'pageNumber',
          message: 'pageNumber must be not null and >= 0'
        };
        this.errorAll = addToValidationsAnotherError(this.errorAll, validError);
      }

      if (!validatePageNumberOrPageSize(this.formData.pageSize)) {
        const validError = {
          fieldName: 'pageSize',
          message: 'pageSize must be not null and >= 0'
        };
        this.errorAll = addToValidationsAnotherError(this.errorAll, validError);
      }

      if (!validateOrganizationFilters(this.formData.filters)) {
        const validError = {
          fieldName: 'filter(-s)',
          message: 'Every filter must be not null and not blank'
        };
        this.errorAll = addToValidationsAnotherError(this.errorAll, validError);
      }

      if (!validateOrganizationFilters(this.formData.sortBy)) {
        const validError = {
          fieldName: 'sort(-s)',
          message: 'Every sorting field must be not null and not blank'
        };
        this.errorAll = addToValidationsAnotherError(this.errorAll, validError);
      }

    },

    submitForm(event) {
      event.preventDefault();

      // сброс состояния
      this.organizations = null;
      this.errorAll = null;

      this.validateAll();
      if (this.errorAll && this.errorAll.validations) {
        return;
      }

      // Формируем URL с параметрами
      const queryParams = {
        pageNumber: this.formData.pageNumber,
        pageSize: this.formData.pageSize,
        filters: this.formData.filters,
        sortBy: this.formData.sortBy,
      };

      // Преобразуем объект queryParams в строку для добавления в URL
      const queryString = Object.entries(queryParams)
          .filter(([key, value]) => value !== undefined && value !== null)
          .map(([key, value]) =>
              Array.isArray(value) ? value.map(v => `${key}=${encodeURIComponent(v)}`).join('&') : `${key}=${encodeURIComponent(value)}`
          )
          .join('&');

      // Формируем URL для отправки запроса
      const url = `${urls[0]}/organizations?${queryString}`;
      console.log('url = ' + url);

      axios.create()
          .get(url, {headers})
          .then(response => {
            console.log(response)
            this.organizations = response.data;
          })
          .catch(error => {
            this.errorAll = handleAxiosError(error);
          });
    },

    addFilter() {
      this.formData.filters.push('');
    },
    removeFilter(index) {
      this.formData.filters.splice(index, 1);
    },

    addSort() {
      this.formData.sortBy.push('');
    },
    removeSort(index) {
      this.formData.sortBy.splice(index, 1);
    },
  },
};
</script>

<style scoped>
@import "@/assets/forms-inputs.css";

</style>