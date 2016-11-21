package application;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

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
			System.out.println("Connected to Database!");
		} else {
			System.out.println("Failed to make connection!");
		}
		// printALL(connection);

		connection.close();

	}

	public static void printALL(Connection connection) throws SQLException {

		Statement st = connection.createStatement();

		// print musicians
		System.out.println("---MUSICIANS---");
		ResultSet rsMusicians = st.executeQuery("SELECT * FROM Musicians;");
		while (rsMusicians.next()) {
			System.out.println("SSN: " + rsMusicians.getString("ssn"));
			System.out.println("NAME: " + rsMusicians.getString("name"));
			System.out.println("HOUSE_ID: " + rsMusicians.getString("house_id"));
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
			System.out.println("TITLE: " + rsIntrument.getString("name"));
			System.out.println("DATE: " + rsIntrument.getString("key"));
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

		}
		rsAlbum.close();
		System.out.println("--------------");
		System.out.println("--------------");

		// print Songs
		System.out.println("---SONGS---");
		ResultSet rsSongs = st.executeQuery("SELECT * FROM Album;");
		while (rsSongs.next()) {
			System.out.println("ALBUM_ID: " + rsSongs.getInt("album_id"));
			System.out.println("SONG_ID: " + rsSongs.getInt("song_id"));
			System.out.println("TITLE: " + rsSongs.getString("title"));
			System.out.println("AUTHOR: " + rsSongs.getString("author"));

		}
		rsAlbum.close();
		System.out.println("--------------");
		System.out.println("--------------");

		// print houses
		System.out.println("---HOUSES---");
		ResultSet rsHouse = st.executeQuery("SELECT * FROM House;");
		while (rsHouse.next()) {
			System.out.println("HOUSE_ID" + rsHouse.getString("house_id"));
			System.out.println("ADDRESS: " + rsHouse.getString("address"));
			System.out.println("phone_number: " + rsHouse.getString("phone_number"));

		}
		rsHouse.close();
		System.out.println("--------------");
		System.out.println("--------------");
		
		
		// print performs
		System.out.println("---PERFORMS---");
		ResultSet rsPerforms = st.executeQuery("SELECT * FROM Performs;");
		while (rsPerforms.next()) {
			System.out.println("MUSICIAN_ID" + rsPerforms.getString("musician_id"));
			System.out.println("SONG_ID" + rsPerforms.getString("song_id"));
		}
		rsPerforms.close();
		System.out.println("--------------");
		System.out.println("--------------");


		st.close();

	}
}
