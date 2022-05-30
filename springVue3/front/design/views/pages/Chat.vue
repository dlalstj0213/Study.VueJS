<template>
  <div>
    <h4 class="room-name">채팅방명!</h4>
    <div id="screen" class="screen">
      <CommentBox />
    </div>
    <ChatInput />
  </div>
</template>

<script>
import ChatInput from "@@/views/components/ChatInput.vue";
import CommentBox from "@@/views/components/CommentBox.vue";

export default {
  name: "ChatPage",
  components: {
    ChatInput,
    CommentBox,
  },
  data() {
    return {
      chats: [],
    };
  },
};
</script>


<style scope lang="scss" src="styles/pages/Chat.scss">
</style>