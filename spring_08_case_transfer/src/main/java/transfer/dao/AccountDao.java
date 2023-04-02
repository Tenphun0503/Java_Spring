/**
 * AccountDao.java
 * Author: Ten Phun
 */
package transfer.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import transfer.domain.Account;

import java.util.List;

public interface AccountDao {
    @Select("select * from tb_account")
    List<Account> findAll();

    @Update("update tb_account set money=money+#{money} where name=#{name}")
    void inMoney(@Param("name") String name, @Param("money") Double money);

    @Update("update tb_account set money=money-#{money} where name=#{name}")
    void outMoney(@Param("name") String name, @Param("money") Double money);
}
