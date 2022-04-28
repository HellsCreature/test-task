INSERT INTO projects(id, name, start_date, completion_date, status, priority) VALUES(1, 'Project ONE', '2022-03-01', '2022-03-22', 2, 3);
INSERT INTO tasks(id, project_id, name, status, description, priority) VALUES(4, 1, 'Task ONE', 2, 'Description task1', 1);
INSERT INTO tasks(id, project_id, name, status, description, priority) VALUES(5, 1, 'Task TWO', 2, 'Description 2', 3);
INSERT INTO tasks(id, project_id, name, status, description, priority) VALUES(6, 1, 'Task THREE', 2, 'Description three', 4);

INSERT INTO projects(id, name, start_date, status, priority) VALUES(2, 'Project TWO', '2022-03-02', 1, 2);
INSERT INTO tasks(id, project_id, name, status, description, priority) VALUES(7, 2, 'Task ONE', 1, 'Description', 0);
INSERT INTO tasks(id, project_id, name, status, description, priority) VALUES(8, 2, 'Task TWO', 0, 'TWO', 2);

INSERT INTO projects(id, name, start_date, status, priority) VALUES(3, 'Project THREE', '2022-03-25', 0, 5);
INSERT INTO tasks(id, project_id, name, status, description, priority) VALUES(9, 3, 'Task ONE', 0, 'TODO', 4);
INSERT INTO tasks(id, project_id, name, status, description, priority) VALUES(10, 3, 'Task TWO', 0, 'TWO Description', 4);
INSERT INTO tasks(id, project_id, name, status, description, priority) VALUES(11, 3, 'Task THREE', 0, '3Description', 4);
