/**
 * AccountDao.java
 * Created on Mar 31, 1:35 PM
 * Author: Ten Phun
 */
package mybatis.dao;

import mybatis.domain.Account;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AccountDao {
    @Insert("insert into tb_account(name, value) values (#{name}, #{money})")
    void save(Account account);

    @Delete("delete from tb_account where id= #{id}")
    void delete(Integer id);

    @Update("update tb_account set name = #{name}, money = #{money} where id =#{id}")
    void update(Account account);

    @Select("select * from tb_account")
    List<Account> findAll();

    @Select("select * from tb_account where id = #{id}")
    Account findById(Integer id);
}
