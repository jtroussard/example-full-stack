CREATE DATABASE fullstack_example_db;

SHOW DATABASES;

CREATE USER 'fullstackExampleAdmin'@'localhost' IDENTIFIED BY 'password123';

GRANT ALL PRIVILEGES ON fullstack_example_db.* TO 'fullstackExampleAdmin'@'localhost';

FLUSH PRIVILEGES;

SELECT User from mysql.user;
