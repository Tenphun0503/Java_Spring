# Spring MVC
Spring MVC is a Java-based web application framework that follows the Model-View-Controller (MVC) architectural pattern. 
It provides a flexible way to develop web applications by separating the concerns of data handling, user interface rendering, and application flow control.
---
### 1. Introduction 
#### Base Steps:
1. Set Dependencies: [pom.xml](../spring_09_mvc_demo/pom.xml)
2. Define Controller: [UserController](../spring_09_mvc_demo/src/main/java/demo/springmvc/UserController.java)
3. Define SpringConfig: [SpringMvcConfig](../spring_09_mvc_demo/src/main/java/demo/ssm.config/SpringMvcConfig.java)
4. Define Servlet Container Init Config: [ServletContainersInitConfig](../spring_09_mvc_demo/src/main/java/demo/ssm.config/ServletContainersInitConfig.java)
5. For Component of Spring, we can exclude scanning bean of SpringMVC: [SpringConfig](../spring_09_mvc_demo/src/main/java/demo/ssm.config/SpringConfig.java)
#### Server Initializing Steps:
1. Start Server, execute `ServletContainersInitCofig`, initialize web container
2. Execute `createdServletApplicationContext`, Create `WebApplicationContext` Object
3. Register SpringMvcConfig
4. Execute `@ComponentScan`, register beans
5. Register `UserController`, each `@RequestMapping` relates to a method
6. Execute `getServletMapping`, define URLs that should be handled by the Spring MVC servlet.
#### Each Request Steps:
1. Send Request `localhost/save`
2. web container send request to SpringMvc
3. Parse request URL `/save`
4. `/save` matches `save()`
5. Execute `save()`
6. Detect `@ReponseBody`, return result of `save()` as the response body.
---
### 2. Request and Response
A servlet block has request url path and response.
```java
@Controller
@RequestMapping("/user")            // we can put the common part of url path here
public class UserController {

    @RequestMapping("/save")
    @ResponseBody
    public String save(){
        return "{'module':'user save'}";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(){
        return "{'module':'user delete'}";
    }
}

```
#### Get and Post
Pass the obtained parameters as formal parameters
`http://localhost/save?name=name&age=10`
```java
@Controller
public class UserController {
    @RequestMapping("/save")
    @ResponseBody
    public String save(String name, int age) {
        return "{'module':'user save'}";
    }
}
```
#### Garbled processing
Use Filter: [ServletContainersInitConfig](../spring_10_mvc_request/src/main/java/mvc/ssm.config/ServletContainersInitConfig.java)
#### Respond
1. return page: just return the name of the page `return page.jsp` (no `RequestBody` needed)
2. return string: `ResponseBody` + `return "stirng text";`
3. return json pojo: `ResponseBody` + `return pojo` (set the type of the method as pojo); '`dependence`: `jackson-databind`'
4. return json list: `ResponseBody` + `return List<pojo>`

---
### 3. Restfull
REST (Representational State Transfer) is a software architectural style that defines a set of constraints to be used for creating web services.  
`http://localhost/user/getById?id=1` in REST `http://localhost/user/1`

#### Some features  
_Statelessness:_ Each request from the client to the server should contain all the information necessary for the server to understand the request. 
The server should not rely on any previous communication from the client.  
_Uniform Interface:_ The interface between the client and server should be standardized, using HTTP methods such as GET, POST, PUT, and DELETE.
#### HTTP methods
`GET`: Inquire  
`POST`: Add/save  
`PUT`: Update  
`DELETE`: Delete  
#### Sample
[UserController](../src/main/java/restful/ssm.controller/UserController.java)
`method`; `paht/{var}` + `@PathVariable`
#### The ways to receive parameters
`@RequestBody`: parameters in the request body  
`@RequestParam`: parameters after the request url  
`@PathVariable`: parameters in the request url
#### Simplify development
1. Move `@RequestMapping` to the top of the class
2. Move `@ResponseBody` to the top of the class
3. Spring Combined `@ResponseBody` and `@Controller` as `@RestController`
4. Change `@RequestMapping(method = RequestMethod.POST)` to `@PostMapping`
5. Change `@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)` to `@DeleteMapping("/{id}")`

---
### 4. SSM
#### SSM
1. Create the project
   - [pom.xml](../spring_11_ssm/pom.xml)
2. SSM Integration
    - Spring
      - [SpringConfig](../spring_11_ssm/src/main/java/ssm/config/SpringConfig.java)
    - Mybatis
      - [MybatisConfig](../spring_11_ssm/src/main/java/ssm/config/MybatisConfig.java)
      - [JdbcConfig](../spring_11_ssm/src/main/java/ssm/config/JdbcConfig.java)
      - [jdbc.properties](../spring_11_ssm/src/main/resources/jdbc.properties)
    - SpringMVC
      - [ServletConfig](../spring_11_ssm/src/main/java/ssm/config/ServletConfig.java)
      - [SpringMvcConfig](../spring_11_ssm/src/main/java/ssm/config/SpringMvcConfig.java)
3. Function Module
   - Tables and [Domains](../spring_11_ssm/src/main/java/ssm/domain/Book.java) class
   - [DAO](../spring_11_ssm/src/main/java/ssm/dao/BookDao.java)
   - [Service](../spring_11_ssm/src/main/java/ssm/service/BookService.java)
     - Service Interface [Test](../spring_11_ssm/src/test/java/ssm/service/BookServiceTest.java) (Junit)
   - [Controller](../spring_11_ssm/src/main/java/ssm/controller/BookController.java)
     - Controller Interface Test (PostMan)
   - Transaction Management
#### Presentation Layer Data Encapsulation
Since we for different request, we returned different type of result back, which increase front-end workload.
In work, we usually use a self-defined result class to encapsulate all the data. e.g.
```java
public class Result {
    private Object data;    // record the result e,g true/false for adding, deleting, updating
    private Integer code;   // record type of request
    private String msg;     // record msg for failed request. e.g. getting request returns null
}
```
- Define [Result](../spring_11_ssm/src/main/java/ssm/controller/Result.java) Class
- Define [Code](../spring_11_ssm/src/main/java/ssm/controller/Code.java)
- Update [BookController](../spring_11_ssm/src/main/java/ssm/controller/BookController.java)
#### Exception Handler
- Different places can occur Exception
  - Exception from framework
  - Exception from data layer
  - Exception from service layer
  - Exception from presentation layer
  - Exception from tool class
- We can let all exceptions throw up to presentation layer and handle them in there.
- Since there are too many kinds of exceptions, so we better use handle them through AOP principle
- Spring MVC provides an exception handler that can be used to handle exceptions centrally and uniformly
- e.g. [ExceptionAdvice Class](../spring_11_ssm/src/main/java/ssm/controller/ProjectExceptionAdvice.java)
#### Exception Handle
- After intercept the exception, we have to handel it
- Different type of exceptions
  - BusinessException
    - Exceptions caused by normative user behavior 
    - Exceptions caused by irregular user behavior
  - SystemException
    - Unavoidable exceptions during the running of the program
  - Exception
    - Unexpected exceptions
- Basic Solution
  - BusinessException
    - Send corresponding message to user to let them operate normally
  - SystemException
    - Send predefined message to user to appease them 
    - Send predefined message to maintainer
    - record log
  - Exception
    - Send predefined message to user to appease them
    - Send predefined message to maintainer and record the exception
    - record log
- Steps
  1. Define Exception Class. e.g. [BusinessException](../spring_11_ssm/src/main/java/ssm/exception/BusinessException.java)
  2. In Code.class, define ERR code
  3. Warp possible exceptions to defined exception
     - Use try..catch. e.g.
     ```
        try{ 
            int i = 1/0;
        } catch (Exception e) {
            throw new SystemException(Code.SYS_ERR, "Server access timeout", e);
        }
     ```
     - or some logical exception e.g. 
     ```
       @Override
       public Book getById(Integer id) {
           if(id<=0) throw new BusinessException(Code.BUS_ERR, "Invalid value");
           return bookDao.getById(id);
       }
     ```
  4. Write handle method in [ExceptionAdvice](../spring_11_ssm/src/main/java/ssm/controller/ProjectExceptionAdvice.java)
#### Front-end and Back-end transaction
- use axios request in front end e.g [books.html](../spring_11_ssm/src/main/webapp/pages/books.html)
- Edit relevant functions

---
### 5. Interceptor
- now we have tomcat deployed our program and all `/*` request will be dispatched by setting by tomcat
- we are dealing with the dynamic pages. The request go through like follow:
  - filters -> Spring -> Central Controller -> each controller
- now we want to add interceptor before and after each controller
- so that we can execute some predefined code (authority check)
#### Difference between filter and interceptor
- filter belongs to Servlet. Interceptor belongs to SpringMVC
- filter boost all access, interceptor only inspect SpringMVC access
#### Steps
- By adding a [ProjectInterceptor.java](../spring_12_interceptor/src/main/java/inter/controller/interceptor/ProjectInterceptor.java) that extends from HandlerInterceptor
  - We can override the three method to control pre, post and afterCompletion
  - Remember to scan and load bean
- In the [SpringMvcSupport.java](../spring_12_interceptor/src/main/java/inter/config/SpringMvcSupport.java) define the path.
  - This should be a configuration class, and have to be added into component scan list.
  - override `addInterceptor()` method to put the path want to be intercepted
- We can also define `addInterceptor()` inside the SpringMvcConfig by implementing it from `WebMvcConfigurer`
- Now the steps go like
  - -> preHandle -> return true -> controller -> postHandle -> afterCompletion ->
#### Parameters
- request
- response
- handler: contained the method that we called
- modelAndView
- ex
#### Multiple Interceptor
if we have interceptor i1 and i2, if all return true at preHandle, the flow will be like
- -> i1.pre -> return true -> i2.pre -> return true -> controller -> i2.post -> i1.post -> i2.after -> i1.after

if i2 return false at preHandle, the flow will be like
- -> i1.pre -> return true -> i2.pre -> return false -> i1.after
- controller and post and i2.after won't be executed

Next: [MavenAdvance](MavenAdvance.md)
Next: [SpringBoot](SpringBoot.md)