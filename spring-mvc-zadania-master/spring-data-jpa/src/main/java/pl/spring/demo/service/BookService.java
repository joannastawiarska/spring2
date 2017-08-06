package pl.spring.demo.service;

import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.to.BookTo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookService {

    List<BookTo> findAllBooks();
    List<BookTo> findBooksByTitle(String title);
    List<BookTo> findBooksByAuthor(String author);
   
    public List<BookTo> findBookByAuthorAndTitle(@Param("author") String author, @Param("title") String title);
    public BookTo findBookById(@Param("id") Long id);
    
    BookTo saveBook(BookTo book);
    void deleteBook(Long id);
}
