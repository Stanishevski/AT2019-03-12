-- MySQL Workbench Forward Engineering

-- -----------------------------------------------------
-- Schema romanova
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `romanova` ;

-- -----------------------------------------------------
-- Schema romanova
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `romanova` ;

-- -----------------------------------------------------
-- Table `romanova`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `romanova`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(16) NOT NULL,
  `email` VARCHAR(255) NULL,
  `password` VARCHAR(32) NOT NULL,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `romanova`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `romanova`.`category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
);


-- -----------------------------------------------------
-- Table `romanova`.`variable`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `romanova`.`variable` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `text` VARCHAR(45) NULL,
  `user_id` INT NOT NULL,
  `category_id` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Data for table `romanova`.`user`
-- -----------------------------------------------------

INSERT INTO `romanova`.`user` (`id`, `username`, `email`, `password`, `create_time`) VALUES (DEFAULT, 'default', 'def@mail.ru', 'qwerty', '2019-04-25');
INSERT INTO `romanova`.`user` (`id`, `username`, `email`, `password`, `create_time`) VALUES (DEFAULT, 'user', 'user@mail.ru', '12345', '2019-04-25');
INSERT INTO `romanova`.`user` (`id`, `username`, `email`, `password`, `create_time`) VALUES (DEFAULT, 'admin', 'a@mail.ru', '222222', '2019-04-25');


-- -----------------------------------------------------
-- Data for table `romanova`.`category`
-- -----------------------------------------------------

INSERT INTO `romanova`.`category` (`id`, `name`) VALUES (DEFAULT, 'SCALAR');
INSERT INTO `romanova`.`category` (`id`, `name`) VALUES (DEFAULT, 'VECTOR');
INSERT INTO `romanova`.`category` (`id`, `name`) VALUES (DEFAULT, 'MATRIX');


