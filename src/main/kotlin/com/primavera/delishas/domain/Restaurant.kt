package com.primavera.delishas.domain

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name="restaurant")
data class Restaurant (
        @Column(name="name")
        var name: String,
        @Column(name="breakfast")
        var breakfast: List<Menu>,
        @Column(name="lunch")
        var lunch: List<Menu>,
        @Column(name="dinner")
        var dinner: List<Menu>
): EntityAuditing(), Serializable