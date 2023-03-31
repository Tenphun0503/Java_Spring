/**
 * BookDaoImpl.java
 * Created on Mar 25, 2023, 6:34 PM
 * Author: Ten Phun
 */
package org.tenphun.ioccase2.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Repository("bookDao")
public class BookDaoImpl implements BookDao {
    @Value("${name}")
    private String name;

    public void save() {
        System.out.println("book dao save ...: " + name);
    }
}
