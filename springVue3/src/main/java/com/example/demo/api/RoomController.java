package com.example.demo.api;

import com.example.demo.temp.Room;
import com.example.demo.temp.TempRepository;
import com.example.demo.temp.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/room")
public class RoomController {
    private final TempRepository tempRepository;

    @GetMapping("")
    public Map<String, Object> getRooms() {
        Map<String, Object> res = new HashMap<>();

        List<Room> rooms = tempRepository.getRooms();

        res.put("rooms", tempRepository.getRooms());

        return res;
    }

    @PostMapping("")
    public Map<String, Object> postRoom(@RequestBody Map<String, Object> req) {
        Map<String, Object> res = new HashMap<>();

        String roomName = String.valueOf(req.get("roomName"));
        String owner = String.valueOf(req.get("owner"));
        int total = Integer.parseInt(String.valueOf(req.get("total")));
        Room room = Room.builder()
                .roomName(roomName)
                .owner(owner)
                .total(total)
                .participants(new ArrayList<>())
                .build();
        tempRepository.addRoom(room);
        List<User> list = tempRepository.getUsers().stream().filter(item -> item.getNickname().equals(owner)).collect(Collectors.toList());

        list.get(0).getRooms().add(room);

        res.put("room", room);

        return res;
    }
}
