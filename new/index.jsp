<%@ page import="java.util.*, java.text.*" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<%@ page import="com.alex.mvc.User" %>
<%@ page import="com.alex.mvc.UserCollection" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.ZoneId" %>

<%@ page errorPage="error.jsp" %>

<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="css/styles.css">
		<title>Таблиця користувачів</title>
	</head>
	<body>
		<div class="container">
			<jsp:include page="form.jsp">
				<jsp:param name="welcomeMessage" value="Ласкаво просимо" />
			</jsp:include>
	
			<div class="block">
				<h2>Існуючі користувачі:</h2>
	
				<%
					var model = (UserCollection) request.getAttribute("userModel");
					List<User> users = new ArrayList<>();
					if (model != null)
						users = model.getUsers();
					var formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
				%>
				<table class="user-table">
					<tr>
						<th>Ім'я</th>
						<th>Пошта</th>
						<th>Час реєстрації</th>
					</tr>
					<%
						for (var user : users) {
					%>
					<tr>
						<td><%= user.getName() %></td>
						<td><%= user.getEmail() %></td>
						<td><%= formatter.format(user.getRegDate().toInstant().atZone(ZoneId.systemDefault())) %></td>
					</tr>
					<%
						}
					%>
				</table>
			</div>
		</div>
	</body>
</html>
