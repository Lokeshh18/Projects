@echo off
echo ============================================
echo   Expense Tracker - Spring Boot Application
echo ============================================
echo.
echo Starting server on http://localhost:8080
echo.
echo Press Ctrl+C to stop the server
echo.

cd /d "%~dp0"

REM Check if Maven is already downloaded
if not exist ".mvn\wrapper\apache-maven-3.9.6\bin\mvn.cmd" (
    echo Downloading Maven...
    powershell -Command "Invoke-WebRequest -Uri 'https://repo.maven.apache.org/maven2/org/apache/maven/apache-maven/3.9.6/apache-maven-3.9.6-bin.zip' -OutFile '.mvn\wrapper\maven.zip'"
    powershell -Command "Expand-Archive -Path '.mvn\wrapper\maven.zip' -DestinationPath '.mvn\wrapper' -Force"
)

REM Run Spring Boot
".mvn\wrapper\apache-maven-3.9.6\bin\mvn.cmd" spring-boot:run

pause
