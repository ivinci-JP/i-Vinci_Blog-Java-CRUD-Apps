package jp.co.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jp.co.model.UserDao;

/**
 * UserDeleteServlet_v1
 * 
 * このServletは、ユーザーの論理削除を行う処理を担当します。
 * ユーザーを論理削除した後、ユーザー一覧画面にリダイレクトします。
 */
@WebServlet("/userDelete_v1")
public class UserDeleteServlet_v1 extends HttpServlet {

	/**
	 * GETリクエストを処理します。
	 * 指定されたユーザー番号に基づいてユーザーを論理削除し、ユーザー一覧画面にリダイレクトします。
	 *
	 * @param request  HTTPリクエスト
	 * @param response HTTPレスポンス
	 * @throws ServletException サーブレットエラー
	 * @throws IOException      入出力エラー
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストからユーザー番号を取得
		int userNo = Integer.parseInt(request.getParameter("userNo"));

		// ユーザーの論理削除を行う
		UserDao.deleteUser_v1(userNo);

		// ユーザー一覧画面にリダイレクト
		response.sendRedirect(request.getContextPath() + "/user?action=list");
	}
}
