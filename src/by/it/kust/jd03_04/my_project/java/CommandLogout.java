package by.it.kust.jd03_04.my_project.java;

import javax.servlet.http.HttpServletRequest;

public class CommandLogout implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        return Action.LOGOUT.inPage;
    }
}
