package com.primavera.delishas.service.restaurant

import com.primavera.delishas.domain.Restaurant
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

    @CachePut(value = ["restaurants"], key = "#localDate")
    fun createRestaurants(restaurants: MutableList<Restaurant>, localDate: String) {
        restaurants.map { restaurant ->  restaurantRepository.save(restaurant) }
    }

    // cache method
    @Cacheable(value = ["restaurants"], key = "#localDate")
    override fun getRestaurants(localDate: LocalDate): MutableList<Restaurant> {
        return refreshRestaurants(localDate)
    }

    // no cache method for crawler
    override fun refreshRestaurants(localDate: LocalDate): MutableList<Restaurant>{

        var testLocalDate = LocalDate.of(2020,4,1)

        var res = restaurantRepository.findByDate(testLocalDate)
        var resDto = res?.map { re -> RestaurantDto.of(re) }

        // 1. get restaurants
        val restaurants = restaurantRepository.findByMenusDate(testLocalDate)
        restaurants ?: throw RestaurantNotFoundException("")

        // 2. refresh cache
        createRestaurants(restaurants, testLocalDate.toString())
        return restaurants
    }
}