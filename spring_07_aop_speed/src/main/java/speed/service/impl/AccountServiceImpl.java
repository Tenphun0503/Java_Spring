/**
 * AccountServiceImpl.java
 * Author: Ten Phun
 */
package speed.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import speed.dao.AccountDao;
import speed.domain.Account;
import speed.service.AccountService;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Override
    public void save(Account account) {
        accountDao.save(account);
    }

    @Override
    public void update(Account account) {
        accountDao.update(account);
    }

    @Override
    public void delete(Integer id) {
        accountDao.delete(id);
    }

    @Override
    public Account findById(Integer id) {
        return accountDao.findById(id);
    }

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }

}
