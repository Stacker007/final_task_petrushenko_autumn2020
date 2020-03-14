CREATE DATABASE simply ENCODING 'UTF-8';

CREATE TYPE roles AS ENUM ('admin', 'user');
CREATE TABLE IF NOT EXISTS users (
  id       SERIAL unique PRIMARY KEY,
  login    VARCHAR(32) UNIQUE NOT NULL,
  password VARCHAR(32) NOT NULL,
  role     roles
);
CREATE TYPE tsk_stat AS ENUM ('active', 'completed', 'trash');
CREATE TABLE IF NOT EXISTS tasks (
  id       SERIAL unique PRIMARY KEY,
  user_id INTEGER NOT NULL,
  task_name    VARCHAR(32)  NOT NULL,
  description VARCHAR(256) ,
  task_date date not null,
  file_path varchar (32),
  status tsk_stat,
  foreign key (user_id) references users (id)
);
--Создаем пользователей.
INSERT INTO users (id, login, password, role) VALUES (DEFAULT, 'admin', '63a9f0ea7bb98050796b649e85481845', 'admin');
INSERT INTO users (id, login, password, role) VALUES (DEFAULT, 'Vladimir', 'c4ca4238a0b923820dcc509a6f75849b', 'user');
--Password of admin: "root"
--Password of Vladimir: "1"

--Тестовая задача

insert into tasks (id, user_id, task_name, description, task_date, status) values (default, 1, 'test_tsk', 'some descript', '2020-03-08', 'active');
insert into tasks (id, user_id, task_name, description, task_date) values (default, 1, 'test_tsk', '', '2020-03-29');
insert into tasks (id, user_id, task_name, task_date) values (default, 1, 'test_tsk2',  '2020-03-01');
insert into tasks (id, user_id, task_name, task_date) values (default, 2, 'test_tsk2',  '2020-03-01');


