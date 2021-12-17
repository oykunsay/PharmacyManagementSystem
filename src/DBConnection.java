import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;

	static final String JDBC_DRIVER = "org.h2.Driver";
	static final String DB_URL = "jdbc:h2:tcp://localhost/~/pharmacy";
	static final String USER = "root";
	static final String PASS = "1234";

	public Connection connDb() throws ClassNotFoundException {
		try {
			Class.forName(JDBC_DRIVER);

			// System.out.println("Connecting to database!");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// System.out.println("Creating table in given database...");

			DatabaseMetaData dbm = conn.getMetaData();
			ResultSet tables = dbm.getTables(null, null, "MEDICINES", null);
			if (tables.next()) {
				System.out.println("Database is ready to use!");
			} else {
				st = conn.createStatement();
				String sql = "CREATE TABLE MEDICINES " + "(id INTEGER not NULL, " + " name VARCHAR(255), "
						+ " price VARCHAR(255), " + " quantity INTEGER, " + " fab_date VARCHAR(255), "
						+ " exp_date VARCHAR(255), " + " company VARCHAR(255), " + " PRIMARY KEY ( id ))";
				st.executeUpdate(sql);
				// System.out.println("Created table in given database!");
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}

		try {
			Class.forName(JDBC_DRIVER);

//			System.out.println("Connecting to database!");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

//			System.out.println("Creating table in given database...");

			DatabaseMetaData dbm = conn.getMetaData();
			ResultSet tables = dbm.getTables(null, null, "AGENTS", null);
			if (tables.next()) {
				System.out.println("Database is ready to use!");
			} else {
				st = conn.createStatement();
				String sql = "CREATE TABLE AGENTS " + "(id INTEGER not NULL, " + " name VARCHAR(255), "
						+ " age INTEGER, " + " phone VARCHAR(225), " + " password VARCHAR(255), "
						+ " gender VARCHAR(255), " + " PRIMARY KEY ( id ))";
				st.executeUpdate(sql);
				// System.out.println("Created table in given database!");
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}

		try {
			Class.forName(JDBC_DRIVER);

			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			DatabaseMetaData dbm = conn.getMetaData();
			ResultSet tables = dbm.getTables(null, null, "COMPANY", null);
			if (tables.next()) {
				System.out.println("Database is ready to use!");
			} else {
				st = conn.createStatement();
				String sql = "CREATE TABLE COMPANY " + "(id INTEGER not NULL, " + " name VARCHAR(255), "
						+ " address VARCHAR(225), " + " experience VARCHAR(225), " + " phone VARCHAR(225), "
						+ " PRIMARY KEY ( id ))";
				st.executeUpdate(sql);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return conn;
	}
}
