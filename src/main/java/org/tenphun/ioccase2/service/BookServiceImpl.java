/**
 * BookServiceImpl.java
 * Created on Mar 30, 7:13 PM
 * Author: Ten Phun
 */
package org.tenphun.ioccase2.service;
import org.springframework.stereotype.Service;
import org.tenphun.ioccase2.dao.BookDao;


@Service()
public class BookServiceImpl implements BookService{
    private BookDao bookDao;

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void save() {
        System.out.println("book service save ...");
        bookDao.save();
    }
}
