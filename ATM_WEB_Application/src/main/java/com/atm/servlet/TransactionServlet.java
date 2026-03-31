package com.atm.servlet;

import java.io.IOException;
import java.util.List;

import com.atm.daoimpl.ATMDAOImpl;
import com.atm.model.Transaction;
import com.atm.model.User;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class TransactionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            res.sendRedirect("login.jsp");
            return;
        }

        User user = (User) session.getAttribute("user");

        ATMDAOImpl dao = new ATMDAOImpl();

        List<Transaction> list = dao.getTransactions(user.getUserId());

        req.setAttribute("transactions", list);

        RequestDispatcher rd = req.getRequestDispatcher("transaction.jsp");
        rd.forward(req, res);
    }
}