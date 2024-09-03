package cn.ran.controller;

import cn.ran.dao.BookDao;
import cn.ran.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookDao bookDao;
    @GetMapping(value = "/books")
    public List<Book> findAllBook(){
        System.out.println("查询所有的书...");
       return bookDao.findAll();
    }

}
