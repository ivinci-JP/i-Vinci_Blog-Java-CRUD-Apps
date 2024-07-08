package jp.co.model;

import java.sql.Date;

/**
 * ユーザー情報を表すクラス。
 * このクラスはユーザーの基本情報と論理削除フラグを管理します。
 */
public class User {
	private int userNo;
	private int userId;
	private String userName;
	private int userPassword;
	private Date userBirthday;
	private Boolean deleteFlag;

	/**
	 * ユーザー情報を初期化するコンストラクタ。
	 *
	 * @param userNo ユーザー番号（ユニークな識別子）
	 * @param userId ユーザーID
	 * @param userName ユーザー名
	 * @param userPassword ユーザーパスワード（ハッシュ化されたもの）
	 * @param userBirthday ユーザーの生年月日
	 * @param deleteFlag 論理削除フラグ（trueの場合削除済み）
	 */
	public User(int userNo, int userId, String userName, int userPassword, Date userBirthday, Boolean deleteFlag) {
		this.userNo = userNo;
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userBirthday = userBirthday;
		this.deleteFlag = deleteFlag;
	}

	// ユーザー番号を取得します
	public int getUserNo() {
		return userNo;
	}

	// ユーザー番号を設定します
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	// ユーザーIDを取得します
	public int getUserId() {
		return userId;
	}

	// ユーザーIDを設定します
	public void setUserId(int userId) {
		this.userId = userId;
	}

	// ユーザー名を取得します
	public String getUserName() {
		return userName;
	}

	// ユーザー名を設定します
	public void setUserName(String userName) {
		this.userName = userName;
	}

	// ユーザーパスワードを取得します
	public int getUserPassword() {
		return userPassword;
	}

	// ユーザーパスワードを設定します
	public void setUserPassword(int userPassword) {
		this.userPassword = userPassword;
	}

	// ユーザーの生年月日を取得します
	public Date getUserBirthday() {
		return userBirthday;
	}

	// ユーザーの生年月日を設定します
	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}

	// 論理削除フラグを取得します
	public Boolean getDeleteFlag() {
		return deleteFlag;
	}

	// 論理削除フラグを設定します
	public void setDeleteFlag(Boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
}
