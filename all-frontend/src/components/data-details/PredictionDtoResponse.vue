<script setup>

</script>

<template>
  <div v-if="predictionDto">
    <h2>Вероятности</h2>
    <p>Годовой оборот увеличится: {{ predictionDto.increaseProbability }}</p>
    <p>Годовой оборот уменьшится: {{ predictionDto.decreaseProbability }}</p>
    <p>Годовой оборот не изменится: {{ predictionDto.remainProbability }}</p>

  </div>
  <div v-else>
    <p class="error_text">Данные организации не загружены.</p>
  </div>
</template>

<script>
export default {
  props: {
    predictionDto: Object // Принимаем объект организации как проп
  }
};

</script>

<style scoped>
@import "@/assets/dto-style.css";
</style>