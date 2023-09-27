<script setup>
import Footer from "@/components/Footer.vue";
</script>

<template>

  <header>
    <div class="wrapper">
      <Footer />
    </div>
  </header>

  <main>
  </main>
</template>

<style scoped>
header {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 10vh; /* Занимает 10% высоты */
  line-height: 1.5;
  z-index: 1000;
  display: flex; /* Выравнивание по горизонтали */
  justify-content: center; /* Выравнивание текста по центру */
}

@media (min-width: 1024px) {
  header {
    display: flex;
    place-items: center;
    padding-right: calc(var(--section-gap) / 2);
  }

}
</style>
