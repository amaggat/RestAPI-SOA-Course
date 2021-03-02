CREATE DATABASE students;

CREATE TABLE IF NOT EXISTS `students`.`students` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(100) NOT NULL,
    `dob` VARCHAR(100) NOT NULL,
    `mail` VARCHAR(100) NOT NULL,
    `gender` VARCHAR(100) NOT NULL,
    
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `students`.`contacts` (
	`name` VARCHAR(100) NOT NULL,
    `address` VARCHAR(100) NOT NULL,
    `studentid` INT NOT NULL,
    
    FOREIGN KEY (`studentid`) REFERENCES students(id)
);