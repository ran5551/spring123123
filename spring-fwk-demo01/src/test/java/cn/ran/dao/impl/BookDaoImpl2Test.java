package cn.ran.dao.impl;

import cn.ran.dao.BookDao;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class BookDaoImpl2Test {

        @Autowired
        private BookDao bookDao;
        @Test
        void findAll() {


     bookDao.findAll().stream().forEach(System.out::println);

        }

    @Test
    void addBook() {
    }
}