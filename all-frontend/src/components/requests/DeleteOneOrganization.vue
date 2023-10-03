<script setup>

import OtherError from "@/components/data-details/OtherError.vue";
import OkResponseNoContent from "@/components/data-details/OkResponseNoContent.vue";
</script>

<template>
  <div class="container">
    <div class="left-side">
      <p class="description_text">Удаление организации по id</p>
      <form @submit="submitForm" class="form">
        <div class="form-group">
          <label for="id">id</label>
          <input type="text" id="id" v-model="formData.id">
        </div>
        <button type="submit">Удалить организацию</button>
      </form>
    </div>
    <div class="right-side">
      <div v-if="errorAll" class="error-message">
        <div v-if="errorAll.status" class="other-message">
          <OtherError :error="errorAll" />
        </div>
        <div v-else>
          <ErrorDto :error="errorAll" />
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
import headers from "@/configs/Config";

export default {

  components: {
    ErrorDto
  },

  data() {
    return {
      formData: {
        id: '',
      },

      errorAll: null,
      message_result: ''
    };
  },

  methods: {
    submitForm(event) {
      event.preventDefault();

      // Сбросил вывод о прошлом действии
      this.message_result = null
      // Выполните запрос на сервер (например, с использованием Axios)
      axios.create()
          .delete(`https://localhost:9099/organizations/${this.formData.id}`, {headers})
          .then(response => {
            this.message_result = "Организация удалена.";
          })
          .catch(error => {
            this.errorAll = error.response.data;
            console.log(error);
          });
    },
  },
};
</script>

<style scoped>
.container {
  display: flex; /* Добавляем свойство display: flex; для контейнера */
}

.left-side {
  flex: 1;
  display: flex;
  justify-content: flex-end; /* Распределение между центром и правым краем */
  align-items: flex-start; /* Расположение по центру по вертикали */
  border: 2px solid #5d4747; /* Добавляем рамку */
  background: linear-gradient(to left, #9fa1a2, #262626);
  padding-right: 20px;
  padding-bottom: 10px;
}

.form {
  padding-top: 5%;
  padding-bottom: 3%;
  padding-right: 5%;
  display: flex;
  flex-direction: column;
  align-items: center; /* Расположение по центру по вертикали внутри формы */
}

.right-side {
  /* Стили для правой части */
  flex: 1;
  border: 2px solid #5d4747; /* Добавляем рамку */
  background: linear-gradient(to right, #9fa1a2, #262626);
  padding-left: 20px;
  padding-top: 5px;
  padding-bottom: 5px;
}

p.description_text {
  display: flex;
  justify-content: start;
  padding-top: 5%;
  padding-right: 5%;
  font-size: 20px;
  color: #51f61a;
}

.form-group {
  margin-bottom: 10px;
}

label {
  margin-right: 10px;
}

input {
  flex: 1;
  padding: 5px;
}

</style>