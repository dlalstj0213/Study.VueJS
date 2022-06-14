<template>
  <HelloWorld />
</template>
<script>
import HelloWorld from "../HelloWorld.vue";

export default {
  name: "main-page",
  components: { HelloWorld },
  data() {
    return {};
  },
  props: {
    str: Array,
  },
  methods: {},
  computed: {},
  watch: {},
  mounted() {},
  updated() {},
};
</script>
<style lang='scss' src='' scoped>
</style>