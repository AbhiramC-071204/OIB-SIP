package com.atm.servlet;

import java.io.IOException;

import com.atm.daoimpl.ATMDAOImpl;
import com.atm.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class TransferServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        int toUser = Integer.parseInt(req.getParameter("toUser"));
        double amount = Double.parseDouble(req.getParameter("amount"));

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        ATMDAOImpl dao = new ATMDAOImpl();

        boolean success = dao.transfer(user.getUserId(), toUser, amount);

        if (success) {

            user.setBalance(dao.getBalance(user.getUserId()));

            res.sendRedirect("dashboard.jsp?msg=Transfer Success");
        } else {
            res.sendRedirect("transfer.jsp?error=Failed");
        }
    }
}