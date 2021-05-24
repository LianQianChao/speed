package org.app.speed.service;


import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;
@Service
public class RedisService<T> {

    @Resource
    public RedisTemplate<String, T> redisTemplate;

    /**
     * 存入数据
     *
     * @param key key
     * @param value value
     */
    public void set(String key, T value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 根据key获取数据
     *
     * @param key key
     * @return return
     */
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 存入list数据
     *
     * @param key key
     */
    public void setList(String key, List<T> data, long delta) {
        redisTemplate.opsForList().rightPushAll(key, data);
        expire(key, delta);
    }

    /**
     * 获取list数据
     *
     * @param key key
     * @return return list
     */
    public List<T> getList(String key) {
        return redisTemplate.opsForList().range(key, 0, -1);
    }


    /**
     * 设置数据过期时间
     *
     * @param key key
     * @param expire 过期时间
     */
    public void expire(String key, long expire) {
        redisTemplate.expire(key, expire, TimeUnit.SECONDS);
    }


    /**
     * 根据key删除数据
     *
     * @param key key
     */
    public void remove(String key) {
        redisTemplate.delete(key);
    }

}
