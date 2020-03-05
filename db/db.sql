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

--Создаем пользователей.
INSERT INTO users (id, login, password, role) VALUES (DEFAULT, 'admin', 'd3b8cc3e6c9693062cdfde1a234f8fcc', 1);


--Выгрузить пользователя с ролью.
SELECT u.id, u.login, u.password, r.id AS rol_id, r.role FROM users AS u LEFT JOIN roles AS r ON u.role = r.id WHERE u.login = (?);
--Удалить пользователя.
DELETE FROM users WHERE id = (?) AND login = (?) AND password = (?) RETURNING id;
--Обновить пользователя.
UPDATE users SET password = (?) WHERE id = (?) RETURNING id;