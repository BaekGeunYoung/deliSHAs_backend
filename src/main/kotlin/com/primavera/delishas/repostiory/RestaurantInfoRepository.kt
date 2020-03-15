package com.primavera.delishas.repostiory


import com.primavera.delishas.domain.Restaurant
import com.primavera.delishas.domain.RestaurantInfo
import org.springframework.data.jpa.repository.JpaRepository

interface RestaurantInfoRepository : JpaRepository<RestaurantInfo, Long>{
    fun findByName(name: String): RestaurantInfo?
    fun deleteByName(name: String)
}