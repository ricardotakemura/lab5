package com.sensedia.lab5.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.ViewResolver

@Configuration
@EnableWebMvc
open class AppWebConfig {

    @Bean
    open fun viewResolver(): ViewResolver {
        TODO("TODO 2 - Criar a configuração para que a página jsp seja renderizada pelos controllers via objeto da classe ModelView.")
    }

}