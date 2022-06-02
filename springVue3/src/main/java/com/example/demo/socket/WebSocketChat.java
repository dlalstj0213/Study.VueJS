package com.example.demo.socket;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Service
@ServerEndpoint(value = "/chat/{roomId}")
public class WebSocketChat {

    private static AtomicInteger onlinePersons = new AtomicInteger(0);
    private static Map<String, Set<Session>> roomMap = new ConcurrentHashMap<>(8);
    private static Map<String, ArrayList<?>> chatList = new ConcurrentHashMap<>(8);



    @OnMessage
    public void onMessage(@PathParam("roomId") String room, Session session, String msg) throws IOException {
        System.out.println(">>> Receive message: " + msg);
        Set<Session> sessions = roomMap.get(room);

        for (Session s : sessions) {
            System.out.println(">>> send data : " + msg);
            s.getBasicRemote().sendText(msg);
        }
    }

    @OnOpen
    public void onOpen(@PathParam("roomId") String room, Session session) {
        System.out.println(">>> Open Session(" + room + "): " + session.toString());
        Set<Session> set = roomMap.get(room);
        if (set == null) {
            set = new CopyOnWriteArraySet();
            set.add(session);
            roomMap.put(room, set);
        } else {
            set.add(session);
        }

        onlinePersons.incrementAndGet();
        roomMap.forEach((k, v) -> log.info((String) k, v));
        log.info(">>> {} ::: {}", session.getId(), onlinePersons);
//        if (!clients.contains(session)) {
//            clients.add(session);
//            System.out.println(">>> Session open: " + session);
//        } else {
//            System.out.println(">>> Session already connected");
//        }
    }

    @OnClose
    public void onClose(@PathParam("roomId") String room, Session session) {
        if (roomMap.containsKey(room)) {
            roomMap.get(room).remove(session);
        }
        System.out.println(">>> Session close: " + session);
//        clients.remove(session);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class RoomObj {
        @Builder.Default
        private Set<Session> sessions = new CopyOnWriteArraySet();
        @Builder.Default
        private static Map<String, ArrayList<?>> chatList = new ConcurrentHashMap<>(8);
        private String msg;
        private AtomicInteger onlinePersons = new AtomicInteger(0);
    };
}
