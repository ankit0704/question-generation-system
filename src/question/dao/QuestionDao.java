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
import question.dto.QuestionOption;

public class QuestionDao {
	private QuestionOptionDao questionOptionDao;

	public QuestionDao() {
		this.questionOptionDao = new QuestionOptionDao();
	}

	public void create(QuestionDto questionDto) {

		try {
			Connection con = DbConnectionService.getConnection();
			String sql = "insert into question(question,type) values(?,?)";
			PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, questionDto.getQuestion());
			ps.setString(2, questionDto.getQuestionType().name());

			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				int questionId = rs.getInt(1);
				questionOptionDao.addOptions(questionDto.getOptions(), questionId);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(QuestionDto questionDto) {
		try {
			Connection con = DbConnectionService.getConnection();
			String sql = "update question set question=?,type=? where id=?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, questionDto.getQuestion());
			ps.setString(2, questionDto.getQuestionType().name());
			ps.setLong(3, questionDto.getId());
			ps.executeUpdate();
			questionOptionDao.deleteOptions(questionDto.getId());
			questionOptionDao.addOptions(questionDto.getOptions(), questionDto.getId());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(long questionId) {

		try {
			Connection con = DbConnectionService.getConnection();
			String sql = "delete from question where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, questionId);
			ps.executeUpdate();
			questionOptionDao.deleteOptions(questionId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<QuestionDto> getAllQuestion() {

		List<QuestionDto> list = new ArrayList<QuestionDto>();
		try {
			Connection con = DbConnectionService.getConnection();
			String sql = "select question,type,id from question";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				QuestionDto questionDto = new QuestionDto();
				questionDto.setQuestion(rs.getString(1));
				questionDto.setQuestionType(rs.getString(2));
				questionDto.setId(rs.getLong(3));
				list.add(questionDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public QuestionDto findById(long questionId) {
		
		QuestionDto questionDto = new QuestionDto();
		List<QuestionOption> questionOptions= new ArrayList();
		try {
			Connection con = DbConnectionService.getConnection();
			String sql = "select question,type from question where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1,questionId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				questionDto.setQuestion(rs.getString(1));
				questionDto.setQuestionType(rs.getString(2));
			}
			
			String sql2 = "select option,is_right from question_option where qid=?";
			PreparedStatement ps2=con.prepareStatement(sql2);
			ps2.setLong(1, questionId);
			ResultSet rs1=ps2.executeQuery();
			
			while(rs1.next()) {
				System.out.println("rs1.getString(1) "+rs1.getString(1));
				System.out.println("rs1.getByte(2) "+rs1.getByte(2));
				QuestionOption questionOption =new QuestionOption();
				questionOption.setOption(rs1.getString(1));
				questionOption.setCorrect(rs1.getByte(2));
				questionOptions.add(questionOption);
			}
			questionDto.setOptions(questionOptions);
			
			
		} catch (SQLException e) {
           e.printStackTrace();
			System.out.println(e);
		}

		return questionDto;
	}
}
