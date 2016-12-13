package todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.junit.Test;
import org.junit.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class ApplicationTest {

	@Autowired
    private ApplicationContext applicationContext;

       @Test
    public void testContext() {
        Assert.assertNotNull(applicationContext);
    }

    @Test
	public void testConvertToUpperCase () throws Exception {
		String expectedValue = "HELLO SPRING BOOT SEED";
		Application app = new Application();
		String actualValue = app.convertToUpperCase("hello spring boot seed");
		Assert.assertEquals(expectedValue,actualValue);

	}
	
}