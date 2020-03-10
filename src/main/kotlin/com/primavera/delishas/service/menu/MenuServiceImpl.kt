package com.primavera.delishas.service.menu

import com.primavera.delishas.domain.Food
import com.primavera.delishas.domain.Menu
import com.primavera.delishas.exception.MenuNotFoundException
import com.primavera.delishas.repostiory.MenuRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MenuServiceImpl (
        @Autowired val menuRepository: MenuRepository
): MenuService{
    override fun create(menu: Menu): Menu {
        return menuRepository.save(menu)
    }

    override fun getAll(): List<Menu> {
        return menuRepository.findAll()
    }

    override fun getById(id: Long): Menu {
        var menu = menuRepository.findById(id)
        if(!menu.isPresent)
            throw MenuNotFoundException("can not find menu : $id")
        return menu.get()
    }

    override fun getByName(name: String): Menu {
        var menu = menuRepository.getByName(name)
        menu?: throw MenuNotFoundException("can not find menu : $name")
        return menu
    }

    override fun update(name: String, food: Food): Menu {
        var menu = menuRepository.getByName(name)
        menu?: throw MenuNotFoundException("can not find menu : $name")
        menu.food = food
        return menuRepository.save(menu)
    }

    override fun deleteAll() {
        menuRepository.deleteAll()
    }

    override fun deleteById(id: Long) {
        menuRepository.deleteById(id)
    }
}