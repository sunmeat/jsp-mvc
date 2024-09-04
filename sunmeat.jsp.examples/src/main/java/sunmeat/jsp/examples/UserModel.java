package sunmeat.jsp.examples;

import java.util.ArrayList;
import java.util.List;

// класс представляет модель данных пользователей,
// управляет списком пользователей, позволяя добавлять новых пользователей 
// и получать текущий список всех зарегистрированных пользователей
public class UserModel {
    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }
}