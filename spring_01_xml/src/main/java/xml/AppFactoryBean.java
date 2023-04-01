/**
 * AppFactoryBean.java
 * Created on Mar 30, 2023, 4:26 PM
 * Author: Ten Phun
 */
package xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xml.dao.BookDao;

public class AppFactoryBean {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookDao bookDao = (BookDao) ctx.getBean("bookDaoByFactory");
        bookDao.save();
    }
}
