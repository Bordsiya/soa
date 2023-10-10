<script setup>
import Headline from "@/components/headers-and-static/Headline.vue";
import GetPredictForOrgByIdAnnualTurnover from "./requests/third/GetPredictForOrgByIdAnnualTurnover.vue";
import GetRecommendQuarter from "@/components/requests/third/GetRecommendQuarter.vue";
import GetRecommendedQuarterForCoordinates from "@/components/requests/third/GetRecommendedQuarterForCoordinates.vue";
</script>

<template>
  <Headline :text_of_headline='headline_text'></Headline>

  <GetPredictForOrgByIdAnnualTurnover />
  <GetRecommendQuarter />
  <GetRecommendedQuarterForCoordinates />

</template>

<script>

const headline_text = 'Analysis Service:';

</script>

<style scoped>

</style>