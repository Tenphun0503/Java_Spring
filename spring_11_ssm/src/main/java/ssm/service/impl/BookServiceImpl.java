/**
 * BookServiceImpl.java
 * Created on Apr 04, 2023, 1:50 AM
 * Author: Ten Phun
 */
package ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.controller.Code;
import ssm.dao.BookDao;
import ssm.domain.Book;
import ssm.exception.BusinessException;
import ssm.service.BookService;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public boolean save(Book book) {
        bookDao.save(book);
        return true;
    }

    @Override
    public boolean update(Book book) {
        bookDao.update(book);
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        bookDao.delete(id);
        return true;
    }

    @Override
    public Book getById(Integer id) {
        if(id<=0) throw new BusinessException(Code.BUS_ERR, "Invalid value");
        return bookDao.getById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.getAll();
    }
}
