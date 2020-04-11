package com.primavera.delishas.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "restaurant_info")
data class RestaurantInfo (
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        @JsonIgnore
        var id: Long,

        @Column(name = "name", unique = true, length = 200)
        var name: String,

        @Column(name = "place")
        var place: String,

        @Column(name = "contact")
        var contact: String,

        @Column(name = "breakfast_time")
        var breakfastTime: String,

        @Column(name = "lunch_time")
        var lunchTime: String,

        @Column(name = "dinner_time")
        var dinnerTime: String

//        @Column(name = "latitude")
//        var latitude: Double,
//
//        @Column(name = "longitude")
//        var longitude: Double
): EntityAuditing(), Serializable