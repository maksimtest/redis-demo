package com.redisdemo.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
class PostgresConfig {
    @Bean(name = ["pgDataSource"])
    fun pgDataSource(): DataSource {
        val url = "jdbc:postgresql://localhost:5433/pg_db"

        return HikariDataSource(HikariConfig().apply {
            driverClassName = "org.postgresql.Driver"
            jdbcUrl = url
            username = "user"
            password = "pg_pass"
            maximumPoolSize = 4
            minimumIdle = 1
            connectionTimeout = 120000
            poolName = "HikariPG"
        })
    }

}