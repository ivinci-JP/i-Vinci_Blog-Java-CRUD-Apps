package jp.co.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jp.co.model.UserDao;

/**
 * UserRestoreServlet
 * 
 * このServletは、論理削除された全てのユーザーを一括で復元する処理を行います。
 */
@WebServlet("/userRestore")
public class UserRestoreServlet extends HttpServlet {

	/**
	 * POSTリクエストを処理します。
	 * 論理削除された全てのユーザーを復元し、ユーザー一覧画面にリダイレクトします。
	 *
	 * @param request  HTTPリクエスト
	 * @param response HTTPレスポンス
	 * @throws ServletException サーブレットエラー
	 * @throws IOException      入出力エラー
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// UserDaoを使用して論理削除された全てのユーザーを復元
		UserDao.restoreAllDeletedUsers();

		// ユーザーリストを表示する画面にリダイレクト
		response.sendRedirect(request.getContextPath() + "/user?action=list");
	}
}
