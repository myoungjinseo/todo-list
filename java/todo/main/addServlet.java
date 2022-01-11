package todo.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.dto.TodoDto;

import todo.dao.TodoDao;
import todo.dto.TodoDto;


/**
 * Servlet implementation class addServlet
 */
@WebServlet("/add")
public class addServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		TodoDto dto = new TodoDto();
		TodoDao dao = new TodoDao();
		String title = request.getParameter("title");
		String name = request.getParameter("name");
		int sequence = Integer.parseInt(request.getParameter("sequence"));
		dto.setTitle(title);
		dto.setName(name);
		dto.setSequence(sequence);
		dao.addTodo(dto);
		
		response.sendRedirect("./MainServlet");
		
	}

}
