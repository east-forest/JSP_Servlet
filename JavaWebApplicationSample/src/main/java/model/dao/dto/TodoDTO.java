package model.dao.dto;

import java.sql.Date;

/**
 * TODOを保持するクラス
 * 
 */
public class TodoDTO {
	private int id;
	private String todo;
	private Date timeLimit;
	
	/**
     * 引数なしコンストラクタ
     * 初期化を行う
     */
    public TodoDTO () {
        id = 0;
        todo = "";
        timeLimit = new Date(System.currentTimeMillis());
    }
    
    /**
     * 受け取った引数によって初期化を行う
     * @param id
     * @param todo
     * @param timeLimit2
     */
    public TodoDTO(int id, String todo, Date timeLimit) {
    	this.id = id;
    	this.todo = todo;
    	this.timeLimit = timeLimit;
    }
    
    public int getId() {
    	return id;
    }
    
    public void setId(int id) {
    	this.id = id;
    }
    
    public String getTodo() {
    	return todo;
    }
    
    public void setTodo(String todo) {
    	this.todo = todo;
    }
    
    public Date getTimeLimit() {
    	return timeLimit;
    }
    
    public void setTimeLimit(Date timeLimit) {
    	this.timeLimit = timeLimit;
    }
}
