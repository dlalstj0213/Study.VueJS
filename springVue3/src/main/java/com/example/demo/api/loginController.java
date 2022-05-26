package com.example.demo.api;

import com.example.demo.temp.TempRepository;
import com.example.demo.temp.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/login")
@RequiredArgsConstructor
public class loginController {
    private final TempRepository tempRepository;

    @PostMapping("/find")
    public Map<String, Object> joinUser(@RequestBody Map<String, Object> req) {
        Map<String, Object> res = new HashMap<>();

        String nickname = String.valueOf(req.get("nickname"));
        List list = tempRepository.getUsers().stream().filter(user -> user.getNickname().equals(nickname)).collect(Collectors.toList());

        if(list.size() == 0)
            res.put("user", tempRepository.addUser(User.builder().nickname(nickname).rooms(new ArrayList<>()).build()));
        else if(list.size() == 1)
            res.put("user", list.get(0));
        else {
            res.put("result", "fail");
            return res;
        }

        System.out.println(">>> CHECK : " + tempRepository.getUsers());

        res.put("result", "success");
        return res;
    }
}
