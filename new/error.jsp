<%@ page isErrorPage="true"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<meta charset="UTF-8">
<title>Помилка</title>
<link rel="stylesheet" type="text/css" href="css/error.css">
</head>
<body class="error-body">
	<div class="error-container">
		<h1 class="error-title">Сталася помилка</h1>
		<%
		var ex = (Throwable) request.getAttribute("jakarta.servlet.error.exception");
		String errorMessage = (ex != null) ? ex.getMessage() : "Невідома помилка.";
		%>
		<p class="error-message">
			Вибачте, але сталася помилка:
			<%=errorMessage%></p>
		<p class="error-message">
			Будь ласка, поверніться на <a class="error-link" href="index.jsp">головну
				сторінку</a>.
		</p>
	</div>
</body>
</html>