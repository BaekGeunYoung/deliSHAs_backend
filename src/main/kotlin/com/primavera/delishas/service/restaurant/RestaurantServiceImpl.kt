package com.primavera.delishas.service.restaurant

import com.primavera.delishas.dto.RestaurantDto
import com.primavera.delishas.repostiory.MenuRepository
import com.primavera.delishas.repostiory.RestaurantRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class RestaurantServiceImpl(
        @Autowired private val restaurantRepository: RestaurantRepository,
        @Autowired private val menuRepository: MenuRepository
): RestaurantService {

    @CachePut(value = ["restaurants"], key = "restaurants")
    override fun createRestaurants(restaurantsDto: MutableList<RestaurantDto>) {
        for(restaurantDto in restaurantsDto){
            restaurantDto.menus.map { menu -> menuRepository.save(menu) }
            restaurantRepository.save(RestaurantDto.toRestaurant(restaurantDto))
        }
    }

    // cache method
    @Cacheable(value = ["restaurants"])
    override fun getRestaurants(): MutableList<RestaurantDto> {
        return refreshRestaurants()
    }

    // no cache method for crawler
    override fun refreshRestaurants(): MutableList<RestaurantDto>{
        val restaurantsRes: MutableList<RestaurantDto> = mutableListOf()

        // 1. get restaurants
        val restaurants = restaurantRepository.findAll()

        // 2. set restaurant dto with menus
        for(restaurant in restaurants){
            val menus = menuRepository.findByRestaurant(restaurant)
            restaurantsRes.add(RestaurantDto.of(restaurant, menus))
        }

        // 3. refresh cache
        createRestaurants(restaurantsRes)
        return restaurantsRes
    }
}