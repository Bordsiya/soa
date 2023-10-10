<script setup>

</script>

<template>
  <div class="error">
    <h2>Error Details</h2>
    <div class="error-info">
      <p><strong>Status:</strong> {{ error.status }}</p>
      <p><strong>Error:</strong> {{ error.error }}</p>
      <p><strong>Timestamp:</strong> {{ convertToDate(error.timestamp) }}</p>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    error: Object, // Принимайте объект ошибки в качестве свойства
  },

  methods: {
    convertToDate(timestamp) {
      const date = new Date(timestamp);
      const year = date.getFullYear();
      const month = String(date.getMonth() + 1).padStart(2, '0'); // Месяц начинается с 0
      const day = String(date.getDate()).padStart(2, '0');
      const hours = String(date.getHours()).padStart(2, '0');
      const minutes = String(date.getMinutes()).padStart(2, '0');
      const seconds = String(date.getSeconds()).padStart(2, '0');

      const formattedDate = `${year}-${month}-${day} ${hours}:${minutes}:${seconds}`;
      return formattedDate;
    }

  }
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