package org.app.speed.service.impl;

import org.app.speed.service.RedisService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl implements RedisService<Object> {

    @Resource
    public RedisTemplate<String, Object> redisTemplate;


    @Override
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }


    @Override
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }


    @Override
    public void setList(String key, Collection<Object> data, long delta) {
        redisTemplate.opsForList().rightPushAll(key, data);
        expire(key, delta);
    }

    @Override
    public Collection<Object> getList(String key) {
        return redisTemplate.opsForList().range(key, 0, -1);
    }


    @Override
    public void expire(String key, long expire) {
        redisTemplate.expire(key, expire, TimeUnit.SECONDS);
    }


    @Override
    public void remove(String key) {
        redisTemplate.delete(key);
    }


}
