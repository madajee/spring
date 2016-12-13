package todos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import org.springframework.context.annotation.Bean;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.util.List;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	@Autowired
    PlaceHolderTodos placeHolderTodos;

    @Autowired
    TodosRepository  repository;

   //PlaceHolderTodos placeHolderTodos =  new PlaceHolderTodos();

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        log.info("********Start Logging From Main Method******");
        log.info("********Hello Spring Boot Seed******");
        log.info("********End Logging From Main Method********");
    }

    @Bean
    public CommandLineRunner run() throws Exception {
    	ResponseEntity<String> response = placeHolderTodos.downloadTodos();
    	String todos = response.getBody();

    	ObjectMapper mapper = new ObjectMapper();
    	List<Todos> todolist = mapper.readValue(todos,TypeFactory.defaultInstance().constructCollectionType(List.class, Todos.class));
    	
    	for (Todos todo: todolist){
			repository.save(todo);
			//log.info(todo.toString());
		}
    	return null;
    }


    public String convertToUpperCase (String str){
 	   return str.toUpperCase();
	}

	
}