package org.app.speed.service;

import java.util.List;

public interface RedisService {

    /**
     * 存入数据
     *
     * @param key
     * @param value
     */
    void set(String key, Object value);

    /**
     * 根据key获取数据
     *
     * @param key
     * @return
     */
    Object get(String key);

    /**
     * 存入list数据
     *
     * @param key
     */
    void setList(String key, List list, long delta);

    /**
     * 获取list数据
     *
     * @param key
     * @return
     */
    List getList(String key);

    /**
     * 设置数据过期时间
     *
     * @param key
     * @param expire
     * @return
     */
    boolean expire(String key, long expire);

    /**
     * 根据key删除数据
     *
     * @param key
     */
    void remove(String key);

    /**
     * 设置key自增长
     *
     * @param key
     * @param delta
     * @return
     */
    long increment(String key, long delta);
}
