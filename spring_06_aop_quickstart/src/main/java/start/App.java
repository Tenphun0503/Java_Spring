/**
 * App.java
 * Author: Ten Phun
 */
package start;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import start.config.SpringConfig;
import start.dao.BookDao;

public class App {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookDao bookDao = (BookDao) ctx.getBean("bookDao");
        bookDao.save();
        bookDao.update();
    }


}
