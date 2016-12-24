package todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TodosService {

	@Autowired
	private TodosRepository repository;

	public Todos getTodoById(String id){
		System.out.println("hello");
		Todos todo = repository.findOne(id);
		return todo;
	}
}