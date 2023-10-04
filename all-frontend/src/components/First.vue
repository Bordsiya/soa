<script setup>
import Headline from "@/components/headers-and-static/Headline.vue";
import GetOneOrganization from "@/components/requests/GetOneOrganization.vue";
import DeleteOneOrganization from "@/components/requests/DeleteOneOrganization.vue";
</script>

<template>
  <Headline :text_of_headline='headline_text'></Headline>

  <GetOneOrganization />
  <DeleteOneOrganization />
</template>

<script>

const headline_text = 'Organization Service:';

</script>

<style scoped>

</style>