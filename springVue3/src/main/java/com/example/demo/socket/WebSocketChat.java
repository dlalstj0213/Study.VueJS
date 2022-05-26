package com.example.demo.socket;

import org.springframework.stereotype.Service;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
@ServerEndpoint(value = "/chat/:id")
public class WebSocketChat {
    private static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());

    @OnMessage
    public void onMessage(String msg, Session session) throws IOException {
        System.out.println(">>> Receive message: " + msg);
        for(Session s : clients) {
            System.out.println(">>> send data : " + msg);
            s.getBasicRemote().sendText(msg);
        }
    }

    @OnOpen
    public void onOpen(Session session) {
        System.out.println(">>> Open Session: " + session.toString());

        if (!clients.contains(session)) {
            clients.add(session);
            System.out.println(">>> Session open: " + session);
        } else {
            System.out.println(">>> Session already connected");
        }
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println(">>> Session close: " + session);
        clients.remove(session);
    }
}
