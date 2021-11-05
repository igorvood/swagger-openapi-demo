package ru.vood.swagger

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class SwaggerApplication

fun main(args: Array<String>) {
    runApplication<SwaggerApplication>(*args)
}
