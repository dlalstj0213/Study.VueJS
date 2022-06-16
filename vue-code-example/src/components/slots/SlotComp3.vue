<template>
  <div class="container">
    <header>
      <slot name="header"></slot>
    </header>
    <main>
      <slot></slot>
    </main>
    <footer>
      <slot name="footer"></slot>
    </footer>
  </div>
</template>

<script>
export default {
  name: "SlotComp3",
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
.container {
  color: white;
  font-size: 20px;
}

header {
  background-color: rgb(0, 0, 0);
}
main {
  background-color: rgb(57, 122, 67);
}
footer {
  background-color: rgba(255, 0, 0, 0.713);
}
</style>