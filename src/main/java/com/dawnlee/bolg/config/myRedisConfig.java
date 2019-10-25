package com.dawnlee.bolg.config;

import com.dawnlee.bolg.model.User;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

@Configuration
public class myRedisConfig {
    @Bean
    public RedisTemplate<Object, User> userRedisTemplate(RedisConnectionFactory redisConnectionFactory){


        RedisTemplate<Object, User> UserRedisTemplate = new RedisTemplate<>();
        UserRedisTemplate.setConnectionFactory(redisConnectionFactory);

        Jackson2JsonRedisSerializer<User> userJackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(User.class);

        UserRedisTemplate.setDefaultSerializer(userJackson2JsonRedisSerializer);
        return UserRedisTemplate;


    }
    @Bean
    public RedisTemplate<Object, Object> objectRedisTemplate(RedisConnectionFactory redisConnectionFactory){


        RedisTemplate<Object, Object> UserRedisTemplate = new RedisTemplate<>();
        UserRedisTemplate.setConnectionFactory(redisConnectionFactory);

        Jackson2JsonRedisSerializer<Object> userJackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);

        UserRedisTemplate.setDefaultSerializer(userJackson2JsonRedisSerializer);
        return UserRedisTemplate;


    }



    @Primary
    @Bean
    public CacheManager MycacheManager(RedisConnectionFactory connectionFactory){
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(connectionFactory);
        Jackson2JsonRedisSerializer<Object> objectJackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
        RedisSerializationContext.SerializationPair<Object> objectSerializationPair = RedisSerializationContext.SerializationPair.fromSerializer(objectJackson2JsonRedisSerializer);
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig().serializeValuesWith(objectSerializationPair);
        return new RedisCacheManager(redisCacheWriter,redisCacheConfiguration);

    }

    @Bean
    public CacheManager MyUsercacheManager(RedisConnectionFactory connectionFactory){
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(connectionFactory);
        Jackson2JsonRedisSerializer<User> objectJackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<User>(User.class);
        RedisSerializationContext.SerializationPair<User> objectSerializationPair = RedisSerializationContext.SerializationPair.fromSerializer(objectJackson2JsonRedisSerializer);
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig().serializeValuesWith(objectSerializationPair);
        return new RedisCacheManager(redisCacheWriter,redisCacheConfiguration);

    }

}
