<script setup>
import OtherError from "@/components/data-details/errors/OtherError.vue";
import ViolationErrors from "../../../data-details/errors/ViolationError.vue";
import ValidationError from "@/components/data-details/errors/ValidationError.vue";

</script>

<template>
  <div class="container">
    <div class="left-side">
      <p class="description_text">Обновление организации по id</p>
      <form @submit="submitForm" class="form">
        <div class="form-group">
          <div class="another-field">
            <label for="id">id</label>
            <input type="number" id="id" v-model.number="id">
          </div>
          <div class="another-field">
            <label for="name">Имя</label>
            <input type="text" id="name" v-model="formData.name">
          </div>
          <div class="another-field">
            <label for="x">координата X</label>
            <input type="number" id="x" v-model="formData.coordinates.x">
          </div>
          <div class="another-field">
            <label for="y">координата Y</label>
            <input type="number" id="y" v-model="formData.coordinates.y">
          </div>
          <div class="another-field">
            <label for="creationDate">Дата создания</label>
            <input type="text" id="creationDate" v-model="formData.creationDate">
          </div>
          <div class="another-field">
            <label for="annualTurnover">Годовой оборот</label>
            <input type="text" id="annualTurnover" v-model="formData.annualTurnover">
          </div>
          <div class="another-field">
            <label for="type">Тип организации</label>
            <select id="type" v-model="formData.type">
              <option value="COMMERCIAL">COMMERCIAL</option>
              <option value="PUBLIC">PUBLIC</option>
              <option value="OPEN_JOINT_STOCK_COMPANY">OPEN_JOINT_STOCK_COMPANY</option>
            </select>
          </div>
          <div class="another-field">
            <label for="address">Адрес(улица)</label>
            <input type="text" id="address" v-model="formData.officialAddress.street">
          </div>
          <div class="another-field">
            <label for="zipcode">Индекс</label>
            <input type="text" id="zipcode" v-model="formData.officialAddress.zipCode">
          </div>
        </div>
        <button type="submit">Обновить организацию</button>
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
        <OrganizationFromDto :organization="organization"/>
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
import {
  addToValidationsAnotherError, validateAnnualTurnover,
  validateCoordinates,
  validateCreationDate, validateId,
  validateName
} from "@/components/utils/validate";

export default {

  components: {
    OrganizationFromDto,
    ErrorDto
  },

  data() {
    return {
      id: 0,
      formData: {
        name: '',
        coordinates: {
          x: 0,
          y: 0
        },
        creationDate: "2023-10-04",
        annualTurnover: 0,
        type: 'COMMERCIAL',
        officialAddress: {
          street: "Kosovo street",
          zipCode: "AE84C"
        }
      },

      errorAll: null,
      organization: null
    };
  },

  methods: {
    validateAll() {
      if (!validateId(this.formData.id)) {
        const validError = {
          fieldName: 'id',
          message: 'id must be not null and >0'
        };
        this.errorAll = addToValidationsAnotherError(this.errorAll, validError);
      }

      if (!validateName(this.formData.name)) {
        const validError = {
          fieldName: 'name',
          message: 'name must be not null and not blank'
        };
        this.errorAll = addToValidationsAnotherError(this.errorAll, validError);
      }

      if (!validateCoordinates(this.formData.coordinates)) {
        const validError = {
          fieldName: 'coordinates: x and y',
          message: 'x is double, y is integer, both is required.'
        };
        this.errorAll = addToValidationsAnotherError(this.errorAll, validError);
      }

      if (!validateCreationDate(this.formData.creationDate)) {
        const validError = {
          fieldName: 'creationDate',
          message: 'creationDate must be in format YYYY-MM-DD'
        };
        this.errorAll = addToValidationsAnotherError(this.errorAll, validError);
      }

      if (!validateAnnualTurnover(this.formData.annualTurnover)) {
        const validError = {
          fieldName: 'annualTurnover',
          message: 'annualTurnover must be not null and >0'
        };
        this.errorAll = addToValidationsAnotherError(this.errorAll, validError);
      }

      if (!validateName(this.formData.officialAddress.zipCode)) {
        const validError = {
          fieldName: 'zipCode',
          message: 'zipCode must be not null and not blank'
        };
        this.errorAll = addToValidationsAnotherError(this.errorAll, validError);
      }

      if (!validateName(this.formData.officialAddress.street)) {
        const validError = {
          fieldName: 'street',
          message: 'street must be not null and not blank'
        };
        this.errorAll = addToValidationsAnotherError(this.errorAll, validError);
      }
    },

    submitForm(event) {
      event.preventDefault();

      // Сбросил вывод о прошлом действии
      this.organization = null
      this.errorAll = null

      this.validateAll();
      if (this.errorAll && this.errorAll.validations) {
        return;
      }

      axios.create()
          .put(`${urls[0]}/organizations/${this.id}`, this.formData, {headers})
          .then(response => {
            this.organization = response.data;
          })
          .catch(error => {
            this.errorAll = handleAxiosError(error);
          });
    },
  },
};
</script>

<style scoped>
@import "@/assets/forms-inputs.css";
</style>