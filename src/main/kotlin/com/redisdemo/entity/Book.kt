package com.redisdemo.entity

import jakarta.persistence.*

@Entity
@Table(name = "books")
class Book (
    @Column(name = "title", nullable = false)
    var title: String,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    var id: Long? = null
        protected set

    @Column(name = "count_pages")
    var countPages: Int? = null

}
