package com.reservation.servlet;

import java.io.IOException;
import java.sql.*;

import com.reservation.util.DBConnection;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        int pnr = Integer.parseInt(req.getParameter("pnr"));
        String name = req.getParameter("name");
        String trainName = req.getParameter("trainName");
        String classType = req.getParameter("classType");
        String source = req.getParameter("source");
        String destination = req.getParameter("destination");

        try (Connection con = DBConnection.getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                "UPDATE reservations SET name=?, train_name=?, class_type=?, source=?, destination=? WHERE pnr=?"
            );

            ps.setString(1, name);
            ps.setString(2, trainName);
            ps.setString(3, classType);
            ps.setString(4, source);
            ps.setString(5, destination);
            ps.setInt(6, pnr);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        res.sendRedirect("AdminServlet");
    }
}