DROP DATABASE IF EXISTS Lesson_15_db;
CREATE DATABASE Lesson_15_db;
USE Lesson_15_db;

CREATE TABLE post(
id INT NOT NULL PRIMARY KEY auto_increment,
title VARCHAR(255) NOT NULL
);

CREATE TABLE comment (
id INT NOT NULL PRIMARY KEY auto_increment,
post_id INT,
authorName VARCHAR(255) NOT NULL,
CONSTRAINT post_id_FK FOREIGN KEY(post_id) REFERENCES Lesson_15_db.post(id) ON DELETE CASCADE ON UPDATE RESTRICT
);


SELECT * FROM post;
SELECT * FROM comment;



