-- MySQL dump 10.13  Distrib 8.0.30-22, for Linux (x86_64)
--
-- Host: ampto.sj.ifsc.edu.br    Database: pp01andre
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*!50717 SELECT COUNT(*) INTO @rocksdb_has_p_s_session_variables FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'performance_schema' AND TABLE_NAME = 'session_variables' */;
/*!50717 SET @rocksdb_get_is_supported = IF (@rocksdb_has_p_s_session_variables, 'SELECT COUNT(*) INTO @rocksdb_is_supported FROM performance_schema.session_variables WHERE VARIABLE_NAME=\'rocksdb_bulk_load\'', 'SELECT 0') */;
/*!50717 PREPARE s FROM @rocksdb_get_is_supported */;
/*!50717 EXECUTE s */;
/*!50717 DEALLOCATE PREPARE s */;
/*!50717 SET @rocksdb_enable_bulk_load = IF (@rocksdb_is_supported, 'SET SESSION rocksdb_bulk_load = 1', 'SET @rocksdb_dummy_bulk_load = 0') */;
/*!50717 PREPARE s FROM @rocksdb_enable_bulk_load */;
/*!50717 EXECUTE s */;
/*!50717 DEALLOCATE PREPARE s */;

--
-- Table structure for table `Cartao`
--

DROP TABLE IF EXISTS `Cartao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Cartao` (
  `idCartao` int NOT NULL AUTO_INCREMENT,
  `Jogador_idJogador` int NOT NULL,
  `Cor_idCor` int NOT NULL,
  `Partida_idPartida` int NOT NULL,
  PRIMARY KEY (`idCartao`),
  KEY `fk_Cartao_Jogador1_idx` (`Jogador_idJogador`),
  KEY `fk_Cartao_Cor1_idx` (`Cor_idCor`),
  KEY `fk_Cartao_Partida1_idx` (`Partida_idPartida`),
  CONSTRAINT `fk_Cartao_Cor1` FOREIGN KEY (`Cor_idCor`) REFERENCES `Cor` (`idCor`),
  CONSTRAINT `fk_Cartao_Jogador1` FOREIGN KEY (`Jogador_idJogador`) REFERENCES `Jogador` (`idJogador`),
  CONSTRAINT `fk_Cartao_Partida1` FOREIGN KEY (`Partida_idPartida`) REFERENCES `Partida` (`idPartida`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Cartao`
--

LOCK TABLES `Cartao` WRITE;
/*!40000 ALTER TABLE `Cartao` DISABLE KEYS */;
INSERT INTO `Cartao` VALUES (1,1,1,3),(2,2,1,1),(3,1,1,5);
/*!40000 ALTER TABLE `Cartao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Copa`
--

DROP TABLE IF EXISTS `Copa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Copa` (
  `idCopa` int NOT NULL AUTO_INCREMENT,
  `ano` int NOT NULL,
  `pais_sede` varchar(45) NOT NULL,
  PRIMARY KEY (`idCopa`,`ano`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Copa`
--

LOCK TABLES `Copa` WRITE;
/*!40000 ALTER TABLE `Copa` DISABLE KEYS */;
INSERT INTO `Copa` VALUES (1,2002,'japao'),(2,1958,'Suecia'),(3,1962,'Chile'),(4,1970,'Mexico'),(5,2006,'Alemanha'),(6,2010,'Africa-Sul'),(7,2014,'Brasil'),(8,2018,'Russia'),(9,2022,'Catar');
/*!40000 ALTER TABLE `Copa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Cor`
--

DROP TABLE IF EXISTS `Cor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Cor` (
  `idCor` int NOT NULL AUTO_INCREMENT,
  `cor` varchar(45) NOT NULL,
  PRIMARY KEY (`idCor`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Cor`
--

LOCK TABLES `Cor` WRITE;
/*!40000 ALTER TABLE `Cor` DISABLE KEYS */;
INSERT INTO `Cor` VALUES (1,'Amarelo'),(2,'Vermelho');
/*!40000 ALTER TABLE `Cor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Estadio`
--

DROP TABLE IF EXISTS `Estadio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Estadio` (
  `idEstadio` int NOT NULL AUTO_INCREMENT,
  `capacidade` int NOT NULL,
  `endereco` varchar(60) NOT NULL,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`idEstadio`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Estadio`
--

LOCK TABLES `Estadio` WRITE;
/*!40000 ALTER TABLE `Estadio` DISABLE KEYS */;
INSERT INTO `Estadio` VALUES (1,60,'rua-xablauu','Maraca'),(2,80,'rua-mirau','San-Siro'),(3,40,'rua-mablau','Arena'),(4,40,'rua-tirau','Vila-Belmiro');
/*!40000 ALTER TABLE `Estadio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Fase`
--

DROP TABLE IF EXISTS `Fase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Fase` (
  `idFase` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`idFase`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Fase`
--

LOCK TABLES `Fase` WRITE;
/*!40000 ALTER TABLE `Fase` DISABLE KEYS */;
INSERT INTO `Fase` VALUES (1,'grupos'),(2,'oitavas'),(3,'quartas'),(4,'semi'),(5,'terceiro-lugar'),(6,'final');
/*!40000 ALTER TABLE `Fase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Gol`
--

DROP TABLE IF EXISTS `Gol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Gol` (
  `idGol` int NOT NULL AUTO_INCREMENT,
  `Jogador_idJogador` int NOT NULL,
  `Partida_idPartida` int NOT NULL,
  `horario` int DEFAULT NULL,
  `ano` int DEFAULT NULL,
  PRIMARY KEY (`idGol`,`Jogador_idJogador`),
  KEY `fk_Gol_Jogador_idx` (`Jogador_idJogador`),
  KEY `fk_Gol_Partida1_idx` (`Partida_idPartida`),
  CONSTRAINT `fk_Gol_Jogador` FOREIGN KEY (`Jogador_idJogador`) REFERENCES `Jogador` (`idJogador`),
  CONSTRAINT `fk_Gol_Partida1` FOREIGN KEY (`Partida_idPartida`) REFERENCES `Partida` (`idPartida`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Gol`
--

LOCK TABLES `Gol` WRITE;
/*!40000 ALTER TABLE `Gol` DISABLE KEYS */;
INSERT INTO `Gol` VALUES (1,2,1,10,1958),(2,2,1,15,1958),(3,2,1,18,1958),(4,2,1,25,1962),(5,2,1,60,1962),(6,2,1,80,1970),(7,2,2,5,1970),(8,2,2,8,1970),(9,2,2,12,1970),(10,2,2,42,1970),(11,2,2,63,1970),(12,2,2,82,1970),(13,1,3,15,2018),(14,1,3,26,2018),(15,6,3,79,2022),(16,6,3,50,2022),(17,9,3,12,2018),(18,9,3,54,2022),(19,10,4,16,2018),(20,10,4,28,2022),(21,9,4,7,2022),(22,9,4,37,2022),(23,6,5,27,2022),(24,6,5,34,2022),(25,6,5,87,2022),(26,10,5,38,2018),(27,10,5,85,2018),(28,1,5,62,2022),(29,1,5,68,2022);
/*!40000 ALTER TABLE `Gol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Jogador`
--

DROP TABLE IF EXISTS `Jogador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Jogador` (
  `idJogador` int NOT NULL AUTO_INCREMENT,
  `data_nascimento` date NOT NULL,
  `nome` varchar(60) NOT NULL,
  `sobrenome` varchar(60) NOT NULL,
  `numero_camisa` varchar(45) DEFAULT NULL,
  `Posicao_idPosicao` int NOT NULL,
  PRIMARY KEY (`idJogador`),
  KEY `fk_Jogador_Posicao1_idx` (`Posicao_idPosicao`),
  CONSTRAINT `fk_Jogador_Posicao1` FOREIGN KEY (`Posicao_idPosicao`) REFERENCES `Posicao` (`idPosicao`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Jogador`
--

LOCK TABLES `Jogador` WRITE;
/*!40000 ALTER TABLE `Jogador` DISABLE KEYS */;
INSERT INTO `Jogador` VALUES (1,'1992-10-10','Neymar','Junior','10',1),(2,'1940-10-23','Pele','Nascimento','10',1),(5,'1976-10-10','Ronaldo','Fenomeno','9',1),(6,'1997-10-10','Richarlison','Pombo','9',1),(7,'2000-10-10','Vini','Junior','18',1),(8,'1920-10-10','Daniel','Alves','13',3),(9,'1987-10-10','Messi','Lionel','10',1),(10,'1985-10-15','Cristiano','Ronaldo','7',1);
/*!40000 ALTER TABLE `Jogador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Jogador_has_Partida`
--

DROP TABLE IF EXISTS `Jogador_has_Partida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Jogador_has_Partida` (
  `Jogador_idJogador` int NOT NULL,
  `Partida_idPartida` int NOT NULL,
  PRIMARY KEY (`Jogador_idJogador`,`Partida_idPartida`),
  KEY `fk_Jogador_has_Partida_Partida1_idx` (`Partida_idPartida`),
  KEY `fk_Jogador_has_Partida_Jogador1_idx` (`Jogador_idJogador`),
  CONSTRAINT `fk_Jogador_has_Partida_Jogador1` FOREIGN KEY (`Jogador_idJogador`) REFERENCES `Jogador` (`idJogador`),
  CONSTRAINT `fk_Jogador_has_Partida_Partida1` FOREIGN KEY (`Partida_idPartida`) REFERENCES `Partida` (`idPartida`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Jogador_has_Partida`
--

LOCK TABLES `Jogador_has_Partida` WRITE;
/*!40000 ALTER TABLE `Jogador_has_Partida` DISABLE KEYS */;
INSERT INTO `Jogador_has_Partida` VALUES (2,1),(2,2),(1,3),(6,3),(7,3),(9,3),(9,4),(1,5),(6,5),(7,5);
/*!40000 ALTER TABLE `Jogador_has_Partida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Jogador_has_Selecao`
--

DROP TABLE IF EXISTS `Jogador_has_Selecao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Jogador_has_Selecao` (
  `Jogador_idJogador` int NOT NULL,
  `Selecao_idSelecao` int NOT NULL,
  PRIMARY KEY (`Jogador_idJogador`,`Selecao_idSelecao`),
  KEY `fk_Jogador_has_Selecao_Selecao1_idx` (`Selecao_idSelecao`),
  KEY `fk_Jogador_has_Selecao_Jogador1_idx` (`Jogador_idJogador`),
  CONSTRAINT `fk_Jogador_has_Selecao_Jogador1` FOREIGN KEY (`Jogador_idJogador`) REFERENCES `Jogador` (`idJogador`),
  CONSTRAINT `fk_Jogador_has_Selecao_Selecao1` FOREIGN KEY (`Selecao_idSelecao`) REFERENCES `Selecao` (`idSelecao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Jogador_has_Selecao`
--

LOCK TABLES `Jogador_has_Selecao` WRITE;
/*!40000 ALTER TABLE `Jogador_has_Selecao` DISABLE KEYS */;
INSERT INTO `Jogador_has_Selecao` VALUES (2,1),(2,2),(2,3),(5,4),(5,5),(1,7),(8,7),(1,8),(8,8),(1,9),(6,9),(7,9),(8,9),(9,10),(10,18);
/*!40000 ALTER TABLE `Jogador_has_Selecao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Pais`
--

DROP TABLE IF EXISTS `Pais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Pais` (
  `idPais` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `sigla` varchar(45) NOT NULL,
  PRIMARY KEY (`idPais`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Pais`
--

LOCK TABLES `Pais` WRITE;
/*!40000 ALTER TABLE `Pais` DISABLE KEYS */;
INSERT INTO `Pais` VALUES (1,'Brasil','BR'),(2,'Portugal','PT'),(3,'Franca','FR'),(4,'Argentina','AR');
/*!40000 ALTER TABLE `Pais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Participacao_selecao`
--

DROP TABLE IF EXISTS `Participacao_selecao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Participacao_selecao` (
  `Selecao_idSelecao` int NOT NULL,
  `Copa_idCopa` int NOT NULL,
  `Copa_ano` int NOT NULL,
  PRIMARY KEY (`Selecao_idSelecao`,`Copa_idCopa`,`Copa_ano`),
  KEY `fk_Selecao_has_Copa_Copa1_idx` (`Copa_idCopa`,`Copa_ano`),
  KEY `fk_Selecao_has_Copa_Selecao1_idx` (`Selecao_idSelecao`),
  CONSTRAINT `fk_Selecao_has_Copa_Copa1` FOREIGN KEY (`Copa_idCopa`, `Copa_ano`) REFERENCES `Copa` (`idCopa`, `ano`),
  CONSTRAINT `fk_Selecao_has_Copa_Selecao1` FOREIGN KEY (`Selecao_idSelecao`) REFERENCES `Selecao` (`idSelecao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Participacao_selecao`
--

LOCK TABLES `Participacao_selecao` WRITE;
/*!40000 ALTER TABLE `Participacao_selecao` DISABLE KEYS */;
INSERT INTO `Participacao_selecao` VALUES (1,2,1958),(2,3,1962),(3,4,1970),(9,9,2022),(10,9,2022),(18,9,2022);
/*!40000 ALTER TABLE `Participacao_selecao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Partida`
--

DROP TABLE IF EXISTS `Partida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Partida` (
  `idPartida` int NOT NULL AUTO_INCREMENT,
  `Estadio_idEstadio` int NOT NULL,
  `Selecao_idSelecao` int NOT NULL,
  `Selecao_idSelecao1` int NOT NULL,
  `Fase_idFase` int NOT NULL,
  `data` varchar(45) NOT NULL,
  PRIMARY KEY (`idPartida`),
  KEY `fk_Partida_Estadio1_idx` (`Estadio_idEstadio`),
  KEY `fk_Partida_Selecao1_idx` (`Selecao_idSelecao`),
  KEY `fk_Partida_Selecao2_idx` (`Selecao_idSelecao1`),
  KEY `fk_Partida_Fase1_idx` (`Fase_idFase`),
  CONSTRAINT `fk_Partida_Estadio1` FOREIGN KEY (`Estadio_idEstadio`) REFERENCES `Estadio` (`idEstadio`),
  CONSTRAINT `fk_Partida_Fase1` FOREIGN KEY (`Fase_idFase`) REFERENCES `Fase` (`idFase`),
  CONSTRAINT `fk_Partida_Selecao1` FOREIGN KEY (`Selecao_idSelecao`) REFERENCES `Selecao` (`idSelecao`),
  CONSTRAINT `fk_Partida_Selecao2` FOREIGN KEY (`Selecao_idSelecao1`) REFERENCES `Selecao` (`idSelecao`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Partida`
--

LOCK TABLES `Partida` WRITE;
/*!40000 ALTER TABLE `Partida` DISABLE KEYS */;
INSERT INTO `Partida` VALUES (1,1,1,11,1,'1958-01-19 03:14:07'),(2,2,1,11,4,'1958-01-25 03:14:07'),(3,4,9,10,1,'2022-12-05 16:00:00'),(4,2,10,18,1,'2022-12-08 12:00:00'),(5,1,9,18,1,'2022-12-12 16:00:00');
/*!40000 ALTER TABLE `Partida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Posicao`
--

DROP TABLE IF EXISTS `Posicao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Posicao` (
  `idPosicao` int NOT NULL AUTO_INCREMENT,
  `posicao` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idPosicao`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Posicao`
--

LOCK TABLES `Posicao` WRITE;
/*!40000 ALTER TABLE `Posicao` DISABLE KEYS */;
INSERT INTO `Posicao` VALUES (1,'atacante'),(2,'meio-campo'),(3,'zagueiro'),(4,'goleiro'),(5,'lateral-esquerdo'),(6,'lateral-direto');
/*!40000 ALTER TABLE `Posicao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Selecao`
--

DROP TABLE IF EXISTS `Selecao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Selecao` (
  `idSelecao` int NOT NULL AUTO_INCREMENT,
  `Pais_idPais` int NOT NULL,
  PRIMARY KEY (`idSelecao`),
  KEY `fk_Selecao_Pais1_idx` (`Pais_idPais`),
  CONSTRAINT `fk_Selecao_Pais1` FOREIGN KEY (`Pais_idPais`) REFERENCES `Pais` (`idPais`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Selecao`
--

LOCK TABLES `Selecao` WRITE;
/*!40000 ALTER TABLE `Selecao` DISABLE KEYS */;
INSERT INTO `Selecao` VALUES (1,1),(2,1),(3,1),(4,1),(5,1),(6,1),(7,1),(8,1),(9,1),(18,2),(19,2),(20,2),(21,2),(22,2),(23,2),(24,2),(25,2),(10,4),(11,4),(12,4),(13,4),(14,4),(15,4),(16,4),(17,4);
/*!40000 ALTER TABLE `Selecao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Selecao_has_Tecnico`
--

DROP TABLE IF EXISTS `Selecao_has_Tecnico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Selecao_has_Tecnico` (
  `Selecao_idSelecao` int NOT NULL,
  `Tecnico_idTecnico` int NOT NULL,
  PRIMARY KEY (`Selecao_idSelecao`,`Tecnico_idTecnico`),
  KEY `fk_Selecao_has_Tecnico_Tecnico1_idx` (`Tecnico_idTecnico`),
  KEY `fk_Selecao_has_Tecnico_Selecao1_idx` (`Selecao_idSelecao`),
  CONSTRAINT `fk_Selecao_has_Tecnico_Selecao1` FOREIGN KEY (`Selecao_idSelecao`) REFERENCES `Selecao` (`idSelecao`),
  CONSTRAINT `fk_Selecao_has_Tecnico_Tecnico1` FOREIGN KEY (`Tecnico_idTecnico`) REFERENCES `Tecnico` (`idTecnico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Selecao_has_Tecnico`
--

LOCK TABLES `Selecao_has_Tecnico` WRITE;
/*!40000 ALTER TABLE `Selecao_has_Tecnico` DISABLE KEYS */;
INSERT INTO `Selecao_has_Tecnico` VALUES (9,1),(18,2),(10,3);
/*!40000 ALTER TABLE `Selecao_has_Tecnico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Tecnico`
--

DROP TABLE IF EXISTS `Tecnico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Tecnico` (
  `idTecnico` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `sobrenome` varchar(45) NOT NULL,
  PRIMARY KEY (`idTecnico`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Tecnico`
--

LOCK TABLES `Tecnico` WRITE;
/*!40000 ALTER TABLE `Tecnico` DISABLE KEYS */;
INSERT INTO `Tecnico` VALUES (1,'Titi','dfgbrb'),(2,'Fernando','Santos'),(3,'Lionel','Scaloni');
/*!40000 ALTER TABLE `Tecnico` ENABLE KEYS */;
UNLOCK TABLES;
/*!50112 SET @disable_bulk_load = IF (@is_rocksdb_supported, 'SET SESSION rocksdb_bulk_load = @old_rocksdb_bulk_load', 'SET @dummy_rocksdb_bulk_load = 0') */;
/*!50112 PREPARE s FROM @disable_bulk_load */;
/*!50112 EXECUTE s */;
/*!50112 DEALLOCATE PREPARE s */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-19 23:21:49
