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
 * UserEditServlet
 * 
 * このServletは、ユーザー情報の編集を行う処理を担当します。
 * ユーザー情報の表示と更新を行います。
 */
@WebServlet("/userEdit")
public class UserEditServlet extends HttpServlet {

	/**
	 * GETリクエストを処理します。
	 * 指定されたユーザーIDに基づいてユーザー情報を取得し、編集画面に転送します。
	 *
	 * @param request  HTTPリクエスト
	 * @param response HTTPレスポンス
	 * @throws ServletException サーブレットエラー
	 * @throws IOException      入出力エラー
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストからユーザーIDを取得
		int userId = Integer.parseInt(request.getParameter("userId"));

		// ユーザーIDに基づいてユーザー情報を取得
		User userToEdit = UserDao.getUserById(userId);

		// ユーザー情報をリクエストに設定し、編集画面に転送
		request.setAttribute("userToEdit", userToEdit);
		request.getRequestDispatcher("/userEdit.jsp").forward(request, response);
	}

	/**
	 * POSTリクエストを処理します。
	 * フォームから送信されたユーザー情報を基にユーザー情報を更新し、ユーザー一覧画面にリダイレクトします。
	 *
	 * @param request  HTTPリクエスト
	 * @param response HTTPレスポンス
	 * @throws ServletException サーブレットエラー
	 * @throws IOException      入出力エラー
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// フォームから送信されたデータを取得
		int userId = Integer.parseInt(request.getParameter("userId"));
		String userName = request.getParameter("userName");
		int userPassword = Integer.parseInt(request.getParameter("userPassword"));
		Date userBirthday = Date.valueOf(request.getParameter("userBirthday"));
		Boolean deleteFlag = false; // 初期値はfalseとする

		// 取得したデータを基にUserオブジェクトを作成
		User editedUser = new User(0, userId, userName, userPassword, userBirthday, deleteFlag);

		// ユーザー情報を更新
		UserDao.updateUser(editedUser);

		// ユーザー一覧画面にリダイレクト
		response.sendRedirect(request.getContextPath() + "/user?action=list");
	}
}
