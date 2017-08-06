package pl.spring.demo.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import pl.spring.demo.constants.ModelConstants;
import pl.spring.demo.controller.LoginController;

public class LoginControllerTest {

	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		//viewResolver.setPrefix("/WEB-INF/views/");
		//viewResolver.setSuffix(".jsp");
		mockMvc = MockMvcBuilders.standaloneSetup(new LoginController()).setViewResolvers(viewResolver).build();
	}
	
	@Test
	public void accesssDeniedTest() throws Exception {
		
		//given
		
		//when
		ResultActions resultActions = mockMvc.perform(get("/403"));
		
		//then
		resultActions.andExpect(view().name("_403"))
		.andExpect(model().attribute(ModelConstants.ERROR_MESSAGE, new ArgumentMatcher<Object>() {
			@Override
			public boolean matches(Object argument) {
				String errorMessage = (String) argument;
				return errorMessage != null;
			}
		}));
	}

}
