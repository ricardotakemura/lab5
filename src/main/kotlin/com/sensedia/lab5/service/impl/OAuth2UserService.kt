package com.sensedia.lab5.service.impl

import com.sensedia.lab5.service.UserService
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient
import org.springframework.security.core.context.SecurityContextHolder

abstract class OAuth2UserService(
    private val clientService: OAuth2AuthorizedClientService) : UserService {

    fun getAccessToken(): String {
        val oauthToken = SecurityContextHolder.getContext().getAuthentication() as OAuth2AuthenticationToken;
        val oAuth2Client = clientService.loadAuthorizedClient(
            oauthToken.getAuthorizedClientRegistrationId(),
            oauthToken.getName()) as OAuth2AuthorizedClient
        return oAuth2Client.getAccessToken().getTokenValue()

    }
}