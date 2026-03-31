package com.reservation.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.reservation.util.DBConnection;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.*;


public class DeleteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String pnrParam = req.getParameter("pnr");

        if(pnrParam != null) {

            int pnr = Integer.parseInt(pnrParam);

            try (Connection con = DBConnection.getConnection()) {

                PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM reservations WHERE pnr=?"
                );

                ps.setInt(1, pnr);
                ps.executeUpdate();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // redirect back to admin
        res.sendRedirect("AdminServlet");
    }
}