<script setup>

</script>

<template>
  <div v-if="totalSum">
    <div class="details">
      <h2>Result</h2>
      <div class="sum-info">
        <p><strong>Sum of annual turnover of all orgs:</strong> {{ totalSum.value }}</p>
      </div>
    </div>
  </div>
  <div v-else>
    <p class="error_text">Данные не загружены.</p>
  </div>
</template>

<script>
export default {
  props: {
    totalSum: Object, // Принимайте объект ошибки в качестве свойства
  },
};
</script>

<style scoped>
@import "@/assets/dto-style.css";
</style>