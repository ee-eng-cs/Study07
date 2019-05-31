@echo on
@set SITE=http://localhost:8080
@set CURL=c:\tools\curl-7.58.0\bin\curl.exe
@set CURL=%CURL% -g -i -H "Accept: application/json" -H "Content-Type: application/json"
@set HR_YELLOW=@powershell -Command Write-Host "----------------------------------------------------------------------" -foreground "Yellow"
@set HR_RED=@powershell    -Command Write-Host "----------------------------------------------------------------------" -foreground "Red"

:home
%HR_YELLOW%
@powershell -Command Write-Host "Home" -foreground "Green"
%CURL% "%SITE%/"
@echo.&pause

:get
%HR_YELLOW%
@powershell -Command Write-Host "GET company" -foreground "Green"
%CURL% "%SITE%/company"
@echo.

:finish
%HR_RED%
@powershell -Command Write-Host "FINISH" -foreground "Red"
pause