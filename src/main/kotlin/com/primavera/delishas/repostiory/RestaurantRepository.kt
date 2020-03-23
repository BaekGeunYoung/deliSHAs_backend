package com.primavera.delishas.repostiory


import com.primavera.delishas.domain.Restaurant
import org.springframework.data.jpa.repository.JpaRepository

interface RestaurantRepository : JpaRepository<Restaurant, Long>