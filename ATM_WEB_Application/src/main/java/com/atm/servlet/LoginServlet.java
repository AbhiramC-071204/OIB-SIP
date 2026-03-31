package com.atm.servlet;

import java.io.IOException;

import com.atm.daoimpl.ATMDAOImpl;
import com.atm.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        int userId = Integer.parseInt(req.getParameter("userId"));
        int pin = Integer.parseInt(req.getParameter("pin"));

        ATMDAOImpl dao = new ATMDAOImpl();
        User user = dao.login(userId, pin);

        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            res.sendRedirect("dashboard.jsp");
        } else {
            res.sendRedirect("login.jsp?error=Invalid");
        }
    }
}