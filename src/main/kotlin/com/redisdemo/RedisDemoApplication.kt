package com.redisdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RedisDemo1Application

fun main(args: Array<String>) {
    runApplication<RedisDemo1Application>(*args)
}
