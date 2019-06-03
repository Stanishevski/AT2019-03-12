-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema okoyro
-- -----------------------------------------------------
-- test db for at courses
DROP SCHEMA IF EXISTS `okoyro` ;

-- -----------------------------------------------------
-- Schema okoyro
--
-- test db for at courses
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `okoyro` DEFAULT CHARACTER SET utf8 ;
USE `okoyro` ;

-- -----------------------------------------------------
-- Table `okoyro`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `okoyro`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(16) NOT NULL,
  `email` VARCHAR(255) NULL,
  `password` VARCHAR(32) NOT NULL,
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `okoyro`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `okoyro`.`category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `okoyro`.`variable`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `okoyro`.`variable` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `text` VARCHAR(45) NULL,
  `user_id` INT NOT NULL,
  `category_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_variable_user_idx` (`user_id` ASC),
  INDEX `fk_variable_category1_idx` (`category_id` ASC),
  CONSTRAINT `fk_variable_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `okoyro`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_variable_category1`
    FOREIGN KEY (`category_id`)
    REFERENCES `okoyro`.`category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `okoyro`.`user`
-- -----------------------------------------------------
START TRANSACTION;
USE `okoyro`;
INSERT INTO `okoyro`.`user` (`id`, `username`, `email`, `password`, `create_time`) VALUES (1, 'default', 'default@mail.com', 'qwerty', DEFAULT);
INSERT INTO `okoyro`.`user` (`id`, `username`, `email`, `password`, `create_time`) VALUES (2, 'simple', 'simple@gmail.com', 'asdfg', DEFAULT);
INSERT INTO `okoyro`.`user` (`id`, `username`, `email`, `password`, `create_time`) VALUES (3, 'admin', 'admin@domain.com', 'zxcvb', DEFAULT);

COMMIT;


-- -----------------------------------------------------
-- Data for table `okoyro`.`category`
-- -----------------------------------------------------
START TRANSACTION;
USE `okoyro`;
INSERT INTO `okoyro`.`category` (`id`, `name`) VALUES (1, 'SCALAR');
INSERT INTO `okoyro`.`category` (`id`, `name`) VALUES (2, 'VECTOR');
INSERT INTO `okoyro`.`category` (`id`, `name`) VALUES (3, 'MATRIX');

COMMIT;


-- -----------------------------------------------------
-- Data for table `okoyro`.`variable`
-- -----------------------------------------------------
START TRANSACTION;
USE `okoyro`;
INSERT INTO `okoyro`.`variable` (`id`, `name`, `text`, `user_id`, `category_id`) VALUES (1, 'A', 'text', 1, 1);

COMMIT;

