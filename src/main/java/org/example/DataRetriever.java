package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataRetriever {
    String url = "jdbc:postgresql://localhost:5432/mini_football_db";
    String user = "postgres"; // user par défaut
    String pass = "password123";

    public void savePlayers(List<Player> list) {
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            conn.setAutoCommit(false);

            String sql = "INSERT INTO Player (id, name, age, id_team) VALUES (?, ?, ?, ?))";

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                for (Player p : list) {
                    ps.setInt(1, p.id);
                    ps.setString(2, p.name);
                    ps.setInt(3, p.age);
                    ps.setInt(4, p.team.id);
                    ps.executeUpdate();
                }
                conn.commit();
                System.out.println("Tous les joueurs ont été enregistrés !");
            } catch (Exception e) {
                conn.rollback();
                System.out.println("Erreur, rien n' a été enregistré : " + e.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Player> findPlayersByName(String nameToFind) {
        List<Player> results = new ArrayList<>();
        String sql = "SELECT * FROM Player WHERE name ILIKE ?";

        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + nameToFind + "%");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Player p = new Player(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), null);
                results.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }
}
