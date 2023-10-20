<script setup>

import Header from "@/components/headers-and-static/Header.vue";
</script>

<template>
  <div class="all-page">
    <Header/>
    <div class="service">
      <router-view></router-view>
      <!--    <First />-->
      <!--    <Second />-->
      <!--    <Third />-->
    </div>
  </div>
</template>

<style scoped>
.all-page {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  overflow: auto;
  display: inline-flex;
}

.service {
  width: 100%;
  padding-top: 100px;
  min-height: 300px;
  min-width: 1000px;
}

</style>
