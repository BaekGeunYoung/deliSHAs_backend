package com.primavera.delishas.domain

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "fake_menu")
data class FakeMenu(
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
        var restaurant: FakeRestaurant
): EntityAuditing()

enum class MealTime {
    BREAKFAST,
    LUNCH,
    DINNER
}