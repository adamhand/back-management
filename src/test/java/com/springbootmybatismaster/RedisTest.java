package com.springbootmybatismaster;

import com.redis.RedisCacheConfiguration;
import com.redis.RedisOperation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    RedisOperation redisOperation;
    @Autowired
    RedisCacheConfiguration configuration;

    @Test
    public void test(){
//        redisOperation.set("gender", "male");
        redisOperation.set("mount", "90");
        redisOperation.decrease("mount");
    }
}
