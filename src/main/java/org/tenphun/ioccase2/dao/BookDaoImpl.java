/**
 * BookDaoImpl.java
 * Created on Mar 25, 2023, 6:34 PM
 * Author: Ten Phun
 */
package org.tenphun.ioccase2.dao;

import org.springframework.stereotype.Repository;

@Repository("bookDao")
public class BookDaoImpl implements BookDao {
    public void save() {
        System.out.println("book dao save ...");
    }
}
