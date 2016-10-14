rem the wildfly path must exists
set WILDFLY_HOME=D:\work\java\wildfly-10.0.0.CR2\

rem copy and deploy the binaries of web application to the deployments directory
copy gc-a1\target\gc-a1.war %WILDFLY_HOME%\standalone\deployments\

pause

rem copy and deploy RESTful web services application
rem copy gc-a2\target\gc-a2.war %WILDFLY_HOME%\standalone\deployments\
rem pause