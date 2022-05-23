<template>
  <div class="hello">
    <h1>Welcome Vue.js!</h1>
    <p>Create Your Free Nickname :</p>
    <input
      type="text"
      name=""
      id="nickname"
      v-model="nickname"
      placeholder="input your nickname"
      v-on:keyup="enterToCreate"
    />
    <button v-on:click="createNickname">Create</button>
    <p id="err-msg">Here is the Error Message field</p>
  </div>
</template>

<script>
const validNickname = (nickname) => {
  console.log(nickname);
  return true;
};

export default {
  name: "WelcomePage",
  data() {
    return {
      nickname: "",
    };
  },
  methods: {
    enterToCreate({ key, code }) {
      if (key === "Enter" && code === "Enter") this.createNickname();
    },
    createNickname() {
      if (this.nickname !== null && this.nickname !== "") {
        validNickname(this.nickname);
        this.$router.push({ name: "RoomList" });
      }
      return;
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
