**About:**
This Web API application for basic task tracker. 
It allows keeping information about projects and tasks.
Application works on 8080 port.
For information exchange used HTTP requests.
To access documentation check http://localhost:8080/swagger-ui.html#/

**System configuration:**
Processor	Intel(R) Core(TM) i5-9300H CPU @ 2.40GHz;
Installed RAM	16.0 GB (15.8 GB usable);
System type	64-bit operating system, x64-based processor;
Windows 10 Enterprise Version 20H2 OS build	19042.1586

**System settings:**
1. JAVA_HOME environment variable should contain path to java JDK version 8 or higher.
2. PostgreSQL version 14 should be installed and launched on port 5432.
3. Environment variable "Path" should contain path to psql.exe.

**Startup:**
1. Set PostgreSQL super user login ("postgres" by default) in "run-task.bat", on the second line:
   psql -U **postgres** -p 5432 -f "./db-postgres.sql"
2. Run "run-task.bat" and enter password for PostgreSQL super user.
3. Make your requests at http://localhost:8080 (for example http://localhost:8080/projects)

**All external libraries are stored in "./lib" folder.**

**Used pattern:**
MVC (Spring-MVC)

**Used technologies:**
Spring Boot; Spring JPA; Swagger2; PostgreSQL database.
