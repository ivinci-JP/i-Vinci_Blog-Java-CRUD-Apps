package jp.co.controller;

import java.io.IOException;
import java.sql.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jp.co.model.User;
import jp.co.model.UserDao;

/**
 * UserAddServlet
 * 
 * このServletは、新しいユーザーを追加する処理を担当します。
 * フォームから入力されたユーザー情報を受け取り、データベースに新しいユーザーを登録します。
 * ユーザーの追加後は、ユーザーリストを更新してユーザー一覧画面にリダイレクトします。
 */
@WebServlet("/userAdd")
public class UserAddServlet extends HttpServlet {

	/**
	 * POSTリクエストを処理します。
	 * フォームから入力されたユーザー情報を取得し、新しいユーザーをデータベースに追加します。
	 * 追加後はユーザーリストを更新して一覧画面にリダイレクトします。
	 *
	 * @param request  HTTPリクエスト
	 * @param response HTTPレスポンス
	 * @throws ServletException サーブレットエラー
	 * @throws IOException      入出力エラー
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// フォームからのデータを取得
		int userId = Integer.parseInt(request.getParameter("userId"));
		String userName = request.getParameter("userName");
		int userPassword = Integer.parseInt(request.getParameter("userPassword"));
		Date userBirthday = Date.valueOf(request.getParameter("userBirthday"));

		// 新しいUserオブジェクトを作成
		User newUser = new User(0, userId, userName, userPassword, userBirthday, false);

		// UserDaoを使ってデータベースに新しいユーザーを追加
		UserDao.addUser(newUser);

		// ユーザーリストを更新して一覧画面にリダイレクト
		response.sendRedirect(request.getContextPath() + "/user?action=list");
	}
}
