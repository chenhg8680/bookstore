package com.stark.web;

/**
 * User: C.H.G
 * Date: 2021/8/16
 * Time: 下午2:59
 */
import com.stark.pojo.Book;
import com.stark.pojo.Page;
import com.stark.service.BookService;
import com.stark.service.impl.BookServiceImpl;
import com.stark.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookServlet extends BaseServlet{

    private BookService bookService = new BookServiceImpl();

    /**
     * 处理分页功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 获取请求的参数 pageNo 和 pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //2 调用BookService.page(pageNo，pageSize)：Page对象
        Page<Book> page = bookService.page(pageNo,pageSize);

        page.setUrl("manager/bookServlet?action=page");

        //3 保存Page对象到Request域中
        req.setAttribute("page",page);
        //4 请求转发到pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 通过BookService查询全部图书
        List<Book> books = bookService.queryBooks();
        //2 把全部图书保存到Request域中
        req.setAttribute("books", books);
        //3、请求转发到/pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }

    protected void add(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{

        System.out.println(req.getParameterMap());
        Book book = WebUtils.copyParamToBean(req.getParameterMap(),new Book());
        bookService.addBook(book);

        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page");
    }

    protected void delete(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
        int id = WebUtils.parseInt(req.getParameter("id"), 0);

        // 2、调用 bookService.deleteBookById();删除图书
        bookService.deleteBookById(id);
        // 3、重定向回图书列表管理页面 // /book/manager/bookServlet?action=list
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page");
    }

    protected void getBook(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
        int id = WebUtils.parseInt(req.getParameter("id"), 0);

        // 2、调用 bookService.deleteBookById();删除图书
        Book book = bookService.queryBookById(id);
        req.setAttribute("book",book);
        // 3、重定向回图书列表管理页面 // /book/manager/bookServlet?action=list
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req,resp);
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、获取请求的参数==封装成为 Book 对象

        System.out.println("------------------------");
        System.out.println(req.getParameterValues("name").toString());
        System.out.println(req.getParameterValues("author"));
        System.out.println("++++++++++++++++++++++++");
        Book book = WebUtils.copyParamToBean(req.getParameterMap(),new Book());
        // 2、调用 BookService.updateBook( book );修改图书
        bookService.updateBook(book);
        // 3、重定向回图书列表管理页面 // 地址：/工程名/manager/bookServlet?action=list
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page");
    }
}