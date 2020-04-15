package com.primavera.delishas.dto

import com.primavera.delishas.domain.MealTime
import com.primavera.delishas.domain.Restaurant
import java.io.Serializable
import java.time.LocalDate

data class RestaurantDto (
        var id: Long,
        var name: String,
        var place: String,
        var contact: String,

        var breakfastTime: String?,
        var lunchTime: String?,
        var dinnerTime: String?,

        var date: LocalDate,

        var breakfast: MealDto,
        var lunch: MealDto,
        var dinner: MealDto,

        var latitude: Double,
        var longitude: Double
): Serializable {
    companion object{
        fun of(restaurant: Restaurant): RestaurantDto{
            val breakfasts = restaurant.menus.filter{menu -> menu.mealTime == MealTime.BREAKFAST}
            val breakfastsIsValid = breakfasts.elementAtOrNull(0)?.isValid ?: true

            val lunches = restaurant.menus.filter{menu -> menu.mealTime == MealTime.LUNCH}
            val lunchesIsValid = lunches.elementAtOrNull(0)?.isValid ?: true

            val dinners = restaurant.menus.filter{menu -> menu.mealTime == MealTime.DINNER}
            val dinnersIsValid = dinners.elementAtOrNull(0)?.isValid ?: true

            return RestaurantDto(
                    id = restaurant.id,
                    name = restaurant.restaurantInfo.name,
                    place = restaurant.restaurantInfo.place,
                    contact = restaurant.restaurantInfo.contact,
                    date = restaurant.date,

                    breakfast = MealDto(
                            menus = if(breakfastsIsValid) breakfasts.map{menu -> MenuDto.of(menu)} else listOf(),
                            message = breakfasts.elementAtOrNull(0)?.msg,
                            isValid = breakfastsIsValid
                    ),

                    lunch = MealDto(
                            menus = if(lunchesIsValid) lunches.map{menu -> MenuDto.of(menu)} else listOf(),
                            message = lunches.elementAtOrNull(0)?.msg,
                            isValid = lunchesIsValid
                    ),

                    dinner = MealDto(
                            menus = if(dinnersIsValid) dinners.map{menu -> MenuDto.of(menu)} else listOf(),
                            message = dinners.elementAtOrNull(0)?.msg,
                            isValid = dinnersIsValid
                    ),

                    breakfastTime = restaurant.restaurantInfo.breakfastTime,
                    lunchTime = restaurant.restaurantInfo.lunchTime,
                    dinnerTime = restaurant.restaurantInfo.dinnerTime,

                    latitude = restaurant.restaurantInfo.latitude,
                    longitude = restaurant.restaurantInfo.longitude
            )
        }
    }
}