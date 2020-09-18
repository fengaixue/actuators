
@echo off & color 3d & setlocal enabledelayedexpansion 
  ::ipconfig>ip.txt
 
  
netstat -aon |findstr 9099>pid.txt
	 
     for /f "delims=" %%a in (pid.txt) do (
		
      for /f "tokens=1* delims=:" %%i in ('call echo %%a^|find /i "TCP"') do (
     	 echo %%a
	 ::读取出内容过滤后,写入另一个记事本中
	 rem Echo %%a>>"text.txt"
        )  
    )
rem 读取文件中内容

set /P OEM=<pid.txt
 
rem 截取文件中的字符串
 
echo  %OEM:~71,76%
 
taskkill /f /pid %OEM:~71,76%

start   javaw -Dfile.encoding=utf-8  -Xms1024m -Xmx1024m -jar D:\mineJar\local9099.jar

exit