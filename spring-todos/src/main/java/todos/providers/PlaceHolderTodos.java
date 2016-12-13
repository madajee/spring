package todos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;

import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.Arrays;

@Component
public class PlaceHolderTodos
{
	private static final Logger log = LoggerFactory.getLogger(PlaceHolderTodos.class);

	public ResponseEntity<String> downloadTodos()
	{
		log.info("********Hello Todos******");

		RestTemplate rt = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        	headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
			HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
			String url = "http://jsonplaceholder.typicode.com/todos";
			ResponseEntity<String> response = rt.exchange(url, HttpMethod.GET, entity, String.class);
			return response;
	}	
	
}