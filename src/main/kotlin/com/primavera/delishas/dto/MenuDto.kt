package com.primavera.delishas.dto

import com.primavera.delishas.domain.Menu
import java.time.LocalDate

data class MenuDto (
        var id: Long,
        var name: String?,
        var price: Int?
){
    companion object{
        fun of(menu: Menu): MenuDto{
            return MenuDto(
                    id = menu.id,
                    name = menu.name,
                    price = menu.price ?: null
            )
        }
    }
}