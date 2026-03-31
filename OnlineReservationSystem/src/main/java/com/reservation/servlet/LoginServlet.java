package com.reservation.servlet;

import java.io.IOException;
import java.sql.*;

import org.mindrot.jbcrypt.BCrypt;

import com.reservation.util.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {

        String user = req.getParameter("username");
        String pass = req.getParameter("password");

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM users WHERE username=?"
            );

            ps.setString(1, user);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
            	String dbPassword = rs.getString("password");

            	if(dbPassword.startsWith("$2a$")) {
            	    // 🔐 BCrypt password
            	    if(BCrypt.checkpw(pass, dbPassword)) {
            	        loginSuccess(req, res, user);
            	    } else {
            	        res.sendRedirect("login.jsp?error=1");
            	    }
            	} else {
            	    // ⚠ Plain password (old data)
            	    if(pass.equals(dbPassword)) {

            	        // Upgrade to BCrypt 🔥
            	        String newHash = BCrypt.hashpw(pass, BCrypt.gensalt());

            	        PreparedStatement update = con.prepareStatement(
            	            "UPDATE users SET password=? WHERE username=?"
            	        );
            	        update.setString(1, newHash);
            	        update.setString(2, user);
            	        update.executeUpdate();

            	        loginSuccess(req, res, user);

            	    } else {
            	        res.sendRedirect("login.jsp?error=1");
            	    }
            	    }
            }
            }
        catch(Exception e) {
            e.printStackTrace();
        }
    }


    private void loginSuccess(HttpServletRequest req, HttpServletResponse res, String user)
    		throws IOException {

    		    HttpSession session = req.getSession();
    		    session.setAttribute("user", user);

    		    res.sendRedirect("home.jsp");
    		}
    }