package com.primavera.delishas

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class DelishasApplication

fun main(args: Array<String>) {
    runApplication<DelishasApplication>(*args)
}
