<template>
  <div v-if="nickname === from" class="me">
    <p>ME</p>
    <p>{{ comment }}</p>
  </div>
  <div v-else class="other">
    <p>{{ nickname }}</p>
    <p>{{ comment }}</p>
  </div>
</template>

<script>
export default {
  name: "CommentBox",
  props: {
    from: String,
    nickname: String,
    comment: String,
  },
};
</script>

<style scoped>
p {
  margin: 0;
  word-break: break-all;
}

div {
  margin-bottom: 10px;
}

.me {
  display: flex;
  flex-direction: column;
  align-items: flex-end;
}

.me > p:nth-child(1) {
  text-align: left;
  margin-right: 10px;
}

.other > p:nth-child(1) {
  text-align: left;
  margin-left: 10px;
}

div > p:nth-child(2) {
  text-align: left;
  width: fit-content;
  max-width: 80%;
  border: solid 1px;
  border-radius: 5px;
}

.me > p:nth-child(2) {
  margin-right: 10px;
  padding-left: 5px;
  padding-right: 5px;
}

.other > p:nth-child(2) {
  margin-left: 10px;
  padding-left: 5px;
  padding-right: 5px;
}
</style>