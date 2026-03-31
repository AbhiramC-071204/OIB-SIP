package com.reservation.daoimpl;

import java.sql.*;
import com.reservation.dao.ReservationDAO;
import com.reservation.model.Reservation;
import com.reservation.util.DBConnection;

public class ReservationDAOImpl implements ReservationDAO {

    public boolean insertReservation(Reservation r) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO reservations(name, train_no, train_name, class_type, journey_date, source, destination) VALUES (?, ?, ?, ?, ?, ?, ?)"
            );

            ps.setString(1, r.getName());
            ps.setString(2, r.getTrainNo());
            ps.setString(3, r.getTrainName());
            ps.setString(4, r.getClassType());
            ps.setDate(5, r.getJourneyDate());
            ps.setString(6, r.getSource());
            ps.setString(7, r.getDestination());

            return ps.executeUpdate() > 0;

        } catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Reservation getReservation(int pnr) {
        Reservation r = null;
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM reservations WHERE pnr=?"
            );
            ps.setInt(1, pnr);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                r = new Reservation();
                r.setName(rs.getString("name"));
                r.setTrainNo(rs.getString("train_no"));
                r.setTrainName(rs.getString("train_name"));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return r;
    }

    public boolean cancelReservation(int pnr) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM reservations WHERE pnr=?"
            );
            ps.setInt(1, pnr);

            return ps.executeUpdate() > 0;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}