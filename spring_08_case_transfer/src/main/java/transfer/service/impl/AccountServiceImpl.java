/**
 * AccountServiceImpl.java
 * Author: Ten Phun
 */
package transfer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import transfer.dao.AccountDao;
import transfer.domain.Account;
import transfer.service.AccountService;
import transfer.service.LogService;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Autowired
    private LogService logService;

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    @Override
    public void transfer(String out, String in, Double money) {
        logService.log(out, in, money);
        accountDao.outMoney(out, money);
        accountDao.inMoney(in, money);
    }
}
