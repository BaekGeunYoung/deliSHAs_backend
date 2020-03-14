package com.primavera.delishas.domain

import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name="restaurant_info")
data class RestaurantInfo (
     var name: String,
     var contact: String,
     var startedAt: LocalDateTime,
     var endedAt: LocalDateTime,

     // 단방향성 관계 맵핑
     @OneToOne
     @JoinColumn(name="restaurant_id")
     var restaurant: Restaurant

): EntityAuditing(), Serializable