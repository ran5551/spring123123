package cn.ran.dao.impl;

import cn.ran.dao.BookDao;
import cn.ran.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository

public class BookDaoimpl implements BookDao {
    @Autowired
    private DataSource dataSource;


    @Override
    public List<Book> findAll() {
        String sql = "select * from books";
        List<Book> books = new ArrayList<>();
        Connection conn =null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = dataSource.getConnection();
            ps =conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Book book = new Book().setId(rs.getInt("id"))
                        .setTitle(rs.getString("title"))
                        .setPrice(rs.getDouble("price"))
                        .setQuantity(rs.getInt("quantity"));
                books.add(book);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }
    @Override
    public int addBook(Book book) {
        String sql = "insert into books(title,price,quantity) values (?,?,?)";
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(true);
            statement=connection.prepareStatement(sql);
            statement.setString(1, book.getTitle());
            statement.setDouble(2,book.getPrice());
            statement.setInt(3,book.getQuantity());
            return statement.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
