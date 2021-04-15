# Laborat&oacute;rio 5 - Integrando Facebook Login

## TODO 1 - Criar a configuração da aplicação. Porta do servidor e segurança via facebook oauth2.

```yaml
server:
  port: 9898
spring:
  security:
    oauth2:
      client:
        registration:
          facebook:
            client-id: XXXXXXXXXXXXXXX
            client-secret: XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
```

## TODO 2 - Criar a configuração para que a página jsp seja renderizada pelos controllers via objeto da classe ModelView.

```kotlin
val viewResolver = InternalResourceViewResolver()
viewResolver.setViewClass(JstlView::class.java)
viewResolver.setPrefix("WEB-INF/pages/")
viewResolver.setSuffix(".jsp")
return viewResolver
```

## TODO 3 - Criar a configuração de segurança: acesso total para o path '/' e restrito para os demais, ou seja, tem que ser autenticado pelo login do Facebook.

```kotlin
http.authorizeRequests()   
    .antMatchers("/").permitAll()
    .anyRequest().authenticated()
    .and().oauth2Login();
```

## TODO 4 - Criar classe de dados User.

```kotlin
data class User(var name: String = "", var email: String = "")
```

## TODO 5 - Implementar o método getAccessToken que devolve o access token gerado pelo login do Facebook.

```kotlin
val oauthToken = SecurityContextHolder.getContext().getAuthentication() as OAuth2AuthenticationToken;
val oAuth2Client = clientService.loadAuthorizedClient(
    oauthToken.getAuthorizedClientRegistrationId(),
    oauthToken.getName()) as OAuth2AuthorizedClient
return oAuth2Client.getAccessToken().getTokenValue()
```

## TODO 6 - Implementar o método getCurrentUser que devolve os dados do usuário atual que fez o login no Facebook.

```kotlin
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
```

## TODO 7 - Implementar o método index no controller para redirecionar para a página WEB-INF/index.jsp

```kotlin
return ModelAndView("index")
```

## TODO 8 - Configurar a página para exibição do nome e email recuperados do usuário atual do Facebook.

```jsp
<!DOCTYPE html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Minha aplica&ccedil;&atilde;o</title>
    </head>
    <body>
        <h1>Nome: <c:out value="${user.name}"/></h1>
        <h1>Email: <c:out value="${user.email}"/></h1>
    </body>
</html>
```

## TODO 9 - Implementar o método getCurrentUser do controller para mandar os dados recuperados do usuário atual do Facebook.

```kotlin
var model = mapOf("user" to userService.getCurrentUser())
return ModelAndView("user", model)
```

## TODO 10 - Executar a aplicação

```shell
mvn clean install
mvn spring-boot:run
```
