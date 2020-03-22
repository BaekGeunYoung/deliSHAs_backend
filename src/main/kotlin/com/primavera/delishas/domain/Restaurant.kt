package com.primavera.delishas.domain

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "restaurant")
class Restaurant(
        @Column(name = "name", unique = true)
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
): EntityAuditing(), Serializable