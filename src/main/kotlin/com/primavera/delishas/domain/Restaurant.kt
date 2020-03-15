package com.primavera.delishas.domain

import java.io.Serializable
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name="restaurant")
data class Restaurant (
        @Column(name="name")
        var name: String,
        @Column(name="date")
        var date: LocalDate,
        @ElementCollection
        var breakfast: List<Menu>,
        @ElementCollection
        var lunch: List<Menu>,
        @ElementCollection
        var dinner: List<Menu>
): EntityAuditing(), Serializable