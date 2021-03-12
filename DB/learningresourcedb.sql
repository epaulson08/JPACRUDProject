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
  PRIMARY KEY (`id`))
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
INSERT INTO `textbook` (`id`, `author`, `title`) VALUES (1, 'Billybob', 'Great Book');

COMMIT;

