<template>
  <header-bar />
  <div class="center">
    <side-bar />
    <!-- <img alt="Vue logo" src="./assets/logo.png" /> -->
    <div class="page">
      <router-view></router-view>
    </div>
  </div>
</template>

<script>
import SideBar from "./components/layout/SideBar.vue";
import HeaderBar from "./components/layout/HeaderBar.vue";

export default {
  name: "App",
  components: {
    SideBar,
    HeaderBar,
  },
};
</script>

<style>
body {
  margin: 0;
  padding: 0;
}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

.page {
  width: 100%;
}

.center {
  display: flex;
  position: relative;
}
</style>




