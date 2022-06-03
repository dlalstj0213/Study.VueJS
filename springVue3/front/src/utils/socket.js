import { post } from "@/utils/httpClient";

export const createSocket = (roomNumber, nickname) => {
    post("/room/participant", {roomNumber, participant: nickname}).catch(console.error);
    return new WebSocket("ws://" + process.env.VUE_APP_API_BASE_URL + `/chat/${roomNumber}/${nickname}`);
}
