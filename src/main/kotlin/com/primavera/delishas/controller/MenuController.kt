package com.primavera.delishas.controller

import com.primavera.delishas.domain.Menu
import com.primavera.delishas.service.menu.MenuService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.Cacheable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/menu")
class MenuController (
        @Autowired val menuService: MenuService
){
    @GetMapping("/")
    @Cacheable(value = ["menus"], key = "menus")
    fun getMenus(): ResponseEntity<List<Menu>> {
        var menus = menuService.getAll()
        return ResponseEntity.ok().body(menus)
    }

    @GetMapping("/get")
    @Cacheable(value = ["menus"], key = "#name")
    fun getMenuByName(@RequestParam name: String): ResponseEntity<Menu>{
        var menu = menuService.getByName(name)
        return ResponseEntity.ok().body(menu)
    }
}