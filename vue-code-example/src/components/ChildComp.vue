<template>
  <h1>This is Child Component ::: {{ this.$parent.parentData }}</h1>
  <button @click="accessParent">Access Parent</button>
</template>
<script>
export default {
  name: "child-comp",
  components: {},
  data() {
    return {};
  },
  props: {},
  methods: {
    accessParent() {
      console.log(this.$parent.parentData);
      this.$parent.parentData = "changed by child component";
      this.$parent.parentMethod();
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