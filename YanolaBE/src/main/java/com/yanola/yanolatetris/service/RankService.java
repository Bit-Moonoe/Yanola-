package com.yanola.yanolatetris.service;

import org.springframework.stereotype.Service;

@Service
public interface RankService {

    public void getRedisStringValue(String key, String value);
}
