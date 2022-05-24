const Room = {
  state() {
    return {
      rooms: [
        {
          number: 1,
          roomName: "Room-1",
          owner: "Rhie",
          participants: ["Rhie", "Steve", "John"],
          total: 5,
        },
        {
          number: 2,
          roomName: "Room-2",
          owner: "Rhie",
          participants: ["Rhie", "Steve", "John"],
          total: 3,
        },
        {
          number: 3,
          roomName: "Room-3",
          owner: "Steve",
          participants: ["Rhie", "Steve", "John"],
          total: 6,
        },
        {
          number: 4,
          roomName: "Room-4",
          owner: "John",
          participants: ["John"],
          total: 2,
        },
      ],
    };
  },
  mutations: {},
  actions: {},
  getters: {},
};

export default Room;
