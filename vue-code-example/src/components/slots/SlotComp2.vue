<template>
  <div>
    <p>
      <slot>FallBack Contents</slot>
    </p>
  </div>
</template>

<script>
export default {
  name: "SlotComp2",
  components: {},
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

<style lang="css" src='' scoped>
p {
  color: blue;
  font-size: 20px;
}
</style>