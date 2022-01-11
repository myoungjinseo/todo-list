package todo.main;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.dao.*;
import todo.dto.*;

@WebServlet("/MainServlet")
public class mainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TodoDao todoDao = null;

	public mainServlet() {
		super();
		todoDao = new TodoDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<TodoDto> todoList = todoDao.getTodos();
		request.setAttribute("todoList", todoList);

		String[] todoTypes = { "TODO", "DOING", "DONE" };
		request.setAttribute("todoTypes", todoTypes);

		RequestDispatcher requestDispatehcer = request.getRequestDispatcher("main.jsp");
		requestDispatehcer.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}