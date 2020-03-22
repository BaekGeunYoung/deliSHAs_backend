package com.primavera.delishas.service.restaurant

import com.primavera.delishas.dto.RestaurantDto

interface RestaurantService {
    fun createRestaurants(restaurantsDto: MutableList<RestaurantDto>)
    fun getRestaurants() : List<RestaurantDto>
}