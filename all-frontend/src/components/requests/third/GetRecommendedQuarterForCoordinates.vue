<script setup>

import OtherError from "@/components/data-details/errors/OtherError.vue";
import ViolationErrors from "../../data-details/errors/ViolationError.vue";
import ValidationError from "@/components/data-details/errors/ValidationError.vue";
</script>

<template>
  <div class="container">
    <div class="left-side">
      <p class="description_text">Получение организаций для работы по координатам</p>
      <form @submit="submitForm" class="form">
        <div class="form-group">
          <div class="another-field">
            <label for="x">x</label>
            <input type="text" id="x" v-model="formData.x">
          </div>
          <div class="another-field">
            <label for="y">y</label>
            <input type="number" id="y" v-model="formData.y">
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
        x: '',
        y: ''
      },

      errorAll: null,
      organizations: null
    };
  },

  methods: {
    validateAll() {
      const coordinates = {
        x: this.formData.x,
        y: this.formData.y
      }

      if (!validateCoordinates(coordinates)) {
        const validError = {
          fieldName: 'coordinates: x and y',
          message: 'x is double, y is integer, both is required.'
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

      axios.create()
          .get(`${urls[2]}/organalysis/recommend/organizations/coordinates?x=${this.formData.x}&y=${this.formData.y}`)
          .then(response => {
            console.log(response)
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