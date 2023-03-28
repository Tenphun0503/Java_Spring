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
- Case 1: Using XML file to implement IoC.
  1. Configure [xml file](../src/main/resources/applicationContext.xml)
  2. Get container and create bean in [app.java](../src/main/java/org/tenphun/ioccase1/App2.java)




### 2. Basic Operation

## 2. AOP & Aspects
### 1. Terms
### 2. AOP Basic Operation
### 3. AOP Development

## 3. Data Access & Data Integration
### 1. Transaction

## 4. Web
## 5. Test

 