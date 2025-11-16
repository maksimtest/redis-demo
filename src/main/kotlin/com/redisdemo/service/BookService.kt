package com.redisdemo.service

import com.redisdemo.entity.Book
import com.redisdemo.payloads.BookRsData
import com.redisdemo.repository.BookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BookService {
    @Autowired
    private lateinit var bookRepository: BookRepository

    @Transactional(readOnly = true)
    @Cacheable(cacheNames = ["book"], key = "'all'")
    fun show(): List<Book> {
        return bookRepository.findAll()
    }

    @Transactional(readOnly = true)
    @Cacheable(cacheNames = ["book"], key = "{#bookId}")
    fun showById(bookId: Long): List<Book> {
        return bookRepository.findAll()
    }

    @Transactional
    @CacheEvict(cacheNames = ["book"], allEntries = true)
    fun create(payload: BookRsData) {
        val book = Book(payload.title)
            .apply {
                countPages = payload.countPages
            }
        bookRepository.save(book)
    }
}