package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Query {
	public static void main(String[] args) throws SQLException {

		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Postgres SQL Driver NOT FOUND!");
			e.printStackTrace();
			return;

		}

		Connection connection = null;

		try {

			connection = DriverManager.getConnection("jdbc:postgresql://cs1.calstatela.edu:5432/cs4222s15", "cs4222s15",
					"m:Vs2fkM");

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;

		}

		if (connection != null) {
			System.out.println("Connected to Database!\n");
		} else {
			System.out.println("Failed to make connection!\n");
		}
		Scanner reader = new Scanner(System.in);
		int input = -99;

		while (input != 0) {
			System.out.println("Commands: ");
			System.out.println("1. Add Musician ");
			System.out.println("2. Remove Musician ");
			System.out.println("3. Add Song");
			System.out.println("4. Remove Song ");
			System.out.println("5. Add Album ");
			System.out.println("6. Remove Album ");
			System.out.println("7. Print All Tables ");
			System.out.println("0. Exit ");

			System.out.print("Enter a number: ");
			input = reader.nextInt();
			
			System.out.println();

			if (input == 1) {
				addMusician(connection);

			} else if (input == 2) {
				deleteMusician(connection);

			} else if (input == 3) {
				addSong(connection);

			} else if (input == 4) {
				deleteSong(connection);

			} else if (input == 5) {
				addAlbum(connection);

			} else if (input == 6) {
				deleteAlbum(connection);

			} else if (input == 7) {
				printALL(connection);

			} else if (input == 0) {
				System.out.println("App is terminating! Goodbye!");
				break;
			} else {
				System.out.println("Invalid Command");
			}

		}

		connection.close();

	}

	public static void addMusician(Connection connection) throws SQLException {
	}

	public static void deleteMusician(Connection connection) throws SQLException {
	}

	public static void addSong(Connection connection) throws SQLException {
	}

	public static void deleteSong(Connection connection) throws SQLException {
	}

	public static void addAlbum(Connection connection) throws SQLException {
	}

	public static void deleteAlbum(Connection connection) throws SQLException {
	}

	public static void printALL(Connection connection) throws SQLException {

		Statement st = connection.createStatement();

		// print musicians
		System.out.println("---MUSICIANS---");
		ResultSet rsMusicians = st.executeQuery("SELECT * FROM Musician;");
		while (rsMusicians.next()) {
			System.out.println("SSN: " + rsMusicians.getString("ssn"));
			System.out.println("M_NAME: " + rsMusicians.getString("m_name"));
			System.out.println("HOUSE_ID: " + rsMusicians.getInt("house_id"));
			System.out.println();
		}
		rsMusicians.close();
		System.out.println("--------------");
		System.out.println("--------------");

		// print Instruments
		System.out.println("---INSTRUMENTS---");
		ResultSet rsIntrument = st.executeQuery("SELECT * FROM Instrument;");
		while (rsIntrument.next()) {
			System.out.println("INSTRUMENT_ID: " + rsIntrument.getInt("instrument_id"));
			System.out.println("NAME: " + rsIntrument.getString("name"));
			System.out.println("KEY: " + rsIntrument.getString("key"));
			System.out.println("USER_SSN: " + rsIntrument.getString("user_ssn"));
			System.out.println();

		}
		rsIntrument.close();
		System.out.println("--------------");
		System.out.println("--------------");

		// print Album
		System.out.println("---ALBUM---");
		ResultSet rsAlbum = st.executeQuery("SELECT * FROM Album;");
		while (rsAlbum.next()) {
			System.out.println("PRODUCER: " + rsAlbum.getString("producer"));
			System.out.println("ALBUM_ID: " + rsAlbum.getInt("album_id"));
			System.out.println("TITLE: " + rsAlbum.getString("title"));
			System.out.println("DATE: " + rsAlbum.getString("date"));
			System.out.println("FORMAT: " + rsAlbum.getString("format"));
			System.out.println("IDENTIFIER: " + rsAlbum.getString("identifier"));
			System.out.println();

		}
		rsAlbum.close();
		System.out.println("--------------");
		System.out.println("--------------");

		// print Songs
		System.out.println("---SONGS---");
		ResultSet rsSongs = st.executeQuery("SELECT * FROM Songs;");
		while (rsSongs.next()) {
			System.out.println("ALBUM_ID: " + rsSongs.getInt("album_id"));
			System.out.println("SONG_ID: " + rsSongs.getInt("song_id"));
			System.out.println("TITLE: " + rsSongs.getString("title"));
			System.out.println("AUTHOR: " + rsSongs.getString("author"));
			System.out.println();

		}
		rsAlbum.close();
		System.out.println("--------------");
		System.out.println("--------------");

		// print houses
		System.out.println("---HOUSES---");
		ResultSet rsHouse = st.executeQuery("SELECT * FROM House;");
		while (rsHouse.next()) {
			System.out.println("HOUSE_ID" + rsHouse.getInt("house_id"));
			System.out.println("ADDRESS: " + rsHouse.getString("address"));
			System.out.println("phone_number: " + rsHouse.getString("phone_number"));
			System.out.println();

		}
		rsHouse.close();
		System.out.println("--------------");
		System.out.println("--------------");

		// print performs
		System.out.println("---PERFORMS---");
		ResultSet rsPerforms = st.executeQuery("SELECT * FROM Performs;");
		while (rsPerforms.next()) {
			System.out.println("MUSICIAN_ID: " + rsPerforms.getString("musician_id"));
			System.out.println("SONG_ID: " + rsPerforms.getString("song_id"));
			System.out.println();

		}
		rsPerforms.close();
		System.out.println("--------------");
		System.out.println("--------------");

		st.close();

	}
}
