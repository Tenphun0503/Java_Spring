/**
 * MyAdvice.java
 * Author: Ten Phun
 */
package start.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


// 5. Add to Spring and tell Spring to execute as AOP
// 6. Then in SpringConfig, add @EnableAspectJAutoProxy telling Spring we're using AOP
@Component
@Aspect
public class MyAdvice {
    // 2. Create pointcut method
    // 3. Annotation
    @Pointcut("execution(* start.dao.*Dao.update(..))")
    public void pc(){}

    // 1. Create advice: define method()
    // 4. Bind relation
    @Before("pc()")
    public void method(){
        System.out.println(System.currentTimeMillis());
    }
}
