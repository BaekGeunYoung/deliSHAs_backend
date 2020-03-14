package com.primavera.delishas.service.restaurantInfo

import com.primavera.delishas.domain.RestaurantInfo

interface RestaurantInfoService {
    // CREATE
    fun create(restaurantInfo: RestaurantInfo): RestaurantInfo

    // GET
    fun getAll(): List<RestaurantInfo>
    fun getById(id: Long): RestaurantInfo
    fun getByName(name: String): RestaurantInfo

    // UPDATE
    // fun update(name: String, breakfast: String?, lunch: String?, dinner: String?): Menu

    // DELETE
    fun deleteAll()
    fun deleteById(id: Long)
    fun deleteByName(name: String)
}