<script setup>

</script>

<template>
  <div v-if="organization">
    <div id="organization_view" class="organization_view">
      <h2 :data-tooltip="organization.name">{{ organization.name }}</h2>
      <p>ID: {{ organization.id }}</p>
      <p>Координаты: ({{ organization.coordinates.x }}, {{ organization.coordinates.y }})</p>
      <p>Дата создания: {{ organization.creationDate }}</p>
      <p>Годовой оборот: {{ organization.annualTurnover }}</p>
      <p>Тип: {{ organization.type }}</p>
      <p>Адрес: {{ organization.officialAddress.street }}, {{ organization.officialAddress.zipCode }}</p>
    </div>
  </div>
  <div v-else>
    <p class="error_text">Данные организации не загружены.</p>
  </div>
</template>

<script>
export default {
  props: {
    organization: Object // Принимаем объект организации как проп
  }
};

</script>

<style scoped>
@import "@/assets/dto-style.css";
</style>