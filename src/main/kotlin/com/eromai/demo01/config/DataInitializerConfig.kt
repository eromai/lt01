package com.eromai.demo01.config

import com.eromai.demo01.entity.Book
import com.eromai.demo01.repository.BookRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DataInitializerConfig {

    @Bean
    fun initDatabase(bookRepository: BookRepository) = CommandLineRunner {
        val books = listOf(
            Book(
                title = "The Kotlin Programming Language",
                author = "Kotlin Team",
                description = "A comprehensive guide to Kotlin programming",
                isbn = "978-1-234567-89-0",
                publicationYear = 2023
            ),
            Book(
                title = "Spring Boot in Action",
                author = "Craig Walls",
                description = "Learn Spring Boot framework",
                isbn = "978-1-617292-54-2",
                publicationYear = 2022
            )
        )

        bookRepository.saveAll(books)
    }
}