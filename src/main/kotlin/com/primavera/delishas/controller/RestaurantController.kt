package com.primavera.delishas.controller

import com.primavera.delishas.domain.Restaurant
import com.primavera.delishas.service.menu.RestaurantService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1")
class RestaurantController (
        @Autowired val restaurantService: RestaurantService
){
    @GetMapping("menus")
    fun getMenus(): ResponseEntity<List<Restaurant>> {
        val restaurants = restaurantService.getAll()
        return ResponseEntity.ok().body(restaurants)
    }

    @GetMapping("menu")
    fun getMenuByName(@RequestParam name: String): ResponseEntity<Restaurant>{
        val restaurant = restaurantService.getByName(name)
        return ResponseEntity.ok().body(restaurant)
    }

    @PostMapping("menu")
    fun createMenu(@RequestBody restaurant: Restaurant): ResponseEntity<Restaurant>{
        val createdRestaurant = restaurantService.create(restaurant)
        return ResponseEntity.ok().body(createdRestaurant)
    }

    @DeleteMapping("menu")
    fun deleteMenu(@RequestParam name: String){
        restaurantService.deleteByName(name)
    }

    @DeleteMapping("menus")
    fun deleteMenus(){
        restaurantService.deleteAll()
    }
}