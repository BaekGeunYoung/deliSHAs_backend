package com.primavera.delishas.repostiory


import com.primavera.delishas.domain.Restaurant
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDate

interface RestaurantRepository : JpaRepository<Restaurant, Long> {
    fun findByMenusDate(localDate: LocalDate): MutableList<Restaurant>?
    fun findByDate(localDate: LocalDate): MutableList<Restaurant>?
}