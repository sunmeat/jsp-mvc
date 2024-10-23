package sunmeat.jsp.examples;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

// класс действует как контроллер в архитектуре MVC
@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserModel userModel = new UserModel();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String submit = request.getParameter("submit");

			// проверка, что форма была отправлена и все необходимые параметры присутствуют
			if (submit != null) {
				if (name != null && !name.trim().isEmpty() && email != null && !email.trim().isEmpty()) {
					if (name.equalsIgnoreCase("Олег")) {
						throw new ServletException("Имя 'Олег' не разрешено.");
					}
					// добавление нового пользователя
					userModel.addUser(new User(name, email, new Date()));
				} else if (name == "" || email == "") {
					request.setAttribute("javax.servlet.error.exception", new ServletException("Не указан логин либо пароль"));
					request.getRequestDispatcher("/error.jsp").forward(request, response);
				}
			}

			// перенаправление на GET запрос для отображения обновленного списка пользователей
			response.sendRedirect(request.getContextPath() + "/user");
		} catch (Exception e) {
			request.setAttribute("javax.servlet.error.exception", e);
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// устанавливаем объект userModel в качестве атрибута запроса с именем "userModel"
		request.setAttribute("userModel", userModel);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
}
