CREATE TABLE `prueba`.`counties` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

INSERT INTO `prueba`.`counties` (`code`, `name`) VALUES ('code600', 'Cundinamarca');


CREATE TABLE `prueba`.`city` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `countiesID` INT NOT NULL,
  `code` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

  INSERT INTO `prueba`.`city` (`countiesID`, `code`, `name`) VALUES ('1', 'code601', 'Bogotá DC');

  CREATE TABLE `prueba`.`material` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cityID` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  `type` VARCHAR(45) NULL,
  `purchaseAt` DATETIME NULL,
  `saleAt` DATETIME NULL,
  `status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

INSERT INTO `prueba`.`material` (`cityID`, `name`, `description`, `type`, `purchaseAt`, `saleAt`, `status`) VALUES ('1', 'Nombre1', 'Descripcion1', 'tipo1', '2025-05-27 18:10:44', '2025-05-27 18:10:44', 'ACTIVE');
