-- MySQL Script generated by MySQL Workbench
-- Wed Apr 20 01:44:57 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Delivery
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Delivery
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Delivery` DEFAULT CHARACTER SET utf8 ;
USE `Delivery` ;

-- -----------------------------------------------------
-- Table `Delivery`.`job_title`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Delivery`.`job_title` (
  `id` BIGINT(19) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Delivery`.`is_active`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Delivery`.`is_active` (
  `id` BIGINT(19) NOT NULL AUTO_INCREMENT,
  `is_active` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Delivery`.`department`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Delivery`.`department` (
  `id` BIGINT(19) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Delivery`.`application`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Delivery`.`application` (
  `id` BIGINT(19) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Delivery`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Delivery`.`user` (
  `id` BIGINT(19) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `job_title_id` BIGINT(19) NULL,
  `is_active_id` BIGINT(19) NULL,
  `department_id` BIGINT(19) NULL,
  `application_id` BIGINT(19) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_name_job_title_idx` (`job_title_id` ASC) VISIBLE,
  INDEX `fk_user_name_is_active1_idx` (`is_active_id` ASC) VISIBLE,
  INDEX `fk_user_name_department1_idx` (`department_id` ASC) VISIBLE,
  INDEX `fk_user_name_application1_idx` (`application_id` ASC) VISIBLE,
  CONSTRAINT `fk_user_name_job_title`
    FOREIGN KEY (`job_title_id`)
    REFERENCES `Delivery`.`job_title` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_name_is_active1`
    FOREIGN KEY (`is_active_id`)
    REFERENCES `Delivery`.`is_active` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_name_department1`
    FOREIGN KEY (`department_id`)
    REFERENCES `Delivery`.`department` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_name_application1`
    FOREIGN KEY (`application_id`)
    REFERENCES `Delivery`.`application` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Delivery`.`crcy`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Delivery`.`crcy` (
  `id` BIGINT(19) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Delivery`.`bun`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Delivery`.`bun` (
  `id` BIGINT(19) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Delivery`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Delivery`.`product` (
  `id` BIGINT(19) NOT NULL AUTO_INCREMENT,
  `material_description` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Delivery`.`delivery`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Delivery`.`delivery` (
  `id` BIGINT(19) NOT NULL AUTO_INCREMENT,
  `mat_doc` BIGINT(19) NOT NULL,
  `item` INT NOT NULL,
  `doc_date` DATE NOT NULL,
  `pstng_date` DATE NOT NULL,
  `quantity` INT NOT NULL,
  `amount_lc` VARCHAR(45) NOT NULL,
  `is_authorized` VARCHAR(45) NULL,
  `user_id` BIGINT(19) NOT NULL,
  `product_id` BIGINT(19) NOT NULL,
  `crcy_id` BIGINT(19) NOT NULL,
  `bun_id` BIGINT(19) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_delivery_user1_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_delivery_product1_idx` (`product_id` ASC) VISIBLE,
  INDEX `fk_delivery_crcy1_idx` (`crcy_id` ASC) VISIBLE,
  INDEX `fk_delivery_bun1_idx` (`bun_id` ASC) VISIBLE,
  CONSTRAINT `fk_delivery_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `Delivery`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_delivery_product1`
    FOREIGN KEY (`product_id`)
    REFERENCES `Delivery`.`product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_delivery_crcy1`
    FOREIGN KEY (`crcy_id`)
    REFERENCES `Delivery`.`crcy` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_delivery_bun1`
    FOREIGN KEY (`bun_id`)
    REFERENCES `Delivery`.`bun` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;