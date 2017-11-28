# vdb

The main project is a database project based on the JEE technologies. It uses Wildfly, PostgreSQL, JPA, CDI, Primefaces to access and present data from a database.

There are three projects:

1) gc-a0 : JPA projects for working with database (data model project)

2) gc-a1 : Web project (Primefaces facelet project with CDI, Java beans, etc)

3) gc-a2 : Web project for publishing RESTfull web services using also the gc-a0 data

In the following are presented the steps needed to compile, deploy and test the project.

## S1) install JDK: http://www.oracle.com/technetwork/java/javase/downloads/index-jsp-138363.html

a) note down path to JDK 

b) add the JDK path into the system path (optional)

## S2) install maven: http://maven.apache.org/download.cgi

a) download it and unpack it

b) add the maven path to the system path

c) check the proxy for the maven when behind the proxy

## S3) compile project 

a) mvn clean install

b) mvn is the maven compiler which resides in the %MAVEN_HOME%\bin

c) compilation has to be done after each modification in scripts

## S4) install Wildfly: http://wildfly.org/downloads/

a) download it and unpack it

b) start it with no modification to check if works 

c) modify port when needed (in standalone.xml change the ports offset (${jboss.socket.binding.port-offset:500}) - it adds the value to all used ports)

## S5) install postgreSQL: https://www.postgresql.org/download/

a) download, run the installation and set default password to "1q2w3e"

b) create the empty database "myDB"


## S6) install postgresql driver and create the data source name (into wildfly): https://jdbc.postgresql.org/download.html

a) download the driver 

b) run jboss_cli.bat from %WILDFLY_HOME%\bin

c) run "connect" or "connect localhost:10490 " (if ports are changed 10490=9990+500)

d) run the command (with the proper jar file):

module add --name=org.postgres --resources=postgresql-9.4-1211.jdbc42.jar --dependencies=javax.api,javax.transaction.api

e) activate the use of postgres driver by runnging:

/subsystem=datasources/jdbc-driver=postgres:add(driver-name="postgres",driver-module-name="org.postgres",driver-class-name=org.postgresql.Driver)

f) define the java data source connection by runnging:

data-source add --jndi-name=java:/myDB --name=myDB --connection-url=jdbc:postgresql://localhost/myDB --driver-name=postgres --user-name=postgres --password=1q2w3e

- the database "myDB" has to be created on into the database server

- the user for the connection is "postgres" and the password is "1q2w3e" (if it is the case they have to be changed to own database credentials)
	
- the localhost can be changed to another computer name or IP that hosts a database (also the database username and password has to be modified)
	
## S7) modify aplication connection to point to the created connection

a) into the persistence.xml file change the jndi name to the new defined one

b) recompile the project

## S8) deploy the project 

a) copy the war file (gc-a1.war) into the "deployments" directory

b) check server console (or log file) to see that no errors are appearing

## S9) check the web application

a) access into the browser http://localhost:8080/gc-a1/ (or 8580)

b) add some new records

## S10) check the effects into the database

a) the created records on the web interface of the application should be present into the database vdb2016

b) create new records directly into the db, this has to be visible on the application web interface
