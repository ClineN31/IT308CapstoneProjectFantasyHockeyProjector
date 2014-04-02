SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `Fantasy_Hockey_Projector` ;
USE `Fantasy_Hockey_Projector` ;

-- -----------------------------------------------------
-- Table `Fantasy_Hockey_Projector`.`Teams`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Fantasy_Hockey_Projector`.`Teams` ;

CREATE  TABLE IF NOT EXISTS `Fantasy_Hockey_Projector`.`Teams` (
  `TeamsID` INT NOT NULL AUTO_INCREMENT ,
  `TeamName` VARCHAR(25) NOT NULL ,
  `TeamRegion` VARCHAR(25) NOT NULL ,
  PRIMARY KEY (`TeamsID`) ,
  UNIQUE INDEX `TeamsID_UNIQUE` (`TeamsID` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Fantasy_Hockey_Projector`.`Positions`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Fantasy_Hockey_Projector`.`Positions` ;

CREATE  TABLE IF NOT EXISTS `Fantasy_Hockey_Projector`.`Positions` (
  `PositionID` INT NOT NULL AUTO_INCREMENT ,
  `PositionName` VARCHAR(15) NOT NULL ,
  PRIMARY KEY (`PositionID`) ,
  UNIQUE INDEX `PositionID_UNIQUE` (`PositionID` ASC) );


-- -----------------------------------------------------
-- Table `Fantasy_Hockey_Projector`.`Players`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Fantasy_Hockey_Projector`.`Players` ;

CREATE  TABLE IF NOT EXISTS `Fantasy_Hockey_Projector`.`Players` (
  `PlayerID` INT NOT NULL AUTO_INCREMENT ,
  `TeamsID` INT NOT NULL ,
  `PositionID` INT NOT NULL ,
  `FName` VARCHAR(25) NOT NULL ,
  `LName` VARCHAR(25) NOT NULL ,
  `PlayerNumber` VARCHAR(5) NOT NULL ,
  PRIMARY KEY (`PlayerID`) ,
  UNIQUE INDEX `PlayerID_UNIQUE` (`PlayerID` ASC) ,
  INDEX `TeamsID_idx` (`TeamsID` ASC) ,
  INDEX `PositionID_idx` (`PositionID` ASC) ,
  CONSTRAINT `TeamsID`
    FOREIGN KEY (`TeamsID` )
    REFERENCES `Fantasy_Hockey_Projector`.`Teams` (`TeamsID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `PositionID`
    FOREIGN KEY (`PositionID` )
    REFERENCES `Fantasy_Hockey_Projector`.`Positions` (`PositionID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Fantasy_Hockey_Projector`.`Stats`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Fantasy_Hockey_Projector`.`Stats` ;

CREATE  TABLE IF NOT EXISTS `Fantasy_Hockey_Projector`.`Stats` (
  `StatID` INT NOT NULL AUTO_INCREMENT ,
  `PlayerID` INT NOT NULL ,
  `Goals` INT NOT NULL DEFAULT 0 ,
  `Assists` INT NOT NULL DEFAULT 0 ,
  `PlusMinus` INT NOT NULL DEFAULT 0 ,
  `GAA` DECIMAL NOT NULL DEFAULT 0 ,
  `Save` DECIMAL NOT NULL DEFAULT 0 ,
  `Wins` INT NOT NULL DEFAULT 0 ,
  PRIMARY KEY (`StatID`) ,
  UNIQUE INDEX `StatID_UNIQUE` (`StatID` ASC) ,
  INDEX `PlayerID_idx` (`PlayerID` ASC) ,
  CONSTRAINT `PlayerID`
    FOREIGN KEY (`PlayerID` )
    REFERENCES `Fantasy_Hockey_Projector`.`Players` (`PlayerID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Fantasy_Hockey_Projector`.`Users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Fantasy_Hockey_Projector`.`Users` ;

CREATE  TABLE IF NOT EXISTS `Fantasy_Hockey_Projector`.`Users` (
  `UsersID` INT NOT NULL AUTO_INCREMENT ,
  `UsersName` VARCHAR(45) NOT NULL ,
  `UsersPassword` VARCHAR(45) NOT NULL ,
  `UsersFName` VARCHAR(45) NOT NULL ,
  `UsersLName` VARCHAR(45) NOT NULL ,
  `AdminUser` TINYINT(1) NOT NULL ,
  PRIMARY KEY (`UsersID`) ,
  UNIQUE INDEX `UsersID_UNIQUE` (`UsersID` ASC) )
ENGINE = InnoDB;

USE `Fantasy_Hockey_Projector` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
