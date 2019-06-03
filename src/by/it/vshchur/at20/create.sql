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
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `vshchur`.`varible`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vshchur`.`varible` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `text` VARCHAR(45) NULL,
  `category_id` INT NULL,
  `user_id` INT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_varible_category`
    FOREIGN KEY (`category_id`)
    REFERENCES `vshchur`.`category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_varible_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `vshchur`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



-- -----------------------------------------------------
-- Data for table `vshchur`.`user`
-- -----------------------------------------------------
INSERT INTO `vshchur`.`user` (`id`, `username`, `email`, `password`, `create_time`) VALUES (DEFAULT, 'default', 'def@mail.ru', 'qwerty', '2019-04-25');
INSERT INTO `vshchur`.`user` (`id`, `username`, `email`, `password`, `create_time`) VALUES (DEFAULT, 'user', 'fasdfas', 'asdfgh', '2019-04-25');
INSERT INTO `vshchur`.`user` (`id`, `username`, `email`, `password`, `create_time`) VALUES (DEFAULT, 'admin', 'admin@gmail.com', '123456', '2019-04-25');



-- -----------------------------------------------------
-- Data for table `vshchur`.`category`
-- -----------------------------------------------------
INSERT INTO `vshchur`.`category` (`id`, `name`) VALUES (DEFAULT, 'SCALAR');
INSERT INTO `vshchur`.`category` (`id`, `name`) VALUES (DEFAULT, 'VECTOR');
INSERT INTO `vshchur`.`category` (`id`, `name`) VALUES (DEFAULT, 'MATRIX');



-- -----------------------------------------------------
-- Data for table `vshchur`.`varible`
-- -----------------------------------------------------
INSERT INTO `vshchur`.`varible` (`id`, `name`, `text`, `category_id`, `user_id`) VALUES (DEFAULT, 'A', '111', NULL, NULL);


