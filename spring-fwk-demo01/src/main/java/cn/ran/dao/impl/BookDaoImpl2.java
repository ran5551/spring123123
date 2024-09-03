package cn.ran.dao.impl;

import cn.ran.dao.BookDao;
import cn.ran.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public class BookDaoImpl2 implements BookDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    //lambda表达式
    public List<Book> findAll() {
        String sql = "select * from books";
        List<Book> books =jdbcTemplate.query(sql,(rs,rowNum) ->{
            Book book = new Book().setId(rs.getInt("id"))
                    .setTitle(rs.getString("title"))
                    .setPrice(rs.getDouble("price"))
                    .setQuantity(rs.getInt("quantity"));
            return book;

        });
        return books;
    }

    @Override
    public int addBook(Book book) {
        String sql = "insert into books(title,price,quantity) values (?,?,?)";
        return jdbcTemplate.update(sql,book.getTitle(),book.getPrice(),book.getQuantity());
    }
}
