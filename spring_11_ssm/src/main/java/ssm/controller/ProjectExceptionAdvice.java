/**
 * ProjectExceptionAdvise.java
 * Author: Ten Phun
 */
package ssm.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ssm.exception.BusinessException;
import ssm.exception.SystemException;

// 1. first, we declare that this class is used to handel exception
// 1.1 Remember that the class should be scanned by SpringMvcConfig
@RestControllerAdvice
public class ProjectExceptionAdvice {
    // 3. we annotate that this method is used to intercept exception
    @ExceptionHandler(Exception.class)
    // 2. then we define a method that handle a type of exception
    public Result doException(Exception e){
        System.out.println(e.getMessage());
        // 4. After handle the exception, we still need to send something to the front
        return new Result(Code.UNKNOWN_ERR, null, "System busy, try later");
    }


    // Example of handling exception
    @ExceptionHandler(SystemException.class)
     public Result doSystemException(SystemException e){
        // record log
        // send msg to maintainer
        // send msg/email to developer (include e type etc.)
        // send msg to user
        return new Result(e.getCode(), null, e.getMessage());
     }


    @ExceptionHandler(BusinessException.class)
     public Result doBusinessException(BusinessException e){
        // send msg to user
        return new Result(e.getCode(), null, e.getMessage());
     }
}
