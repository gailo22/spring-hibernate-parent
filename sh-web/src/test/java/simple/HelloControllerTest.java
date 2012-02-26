package simple;

import static org.junit.Assert.assertThat;

import org.hamcrest.core.IsEqual;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

public class HelloControllerTest {

	@Test
	public void testHandleRequestView() throws Exception {	
		// Given
        HelloController controller = new HelloController();
        
        // When
        ModelAndView modelAndView = controller.handleRequest(null, null);	
        
        // Then
        assertThat(modelAndView.getViewName(), IsEqual.equalTo("hello.jsp"));
    }
}
