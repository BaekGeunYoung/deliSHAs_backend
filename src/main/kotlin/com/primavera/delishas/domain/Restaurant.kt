package com.primavera.delishas.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import java.io.Serializable
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "restaurant")
class Restaurant(
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        @JsonIgnore
        var id: Long,

        @Column(name = "date")
        var date: LocalDate,

        @OneToMany(mappedBy = "restaurant")
        var menus: MutableList<Menu>,

        @ManyToOne
        @JoinColumn(name = "restaurant_info_id")
        var restaurantInfo: RestaurantInfo

): EntityAuditing(), Serializable