package com.primavera.delishas.controller

import com.primavera.delishas.domain.Restaurant
import com.primavera.delishas.domain.RestaurantInfo
import com.primavera.delishas.service.restaurant.RestaurantService
import com.primavera.delishas.service.restaurantInfo.RestaurantInfoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/restaurant")
class RestaurantController (
        @Autowired val restaurantService: RestaurantService,
        @Autowired val restaurantInfoService: RestaurantInfoService
){

    // Restaurant Menu

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

    // Restaurant Info

    @GetMapping("info")
    fun getInfoByName(@RequestParam name: String): ResponseEntity<RestaurantInfo>{
        val restaurantInfo = restaurantInfoService.getByName(name)
        return ResponseEntity.ok().body(restaurantInfo)
    }

    @GetMapping("infos")
    fun getInfos(): ResponseEntity<List<RestaurantInfo>>{
        val restaurantInfos = restaurantInfoService.getAll()
        return ResponseEntity.ok().body(restaurantInfos)
    }

    @PostMapping("info")
    fun createInfo(@RequestBody restaurantInfo: RestaurantInfo): ResponseEntity<RestaurantInfo>{
        val restaurantInfo = restaurantInfoService.create(restaurantInfo)
        return ResponseEntity.ok().body(restaurantInfo)
    }

    @DeleteMapping("info")
    fun deleteInfo(@RequestParam name: String){
        restaurantInfoService.deleteByName(name)
    }

    @DeleteMapping("infos")
    fun deleteInfos(){
        restaurantInfoService.deleteAll()
    }
}