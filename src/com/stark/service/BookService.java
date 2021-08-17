package com.stark.service;

import com.stark.pojo.Book;
import com.stark.pojo.Page;

import java.util.List;

/**
 * Author: C.H.G
 * User: C.H.G
 * Date: 2021/8/16
 * Time: 上午11:45
 */
public interface BookService {
    public void addBook(Book book);
    public void deleteBookById(Integer id);
    public void updateBook(Book book);
    public Book queryBookById(Integer id);
    public List<Book> queryBooks();
    Page<Book> page(int pageNo, int pageSize);
    //Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);
}
