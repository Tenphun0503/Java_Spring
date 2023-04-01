/**
 * BookDaoFactoryBean.java
 * Created on Mar 30, 2023, 5:24 PM
 * Author: Ten Phun
 */
package xml.dao;

import org.springframework.beans.factory.FactoryBean;

public class BookDaoFactoryBean implements FactoryBean<BookDao> {
    @Override
    public BookDao getObject() throws Exception {
        return new BookDaoImpl();
    }

    @Override
    public Class<?> getObjectType() {
        return BookDao.class;
    }

    // Now we can change the scope here
    @Override
    public boolean isSingleton() {
        return true;
    }
}
