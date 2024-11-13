@echo off
setlocal

rem Imposta i percorsi relativi
set CLIENT_BIN_DIR=Client\bin
set CLIENT_SRC_DIR =Client\src
set LIB_DIR=lib

rem Verifica che la directory del client esista
if not exist "%CLIENT_BIN_DIR%" (
    echo La directory del client non esiste: %CLIENT_BIN_DIR%
    exit /b 1
)

rem Verifica che il file del driver MySQL esista
if not exist "%LIB_DIR%\mysql-connector-java-8.0.17.jar" (
    echo Il file del driver MySQL non esiste: %LIB_DIR%\mysql-connector-java-8.0.17.jar
    exit /b 1
)

rem Verifica che il file MainTest.class esista
if not exist "%CLIENT_BIN_DIR%\MainTest.class" (
    echo Il file MainTest.class non esiste in %CLIENT_BIN_DIR%
    exit /b 1
)
REM Cambia la directory di lavoro nella cartella del progetto
cd /d %CLIENT_BIN_DIR%
rem Esegui la classe MainTest con il driver MySQL incluso nel classpath
echo Esecuzione del client con classpath: %CLIENT_BIN_DIR%;%LIB_DIR%\mysql-connector-java-8.0.17.jar
java -cp "..\bin;C:\Users\user\Desktop\estensioneprov\lib\mysql-connector-java-8.0.17.jar" MainTest 127.0.0.1 2025

pause

