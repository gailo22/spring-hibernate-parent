package simple.controller;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.ui.ModelMap;

public class WelcomeRestControllerTest {
	
	@Mock
	private ModelMap mockModelMap;
	
	@Before
	public void setup() {
		initMocks(this);
	}
	
	@Test
	public void shouldReturnCorrectViewName() {
		// Given
		WelcomeRestController controller = new WelcomeRestController();
		// When
		String viewName = controller.sayHello("John", mockModelMap);
		// Then
		assertThat(viewName, equalTo("welcomeRest"));
	}

}
