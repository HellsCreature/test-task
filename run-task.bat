@REM Create database
psql -U postgres -p 5432 -f "./db-postgres.sql"

java -jar "task-0.0.1.jar"