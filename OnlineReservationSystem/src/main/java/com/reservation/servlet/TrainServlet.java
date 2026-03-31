package com.reservation.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.reservation.util.DBConnection;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TrainServlet extends HttpServlet  {
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws IOException {

			    String trainNo = req.getParameter("trainNo");

			    try(Connection con = DBConnection.getConnection()) {

			        PreparedStatement ps = con.prepareStatement(
			            "SELECT train_name FROM trains WHERE train_no=?"
			        );

			        ps.setString(1, trainNo);

			        ResultSet rs = ps.executeQuery();

			        if(rs.next()) {
			            res.getWriter().write(rs.getString("train_name"));
			        } else {
			            res.getWriter().write("Not Found");
			        }

			    } catch(Exception e) {
			        e.printStackTrace();
			    }
			}
}
