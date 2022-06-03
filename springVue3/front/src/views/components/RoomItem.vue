<template>
  <div class="room">
    <div class="top">
      <div class="number">
        <p>{{ number }}</p>
      </div>
      <div class="name">
        <p>{{ roomName }}</p>
      </div>
      <div>
        <button @click="clickHandler" v-bind:disabled="this.participants.length >= this.total">Join</button>
      </div>
    </div>
    <div class="bottom">
      <div class="owner">
        <p>owner: {{ owner }}</p>
      </div>
      <div class="count">
        <p>{{ count + "/" + total }}</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "RoomItem",
  props: {
    number: Number,
    roomName: String,
    owner: String,
    participants: Array,
    total: {
      default: 0,
      type: Number,
    },
    click: {
      type: Function,
      default(){
        return;
      }
    }
  },
  methods: {
    clickHandler() {
      this.click({roomNumber: this.number, roomName: this.roomName});
    },
  },
  computed: {
    count() {
      return this.participants.length;
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss" src="styles/components/RoomItem.scss">
</style>
