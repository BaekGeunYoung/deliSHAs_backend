package com.primavera.delishas.repostiory

import com.primavera.delishas.domain.Menu
import org.springframework.data.jpa.repository.JpaRepository

interface MenuRepository : JpaRepository<Menu, Long>{
    fun getByName(name: String): Menu?
}