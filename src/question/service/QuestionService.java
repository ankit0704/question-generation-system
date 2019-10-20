package question.service;

import java.util.List;

import question.dao.QuestionDao;
import question.dto.QuestionDto;

public class QuestionService {
	
	private QuestionDao questionDao;

	public QuestionService() {
		questionDao = new QuestionDao();
	}

	public void create(QuestionDto question) {
		questionDao.create(question);
	}
    
	public void update(QuestionDto question) {
		questionDao.update(question);
	}

	public void delete(long questionId) {
		questionDao.delete(questionId);
	}

	public List<QuestionDto> getAllQuestion() {
		return questionDao.getAllQuestion();
	}
	
}
