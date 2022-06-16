<template>
  <div>
    <h1>{{ count }}</h1>
    <button @click="increase(1, $event)">Increase</button>
    <button @click="decrease">Decrease</button>
  </div>
</template>

<script>
export default {
  inheritAttrs: false,
  name: "child-comp",
  components: {},
  props: {
    count: Number,
  },
  data() {
    return {};
  },
  methods: {
    increase(value, event) {
      this.$emit("countHandler", this.count + value, event);
    },
    decrease() {
      this.$emit("countHandler", this.count - 1);
    },
  },
  emits: {
    click: (event) => {
      console.log(event);
      return true;
    },
    countHandler: (count) => {
      console.log(count);
      if (count > 10) {
        console.warn("잘못된 이벤트");
        throw new Error();
        // return false;
      }
      return true;
    },
  },
};
</script>

<style lang='' src='' scoped>
</style>