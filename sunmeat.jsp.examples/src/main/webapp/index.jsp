<%@ page import="java.util.*, java.text.*" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<%@ page import="sunmeat.jsp.examples.User" %>
<%@ page import="sunmeat.jsp.examples.UserModel" %>

<%@ page errorPage="error.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/table.css">
    <title>Таблица пользователей</title>
</head>
<body>
    <div class="container">
         <jsp:include page="form.jsp">
            <jsp:param name="welcomeMessage" value="Welcome" />
        </jsp:include>

        <div class="block">
            <h2>Существующие пользователи:</h2>
            
           <%
    UserModel userModel = (UserModel) request.getAttribute("userModel");
    List<User> users = new ArrayList<>();
    if (userModel != null) {
        users = userModel.getUsers();
        int x = 10;
    }
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", new Locale("uk", "UA"));
%>
            <table class="user-table">
                <tr>
                    <th>Имя</th>
                    <th>Почта</th>
                    <th>Время регистрации</th>
                </tr>
                <% for (User user : users) { %>
                    <tr>
                        <td><%= user.getName() %></td>
                        <td><%= user.getEmail() %></td>
                        <td><%= sdf.format(user.getRegDate()) %></td>
                    </tr>
                <% } %>
            </table>
        </div>
    </div>
</body>
</html>