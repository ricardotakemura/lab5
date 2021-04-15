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