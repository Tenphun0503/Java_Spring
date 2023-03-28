/**
 * BookServiceImpl.java
 * Created on Mar 25, 2023, 7:10 PM
 * Author: Ten Phun
 */
package org.tenphun.ioccase1.service;

import org.tenphun.ioccase1.dao.BookDao;
import org.tenphun.ioccase1.dao.BookDaoImpl;

public class BookServiceImpl implements BookService {
    // 4. Delete
    private BookDao bookDao = new BookDaoImpl();

    public void save() {
        System.out.println("book service save ...");
        bookDao.save();
    }
}
