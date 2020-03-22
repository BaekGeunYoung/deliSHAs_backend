package com.primavera.delishas.dto

import com.primavera.delishas.domain.Menu
import com.primavera.delishas.domain.Restaurant
import com.primavera.delishas.exception.RestaurantNotFoundException

data class RestaurantDto (
    var name: String,
    var place: String,
    var contact: String,

    var menus: List<Menu>,

    var breakfastTime: String,
    var lunchTime: String,
    var dinnerTime: String
){
    companion object{
        fun of(restaurant: Restaurant, menus: List<Menu>?): RestaurantDto{
            return RestaurantDto(
                    name = restaurant.name,
                    place = restaurant.place,
                    contact = restaurant.contact,

                    menus = menus ?: listOf(),
                    breakfastTime = restaurant.breakfastTime,
                    lunchTime = restaurant.lunchTime,
                    dinnerTime = restaurant.dinnerTime
            )
        }

        fun toRestaurant(restaurantDto: RestaurantDto): Restaurant{
            return Restaurant(
                    name = restaurantDto.name,
                    place = restaurantDto.place,
                    contact = restaurantDto.contact,

                    breakfastTime = restaurantDto.breakfastTime,
                    lunchTime = restaurantDto.lunchTime,
                    dinnerTime = restaurantDto.dinnerTime
            )
        }
    }
}