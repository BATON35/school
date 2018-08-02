CREATE SCHEMA IF NOT EXISTS `SZKOLA`;

USE `SZKOLA`;

CREATE TABLE IF NOT EXISTS `school` (
  `id`      INT          NOT NULL AUTO_INCREMENT,
  `name`    VARCHAR(255) NOT NULL,
  `address` VARCHAR(255) NOT NULL,
  `tell_number`  VARCHAR(9),
  `mail`         VARCHAR(30),
  `patron`  VARCHAR(255),
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `classroom` (
  `id`            INT         NOT NULL AUTO_INCREMENT,
  `capacity`      INT         NOT NULL,
  `id_school`     INT         NOT NULL,
  PRIMARY KEY (id)
);

ALTER TABLE `classroom`
  ADD FOREIGN KEY (`id_school`) REFERENCES `school` (`id`)
  ON DELETE NO ACTION;

CREATE TABLE IF NOT EXISTS `lesson` (
  `id`       			INT 	NOT	NULL AUTO_INCREMENT,
  `begin_time`		    VARCHAR(45)  DEFAULT NULL,
  `day` 				VARCHAR(45)  DEFAULT NULL,
  `id_classroom` 		INT 	NOT NULL,
  `id_subject`       	INT 	NOT NULL,
  `id_teacher`      	INT 	NOT NULL,
  `id_group`     	 	INT 	NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `subject` (
  `id`           INT         NOT NULL AUTO_INCREMENT,
  `subject_name` VARCHAR(45) NOT NULL,
  `id_test`      INT         DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS`test` (
  `id`           INT         NOT NULL AUTO_INCREMENT,
  `type` ENUM('test', 'pop_quiz', 'final_test'),
  PRIMARY KEY (id)
);

ALTER TABLE `subject`
  ADD FOREIGN KEY (`id_test`) REFERENCES `test` (`id`)
  ON DELETE NO ACTION;

CREATE TABLE IF NOT EXISTS `teacher` (
  `id`         INT	 		NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45)  DEFAULT NULL,
  `last_name`  VARCHAR(45)  DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `group` (
  `id`         INT	 		NOT NULL AUTO_INCREMENT,
  `identity_number` VARCHAR(1)  DEFAULT NULL,
  `identity_letter` VARCHAR(1)  DEFAULT NULL,
  `id_student`  INT  NOT NULL,

  PRIMARY KEY (`id`)
);

ALTER TABLE `lesson`
  ADD FOREIGN KEY (`id_classroom`) REFERENCES `classroom` (`id`)
  ON DELETE NO ACTION,
  ADD FOREIGN KEY (`id_group`) REFERENCES `group` (`id`)
  ON DELETE NO ACTION,
  ADD FOREIGN KEY (`id_teacher`) REFERENCES `teacher` (`id`)
  ON DELETE NO ACTION,
  ADD FOREIGN KEY (`id_subject`) REFERENCES `subject` (`id`)
  ON DELETE NO ACTION;

CREATE TABLE IF NOT EXISTS `student` (
  `id`         INT AUTO_INCREMENT,
  `id_class`   INT         NOT NULL,
  `first_name` VARCHAR(20) NOT NULL,
  `last_name`  VARCHAR(20) NOT NULL,
  `tell_number`  VARCHAR(9),
  `mobile_phone` VARCHAR(9),
  `mail`         VARCHAR(30),
  `id_parent`   INT         NOT NULL,
  PRIMARY KEY (`id`)
);
ALTER TABLE `group`
  ADD FOREIGN KEY (`id_student`) REFERENCES `student` (`id`)
  ON DELETE NO ACTION;

CREATE TABLE IF NOT EXISTS `parent` (
  `id`           INT AUTO_INCREMENT,
  `first_name`   VARCHAR(20),
  `surname`      VARCHAR(20) NOT NULL,
  `tell_number`  VARCHAR(9),
  `mobile_phone` VARCHAR(9),
  `mail`         VARCHAR(30),
  `id_student`   INT         NOT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE IF NOT EXISTS `student_parent` (
  `id_student`   INT         NOT NULL,
  `id_parent`   INT         NOT NULL,
  PRIMARY KEY (`id_student`, `id_parent`)
);
ALTER TABLE `student_parent`
  ADD FOREIGN KEY (`id_parent`) REFERENCES `parent` (`id`)
  ON DELETE NO ACTION,
  ADD FOREIGN KEY (`id_student`) REFERENCES `student` (`id`)
  ON DELETE NO ACTION;

CREATE TABLE IF NOT EXISTS `grade` (
  `id`               INT AUTO_INCREMENT,
  `id_subject`       INT NOT NULL,
  `grade`            INT(1),
  `grade_mark`       VARCHAR(1),
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `student_grade` (
  `id_student` INT NOT NULL,
  `id_grade`   INT NOT NULL,
  PRIMARY KEY (`id_student`, `id_grade`)
);
ALTER TABLE `student_grade`
  ADD FOREIGN KEY (`id_grade`) REFERENCES `grade` (`id`)
  ON DELETE NO ACTION,
  ADD FOREIGN KEY (`id_student`) REFERENCES `student` (`id`)
  ON DELETE NO ACTION;











