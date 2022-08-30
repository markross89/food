-- -----------------------------------------------------
-- Schema scrumlab
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `scrumlab` DEFAULT CHARACTER SET utf8 ;
USE `scrumlab` ;

-- -----------------------------------------------------
-- Table `scrumlab`.`admins`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `scrumlab`.`admins` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'Klucz główny tabeli.',
  `first_name` VARCHAR(245) NULL COMMENT 'Imię',
  `last_name` VARCHAR(245) NULL COMMENT 'Nazwisko',
  `email` VARCHAR(245) NULL COMMENT 'Adres email',
  `password` VARCHAR(60) NULL COMMENT 'Hasło',
  `superadmin` TINYINT(1) NULL COMMENT 'Czy użytkownik jest Super Administratorem.',
  `enable` TINYINT(1) NOT NULL DEFAULT '1' COMMENT 'Czy jest aktywny i może się logować.',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
COMMENT = 'Tabela zawierająca dane użytkowników';


-- -----------------------------------------------------
-- Table `scrumlab`.`recipe`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `scrumlab`.`recipe` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'Klucz główny tabeli.',
  `name` VARCHAR(255) NULL COMMENT 'Nazwa przepisu.',
  `ingredients` TEXT NULL COMMENT 'Składniki przepisu.',
  `description` TEXT NULL COMMENT 'Opis przepisu.',
  `created` DATETIME NULL COMMENT 'Data dodania.',
  `updated` DATETIME NULL COMMENT 'Data edycji.',
  `preparation_time` INT NULL COMMENT 'Czas przygotowania w minutach.',
  `preparation` TEXT NULL COMMENT 'Sposób przygotowania.',
  `admin_id` INT NOT NULL COMMENT 'Klucz obcy tabeli admins.',
  PRIMARY KEY (`id`),
  INDEX `fk_recipie_admins1_idx` (`admin_id` ASC),
  CONSTRAINT `fk_recipie_admins1`
    FOREIGN KEY (`admin_id`)
    REFERENCES `scrumlab`.`admins` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'Tabela zawierająca przepisy';


-- -----------------------------------------------------
-- Table `scrumlab`.`plan`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `scrumlab`.`plan` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'Klucz główny tabeli',
  `name` VARCHAR(45) NULL COMMENT 'Nazwa planu.',
  `description` TEXT NULL COMMENT 'Opis planu',
  `created` DATETIME NULL COMMENT 'Data utworzenia.',
  `admin_id` INT NOT NULL COMMENT 'Klucz obcy tabeli admins.',
  PRIMARY KEY (`id`),
  INDEX `fk_plan_admins1_idx` (`admin_id` ASC),
  CONSTRAINT `fk_plan_admins1`
    FOREIGN KEY (`admin_id`)
    REFERENCES `scrumlab`.`admins` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'Tabela zawierająca informacje na temat planów.';


-- -----------------------------------------------------
-- Table `scrumlab`.`day_name`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `scrumlab`.`day_name` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL COMMENT 'Nazwa dnia.',
  `display_order` INT NULL COMMENT 'Kolejność wyświetlania.',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
COMMENT = 'Tabela zawierająca nazwy dni.';


-- -----------------------------------------------------
-- Table `scrumlab`.`recipe_plan`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `scrumlab`.`recipe_plan` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'Klucz główny tabeli.',
  `recipe_id` INT NOT NULL COMMENT 'Klucz obcy tabeli przepisów.',
  `meal_name` VARCHAR(245) NULL COMMENT 'Nazwa posiłku',
  `display_order` INT NULL COMMENT 'Kolejność wyświetlania posiłku w ciągu dnia.',
  `day_name_id` INT NOT NULL COMMENT 'Klucz obcy tabeli dni.',
  `plan_id` INT NOT NULL COMMENT 'Klucz obcy tabeli plany.',
  PRIMARY KEY (`id`),
  INDEX `fk_recipe_plan_recipe1_idx` (`recipe_id` ASC),
  INDEX `fk_recipe_day_day_name1_idx` (`day_name_id` ASC),
  INDEX `fk_recipe_plan_plan1_idx` (`plan_id` ASC),
  CONSTRAINT `fk_recipe_plan_recipe1`
    FOREIGN KEY (`recipe_id`)
    REFERENCES `scrumlab`.`recipe` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_recipe_day_day_name1`
    FOREIGN KEY (`day_name_id`)
    REFERENCES `scrumlab`.`day_name` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_recipe_plan_plan1`
    FOREIGN KEY (`plan_id`)
    REFERENCES `scrumlab`.`plan` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'Tabela zawierająca informacje o połączeniu przepisu oraz planu.';


-- -----------------------------------------------------
-- Table `scrumlab`.`pages`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `scrumlab`.`pages` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'Klucz główny tabeli',
  `title` VARCHAR(245) NULL COMMENT 'Tytuł strony.',
  `description` TEXT NULL COMMENT 'Zawartość strony.',
  `slug` VARCHAR(245) NULL COMMENT 'Unikalny identyfikator strony tworzony na podstawie tytułu.',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `slug_UNIQUE` (`slug` ASC))
ENGINE = InnoDB;


CREATE TABLE `book` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8_polish_ci NOT NULL,
  `author` varchar(255) COLLATE utf8_polish_ci NOT NULL,
  `isbn` varchar(255) COLLATE utf8_polish_ci NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
COMMENT = 'Przykładowa tabela.';