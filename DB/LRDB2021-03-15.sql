-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema learningresourcedb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `learningresourcedb` ;

-- -----------------------------------------------------
-- Schema learningresourcedb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `learningresourcedb` DEFAULT CHARACTER SET utf8 ;
USE `learningresourcedb` ;

-- -----------------------------------------------------
-- Table `textbook`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `textbook` ;

CREATE TABLE IF NOT EXISTS `textbook` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `author` VARCHAR(150) NOT NULL,
  `title` VARCHAR(150) NOT NULL,
  `subtitle` VARCHAR(150) NULL,
  `edition` SMALLINT(100) NULL,
  `year` INT NULL,
  `length` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `author`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `author` ;

CREATE TABLE IF NOT EXISTS `author` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL,
  `middle_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `suffix` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `author_textbook`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `author_textbook` ;

CREATE TABLE IF NOT EXISTS `author_textbook` (
  `author_id` INT NOT NULL,
  `textbook_id` INT NOT NULL,
  PRIMARY KEY (`author_id`, `textbook_id`),
  INDEX `fk_author_textbook_author1_idx` (`author_id` ASC),
  INDEX `fk_author_textbook_textbook1_idx` (`textbook_id` ASC),
  CONSTRAINT `fk_author_textbook_author1`
    FOREIGN KEY (`author_id`)
    REFERENCES `author` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_author_textbook_textbook1`
    FOREIGN KEY (`textbook_id`)
    REFERENCES `textbook` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS learninguser@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'learninguser'@'localhost' IDENTIFIED BY 'learninguser';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'learninguser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `textbook`
-- -----------------------------------------------------
START TRANSACTION;
USE `learningresourcedb`;
INSERT INTO `textbook` (`id`, `author`, `title`, `subtitle`, `edition`, `year`, `length`) VALUES (1, 'Billybob', 'Great Book', NULL, NULL, NULL, NULL);

COMMIT;

