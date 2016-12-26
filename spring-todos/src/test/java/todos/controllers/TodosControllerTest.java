package todos;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Before;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.context.embedded.LocalServerPort;

import java.net.URL;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TodosControllerTest{

	@Autowired
    private TodosController controller;

    @Autowired
    TodosRepository  repository;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private URL base;

    @Before
	public void setUp() throws Exception {
	    //repository.deleteAll();
    	System.out.println("hello"); 
    	this.base = new URL("http://localhost:" + port + "/todos/1");
    	Todos todo1 = new Todos ("1","userId1","title1","false");
    	repository.save(todo1);

	}

     /*
     * Add HTTP Authorization header, using Basic-Authentication to send user-credentials.
     */
    private static HttpHeaders getHeaders(){
        String plainCredentials="bill:abc123";
        String base64Credentials = new String(Base64.encodeBase64(plainCredentials.getBytes()));
        
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Credentials);
        return headers;
    }

	@Test
    public void contextLoads() throws Exception {

    	assertThat(controller).isNotNull();
    }

    @Test
    public void testGetTodoById() throws Exception {


    	//ResponseEntity<String> response = restTemplate.getForEntity(base.toString(), String.class);  
    	//assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    	//assertThat(response.getBody()).contains("userId1");

        HttpEntity<String> request = new HttpEntity<String>(getHeaders());
        ResponseEntity<String> response = restTemplate.exchange(base.toString(), HttpMethod.GET, request, String.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat(response.getBody()).contains("userId1");
    }


}