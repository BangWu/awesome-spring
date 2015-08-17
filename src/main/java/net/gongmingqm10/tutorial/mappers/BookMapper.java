package net.gongmingqm10.tutorial.mappers;

import net.gongmingqm10.tutorial.model.Book;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BookMapper {
    @Select(
            "SELECT id, user_id as userId, title, summary, image, author FROM books WHERE user_id=#{userId}"
    )
    List<Book> getBooksByUser(int userId);

    @Select(
            "SELECT id, user_id as userId, title, summary, image, author FROM books WHERE user_id=#{userId} and id=#{bookId}"
    )
    Book getUserBook(@Param("userId")int userId, @Param("bookId")int bookId);

    @Insert(
            "INSERT INTO books SET user_id=#{userId}, title=#{title}, summary=#{summary}, image=#{image}, author=#{author}"
    )
    void saveUserBook(Book book);
}
