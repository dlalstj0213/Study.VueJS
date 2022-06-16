<template>
  <child-comp :count="count" v-on:count-handler="clickHandler"></child-comp>
</template>

<script>
import ChildComp from "./ChildComp";

export default {
  name: "parent-comp",
  components: {
    ChildComp,
  },
  props: {},
  data() {
    return {
      count: 0,
    };
  },
  methods: {
    clickHandler(value, event) {
      console.log("clicked! ::", value, event);
      this.count = value;
    },
  },
  errorCaptured: function (err, instance, info) {
    console.log("Parent :: CALL");
    console.log(err);
    console.log(instance);
    console.log(info);
    this.count = instance.$options.name === "child-comp" ? 0 : this.count;
    return false;
  },
};
</script>

<style lang='' src='' scoped>
</style>