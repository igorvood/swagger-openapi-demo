package ru.vood.swagger.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import ru.vood.swagger.controller.BookRepository
import ru.vood.swagger.controller.BookNotFoundException

@RestController
@RequestMapping("/api/book")
@Tag(name = "Book", description = "The User API")
class BookController(private val repository: BookRepository) {

    @ApiResponses(
        value = [ApiResponse(
            responseCode = "200",
            description = "Found the book",
            content = [Content(
                mediaType = "application/json",
                array = ArraySchema(
                    schema = Schema(
                        implementation = Book::class
                    )
                )
            )]
        )]
    )
    @Operation(summary = "Gets book by id", tags = ["book"])
    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): Book {
        return repository.findById(id)
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