package org.diligentsnail.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	public static void main(String[] args) throws SQLException {
		// JDBC?
		// SELECT 1 from SYSIBM.SYSDUMMY1;
		// Embedded
		try (Connection connection =
					 DriverManager.getConnection("jdbc:derby:memory:sample;create=true");
			 Statement statement = connection.createStatement()) {
			try (ResultSet resultSet = statement.executeQuery("SELECT 1 FROM SYSIBM.SYSDUMMY1")) {
				System.out.println("resultSet.next() = " + resultSet.next());
				int i = resultSet.getInt(1);
				System.out.println(i);
			}
		}
	}
}
