package todos;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Before;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TodosControllerWebContextTest{

	@Autowired
    private TodosController controller;

    @Autowired
    TodosRepository  repository;

    @Autowired
    private MockMvc mockMvc;


	/*@Test
    public void contextLoads() throws Exception {

    	//assertThat(controller).isNotNull();
    	System.out.println("Hello");
    }*/

    @Before
	public void setUp() throws Exception {
    	Todos todo1 = new Todos ("1","userId1","title1","false");
    	repository.save(todo1);

	}

    @Test
    public void testHello(){
    	System.out.println("Hello");
    }

    @Test
    public void testGetTodoById() throws Exception{
    	System.out.println("Hello");

    	 this.mockMvc.perform(get("/todos/1")).andDo(print()).andExpect(status().isOk())
    	 	.andExpect(content().string(containsString("userId1")));
    }
}