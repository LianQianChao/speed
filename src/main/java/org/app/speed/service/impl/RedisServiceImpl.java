package org.app.speed.service.impl;

import org.app.speed.service.RedisService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl implements RedisService {

    @Resource
    private RedisTemplate redisTemplate;


    @Override
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key,value);
    }


    @Override
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }



    @Override
    public void setList(String key,List list,long delta) {
        redisTemplate.opsForList().rightPushAll(key,list);
        expire(key,delta);
    }

    @Override
    public List getList(String key) {
        return redisTemplate.opsForList().range(key,0,-1);
    }


    @Override
    public boolean expire(String key, long expire) {
        return redisTemplate.expire(key, expire,TimeUnit.SECONDS);
    }


    @Override
    public void remove(String key) {
        redisTemplate.delete(key);
    }


    @Override
    public long increment(String key, long delta) {
        return redisTemplate.opsForValue().increment(key, delta);
    }
}
