🏧 ATM Management System
📌 Project Overview

The ATM Management System is a web-based application that simulates basic banking operations such as balance inquiry, deposit, withdrawal, and transaction history.

🚀 Features
🔐 User Authentication (Login/Logout)
💰 Check Account Balance
➕ Deposit Money
➖ Withdraw Money
📊 Transaction History
📱 Responsive Dashboard UI
🛠️ Tech Stack
Frontend: HTML, CSS, JavaScript, JSP
Backend: Java (Servlets)
Database: MySQL
Server: Apache Tomcat



🎯 Number Guessing Game (Java)
📌 Project Overview

The Number Guessing Game is a simple Java-based console game where the system generates a random number and the user must guess it.

🚀 Features
🎲 Random number generation (1–100)
🔁 Multiple attempts
📢 Hints (Too High / Too Low)
🏆 Score tracking


🚆 Online Reservation System
📌 Project Overview

The Online Reservation System is a web application used for booking, searching, and canceling tickets. It simulates railway/bus reservation systems.

🚀 Features
🔍 Search Available Tickets
🎫 Book Ticket
❌ Cancel Ticket
📄 View Booking Details
💾 Database Integration
⚡ AJAX-based Search (optional upgrade)
🛠️ Tech Stack
Frontend: HTML, CSS, JavaScript, JSP
Backend: Java (Servlets)
Database: MySQL
Server: Apache Tomcat

1)
CREATE DATABASE atm_system;
USE atm_system;

-- User Table
CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    pin INT,
    balance DOUBLE DEFAULT 0
);

-- Transactions Table
CREATE TABLE transactions (
    transaction_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    type VARCHAR(50),
    amount DOUBLE,
    date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

2)
CREATE DATABASE number_game;
USE number_game;

-- Player Table
CREATE TABLE players (
    player_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100)
);

-- Scores Table
CREATE TABLE scores (
    score_id INT AUTO_INCREMENT PRIMARY KEY,
    player_id INT,
    attempts INT,
    score INT,
    played_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (player_id) REFERENCES players(player_id)
);

3)
CREATE DATABASE reservation_system;
USE reservation_system;

-- Users Table
CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    phone VARCHAR(15)
);

-- Trains / Buses Table
CREATE TABLE routes (
    route_id INT AUTO_INCREMENT PRIMARY KEY,
    source VARCHAR(100),
    destination VARCHAR(100),
    seats_available INT,
    price DOUBLE
);

-- Booking Table
CREATE TABLE bookings (
    booking_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    route_id INT,
    journey_date DATE,
    seats_booked INT,
    status VARCHAR(50) DEFAULT 'CONFIRMED',
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (route_id) REFERENCES routes(route_id)
);
