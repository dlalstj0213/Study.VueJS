<template>
  <div class="chat">
    <div class="screen" v-for="(chat, index) in chats" :key="index">
      <div v-if="chat.nickname === from" class="me">
        <p>ME</p>
        <p>{{ chat.comments }}</p>
      </div>
      <div v-else class="other">
        <p>{{ chat.nickname }}</p>
        <p>{{ chat.comments }}</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "ChatScreen",
  data() {
    return {
      from: "John",
      chats: [
        { nickname: "Rhie", comments: "Hello!" },
        {
          nickname: "Steve",
          comments:
            "Hello!Hello!Hello!Hello!Hello!Hello!Hello!Hello!Hello!Hello!Hello!Hello!Hello!Hello!",
        },
        {
          nickname: "John",
          comments:
            "Hello!Hello!Hello!Hello!Hello!Hello!Hello!Hello!Hello!Hello!Hello!Hello!Hello!Hello!",
        },
      ],
    };
  },
};
</script>

<style scoped>
p {
  margin: 0;
  word-break: break-all;
}
.chat {
  width: 500px;
  height: 500px;
  margin: auto auto;
  padding-top: 10px;
  border: solid 1px;
  border-radius: 5%;
}

.chat > .screen {
  /* max-width: 80%; */
  margin-bottom: 10px;
}

.chat > .screen > .me {
  display: flex;
  flex-direction: column;
  align-items: flex-end;
}

.chat > .screen p:nth-child(2) {
  text-align: left;
  width: fit-content;
  max-width: 80%;
  border: solid 1px;
  border-radius: 5px;
}

.chat > .screen > .me > p:nth-child(1) {
  text-align: left;
  margin-right: 10px;
}

.chat > .screen > .other > p:nth-child(1) {
  text-align: left;
  margin-left: 10px;
}

.chat > .screen > .me > p:nth-child(2) {
  margin-right: 10px;
  padding-left: 5px;
  padding-right: 5px;
}

.chat > .screen > .other > p:nth-child(2) {
  margin-left: 10px;
  padding-left: 5px;
  padding-right: 5px;
}
</style>