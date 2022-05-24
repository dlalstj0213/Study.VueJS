import { createWebHistory, createRouter } from "vue-router";

const routes = [
  {
    path: "/",
    redirect: "/welcome",
  },
  {
    path: "/welcome",
    name: "Welcome",
    component: () => import("@/pages/Welcome.vue"),
  },
  {
    path: "/room",
    name: "RoomList",
    component: () => import("@/pages/RoomList.vue"),
  },
  {
    path: "/room/chat/:id",
    name: "Chat",
    component: () => import("@/pages/Chat.vue"),
  },
];

const router = createRouter({
  history: createWebHistory(), // HTML5 모드
  //   history: createWebHashHistory(),  // Hash 모드
  routes,
});

export default router;
