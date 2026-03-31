package com.reservation.servlet;

import java.io.IOException;
import java.sql.*;
import java.sql.Date;
import java.util.*;

import com.reservation.model.Reservation;
import com.reservation.util.DBConnection;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String pnr = req.getParameter("pnr");
        String date = req.getParameter("date");

        List<Reservation> list = new ArrayList<>();

        try (Connection con = DBConnection.getConnection()) {

            String query = "SELECT * FROM reservations WHERE 1=1";

            if (pnr != null && !pnr.isEmpty()) {
                query += " AND pnr=?";
            }

            if (date != null && !date.isEmpty()) {
                query += " AND journey_date=?";
            }

            PreparedStatement ps = con.prepareStatement(query);

            int i = 1;
            if (pnr != null && !pnr.isEmpty()) {
                ps.setInt(i++, Integer.parseInt(pnr));
            }
            if (date != null && !date.isEmpty()) {
                ps.setDate(i++, Date.valueOf(date));
            }

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Reservation r = new Reservation();
                r.setName(rs.getString("name"));
                r.setTrainNo(rs.getString("train_no"));
                r.setTrainName(rs.getString("train_name"));
                r.setClassType(rs.getString("class_type"));
                r.setSource(rs.getString("source"));
                r.setDestination(rs.getString("destination"));
                list.add(r);
                r.setPnr(rs.getInt("pnr"));   // VERY IMPORTANT
            }

            req.setAttribute("data", list);
            req.getRequestDispatcher("admin.jsp").forward(req, res);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}