//package com.microservice.crudapp.service;
//
//import com.microservice.crudapp.configuration.ResourceNotFoundException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.stereotype.Service;
//
//@Service
//public class MovieCacheService {
//
//    @Autowired
//    RedisCacheManager cacheManager;
//
//    public String clearByID(String cacheName, String cacheKey) {
//        StringBuilder stringBuilder = new StringBuilder();
//        try {
//            cacheManager.getCache(cacheName).evict(cacheKey);
//              stringBuilder.append("successfully deleted using ").append(cacheName).append(" and ").append(cacheKey);
//
//            return stringBuilder.toString();
//        } catch (Exception e) {
//            new ResourceNotFoundException(e.getMessage());
//        }
//        return cacheName;
//    }
//
//
//    public String clearAllMovies(String cacheName) {
//
//        StringBuilder stringBuilder = new StringBuilder();
//        try {
//            cacheManager.getCache(cacheName).clear();
//            stringBuilder.append("successfully deleted using ").append(cacheName);
//
//            return stringBuilder.toString();
//        } catch (Exception e) {
//            new ResourceNotFoundException(e.getMessage());
//        }
//        return cacheName;
//
//    }
//
//
//}
