package org.diligentsnail.jdbc;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JdbcTest {

	@BeforeAll
	void createTable() throws SQLException {
		try (Connection connection = getConnection();
			 Statement statement = connection.createStatement()) {
			statement.executeUpdate("""
					CREATE TABLE songs
					(
						id           BIGINT       NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY,
						title        VARCHAR(512) NOT NULL,
						artist       VARCHAR(512) NOT NULL,
						UNIQUE (title, artist)
					)
					""");
		}
	}

	@Test
	@Order(0)
	void noRecords() throws SQLException {
		// SELECT COUNT(*) FROM songs;
		// 1. Connection
		try (Connection connection = getConnection();
			 Statement statement = connection.createStatement()) {
			try (ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM songs")) {
				assertTrue(resultSet.next());
				assertEquals(0, resultSet.getInt(1));
			}
		}
	}

	@Test
	@Order(1)
	void insertSong() throws SQLException {
		// ('Blinding Lights', 'The Weeknd', 'canadian contemporary r&b', 2020),
		try (Connection connection = getConnection();
			 Statement statement = connection.createStatement()) {
			String sql = "INSERT INTO songs(title, artist) VALUES ('Blinding Lights', 'The Weeknd')";
			int rowsAffected = statement.executeUpdate(sql);

			assertEquals(1, rowsAffected);
		}
	}

	@Test
	@Order(2)
	void songFound() throws SQLException {
		try (Connection connection = getConnection();
			 Statement statement = connection.createStatement()) {
			String sql = "SELECT * FROM SONGS where id = 1";
			try (ResultSet resultSet = statement.executeQuery(sql)) {
				assertTrue(resultSet.next());

				assertEquals("Blinding Lights", resultSet.getString("title"));
			}
		}
	}

	@Test
	@Order(3)
	void oneMoreSongInserted() throws SQLException {
		try (Connection connection = getConnection();
			 PreparedStatement statement = connection.prepareStatement(
					 "INSERT INTO songs(title, artist) VALUES (?, ?)")) {
			// ('Something Just Like This', 'The Chainsmokers', 'dance pop', 2017),
			statement.setString(1, "Something Just Like This");
			statement.setString(2, "The Chainsmokers");

			int rowsAffected = statement.executeUpdate();
			assertEquals(1, rowsAffected);
		}
	}

	@Test
	@Order(4)
	void yetAnotherSongInserted() throws SQLException {
		try (Connection connection = getConnection();
			 PreparedStatement statement = connection.prepareStatement(
					 "INSERT INTO songs(title, artist) VALUES (?, ?)",
					 Statement.RETURN_GENERATED_KEYS)
		) {
			// ('Something Just Like This', 'The Chainsmokers', 'dance pop', 2017),
			// 	   ('Photograph', 'Ed Sheeran', 'pop', 2014),
			statement.setString(1, "Photograph");
			statement.setString(2, "Ed Sheeran");

			int rowsAffected = statement.executeUpdate();
			assertEquals(1, rowsAffected);

			try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
				assertTrue(generatedKeys.next());
				long id = generatedKeys.getLong(1);
				assertThat(id).isGreaterThan(0);
			}
		}
	}

	@Test
	@Order(5)
	void songsFound() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:derby:memory:sample;create=true");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		List<Song> songs = jdbcTemplate.query("SELECT * FROM songs", (rs, rowNum) -> {
			Song song = new Song();
			song.setId(rs.getLong("id"));
			song.setArtist(rs.getString("artist"));
			song.setTitle(rs.getString("title"));
			return song;
		});

		System.out.println(songs);

		assertThat(songs).isNotEmpty();
	}

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(
				"jdbc:derby:memory:sample;create=true");
	}


	// В 13:00 начнём
}
