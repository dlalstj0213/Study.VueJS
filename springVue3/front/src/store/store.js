import { createStore } from "vuex";
import User from "@/store/user.js";
import Room from "./room.js";

export default createStore({
  modules: {
    users: User,
    rooms: Room,
  },
});
