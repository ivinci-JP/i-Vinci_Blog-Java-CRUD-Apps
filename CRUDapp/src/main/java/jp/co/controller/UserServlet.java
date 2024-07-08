package jp.co.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jp.co.model.User;
import jp.co.model.UserDao;

/**
 * ユーザーに関する処理を行うServletクラス
 * ユーザーのログイン処理およびユーザー一覧の表示を行います。
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {

	/**
	 * POSTリクエストを処理します。
	 * 主にログイン処理を行い、成功時にはユーザー一覧を表示します。
	 *
	 * @param request  HTTPリクエスト
	 * @param response HTTPレスポンス
	 * @throws ServletException サーブレットエラー
	 * @throws IOException      入出力エラー
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if ("login".equals(action)) {
			// TODO ユーザー認証のチェックなど

			// ログイン成功時にユーザーリストを取得して一覧画面に表示
			List<User> userList = UserDao.getAllUsers();
			request.setAttribute("userList", userList);
			request.getRequestDispatcher("/userList.jsp").forward(request, response);
		} else {
			// ログイン画面にリダイレクト
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		}
	}

	/**
	 * GETリクエストを処理します。
	 * 主にユーザー一覧の表示を行います。
	 *
	 * @param request  HTTPリクエスト
	 * @param response HTTPレスポンス
	 * @throws ServletException サーブレットエラー
	 * @throws IOException      入出力エラー
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if ("list".equals(action)) {
			// ユーザーリストを取得して一覧画面に表示
			List<User> userList = UserDao.getAllUsers();
			request.setAttribute("userList", userList);
			request.getRequestDispatcher("/userList.jsp").forward(request, response);
		} else {
			// デフォルトの動作（特に何もしない）
		}
	}
}
