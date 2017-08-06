package pl.spring.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.spring.demo.constants.ModelConstants;
import pl.spring.demo.constants.ViewNames;

@Controller
public class HomeController {

	private static final String INFO_TEXT = "Here You can find all books in our library or search one by title or by authors.";
	private static final String WELCOME = "Welcome to our website";

	@RequestMapping("/")
	public String welcome(Model model) {
		model.addAttribute(ModelConstants.GREETING, WELCOME);
		model.addAttribute(ModelConstants.INFO, INFO_TEXT);
		return ViewNames.WELCOME;
	}
}
