<template>
  <parent-comp></parent-comp>
</template>
<script>
import ParentComp from "../non-prop/ParentComp.vue";

export default {
  name: "non-prop-comp",
  components: { ParentComp },
  props: {},
  data() {
    return {};
  },
};
</script>
<style lang='css' src='' scoped>
</style>