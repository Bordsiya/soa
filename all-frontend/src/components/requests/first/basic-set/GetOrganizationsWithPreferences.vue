<script setup>

import OtherError from "@/components/data-details/OtherError.vue";
</script>

<template>
  <div class="container">
    <div class="left-side">
      <p class="description_text">Получение организаций с фильтрами и сортировками</p>
      <form @submit="submitForm" class="form">
        <div class="form-group">
          <div class="another-field">
            <label for="pageNumber">Page Number</label>
            <input type="number" id="pageNumber" v-model="pageNumber">
          </div>
          <div class="another-field">
            <label for="pageSize">Page Size</label>
            <input type="number" id="pageSize" v-model="pageSize">
          </div>
          <div class="field-sort-or-filter">
            <!-- Фильтры (можно добавлять динамически) -->
            <div v-for="(filter, index) in filters" :key="index" class="sort-field">
              <label :for="'filter_' + index">Filter {{ index + 1 }}</label>
              <input :id="'filter_' + index" v-model="filters[index]">
              <button type="button" @click="removeFilter(index)">Удалить фильтр</button>
            </div>
            <button type="button" @click="addFilter">Добавить фильтр</button>
          </div>
          <div class="field-sort-or-filter">
            <!-- Сортировка (можно добавлять динамически) -->
            <div v-for="(sort, index) in sortBy" :key="index" class="sort-field">
              <label :for="'sort_' + index">Sort {{ index + 1 }}</label>
              <select :id="'sort_' + index" v-model="sortBy[index]">
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
        <div v-if="errorAll.status" class="other-message">
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
import ErrorDto from "@/components/data-details/ErrorDto.vue";
import {headers, urls} from "@/configs/Config";
import {handleAxiosError} from "@/components/requests/ErrorHandler";
import '@/assets/requets.css';

export default {

  components: {
    OrganizationFromDto,
    ErrorDto
  },

  data() {
    return {
      pageNumber: 1,
      pageSize: 5,
      filters: [], // Массив для фильтров
      sortBy: [], // Массив для сортировки

      errorAll: null,
      organizations: null
    };
  },
  methods: {
    submitForm(event) {
      event.preventDefault();

      // Формируем URL с параметрами
      const queryParams = {
        pageNumber: this.pageNumber,
        pageSize: this.pageSize,
        filters: this.filters,
        sortBy: this.sortBy,
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

      this.organizations = null;
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
      this.filters.push('');
    },
    removeFilter(index) {
      this.filters.splice(index, 1);
    },
    addSort() {
      this.sortBy.push('');
    },
    removeSort(index) {
      this.sortBy.splice(index, 1);
    },
  },
};
</script>

<style scoped>
@import "@/assets/forms-inputs.css";

</style>