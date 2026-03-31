package com.reservation.dao;

import com.reservation.model.Reservation;

public interface ReservationDAO {
    boolean insertReservation(Reservation r);
    Reservation getReservation(int pnr);
    boolean cancelReservation(int pnr);
}