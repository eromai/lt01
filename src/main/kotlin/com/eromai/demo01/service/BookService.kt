package com.eromai.demo01.service

import com.eromai.demo01.entity.Book
import com.eromai.demo01.repository.BookRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BookService(private val bookRepository: BookRepository) {

    fun getAllBooks(): List<Book> = bookRepository.findAll()

    fun getBookById(id: Long): Book? = bookRepository.findById(id).orElse(null)

    fun findBooksByTitle(title: String): List<Book> =
        bookRepository.findByTitleContainingIgnoreCase(title)

    fun findBooksByAuthor(author: String): List<Book> =
        bookRepository.findByAuthorContainingIgnoreCase(author)

    @Transactional
    fun createBook(book: Book): Book = bookRepository.save(book)

    @Transactional
    fun updateBook(id: Long, bookDetails: Book): Book? {
        return bookRepository.findById(id).map { existingBook ->
            val updatedBook = existingBook.copy(
                title = bookDetails.title,
                author = bookDetails.author,
                description = bookDetails.description,
                isbn = bookDetails.isbn,
                publicationYear = bookDetails.publicationYear
            )
            bookRepository.save(updatedBook)
        }.orElse(null)
    }

    @Transactional
    fun deleteBook(id: Long) {
        bookRepository.deleteById(id)
    }
}