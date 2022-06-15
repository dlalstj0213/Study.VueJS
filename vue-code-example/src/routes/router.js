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
];

export const router = createRouter({
  history: createWebHistory(),
  routes,
});
