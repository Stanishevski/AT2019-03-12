-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema agrinkevich
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `agrinkevich` ;

-- -----------------------------------------------------
-- Schema agrinkevich
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `agrinkevich` DEFAULT CHARACTER SET utf8 ;
USE `agrinkevich` ;

-- -----------------------------------------------------
-- Table `agrinkevich`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `agrinkevich`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(16) NOT NULL,
  `email` VARCHAR(255) NULL,
  `password` VARCHAR(32) NOT NULL,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `agrinkevich`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `agrinkevich`.`category` (
  `id` INT NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `agrinkevich`.`variable`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `agrinkevich`.`variable` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `text` VARCHAR(45) NULL,
  `category_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_variable_category1_idx` (`category_id` ASC) VISIBLE,
  INDEX `fk_variable_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_variable_category1`
    FOREIGN KEY (`category_id`)
    REFERENCES `agrinkevich`.`category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_variable_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `agrinkevich`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `agrinkevich`.`user`
-- -----------------------------------------------------
START TRANSACTION;
USE `agrinkevich`;
INSERT INTO `agrinkevich`.`user` (`id`, `username`, `email`, `password`, `create_time`) VALUES (1, 'default', 'default@mail.com', 'qwerty', '2019-04-25');
INSERT INTO `agrinkevich`.`user` (`id`, `username`, `email`, `password`, `create_time`) VALUES (2, 'user', 'user@gmail.com', 'testqwe', '2019-04-25');
INSERT INTO `agrinkevich`.`user` (`id`, `username`, `email`, `password`, `create_time`) VALUES (3, 'admin', 'admin@gmail.com', 'adminqwe', '2019-04-25');

COMMIT;


-- -----------------------------------------------------
-- Data for table `agrinkevich`.`category`
-- -----------------------------------------------------
START TRANSACTION;
USE `agrinkevich`;
INSERT INTO `agrinkevich`.`category` (`id`, `name`) VALUES (1, 'SCALAR');
INSERT INTO `agrinkevich`.`category` (`id`, `name`) VALUES (2, 'VECTOR');
INSERT INTO `agrinkevich`.`category` (`id`, `name`) VALUES (3, 'MATRIX');

COMMIT;


-- -----------------------------------------------------
-- Data for table `agrinkevich`.`variable`
-- -----------------------------------------------------
START TRANSACTION;
USE `agrinkevich`;
INSERT INTO `agrinkevich`.`variable` (`id`, `name`, `text`, `category_id`, `user_id`) VALUES (1, 'A', '111', 1, 1);

COMMIT;

