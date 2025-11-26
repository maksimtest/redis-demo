package com.redisdemo.controller

import com.redisdemo.entity.Book
import com.redisdemo.payloads.BookRsData
import com.redisdemo.service.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/book")
class BookRestController {
    @Autowired
    private lateinit var bookService: BookService

    @GetMapping
    fun show(): List<Book> {
        return bookService.show()
    }

    @GetMapping("/{bookId}")
    fun showById(@PathVariable("bookId") bookId: Long): Book? {
        return bookService.showById(bookId)
    }

    @PostMapping
    fun create(payload: BookRsData): String {
        bookService.create(payload)
        return "Ok"
    }
}