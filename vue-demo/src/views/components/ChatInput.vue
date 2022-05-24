<template>
  <div>
    <input type="text" @keyup="enter" v-model="comment" />
    <button @click="send">{{ btnName }}</button>
  </div>
</template>


<script>
export default {
  name: "ChatInput",
  data() {
    return { comment: "" };
  },
  props: {
    btnName: String,
  },
  methods: {
    send() {
      if (this.comment === "") return;
      this.$emit("send", this.comment);
      this.comment = "";
    },
    enter({ key, code }) {
      if (key === "Enter" && code === "Enter") this.send();
    },
  },
};
</script>

<style scope>
</style>