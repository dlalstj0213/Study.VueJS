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

<style scoped lang="scss" src="styles/components/CommentBox.scss">
</style>