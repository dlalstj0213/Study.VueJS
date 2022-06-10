<template>
  <div class="hello">
    <global-component />
    <local-component />
  </div>
  <div>
    <br />
    <parent-comp />
  </div>
</template>

<script>
import LocalComponent from "./LocalComponent.vue";
import ParentComp from "./ParentComp.vue";

export default {
  components: {
    LocalComponent,
    ParentComp,
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
