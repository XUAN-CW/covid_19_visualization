package edu.guet.covid_19_visualization.msm;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

@SpringBootTest
class MsmApplicationTests {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Test
    void contextLoads() {
        redisTemplate.opsForValue().set("phone","code",5, TimeUnit.MINUTES);
    }

}
