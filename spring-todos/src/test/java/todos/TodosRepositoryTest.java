package todos;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.springframework.beans.factory.annotation.Autowired;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class TodosRepositoryTest {

	@Autowired
    TodosRepository  repository;

    @Test
    public void testTodo() {
    	Todos todo = new Todos();
    	todo.setUserId("userId1");
    	todo.setTitle("title1");
    	todo.setCompleted("false");
    	
    	assertNull(todo.getId());
    	todo =  repository.save(todo);
 
        assertNotNull(todo.getId());
        assertEquals(todo.getTitle(), "title1");
        //assertTrue(todo.getId() > 0);
    }

}