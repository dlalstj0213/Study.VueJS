<template>
  <child-comp
    v-bind:title="'This is Child Component'"
    :propB="1234"
  ></child-comp>
</template>

<script>
import ChildComp from "@/components/props/ChildComp.vue";

export default {
  name: "parent-comp",
  components: { ChildComp },
};
</script>

<style lang='scss' src='' scoped>
</style>


