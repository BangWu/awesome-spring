package net.gongmingqm10.tutorial.controller;

import net.gongmingqm10.tutorial.model.APIMessage;
import net.gongmingqm10.tutorial.model.Book;
import net.gongmingqm10.tutorial.model.User;
import net.gongmingqm10.tutorial.service.BookService;
import net.gongmingqm10.tutorial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    protected UserService userService;

    @Autowired
    protected BookService bookService;

    @RequestMapping(value = "")
    public ModelAndView index() {
        List<User> users = userService.getAllUsers();
        ModelAndView modelView = new ModelAndView("users/index");
        modelView.addObject("users", users);
        return modelView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{userid}/books")
    public ModelAndView get(@PathVariable("userid") String userid){
        List<Book> books = bookService.getBooksByUser(Integer.parseInt(userid));
        ModelAndView modelAndView = new ModelAndView("users/books");
        modelAndView.addObject("books", books);
        return modelAndView;
    }


    @RequestMapping(method = RequestMethod.GET, value = "/{userid}/books/new")
    public ModelAndView addNewBook(@PathVariable("userid") String userid){
        Book book = new Book();
        book.setUserId(Integer.parseInt(userid));
        ModelAndView modelAndView = new ModelAndView("books/new");
        modelAndView.addObject("book", book);
        modelAndView.addObject("userid", userid);
        return modelAndView;
    }


    @RequestMapping(method = RequestMethod.POST, value = "/{userid}/books")
    public
    String saveUserBook(@PathVariable("userid") String userid, HttpServletRequest request){
        Book book = new Book();
        book.setUserId(Integer.parseInt(userid))
                .setAuthor(request.getParameter("author"))
                .setImage(request.getParameter("image"))
                .setSummary(request.getParameter("summary"))
                .setTitle(request.getParameter("title"));
        bookService.saveUserBook(book);
        return "redirect:/users/"+userid+"/books";
    }
}
