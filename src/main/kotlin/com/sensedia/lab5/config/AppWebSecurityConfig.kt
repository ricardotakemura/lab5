package com.sensedia.lab5.config

import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.context.annotation.Configuration

@Configuration
@EnableWebSecurity
open class AppWebSecurityConfig: WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        TODO("TODO 3 - Criar a configuração de segurança: acesso total para o path '/' e restrito para os demais, ou seja, tem que ser autenticado pelo login do Facebook.")
    }

}