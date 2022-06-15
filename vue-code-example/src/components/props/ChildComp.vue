<template>
  <div>
    <h1>{{ title }}</h1>
    <h2>Copyed Title : {{ copyedTitle }}</h2>
    <h2>Two Type of props : {{ propB }}</h2>
    <h2>id? : {{ id }}</h2>
  </div>
</template>

<script>
export default {
  name: "child-comp",
  components: {},
  props: {
    title: String,
    propB: [String, Number],
    id: Number,
  },
  data() {
    return {
      copyedTitle: this.title,
    };
  },
};
</script>

<style lang='scss' src='' scoped>
</style>