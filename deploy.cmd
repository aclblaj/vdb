@echo off
rem the wildfly path must exists
set WILDFLY_HOME=C:\Software\Java\wildfly-38.0.0.Final

:menu
cls

echo =============================
echo   WildFly Deployment Menu
echo =============================
echo 1. Deploy gc-a1 (web app)
echo 2. Deploy gc-a2 (RESTful app)
echo 3. Deploy both
echo 4. Prepare gc-a4 and run RESTClientPOST
set /p option=Choose an option (1-4):

if "%option%"=="1" goto deploy_gc_a1
if "%option%"=="2" goto deploy_gc_a2
if "%option%"=="3" goto deploy_both
if "%option%"=="4" goto prepare_gc_a4

echo Invalid option. Please choose 1, 2, 3, or 4.
pause
goto menu

:deploy_gc_a1
rem copy and deploy the binaries of web application to the deployments directory
copy gc-a1\target\gc-a1.war "%WILDFLY_HOME%\standalone\deployments\"

pause
goto end

:deploy_gc_a2
rem copy and deploy RESTful web services application
copy gc-a2\target\gc-a2.war "%WILDFLY_HOME%\standalone\deployments\"
pause
goto end

:deploy_both
rem copy and deploy the binaries of web application to the deployments directory
copy gc-a1\target\gc-a1.war "%WILDFLY_HOME%\standalone\deployments\"
rem copy and deploy RESTful web services application
copy gc-a2\target\gc-a2.war "%WILDFLY_HOME%\standalone\deployments\"
pause
goto end

:prepare_gc_a4
rem Build gc-a4 and copy dependencies
echo mvn clean install
echo mvn dependency:copy-dependencies -DoutputDirectory=target/lib -pl gc-a4
rem Run RESTClientPOST
echo java -cp "gc-a4/target/classes;gc-a4/target/lib/*" org.utbv.mitb.jerseyclient.RESTClientPOST
pause
goto end

:end
