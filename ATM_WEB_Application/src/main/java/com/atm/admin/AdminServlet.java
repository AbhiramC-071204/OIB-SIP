package com.atm.admin;

import java.io.IOException;
import java.util.List;

import com.atm.daoimpl.ATMDAOImpl;
import com.atm.model.User;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class AdminServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        ATMDAOImpl dao = new ATMDAOImpl();

        List<User> users = dao.getAllUsers();

        req.setAttribute("users", users);

        RequestDispatcher rd = req.getRequestDispatcher("admin.jsp");
        rd.forward(req, res);
    }
}