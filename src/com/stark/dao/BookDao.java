package com.stark.dao;

/**
 * User: C.H.G
 * Date: 2021/8/16
 * Time: 上午11:29
 */
import com.stark.pojo.Book;
import java.util.List;

public interface BookDao {
    public int addBook(Book book);
    public int deleteBookById(Integer id);
    public int updateBook(Book book);
    public Book queryBookById(Integer id);
    public List<Book> queryBooks();
    public int getCount();
    public List<Book> getList(int limit, int size);
}
