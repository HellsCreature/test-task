DROP TABLE IF EXISTS projects;
CREATE TABLE projects(
    id serial PRIMARY KEY,
    name VARCHAR(255),
    start_date DATE,
    completion_date DATE,
    status INTEGER,
    priority INTEGER
    );

DROP SEQUENCE IF EXISTS hibernate_sequence;
CREATE SEQUENCE hibernate_sequence START 12;

DROP TABLE IF EXISTS tasks;
CREATE TABLE tasks(
    id serial PRIMARY KEY,
    name VARCHAR(255),
    status INTEGER,
    project_id INTEGER,
    description VARCHAR(255),
    priority INTEGER
    );