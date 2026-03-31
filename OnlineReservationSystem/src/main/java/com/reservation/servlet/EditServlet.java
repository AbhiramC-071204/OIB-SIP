package com.reservation.servlet;

import java.io.IOException;
import java.sql.*;

import com.reservation.model.Reservation;
import com.reservation.util.DBConnection;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        int pnr = Integer.parseInt(req.getParameter("pnr"));

        try (Connection con = DBConnection.getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM reservations WHERE pnr=?"
            );

            ps.setInt(1, pnr);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Reservation r = new Reservation();
                r.setPnr(rs.getInt("pnr"));
                r.setName(rs.getString("name"));
                r.setTrainName(rs.getString("train_name"));
                r.setClassType(rs.getString("class_type"));
                r.setSource(rs.getString("source"));
                r.setDestination(rs.getString("destination"));

                req.setAttribute("r", r);
            }

            req.getRequestDispatcher("edit.jsp").forward(req, res);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}