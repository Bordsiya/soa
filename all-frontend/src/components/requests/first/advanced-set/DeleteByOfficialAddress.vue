<script setup>

import OtherError from "@/components/data-details/OtherError.vue";
import OkResponseNoContent from "@/components/data-details/OkResponseNoContent.vue";
import ViolationErrors from "../../../data-details/ViolationErrors.vue";
</script>

<template>
  <div class="container">
    <div class="left-side">
      <p class="description_text">Удаление организации по адресу</p>
      <form @submit="submitForm" class="form">
        <div class="form-group">
          <div class="another-field">
            <label for="officialAddressStreet">street</label>
            <input type="text" id="officialAddressStreet" v-model="formData.officialAddressStreet">
          </div>
          <div class="another-field">
            <label for="officialAddressZipCode">zipCode</label>
            <input type="text" id="officialAddressZipCode" v-model="formData.officialAddressZipCode">
          </div>
        </div>
        <button type="submit">Удалить организацию</button>
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
        <OkResponseNoContent :message_for_no_content="message_result"/>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import ErrorDto from "@/components/data-details/ErrorDto.vue";
import {headers, urls} from "@/configs/Config";
import {handleAxiosError} from "@/components/requests/ErrorHandler";
import '@/assets/requets.css';

export default {

  components: {
    ErrorDto
  },

  data() {
    return {
      formData: {
        officialAddressStreet: '',
        officialAddressZipCode: ''
      },

      errorAll: null,
      message_result: ''
    }
  },

  methods: {
    submitForm(event) {
      event.preventDefault();

      const queryParams = {
        officialAddressStreet: this.formData.officialAddressStreet,
        officialAddressZipCode: this.formData.officialAddressZipCode
      }

      const queryString = Object.entries(queryParams)
          .filter(([key, value]) => value !== undefined && value !== null)
          .map(([key, value]) =>
              Array.isArray(value) ? value.map(v => `${key}=${encodeURIComponent(v)}`).join('&') : `${key}=${encodeURIComponent(value)}`
          )
          .join('&');

      const url = `${urls[0]}/organizations/official-address?${queryString}`
      console.log(url)

      // Сбросил вывод о прошлом действии
      this.message_result = null
      this.errorAll = null

      axios.create()
          .delete(url, {headers})
          .then(response => {
            this.message_result = "Организация удалена.";
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