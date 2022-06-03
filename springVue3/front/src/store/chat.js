import { get } from "@/utils/httpClient";

const Chat = {
    state() {
        return {
            chat: {
                roomNumber: "",
                roomName: "",
                records: []
            },
        };
    },
    mutations: {
        setRecords(state, records) {
            state.chat.records = records;
        },
        setRoomInfo(state, {roomName, roomNumber}) {
            state.chat.roomName = roomName;
            state.chat.roomNumber = roomNumber;
        },
        pushRecords(state, value) {
            state.chat.records.push(value);
        }
    },
    actions: {
        async fetchChatRecords({commit}, roomNumber) {
            commit("setRecords", []);
            const data = await get(`/chat?roomNumber=${roomNumber}`);
            if (data.length > 0) {
                commit("setRecords", data);
            }
        },
        initRoomInfo({commit}, {roomName, roomNumber}) {
            commit("setRoomInfo", {roomName, roomNumber});
        },
        addChat({commit}, data) {
            const {nickname, comment} = data;
            commit("pushRecords", {nickname, comment});
        },
    },
    getters: {
        getChatRecords(state){
            return state.chat.records;
        },
        getRoomName(state) {
            return state.chat.roomName;
        },
        getRoomNumber(state){
            return state.chat.roomNumber;
        },
        getRoomInfo(state) {
            return {
                roomName: state.chat.roomName,
                roomNumber: state.chat.roomNumber
            }
        }
    },
};

export default Chat;
