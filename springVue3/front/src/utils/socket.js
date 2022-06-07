import { post } from "@/utils/httpClient";

export const createSocket = (roomNumber, nickname) => {
    const socketUrl = process.env.VUE_APP_API_BASE_URL.substring(7);
    post("/room/participant", {roomNumber, participant: nickname}).catch(console.error);
    return new WebSocket("ws://" + socketUrl + `/chat/${roomNumber}/${nickname}`);
}
