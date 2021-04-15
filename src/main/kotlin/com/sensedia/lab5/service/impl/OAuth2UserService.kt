package com.sensedia.lab5.service.impl

import com.sensedia.lab5.service.UserService
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService

abstract class OAuth2UserService(
    private val clientService: OAuth2AuthorizedClientService) : UserService {

    fun getAccessToken(): String {
        TODO("TODO 5 - Implementar o método getAccessToken que devolve o access token gerado pelo login do Facebook.")
    }
}