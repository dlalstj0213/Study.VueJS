<template>
  <h1>This is Parent Component ::: {{ parentData }}</h1>
  <child-comp />
</template>
<script>
import ChildComp from "./ChildComp.vue";

export default {
  name: "parent-comp",
  components: { ChildComp },
  data() {
    return {
      parentData: "THIS IS Parent data",
    };
  },
  props: {},
  methods: {
    parentMethod() {
      console.log("Call parentMethod() :::", this.parentData);
    },
  },
  computed: {},
  watch: {},
  mounted() {},
  updated() {},
};
</script>
<style lang='scss' src='' scope>
</style>