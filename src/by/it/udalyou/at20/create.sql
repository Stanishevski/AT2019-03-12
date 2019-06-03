-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema udalyou
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `udalyou` ;

-- -----------------------------------------------------
-- Schema udalyou
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `udalyou` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `udalyou` ;

-- -----------------------------------------------------
-- Table `udalyou`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `udalyou`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `username` NVARCHAR(16) NOT NULL COMMENT '',
  `email` VARCHAR(255) NULL COMMENT '',
  `password` VARCHAR(32) NOT NULL COMMENT '',
  `create_time` TIMESTAMP(6) NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `udalyou`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `udalyou`.`category` (
  `id` INT NOT NULL COMMENT '',
  `name` VARCHAR(255) NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `udalyou`.`veriable`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `udalyou`.`veriable` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `name` VARCHAR(45) NULL COMMENT '',
  `text` VARCHAR(45) NULL COMMENT '',
  `user_id` INT NOT NULL COMMENT '',
  `category_id` INT NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `fk_veriable_user_idx` (`user_id` ASC)  COMMENT '',
  INDEX `fk_veriable_category1_idx` (`category_id` ASC)  COMMENT '',
  CONSTRAINT `fk_veriable_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `udalyou`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_veriable_category1`
    FOREIGN KEY (`category_id`)
    REFERENCES `udalyou`.`category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `udalyou`.`user`
-- -----------------------------------------------------
START TRANSACTION;
USE `udalyou`;
INSERT INTO `udalyou`.`user` (`id`, `username`, `email`, `password`, `create_time`) VALUES (1, 'default', 'default@tut.by', '12345', '20190502');
INSERT INTO `udalyou`.`user` (`id`, `username`, `email`, `password`, `create_time`) VALUES (2, 'user', 'user@mail.ru', '65432', '20190502');
INSERT INTO `udalyou`.`user` (`id`, `username`, `email`, `password`, `create_time`) VALUES (3, 'admin', 'admin@gmail.ru', '789645', '20190502');

COMMIT;


-- -----------------------------------------------------
-- Data for table `udalyou`.`category`
-- -----------------------------------------------------
START TRANSACTION;
USE `udalyou`;
INSERT INTO `udalyou`.`category` (`id`, `name`) VALUES (1, 'SCALAR');
INSERT INTO `udalyou`.`category` (`id`, `name`) VALUES (2, 'VECTOR');
INSERT INTO `udalyou`.`category` (`id`, `name`) VALUES (3, 'MATRIX');

COMMIT;


-- -----------------------------------------------------
-- Data for table `udalyou`.`veriable`
-- -----------------------------------------------------
START TRANSACTION;
USE `udalyou`;
INSERT INTO `udalyou`.`veriable` (`id`, `name`, `text`, `user_id`, `category_id`) VALUES (1, 'aaa', '111', 1, 1);

COMMIT;

