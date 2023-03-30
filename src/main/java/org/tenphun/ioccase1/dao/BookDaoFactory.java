/**
 * BookDaoFactory.java
 * Created on Mar 30, 2023, 3:26 PM
 * Author: Ten Phun
 */
package org.tenphun.ioccase1.dao;

public class BookDaoFactory {
    /*
        Static way to create object
     */
    public static BookDao getBookDao(){
        return new BookDaoImpl();
    }
}
