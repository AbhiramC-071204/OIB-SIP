package com.atm.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.atm.util.DBConnection;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        int userId = Integer.parseInt(req.getParameter("userId"));
        int pin = Integer.parseInt(req.getParameter("pin"));

        try (Connection con = DBConnection.getConnection()) {

            // Check if user exists
            PreparedStatement check = con.prepareStatement(
                "SELECT * FROM users WHERE user_id=?"
            );
            check.setInt(1, userId);

            ResultSet rs = check.executeQuery();

            if (rs.next()) {
                res.sendRedirect("register.jsp?error=User Already Exists");
                return;
            }

            // Insert new user
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO users(user_id,pin,balance) VALUES(?,?,1000)"
            );

            ps.setInt(1, userId);
            ps.setInt(2, pin);

            ps.executeUpdate();

            res.sendRedirect("login.jsp?msg=Account Created Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}