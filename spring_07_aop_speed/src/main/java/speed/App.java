/**
 * App.java
 * Author: Ten Phun
 */
package speed;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import speed.config.SpringConfig;
import speed.domain.Account;
import speed.service.AccountService;
import speed.service.impl.AccountServiceImpl;

public class App {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountService accountService = (AccountService) ctx.getBean("accountService");
        Account ac = accountService.findById(1);
        System.out.println(ac);
    }
}
