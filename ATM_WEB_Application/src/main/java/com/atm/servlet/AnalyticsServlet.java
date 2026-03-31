package com.atm.servlet;

import java.io.IOException;

import com.atm.daoimpl.ATMDAOImpl;
import com.atm.model.User;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class AnalyticsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        if(session == null || session.getAttribute("user") == null){
            res.sendRedirect("login.jsp");
            return;
        }

        User user = (User) session.getAttribute("user");

        ATMDAOImpl dao = new ATMDAOImpl();

        double deposit = dao.getTotalDeposit(user.getUserId());
        double withdraw = dao.getTotalWithdraw(user.getUserId());

        req.setAttribute("deposit", deposit);
        req.setAttribute("withdraw", withdraw);

        RequestDispatcher rd = req.getRequestDispatcher("analytics.jsp");
        rd.forward(req, res);
    }
}