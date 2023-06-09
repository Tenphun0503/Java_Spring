/**
 * LogDao.java
 * Author: Ten Phun
 */
package transfer.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface LogDao {
    @Insert("insert into tb_log(info) value (#{info})")
    void log(@Param("info") String info);
}
