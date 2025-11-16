package com.redisdemo.controller

import com.redisdemo.service.InitService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class InitRestController {

    @Autowired
    private lateinit var initService: InitService

    @GetMapping("/init")
    fun init(): String {
        initService.initBook()
        return "Ok"
    }
}