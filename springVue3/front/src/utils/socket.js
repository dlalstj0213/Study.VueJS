import { post } from "@/utils/httpClient";

export const createSocket = (roomNumber, nickname) => {
    post("/room/participant", {roomNumber, participant: nickname}).catch(console.error);
    return new WebSocket("ws://" + location.host + `/chat/${roomNumber}/${nickname}`);
}
