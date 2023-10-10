<script setup>

</script>

<template>
  <div v-if="Quarter">
    <div class="details">
      <h2>Quarter number {{ Quarter.quarter }}</h2>
    </div>
  </div>
  <div v-else>
    <p class="error_text">Данные не загружены.</p>
  </div>
</template>

<script>
export default {
  props: {
    Quarter: Object, // Принимайте объект ошибки в качестве свойства
  },
};
</script>

<style scoped>
h2 {
  font-weight: bold;
  font-size: 24px;
  color: #51f61a;
}

p {
  font-size: 16px;
  color: #000;
}

</style>