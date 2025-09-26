package com.alex.mvc;

import java.util.Date;

// POJO (звичайний старий об'єкт java)
// слугує для зберігання інформації про користувача
// у контексті MVC цей клас можна вважати частиною моделі
// https://www.baeldung.com/java-pojo-class
// https://en.wikipedia.org/wiki/Plain_Old_Java_Object
// https://www.geeksforgeeks.org/advance-java/pojo-vs-java-beans/
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

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "User{" + "name='" + name + '\'' + ", email='" + email + '\'' + ", regDate=" + regDate + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		User user = (User) o;
		if (!name.equals(user.name))
			return false;
		if (!email.equals(user.email))
			return false;
		return regDate.equals(user.regDate);
	}

	@Override
	public int hashCode() {
		int result = name.hashCode();
		result = 31 * result + email.hashCode();
		result = 31 * result + regDate.hashCode();
		return result;
	}
}