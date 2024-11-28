package com.eromai.demo01.controller

import com.eromai.demo01.entity.Book
import com.eromai.demo01.service.BookService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/books")
@Tag(name = "Book Management", description = "APIs for managing books")
class BookController(private val bookService: BookService) {

    @Operation(
        summary = "Get all books",
        description = "Retrieves a list of all books in the system"
    )
    @GetMapping
    fun getAllBooks(): List<Book> = bookService.getAllBooks()

    @Operation(
        summary = "Get a book by ID",
        description = "Retrieves a specific book by its ID",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "Book found",
                content = [Content(schema = Schema(implementation = Book::class))]
            ),
            ApiResponse(
                responseCode = "404",
                description = "Book not found"
            )
        ]
    )
    @GetMapping("/{id}")
    fun getBookById(@PathVariable id: Long): ResponseEntity<Book> {
        val book = bookService.getBookById(id)
        return if (book != null) ResponseEntity.ok(book)
        else ResponseEntity.notFound().build()
    }

    @Operation(
        summary = "Create a new book",
        description = "Creates a new book with the provided details"
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createBook(@RequestBody book: Book): Book = bookService.createBook(book)

    @Operation(
        summary = "Update a book",
        description = "Updates an existing book with the provided details"
    )
    @PutMapping("/{id}")
    fun updateBook(@PathVariable id: Long, @RequestBody bookDetails: Book): ResponseEntity<Book> {
        val updatedBook = bookService.updateBook(id, bookDetails)
        return if (updatedBook != null) ResponseEntity.ok(updatedBook)
        else ResponseEntity.notFound().build()
    }

    @Operation(
        summary = "Delete a book",
        description = "Deletes a book by its ID"
    )
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteBook(@PathVariable id: Long) = bookService.deleteBook(id)

    @Operation(
        summary = "Search books by title",
        description = "Finds books whose titles contain the search term (case-insensitive)"
    )
    @GetMapping("/search/title")
    fun findBooksByTitle(@RequestParam title: String): List<Book> =
        bookService.findBooksByTitle(title)

    @Operation(
        summary = "Search books by author",
        description = "Finds books whose authors contain the search term (case-insensitive)"
    )
    @GetMapping("/search/author")
    fun findBooksByAuthor(@RequestParam author: String): List<Book> =
        bookService.findBooksByAuthor(author)
}