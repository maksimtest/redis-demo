package com.redisdemo.config

import org.springframework.cache.CacheManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.cache.RedisCacheConfiguration
import org.springframework.data.redis.cache.RedisCacheManager
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.RedisSerializationContext
import org.springframework.data.redis.serializer.StringRedisSerializer
import java.time.Duration

@Configuration
class RedisConfig {
//
//    @Bean
//    fun redisTemplate(connectionFactory: RedisConnectionFactory): RedisTemplate<String, Any> {
//        val keySer = StringRedisSerializer()
//        val valueSer = GenericJackson2JsonRedisSerializer()
//
//        return RedisTemplate<String, Any>().apply {
//            setConnectionFactory(connectionFactory)
//            keySerializer = keySer
//            hashKeySerializer = keySer
//            valueSerializer = valueSer
//            hashValueSerializer = valueSer
//            afterPropertiesSet()
//        }
//    }
//
    @Bean
    fun cacheManager(connectionFactory: RedisConnectionFactory): CacheManager {
        val keySer = StringRedisSerializer()
        val valueSer = GenericJackson2JsonRedisSerializer()

        val cacheConfig = RedisCacheConfiguration.defaultCacheConfig()
            .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(keySer))
            .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(valueSer))
            .entryTtl(Duration.ofHours(1))

        return RedisCacheManager.builder(connectionFactory)
            .cacheDefaults(cacheConfig)
            .transactionAware()
            .build()
    }

}
