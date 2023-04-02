# Spring Framework

## 1. Core Container

### 1. IoC/DI
#### Coupling
- "Coupling" refers to the degree to which one module or component in a system is dependent on another module or component.
- High coupling means that changes to one module can have a significant impact on other modules, which can make the system more difficult to maintain, test, and evolve over time.
- > IoC helps reduce coupling
#### IoC (Inversion of Control)
- IoC allows for the creation and management of objects by a container, 
rather than the developer, which makes the code easier to maintain.
- > IoC new objects in containers, so that you don't have to new them in your class.
#### IoC Container
- Spring provides an IoC container that implements the idea of IoC.
- > Spring uses .xml to set beans to implement IoC.
- **Case 1: Using XML file to implement IoC**.
  1. Configure [xml file](../spring_01_xml/src/main/resources/applicationContext.xml)
  2. Use `property` label to set the all referenced objects.
  3. Get container and create bean in [app.java](../spring_01_xml/src/main/java/xml/App2.java)
#### Bean
- Objects that created and controlled in the IoC container are called Bean.
- `<bean></bean>` is the tag pair to define a bean.
  e.g. `bean id="bookDao" name = "dao dao1" class="BookDaoImpl"/>`
- `id` sets only identify name for the bean, while `name` sets nicknames for the bean. (Which are used in `getBean()`)
- `scope` decides whether single instance or multiple instances. e.g. Two objects created by `getBean()` are different if `scope="prototype"`
- `init-method` and : Call lined method on creation of the bean.
- `destroy-method`: Call linked method on the destruction. Need to call `ctx.close()` or `ctx.registerShutdownHoot()`
- > Life-cycle control methods can be also set by implementing interfaces `InitializingBean` and `DisposableBean`
- **Case 2: Three types of instantiate bean**
  1. Use Constructor of the class
  ```xml
  <bean id="bookDao" class="BookDao"/>
  ```
  2. Use static factory (See [BookDaoFactory](../spring_01_xml/src/main/java/xml/dao/BookDaoFactory.java))
  ```xml
  <bean id="bookDao" class="BookDaoFactory" factory-method="getBookDao"/>
  ```
  3. Use instance factory
  ```xml
  <beans>
  <bean id="bookDaoFactory" class="BookDaoFactory"/>
  <bean id="bookDao" factory-method="getBookDao" factory-bean="bookDaoFactory"/>
  </beans>
  ```
- > For the 3rd type, Spring improved it by setting [FactoryBean](../spring_01_xml/src/main/java/xml/dao/BookDaoFactoryBean.java) so that it can be more generalized.
#### DI (Dependency Injection)
- This design pattern allows fot the automatic injection of dependencies into objects.
- > If one class depends on another one, IoC binds and loads them together.
- Different DI methods:
  - setter 
    - for simple types (int, String...)
      1. Provide setter method
      2. in `<property>` set `name` and `value`
    - for reference types
      1. Provide setter method
      2. in `<property>` set `name` and `ref`
  - Constructor
    - for simple types
      1. Provide Constructor method
      2. in `<constructor-arg>` set `name` and `value`
    - for reference types
      1. Provide Constructor method
      2. in `<constructor-arg>` set `name` and `ref`
  - Autowire
    1. Provide setter method
    2. in `<bean>` set `autowire = byType or byName`
> Now we can easily set up a bean of a class, even from 3rd-party. E.g. Connecting database. 
> We can also use a better way: load properties file, with "${}"

#### Use Annotation to develop
1. Edit [.xml](../spring_02_annotation/src/main/resources/ApplicationContext.xml)
2. Use `@Component` [Annotation](../spring_02_annotation/src/main/java/annotation/dao/BookDaoImpl.java) to set beans
3. Use [Config](../spring_02_annotation/src/main/java/annotation/config/SpringConfig.java) class to replace xml setting file.
4. In [dependent class](../spring_02_annotation/src/main/java/annotation/service/BookServiceImpl.java), use `@Autowired` to DI. 
5. For simple types injection, we use `@Value("value")`. We can also set `@PropertySource` in config class to load properties file
- > With `@Autowired`, we no longer need setter method. If we have multiple implement classes, we use `@Qualifier("name")` to set name.  
- > With `@Import` in SpringConfig, we can load other config class.
#### Some common Exception
- `NoSuchBeanDefinitionException`: Spring is unable to find a bean definition for a specified bean name or class;
- `BeanCreationExcpetion`: Spring is unable to create a bean. Check the no-para constructor of the class.

### 2. Basic Operation
#### Mybatis
1. See a [Mybatis sample](../spring_03_mybatis), which works without Spring
2. Now we combine myBatis and Spring together
   1. Add relevant [dependencies](../spring_04_mybatis2/pom.xml)
   2. Convert SqlMapConfig.xml to config class: [MybatisConfig](../spring_04_mybatis2/src/main/java/mybatis/config/MybatisConfig.java),
   Set `typeAliases`, `dataSource` and `mapper` 
   3. For `dataSource`, set [JdbcConfig](../spring_04_mybatis2/src/main/java/mybatis/config/JdbcConfig.java)
   4. Set [SpringConfig](../spring_04_mybatis2/src/main/java/mybatis/config/SpringConfig.java) and import above config classes
   5. Edit [App.java](../spring_04_mybatis2/src/main/java/mybatis/App.java)
> Don't combine `MybatisConfig` and `JdbcConfig`, it results circular dependency, which will give an error.
#### Junit
- See how Spring combines [Junit](../spring_05_junit/src/test/java/mybatis/service/AccountServiceTest.java)


## 2. AOP & Aspects
### 1. Terms
- **AOP (Aspect Oriented Programming)** is a programming paradigm that aims to increase the modularity and maintainability of software systems by separating cross-cutting concerns from the main program logic
- **JoinPoint**: A join point is a point in the execution of a Spring-managed object's method where an aspect can be applied. Examples of join points include method calls, method execution, and exception handling.
- **Pointcut**: A pointcut is a predicate that defines which join points an aspect should be applied to. Pointcuts are typically defined using annotations or XML configuration.
- **Advice**: Advice is the code that is executed at a join point. In Spring AOP, there are four types of advice: Before, After, AfterReturning, and AfterThrowing.
- **Aspect**: An aspect is a modular unit of cross-cutting concern that is applied to Spring-managed objects. Aspects are typically defined using annotations or XML configuration.
### 2. AOP Basic Operation
#### Quick Start
1. Add [dependencies](../spring_06_aop_quickstart/pom.xml)
2. Create JoinPoint (The original methods such as Dao interfaces and its implementation)
3. Create [Advice](../spring_06_aop_quickstart/src/main/java/start/aop/MyAdvice.java)
4. Create Pointcut
5. Create Aspect (Binding the relation of the advice and pointcut)
#### Pointcut Expression  
A pointcut expression is a predicate that selects one or more join points in a program where an aspect's advice should be applied.  
- Convention: `actionKeyWord ([accessModifier] return package.class/interface(parameters) [exception])`
- We can also use wildcard:
  - `*` e.g. `execution(public * com.example.*.UserService.find* (*))`   
  // All methods start with 'find', has just one input and return a value, in UserService under any(but one level) of 'com.example' package.
  - `..` e.g. `execution(public User com..UserService.findById(..))`
  // findById() methods in UserService with any input and under any of 'com' package
  - `+` e.g. `execution(* *..*Service+.*(..))
  // Any methods in subclasses of class which class name end with 'Service'. 
  > return any methods: `@Pointcut("execution(* *..*(..))")`
#### Different Advice Type
1. `@Before(pointcut())`
2. `@After(pointcut())`
3. `@Around(pointcut())`: **Around Advice** requires clarifying pointcut method, and return any possible value in type of Object:
    ```
      public Object Around(ProceedingJoinPoint pjp) throw Throwable{
          beforeMethod();
          Object res = pjp.proceed(); //Clarify pointcut, and get return value
          afterMethod();
          return res;  // return value;
      } 
    ```
4. `AfterReturning(pointcut())`: execute only if pointcut method is successfully executed
5. `AfterThrowing(pointcut())`: execute only if pointcut method throws  exception
#### Get arguments of pointcut method
1. in `@Before` and `@After`, use `joinPoint jp.getArgs()`. 
2. in `@Around`, use `pjp.getArgs()`. Since `@Around` has to use `pjp.proceed()`, one can pre-edit args get from `getArgs()` and pass to `proceed(args)`
- > It facilitates   some function development, such as check if the input values are valid.
3. For `@AfterReturning` and `@AfterTrowing`, set parameters after them to get return or exception. e.g.`@AfterReturning(value="pt()", returning="ret")`
### 3. AOP Development
#### Case
- Requirement: Measure Execute Time of Every Service Interface.
  - Set up [Advice.java](../spring_07_aop_speed/src/main/java/speed/aop/Advice.java)
> `getSignature()` of `ProceedingJoinPoint pjp` provides information of the pointcut method.   
> Include className `signature.getDeclaringTypeName()` and methodName `signature.getName()`, can be used to distinguish method.

## 3. Data Access & Data Integration
### 1. Transaction

## 4. Web
## 5. Test

 