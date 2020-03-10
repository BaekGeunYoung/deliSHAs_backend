package com.primavera.delishas.service.menu

import com.primavera.delishas.domain.Food
import com.primavera.delishas.domain.Menu

interface MenuService {
    // CREATE
    fun create(menu: Menu): Menu

    // GET
    fun getAll(): List<Menu>
    fun getById(id: Long): Menu
    fun getByName(name: String): Menu

    // UPDATE
    fun update(name: String, food: Food): Menu

    // DELETE
    fun deleteById(id: Long)
    fun deleteAll()
}