package com.reservation.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import org.mindrot.jbcrypt.BCrypt;

import com.reservation.util.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {

        String user = req.getParameter("username");
        String pass = req.getParameter("password");

    
        try (Connection con = DBConnection.getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO users(username, password) VALUES (?, ?)"
            );

            ps.setString(1, user);
            // 🔐 encrypt
            String hashed = BCrypt.hashpw(pass, BCrypt.gensalt());

            ps.setString(2, hashed);
            int i = ps.executeUpdate();

            if(i > 0) {
                res.sendRedirect("login.jsp?register=success");
            } else {
                res.sendRedirect("register.jsp?error=1");
            }

        } catch(Exception e) {
            e.printStackTrace();
            res.sendRedirect("register.jsp?error=1");
        }
    }
}