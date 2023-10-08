<script setup>
import Headline from "@/components/headers-and-static/Headline.vue";
import GetOneOrganization from "@/components/requests/first/basic-set/GetOneOrganization.vue";
import DeleteOneOrganization from "@/components/requests/first/basic-set/DeleteOneOrganization.vue";
import PostOneOrganization from "@/components/requests/first/basic-set/PostOneOrganization.vue";
import PutOneOrganization from "@/components/requests/first/basic-set/PutOneOrganization.vue";
import GetOrganizationsWithPreferences from "@/components/requests/first/basic-set/GetOrganizationsWithPreferences.vue";
import GetAnnualTurnoverSum from "@/components/requests/first/advanced-set/GetAnnualTurnoverSum.vue";
import GetAnnualTurnoverGrouped from "@/components/requests/first/advanced-set/GetAnnualTurnoverGrouped.vue";
import DeleteByOfficialAddress from "@/components/requests/first/advanced-set/DeleteByOfficialAddress.vue";
</script>

<template>
  <Headline :text_of_headline='headline_text'></Headline>

  <GetOneOrganization />
  <DeleteOneOrganization />
  <PostOneOrganization />
  <PutOneOrganization />
  <GetOrganizationsWithPreferences />
  <GetAnnualTurnoverSum />
  <GetAnnualTurnoverGrouped />
  <DeleteByOfficialAddress />
</template>

<script>

const headline_text = 'Organization Service:';

</script>

<style scoped>

</style>