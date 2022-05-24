<template>
  <div class="room">
    <div class="top">
      <div class="number">
        <p>{{ number }}</p>
      </div>
      <div class="room-name">
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
      this.$router.push({ name: "Chat", params: { id: this.number } });
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
<style scoped>
.room {
  width: 20rem;
  height: 5rem;
  margin: 20px auto;
  border: solid 1px;
}

.room > .top {
  height: 60%;
  display: flex;
}

.room > .top > .number {
  width: 40px;
  position: relative;
}

.room > .top > .number > p {
  top: 0px;
  width: 20px;
  height: 20px;
  margin: 5px 0 0 5px;
  border: solid 1px;
  border-radius: 50%;
  display: block;
  position: absolute;
}

.room > .top > .room-name {
  width: 100%;
}

.room > .top > .room-name > p {
  margin: 13px 0 0 5px;
  text-align: left;
}

.room > .bottom {
  height: 40%;
  display: flex;
}

.room > .bottom > .owner {
  width: 100%;
}

.room > .bottom > .owner > p {
  margin: 5px 0 0 5px;
  text-align: left;
}

.room > .bottom > .count {
  width: fit-content;
}

.room > .bottom > .count > p {
  margin: 5px 5px 0 5px;
  text-align: right;
}
</style>
