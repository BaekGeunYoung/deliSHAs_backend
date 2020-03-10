package com.primavera.delishas.domain

import javax.persistence.*

@Entity
data class Menu (
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long,
        var restaurant: String,
        var food: Food
)

data class Food(
        var breakfast: String,
        var lunch: String,
        var dinner: String
)