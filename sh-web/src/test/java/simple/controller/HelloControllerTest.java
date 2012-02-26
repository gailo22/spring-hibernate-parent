package simple.controller;

import static org.junit.Assert.assertThat;

import org.hamcrest.core.IsEqual;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import simple.controller.HelloController;

public class HelloControllerTest {

	@Test
	public void testHandleRequestView() throws Exception {	
		// Given
        HelloController controller = new HelloController();
        
        // When
        ModelAndView modelAndView = controller.handleRequest(null, null);	
        
        // Then
        assertThat(modelAndView.getViewName(), IsEqual.equalTo("hello"));
    }
}
