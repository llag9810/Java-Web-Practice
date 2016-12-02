package Server;

import AccountSystem.User;
import AccountSystem.UserDao;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by minghua on 11/30/16.
 */
public class RegisterHandler extends HttpServlet {

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException{
        int userType = Integer.parseInt(request.getParameter("userType"));
        String userName = request.getParameter("userName");
        String studentID = request.getParameter("studentID");
        String password = request.getParameter("password");
        User newUser = new User(userType, studentID, password, userName);
        UserDao.insertUser(newUser);

        response.setStatus(201);
    }
}
