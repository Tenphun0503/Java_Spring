# Maven Advance
Sub-module development and design
## Intro
Divide whole project into a few modules, design mutual call and interface sharing between modules

## How to extract
Use [spring_11_ssm](../spring_11_ssm) as example
- extract domain and new a module for it, e.g. spring_pojo
- now we lost it but many code depend on it, so we add it as dependency in pom.xml
  - in pom.xml of the original module, add dependency spring_pojo
  - in maven setting, under spring_pojo/lifecycle, we install it into our local maven repository

## Dependency Transitivity
- If module2 depends on module3 and module1 depends on module2, 3.
We add module3 as dependency in module2, and we only have to add module2 in 1.

## Optional Dependency
- add `<optional>true</optional>` under coordination of the dependency can make it available only in current module
- set optional dependency will hide if from other modules

## Exclude Dependency
- add `<exclusions>` can exclude unwanted indirect dependencies of a dependency

## Inheritance and aggregation
### Aggregation
the ability to build multiple modules together as a single build
- Create a parent module that will serve as the aggregator. This parent module will contain a pom.xml file that lists all the subprojects that should be included in the build.
- add `<packaging>pom</packaging>` in the parent module (web-war, default-jar)
- add in `<modules>` `<module>../moduleName</module>` to include modules
### Inheritance
the ability for a child project to inherit configuration settings from a parent project
- in each child project's pom.xml file, specify the parent project as the parent of the current project with `parent`
- in the parent project's pom.xml file contains the common settings
  - add dependencies and they will apply to all children project
  - add into `<dependencyManagement>`, children module can choose to use it or not
    - if a child module want to include, it has to add dependency into its pom.xml without version clarify

## Properties
properties are variables that can be used to store and reuse values throughout pom.xml file.
```
<properties>
  <spring.version>5.2.10</spring.version>
</properties>
```
- Properties can be referenced anywhere in the pom.xml file using the syntax `${propertyName}`
`${spring.version}`
- we can also define variable that can be used in other configuration files (jdbc.properties)
  - e.g. `<jdbc.user>user</jdbc.user>` in pom.xml
  - `jdbc.username=${db.username}` in jdbc.properties
  - to link them, we have to indicate the location of the configuration files
    - use `<resources>`
    ```
     <build>
       <resources>
         <resource>
           <directory>${project.basedir}/src/main/resources</directory>
           <filtering>true</filtering>
         </resource>
       </resources>
     </build>
    ```
    

## Profiles
profiles are a way to customize the build process based on different environments, such as development, testing, and production.
- e.g. jdbc.url changes when we send our project to test team
```
<profiles>
  <profile>
    <id>development</id>
    <properties>
      <jdbc.url>jdbc:mysql://127.0.0.1:3306/mydb</jdbc.url>
    </properties>
    <activation>
      <activeByDefault>true</activeByDefault>
    </activation>
  </profile>
  <profile>
    <id>test</id>
    <properties>
      <jdbc.url>jdbc:mysql://127.0.2.2:3306/mydb</jdbc.url>
    </properties>
  </profile>
</profiles>
```
- activation: set as current environment