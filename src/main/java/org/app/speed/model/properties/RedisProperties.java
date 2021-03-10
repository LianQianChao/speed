package org.app.speed.model.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * redis 自定义属性
 */
@ConfigurationProperties(prefix = "redis.key.prefix")
@Component
@Data
public class RedisProperties {

    //key值
    private String key;

    //过期时间
    private Long expire;

}
