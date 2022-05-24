<template>
  <div>
    <input type="text" @keyup="enter" v-model="comment" />
    <button @click="send">Send</button>
  </div>
</template>


<script>
export default {
  name: "ChatInput",
  data() {
    return { comment: "" };
  },
  methods: {
    send() {
      console.log(this.comment);
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