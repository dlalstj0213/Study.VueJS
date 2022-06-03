package com.example.demo.socket;

import lombok.*;

import javax.websocket.Session;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ChatDto {
    @Builder.Default
    private Set<Session> sessions = new CopyOnWriteArraySet();
    @Builder.Default
    private List chatList = Collections.synchronizedList(new ArrayList<MsgObj>());
    @Builder.Default
    private AtomicInteger onlinePersons = new AtomicInteger(0);

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @ToString
    public static class MsgObj {
        private String nickname;
        private String comment;
    }
}
