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
        <button @click="join">Join</button>
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
  },
  methods: {
    join() {
      this.$router.push({
        name: "Chat",
        params: { roomNumber: this.number },
        query: { roomName: this.roomName },
      });
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
