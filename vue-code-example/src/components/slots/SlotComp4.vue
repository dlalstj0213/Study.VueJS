<template>
  <div>
    <p v-for="(item, idx) in list" :key="idx">
      <slot :prop="item" :index="idx"></slot>
    </p>
  </div>
</template>

<script>
export default {
  name: "SlotComp4",
  components: {},
  props: {
    list: Array,
  },
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
  display: inline;
}
</style>