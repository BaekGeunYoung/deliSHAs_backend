package com.primavera.delishas.repostiory

import com.primavera.delishas.domain.Menu
import com.primavera.delishas.domain.Restaurant
import org.springframework.data.jpa.repository.JpaRepository

interface MenuRepository : JpaRepository<Menu, Long>{
    fun findByRestaurant(restaurant: Restaurant): List<Menu>?
}