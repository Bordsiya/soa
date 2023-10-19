<template>
  <div class="navigation">
    <div class="trapezoid-first">
      <button type="button" class="my-button" @click="component='First'">FIRST SERVICE</button>
    </div>
    <div class="trapezoid-second">
      <button type="button" class="my-button" @click="component='Second'">SECOND SERVICE</button>
    </div>
    <div class="trapezoid-third">
      <button type="button" class="my-button" @click="component='Third'">THIRD SERVICE</button>
    </div>
  </div>


  <div>
    <KeepAlive>
      <component :is="component"></component>
    </KeepAlive>
  </div>
</template>

<script>
import First from "@/components/First.vue";
import Second from "@/components/Second.vue";
import Third from "@/components/Third.vue";

export default {
  components: {
    First,
    Second,
    Third
  },

  data() {
    return {
      component: 'First'
    }
  }
}

</script>

<style scoped>
@import "@/assets/navigation-and-buttons.css";
</style>