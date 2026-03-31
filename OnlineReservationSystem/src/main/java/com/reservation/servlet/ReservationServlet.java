package com.reservation.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.reservation.daoimpl.ReservationDAOImpl;
import com.reservation.model.Reservation;
import com.reservation.util.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ReservationServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	        throws ServletException, IOException{
			    try(Connection con = DBConnection.getConnection()) {

			        PreparedStatement ps = con.prepareStatement(
			            "INSERT INTO reservations(name, train_no, train_name, class_type, journey_date, source, destination) VALUES (?, ?, ?, ?, ?, ?, ?)",
			            Statement.RETURN_GENERATED_KEYS
			        );

			        ps.setString(1, req.getParameter("name"));
			        ps.setString(2, req.getParameter("trainNo"));
			        ps.setString(3, req.getParameter("trainName"));
			        ps.setString(4, req.getParameter("classType"));
			        ps.setDate(5, Date.valueOf(req.getParameter("date")));
			        ps.setString(6, req.getParameter("source"));
			        ps.setString(7, req.getParameter("destination"));

			        ps.executeUpdate();

			        ResultSet rs = ps.getGeneratedKeys();

			        if(rs.next()) {
			            int pnr = rs.getInt(1);
			            res.sendRedirect("SuccessServlet?pnr=" + pnr);
			        }

			    } catch(Exception e) {
			        e.printStackTrace();
			    }
	}
}
