<script setup>

import OtherError from "@/components/data-details/errors/OtherError.vue";
import ViolationErrors from "../../data-details/errors/ViolationError.vue";
import ValidationError from "@/components/data-details/errors/ValidationError.vue";
</script>

<template>
  <div class="container">
    <div class="left-side">
      <p class="description_text">Получение организаций по промежутку годовых оборотов</p>
      <form @submit="submitForm" class="form">
        <div class="form-group">
          <div class="another-field">
            <label for="min">min</label>
            <input type="text" id="min" v-model="formData.minAnnualTurnover">
          </div>
          <div class="another-field">
            <label for="max">max</label>
            <input type="text" id="max" v-model="formData.maxAnnualTurnover">
          </div>
        </div>
        <button type="submit">Найти организации</button>
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
import {
  addToValidationsAnotherError, validateAnnualTurnover,
  validateCoordinates,
  validateCreationDate,
  validateName
} from "@/components/utils/validate";

export default {

  components: {
    OrganizationFromDto,
    ErrorDto
  },

  data() {
    return {
      formData: {
        minAnnualTurnover: 0,
        maxAnnualTurnover: 0
      },

      errorAll: null,
      organizations: null
    };
  },

  methods: {
    validateAll() {
      if (!validateAnnualTurnover(this.formData.minAnnualTurnover)) {
        const validError = {
          fieldName: 'min',
          message: 'min annual turnover must be double and >0'
        };
        this.errorAll = addToValidationsAnotherError(this.errorAll, validError);
      }

      if (!validateAnnualTurnover(this.formData.maxAnnualTurnover)) {
        const validError = {
          fieldName: 'max',
          message: 'max annual turnover must be double and >0'
        };
        this.errorAll = addToValidationsAnotherError(this.errorAll, validError);
      }

    },

    submitForm(event) {
      event.preventDefault();

      // Сбросил вывод о прошлом действии
      this.organizations = null
      this.errorAll = null

      this.validateAll();
      if (this.errorAll && this.errorAll.validations) {
        return;
      }

      if (parseFloat(this.formData.minAnnualTurnover) > parseFloat(this.formData.maxAnnualTurnover)) {
        const validError = {
          fieldName: 'min/max',
          message: 'max must be >= min'
        };
        this.errorAll = addToValidationsAnotherError(this.errorAll, validError);
        return;
      }

      axios.create()
          .get(`${urls[1]}/orgdirectory/filter/turnover/${this.formData.minAnnualTurnover}/${this.formData.maxAnnualTurnover}`, {headers})
          .then(response => {
            this.organizations = response.data;
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