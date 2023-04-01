/**
 * BookServiceImpl.java
 * Created on Mar 25, 2023, 7:10 PM
 * Author: Ten Phun
 */
package xml.service;

import xml.dao.BookDao;

public class BookServiceImpl implements BookService {
    // 4. Delete objects created with 'new'.
    private BookDao bookDao;

    public void save() {
        System.out.println("book service save ...");
        bookDao.save();
    }
    // 5. Provide a setter.
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }
}
