<template>
  <div class="side-bar">
    <router-link :to="'/'">Main</router-link> <br />
    <router-link :to="'/test'">Parent & Child</router-link>
  </div>
</template>
<script>
export default {
  name: "SideBar",
  components: {},
  data() {
    return {};
  },
  props: {},
  methods: {},
  computed: {},
  watch: {},
  mounted() {},
  updated() {},
};
</script>
<style scoped>
.side-bar {
  width: 200px;
  height: 100vh;
  background-color: blanchedalmond;
}
</style>