package pl.spring.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pl.spring.demo.constants.ModelConstants;
import pl.spring.demo.constants.ViewNames;
import pl.spring.demo.service.BookService;
import pl.spring.demo.to.BookTo;

/**
 * Book controller
 * 
 * @author mmotowid
 *
 */
@Controller
@RequestMapping("/books")
public class BookController {

	@Autowired
	BookService bookService;

	@RequestMapping
	public String list(Model model) {
		// TODO: implement default method
		return ViewNames.BOOKS;
	}

	@RequestMapping("/all")
	public ModelAndView allBooks() {

		// TODO: implement method gathering and displaying all books
		ModelAndView model = new ModelAndView();
		model.addObject(ModelConstants.BOOK_LIST, bookService.findAllBooks());
		model.setViewName(ViewNames.BOOKS);
		return model;
	}

	@RequestMapping(value = "/book/{id}")
	public ModelAndView showBook(@PathVariable("id") Long id) {

		ModelAndView model = new ModelAndView();
		model.addObject(ModelConstants.BOOK, bookService.findBookById(id));
		model.setViewName(ViewNames.BOOK);
		return model;
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView searchBook(@RequestParam(value = "title", required = false) String title,
			@RequestParam(value = "authors", required = false) String authors) {

		ModelAndView model = new ModelAndView();
		if(authors == "" && title == ""){
			model.addObject("message", "You have to set author or title!");
		} else {
			model.addObject(ModelConstants.BOOK_LIST, bookService.findBookByAuthorAndTitle(authors, title));
		}
		model.setViewName(ViewNames.BOOKS);
		return model;

	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteBook(@PathVariable("id") Long id) {

		ModelAndView model = new ModelAndView();
		BookTo bookDeleted = bookService.findBookById(id);
		bookService.deleteBook(id);
		model.addObject(ModelConstants.BOOK, bookDeleted);
		model.setViewName(ViewNames.BOOK_DELETED);
		return model;

	}

	/**
	 * Binder initialization
	 */
	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
		binder.setAllowedFields("id", "title", "authors", "status");
	}

}
