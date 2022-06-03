import { createStore } from "vuex";
import User from "@/store/user.js";
import Room from "@/store/room.js";
import Chat from "@/store/chat.js";

export default createStore({
  modules: {
    users: User,
    rooms: Room,
    chat: Chat,
  },
});
