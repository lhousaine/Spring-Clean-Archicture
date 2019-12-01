# shop-back-end
This project is builded with The spring framework of java EE,I was using multiple spring modules like :
Spring Boot : to create stand-alone, production-grade Spring based Applications.
Spring Data : for interacting with the database .
Spring Security : to secure all endpoints , I add the JWT models for authenticating users, 
Spring Data Rest : makes it easy to build hypermedia-driven REST web services on top of Spring Data repositories.
JPA : it is a Java specification for accessing, persisting, and managing data between Java objects / classes and a relational database. 
Mockito and Junit : for creating all functions tests.
The architecture of the project follows the principles of Clean Architecture. It is a simple api endpoint . 
It is list shops filtering by users likes, dislikes and coordinates. it offer a user to authenticate or creating an account by his mail and password .
in this I have worked with the TDD-Test driven developpement. 
So,the project is composed by two mainly directories :
Main : for java coding features of the app .
Test : is like Main, it contains the same directories as Main contains. it is creating create tests of all logic functions of the project.
the Main diretory is compose of directoies :
Core : is composed of the features that are constents and shared bettwen all the others part of proeject , it is composed by :
    Converters : it is contains functions used to convert from entities to dto and inversly from dto to entities,
                to do that, I am using the BeanUtils with it's functions
    Exceptions : Contatins all Costums defined Exceptions .
    InitData: contains data used to load to the database when the application was runing.
    Security : contains all features used for securing the api, as configuring the Security , Creation of jwt Token...
    Utils : it is contains somme functions that will used in the services of the project, for example the functions sorting shops but the distance to user coordinates .
Data: composed by three parts :
    Dto : in any application or project we need to give the user just the minimum of information, so in this part of data layer we create objects from entity,but somme missing fields ; as an example , in case of user, we don't want to send every a password to user, so we will define it the userDto.  
    Entities : These are the business objects of the application.
    Repositories : Convert and present data to the services layer from the database.
Services : it contains all functions job of required by the controllers .this all functions returns data as dto objects.
Web : 
    Controllers : they are rest controllers permet to build all endpoints of the api .
    Exceptions : I am trying to customize exceptions and it status code .


