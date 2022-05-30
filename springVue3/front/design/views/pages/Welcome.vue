<template>
  <div class="hello">
    <h1>Welcome Vue.js!</h1>
    <p>Create Your Free Nickname :</p>
    <input type="text" name="" id="nickname" />
    <button>Create</button>
    <p id="err-msg">Here is the Error Message field</p>
  </div>
</template>

<script>
export default {
  name: "WelcomePage",
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss" src="styles/pages/Welcome.scss">
</style>
