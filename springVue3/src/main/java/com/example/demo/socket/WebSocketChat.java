package com.example.demo.socket;

import com.example.demo.temp.Room;
import com.example.demo.temp.TempRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Slf4j
@Service
@ServerEndpoint(value = "/chat/{roomId}/{nickname}")
public class WebSocketChat {
    private static AtomicInteger onlinePersons = new AtomicInteger(0);
    private static Map<String, ChatDto> roomMap = new ConcurrentHashMap<>(8);

    public Map<String, ChatDto> getRoomMap() {
        return roomMap;
    }

    @OnMessage
    public void onMessage(@PathParam("roomId") String room, @PathParam("nickname") String nickname, Session session, String msg) throws IOException {
        System.out.println(">>> Receive message: " + msg);
        ChatDto chatDto = roomMap.get(room);
        Set<Session> sessions = chatDto.getSessions();

        ObjectMapper objectMapper = new ObjectMapper();
        Msg msgObj = objectMapper.readValue(msg, Msg.class);
        chatDto.getChatList().add(new ChatDto.MsgObj(msgObj.getFrom(), msgObj.getMsg()));
        for (Session s : sessions) {
//            System.out.println(">>> send data : " + msg);
            s.getBasicRemote().sendText(msg);
        }

    }

    @OnOpen
    public void onOpen(@PathParam("roomId") String room, @PathParam("nickname") String nickname, Session session) {
        System.out.println(">>> Open Session(" + room + "): " + session.toString());
        ChatDto chatDto = roomMap.get(room);
        if (chatDto == null) {
            chatDto = ChatDto.builder().build();
            chatDto.getSessions().add(session);
            roomMap.put(room, chatDto);
        } else {
            chatDto.getSessions().add(session);
        }
        chatDto.getOnlinePersons().incrementAndGet();

        roomMap.forEach((k, v) -> log.info((String) k, v));
    }

    @OnClose
    public void onClose(@PathParam("roomId") String room, @PathParam("nickname") String nickname, Session session) {
        if (roomMap.containsKey(room)) {
            roomMap.get(room).getSessions().remove(session);
            roomMap.get(room).getOnlinePersons().decrementAndGet();

            TempRepository tempRepository = BeanUtil.getBean(TempRepository.class);
            List<Room> rooms = tempRepository.getRooms().stream().filter(item -> item.getNumber() == Integer.parseInt(room)).collect(Collectors.toList());
            if (rooms.size() == 1) {
                rooms.get(0).getParticipants().remove(nickname);
                System.out.println(rooms.get(0).getParticipants());
            }
        }
        System.out.println(">>> Session close: " + session);
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    static class Msg {
        private String from;
        private String msg;
        private String date;
    }

}
