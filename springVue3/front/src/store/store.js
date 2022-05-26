import { createStore } from "vuex";
import User from "./user.js";
// import Room from "./room.js";

export default createStore({
  modules: {
    users: User,
    // rooms: Room,
  },
});
