SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';


-- -----------------------------------------------------
-- Table `jcalEletronicos`.`Usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jcalEletronicos`.`Usuario` ;

CREATE TABLE IF NOT EXISTS `jcalEletronicos`.`Usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `nomeUsuario` VARCHAR(45) NOT NULL,
  `emailUsuario` VARCHAR(45) NOT NULL,
  `telefoneUsuario` VARCHAR(45) NOT NULL,
  `dataNascimentoUsuario` DATE NOT NULL,
  `sexoUsuario` ENUM('m','f') NOT NULL COMMENT 'm: masculino\nf: feminino\n',
  `tipoUsuario` ENUM('a', 'g', 'e', 'v', 'c') NOT NULL COMMENT 'a: administrador\ng: gerente\ne: encarregado\nv: vendedor\nc: cliente\n',
  `senhaUsuario` VARCHAR(45) NOT NULL,
  `cpfUsuario` VARCHAR(45) NULL,
  `enderecoUsuario` VARCHAR(45) NULL,
  `cepUsuario` VARCHAR(45) NULL,
  `cidadeUsuario` VARCHAR(20) NULL,
  `estadoUsuario` VARCHAR(2) NULL,
  PRIMARY KEY (`idUsuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jcalEletronicos`.`Produto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jcalEletronicos`.`Produto` ;

CREATE TABLE IF NOT EXISTS `jcalEletronicos`.`Produto` (
  `idProduto` INT NOT NULL AUTO_INCREMENT,
  `nomeProduto` VARCHAR(45) NOT NULL,
  `precoProduto` FLOAT NOT NULL,
  `descricaoProduto` VARCHAR(1000) NOT NULL,
  `categoriaProduto` ENUM('ap','ac') NOT NULL COMMENT 'ap: Aparelho\nac: acessório',
  `quantidadeEstoqueProduto` INT NOT NULL,
  PRIMARY KEY (`idProduto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jcalEletronicos`.`Compra`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jcalEletronicos`.`Compra` ;

CREATE TABLE IF NOT EXISTS `jcalEletronicos`.`Compra` (
  `idCompra` INT NOT NULL AUTO_INCREMENT,
  `valorCompra` FLOAT NOT NULL,
  `freteCompra` FLOAT NOT NULL,
  `idUsuarioCompra` INT NOT NULL,
  PRIMARY KEY (`idCompra`),
  INDEX `fk_Compra_Usuario1_idx` (`idUsuarioCompra` ASC),
  CONSTRAINT `fk_Compra_Usuario1`
    FOREIGN KEY (`idUsuarioCompra`)
    REFERENCES `jcalEletronicos`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jcalEletronicos`.`Carrinho`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jcalEletronicos`.`Carrinho` ;

CREATE TABLE IF NOT EXISTS `jcalEletronicos`.`Carrinho` (
  `idCarrinho` INT NOT NULL AUTO_INCREMENT,
  `idProdutoCarrinho` INT NOT NULL,
  `idUsuarioCarrinho` INT NOT NULL,
  PRIMARY KEY (`idCarrinho`),
  INDEX `fk_Compra_has_Produto_Produto1_idx` (`idProdutoCarrinho` ASC),
  INDEX `fk_ItemCompra_Usuario1_idx` (`idUsuarioCarrinho` ASC),
  CONSTRAINT `fk_Compra_has_Produto_Produto1`
    FOREIGN KEY (`idProdutoCarrinho`)
    REFERENCES `jcalEletronicos`.`Produto` (`idProduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ItemCompra_Usuario1`
    FOREIGN KEY (`idUsuarioCarrinho`)
    REFERENCES `jcalEletronicos`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jcalEletronicos`.`Promocao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jcalEletronicos`.`Promocao` ;

CREATE TABLE IF NOT EXISTS `jcalEletronicos`.`Promocao` (
  `idPromocao` INT NOT NULL AUTO_INCREMENT,
  `nomePromocao` VARCHAR(45) NOT NULL,
  `dataComecoPromocao` DATE NOT NULL,
  `dataFimPromocao` DATE NOT NULL,
  `descontoPromocao` FLOAT NOT NULL,
  `statusPromocao` ENUM('A','I') NOT NULL COMMENT 'A = Ativa\nI = Inativa',
  PRIMARY KEY (`idPromocao`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jcalEletronicos`.`PromocaoProduto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jcalEletronicos`.`PromocaoProduto` ;

CREATE TABLE IF NOT EXISTS `jcalEletronicos`.`PromocaoProduto` (
  `idPromocaoProduto` INT NOT NULL AUTO_INCREMENT,
  `idProdutoPromocaoProduto` INT NOT NULL,
  `idPromocaoPromocaoProduto` INT NOT NULL,
  INDEX `fk_Produto_has_Promocao_Promocao1_idx` (`idPromocaoPromocaoProduto` ASC),
  INDEX `fk_Produto_has_Promocao_Produto1_idx` (`idProdutoPromocaoProduto` ASC),
  PRIMARY KEY (`idPromocaoProduto`),
  CONSTRAINT `fk_Produto_has_Promocao_Produto1`
    FOREIGN KEY (`idProdutoPromocaoProduto`)
    REFERENCES `jcalEletronicos`.`Produto` (`idProduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Produto_has_Promocao_Promocao1`
    FOREIGN KEY (`idPromocaoPromocaoProduto`)
    REFERENCES `jcalEletronicos`.`Promocao` (`idPromocao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jcalEletronicos`.`ImagemProduto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jcalEletronicos`.`ImagemProduto` ;

CREATE TABLE IF NOT EXISTS `jcalEletronicos`.`ImagemProduto` (
  `idImagemProduto` INT NOT NULL AUTO_INCREMENT,
  `imagem1` LONGTEXT NOT NULL,
  `imagem2` LONGTEXT NULL,
  `imagem3` LONGTEXT NULL,
  `idProdutoImagemProduto` INT NOT NULL,
  PRIMARY KEY (`idImagemProduto`),
  INDEX `fk_ImagemDeProduto_Produto1_idx` (`idProdutoImagemProduto` ASC),
  CONSTRAINT `fk_ImagemDeProduto_Produto1`
    FOREIGN KEY (`idProdutoImagemProduto`)
    REFERENCES `jcalEletronicos`.`Produto` (`idProduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
