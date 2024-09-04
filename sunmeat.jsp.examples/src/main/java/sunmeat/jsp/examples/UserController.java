package sunmeat.jsp.examples;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

// Класс действует как контроллер в архитектуре MVC
@WebServlet("/user")
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void init() throws ServletException {
        // Инициализация UserModel при старте приложения и очистка данных
        UserModel userModel = new UserModel();
        getServletContext().setAttribute("userModel", userModel);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String submit = request.getParameter("submit");

            // Проверка, что форма была отправлена и все необходимые параметры присутствуют
            if (submit != null && "Добавить пользователя".equals(submit) && name != null && !name.trim().isEmpty() && email != null && !email.trim().isEmpty()) {
                if ("Олег".equalsIgnoreCase(name)) {
                    throw new ServletException("Имя 'Олег' не разрешено.");
                }

                // Получение UserModel из ServletContext
                UserModel userModel = (UserModel) getServletContext().getAttribute("userModel");
                if (userModel == null) {
                    // В случае отсутствия UserModel создаем новый
                    userModel = new UserModel();
                    getServletContext().setAttribute("userModel", userModel);
                }

                // Добавление нового пользователя
                userModel.addUser(new User(name, email, new Date()));
            }

            // Перенаправление на GET запрос для отображения обновленного списка пользователей
            response.sendRedirect(request.getContextPath() + "/user");
        } catch (Exception e) {
            request.setAttribute("javax.servlet.error.exception", e);
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Получение UserModel из ServletContext
        UserModel userModel = (UserModel) getServletContext().getAttribute("userModel");
        if (userModel == null) {
            // В случае отсутствия UserModel создаем новый
            userModel = new UserModel();
            getServletContext().setAttribute("userModel", userModel);
        }

        // Устанавливаем объект userModel в качестве атрибута запроса с именем "userModel"
        request.setAttribute("userModel", userModel);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}