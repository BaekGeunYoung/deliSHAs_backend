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
        var mealTime: MealTime,

        @Column(name = "date")
        var date: LocalDate,

        @ManyToOne
        @JoinColumn(name = "restaurant_id")
        //@JsonIgnore
        var restaurant: Restaurant
): EntityAuditing(), Serializable

enum class MealTime {
    BREAKFAST,
    LUNCH,
    DINNER
}