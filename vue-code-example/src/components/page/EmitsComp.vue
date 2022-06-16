<template>
  <parent-comp></parent-comp>
</template>

<script>
import ParentComp from "../emits/ParentComp";

export default {
  name: "emits-comp",
  components: {
    ParentComp,
  },
  props: {},
  data() {
    return {};
  },
  methods: {},
  computed: {},
  watch: {},
  mounted() {},
  updated() {},
};
</script>

<style lang='' src='' scoped>
</style>