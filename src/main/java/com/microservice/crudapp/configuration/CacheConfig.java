//package com.microservice.crudapp.configuration;
//
//import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.cache.RedisCacheConfiguration;
//import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.RedisSerializationContext;
//
//import java.time.Duration;
//
//@Configuration
//public class CacheConfig {
//
////    @Bean
////    public org.springframework.data.redis.core.RedisTemplate<String, String> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
////        org.springframework.data.redis.core.RedisTemplate<String, String> redisTemplate = new org.springframework.data.redis.core.RedisTemplate<>();
////        redisTemplate.setConnectionFactory(redisConnectionFactory);
////        return redisTemplate;
////    }
//
//
//
//    @Bean
//    public RedisCacheConfiguration redisCacheConfiguration() {
//        return RedisCacheConfiguration.defaultCacheConfig()
//                .entryTtl(Duration.ofMinutes(60))
//                .disableCachingNullValues()
//                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
//    }
//
//    @Bean
//    public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {
//        return (builder) -> builder
//                .withCacheConfiguration("moviedetailscache",
//                        RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(30)));
//    }
//
//
//
//
//
//
//
//}
