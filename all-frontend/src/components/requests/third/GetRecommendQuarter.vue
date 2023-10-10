<script setup>

import OtherError from "@/components/data-details/OtherError.vue";
</script>

<template>
  <div class="container">
    <div class="left-side">
      <p class="description_text">Получение наиболее удобной четверти для организации</p>
      <form @submit="submitForm" class="form">
        <div class="form-group">

        </div>
        <button type="submit">Рассчитать четверть</button>
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
        <QuarterDto :Quarter="quarter"/>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import QuarterDto from "@/components/data-details/QuarterDto.vue";
import ErrorDto from "@/components/data-details/ErrorDto.vue";
import {headers, urls} from "@/configs/Config";
import {handleAxiosError} from "@/components/requests/ErrorHandler";
import '@/assets/requets.css';

export default {

  components: {
    QuarterDto,
    ErrorDto
  },

  data() {
    return {
      formData: {
        id: '',
      },

      errorAll: null,
      quarter: 0
    };
  },

  methods: {
    submitForm(event) {
      event.preventDefault();

      // Сбросил вывод о прошлом действии
      this.quarter = null
      this.errorAll = null

      const headersAll = {
        // 'Access-Control-Allow-Origin': '*',
        // 'Access-Control-Allow-Headers': '*',
        // 'Access-Control-Allow-Credentials': "true",
        // 'Accept': '*/*',
        // 'Content-Type': 'application/json'
      }

      axios.create()
          .get(`${urls[2]}/organalysis/recommend/coordinates/quarter`, {
            headers: headersAll
          })
          .then(response => {
            console.log(response);
            this.quarter = response.data.body;
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