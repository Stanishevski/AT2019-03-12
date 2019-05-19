-- MySQL Workbench Forward Engineering

-- -----------------------------------------------------
-- Schema stanishevski
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `stanishevski`;

-- -----------------------------------------------------
-- Schema stanishevski
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `stanishevski`;

-- -----------------------------------------------------
-- Table `stanishevski`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stanishevski`.`category` (
  `id` INT(11) NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
;


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
;


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
;




-- -----------------------------------------------------
-- Data for table `stanishevski`.`category`
-- -----------------------------------------------------

INSERT INTO `stanishevski`.`category` (`id`, `name`) VALUES (1, 'SCALAR');
INSERT INTO `stanishevski`.`category` (`id`, `name`) VALUES (2, 'VECTOR');
INSERT INTO `stanishevski`.`category` (`id`, `name`) VALUES (3, 'MATRIX');




-- -----------------------------------------------------
-- Data for table `stanishevski`.`user`
-- -----------------------------------------------------

INSERT INTO `stanishevski`.`user` (`id`, `username`, `email`, `password`, `create_time`) VALUES (1, 'default', 'default@mail.com', 'qwerty', '2019-04-25');
INSERT INTO `stanishevski`.`user` (`id`, `username`, `email`, `password`, `create_time`) VALUES (2, 'user', 'user@gmail.com', 'asdfgh', '2019-04-25');
INSERT INTO `stanishevski`.`user` (`id`, `username`, `email`, `password`, `create_time`) VALUES (3, 'admin', 'admin@domain.com', 'zxcvbn', '2019-04-25');




-- -----------------------------------------------------
-- Data for table `stanishevski`.`variable`
-- -----------------------------------------------------

INSERT INTO `stanishevski`.`variable` (`id`, `name`, `text`, `user_id`, `category_id`) VALUES (1, 'A', '111', 1, 1);



