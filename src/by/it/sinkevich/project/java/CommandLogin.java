package by.it.sinkevich.project.java;

import by.it.sinkevich.project.java.bean.User;
import by.it.sinkevich.project.java.dao.DAO;
import by.it.sinkevich.project.java.dao.UserDAO;
import by.it.sinkevich.project.java.util.Pattern;
import by.it.sinkevich.project.java.util.Utility;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CommandLogin implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (Utility.isValid(login, Pattern.loginRegex) && Utility.isValid(password, Pattern.passwordRegex)) {
            UserDAO userDAO = DAO.getDao().getUserDAO();
            List<User> users = userDAO.readAll(String.format("WHERE login = '%s' AND password = '%s'", login, password));
            User user = null;
            if (users.size() > 0) {
                user = users.get(0);
            }
            String message = request.getAttribute("message").toString();
            if (user != null) {
                request.setAttribute(Action.message, message.concat("Добро пожаловать, ").concat(user.getLogin()));
            } else {
                request.setAttribute(Action.message, message.concat("Введены неверные данные!"));
            }
        }
        return Action.LOGIN.okPage;
    }
}
