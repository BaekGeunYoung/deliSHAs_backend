package com.primavera.delishas.controller

import com.primavera.delishas.dto.RestaurantDto
import com.primavera.delishas.service.restaurant.RestaurantService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/restaurants")
class RestaurantController (
        @Autowired val restaurantService: RestaurantService
){
    // api for getting restaurants by client
    @GetMapping("/")
    fun getRestaurants(): ResponseEntity<MutableList<RestaurantDto>>{
        val restaurants = restaurantService.getRestaurants()
        return ResponseEntity.ok().body(restaurants)
    }

    // api for refreshing by crawler
    @PostMapping("/")
    fun createRestaurants(): ResponseEntity<Unit>{
        restaurantService.refreshRestaurants()
        return ResponseEntity.ok().build()
    }
}