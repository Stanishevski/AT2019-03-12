-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema tsyhanova
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `tsyhanova` ;

-- -----------------------------------------------------
-- Schema tsyhanova
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tsyhanova` DEFAULT CHARACTER SET utf8 ;
USE `tsyhanova` ;

-- -----------------------------------------------------
-- Table `tsyhanova`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tsyhanova`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(16) NOT NULL,
  `email` VARCHAR(255) NULL,
  `password` VARCHAR(32) NOT NULL,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `tsyhanova`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tsyhanova`.`category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE);


-- -----------------------------------------------------
-- Table `tsyhanova`.`variable`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tsyhanova`.`variable` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `text` VARCHAR(45) NULL,
  `user_id` INT NOT NULL,
  `category_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_variable_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `tsyhanova`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_variable_category1`
    FOREIGN KEY (`category_id`)
    REFERENCES `tsyhanova`.`category` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `tsyhanova`.`user`
-- -----------------------------------------------------
START TRANSACTION;
USE `tsyhanova`;
INSERT INTO `tsyhanova`.`user` (`id`, `username`, `email`, `password`, `create_time`) VALUES (DEFAULT, 'default', 'default@gmail.com', 'qwerty', '2019-04-25');
INSERT INTO `tsyhanova`.`user` (`id`, `username`, `email`, `password`, `create_time`) VALUES (DEFAULT, 'user', 'user@gmail.com', 'asdfgh', '2019-04-05');
INSERT INTO `tsyhanova`.`user` (`id`, `username`, `email`, `password`, `create_time`) VALUES (DEFAULT, 'admin', 'admin@domain.com', 'zxcvbn', '2019-04-05');

COMMIT;


-- -----------------------------------------------------
-- Data for table `tsyhanova`.`category`
-- -----------------------------------------------------
START TRANSACTION;
USE `tsyhanova`;
INSERT INTO `tsyhanova`.`category` (`id`, `name`) VALUES (DEFAULT, 'SCALAR');
INSERT INTO `tsyhanova`.`category` (`id`, `name`) VALUES (DEFAULT, 'VECTOR');
INSERT INTO `tsyhanova`.`category` (`id`, `name`) VALUES (DEFAULT, 'MATRIX');

COMMIT;


-- -----------------------------------------------------
-- Data for table `tsyhanova`.`variable`
-- -----------------------------------------------------
START TRANSACTION;
USE `tsyhanova`;
INSERT INTO `tsyhanova`.`variable` (`id`, `name`, `text`, `user_id`, `category_id`) VALUES (DEFAULT, 'a', '111', 1, 1);

COMMIT;

