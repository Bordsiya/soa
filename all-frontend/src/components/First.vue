<script setup>
import GetOneOrganization from "@/components/requests/first/basic-set/GetOneOrganization.vue";
import DeleteOneOrganization from "@/components/requests/first/basic-set/DeleteOneOrganization.vue";
import PostOneOrganization from "@/components/requests/first/basic-set/PostOneOrganization.vue";
import PutOneOrganization from "@/components/requests/first/basic-set/PutOneOrganization.vue";
import GetOrganizationsWithPreferences from "@/components/requests/first/basic-set/GetOrganizationsWithPreferences.vue";
import GetAnnualTurnoverSum from "@/components/requests/first/advanced-set/GetAnnualTurnoverSum.vue";
import GetAnnualTurnoverGrouped from "@/components/requests/first/advanced-set/GetAnnualTurnoverGrouped.vue";
import DeleteByOfficialAddress from "@/components/requests/first/advanced-set/DeleteByOfficialAddress.vue";
import GetAllOrganizations from "@/components/requests/first/basic-set/GetAllOrganizations.vue";
</script>

<template>
  <div class="overflow-wrapper">
    <GetOneOrganization/>
    <DeleteOneOrganization/>
    <PostOneOrganization/>
    <PutOneOrganization/>
    <GetAllOrganizations/>
    <GetOrganizationsWithPreferences/>
    <GetAnnualTurnoverSum/>
    <GetAnnualTurnoverGrouped/>
    <DeleteByOfficialAddress/>
  </div>
</template>

<script>
</script>

<style scoped>

</style>