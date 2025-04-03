package org.midterm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbDriver {
	private Connection connection;
	private String dbUrl = "jdbc:sqlite:database/games.db";

	public dbDriver() {

		try {
			connection = DriverManager.getConnection(dbUrl);
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	public void dbInit() {
		String sql = "CREATE TABLE IF NOT EXISTS teams (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL,"
				+ "score INTEGER NOT NULL)";

		try (Statement stmt = connection.createStatement()) {
			stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(0);
		}

	}

	public void addTeamdb(int score, String name) {
		String sql = "INSERT INTO teams (name, score) VALUES (?, ?)";

		try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
			pstmt.setString(1, name);
			pstmt.setInt(2, score);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void getAllTeams() {
		String sql = "SELECT * FROM teams;";

		try (PreparedStatement pstmt = connection.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {

			if (!rs.isBeforeFirst()) {
				System.out.println("There is no team data");

			}
			while (rs.next()) {
				String name = rs.getString("name"); // Example column
				int socre = rs.getInt("score");
				System.out.println("Name: " + name + " Score: " + socre);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
