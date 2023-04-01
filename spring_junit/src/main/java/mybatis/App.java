/**
 * App.java
 * Author: Ten Phun
 */
package mybatis;

import mybatis.config.SpringConfig;
import mybatis.domain.Account;
import mybatis.service.AccountService;
import mybatis.service.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountService accountService = ctx.getBean(AccountServiceImpl.class);
        Account ac = accountService.findById(1);
        System.out.println(ac);
    }
}
