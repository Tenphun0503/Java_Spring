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
#### Exception Handler
#### Exception Handle


---
### 5. Interceptor