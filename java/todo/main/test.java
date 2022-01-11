package todo.main;

import java.util.List;

import todo.dao.TodoDao;
import todo.dto.TodoDto;

public class test {
	public static void main(String[] args) {

		TodoDao dao = new TodoDao();
		
		List<TodoDto> list = dao.getTodos();

		for(TodoDto dto : list) {
			System.out.println(dto);
		}
	} 
}
