<script setup>

</script>

<template>
  <div class="error">
    <h2>Error Details</h2>
    <div class="error-info">
      <p><strong>Status:</strong> {{ error.status }}</p>
      <p><strong>Error:</strong> {{ error.error }}</p>
      <p><strong>Timestamp:</strong> {{ error.timestamp }}</p>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    error: Object, // Принимайте объект ошибки в качестве свойства
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