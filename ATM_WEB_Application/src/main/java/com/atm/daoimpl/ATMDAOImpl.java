package com.atm.daoimpl;

import java.sql.*;
import java.util.*;

import com.atm.dao.ATMDAO;
import com.atm.model.Transaction;
import com.atm.model.User;
import com.atm.util.DBConnection;

public class ATMDAOImpl implements ATMDAO {

    public User login(int userId, int pin) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM users WHERE user_id=? AND pin=?"
            );
            ps.setInt(1, userId);
            ps.setInt(2, pin);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                User u = new User();
                u.setUserId(userId);
                u.setBalance(rs.getDouble("balance"));
                return u;
            }
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }

    public double getBalance(int userId) {
        double balance = 0;
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                "SELECT balance FROM users WHERE user_id=?"
            );
            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) balance = rs.getDouble("balance");

        } catch (Exception e) { e.printStackTrace(); }
        return balance;
    }

    private void addTransaction(int userId, String type, double amount, Connection con) throws Exception {
        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO transactions(user_id,type,amount) VALUES(?,?,?)"
        );
        ps.setInt(1, userId);
        ps.setString(2, type);
        ps.setDouble(3, amount);
        ps.executeUpdate();
    }

    public boolean deposit(int userId, double amount) {
        try (Connection con = DBConnection.getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                "UPDATE users SET balance = balance + ? WHERE user_id=?"
            );
            ps.setDouble(1, amount);
            ps.setInt(2, userId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                addTransaction(userId, "DEPOSIT", amount, con);
                return true;
            }

        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    public boolean withdraw(int userId, double amount) {
        try (Connection con = DBConnection.getConnection()) {

            PreparedStatement check = con.prepareStatement(
                "SELECT balance FROM users WHERE user_id=?"
            );
            check.setInt(1, userId);

            ResultSet rs = check.executeQuery();

            if (rs.next() && rs.getDouble("balance") >= amount) {

                PreparedStatement ps = con.prepareStatement(
                    "UPDATE users SET balance = balance - ? WHERE user_id=?"
                );
                ps.setDouble(1, amount);
                ps.setInt(2, userId);

                int rows = ps.executeUpdate();

                if (rows > 0) {
                    addTransaction(userId, "WITHDRAW", amount, con);
                    return true;
                }
            }

        } catch (Exception e) { e.printStackTrace(); }

        return false;
    }

    public boolean transfer(int fromUser, int toUser, double amount) {
        try (Connection con = DBConnection.getConnection()) {

            con.setAutoCommit(false);

            PreparedStatement w = con.prepareStatement(
                "UPDATE users SET balance = balance - ? WHERE user_id=?"
            );
            w.setDouble(1, amount);
            w.setInt(2, fromUser);

            PreparedStatement d = con.prepareStatement(
                "UPDATE users SET balance = balance + ? WHERE user_id=?"
            );
            d.setDouble(1, amount);
            d.setInt(2, toUser);

            w.executeUpdate();
            d.executeUpdate();

            addTransaction(fromUser, "TRANSFER SENT", amount, con);
            addTransaction(toUser, "TRANSFER RECEIVED", amount, con);

            con.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Transaction> getTransactions(int userId) {

        List<Transaction> list = new ArrayList<>();

        try (Connection con = DBConnection.getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM transactions WHERE user_id=? ORDER BY date DESC"
            );
            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Transaction t = new Transaction();
                t.setType(rs.getString("type"));
                t.setAmount(rs.getDouble("amount"));
                t.setDate(rs.getTimestamp("date"));
                list.add(t);
            }

        } catch (Exception e) { e.printStackTrace(); }

        return list;
    }
    public List<User> getAllUsers() {

        List<User> list = new ArrayList<>();

        try (Connection con = DBConnection.getConnection()) {

            PreparedStatement ps = con.prepareStatement("SELECT * FROM users");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User u = new User();
                u.setUserId(rs.getInt("user_id"));
                u.setBalance(rs.getDouble("balance"));
                list.add(u);
            }

        } catch (Exception e) { e.printStackTrace(); }

        return list;
    }

    public boolean deleteUser(int userId) {

        try (Connection con = DBConnection.getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM users WHERE user_id=?"
            );
            ps.setInt(1, userId);

            return ps.executeUpdate() > 0;

        } catch (Exception e) { e.printStackTrace(); }

        return false;
    }
    public double getTotalDeposit(int userId) {
        return getSum(userId, "DEPOSIT");
    }

    public double getTotalWithdraw(int userId) {
        return getSum(userId, "WITHDRAW");
    }

    private double getSum(int userId, String type) {
        double total = 0;

        try (Connection con = DBConnection.getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                "SELECT SUM(amount) FROM transactions WHERE user_id=? AND type=?"
            );

            ps.setInt(1, userId);
            ps.setString(2, type);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                total = rs.getDouble(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return total;
    }
}