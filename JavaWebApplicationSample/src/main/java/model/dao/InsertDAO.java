package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.DBConnection;

/**
 * Todoをデータベースに登録する
 */
public class InsertDAO {
	
	/**
	 * Todoをデータベースに登録する
	 * 
	 * @param todoの内容
	 * @param 期限
	 * @return 登録数
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int insertTodo(String todo, Date timeLimit) throws ClassNotFoundException, SQLException {
		// 更新した行数を返却するための変数
		int processingNumber = 0;
		
		// 実行SQL
		String sql = "INSERT INTO todo(todo, timeLimit) VALUES (?, ?)";
		
		// SQL実行
		try(Connection con = DBConnection.getConnection();
				PreparedStatement psmst = con.prepareStatement(sql)) {
			// パラメータに値を設定する
			// 1つ目のパラメータにtodoの内容を設定
			psmst.setString(1, todo);
			// 2つ目のパラメータにtimeLimitの内容を設定
			psmst.setDate(2, timeLimit);
			// SQLを実行し、実行行数を受け取る
			processingNumber = psmst.executeUpdate();
		}
		
		return processingNumber;
	}

}
