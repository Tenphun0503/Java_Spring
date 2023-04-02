import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import transfer.config.SpringConfig;
import transfer.service.AccountService;

import java.io.IOException;

/**
 * AccountServiceTest.java
 * Author: Ten Phun
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class AccountServiceTest {
    @Autowired
    private AccountService accountService;

    @Test
    public void TestFindAll(){
        System.out.println(accountService.findAll());
    }

    @Test
    public void transfer() throws IOException{
        accountService.transfer("Tom", "Jerry", 100D);
    }

    @Test
    public void transfer2() throws IOException{
        accountService.transfer("Jerry", "Tom ", 100D);
    }
}
