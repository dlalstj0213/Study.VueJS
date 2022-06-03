package com.example.demo.temp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Room {
    private int number;
    private String roomName;
    private String owner;
    @Builder.Default
    private Set<String> participants = new HashSet<>();
    private int total;
}
