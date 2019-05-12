-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema vshchur
-- -----------------------------------------------------
-- at20
DROP SCHEMA IF EXISTS `vshchur` ;

-- -----------------------------------------------------
-- Schema vshchur
--
-- at20
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `vshchur` DEFAULT CHARACTER SET utf8 ;
USE `vshchur` ;

-- -----------------------------------------------------
-- Table `vshchur`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vshchur`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(16) NOT NULL,
  `email` VARCHAR(255) NULL,
  `password` VARCHAR(32) NOT NULL,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `vshchur`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vshchur`.`category` (
  `category_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`category_id`));


-- -----------------------------------------------------
-- Table `vshchur`.`varible`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vshchur`.`varible` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `text` VARCHAR(45) NULL,
  `user_id` INT NULL,
  `category_id` INT NULL,
  `user_id1` INT NOT NULL,
  `category_category_id` INT NOT NULL,
  PRIMARY KEY (`id`, `user_id1`, `category_category_id`),
  INDEX `fk_varible_user_idx` (`user_id1` ASC) VISIBLE,
  INDEX `fk_varible_category1_idx` (`category_category_id` ASC) VISIBLE,
  CONSTRAINT `fk_varible_user`
    FOREIGN KEY (`user_id1`)
    REFERENCES `vshchur`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_varible_category1`
    FOREIGN KEY (`category_category_id`)
    REFERENCES `vshchur`.`category` (`category_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `vshchur`.`user`
-- -----------------------------------------------------
START TRANSACTION;
USE `vshchur`;
INSERT INTO `vshchur`.`user` (`id`, `username`, `email`, `password`, `create_time`) VALUES (DEFAULT, 'default', 'def@mail.ru', 'qwerty', '2019-04-25');
INSERT INTO `vshchur`.`user` (`id`, `username`, `email`, `password`, `create_time`) VALUES (DEFAULT, 'user', 'fasdfas', 'asdfgh', '2019-04-25');
INSERT INTO `vshchur`.`user` (`id`, `username`, `email`, `password`, `create_time`) VALUES (DEFAULT, 'admin', 'admin@gmail.com', '123456', '2019-04-25');

COMMIT;


-- -----------------------------------------------------
-- Data for table `vshchur`.`category`
-- -----------------------------------------------------
START TRANSACTION;
USE `vshchur`;
INSERT INTO `vshchur`.`category` (`category_id`, `name`) VALUES (DEFAULT, 'SCALAR');
INSERT INTO `vshchur`.`category` (`category_id`, `name`) VALUES (DEFAULT, 'VECTOR');
INSERT INTO `vshchur`.`category` (`category_id`, `name`) VALUES (DEFAULT, 'MATRIX');

COMMIT;


-- -----------------------------------------------------
-- Data for table `vshchur`.`varible`
-- -----------------------------------------------------
START TRANSACTION;
USE `vshchur`;
INSERT INTO `vshchur`.`varible` (`id`, `name`, `text`, `user_id`, `category_id`, `user_id1`, `category_category_id`) VALUES (DEFAULT, 'A', '111', 1, 1, 1, 1);

COMMIT;

