<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*, java.text.*" %>

<div class="block">
    <h2>Добавить нового пользователя</h2>
    <!--<p>
        <%= request.getParameter("welcomeMessage") %>
    </p> -->
    <form name="f1" method="post" action="user" class="user-form">
        <label for="name">Имя пользователя:</label>
        <input id="name" name="name" type="text" maxlength="20" value="" required />
        
        <label for="email">E-mail:</label>
        <input id="email" name="email" type="email" maxlength="20" value="" required />
        
        <input type="submit" name="submit" value="Добавить пользователя" class="submit-button" />
    </form>
</div>
