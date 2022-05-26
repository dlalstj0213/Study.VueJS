const User = {
  state() {
    return {
      nickname: "",
      rooms: [],
    };
  },
  mutations: {
    setNickname(state, nickname) {
      state.nickname = nickname;
    },
    setRooms(state, rooms) {
      state.rooms = rooms;
    },
  },
  actions: {
    addUser({ commit }, value) {
      console.log("addUser:", value);
      commit("setNickname", value);
    },
  },
  getters: {
    getNickname(state) {
      return state.nickname;
    },
    getRooms(state) {
      return state.rooms;
    },
  },
};

export default User;
