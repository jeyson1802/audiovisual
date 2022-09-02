CREATE DATABASE  IF NOT EXISTS `audiovisual` /*!40100 DEFAULT CHARACTER SET latin1 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `audiovisual`;
-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: audiovisual
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `campana`
--

DROP TABLE IF EXISTS `campana`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `campana` (
                           `idcampana` int NOT NULL AUTO_INCREMENT,
                           `descripcion` varchar(200) NOT NULL,
                           `link_campana` varchar(200) NOT NULL,
                           `link_creativos` varchar(200) DEFAULT NULL,
                           `link_canal` varchar(200) DEFAULT NULL,
                           `fecha_inicial` date DEFAULT NULL,
                           `fecha_final` date DEFAULT NULL,
                           `idlista_proveedor_email_marketing` varchar(100) NOT NULL,
                           `idcurso` int NOT NULL,
                           `idtrafico` int NOT NULL,
                           `idlista_lead` int NOT NULL,
                           `idproveedor_email_marketing` int NOT NULL,
                           `estado` varchar(1) NOT NULL COMMENT '''1: ACTIVO, 0: INACTIVO''',
                           `fecha_registro` datetime NOT NULL,
                           `usuario_registro` varchar(45) NOT NULL,
                           `fecha_modificacion` datetime DEFAULT NULL,
                           `usuario_modificacion` varchar(45) DEFAULT NULL,
                           PRIMARY KEY (`idcampana`),
                           KEY `fk_campana_trafico1_idx` (`idtrafico`),
                           KEY `fk_campana_curso1_idx` (`idcurso`),
                           KEY `fk_campana_proveedor_email_marketing1_idx` (`idproveedor_email_marketing`),
                           KEY `fk_campana_lista_lead1_idx` (`idlista_lead`),
                           CONSTRAINT `fk_campana_curso1` FOREIGN KEY (`idcurso`) REFERENCES `curso` (`idcurso`),
                           CONSTRAINT `fk_campana_lista_lead1` FOREIGN KEY (`idlista_lead`) REFERENCES `lista_lead` (`idlista_lead`),
                           CONSTRAINT `fk_campana_proveedor_email_marketing1` FOREIGN KEY (`idproveedor_email_marketing`) REFERENCES `proveedor_email_marketing` (`idproveedor_email_marketing`),
                           CONSTRAINT `fk_campana_trafico1` FOREIGN KEY (`idtrafico`) REFERENCES `trafico` (`idtrafico`)
) ENGINE=InnoDB AUTO_INCREMENT=915522 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `campana`
--

LOCK TABLES `campana` WRITE;
/*!40000 ALTER TABLE `campana` DISABLE KEYS */;
INSERT INTO `campana` VALUES (915521,'Campaña Tráfico Frío Grupos Facebook','https://filmmakerrgb.com/','https://drive.google.com/drive/folders/1aMwfJDkhx9LK2ZLusoM8wPaRQ69eZd5F?usp=sharing','https://t.me/+b3z_cU1a0xE3NWVh','2022-09-02',NULL,'1',1,1,1,1,'1','2022-09-02 13:37:02','ADMIN',NULL,NULL);
/*!40000 ALTER TABLE `campana` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `curso` (
                         `idcurso` int NOT NULL AUTO_INCREMENT,
                         `descripcion` varchar(200) NOT NULL,
                         `link_afiliado` varchar(200) DEFAULT NULL,
                         `precio` decimal(10,2) DEFAULT NULL,
                         `comision` decimal(10,2) DEFAULT NULL,
                         `estado` varchar(1) NOT NULL COMMENT '''1: ACTIVO, 0: INACTIVO''',
                         `fecha_registro` datetime NOT NULL,
                         `usuario_registro` varchar(45) NOT NULL,
                         `fecha_modificacion` datetime DEFAULT NULL,
                         `usuario_modificacion` varchar(45) DEFAULT NULL,
                         PRIMARY KEY (`idcurso`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` VALUES (1,'VisualMasterClass 2.0',NULL,97.00,43.40,'1','2022-09-02 13:37:02','ADMIN',NULL,NULL);
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lead`
--

DROP TABLE IF EXISTS `lead`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lead` (
                        `idlead` int NOT NULL AUTO_INCREMENT,
                        `correo` varchar(200) NOT NULL,
                        `nombres` varchar(200) DEFAULT NULL,
                        `ubicacion` varchar(200) DEFAULT NULL,
                        `idlista_lead` int NOT NULL,
                        `idcampana` int NOT NULL,
                        `estado` varchar(1) NOT NULL COMMENT '''1: ACTIVO, 0: INACTIVO''',
                        `fecha_registro` datetime NOT NULL,
                        `usuario_registro` varchar(45) NOT NULL,
                        `fecha_modificacion` datetime DEFAULT NULL,
                        `usuario_modificacion` varchar(45) DEFAULT NULL,
                        PRIMARY KEY (`idlead`),
                        KEY `fk_lead_lista_lead1_idx` (`idlista_lead`),
                        KEY `fk_lead_campana1_idx` (`idcampana`),
                        CONSTRAINT `fk_lead_campana1` FOREIGN KEY (`idcampana`) REFERENCES `campana` (`idcampana`),
                        CONSTRAINT `fk_lead_lista_lead1` FOREIGN KEY (`idlista_lead`) REFERENCES `lista_lead` (`idlista_lead`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lead`
--

LOCK TABLES `lead` WRITE;
/*!40000 ALTER TABLE `lead` DISABLE KEYS */;
/*!40000 ALTER TABLE `lead` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lista_lead`
--

DROP TABLE IF EXISTS `lista_lead`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lista_lead` (
                              `idlista_lead` int NOT NULL AUTO_INCREMENT,
                              `descripcion` varchar(200) NOT NULL,
                              `estado` varchar(1) NOT NULL COMMENT '''1: ACTIVO, 0: INACTIVO''',
                              `fecha_registro` datetime NOT NULL,
                              `usuario_registro` varchar(45) NOT NULL,
                              `fecha_modificacion` datetime DEFAULT NULL,
                              `usuario_modificacion` varchar(45) DEFAULT NULL,
                              PRIMARY KEY (`idlista_lead`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lista_lead`
--

LOCK TABLES `lista_lead` WRITE;
/*!40000 ALTER TABLE `lista_lead` DISABLE KEYS */;
INSERT INTO `lista_lead` VALUES (1,'Filmmakers - 01','1','2022-09-02 13:37:02','ADMIN',NULL,' '),(2,'Filmmakers - 02','1','2022-09-02 13:37:02','ADMIN',NULL,NULL);
/*!40000 ALTER TABLE `lista_lead` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor_email_marketing`
--

DROP TABLE IF EXISTS `proveedor_email_marketing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedor_email_marketing` (
                                             `idproveedor_email_marketing` int NOT NULL AUTO_INCREMENT,
                                             `nombre` varchar(200) NOT NULL,
                                             `correo` varchar(200) NOT NULL,
                                             `api` varchar(200) NOT NULL,
                                             `estado` varchar(1) NOT NULL COMMENT '''1: ACTIVO, 0: INACTIVO''',
                                             `fecha_registro` datetime NOT NULL,
                                             `usuario_registro` varchar(45) NOT NULL,
                                             `fecha_modificacion` datetime DEFAULT NULL,
                                             `usuario_modificacion` varchar(45) DEFAULT NULL,
                                             PRIMARY KEY (`idproveedor_email_marketing`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor_email_marketing`
--

LOCK TABLES `proveedor_email_marketing` WRITE;
/*!40000 ALTER TABLE `proveedor_email_marketing` DISABLE KEYS */;
INSERT INTO `proveedor_email_marketing` VALUES (1,'sendinblue','info@filmmakerrgb.com','xxxxxxxxxxxx','1','2022-09-02 13:37:02','',NULL,NULL);
/*!40000 ALTER TABLE `proveedor_email_marketing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trafico`
--

DROP TABLE IF EXISTS `trafico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trafico` (
                           `idtrafico` int NOT NULL AUTO_INCREMENT,
                           `descripcion` varchar(200) NOT NULL,
                           `tipo` varchar(1) NOT NULL COMMENT '1: Orgánico - 2: Pago',
                           `estado` varchar(1) NOT NULL COMMENT '''1: ACTIVO, 0: INACTIVO''',
                           `fecha_registro` datetime NOT NULL,
                           `usuario_registro` varchar(45) NOT NULL,
                           `fecha_modificacion` datetime DEFAULT NULL,
                           `usuario_modificacion` varchar(45) DEFAULT NULL,
                           PRIMARY KEY (`idtrafico`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trafico`
--

LOCK TABLES `trafico` WRITE;
/*!40000 ALTER TABLE `trafico` DISABLE KEYS */;
INSERT INTO `trafico` VALUES (1,'Grupos de Facebook','1','1','2022-09-02 13:37:02','',NULL,NULL);
/*!40000 ALTER TABLE `trafico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'audiovisual'
--

--
-- Dumping routines for database 'audiovisual'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-02  9:13:39
