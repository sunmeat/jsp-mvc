<%@ page isErrorPage="true" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ошибка</title>
    <link rel="stylesheet" type="text/css" href="css/error.css">
</head>
<body class="error-body">
    <div class="error-container">
        <h1 class="error-title">Произошла ошибка</h1>
        <%
            Throwable ex = (Throwable) request.getAttribute("javax.servlet.error.exception");
            String errorMessage = (ex != null) ? ex.getMessage() : "Неизвестная ошибка.";
        %>
        <p class="error-message">Извините, но произошла ошибка: <%= errorMessage %></p>
        <p class="error-message">Пожалуйста, вернитесь на <a class="error-link" href="index.jsp">главную страницу</a>.</p>
    </div>
</body>
</html>