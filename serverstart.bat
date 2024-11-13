@echo off
setlocal

REM Percorso del progetto relativo a estensioneprov
set PROJECT_DIR=server\src

REM Cambia la directory di lavoro nella cartella del progetto
cd /d %PROJECT_DIR%

REM Avvia il server, includendo il driver MySQL nel classpath
java -cp ".;..\..\lib\mysql-connector-java-8.0.17.jar" Main

endlocal
pause