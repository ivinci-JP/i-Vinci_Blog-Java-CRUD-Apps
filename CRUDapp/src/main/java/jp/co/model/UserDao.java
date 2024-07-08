package jp.co.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * UserデータのCRUD（Create, Read, Update, Delete）操作を行うDAO（Data Access Object）クラス
 */
public class UserDao {

	/**
	 * 全ユーザーのリストを取得します（論理削除されていないユーザーのみ）。
	 *
	 * @return ユーザーのリスト
	 */
	public static List<User> getAllUsers() {
		List<User> userList = new ArrayList<>();
		try (Connection connection = DatabaseConnector.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("SELECT * FROM r_user WHERE DELETE_FLAG = 0");
				ResultSet resultSet = preparedStatement.executeQuery()) {

			while (resultSet.next()) {
				User user = new User(
						resultSet.getInt("USER_NO"),
						resultSet.getInt("USER_ID"),
						resultSet.getString("USER_NAME"),
						resultSet.getInt("USER_PASSWD"),
						resultSet.getDate("USER_BIRTHDAY"),
						resultSet.getBoolean("DELETE_FLAG"));
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	/**
	 * 新しいユーザーを追加します。
	 *
	 * @param user 追加するユーザーの情報
	 */
	public static void addUser(User user) {
		try (Connection connection = DatabaseConnector.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(
						"INSERT INTO r_user (USER_ID, USER_NAME, USER_PASSWD, USER_BIRTHDAY) VALUES (?, ?, ?, ?)")) {

			preparedStatement.setInt(1, user.getUserId());
			preparedStatement.setString(2, user.getUserName());
			preparedStatement.setInt(3, user.getUserPassword());
			preparedStatement.setDate(4, user.getUserBirthday());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 指定したユーザーIDに対応するユーザー情報を取得します。
	 *
	 * @param userId 取得するユーザーのID
	 * @return 指定したユーザーIDに対応するユーザー情報
	 */
	public static User getUserById(int userId) {
		User user = null;
		try (Connection connection = DatabaseConnector.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("SELECT * FROM r_user WHERE USER_ID = ?")) {

			preparedStatement.setInt(1, userId);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					user = new User(
							resultSet.getInt("USER_NO"),
							resultSet.getInt("USER_ID"),
							resultSet.getString("USER_NAME"),
							resultSet.getInt("USER_PASSWD"),
							resultSet.getDate("USER_BIRTHDAY"),
							resultSet.getBoolean("DELETE_FLAG"));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	/**
	 * ユーザー情報を更新します。
	 *
	 * @param user 更新するユーザーの情報
	 */
	public static void updateUser(User user) {
		try (Connection connection = DatabaseConnector.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(
						"UPDATE r_user SET USER_NAME = ?, USER_PASSWD = ?, USER_BIRTHDAY = ? WHERE USER_ID = ?")) {

			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setInt(2, user.getUserPassword());
			preparedStatement.setDate(3, user.getUserBirthday());
			preparedStatement.setInt(4, user.getUserId());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ユーザーを物理削除します。
	 *
	 * @param userId 削除するユーザーのID
	 */
	public static void deleteUser(int userId) {
		try (Connection connection = DatabaseConnector.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("DELETE FROM r_user WHERE USER_ID = ?")) {

			preparedStatement.setInt(1, userId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ユーザーを論理削除します（DELETE_FLAGをtrueに設定）。
	 *
	 * @param userNo 論理削除するユーザーの番号
	 */
	public static void deleteUser_v1(int userNo) {
		try (Connection connection = DatabaseConnector.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(
						"UPDATE `r_user` SET `DELETE_FLAG` = true WHERE `USER_NO` = ?")) {

			preparedStatement.setInt(1, userNo);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 論理削除された全てのユーザーを復元します（DELETE_FLAGをfalseに設定）。
	 */
	public static void restoreAllDeletedUsers() {
		try (Connection connection = DatabaseConnector.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(
						"UPDATE `r_user` SET `DELETE_FLAG` = false WHERE `DELETE_FLAG` = true")) {

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
