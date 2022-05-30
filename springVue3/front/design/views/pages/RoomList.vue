<template>
  <div class="room-box">
    <div>
      <h4 for="">New Room</h4>
      <div>
        <label for="">Room Name:</label>
        <input type="text" />
        <input type="text" />
      </div>
      <div>
        <label for="">Owner:</label>
        <input type="text" disabled />
      </div>

      <button>Create</button>
    </div>
    <h4 for="">Room List</h4>
    <RoomItem />
  </div>
</template>

<script>
import RoomItem from "@@/views/components/RoomItem.vue";

export default {
  name: "RoomList",
  components: {
    RoomItem,
  },
  data() {
    return {
      nickname: "",
      roomName: "",
      total: 1,
      rooms: [],
    };
  },
};
</script>

<style scoped>
</style>
