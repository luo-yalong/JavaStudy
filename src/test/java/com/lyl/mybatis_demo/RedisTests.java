package com.lyl.mybatis_demo;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class RedisTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void testPutList(){
        List<Integer> list = Arrays.asList(4, 5, 6);

        redisTemplate.opsForList().leftPush("list", list);
    }

    @Test
    void testGetList(){
        Object list = redisTemplate.opsForList().leftPop("list");
        System.out.println("list = " + list);
    }


}
