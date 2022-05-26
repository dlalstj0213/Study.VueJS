<template>
  <div class="room-box">
    <div>
      <h4 for="">New Room</h4>
      <div>
        <label for="">Room Name:</label>
        <input type="text" v-model="roomName" />
        <input type="text" v-model="total" />
      </div>
      <div>
        <label for="">Owner:</label>
        <input type="text" v-model="nickname" disabled />
      </div>

      <button @click="createRoom">Create</button>
    </div>
    <h4 for="">Room List</h4>
    <RoomItem
      v-for="room in rooms"
      :number="room.number"
      :roomName="room.roomName"
      :owner="room.owner"
      :participants="room.participants"
      :total="room.total"
      :key="room.number"
    />
  </div>
</template>

<script>
import RoomItem from "../components/RoomItem.vue";
import { get, post } from "../../utils/httpClient";

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
  async mounted() {
    this.nickname = this.$store.getters.getNickname;
    const { rooms } = await get("/room");
    this.rooms = rooms;
  },
  methods: {
    async createRoom() {
      if (this.roomName.trim() === "" || this.total < 1) return;
      const data = {
        roomName: this.roomName,
        owner: this.nickname,
        total: this.total,
      };
      const { room } = await post("/room", data);
      this.rooms.push(room);
      this.roomName = "";
      this.total = 1;
    },
  },
};
</script>

<style scoped>
</style>
