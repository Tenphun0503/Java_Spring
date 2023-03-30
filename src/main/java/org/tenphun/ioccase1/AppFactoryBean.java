/**
 * AppFactoryBean.java
 * Created on Mar 30, 2023, 4:26 PM
 * Author: Ten Phun
 */
package org.tenphun.ioccase1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tenphun.ioccase1.dao.BookDao;

public class AppFactoryBean {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookDao bookDao = (BookDao) ctx.getBean("bookDaoByFactory");
        bookDao.save();
    }
}
