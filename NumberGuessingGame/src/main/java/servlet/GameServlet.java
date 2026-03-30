package servlet;

import java.io.IOException;

import daoimpl.GameDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Game;

public class GameServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        HttpSession session = req.getSession();

        int randomNumber = (int) session.getAttribute("number");
        int attempts = (int) session.getAttribute("attempts");

        int guess = Integer.parseInt(req.getParameter("guess"));

        attempts--;

        String message = "";

        if (guess == randomNumber) {
            message = "Correct!";
        } else if (guess > randomNumber) {
            message = "Too High!";
        } else {
            message = "Too Low!";
        }

        session.setAttribute("attempts", attempts);
        session.setAttribute("message", message);

        if (guess == randomNumber || attempts == 0) {

            int score = attempts * 10;

            Game game = new Game();
            game.setUsername("Player1");
            game.setAttempts(5 - attempts);
            game.setScore(score);
            game.setResult(message);

            new GameDAOImpl().saveResult(game);

            res.sendRedirect("result.jsp");

        } else {
            res.sendRedirect("game.jsp");
        }
    }
}