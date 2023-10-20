package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		// データベースのURL
		final String url = "jdbc:postgresql://localhost:5432/study1";
		// データベースにアクセスするユーザー情報
		final String user = "postgres";
		final String pass = "bigtree10";
		
		Class.forName("org.postgresql.Driver");
		// データベースへ接続する
		Connection con = DriverManager.getConnection(url, user, pass);
		return con;
	}
}
