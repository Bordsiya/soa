<template>
  <div class="trapezoid">
    <p class="my_text">{{ text_of_headline }}</p>
  </div>
</template>

<script>
export default {
  props: {
    text_of_headline: String // Определите свойство text как строку
  }
}
</script>

<style scoped>

.trapezoid {
  width: 50%;
  height: 100px;
  background: linear-gradient(to right, #918080, #333); /* Градиентный фон от светло-серого слева до темно-серого справа */
  clip-path: polygon(0% 0%, 100% 0%, 90% 100%, 0% 100%); /* Координаты для трапеции */
}

.my_text {
  position: relative;
  top: 25%;
  left: 50%;
  font-size: 28px; /* Размер текста */
  font-weight: bold; /* Жирный шрифт */
  color: #fc0e0e;
}

</style>