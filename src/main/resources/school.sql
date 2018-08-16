CREATE SCHEMA IF NOT EXISTS `SZKOLA`;

USE `SZKOLA`;

CREATE TABLE IF NOT EXISTS `school` (
  `id_school`   INT          NOT NULL AUTO_INCREMENT,
  `name`        VARCHAR(255) NOT NULL,
  `address`     VARCHAR(255) NOT NULL,
  `tell_number` VARCHAR(9),
  `mail`        VARCHAR(30),
  `patron`      VARCHAR(255),
  PRIMARY KEY (`id_school`)
);

CREATE TABLE IF NOT EXISTS `classroom` (
  `id_classroom` INT NOT NULL AUTO_INCREMENT,
  `capacity`     INT NOT NULL,
  `id_school`    INT NOT NULL,
  PRIMARY KEY (`id_classroom`)
);

ALTER TABLE `classroom`
  ADD FOREIGN KEY (`id_school`) REFERENCES `school` (`id_school`)
  ON DELETE NO ACTION;

CREATE TABLE IF NOT EXISTS `lesson` (
  `id_lesson`    INT        NOT NULL AUTO_INCREMENT,
  `begin_time`   VARCHAR(45)         DEFAULT NULL,
  `day`          VARCHAR(45)         DEFAULT NULL,
  `id_classroom` INT        NOT NULL,
  `subject`      INT        NOT NULL,
  `id_teacher`   INT        NOT NULL,
  `id_group`     INT        NOT NULL,
  `id_test`      INT UNIQUE NOT NULL,
  PRIMARY KEY (`id_lesson`)
);

CREATE TABLE IF NOT EXISTS `test` (
  `id_test` INT NOT NULL AUTO_INCREMENT,
  `type`    ENUM ('test', 'pop_quiz', 'final_test'),
  `date`    DATE,
  PRIMARY KEY (`id_test`)
);

ALTER TABLE `lesson`
  ADD FOREIGN KEY (`id_test`) REFERENCES `test` (`id_test`)
  ON DELETE NO ACTION;

CREATE TABLE IF NOT EXISTS `teacher` (
  `id_teacher` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45)  DEFAULT NULL,
  `last_name`  VARCHAR(45)  DEFAULT NULL,
  PRIMARY KEY (`id_teacher`)
);

CREATE TABLE IF NOT EXISTS `group` (
  `id_group`        INT NOT NULL AUTO_INCREMENT,
  `identity_number` VARCHAR(1)   DEFAULT NULL,
  `identity_letter` VARCHAR(1)   DEFAULT NULL,
  PRIMARY KEY (`id_group`)
);

ALTER TABLE `lesson`
  ADD FOREIGN KEY (`id_classroom`) REFERENCES `classroom` (`id_classroom`)
  ON DELETE NO ACTION,
  ADD FOREIGN KEY (`id_group`) REFERENCES `group` (`id_group`)
  ON DELETE NO ACTION,
  ADD FOREIGN KEY (`id_teacher`) REFERENCES `teacher` (`id_teacher`)
  ON DELETE NO ACTION;

CREATE TABLE IF NOT EXISTS `student` (
  `id_student`   INT AUTO_INCREMENT,
  `id_class`     INT         NOT NULL,
  `first_name`   VARCHAR(20) NOT NULL,
  `last_name`    VARCHAR(20) NOT NULL,
  `tell_number`  VARCHAR(9),
  `mobile_phone` VARCHAR(9),
  `mail`         VARCHAR(30),
  `id_parent`    INT         NOT NULL,
  `id_grouop`    INT         NOT NULL,
  PRIMARY KEY (`id_student`)
);
ALTER TABLE `student`
  ADD FOREIGN KEY (`id_grouop`) REFERENCES `group` (`id_group`)
  ON DELETE NO ACTION;

CREATE TABLE IF NOT EXISTS `parent` (
  `id_parent`    INT AUTO_INCREMENT,
  `first_name`   VARCHAR(20),
  `last_name`    VARCHAR(20) NOT NULL,
  `tell_number`  VARCHAR(9),
  `mobile_phone` VARCHAR(9),
  `mail`         VARCHAR(30),
  `username`     VARCHAR(50) NOT NULL,
  `password`     CHAR(80)    NOT NULL,
  PRIMARY KEY (`id_parent`)
);
CREATE TABLE IF NOT EXISTS `student_parent` (
  `id_student` INT NOT NULL,
  `id_parent`  INT NOT NULL,
  PRIMARY KEY (`id_student`, `id_parent`)
);
ALTER TABLE `student_parent`
  ADD FOREIGN KEY (`id_parent`) REFERENCES `parent` (`id_parent`)
  ON DELETE NO ACTION,
  ADD FOREIGN KEY (`id_student`) REFERENCES `student` (`id_student`)
  ON DELETE NO ACTION;

CREATE TABLE IF NOT EXISTS `grade` (
  `id_grade`   INT AUTO_INCREMENT,
  `id_subject` INT NOT NULL,
  `grade`      INT(1),
  `grade_mark` VARCHAR(1),
  PRIMARY KEY (`id_grade`)
);

CREATE TABLE IF NOT EXISTS `student_grade` (
  `id_student` INT NOT NULL,
  `id_grade`   INT NOT NULL,
  PRIMARY KEY (`id_student`, `id_grade`)
);
ALTER TABLE `student_grade`
  ADD FOREIGN KEY (`id_grade`) REFERENCES `grade` (`id_grade`)
  ON DELETE NO ACTION,
  ADD FOREIGN KEY (`id_student`) REFERENCES `student` (`id_student`)
  ON DELETE NO ACTION;

CREATE TABLE IF NOT EXISTS `role` (
  `id_role`   INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50)      DEFAULT NULL,
  PRIMARY KEY (`id_role`)
);

CREATE TABLE IF NOT EXISTS `users_roles` (
  id_parent int(11) NOT NULL,
  id_role int(11) NOT NULL,
  PRIMARY KEY (`id_parent`,`id_role`)
);

ALTER TABLE `users_roles`
  ADD FOREIGN KEY (`id_parent`) REFERENCES `parent` (`id_parent`)
  ON DELETE NO ACTION,
  ADD FOREIGN KEY (`id_role`) REFERENCES `role` (`id_role`)
  ON DELETE NO ACTION;


SET FOREIGN_KEY_CHECKS = 1;

--
-- Dumping data for table `users_roles`
--
INSERT INTO `role` (name)
VALUES
  ('ROLE_EMPLOYEE'), ('ROLE_MANAGER'), ('ROLE_ADMIN');

INSERT INTO `parent` (username, password, first_name, last_name, mail)
VALUES
  ('john', '$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K', 'John', 'Doe', 'john@luv2code.com'),
  ('mary', '$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K', 'Mary', 'Public', 'mary@luv2code.com'),
  ('susan', '$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K', 'Susan', 'Adams', 'susan@luv2code.com');

INSERT INTO `users_roles` (id_parent, id_role)
VALUES
  (1, 1),
  (2, 1),
  (2, 2),
  (3, 1),
  (3, 3);

USE `SZKOLA`;
INSERT INTO school (name, address, tell_number, mail, patron)
VALUES ('Franciszka Dolasa', 'Piździbory mniejsze', '2506059', 'sratatata@wp.com', 'Zagloba');

INSERT INTO school (name, address, tell_number, mail, patron)
VALUES ('Franciszka Dolasa', 'Piździbory mniejsze', '2506059', 'sratatata@wp.com', 'Zagloba');


INSERT INTO school (name, address, tell_number, mail, patron)
VALUES ('Franciszka Dolasa', 'Piździbory mniejsze', '2506059', 'sratatata@wp.com', 'Zagloba');






