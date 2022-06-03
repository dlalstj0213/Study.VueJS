const User = {
  state() {
    return {
      nickname: "",
    };
  },
  mutations: {
    setNickname(state, nickname) {
      state.nickname = nickname;
    },
  },
  actions: {
    addUser({ commit }, value) {
      commit("setNickname", value);
    },
  },
  getters: {
    getNickname(state) {
      return state.nickname;
    },
  },
};

export default User;
