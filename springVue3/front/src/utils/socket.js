export const createSocket = (roomNumber) => {
    return new WebSocket("ws://" + location.host + `/chat/${roomNumber}`);
}
