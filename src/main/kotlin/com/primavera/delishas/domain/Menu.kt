package com.primavera.delishas.domain

import javax.persistence.Entity

@Entity
data class Menu(
        var name: String,
        var price: Int,
        var msg: String
)