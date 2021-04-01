package org.app.speed.service;

import java.util.Collection;

public interface RedisService<T> {

    /**
     * 存入数据
     *
     * @param key key
     * @param value value
     */
    void set(String key, Object value);

    /**
     * 根据key获取数据
     *
     * @param key key
     * @return return
     */
    Object get(String key);

    /**
     * 存入list数据
     *
     * @param key key
     */
    void setList(String key, Collection<T> list, long delta);

    /**
     * 获取list数据
     *
     * @param key key
     * @return return list
     */
    Collection<T> getList(String key);

    /**
     * 设置数据过期时间
     *
     * @param key key
     * @param expire 过期时间
     */
    void expire(String key, long expire);

    /**
     * 根据key删除数据
     *
     * @param key key
     */
    void remove(String key);

}
