package question.dao;

import java.sql.Connection;

import common.DbConnectionService;
import question.dto.QuestionDto;

public class QuestionDao {
	private Connection con;
	public void create(QuestionDto questionDto) {
		con = DbConnectionService.getConnection();
		
	}
	public void update(QuestionDto questionDto) {
		con = DbConnectionService.getConnection();
		
	}
	
	public void delete(Long questionId) {
		con = DbConnectionService.getConnection();
		
	}
}
