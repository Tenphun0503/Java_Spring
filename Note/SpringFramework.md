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
2. Use [Annotation](../spring_02_annotation/src/main/java/annotation/dao/BookDaoImpl.java) to set beans
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
1. Add dependencies
2. Create JoinPoint (The original methods such as Dao interfaces and its implementation)
3. Create Advice
4. Create Pointcut
5. Create Aspect (Binding the relation of the advice and pointcut)
### 3. AOP Development

## 3. Data Access & Data Integration
### 1. Transaction

## 4. Web
## 5. Test

 