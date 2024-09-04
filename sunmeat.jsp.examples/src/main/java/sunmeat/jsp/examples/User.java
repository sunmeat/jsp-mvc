package sunmeat.jsp.examples;

import java.util.Date;

// POJO (Plain Old Java Object)
// служит для хранения информации о пользователе
// в контексте MVC этот класс можно считать частью модели
public class User {
    private String name;
    private String email;
    private Date regDate;

    public User(String name, String email, Date regDate) {
        this.name = name;
        this.email = email;
        this.regDate = regDate;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Date getRegDate() {
        return regDate;
    }
}