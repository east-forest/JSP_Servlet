package servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import constant.Parameters;
import model.dao.InsertDAO;

/**
 * Servlet implementation class InputServlet
 */
//↓ここの設定。これで「insert-servlet」にリクエストが送られた時にInsertServletが実行される
@WebServlet("/insert-servlet")
public class InsertServlet extends HttpServlet {       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// リクエストパラメータのname属性がtodoの値を受け取る
		String todo = (String)request.getParameter(Parameters.TODO);
		// リクエストパラメータのname属性がtimeLimitの値を受け取る
		Date timeLimit = Date.valueOf(request.getParameter(Parameters.TIME_LIMIT));
				
		InsertDAO dao = new InsertDAO();
		try {
			dao.insertTodo(todo, timeLimit);
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		response.sendRedirect("list-servlet");
	}
}
