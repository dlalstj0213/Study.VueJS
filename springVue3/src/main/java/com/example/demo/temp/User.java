package com.example.demo.temp;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String nickname;
    @Builder.Default
    private List<Room> rooms = new ArrayList<>();
}
