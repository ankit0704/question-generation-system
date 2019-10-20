package question.dto;
import java.util.ArrayList;
import java.util.List;
import question.constants.QuestionType;

public class QuestionDto {
	
	private long id;
	private String question;
	private QuestionType questionType;
	private List<QuestionOption> options = new ArrayList<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public QuestionType getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String quesionType) {
		this.questionType=QuestionType.valueOf(quesionType);
	}

	public List<QuestionOption> getOptions() {
		return options;
	}

	public void setOptions(List<QuestionOption> options) {
		this.options = options;
	}
	
}
