package com.example.demo.temp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Room {
    private int number;
    private String roomName;
    private String owner;
    @Builder.Default
    private List<String> participants = new ArrayList<>();
    private int total;
}
