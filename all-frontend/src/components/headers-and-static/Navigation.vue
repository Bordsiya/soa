<template>
  <div class="navigation">
    <div class="trapezoid-first">
      <a href="#/first" class="my_text">FIRST</a>
    </div>
    <div class="trapezoid-second">
      <a href="#/second" class="my_text">SECOND</a>
    </div>
    <div class="trapezoid-third">
      <a href="#/third" class="my_text">THIRD</a>
    </div>
  </div>
</template>

<script>
</script>

<style scoped>

.navigation {
  text-align: center;
  display: inline-flex;
  width: 100%;
  //max-height: 3vh;

}

.trapezoid-first {
  width: 34%;
  background: linear-gradient(to right, #735959, #60523a); /* Градиентный фон от светло-серого слева до темно-серого справа */
}

.trapezoid-second {
  width: 33%;
  background: linear-gradient(to right, #60523a, #c04848); /* Градиентный фон от светло-серого слева до темно-серого справа */
}

.trapezoid-third {
  width: 33%;
  background: linear-gradient(to right, #c04848, #1d0131); /* Градиентный фон от светло-серого слева до темно-серого справа */
}

.my_text {
  text-align: center;
  font-size: 28px; /* Размер текста */
  font-weight: bold; /* Жирный шрифт */
  color: #fc0e0e;
}

</style>