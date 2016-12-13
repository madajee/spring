package todos;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PlaceHolderTodosTest{
	
    @Test
    public void todosShouldHaveMessage() {


    	PlaceHolderTodos placeHolderTodos = new PlaceHolderTodos();
    	ResponseEntity<String> response;
	    response = placeHolderTodos.downloadTodos();
	    assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
	}

}