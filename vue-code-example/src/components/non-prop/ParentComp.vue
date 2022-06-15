<template>
  <child-comp
    id="main-id"
    class="main-class"
    etc="etc"
    title="This is the Main Title !"
    @click="clickHandler"
  ></child-comp>
  <child-comp></child-comp>
</template>

<script>
import ChildComp from "./ChildComp";

export default {
  name: "parent-comp",
  components: { ChildComp },
  props: {},
  data() {
    return {};
  },
  methods: {
    clickHandler(e) {
      console.log(e.currentTarget);
    },
  },
};
</script>

<style lang='css' src='' scoped>
</style>


