<template>
  <div>
    <div class="room-name">{{ roomName }}</div>
    <div id="screen" class="screen">
      <CommentBox
        v-for="(chat, idx) in chats"
        :key="idx"
        :from="this.$store.getters.getNickname"
        :comment="chat.comment"
        :nickname="chat.nickname"
      />
    </div>
    <ChatInput :btnName="'Send'" @send="send" />
  </div>
</template>

<script>
import ChatInput from "@/views/components/ChatInput.vue";
import CommentBox from "@/views/components/CommentBox.vue";
import { createSocket } from "@/utils/socket";

export default {
  name: "ChatPage",
  components: {
    ChatInput,
    CommentBox,
  },
  data() {
    return {
      roomName: this.$route.query.roomName,
      chats: [],
      ws: createSocket(this.$route.params.roomNumber),
    };
  },
  methods: {
    send(value) {
      this.sendComment(value);
    },
    scrollToBottom() {
      let elmnt = document.getElementById("screen");
      elmnt.scrollTop = elmnt.scrollHeight;
    },
    sendComment(value) {
      let data = {
        from: this.$store.getters.getNickname,
        msg: value,
        date: new Date().toLocaleString(),
      };
      const temp = JSON.stringify(data);
      this.ws.send(temp);
    },
    addCommentBox({ from, msg, date }) {
      console.log(date);
      return this.chats.push({ nickname: from, comment: msg });
    },
  },
  watch: {
    chats(v) {
      console.log(v);
    },
  },
  mounted() {
    this.ws.onmessage = (msg) => {
      let data = JSON.parse(msg.data);
      this.addCommentBox(data);
    };
    this.scrollToBottom();
  },
  updated() {
    this.scrollToBottom();
  },
};
</script>


<style scope lang="scss" src="styles/pages/Chat.scss">
</style>