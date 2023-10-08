<script setup>
import Headline from "@/components/headers-and-static/Headline.vue";
import GetFilterByAnnualTurnover from "@/components/requests/second/GetFilterByAnnualTurnover.vue";
import GetFilterByEmployeesCount from "@/components/requests/second/GetFilterByEmployeesCount.vue";
</script>

<template>
  <Headline :text_of_headline='headline_text'></Headline>

  <GetFilterByAnnualTurnover />
  <GetFilterByEmployeesCount />

</template>

<script>

const headline_text = 'Orgdirectory Service:';

</script>

<style scoped>

</style>