<script setup>

import OtherError from "@/components/data-details/errors/OtherError.vue";
import GroupedAnnualTurnover from "@/components/data-details/GroupedAnnualTurnover.vue";
import ViolationErrors from "../../../data-details/errors/ViolationError.vue";
import ValidationError from "@/components/data-details/errors/ValidationError.vue";
</script>

<template>
  <div class="container">
    <div class="left-side">
      <p class="description_text">Группировка по годовым оборотам</p>
      <form @submit="submitForm" class="form">
        <div class="form-group">

        </div>
        <button type="submit">Сгруппировать организации</button>
      </form>
    </div>
    <div class="right-side">
      <div v-if="errorAll" class="error-message">
        <div v-if="errorAll.violations">
          <ViolationErrors :errors="errorAll.violations"/>
        </div>

        <div v-if="errorAll.validations">
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
        <GroupedAnnualTurnover :groupedByAnnual="groupedByAnnual"/>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import GroupedByAnnualTurnover from "@/components/data-details/GroupedAnnualTurnover.vue";
import ErrorDto from "@/components/data-details/errors/ErrorDto.vue";
import {headers, urls} from "@/configs/Config";
import {handleAxiosError} from "@/components/requests/ErrorHandler";
import '@/assets/requets.css';

export default {

  components: {
    GroupedByAnnualTurnover,
    ErrorDto
  },

  data() {
    return {
      formData: {
        id: '',
      },

      errorAll: null,
      groupedByAnnual: null
    };
  },

  methods: {
    submitForm(event) {
      event.preventDefault();

      // Сбросил вывод о прошлом действии
      this.groupedByAnnual = null
      this.errorAll = null

      axios.create()
          .get(`${urls[0]}/organizations/annual-turnover/grouped`, {headers})
          .then(response => {
            console.log(response);
            this.groupedByAnnual = response.data;
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