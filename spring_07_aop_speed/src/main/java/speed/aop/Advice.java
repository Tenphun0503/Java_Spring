/**
 * Advice.java
 * Created on Apr 02, 2023, 12:02 AM
 * Author: Ten Phun
 */
package speed.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Advice {

    @Pointcut("execution(* speed.service.*Service.*(..))")
    public void servicePt() {
    }

    @Around("servicePt()")
    public void aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
        Signature signature = pjp.getSignature();
        String className = signature.getDeclaringTypeName();
        String methodName = signature.getName();

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            pjp.proceed();
        }
        long endTime = System.currentTimeMillis();
        System.out.println(className +" "+ methodName + " 10 times execution Time: " + (endTime - startTime) + "ms");
    }
}
