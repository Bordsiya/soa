<script setup>

</script>

<template>
  <p class="response">{{ message_for_no_content }}</p>
</template>

<script>
export default {
  props: {
    message_for_no_content: '' // Принимаем объект организации как проп
  }
};

</script>

<style scoped>
p {
  font-size: 16px;
  color: #000;
}
</style>