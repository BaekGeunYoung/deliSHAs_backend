package com.primavera.delishas.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import java.io.Serializable
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "menu")
data class Menu(
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        @JsonIgnore
        var id: Long,

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

        @ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name = "restaurant_id")
        @JsonIgnore
        var restaurant: Restaurant
): EntityAuditing(), Serializable

enum class MealTime {
    BREAKFAST,
    LUNCH,
    DINNER
}