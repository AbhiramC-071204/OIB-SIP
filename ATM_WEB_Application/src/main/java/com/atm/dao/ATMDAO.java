package com.atm.dao;

import com.atm.model.User;
import com.atm.model.Transaction;
import java.util.List;

public interface ATMDAO {

    User login(int userId, int pin);

    double getBalance(int userId);

    boolean deposit(int userId, double amount);

    boolean withdraw(int userId, double amount);

    boolean transfer(int fromUser, int toUser, double amount);

    List<Transaction> getTransactions(int userId);

    double getTotalDeposit(int userId);

    double getTotalWithdraw(int userId);
}