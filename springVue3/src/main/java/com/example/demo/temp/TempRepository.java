package com.example.demo.temp;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TempRepository {
    private List<User> users = new ArrayList<User>();
    private List<Room> rooms = new ArrayList<Room>();
    private int count = 1;

    /**
     * init
     */
    public TempRepository() {
        User user = User.builder().nickname("Admin").rooms(new ArrayList<Room>()).build();
        Room room = Room.builder()
                .owner("Admin")
                .total(3)
                .roomName("채팅방 임시 - 1")
                .participants(new ArrayList<String>())
                .build();
        user.getRooms().add(room);
        room.getParticipants().add(user.getNickname());
        this.users.add(user);
        this.addRoom(room);
    }

    public User addUser(User user) {
        this.users.add(user);
        return user;
    }

    public List<User> getUsers() {
        return this.users;
    }

    public Room addRoom(Room room) {
        room.setNumber(count++);
        this.rooms.add(room);
//        this.rooms.forEach(item -> item.setNumber(count++));
        return room;
    }

    public List<Room> getRooms() {
        return this.rooms;
    }
}
