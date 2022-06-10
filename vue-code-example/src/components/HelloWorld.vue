<template>
  <div class="hello">
    <global-component />
    <local-component />
  </div>
</template>

<script>
import LocalComponent from "./LocalComponent.vue";

export default {
  components: {
    LocalComponent,
  },
  name: "HelloWorld",
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.hello {
  background-color: bisque;
}
</style>

<style>
h1 {
  color: green;
}
</style>
