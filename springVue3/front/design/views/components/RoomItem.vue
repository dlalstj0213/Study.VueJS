<template>
  <div class="room">
    <div class="top">
      <div class="number">
        <p>1</p>
      </div>
      <div class="name">
        <p>채팅방명</p>
      </div>
      <div>
        <button v-bind:disabled="isDisabled">참가</button>
      </div>
    </div>
    <div class="bottom">
      <div class="owner">
        <p>owner: Admin</p>
      </div>
      <div class="count">
        <p>1/3</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "RoomItem",
  data(){
    return {
      isDisabled : false
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss" src="styles/components/RoomItem.scss">
</style>
