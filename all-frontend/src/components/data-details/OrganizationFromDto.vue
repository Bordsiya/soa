<script setup>

</script>

<template>
  <div v-if="organization">
    <h2>{{ organization.name }}</h2>
    <p>ID: {{ organization.id }}</p>
    <p>Координаты: ({{ organization.coordinates.x }}, {{ organization.coordinates.y }})</p>
    <p>Дата создания: {{ organization.creationDate }}</p>
    <p>Годовой оборот: {{ organization.annualTurnover }}</p>
    <p>Тип: {{ organization.type }}</p>
    <p>Адрес: {{ organization.officialAddress.street }}, {{ organization.officialAddress.zipCode }}</p>
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