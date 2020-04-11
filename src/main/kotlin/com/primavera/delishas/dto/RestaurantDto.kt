package com.primavera.delishas.dto

import com.primavera.delishas.domain.MealTime
import com.primavera.delishas.domain.Menu
import com.primavera.delishas.domain.Restaurant
import com.primavera.delishas.exception.RestaurantNotFoundException
import java.time.LocalDate

data class RestaurantDto (
        var name: String,
        var place: String,
        var contact: String,

        var breakfastTime: String,
        var lunchTime: String,
        var dinnerTime: String,

        var date: LocalDate,

        var breakfast: MealDto,
        var lunch: MealDto,
        var dinner: MealDto
//
//    var latitude: Double,
//    var longitude: Double
){
    companion object{
        fun of(restaurant: Restaurant): RestaurantDto{
            val breakfasts = restaurant.menus?.filter{menu -> menu.mealTime == MealTime.BREAKFAST}
            val lunches = restaurant.menus?.filter{menu -> menu.mealTime == MealTime.LUNCH}
            val dinners = restaurant.menus?.filter{menu -> menu.mealTime == MealTime.DINNER}
            return RestaurantDto(
                    name = restaurant.restaurantInfo.name,
                    place = restaurant.restaurantInfo.place,
                    contact = restaurant.restaurantInfo.contact,
                    date = restaurant.date,

                    breakfast = MealDto(
                            menus = breakfasts?.map{menu -> MenuDto.of(menu)},
                            message = breakfasts?.first()?.msg,
                            isValid = breakfasts?.first()?.isValid
                    ),

                    lunch = MealDto(
                            menus = lunches?.map{menu -> MenuDto.of(menu)},
                            message = lunches?.first()?.msg,
                            isValid = lunches?.first()?.isValid
                    ),

                    dinner = MealDto(
                            menus = dinners?.map{menu -> MenuDto.of(menu)},
                            message = dinners?.first()?.msg,
                            isValid = dinners?.first()?.isValid
                    ),

                    breakfastTime = restaurant.restaurantInfo.breakfastTime,
                    lunchTime = restaurant.restaurantInfo.lunchTime,
                    dinnerTime = restaurant.restaurantInfo.dinnerTime

//                    latitude = restaurant.latitude,
//                    longitude = restaurant.longitude
            )
        }
    }
}