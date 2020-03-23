package com.primavera.delishas.domain

import java.io.Serializable
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "menu")
data class Menu(
        @Column(name = "name")
        var name: String?,

        @Column(name = "price")
        var price: Int?,

        @Column(name = "msg")
        var msg: String?,

        @Column(name = "meal_time")
        @Enumerated(EnumType.STRING)
        var mealTime: MealTime,

        @Column(name = "date")
        var date: LocalDate,

        @Column(name = "is_valid")
        var isValid: Boolean,

        @ManyToOne
        @JoinColumn(name = "restaurant_id")
        var restaurant: Restaurant
): EntityAuditing(), Serializable

enum class MealTime {
    BREAKFAST,
    LUNCH,
    DINNER
}