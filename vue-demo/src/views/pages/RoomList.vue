<template>
  <div class="room-box">
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

export default {
  name: "RoomList",
  components: {
    RoomItem,
  },
  data() {
    return {
      rooms: [
        {
          number: 1,
          roomName: "Room-1",
          owner: "Rhie",
          participants: ["Rhie", "Steve", "John"],
          total: 5,
        },
        {
          number: 2,
          roomName: "Room-2",
          owner: "Rhie",
          participants: ["Rhie", "Steve", "John"],
          total: 3,
        },
        {
          number: 3,
          roomName: "Room-3",
          owner: "Steve",
          participants: ["Rhie", "Steve", "John"],
          total: 6,
        },
        {
          number: 4,
          roomName: "Room-4",
          owner: "John",
          participants: ["John"],
          total: 2,
        },
      ],
    };
  },
};
</script>

<style scoped>
</style>
