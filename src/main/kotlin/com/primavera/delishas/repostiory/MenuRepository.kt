package com.primavera.delishas.repostiory

import com.primavera.delishas.domain.Menu
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDate

interface MenuRepository : JpaRepository<Menu, Long>{
    fun findByDate(localDate: LocalDate): List<Menu>?
}