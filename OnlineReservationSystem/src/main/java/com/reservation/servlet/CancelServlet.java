package com.reservation.servlet;

import java.io.IOException;
import java.sql.*;

import com.reservation.util.DBConnection;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/CancelServlet")
public class CancelServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        String pnrParam = req.getParameter("pnr");

        res.setContentType("application/json");

        try (Connection con = DBConnection.getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM reservations WHERE pnr=?"
            );

            ps.setInt(1, Integer.parseInt(pnrParam));
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
            	String json = "{"
            	        + "\"name\":\"" + rs.getString("name") + "\","
            	        + "\"train\":\"" + rs.getString("train_name") + "\","
            	        + "\"classType\":\"" + rs.getString("class_type") + "\","
            	        + "\"from\":\"" + rs.getString("source") + "\","
            	        + "\"to\":\"" + rs.getString("destination") + "\""
            	        + "}";
                res.getWriter().write(json);

            } else {
                res.getWriter().write("{}");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        int pnr = Integer.parseInt(req.getParameter("pnr"));

        try (Connection con = DBConnection.getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM reservations WHERE pnr=?"
            );

            ps.setInt(1, pnr);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        res.getWriter().write("success");
    }
}