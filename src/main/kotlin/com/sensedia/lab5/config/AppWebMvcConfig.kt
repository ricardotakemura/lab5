package com.sensedia.lab5.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.ViewResolver
import org.springframework.web.servlet.view.InternalResourceViewResolver
import org.springframework.web.servlet.view.JstlView

@Configuration
@EnableWebMvc
open class AppWebConfig {

    @Bean
    open fun viewResolver(): ViewResolver {
        val viewResolver = InternalResourceViewResolver()
        viewResolver.setViewClass(JstlView::class.java)
        viewResolver.setPrefix("WEB-INF/pages/")
        viewResolver.setSuffix(".jsp")
        return viewResolver
    }

}