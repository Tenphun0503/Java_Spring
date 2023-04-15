  # SpringBoot
Spring Boot is used for building and deploying web applications and microservices.
It simplifies Spring setup and development
## Use
- We skip the setting of pom.xml and SpringConfig, SpringMvcConfig..
- Add [BookController](../spring_13_boot_demo/src/main/java/demo/controller/BookController.java)
- Then we can run and send request
## Quick Start
- Build package (run Maven package) -> get a `springboot.jar`
- `java -jar springboot.jar`
- now we deployed our server
## Configuration
SpringBoot provides three ways to configure the project
- `application.properties` 
- `application.yml`
- `application.yaml`
Priority: properties > yml > yaml
## yml convention
- to reference a value, same as before
```
@Value("${valueName}")
private String valueName;
```
- for multilevel and multiple values
```
@Value("${animal.human[0]})
private String head;
```
- or we can use `Environment` and `@Autowired`
```java
class Example{
    @Autowired
    private Environment en;
    public static void main(String[] args) {
        System.out.println(en.getProperty("lesson"));
        System.out.println(en.getProperty("animal.human[0]"));
    }
}
```
- we can creat a class and use `Component` and `ConfigurationProperties(prefix="properityName")` to get data from yml or yaml
## Multi profiles
we can set multiple environment setting in yml
```yaml
spring:
  profiles:
    active: dev
---
spring:
  config:
    activate:
      on-profile: dev
      
server:
  port: 80
  
---
spring:
  config:
    activate:
      on-profile: pro

server:
  port: 90
```
- After we package the jar file, we can run in terminal like below to change env
`java -jar project.jar --spring.profiles.active=test`
- Or change specific configuration
`java -jar project.jar --server.port=99`