package jp.co.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * データベース接続を管理するクラス。
 * MySQLデータベースへの接続を確立するためのユーティリティクラスです。
 */
public class DatabaseConnector {
	private static final String url = "jdbc:mysql://localhost/tech_blog";
	private static final String username = "root";
	private static final String password = "";

	/**
	 * データベースへの接続を取得します。
	 *
	 * @return データベース接続オブジェクト
	 * @throws SQLException データベース接続に失敗した場合にスローされます
	 */
	public static Connection getConnection() throws SQLException {
		try {
			// MySQLドライバの読み込み
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new SQLException("MySQLドライバの読み込みに失敗しました", e);
		}

		// データベース接続を確立し、接続オブジェクトを返す
		return DriverManager.getConnection(url, username, password);
	}
}
