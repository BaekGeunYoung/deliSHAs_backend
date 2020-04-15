package com.primavera.delishas.service.restaurant

import com.primavera.delishas.dto.RestaurantDto
import com.primavera.delishas.exception.RestaurantNotFoundException
import com.primavera.delishas.repostiory.MenuRepository
import com.primavera.delishas.repostiory.RestaurantRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class RestaurantServiceImpl(
        @Autowired private val restaurantRepository: RestaurantRepository,
        @Autowired private val menuRepository: MenuRepository
): RestaurantService {

//    @CachePut(value = ["restaurants"], key = "#localDate")
//    fun createRestaurants(restaurants: MutableList<Restaurant>, localDate: String) {
//        restaurants.map { restaurant ->  restaurantRepository.save(restaurant) }
//    }

    // cache method
    @Cacheable(value = ["restaurants"], key = "#localDate")
    override fun getRestaurants(localDate: LocalDate): List<RestaurantDto> {
        return refreshRestaurants(localDate)
    }

    // no cache method for crawler
    @CachePut(value = ["restaurants"], key = "#localDate")
    override fun refreshRestaurants(localDate: LocalDate): List<RestaurantDto>{
        //var testLocalDate = LocalDate.of(2020,4,1)
        // var res = restaurantRepository.findByDate(localDate)
        // var resDto = res?.map { re -> RestaurantDto.of(re) }

        // 1. get restaurants
        // val restaurants = restaurantRepository.findByMenusDate(testLocalDate)

        var restaurants = restaurantRepository.findByDate(localDate)
        // TODO Exception 메세지 통일
        restaurants ?: throw RestaurantNotFoundException("can not find any restaurants.")

        var test = restaurants?.map { restaurant -> RestaurantDto.of(restaurant) }
        // 2. refresh cache
        // createRestaurants(restaurantsDto, localDate.toString())
        return restaurants?.map { restaurant -> RestaurantDto.of(restaurant) }
    }
}