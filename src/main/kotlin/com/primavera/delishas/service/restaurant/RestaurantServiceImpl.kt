package com.primavera.delishas.service.restaurant

import com.primavera.delishas.domain.Restaurant
import com.primavera.delishas.exception.RestaurantNotFoundException
import com.primavera.delishas.repostiory.RestaurantRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.*
import org.springframework.stereotype.Service

@Service
class RestaurantServiceImpl (
        @Autowired val restaurantRepository: RestaurantRepository
): RestaurantService{
    @CachePut(value = ["menus"], key = "#restaurant.name")
    override fun create(restaurant: Restaurant): Restaurant {
        return restaurantRepository.save(restaurant)
    }

    @Cacheable(value = ["menus"])
    override fun getAll(): List<Restaurant> {
        val restaurants = restaurantRepository.findAll()
        if(restaurants.isEmpty()) throw RestaurantNotFoundException("can not find any menu")

        // CachePut
        for(restaurant in restaurants) create(restaurant)
        return restaurants
    }

    override fun getById(id: Long): Restaurant {
        val restaurant = restaurantRepository.findById(id)
        if(!restaurant.isPresent) throw RestaurantNotFoundException("can not find menu : $id")

        // CachePut
        create(restaurant.get())
        return restaurant.get()
    }

    @Cacheable(value = ["menus"], key = "#name")
    override fun getByName(name: String): Restaurant {
        val restaurant = restaurantRepository.findByName(name)
        restaurant?: throw RestaurantNotFoundException("can not find menu : $name")

        // CachePut
        create(restaurant)
        return restaurant
    }

//    override fun update(name: String, breakfast: String?, lunch: String?, dinner: String?): Menu {
//        val menu = menuRepository.getByName(name)
//        menu?: throw MenuNotFoundException("can not find menu : $name")
//        // menu.food = food
//        return menuRepository.save(menu)
//    }

    @CacheEvict(value = ["menus"], allEntries = true)
    override fun deleteAll() {
        restaurantRepository.deleteAll()
    }

    override fun deleteById(id: Long) {
        restaurantRepository.deleteById(id)
    }

    @CacheEvict(value = ["menus"], key = "#name")
    override fun deleteByName(name: String) {
        restaurantRepository.deleteByName(name)
    }
}