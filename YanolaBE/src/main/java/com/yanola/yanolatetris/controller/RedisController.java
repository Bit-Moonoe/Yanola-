package com.yanola.yanolatetris.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yanola.yanolatetris.service.RankService;

// @RequestMapping(value = "/rank")
@RestController
public class RedisController {
    @Autowired
    private RankService rankService;

    @PostMapping(value = "/setRedisStringValue")
    public void setRedisStringValue(String key, String value) {
        rankService.getRedisStringValue(key, value);
    }

    @GetMapping("/getSessionId")
    public String getSessionId(HttpSession session) {
        return session.getId();
    }

}
