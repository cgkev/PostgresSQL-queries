package application;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class Query {
	public static void main(String[] args) {
	
		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Postgres SQL Driver NOT FOUND!");
			e.printStackTrace();
			return;

		}


		Connection connection = null;

		try {

			connection = DriverManager.getConnection(
					"jdbc:postgresql://cs1.calstatela.edu:5432/cs4222s15", "cs4222s15",
					"m:Vs2fkM");
			


		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;

		}

		if (connection != null) {
			System.out.println("Connected to Database!");
		} else {
			System.out.println("Failed to make connection!");
		}
	}
}
