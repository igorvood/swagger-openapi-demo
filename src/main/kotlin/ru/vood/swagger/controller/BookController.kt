package ru.vood.swagger.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import ru.vood.swagger.controller.BookRepository
import ru.vood.swagger.controller.BookNotFoundException

@RestController
@RequestMapping("/api/book")
class BookController {
    @Autowired
    private val repository: BookRepository? = null
    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): Book {
        return repository!!.findById(id)
            .orElseThrow { BookNotFoundException() }
    }

    @GetMapping("/")
    fun findBooks(): Collection<Book> {
        return repository!!.books
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun updateBook(
        @PathVariable("id") id: String?, @RequestBody book: Book
    ): Book {
        return book
    }
}