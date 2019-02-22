package com.redis;

import com.commons.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


@Component
public class RedisOperation {

//    @Autowired
//    private JedisPool jedisPool;
//
//    public void set(String key, String value){
//        try (Jedis jedis = jedisPool.getResource()){
//            jedis.set(key, value);
//        }
//    }
//
//    public Long decrease(String key){
//        try (Jedis jedis = jedisPool.getResource()) {
//            return jedis.decr(key);
//        }
//    }

    public void set(String key, String value){
        Jedis jedis = RedisUtil.getJedis();
        if(jedis != null){
            jedis.set(key, value);
        }
    }

    /**
     * 根据商品ID得到商品数量
     * @param id
     * @return
     */
    public Long get(String id){
        Jedis jedis = RedisUtil.getJedis();
        if(jedis != null){
            String amount = jedis.get(id);
            if(amount == null){
                return null;
            }
            return Long.parseLong(amount);
        }else {
            return null;
        }
    }

    public Long decrease(String key){
        Jedis jedis = RedisUtil.getJedis();
        if(jedis != null){
            return jedis.decr(key);
        }else {
            return null;
        }
    }

}
