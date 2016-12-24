package todos;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class InvalidTodoRequestException extends RuntimeException {

	public InvalidTodoRequestException(String id){
		super("Invalid Request ID: " + id);
	}
}