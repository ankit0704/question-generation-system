package question.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.DbConnectionService;
import question.dto.QuestionDto;

public class QuestionDao {
			private QuestionOptionDao questionOptionDao;
			public QuestionDao() {
				this.questionOptionDao= new QuestionOptionDao();
			}
    	    public void create(QuestionDto questionDto){
			try {
			Connection con = DbConnectionService.getConnection();
			String sql="insert into question(question,type) values(?,?)";
			PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1,questionDto.getQuestion());
			ps.setString(2,questionDto.getQuestionType().name());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()) {
            int questionId =rs.getInt(1);
            questionOptionDao.addOptions(questionDto.getOptions(), questionId);
            }
            
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	     public void update(QuestionDto questionDto) {
		  try {
			Connection con= DbConnectionService.getConnection();
			String sql="update question set question=?,type=? where id=?";
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setLong(1,questionDto.getId());
		   ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(long questionId) {
		
		try {
			Connection con = DbConnectionService.getConnection();
			String sql="delete from question where id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setLong(1,questionId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<QuestionDto> getAllQuestion(){
		
		List<QuestionDto> list = new ArrayList<QuestionDto>();
		try {
       		Connection con=DbConnectionService.getConnection();
    		String sql="select question,type,id from question";            
			PreparedStatement ps= con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
 			while(rs.next()) {
			QuestionDto questionDto= new QuestionDto();
			questionDto.setQuestion(rs.getString(1));
			questionDto.setQuestionType(rs.getString(2));
			questionDto.setId(rs.getLong(3));
			list.add(questionDto);
		}
		}catch (SQLException e) {
			e.printStackTrace();
		}
        return list;
	}
}
