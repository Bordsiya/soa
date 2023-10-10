<script setup>

</script>

<template>
  <div class="error">
    <h2>Error Details VIOLATIONS</h2>
    <div class="error-info">
      <div v-for="(violation, index) in errors" :key="index">
        <p><strong>Error with field equals:</strong> {{ violation.fieldName }}</p>
        <p><strong>Message about:</strong> {{ violation.message }}</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    errors: Object, // Принимайте объект ошибки в качестве свойства
  },

};
</script>

<style scoped>
h2 {
  font-weight: bold;
  font-size: 24px;
  color: #51f61a;
}

.error {
  background-color: #ffcccc;
  border: 1px solid #ff0000;
  padding: 10px;
  margin: 10px 0;
}

.error-info {
  font-size: 14px;
}

p {
  font-size: 16px;
  color: #000;
}
</style>