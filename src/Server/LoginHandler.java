package Server;

import AccountSystem.User;
import AccountSystem.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


import java.sql.SQLException;

/**
 * Created by minghua on 11/30/16.
 */

public class LoginHandler extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String studentID = req.getParameter("studentID");
        String password = req.getParameter("password");

        User user = UserDao.getUser(studentID);
        if (user == null) {
            resp.setStatus(400);
        } else {
            resp.setStatus(200);
        }
    }
}

