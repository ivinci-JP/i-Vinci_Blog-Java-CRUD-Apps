package jp.co.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jp.co.model.UserDao;

/**
 * UserDeleteServlet
 * 
 * このServletは、ユーザーの物理削除を行う処理を担当します。
 * ユーザーを削除した後、ユーザー一覧画面にリダイレクトします。
 */
@WebServlet("/userDelete")
public class UserDeleteServlet extends HttpServlet {

	/**
	 * GETリクエストを処理します。
	 * 指定されたユーザーIDに基づいてユーザーを物理削除し、ユーザー一覧画面にリダイレクトします。
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

		// ユーザーの物理削除を行う
		UserDao.deleteUser(userId);

		// ユーザー一覧画面にリダイレクト
		response.sendRedirect(request.getContextPath() + "/user?action=list");
	}
}
