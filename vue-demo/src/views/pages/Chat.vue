<template>
  <div>
    <div class="room-name">{{ roomName }}</div>
    <ChatScreen />
    <ChatInput />
  </div>
</template>

<script>
import ChatScreen from "../components/ChatScreen.vue";
import ChatInput from "../components/ChatInput.vue";

export default {
  name: "ChatPage",
  components: {
    ChatScreen,
    ChatInput,
  },
  data() {
    return { roomName: "defualt" };
  },
};
</script>


<style scope>
.room-name {
  width: fit-content;
  padding-left: 10px;
  padding-right: 10px;
  margin: 10px auto;
  border: solid 2px;
}
</style>