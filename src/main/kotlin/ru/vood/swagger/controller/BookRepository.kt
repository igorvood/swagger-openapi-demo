package ru.vood.swagger.controller

import org.springframework.stereotype.Controller
import java.util.*

@Controller
class BookRepository {
    fun findById(id: Long): Optional<Book> {
        return Optional.of(Book("xcv"))
    }

    val books: Collection<Book>
        get() = Arrays.asList(Book("qwe"))
}