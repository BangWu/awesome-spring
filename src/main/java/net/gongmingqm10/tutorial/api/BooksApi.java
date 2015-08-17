package net.gongmingqm10.tutorial.api;

import net.gongmingqm10.tutorial.model.APIMessage;
import net.gongmingqm10.tutorial.model.Book;
import net.gongmingqm10.tutorial.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/api")
public class BooksApi {

    @Autowired
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET, value = "/users/{userid}/books", produces = "application/json")
    public
    @ResponseBody
    ResponseEntity<List<Book>> get(@PathVariable("userid") String userid){
        List<Book> books = bookService.getBooksByUser(Integer.parseInt(userid));
        return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users/{userid}/books/{bookid}", produces = "application/json")
    public
    @ResponseBody
    ResponseEntity<Book> getUserBook(@PathVariable("userid") String userid, @PathVariable("bookid") String bookid){
        Book book = bookService.getUserBook(Integer.parseInt(userid), Integer.parseInt(bookid));
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users/{userid}/books", produces = "application/json")
    public
    @ResponseBody
    ResponseEntity<APIMessage> saveUserBook(@PathVariable("userid") String userid, HttpServletRequest request){
        Book book = new Book();
        book.setUserId(Integer.parseInt(userid))
                .setAuthor(request.getParameter("author"))
                .setImage(request.getParameter("image"))
                .setSummary(request.getParameter("summary"))
                .setTitle(request.getParameter("title"));
        bookService.saveUserBook(book);
        return new ResponseEntity(new APIMessage("Add success"), HttpStatus.OK);
    }

}
