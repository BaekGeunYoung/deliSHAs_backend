package com.primavera.delishas.service.restaurant

import com.primavera.delishas.domain.Restaurant
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

    // 테스트용 메소드
    @CachePut(value = ["restaurants"], key = "restaurants")
    override fun createRestaurants(restaurantsDto: MutableList<RestaurantDto>) {
        for(restaurantDto in restaurantsDto){
            restaurantDto.menus.map { menu -> menuRepository.save(menu) }
            restaurantRepository.save(RestaurantDto.toRestaurant(restaurantDto))
        }
    }

    @Cacheable(value = ["restaurants"])
    override fun getRestaurants(): MutableList<RestaurantDto> {
        val restaurantsRes: MutableList<RestaurantDto> = mutableListOf()
        val restaurants = restaurantRepository.findAll()

        for(restaurant in restaurants){
            val menus = menuRepository.findByRestaurant(restaurant)
            restaurantsRes.add(RestaurantDto.of(restaurant, menus))
        }

        return restaurantsRes
    }

}