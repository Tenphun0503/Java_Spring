/**
 * AccountService.java
 * Author: Ten Phun
 */
package transfer.service;

import org.springframework.transaction.annotation.Transactional;
import transfer.domain.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAll();

    // 1. Set related method transactional. Then goto jdbcConfig see next step
    @Transactional
    void transfer(String out, String in, Double money);

}
