package demo;

import org.junit.Test;
import static org.junit.Assert.*;


public class ApplicationTest {

	@Test
	public void testConvertToUpperCase () throws Exception {
		String expectedValue = "HELLO SPRING BOOT SEED";
		Application app = new Application();
		String actualValue = app.convertToUpperCase("hello spring boot seed");
		assertEquals(expectedValue,actualValue);

	}
}