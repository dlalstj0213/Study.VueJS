<template>
  <slot-comp-1>
    <strong>Basic</strong>
    Slots! :: {{ text }}
  </slot-comp-1>

  <slot-comp-2></slot-comp-2>
  <slot-comp-2>New Contents</slot-comp-2>

  <slot-comp-3>
    <template v-slot:header>
      <h1>This is the Header</h1>
    </template>
    <template #default>
      <h1>This is the Main</h1>
    </template>
    <template #footer>
      <h1>This is the Footer</h1>
    </template>
  </slot-comp-3>

  <slot-comp-4 :list="strlist" v-slot:default="slotProps">
    <U>{{ slotProps.prop }}</U>
  </slot-comp-4>

  <slot-comp-4 :list="numlist" v-slot:default="{ prop = 3 }">
    <U>{{ prop }}</U>
  </slot-comp-4>

  <slot-comp-4 :list="strlist" v-slot="{ prop: prop1, index }">
    {{ prop1 }} | {{ index }} |
  </slot-comp-4>

  <slot-comp-4 :list="strlist" v-slot="props">
    {{ props.prop }} | {{ props.index }} |
  </slot-comp-4>
</template>

<script>
import SlotComp1 from "./SlotComp1.vue";
import SlotComp2 from "./SlotComp2.vue";
import SlotComp3 from "./SlotComp3.vue";
import SlotComp4 from "./SlotComp4.vue";

export default {
  name: "parent-comp",
  components: {
    SlotComp1,
    SlotComp2,
    SlotComp3,
    SlotComp4,
  },
  props: {},
  data() {
    return {
      text: "TEXT HERE!",
      strlist: ["A", "B", "C", "D", "E"],
      numlist: [1, 2, undefined, 4, 5],
    };
  },
  methods: {},
  computed: {},
  watch: {},
  mounted() {},
  updated() {},
};
</script>

<style lang='' src='' scoped>
</style>