/**
 * BookServiceImpl.java
 * Created on Mar 30, 7:13 PM
 * Author: Ten Phun
 */
package annotation.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import annotation.dao.BookDao;


@Service()
public class BookServiceImpl implements BookService{

    @Autowired
    @Qualifier("bookDao")
    private BookDao bookDao;

    // We no longer need setter
    /*public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }*/

    public void save() {
        System.out.println("book service save ...");
        bookDao.save();
    }
}
