-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema stanishevski
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `stanishevski` ;

-- -----------------------------------------------------
-- Schema stanishevski
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `stanishevski` DEFAULT CHARACTER SET utf8 ;
USE `stanishevski` ;

-- -----------------------------------------------------
-- Table `stanishevski`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stanishevski`.`category` (
  `id` INT(11) NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `stanishevski`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stanishevski`.`user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(16) NOT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `password` VARCHAR(32) NOT NULL,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `stanishevski`.`variable`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stanishevski`.`variable` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `text` VARCHAR(45) NULL DEFAULT NULL,
  `user_id` INT(11) NOT NULL,
  `category_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_variable_category1`
    FOREIGN KEY (`category_id`)
    REFERENCES `stanishevski`.`category` (`id`),
  CONSTRAINT `fk_variable_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `stanishevski`.`user` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `stanishevski`.`category`
-- -----------------------------------------------------
START TRANSACTION;
USE `stanishevski`;
INSERT INTO `stanishevski`.`category` (`id`, `name`) VALUES (1, 'SCALAR');
INSERT INTO `stanishevski`.`category` (`id`, `name`) VALUES (2, 'VECTOR');
INSERT INTO `stanishevski`.`category` (`id`, `name`) VALUES (3, 'MATRIX');

COMMIT;


-- -----------------------------------------------------
-- Data for table `stanishevski`.`user`
-- -----------------------------------------------------
START TRANSACTION;
USE `stanishevski`;
INSERT INTO `stanishevski`.`user` (`id`, `username`, `email`, `password`, `create_time`) VALUES (1, 'default', 'default@mail.com', 'qwerty', '2019-04-25');
INSERT INTO `stanishevski`.`user` (`id`, `username`, `email`, `password`, `create_time`) VALUES (2, 'user', 'user@gmail.com', 'asdfgh', '2019-04-25');
INSERT INTO `stanishevski`.`user` (`id`, `username`, `email`, `password`, `create_time`) VALUES (3, 'admin', 'admin@domain.com', 'zxcvbn', '2019-04-25');

COMMIT;


-- -----------------------------------------------------
-- Data for table `stanishevski`.`variable`
-- -----------------------------------------------------
START TRANSACTION;
USE `stanishevski`;
INSERT INTO `stanishevski`.`variable` (`id`, `name`, `text`, `user_id`, `category_id`) VALUES (1, 'A', '111', 1, 1);

COMMIT;

