package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	private static DBConnector connector;
	
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String host = "localhost";
	private String port = "3306";
	private String user = "root";
	private String password = "root";
	private String db = "tpsysacad";
	private int connected = 0;
	private Connection connection = null;
	
	
	private DBConnector() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public static DBConnector getInstancia() {
		if (connector == null) {
			connector = new DBConnector();
		}
		return connector;
	}
	
	
	public static DBConnector getConnector() {
		if(connector == null) {
			connector = new DBConnector();
		}
		
		return connector;
	}
	
	
	public Connection getConnection() {
		try {
			if(connection == null || connection.isClosed()) {
				connection = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+db, user, password);
				connected = 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		connected++;
		return connection;
	}
	
	public void releaseConnection() {
		connected--;
		try {
			if(connected <= 0) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
