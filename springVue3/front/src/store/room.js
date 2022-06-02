import { get, post } from "@/utils/httpClient";

const Room = {
  state() {
    return {
      rooms: [],
    };
  },
  mutations: {
    setRooms(state, rooms) {
      state.rooms = rooms;
    },
    addRoom(state, room) {
      state.rooms.push(room);
    }
  },
  actions: {
    async fetchRooms({commit}) {
      const {rooms} = await get("/room");
      commit("setRooms", rooms);
    },
    async createRoom(context, {roomName, owner, total}) {
      const { room } = await post("/room", {roomName, owner, total});
      context.commit("addRoom", room);
    }
  },
  getters: {
    getRooms(state) {
      return state.rooms;
    }
  },
};

export default Room;
