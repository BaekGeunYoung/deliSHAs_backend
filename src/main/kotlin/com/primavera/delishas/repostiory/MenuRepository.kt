package com.primavera.delishas.repostiory

import com.primavera.delishas.domain.Menu
import com.primavera.delishas.domain.Restaurant
import org.springframework.data.jpa.repository.JpaRepository

interface MenuRepository : JpaRepository<Menu, Long>{
    fun findByName(name: String): Menu?
    fun deleteByName(name: String)
    fun findByRestaurant(restaurant: Restaurant): List<Menu>?
}