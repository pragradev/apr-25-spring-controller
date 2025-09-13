## Controller# apr-25-spring-controller

HTTP Methods

ConcurrentHashMap
HashTable


Get - get data
Post - create new data
Put - update data (whole)
Delete - delete data 
Patch - update data (only update those which is asked for)

H2 Database
database - relational: In memory database: small scale
Datasource:  class in spring
URL
Username
password

Spring vs spring boot

tomcat
version resolver
auto configuration

DATA.SQL - DML - data manipulation lang CRUD - select/inser/update/delete
SCHEMA.SQL - DDL - DATA DEFINAITON LANG - create / alter

HIBERNATE: ORM : 
OBJECT RELATIONAL MAPPING
TRANSACTIONS
SESSION
CACHE LEVEL 1

MYBATIS: ORM: OBJECT RELATIONAL MAPPING

ONLY MAKE JAVA CLASSES/ DATABASE TABLES

J2EE - 
JAKARTA2EE - J2EE (REWROTE) - REACTIVE

SPRING: SPRING DATA JPA (JAVA PERSISTENT API) -> (6 - JAKARTA PERSISTENT API)
SPRING DATA JPA -> INTERFACES
INTERFACES PARENTS

Fetchtype : reading data - select
cascading : insert/ update/ delete

Deleting Data:

Hard delete - 10
soft delete - 90 , IsActive = 0/1

Consumption for API (Rest)
HTTP Clients

Rest Template (Spring Web)
Webclient - reactive framework : event loop & bus
Feign client - 

Make Application A: Product (e-commerce) CRUD operation : 9091
Application B: orders: CRUD: consume Product Application, use its GetById api
- persist into App B's database: 9092 (rest template code)


App A get Api, which can fetch git user data from github
App B: Git User CRUD: Post call to insert new git user with username: 
    - use that username: and consume App A api, which will give you all git user info
    - persist that to db
    - return it back
    - rest of operation should be with your own db
spe operation : - for get API with username: first check in database:
                - if you have record fir that username: fetch it from db and give response back
                - if you have not record in db: then consume App A: fetch data: persist data and then send response back


fallback: circuit braker design patter


feign client: Netflix, declarative, 

SONAR: code quality
sonar qube: 