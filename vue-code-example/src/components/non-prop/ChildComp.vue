<template>
  <div>
    <h1>{{ title }}</h1>
    <h2 v-bind="$attrs">First sentence here!</h2>
    <h2 v-bind:id="$attrs.id">Second sentence here!</h2>
    <h2 v-bind:class="$attrs.class">Third sentence here!</h2>
    <h2 v-bind:etc="$attrs.etc">Fourth sentence here!</h2>
    <h2 @click="clickHandler">Fifth sentence here!</h2>
  </div>
</template>

<script>
export default {
  inheritAttrs: false,
  name: "child-comp",
  components: {},
  props: {
    title: {
      type: String,
      default: "No Title",
    },
  },
  data() {
    return {};
  },
  methods: {
    clickHandler(e) {
      this.$attrs.onClick(e);
    },
  },
};
</script>

<style lang='css' src='' scoped>
#main-id {
  color: red;
}
.main-class {
  background-color: black;
}
</style>