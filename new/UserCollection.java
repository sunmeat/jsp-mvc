package com.alex.mvc;

import java.util.ArrayList;
import java.util.List;

// клас представляє модель даних користувачів,
// керує списком користувачів, дозволяючи додавати нових користувачів 
// і отримувати поточний список всіх зареєстрованих користувачів
public class UserCollection {
	private List<User> users = new ArrayList<>();

	public void addUser(User user) {
		users.add(user);
	}

	public List<User> getUsers() {
		return new ArrayList<>(users);
	}

	public boolean removeUser(String name) {
		return users.removeIf(user -> user.getName().equals(name));
	}

	public User findUserByName(String name) {
		return users.stream().filter(user -> user.getName().equals(name)).findFirst().orElse(null);
	}

	public User findUserByEmail(String email) {
		return users.stream().filter(user -> user.getEmail().equals(email)).findFirst().orElse(null);
	}

	public int getUserCount() {
		return users.size();
	}

	public void clearUsers() {
		users.clear();
	}
}