CREATE DATABASE simply ENCODING 'UTF-8';

CREATE TABLE IF NOT EXISTS roles (
  id   SERIAL unique PRIMARY KEY,
  role VARCHAR(5) NOT NULL
);

INSERT INTO roles (id, role) VALUES (DEFAULT, 'admin');
INSERT INTO roles (id, role) VALUES (DEFAULT, 'user');


CREATE TABLE IF NOT EXISTS users (
  id       SERIAL unique PRIMARY KEY,
  login    VARCHAR(32) UNIQUE NOT NULL,
  password VARCHAR(32) UNIQUE NOT NULL,
  role     INTEGER     NOT NULL,
  FOREIGN KEY (role) REFERENCES roles (id)
);
CREATE TABLE IF NOT EXISTS tasks (
  id       SERIAL unique PRIMARY KEY,
  user_id INTEGER NOT NULL,
  task_name    VARCHAR(32)  NOT NULL,
  description VARCHAR(256) ,
  task_date date not null,
  file_path varchar (32),
  foreign key (user_id) references users (id)
);
--Создаем пользователей.
INSERT INTO users (id, login, password, role) VALUES (DEFAULT, 'admin', 'd3b8cc3e6c9693062cdfde1a234f8fcc', 1);
INSERT INTO users (id, login, password, role) VALUES (DEFAULT, 'Vladimir', 'c4ca4238a0b923820dcc509a6f75849b', 2);
--Password of admin: "root"
--Password of Vladimir: "1"

--Тестовая задача

insert into tasks (id, user_id, task_name, description, task_date) values (default, 1, 'test_tsk', 'some descript', '2020-03-08');
insert into tasks (id, user_id, task_name, description, task_date) values (default, 1, 'test_tsk', '', '2020-03-29');
insert into tasks (id, user_id, task_name, task_date) values (default, 1, 'test_tsk2',  '2020-03-01');
insert into tasks (id, user_id, task_name, task_date) values (default, 2, 'test_tsk2',  '2020-03-01');


--Выгрузить пользователя с ролью.
SELECT u.id, u.login, u.password, r.id AS rol_id, r.role FROM users AS u LEFT JOIN roles AS r ON u.role = r.id WHERE u.login = (?);
--Удалить пользователя.
DELETE FROM users WHERE id = (?) AND login = (?) AND password = (?) RETURNING id;
--Обновить пользователя.
UPDATE users SET password = (?) WHERE id = (?) RETURNING id;