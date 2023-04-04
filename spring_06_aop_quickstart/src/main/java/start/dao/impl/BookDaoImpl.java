/**
 * BookDaoImpl.java
 * Author: Ten Phun
 */
package start.dao.impl;

import start.dao.BookDao;
import org.springframework.stereotype.Repository;

@Repository("bookDao")
public class BookDaoImpl implements BookDao {
    @Override
    public void save() {
        System.out.println(System.currentTimeMillis());
        System.out.println("book ssm.dao save...");
    }

    @Override
    public void update() {
        System.out.println("book ssm.dao update");
    }
}
