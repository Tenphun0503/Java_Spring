/**
 * App.java
 * Created on Mar 30, 6:47 PM
 * Author: Ten Phun
 */
package annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import annotation.dao.BookDao;
import annotation.service.BookService;

public class App {
    public static void main(String[] args) {
        //We load the annotation configuration file
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        BookDao bookDao = (BookDao) ctx.getBean("bookDao");
        bookDao.save();

        // if you don't give name for Component, you can also use Class
        BookService bookService = ctx.getBean(BookService.class);
        bookService.save();
    }

}
