package com.atm.admin;

import java.io.IOException;

import com.atm.daoimpl.ATMDAOImpl;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class DeleteUserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        ATMDAOImpl dao = new ATMDAOImpl();
        dao.deleteUser(id);

        res.sendRedirect("admin");
    }
}