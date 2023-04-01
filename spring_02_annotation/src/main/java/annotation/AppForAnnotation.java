/**
 * AppForAnnotation.java
 * Created on Mar 31, 2023, 12:04 AM
 * Author: Ten Phun
 */
package annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import annotation.config.SpringConfig;
import annotation.dao.BookDao;
import annotation.service.BookService;

public class AppForAnnotation {
    public static void main(String[] args) {
        // We can use class to replace xml file
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);

        BookDao bookDao = (BookDao) ctx.getBean("bookDao");
        bookDao.save();

        BookService bookService = ctx.getBean(BookService.class);
        bookService.save();
    }

}
