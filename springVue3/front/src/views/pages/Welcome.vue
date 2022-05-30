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
import { post } from "@/utils/httpClient";

const validNickname = async (nickname) => {
  const data = await post("/login/find", { nickname });
  return {
    result: data.result,
    user: data.user,
  };
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
    async createNickname() {
      if (this.nickname !== null && this.nickname !== "") {
        const { result, user } = await validNickname(this.nickname);
        if (result === "success") {
          await this.$store.dispatch("addUser", user.nickname);
          await this.$router.push({ name: "RoomList" });
        }
      }
      return;
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss" src="styles/pages/Welcome.scss">
</style>
