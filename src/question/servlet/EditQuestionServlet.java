package question.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import question.dto.QuestionDto;
import question.service.QuestionService;

@WebServlet("/question/edit")
public class EditQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	long questionId;
	private QuestionService questionsService;
	public void init() {
		questionsService = new QuestionService();
	}

	
	public void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long questionId=Long.parseLong(request.getParameter("questionId"));
		QuestionDto questionDto= new QuestionDto();
		questionsService.update(questionDto);
	}

}
