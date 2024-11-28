package com.eromai.demo01.entity

import jakarta.persistence.*

@Entity
@Table(name = "books")
data class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    var title: String,

    @Column(nullable = false)
    var author: String,

    @Column(length = 1000)
    var description: String? = null,

    @Column(nullable = false)
    var isbn: String,

    @Column(name = "publication_year")
    var publicationYear: Int? = null
)