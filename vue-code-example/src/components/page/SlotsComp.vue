<template>
  <parent-comp></parent-comp>
</template>

<script>
import ParentComp from "../slots/ParentComp.vue";

export default {
  name: "slots-comp",
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