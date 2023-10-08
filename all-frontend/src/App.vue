<script setup>

import Header from "@/components/headers-and-static/Header.vue";
import First from "@/components/First.vue";
import Second from "@/components/Second.vue";
import Third from "@/components/Third.vue";
</script>

<template>
  <header>
    <div class="header-fixed">
      <Header />
    </div>
  </header>
  <main>
    <First />
    <Second />
    <Third />
  </main>

</template>

<style scoped>

header {
  position: fixed;
  left: 0;
  top: 0;
  right: 0;
  height: 8vh; /* Занимает 10% высоты */
}

main {
  padding-top: 8vh;
}

</style>
