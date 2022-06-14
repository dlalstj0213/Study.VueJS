<template>
  <div>
    <parent-comp></parent-comp>
  </div>
</template>
<script>
import ParentComp from "@/components/props/ParentComp.vue";

export default {
  name: "props-comp",
  components: { ParentComp },
  props: {},
  data() {
    return {};
  },
};
</script>
<style lang='scss' src='' scoped>
</style>