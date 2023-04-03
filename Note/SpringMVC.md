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


---
### 3. Restfull

---
### 4. SSM

---
### 5. Interceptor