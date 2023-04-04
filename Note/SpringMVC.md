# Spring MVC
Spring MVC is a Java-based web application framework that follows the Model-View-Controller (MVC) architectural pattern. 
It provides a flexible way to develop web applications by separating the concerns of data handling, user interface rendering, and application flow control.
---
### 1. Introduction 
#### Base Steps:
1. Set Dependencies: [pom.xml](../spring_09_mvc_demo/pom.xml)
2. Define Controller: [UserController](../spring_09_mvc_demo/src/main/java/demo/springmvc/UserController.java)
3. Define SpringConfig: [SpringMvcConfig](../spring_09_mvc_demo/src/main/java/demo/config/SpringMvcConfig.java)
4. Define Servlet Container Init Config: [ServletContainersInitConfig](../spring_09_mvc_demo/src/main/java/demo/config/ServletContainersInitConfig.java)
5. For Component of Spring, we can exclude scanning bean of SpringMVC: [SpringConfig](../spring_09_mvc_demo/src/main/java/demo/config/SpringConfig.java)
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
Use Filter: [ServletContainersInitConfig](../spring_10_mvc_request/src/main/java/mvc/config/ServletContainersInitConfig.java)
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



---
### 4. SSM

---
### 5. Interceptor