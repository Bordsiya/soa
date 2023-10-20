<script setup>

</script>

<template>
  <div v-if="groupedByAnnual">
    <div class="details">
      <h2>Result</h2>
      <div>
        <table class="custom-table">
          <thead>
          <tr>
            <th class="large-text">Годовой оборот</th>
            <th class="large-text">Количество организаций</th>
          </tr>
          </thead>
          <tbody>
          <tr v-for="(item, index) in groupedByAnnual" :key="index">
            <td class="large-text">{{ item.annualTurnover }}</td>
            <td class="large-text">{{ item.organizationsCount }}</td>
          </tr>
          </tbody>
        </table>
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
    groupedByAnnual: Object, // Принимайте объект ошибки в качестве свойства
  },
};
</script>

<style scoped>
@import "@/assets/dto-style.css";
</style>