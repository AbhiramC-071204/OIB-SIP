package com.reservation.servlet;

import java.io.IOException;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/SuccessServlet")
public class SuccessServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String pnr = req.getParameter("pnr");
        req.setAttribute("pnr", pnr);

        req.getRequestDispatcher("success.jsp").forward(req, res);
    }
}