package com.primavera.delishas.controller

import com.primavera.delishas.service.restaurant.RestaurantService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/restaurant")
class RestaurantController (
        @Autowired val restaurantService: RestaurantService
){
    // GetRestaurants
}