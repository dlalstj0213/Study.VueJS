<template>
  <div>
    <p>
      <slot></slot>
    </p>
  </div>
</template>

<script>
export default {
  name: "SlotComp1",
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
  color: blueviolet;
  font-size: 20px;
}
</style>