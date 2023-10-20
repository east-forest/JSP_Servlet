package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.DBConnection;
import model.dao.dto.TodoDTO;

public class UpdateDAO {
	/**
	 * idを元にデータベースからtodo情報を取得する
	 * @param id
	 * @return todo
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public TodoDTO getTodo(int id) throws SQLException, ClassNotFoundException {
		// 取得したtodoを格納する変数
		TodoDTO todo = new TodoDTO();
		
		// IDを指定してtodoを取得するsql
		String sql = "SELECT id, todo, timeLimit FROM todo WHERE id = ?";
		
		try(Connection con = DBConnection.getConnection();
				PreparedStatement psmst = con.prepareStatement(sql)) {
			psmst.setInt(1, id);
			
			ResultSet rs = psmst.executeQuery();
			
			while(rs.next()) {
				todo.setId(rs.getInt("id"));
				todo.setTodo(rs.getString("todo"));
				todo.setTimeLimit(rs.getDate("timeLimit"));
			}
		} 
		return todo;
	}
	
	/**
	 * Todoデータを更新する
	 * @param id 
	 * @param todo
	 * @param timeLimit
	 * @return 更新行数
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int updateTodo(int id,String todo, Date timeLimit) throws SQLException, ClassNotFoundException {
		// 変更した行数を返却するための変数
		int processingNumber = 0;
		
		// SQLを作成
		String sql = "UPDATE todo SET todo = ?, timeLimit = ? WHERE id = ?";
		
		try(Connection con = DBConnection.getConnection();
				PreparedStatement psmst = con.prepareStatement(sql)) {
			psmst.setString(1, todo);
			psmst.setDate(2, timeLimit);
			psmst.setInt(3, id);
			
			// SQLを実行する
			processingNumber = psmst.executeUpdate();
		}
		return processingNumber;
	}
}
