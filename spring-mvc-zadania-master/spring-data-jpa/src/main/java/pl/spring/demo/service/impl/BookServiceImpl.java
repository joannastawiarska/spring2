package pl.spring.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.mapper.BookMapper;
import pl.spring.demo.repository.BookRepository;
import pl.spring.demo.service.BookService;
import pl.spring.demo.to.BookTo;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class BookServiceImpl implements BookService {

    //@Autowired
    private BookRepository bookRepository;
    
   public BookServiceImpl(){
    	
    }
    
   @Autowired
    public BookServiceImpl(BookRepository bookRepository){
    	this.bookRepository = bookRepository;
    }

	public List<BookTo> findBookByAuthorAndTitle(@Param("author") String author, @Param("title") String title){
    	return BookMapper.map2To(bookRepository.findBookByAuthorAndTitle(author, title));
    }
    
    public BookTo findBookById(@Param("id") Long id){
    	return BookMapper.map(bookRepository.findBookById(id));
    }

    @Override
    public List<BookTo> findAllBooks() {
        return BookMapper.map2To(bookRepository.findAll());
    }

    @Override
    public List<BookTo> findBooksByTitle(String title) {
        return BookMapper.map2To(bookRepository.findBookByTitle(title));
    }

    @Override
    public List<BookTo> findBooksByAuthor(String author) {
        return BookMapper.map2To(bookRepository.findBookByAuthor(author));
    }
    
    @Override
    @Transactional(readOnly = false)
    public BookTo saveBook(BookTo book) {
        BookEntity entity = BookMapper.map(book);
        entity = bookRepository.save(entity);
        return BookMapper.map(entity);
    }

	@Override
	@Transactional(readOnly = false)
	public void deleteBook(Long id) {
		bookRepository.delete(id);
		
	}
}