package com.sensedia.lab5.service.impl

import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers
import java.net.HttpURLConnection
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
        var accessToken = getAccessToken()
        val uri = URI("https://graph.facebook.com/me?fields=name,email&access_token=" + accessToken)
        val request = HttpRequest.newBuilder().uri(uri).GET().build()
        val response = HttpClient.newHttpClient().send(request, BodyHandlers.ofString())
        if (response.statusCode() == HttpURLConnection.HTTP_OK) {
            var json = response.body()
            var rootNode = objectMapper.readTree(json)
            return User(rootNode.get("name").asText(""),
                rootNode.get("email").asText(""))
        }
        return null
    }
}