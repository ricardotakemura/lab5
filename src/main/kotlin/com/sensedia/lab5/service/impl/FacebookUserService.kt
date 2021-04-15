package com.sensedia.lab5.service.impl

import com.sensedia.lab5.model.User
import com.sensedia.lab5.service.impl.OAuth2UserService
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service("facebook")
class FacebookUserService  @Autowired constructor(
    private val clientService: OAuth2AuthorizedClientService): OAuth2UserService(clientService) {
    
    private val objectMapper = ObjectMapper()

    override fun getCurrentUser(): User? {
        TODO("TODO 6 - Implementar o método getCurrentUser que devolve os dados do usuário atual que fez o login no Facebook.")
    }
}