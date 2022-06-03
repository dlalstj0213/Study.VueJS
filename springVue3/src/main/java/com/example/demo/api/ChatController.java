package com.example.demo.api;

import com.example.demo.socket.BeanUtil;
import com.example.demo.socket.ChatDto;
import com.example.demo.socket.ChatDto.MsgObj;
import com.example.demo.socket.WebSocketChat;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/chat")
@RequiredArgsConstructor
public class ChatController {
    private final WebSocketChat webSocketChat;


    @GetMapping("")
    public List<MsgObj> getChatList(@RequestParam String roomNumber) {
        ChatDto chatDto = webSocketChat.getRoomMap().get(roomNumber);
        if(chatDto == null) {
            return new ArrayList<>();
        } else {
            return chatDto.getChatList();
        }
    }
}
