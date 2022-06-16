import { createRouter, createWebHistory } from "vue-router";

const routes = [
  {
    path: "/",
    name: "Main",
    component: () => import("@/components/page/Main.vue"),
  },
  {
    path: "/props",
    name: "Props",
    component: () => import("@/components/page/PropsComp.vue"),
  },
  {
    path: "/non-prop",
    name: "NonProp",
    component: () => import("@/components/page/NonPropComp.vue"),
  },
  {
    path: "/emits",
    name: "Emits",
    component: () => import("@/components/page/EmitsComp.vue"),
  },
  {
    path: "/slots",
    name: "Slots",
    component: () => import("@/components/page/SlotsComp.vue"),
  },
];

export const router = createRouter({
  history: createWebHistory(),
  routes,
});
