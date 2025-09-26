package com.alex.mvc;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserCollection userModel = new UserCollection();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// отримуємо параметри з форми: ім'я, email та кнопку submit
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String submit = request.getParameter("submit");

			// перевіряємо, чи була надіслана форма
			if (submit != null) {
				if (name != null && !name.trim().isEmpty() && email != null && !email.trim().isEmpty()) {
					// спеціальна перевірка: якщо ім'я "Олег" (ігноруючи регістр), викидаємо виняток
					// цей throw потрапляє в catch-блок нижче, що призводить до forward на error.jsp
					if (name.equalsIgnoreCase("Олег")) {
						throw new ServletException("Ім'я 'Олег' не дозволено.");
					}
					// якщо валідація пройшла, створюємо нового User і додаємо до моделі
					userModel.addUser(new User(name, email, new Date()));
				} else {
					// альтернативна обробка: якщо поля порожні (""), встановлюємо атрибут з
					// винятком
					// і відразу forward на error.jsp без перенаправлення
					request.setAttribute("javax.servlet.error.exception",
							new ServletException("Не вказано логін або пароль"));
					request.getRequestDispatcher("/error.jsp").forward(request, response);
				}
			}

			// якщо все OK (додано користувача або форма не надіслана), перенаправляємо на GET-запит
			// це забезпечує відображення оновленого списку без дублювання POST
			response.sendRedirect(request.getContextPath() + "/user");
		} catch (Exception e) {
			// catch ловить будь-який виняток з try (включно з ServletException від "Олег")
			// встановлюємо виняток як атрибут запиту для error.jsp, потім forward на неї
			// forward передає контроль на error.jsp без зміни URL (внутрішній перехід)
			request.setAttribute("javax.servlet.error.exception", e);
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// для GET: встановлюємо модель користувачів як атрибут для index.jsp
		request.setAttribute("userModel", userModel);
		// forward на index.jsp: рендеримо JSP з атрибутом, відображаючи таблицю
		// користувачів
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
}