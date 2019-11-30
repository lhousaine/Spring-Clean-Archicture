# shop-back-end
This project is built with The spring framework of java EE, I was using multiple spring modules like :  
**Spring Boot** : to create stand-alone, production-grade Spring based Applications.</br> 
**Spring Data**: for interacting with the database.  
**Spring Security**: to secure all endpoints, I add the JWT models for authenticating users.</br>
**Spring Data Rest** :makes it easy to build hypermedia-driven REST web services on top of Spring Data repositories.</br>
**JPA**: it is a Java specification for accessing, persisting, and managing data between Java objects / classes and a relational database.</br>
**Mockito and Junit** :for creating all functions tests.</br>
     The architecture of the project follows the principles of Clean Architecture. It is a simple API endpoint.
It is list shops filtering by users likes, dislikes and coordinates. It offers a user to authenticate or creating an account by his mail and password.</br>
In this I have worked with the TDD-Test driven development.
So, the project is composed by two mainly directories :</br>
**Main** : for java coding features of the app.</br>
**Test** : is like Main, it contains the same directories as Main contains. It is creating create tests of all logic functions of the project.</br>
The Main directory is composed of directories :</br>
**Core** : is composed of the features that are constants and shared between all the others part of project, it is composed by :</br>
**Converters** : it is contains functions used to convert from entities to dto and inversely from dto to entities,
to do that, I am using the BeanUtils with its functions
**Exceptions** : Contains all Costumes defined Exceptions.</br>
**InitData**: contains data used to load to the database when the application was running.</br>
**Security** : contains all features used for securing the API, as configuring the Security, Creation of JWT Token...</br>
**Utiles** : it is contains some functions that will used in the services of the project, for example the functions sorting shops but the distance to user coordinates.</br>
**Data**: composed by three parts :</br>
**DTO** : in any application or project we need to give the user just the minimum of information, so in this part of data layer we create objects from entity, but some missing fields ; as an example, in case of user, we don't want to send every a password to user, so we will define it the userDto.</br>
**Entities** : These are the business objects of the application.</br>
**Repositories** : Convert and present data to the services layer from the database.</br>
**Services** : it contains all functions job of required by the controllers.this all functions returns data as DTO objects.</br>
**Web**:  </br>
**Controllers** : they are rest controllers permit to build all endpoints of the API.</br>
**Exceptions** : I am trying to customize exceptions and it is status code.



