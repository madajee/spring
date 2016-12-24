package todos;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Before;
import static org.junit.Assert.assertNotNull;



@RunWith(SpringRunner.class)
@SpringBootTest
//@ContextConfiguration(classes = {AppConfig.class})
public class TodosServiceTest {

	@Autowired
    private TodosService todoService;

    @Autowired
	private TodosRepository repository;

	@Before
	public void setUp() throws Exception {
    	Todos todo1 = new Todos ("1","userId1","title1","false");
    	repository.save(todo1);
	}

	@Test
    public void testGetTodoById() throws Exception {
    	Todos todo = todoService.getTodoById("1");
    	assertNotNull(todo.getId());
    }

}