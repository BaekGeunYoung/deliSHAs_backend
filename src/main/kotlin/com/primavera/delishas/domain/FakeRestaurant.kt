package com.primavera.delishas.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "fake_restaurant")
class FakeRestaurant(
        @Column(name = "name", unique = true)
        var name: String,

        @Column(name = "breakfast_start")
        var breakfastStart: String,

        @Column(name = "breakfast_end")
        var breakfastEnd: String,

        @Column(name = "lunch_start")
        var lunchStart: String,

        @Column(name = "lunch_end")
        var lunchEnd: String,

        @Column(name = "dinner_start")
        var dinnerStart: String,

        @Column(name = "dinner_end")
        var dinnerEnd: String
): EntityAuditing()