package com.primavera.delishas.service.restaurant

import com.primavera.delishas.domain.Restaurant
import com.primavera.delishas.dto.RestaurantDto
import java.time.LocalDate

interface RestaurantService {
    fun getRestaurants(localDate: LocalDate) : List<RestaurantDto>
    fun refreshRestaurants(localDate: LocalDate): List<RestaurantDto>
}