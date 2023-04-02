/**
 * LogServiceImpl.java
 * Author: Ten Phun
 */
package transfer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import transfer.dao.LogDao;
import transfer.service.LogService;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDao logDao;
    @Override
    public void log(String out, String in, Double money) {
        logDao.log("From " +out+" to "+in+", Value: "+money);
    }
}
