
-- Schema asimanovich
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `udalyou` ;

-- -----------------------------------------------------
-- Schema asimanovich
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `asimanovich` ;

-- -----------------------------------------------------
-- Table `asimanovich`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `udalyou`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `username` NVARCHAR(16) NOT NULL COMMENT '',
  `email` VARCHAR(255) NULL COMMENT '',
  `password` VARCHAR(32) NOT NULL COMMENT '',
  `create_time` TIMESTAMP(6) NULL COMMENT '',
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `asimanovich`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asimanovich`.`category` (
  `id` INT NOT NULL COMMENT '',
  `name` VARCHAR(255) NOT NULL COMMENT '',
  PRIMARY KEY (`id`) );


-- -----------------------------------------------------
-- Table `asimanovich`.`veriable`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `asimanovich`.`veriable` (
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
    REFERENCES `asimanovich`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_veriable_category1`
    FOREIGN KEY (`category_id`)
    REFERENCES `asimanovich`.`category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



INSERT INTO `asimanovich`.`user` (`id`, `username`, `email`, `password`, `create_time`) VALUES (1, 'default', 'default@tut.by', '12345', '20190502');
INSERT INTO `asimanovich`.`user` (`id`, `username`, `email`, `password`, `create_time`) VALUES (2, 'user', 'user@mail.ru', '65432', '20190502');
INSERT INTO `asimanovich`.`user` (`id`, `username`, `email`, `password`, `create_time`) VALUES (3, 'admin', 'admin@gmail.ru', '789645', '20190502');




-- -----------------------------------------------------
-- Data for table `asimanovich`.`category`
-- -----------------------------------------------------

INSERT INTO `asimanovich`.`category` (`id`, `name`) VALUES (1, 'SCALAR');
INSERT INTO `asimanovich`.`category` (`id`, `name`) VALUES (2, 'VECTOR');
INSERT INTO `asimanovich`.`category` (`id`, `name`) VALUES (3, 'MATRIX');


-- -----------------------------------------------------
-- Data for table `asimanovich`.`veriable`
-- -----------------------------------------------------
INSERT INTO `asimanovich`.`veriable` (`id`, `name`, `text`, `user_id`, `category_id`) VALUES (1, 'aaa', '111', 1, 1);



