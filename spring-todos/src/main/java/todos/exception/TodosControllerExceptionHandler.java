package todos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.HttpStatus;
import javax.servlet.http.HttpServletRequest;


import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class TodosControllerExceptionHandler {

	private static final Logger log = LoggerFactory.getLogger(TodosControllerExceptionHandler.class);


	@ResponseStatus(HttpStatus.BAD_REQUEST) // 400
    @ResponseBody
    @ExceptionHandler(InvalidTodoRequestException.class)
    public String handleBadRequest(HttpServletRequest req) {
        log.error("Invalid Todo Request");
        //log.error(req.getRequestURL());
        String test = req.getRequestURL().toString();
        log.info(test);
        return "Invalid Todo Request";
    }

    @ResponseStatus(HttpStatus.NOT_FOUND) // 404
    @ResponseBody
    @ExceptionHandler(TodoNotFoundException.class)
    public String handleNotFound() {
        log.error("Resource not found");
        return "Resource not found";
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // 500
    @ExceptionHandler(Exception.class)
    public void handleGeneralError(Exception ex) {
        log.error("An error occurred procesing request", ex);
    }

}