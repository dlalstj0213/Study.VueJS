<template>
  <div>
    <div class="room-name">{{ roomName }}</div>
    <div id="screen" class="screen">
      <CommentBox
        v-for="(chat, idx) in chats"
        :key="idx"
        :from="from"
        :comment="chat.comment"
        :nickname="chat.nickname"
      />
    </div>
    <ChatInput :btnName="'Send'" @send="send" />
  </div>
</template>

<script>
import ChatInput from "../components/ChatInput.vue";
import CommentBox from "../components/CommentBox.vue";

export default {
  name: "ChatPage",
  components: {
    ChatInput,
    CommentBox,
  },
  data() {
    return {
      roomName: "defualt",
      from: "Rhie",
      chats: [
        { nickname: "Rhie", comment: "Hello!" },
        {
          nickname: "Steve",
          comment:
            "Hello!Hello!Hello!Hello!Hello!Hello!Hello!Hello!Hello!Hello!Hello!Hello!Hello!Hello!",
        },
        {
          nickname: "John",
          comment:
            "Hello!Hello!Hello!Hello!Hello!Hello!Hello!Hello!Hello!Hello!Hello!Hello!Hello!Hello!",
        },
        { nickname: "Rhie", comment: "Hello!" },
        {
          nickname: "Steve",
          comment:
            "Hello!Hello!Hello!Hello!Hello!Hello!Hello!Hello!Hello!Hello!Hello!Hello!Hello!Hello!",
        },
        {
          nickname: "John",
          comment:
            "Hello!Hello!Hello!Hello!Hello!Hello!Hello!Hello!Hello!Hello!Hello!Hello!Hello!Hello!",
        },
        { nickname: "Rhie", comment: "Hello!" },
        {
          nickname: "Steve",
          comment:
            "Hello!Hello!Hello!Hello!Hello!Hello!Hello!Hello!Hello!Hello!Hello!Hello!Hello!Hello!",
        },
        {
          nickname: "John",
          comment:
            "Hello!Hello!Hello!Hello!Hello!Hello!Hello!Hello!Hello!Hello!Hello!Hello!Hello!Hello!",
        },
      ],
    };
  },
  methods: {
    send(value) {
      this.chats.push({ nickname: this.from, comment: value });
    },
    scrollToBottom() {
      let elmnt = document.getElementById("screen");
      elmnt.scrollTop = elmnt.scrollHeight;
    },
  },
  watch: {
    chats(v) {
      console.log(v);
    },
  },
  mounted() {
    this.scrollToBottom();
  },
  updated() {
    this.scrollToBottom();
  },
};
</script>


<style scope>
.chat-room-name {
  width: fit-content;
  padding-left: 10px;
  padding-right: 10px;
  margin: 10px auto;
  border: solid 2px;
}

.screen {
  width: 500px;
  height: 500px;
  margin: auto auto;
  padding-top: 10px;
  border: solid 1px;
  border-radius: 5%;
  overflow-y: scroll;
}
</style>