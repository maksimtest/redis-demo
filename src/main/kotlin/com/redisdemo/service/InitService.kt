package com.redisdemo.service

import com.redisdemo.entity.Book
import com.redisdemo.repository.BookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.CacheEvict
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class InitService {
    @Autowired
    private lateinit var bookRepository: BookRepository

    @Transactional
    @CacheEvict(cacheNames = ["book"], allEntries = true)
    fun initBook() {
        val book1: Book = Book("Kotlin")
        book1.countPages = 20
        bookRepository.save(book1)

        val book2: Book = Book("Java")
        book1.countPages = 40
        bookRepository.save(book2)
    }

}