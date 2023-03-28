/**
 * App2.java
 * Created on Mar 25, 2023, 8:26 PM
 * Author: Ten Phun
 */
package org.tenphun.ioccase1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tenphun.ioccase1.dao.BookDao;
import org.tenphun.ioccase1.service.BookService;
import org.tenphun.ioccase1.service.BookServiceImpl;

public class App2 {
    public static void main(String[] args) {
        //2. Get IoC Container
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        //3. Get Beans
        BookDao bookDao = (BookDao) ctx.getBean("bookDao");
        bookDao.save();

        // We can see how dependency is injected here
        BookService bookService = (BookService) ctx.getBean("bookService");
        bookService.save();

    }
}
