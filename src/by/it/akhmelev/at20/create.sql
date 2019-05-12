-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema akhmelev
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `akhmelev` ;

-- -----------------------------------------------------
-- Schema akhmelev
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `akhmelev` DEFAULT CHARACTER SET utf8 ;
USE `akhmelev` ;

-- -----------------------------------------------------
-- Table `akhmelev`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `akhmelev`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(16) NOT NULL,
  `email` VARCHAR(255) NULL,
  `password` VARCHAR(32) NOT NULL,
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `akhmelev`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `akhmelev`.`category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC));


-- -----------------------------------------------------
-- Table `akhmelev`.`variable`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `akhmelev`.`variable` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `text` VARCHAR(45) NULL,
  `user_id` INT NOT NULL,
  `category_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_variable_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `akhmelev`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_variable_category1`
    FOREIGN KEY (`category_id`)
    REFERENCES `akhmelev`.`category` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `akhmelev`.`user`
-- -----------------------------------------------------
START TRANSACTION;
USE `akhmelev`;
INSERT INTO `akhmelev`.`user` (`id`, `username`, `email`, `password`, `create_time`) VALUES (1, 'default', 'def@mail.ru', 'qwerty', DEFAULT);
INSERT INTO `akhmelev`.`user` (`id`, `username`, `email`, `password`, `create_time`) VALUES (2, 'user', 'user@mail.ru', 'asdfgh', DEFAULT);
INSERT INTO `akhmelev`.`user` (`id`, `username`, `email`, `password`, `create_time`) VALUES (3, 'admin', 'admin@google.com', 'zxcvbn', DEFAULT);

COMMIT;


-- -----------------------------------------------------
-- Data for table `akhmelev`.`category`
-- -----------------------------------------------------
START TRANSACTION;
USE `akhmelev`;
INSERT INTO `akhmelev`.`category` (`id`, `name`) VALUES (1, 'SCALAR');
INSERT INTO `akhmelev`.`category` (`id`, `name`) VALUES (2, 'VECTOR');
INSERT INTO `akhmelev`.`category` (`id`, `name`) VALUES (3, 'MATRIX');

COMMIT;


-- -----------------------------------------------------
-- Data for table `akhmelev`.`variable`
-- -----------------------------------------------------
START TRANSACTION;
USE `akhmelev`;
INSERT INTO `akhmelev`.`variable` (`id`, `name`, `text`, `user_id`, `category_id`) VALUES (1, 'A', '111', 1, 1);

COMMIT;

