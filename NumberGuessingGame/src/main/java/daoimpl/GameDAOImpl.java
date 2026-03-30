package daoimpl;

import dao.GameDAO;
import model.Game;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class GameDAOImpl implements GameDAO {

    @Override
    public void saveResult(Game game) {

        try {
            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO game_results(username, attempts, score, result) VALUES(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, game.getUsername());
            ps.setInt(2, game.getAttempts());
            ps.setInt(3, game.getScore());
            ps.setString(4, game.getResult());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}