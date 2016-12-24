package todos;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Before;
import org.springframework.test.context.junit4.SpringRunner;

//import org.springframework.test.context.ContextConfiguration;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders; 

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations; 
import org.mockito.Mock; 

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = {AppConfig.class})
public class TodosControllerStandAloneTest{

	private MockMvc mockMvc; 

	@InjectMocks 
    private TodosController todosController;

    @Mock
    private TodosService todosService;

	@Before
	public void setUp() throws Exception {
		System.out.println("Hello");
		MockitoAnnotations.initMocks(this); 
        mockMvc = MockMvcBuilders.standaloneSetup(todosController).build(); 
	}

	@Test
    public void testHello(){
    	System.out.println("Hello");
    }

    @Test
    public void testGetTodoById() throws Exception{
    	System.out.println("Hello");
    	Todos todo1 = new Todos ("1","userId1","title1","false");
    	when(todosService.getTodoById("1")).thenReturn(todo1);
    	//this.mockMvc.perform(get("/todos/1")).andDo(print()).andExpect(status().is(200));
    	 	//.andExpect(content().string(containsString("userId1")));
    	this.mockMvc.perform(get("/todos/1")).andDo(print()).andExpect(status().isOk())
    	 	.andExpect(content().string(containsString("userId1")));
    }





}