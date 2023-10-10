<script setup>

import OtherError from "@/components/data-details/OtherError.vue";
import ViolationErrors from "../../../data-details/ViolationErrors.vue";
</script>

<template>
  <div class="container">
    <div class="left-side">
      <p class="description_text">Получение суммы годовых оборотов</p>
      <form @submit="submitForm" class="form">
        <div class="form-group">

        </div>
        <button type="submit">Получить сумму годовых оборотов всех компаний</button>
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
        <TotalSum :totalSum="totalSum"/>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import TotalSum from "@/components/data-details/TotalSum.vue";
import ErrorDto from "@/components/data-details/ErrorDto.vue";
import {headers, urls} from "@/configs/Config";
import {handleAxiosError} from "@/components/requests/ErrorHandler";
import '@/assets/requets.css';

export default {

  components: {
    TotalSum,
    ErrorDto
  },

  data() {
    return {
      formData: {
        id: '',
      },

      errorAll: null,
      totalSum: 0
    };
  },

  methods: {
    submitForm(event) {
      event.preventDefault();

      // Сбросил вывод о прошлом действии
      this.totalSum = null
      this.errorAll = null

      axios.create()
          .get(`${urls[0]}/organizations/annual-turnover/sum`, {headers})
          .then(response => {
            console.log(response);
            this.totalSum = response.data;
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