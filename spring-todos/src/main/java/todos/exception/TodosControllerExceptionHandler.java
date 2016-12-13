package todos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class TodosControllerExceptionHandler {

	private static final Logger log = LoggerFactory.getLogger(TodosControllerExceptionHandler.class);

	@ResponseStatus(HttpStatus.BAD_REQUEST) // 400
    @ExceptionHandler(InvalidTodoRequestException.class)
    public void handleBadRequest() {
        log.error("Invalid Todo Request");
    }

    @ResponseStatus(HttpStatus.NOT_FOUND) // 404
    @ExceptionHandler(TodoNotFoundException.class)
    public void handleNotFound() {
        log.error("Resource not found");
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // 500
    @ExceptionHandler(Exception.class)
    public void handleGeneralError(Exception ex) {
        log.error("An error occurred procesing request", ex);
    }

}