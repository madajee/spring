package todos;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class TodosController {

	//@Autowired
	//private TodosRepository repository;

    @Autowired
    private TodosService service;

   /* private final TodosService service;

    public TodosController(TodosService service) {
        this.service = service;
    }*/


	@RequestMapping(value = "/todos/{id}", method = RequestMethod.GET)
    public Todos getTodoById(@PathVariable("id") String id) {
  		
  		//System.out.println(id);
        /* validate customer Id parameter */
        if (id.equals("0")) {
        	//System.out.println("Hello Exception");
            throw new InvalidTodoRequestException(id);
        }
  
        //Todos todo = repository.findOne(id);

        Todos todo = service.getTodoById(id);

        if(null==todo){
            throw new TodoNotFoundException();
            
        }
  
  
        return todo;
    }
}