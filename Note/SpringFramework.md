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
#### Bean
- Objects that created and controlled in the IoC container are called Bean.
#### DI (Dependency Injection)
- This design pattern allows fot the automatic injection of dependencies into objects.
- > If one class depends on another one, IoC binds and loads them together.
#### Getting Started Case
- **Case 1: Using XML file to implement IoC**.
  1. Configure [xml file](../src/main/resources/applicationContext.xml)
  2. Use `property` label to set the all referenced objects.
  3. Get container and create bean in [app.java](../src/main/java/org/tenphun/ioccase1/App2.java)
- > Now we know Spring uses .xml to set beans to implement IoC.
- `<bean></bean>` is the tag pair to define a bean. 
e.g. `bean id="bookDao" name = "dao dao1" class="BookDaoImpl" scope="prototype"/>`
- `id` sets only identify name for the bean, while `name` sets nicknames for the bean. (Which are used in `getBean()`)
- `scope` decides whether single instance or multiple instances. e.g. Two objects created by `getBean()` are different if `scope="prototype"`
 
- **Case 2: Three types of instantiate bean**
  1. Use Constructor of the class
  ```xml
    <bean id="id" class="class"/>
  ```
  2. Use static factory
  ```xml
    <bean id="id" class="factoryClass" factory-method="method of factory class that create the object"/>
  ```
  3. Use instance factory
  ```xml
    <beans>
        <bean id="factoryId" class="factoryClass"/>
        <bean id="id" factory-method="method of factory class that create the object" factory-bean="factoryId"/>
    </beans>
  ```
  for this type, Spring improved it so that it can be generalized. TODO: last log here.
#### Some common Exception
- `NoSuchBeanDefinitionException`: Spring is unable to find a bean definition for a specified bean name or class;
- `BeanCreationExcpetion`: Spring is unable to create a bean. Check the no-para constructor of the class.

### 2. Basic Operation

## 2. AOP & Aspects
### 1. Terms
### 2. AOP Basic Operation
### 3. AOP Development

## 3. Data Access & Data Integration
### 1. Transaction

## 4. Web
## 5. Test

 