package com.primavera.delishas.dto

import java.io.Serializable

data class MealDto (
        var menus: List<MenuDto>?,
        var message: String?,
        var isValid: Boolean
): Serializable