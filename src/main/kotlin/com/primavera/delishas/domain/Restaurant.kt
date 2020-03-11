package com.primavera.delishas.domain

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name="restaurant")
data class Restaurant (
        @Column(name="name")
        var name: String,
        @Column(name="breakfast")
        var breakfast: String,
        @Column(name="lunch")
        var lunch: String,
        @Column(name="dinner")
        var dinner: String
): EntityAuditing(), Serializable