package Server;

import AccountSystem.Account;
import AccountSystem.AccountDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AccountHandler extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String accountName = req.getParameter("accountName");
        int type = Integer.parseInt(req.getParameter("type"));
        double amount = Double.parseDouble(req.getParameter("amount"));
        String description = req.getParameter("description");
        int id = (int)System.currentTimeMillis();
        String studentID = req.getParameter("studentID");

        Account account = new Account(id, accountName, type,
                amount, description, studentID);

        AccountDao.insertAccount(account);

        resp.setStatus(201);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String orderBy = req.getParameter("orderBy")
    }

    protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // TODO: 11/30/16 delete account 
    }

    protected void doPut(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // TODO: 12/2/16
    }
}

