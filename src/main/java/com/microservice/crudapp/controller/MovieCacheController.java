//package com.microservice.crudapp.controller;
//
//import com.microservice.crudapp.service.MovieCacheService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/admin/v1")
//public class MovieCacheController {
//
//
//    @Autowired
//    MovieCacheService  movieCacheService;
//
//    @GetMapping("/clearCacheByID")
//    public ResponseEntity<String> clearCacheByID(@RequestParam("cacheName") String cacheName, @RequestParam("cacheKey") String cacheKey) {
//       String response =  movieCacheService.clearByID(cacheName, cacheKey);
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//
//    @GetMapping("/clearCacheByName")
//    public ResponseEntity<String> clearCacheByName(@RequestParam("cacheName") String cacheName, @RequestParam(required = false) String cacheKey) {
//        String response =  movieCacheService.clearByID(cacheName, cacheKey);
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//}
