package net.gongmingqm10.tutorial.service;

import net.gongmingqm10.tutorial.mappers.BookMapper;
import net.gongmingqm10.tutorial.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookService {

    @Autowired
    private BookMapper bookMapper;

    public List<Book> getBooksByUser(int userId) {
        return bookMapper.getBooksByUser(userId);
    }

    public Book getUserBook(int userId, int bookId) {
        return bookMapper.getUserBook(userId, bookId);
    }

    public void saveUserBook(Book book) {
        bookMapper.saveUserBook(book);
    }
}
