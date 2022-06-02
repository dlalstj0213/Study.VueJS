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
        <input type="text" v-model="currentUser" disabled />
      </div>

      <button @click="createRoom">Create</button>
    </div>
    <h4 for="">Room List</h4>
    <RoomItem
      v-for="room in this.$store.getters.getRooms"
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
import RoomItem from "@/views/components/RoomItem.vue";

export default {
  name: "RoomList",
  components: {
    RoomItem,
  },
  data() {
    return {
      roomName: "",
      total: 1,
    };
  },
  async mounted() {
    await this.$store.dispatch("fetchRooms");
  },
  methods: {
    async createRoom() {
      if (this.roomName.trim() === "" || this.total < 1) return;
      const data = {
        roomName: this.roomName,
        owner: this.currentUser,
        total: this.total,
      };
      await this.$store.dispatch("createRoom", data);
      this.roomName = "";
      this.total = 1;
    },
  },
  computed: {
    rooms() {
      return this.$store.getters.getRooms;
    },
    currentUser() {
      return this.$store.getters.getNickname;
    },
  }
};
</script>

<style scoped>
</style>
