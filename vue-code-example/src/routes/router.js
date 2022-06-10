import { createRouter, createWebHistory } from "vue-router";

const routes = [
  {
    path: "/",
    name: "Main",
    component: () => import("@/components/page/Main.vue"),
  },
  {
    path: "/test",
    name: "ParentNChild",
    component: () => import("@/components/page/ParentComp.vue"),
  },
];

export const router = createRouter({
  history: createWebHistory(),
  routes,
});
