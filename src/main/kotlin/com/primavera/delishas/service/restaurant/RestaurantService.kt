package com.primavera.delishas.service.restaurant

import com.primavera.delishas.domain.Restaurant

interface RestaurantService {
    // CREATE
    fun create(restaurant: Restaurant): Restaurant

    // GET
    fun getAll(): List<Restaurant>
    fun getById(id: Long): Restaurant
    fun getByName(name: String): Restaurant

    // UPDATE
    // fun update(name: String, breakfast: String?, lunch: String?, dinner: String?): Menu

    // DELETE
    fun deleteAll()
    fun deleteById(id: Long)
    fun deleteByName(name: String)
}