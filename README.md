
# Azure Databases
Two general types of database - relational (SQL) and non-relational (usually called 'NoSQL')  

Azure can host databases from any vendor - either as IAAS (where you set up and configure everything yourself) or PAAS (where the databases is available as a service).  

Azure has 'Table Storage' or Azure Cosmos DB, which are NoSQL databases.  
This course had a guest lecture on CosmosDB from Niamh Stockil (they are not on the exam though).  

For relational databases, we can follow the following steps to set up a SQL Server database on Azure.  
Note, that it is assumed you have already studied 

## Create the server (and the database)
1. Log into the Azure Portal using your college email account
1. Create a resource
1. Search for SQL Database from Microsoft and select *Create*
   1. Database name should be obvious to you (if you call everything database1 you will suffer later)
   1. Ensure subscription is 'Azure for Students'
   1. Resource Group is either an existing one (if you made one earlier for an app and the database is to be used with that app) or a new one
   1. Source is *Blank database*
   1. Create a new server, ensure North Europe, a server admin login (use something other than admin and something you'll remember) and a new password for database access
   1. *Not now* for elastic pool
   1. Pricing tier - Basic is fine for what we are doing
   1. Pin to dashboard should be ticked
   1. Select *Create*

## Query Editor
1. Once the server/database is created, select the database and *Query Editor (preview)* on the left
1. Login (use the server admin login and password from the previous steps). Authorisation type is SQL server authentication
1. The Query editor allows you to execute SQL without having to have a seperate program
1. I used Mockaroo to generate some sample SQL for this tutorial (I edited true/false values to be 'true'/'false':

```sql
create table CustomerTable (
	id INT,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	amount DECIMAL(5,2),
	paid VARCHAR(50)
);
insert into CustomerTable (id, first_name, last_name, amount, paid) values (1, 'Carlee', 'Attoe', 76.41, 'false');
insert into CustomerTable (id, first_name, last_name, amount, paid) values (2, 'Jyoti', 'Binch', 70.31, 'true');
insert into CustomerTable (id, first_name, last_name, amount, paid) values (3, 'Marianne', 'Brazelton', 58.34, 'false');
insert into CustomerTable (id, first_name, last_name, amount, paid) values (4, 'Arvin', 'Polson', 21.32, 'true');
insert into CustomerTable (id, first_name, last_name, amount, paid) values (5, 'Ashely', 'Muddiman', 18.14, 'true');
insert into CustomerTable (id, first_name, last_name, amount, paid) values (6, 'Joeann', 'Sturzaker', 91.8, 'false');
insert into CustomerTable (id, first_name, last_name, amount, paid) values (7, 'Karina', 'Vanstone', 55.31, 'false');
insert into CustomerTable (id, first_name, last_name, amount, paid) values (8, 'Scottie', 'Venart', 2.53, 'true');
insert into CustomerTable (id, first_name, last_name, amount, paid) values (9, 'Tynan', 'Hallick', 80.5, 'true');
insert into CustomerTable (id, first_name, last_name, amount, paid) values (10, 'Elenore', 'Gillice', 48.23, 'false');
insert into CustomerTable (id, first_name, last_name, amount, paid) values (11, 'Sianna', 'Broader', 95.04, 'true');
insert into CustomerTable (id, first_name, last_name, amount, paid) values (12, 'Enrica', 'Witchalls', 56.78, 'false');
insert into CustomerTable (id, first_name, last_name, amount, paid) values (13, 'Tonie', 'Doy', 66.27, 'true');
insert into CustomerTable (id, first_name, last_name, amount, paid) values (14, 'Georgie', 'Dance', 77.76, 'true');
insert into CustomerTable (id, first_name, last_name, amount, paid) values (15, 'Abdel', 'Leckey', 77.28, 'true');
insert into CustomerTable (id, first_name, last_name, amount, paid) values (16, 'Constantina', 'Grimwood', 56.72, 'false');
insert into CustomerTable (id, first_name, last_name, amount, paid) values (17, 'Regen', 'Tomaszczyk', 50.55, 'true');
insert into CustomerTable (id, first_name, last_name, amount, paid) values (18, 'Lemmie', 'Kilbourne', 51.55, 'false');
insert into CustomerTable (id, first_name, last_name, amount, paid) values (19, 'Violetta', 'Becerro', 76.42, 'false');
insert into CustomerTable (id, first_name, last_name, amount, paid) values (20, 'Adham', 'Frankcomb', 76.35, 'false');
```

## Write a JDBC console app to query database
1. Use Maven to generate a new 'Hello World' type app: 
    1. archetype: **maven-archetype-quickstart**
    1. Define value for property 'groupId': **ie.examples**
    1. Define value for property 'artifactId': **JDBCConsoleApp**
    1. If you are having issues, it's the JDBCConsole app on Github 
1. Do a Maven install: **mvn install** to ensure it all completed successfully
1. If you get a surefire test error, you can just skip the tests with **mvn install -DskipTests** 

### Connecting to the database
1. Because we are connecting to an Azure SQL Server database, we need some things:
   1. The JDBC driver for MS SQL Server
      1. Add the following dependency to the POM.xml for your project
   1. The JDBC connection strings from Azure, (and the server admin login and password)
1. To execute the code, use the Maven command: **mvn exec:java -D"exec.mainClass"="ie.examples.App"**

## Write a Vaadin app to query the database

## Data Grids in Vaadin apps
