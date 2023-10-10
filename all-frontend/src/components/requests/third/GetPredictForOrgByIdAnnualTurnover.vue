<script setup>

import OtherError from "@/components/data-details/OtherError.vue";
import ViolationErrors from "../../data-details/ViolationErrors.vue";
</script>

<template>
  <div class="container">
    <div class="left-side">
      <p class="description_text">Расчёт развития годового оборота организации по id</p>
      <form @submit="submitForm" class="form">
        <div class="form-group">
          <div class="another-field">
            <label for="id">id</label>
            <input type="number" id="id" v-model="formData.id">
          </div>
        </div>
        <button type="submit">Рассчитать для организации организацию</button>
      </form>
    </div>
    <div class="right-side">
      <div v-if="errorAll" class="error-message">
        <div v-if="errorAll.violations">
          <ViolationErrors :errors="errorAll.violations"/>
        </div>

        <div v-else-if="errorAll.status" class="other-message">
          <OtherError :error="errorAll"/>
        </div>
        <div v-else>
          <ErrorDto :error="errorAll"/>
        </div>
      </div>
      <div v-else>
        <PredictionDtoResponse :predictionDto="predictionDto"/>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import PredictionDtoResponse from "@/components/data-details/PredictionDtoResponse.vue";
import ErrorDto from "@/components/data-details/ErrorDto.vue";
import {headers, urls} from "@/configs/Config";
import {handleAxiosError} from "@/components/requests/ErrorHandler";
import '@/assets/requets.css';

export default {

  components: {
    PredictionDtoResponse,
    ErrorDto
  },

  data() {
    return {
      formData: {
        id: '',
      },

      errorAll: null,
      predictionDto: null
    };
  },

  methods: {
    submitForm(event) {
      event.preventDefault();

      // Сбросил вывод о прошлом действии
      this.predictionDto = null
      this.errorAll = null

      axios.create()
          .get(`${urls[2]}/organalysis/predict/organizations/${this.formData.id}/annual-turnover`)
          .then(response => {
            console.log(response)
            this.predictionDto = response.data.body;
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