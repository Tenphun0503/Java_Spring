/**
 * BookService.java
 * Created on Apr 04, 2023, 1:50 AM
 * Author: Ten Phun
 */
package ssm.service;

import ssm.domain.Book;

import java.util.List;

public interface BookService {
    /**
     * Save
     * @param book
     * @return if action success
     */
    boolean save(Book book);

    /**
     * Update data
     * @param book
     * @return if action success
     */
    boolean update(Book book);

    /**
     * Delete by id
     * @param id
     * @return if action success
     */
    boolean delete(Integer id);

    /**
     * Select by id
     * @param id
     * @return return Book
     */
    Book getById(Integer id);

    /**
     * Select All
     * @return return Books
     */
    List<Book> getAll();

}
