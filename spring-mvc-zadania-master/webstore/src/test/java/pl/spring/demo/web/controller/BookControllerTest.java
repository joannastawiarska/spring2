package pl.spring.demo.web.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import pl.spring.demo.constants.ModelConstants;
import pl.spring.demo.controller.BookController;
import pl.spring.demo.enumerations.BookStatus;
import pl.spring.demo.service.BookService;
import pl.spring.demo.to.BookTo;

public class BookControllerTest {

	private MockMvc mockMvc;

	@Mock
	private BookService bookService;

	@InjectMocks
	private BookController bookController;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(bookController).build(); //atrapa mockmvc
	}

	@Test
	public void shouldDisplayAllBooks() throws Exception {

		// given
		List<BookTo> bookList = new ArrayList<BookTo>();
		bookList.add(new BookTo(1L, "title", "autor", BookStatus.FREE));
		bookList.add(new BookTo(2L, "title", "autor", BookStatus.FREE));
		when(bookService.findAllBooks()).thenReturn(bookList);
		
		// when
		ResultActions resultActions = mockMvc.perform(get("/books/all"));

		// then

		resultActions.andExpect(view().name("books"))
				.andExpect(model().attribute(ModelConstants.BOOK_LIST, bookList));
	}

	@Test
	public void shouldDisplayOneBook() throws Exception {

		// given
		BookTo book = new BookTo(1L, "title", "autor", BookStatus.FREE);
		when(bookService.findBookById(1L)).thenReturn(book);

		// when
		ResultActions resultActions = mockMvc.perform(get("/books/book/{id}", 1L));

		// then
		resultActions.andExpect(view().name("book")).
				andExpect(model().attribute(ModelConstants.BOOK, book));
	}
	
	@Test
	public void shouldDeleteOneBook() throws Exception {

		// given
		List<BookTo> bookList = new ArrayList<BookTo>();
		BookTo bookDeleted = new BookTo(1L, "title", "autor", BookStatus.FREE);
		bookList.add(bookDeleted);
		bookList.add(new BookTo(2L, "title", "autor", BookStatus.FREE));
		when(bookService.findBookById(1L)).thenReturn(bookDeleted);
		Mockito.doNothing().when(bookService).deleteBook(1L);
		
		// when
		ResultActions resultActions = mockMvc.perform(get("/books/delete/{id}", 1L));
		// then
				resultActions.andExpect(view().name("deleteBook")).
						andExpect(model().attribute(ModelConstants.BOOK, bookDeleted));
		
	}
	
	@Test
	public void shouldFilterBooks() throws Exception {

		// given
		List<BookTo> bookList = new ArrayList<BookTo>();
		bookList.add(new BookTo(1L, "First", "Nowak", BookStatus.FREE));
		bookList.add(new BookTo(2L, "Second", "Nowak", BookStatus.FREE));
		when(bookService.findBookByAuthorAndTitle("Nowak", "")).thenReturn(bookList);
		
		// when
		ResultActions resultActions = mockMvc.perform(get("/books/search?authors={authors}&title=&Submit=Find", "Nowak"));
		// then
				resultActions.andExpect(view().name("books")).
						andExpect(model().attribute(ModelConstants.BOOK_LIST, bookList));
	}

}
