/**
 * App.java
 * Created on Mar 30, 6:47 PM
 * Author: Ten Phun
 */
package org.tenphun.ioccase2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tenphun.ioccase2.dao.BookDao;
import org.tenphun.ioccase2.service.BookService;

public class App {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("annotationApplicationContext.xml");
        BookDao bookDao = (BookDao) ctx.getBean("bookDao");
        bookDao.save();

        // if you don't give name for Component, you can also use Class
        BookService bookService = ctx.getBean(BookService.class);
        bookService.save();
    }

}
