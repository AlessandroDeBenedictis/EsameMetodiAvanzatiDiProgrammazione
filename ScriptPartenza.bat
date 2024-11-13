@echo off
setlocal

REM Chiede il nome utente per entrare nel database
set /p USER=Inserisci il nome utente per il database: 

mysql -h localhost -u %USER% -p  < exampletab.sql

REM ora è dentero MySQL
REM Esegue il comando MySQL per accedere al database
REM Sostituisci `exampletab.sql` con il percorso relativo del tuo file SQL
endlocal
pause
exit
