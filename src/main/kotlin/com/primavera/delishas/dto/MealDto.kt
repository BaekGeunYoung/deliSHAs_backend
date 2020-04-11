package com.primavera.delishas.dto

import com.primavera.delishas.domain.Menu

data class MealDto (
        var menus: List<MenuDto>?,
        var message: String?,
        var isValid: Boolean? = true
)