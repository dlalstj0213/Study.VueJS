<template>
  <div>
    <div class="room-name">{{ getRoomInfo.roomName }}</div>
    <div id="screen" class="screen">
      <CommentBox
        v-for="(chat, idx) in getRecords"
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
      ws: createSocket(this.$route.params.roomNumber, this.$store.getters.getNickname),
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
      this.$store.dispatch("addChat", { nickname: from, comment: msg })
    },
  },
  computed: {
    getRecords(){
      return this.$store.getters.getChatRecords;
    },
    getRoomInfo() {
      return this.$store.getters.getRoomInfo;
    }
  },
  watch: {
    chats(v) {
      console.log(v);
    },
  },
  mounted() {
    const roomNumber = this.$route.params.roomNumber;
    const roomName = this.$store.getters.getRooms.find(item => item.number == this.$route.params.roomNumber).roomName;
    this.$store.dispatch("initRoomInfo", {roomName, roomNumber});
    this.$store.dispatch("fetchChatRecords", roomNumber);

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