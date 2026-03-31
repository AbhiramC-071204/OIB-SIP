package com.atm.servlet;

import java.io.IOException;

import com.atm.daoimpl.ATMDAOImpl;
import com.atm.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class DepositServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        double amount = Double.parseDouble(req.getParameter("amount"));

        HttpSession session = req.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            res.sendRedirect("login.jsp");
            return;
        }

        User user = (User) session.getAttribute("user");

        ATMDAOImpl dao = new ATMDAOImpl();

        if (dao.deposit(user.getUserId(), amount)) {

            user.setBalance(dao.getBalance(user.getUserId()));

            res.sendRedirect("dashboard.jsp?msg=Deposit Success");

        } else {
            res.sendRedirect("deposit.jsp?error=Failed");
        }
    }
}