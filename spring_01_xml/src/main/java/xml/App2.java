/**
 * App2.java
 * Created on Mar 25, 2023, 8:26 PM
 * Author: Ten Phun
 */
package xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xml.dao.BookDao;
import xml.service.BookService;

public class App2 {
    public static void main(String[] args) {
        // 2. Get IoC Container
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 3. Get Beans
        BookDao bookDao = (BookDao) ctx.getBean("bookDao");
        bookDao.save();

        // We can see how dependency is injected here
        BookService bookService = (BookService) ctx.getBean("bookService");
        bookService.save();

    }
}
