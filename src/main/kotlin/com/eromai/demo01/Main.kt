package com.eromai.demo01

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.util.Scanner

@SpringBootApplication
class Demo01Application

fun main(args: Array<String>) {
    runApplication<Demo01Application>(*args)

    val scanner = Scanner(System.`in`)
    println("Enter your name:")
    val name = scanner.nextLine()
    println("Hello, \$name! Welcome to the Spring Boot application.")
}





