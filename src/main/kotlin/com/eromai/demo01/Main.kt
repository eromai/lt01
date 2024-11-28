package com.eromai.demo01

import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(
    scanBasePackages = ["com.eromai.demo01"]
)
class BookStoreApplication {
    companion object {
        private val logger = LoggerFactory.getLogger(BookStoreApplication::class.java)
    }

    init {
        logger.info("Initializing Book Store Application")
    }
}

fun main(args: Array<String>) {
    runApplication<BookStoreApplication>(*args) {
        // You can add additional configuration here if needed
        addInitializers()
    }
}