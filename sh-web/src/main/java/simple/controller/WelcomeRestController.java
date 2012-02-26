package simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeRestController {
	
	@RequestMapping(value="/welcomeRest/{name}", method=RequestMethod.GET)
	public String sayHello(@PathVariable String name, ModelMap modelMap) {
		modelMap.addAttribute("name", name);
		return "welcomeRest";
	}

}
