/**
 * BookDao.java
 * Created on Apr 04, 2023, 1:50 AM
 * Author: Ten Phun
 */
package ssm.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import ssm.domain.Book;

import java.util.List;

@Repository
public interface BookDao {
    @Insert("insert into db2 values(null, #{type}, #{name}, #{description}")
    public void save(Book book);
    @Update("update db2 set type=#{type}, name=#{name}, description=#{description} where id=#{id}")
    public void update(Book book);
    @Delete("delete from db2 where id=#{id}")
    public void delete(Integer id);
    @Select("select * from db2 where id=#{id}")
    public Book getById(Integer id);
    @Select("select * from db2")
    public List<Book> getAll();

}
