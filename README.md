# vdb

The main project is a database application based on Jakarta EE technologies. It uses WildFly, PostgreSQL, JPA, CDI, and PrimeFaces to access and present data from a database.

## Software versions
Compile date: 2025-11-04
- OpenJDK 21
- Apache Maven 3.8+
- PostgreSQL 13+
- Driver: postgresql-42.3.1.jar
- WildFly 38.0.0.Final
- PrimeFaces 15 (Jakarta)

## Subprojects

There are four main modules:

1) gc-a0 : JPA project for working with the database (data model)
2) gc-a1 : Web application (PrimeFaces Facelets, CDI, Java beans, etc)
3) gc-a2 : RESTful web services (publishes REST endpoints using gc-a0 data)
4) gc-a4 : Standalone REST client (automated POST/GET testing)

## New Features
- Modernized to Jakarta EE and latest PrimeFaces
- Automated deploy.cmd menu for building, deploying, and running REST clients
- .gitignore for excluding build and dependency folders

## Setup Steps

### 1. Install JDK
- Download OpenJDK 21 or later
- Add JDK path to system PATH (optional)

### 2. Install Maven
- Download and unpack Maven
- Add Maven path to system PATH
- Configure proxy if needed

### 3. Compile Project
- Run `mvn clean install` in the project root
- Recompile after any code or configuration changes

### 4. Install WildFly
- Download and unpack WildFly 38+
- Start WildFly to verify installation
- Modify ports in standalone.xml if needed

### 5. Install PostgreSQL
- Download and install PostgreSQL
- Set default password (e.g., "1q2w3e")
- Create database "myDB"

### 6. Install PostgreSQL Driver & Configure Data Source in WildFly
- Download JDBC driver
- Use jboss-cli to add module and driver
- Example commands:
  - `module add --name=org.postgres --resources=postgresql-42.3.1.jar --dependencies=jakarta.api,jakarta.transaction.api`
  - `/subsystem=datasources/jdbc-driver=postgres:add(driver-name="postgres",driver-module-name="org.postgres",driver-class-name=org.postgresql.Driver)`
  - `data-source add --jndi-name=java:/myDB --name=myDB --connection-url=jdbc:postgresql://localhost/myDB --driver-name=postgres --user-name=postgres --password=1q2w3e`

### 7. Configure Application Connection
- Edit persistence.xml to use the correct JNDI name
- Recompile the project

### 8. Deploy the Project
- Use deploy.cmd menu for deployment:
  - Option 1: Deploy gc-a1 (web app)
  - Option 2: Deploy gc-a2 (RESTful app)
  - Option 3: Deploy both
  - Option 4: Prepare gc-a4 and run RESTClientPOST
- Or manually copy gc-a1.war/gc-a2.war to WildFly deployments directory

### 9. Test the Web Application
- Access http://localhost:8080/gc-a1/
- Use the menu to navigate (Greet, Users, Books, etc)

### 10. Test REST Endpoints and Clients
- Access REST endpoints via gc-a2 (e.g., /rest/message/measure/...)
- Use gc-a4 module and deploy.cmd option 4 to run RESTClientPOST/GET

### 11. Verify Database Effects
- Records created via the web interface should appear in the database
- Changes in the database should be reflected in the application

## Notes
- All build and dependency folders (target, lib) are excluded from git via .gitignore
- For troubleshooting, check WildFly logs and REST client output
- For further upgrades, update dependencies in pom.xml and redeploy
