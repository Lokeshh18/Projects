@REM ----------------------------------------------------------------------------
@REM Maven Start Up Batch script for Windows
@REM ----------------------------------------------------------------------------

@echo off
setlocal enableextensions enabledelayedexpansion

set MAVEN_PROJECTBASEDIR=%~dp0
set WRAPPER_JAR="%MAVEN_PROJECTBASEDIR%.mvn\wrapper\maven-wrapper.jar"
set WRAPPER_LAUNCHER=org.apache.maven.wrapper.MavenWrapperMain

set DOWNLOAD_URL="https://repo.maven.apache.org/maven2/org/apache/maven/wrapper/maven-wrapper/3.2.0/maven-wrapper-3.2.0.jar"

FOR /F "usebackq tokens=1,2 delims==" %%A IN ("%MAVEN_PROJECTBASEDIR%.mvn\wrapper\maven-wrapper.properties") DO (
    IF "%%A"=="wrapperUrl" SET DOWNLOAD_URL=%%B
)

if not exist %WRAPPER_JAR% (
    echo Downloading maven-wrapper from: %DOWNLOAD_URL%
    powershell -Command "& {Invoke-WebRequest -Uri '%DOWNLOAD_URL%' -OutFile '%WRAPPER_JAR%'}"
)

set MAVEN_ZIP=%MAVEN_PROJECTBASEDIR%.mvn\wrapper\apache-maven-3.9.6-bin.zip
set MAVEN_EXTRACT=%MAVEN_PROJECTBASEDIR%.mvn\wrapper\apache-maven-3.9.6
set MAVEN_HOME=%MAVEN_EXTRACT%\apache-maven-3.9.6

if not exist "%MAVEN_HOME%\bin\mvn.cmd" (
    if not exist "%MAVEN_ZIP%" (
        echo Downloading Maven 3.9.6...
        powershell -Command "& {$url='https://repo.maven.apache.org/maven2/org/apache/maven/apache-maven/3.9.6/apache-maven-3.9.6-bin.zip'; Invoke-WebRequest -Uri $url -OutFile '%MAVEN_ZIP%'}"
    )
    if not exist "%MAVEN_EXTRACT%" (
        echo Extracting Maven...
        powershell -Command "& {Expand-Archive -Path '%MAVEN_ZIP%' -DestinationPath '%MAVEN_EXTRACT%' -Force}"
    )
)

set PATH=%MAVEN_HOME%\bin;%PATH%
"%MAVEN_HOME%\bin\mvn.cmd" %*

endlocal
