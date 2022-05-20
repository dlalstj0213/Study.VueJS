<template>
  <img alt="Vue logo" src="./assets/logo.png" />
  <router-view />
  <p id="err-msg">Here is the Error Message field</p>
</template>

<script>
// import WelcomePage from "./views/pages/Welcome.vue";

// export default {
//   name: "App",
//   components: {
//     WelcomePage,
//   },
// };
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

#err-msg {
  color: red;
}
</style>
