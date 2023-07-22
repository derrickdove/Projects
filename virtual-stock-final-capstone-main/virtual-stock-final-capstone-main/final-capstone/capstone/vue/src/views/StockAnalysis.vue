<template>
  <div class="stock-analysis">
    <div class="iframe-container">
      <iframe :src="stockAnalysisUrl" width="100%" height="500px"></iframe>
    </div>
  </div>
</template>

<script>
export default {
  name: 'StockAnalysis',
  data() {
    return {
      stockAnalysisUrl: 'https://stockanalysis.com/stocks/', 
    };
  },
};
</script>

<style scoped>
.stock-analysis {
  padding: 20px;
}

.iframe-container {
  width: 100%;
  height: 700px;
  border: 1px solid black;
  overflow: hidden;
}

iframe {
  width: 100%;
  height: 100%;
  border: none;
}
</style>