package com.primavera.delishas.controller

import com.primavera.delishas.dto.RestaurantDto
import com.primavera.delishas.service.restaurant.RestaurantService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate
import java.time.ZoneId

@RestController
@RequestMapping("api/v1/restaurants")
class RestaurantController (
        @Autowired val restaurantService: RestaurantService
){
    // api for getting restaurants by client
    @GetMapping("/")
    fun getRestaurants(): ResponseEntity<List<RestaurantDto>>{
        val localDate = LocalDate.now(ZoneId.of("Asia/Seoul"))
        val restaurants = restaurantService.getRestaurants(localDate)
        return ResponseEntity.ok().body(restaurants)
    }

    // api for refreshing by crawler
    @PostMapping("/")
    fun createRestaurants(): ResponseEntity<Unit>{
        val localDate = LocalDate.now(ZoneId.of("Asia/Seoul"))
        restaurantService.refreshRestaurants(localDate)
        return ResponseEntity.ok().build()
    }
}