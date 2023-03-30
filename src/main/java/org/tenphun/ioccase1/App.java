/**
 * App.java
 * Created on Mar 25, 2023, 7:09 PM
 * Author: Ten Phun
 */
package org.tenphun.ioccase1;

import org.tenphun.ioccase1.service.BookService;
import org.tenphun.ioccase1.service.BookServiceImpl;

public class App {
    public static void main(String[] args) {
        // Running this will cause error because we deleted Dao object created with 'new'
        BookService bookService = new BookServiceImpl();
        bookService.save();
    }
}
