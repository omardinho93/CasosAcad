CREATE DATABASE  IF NOT EXISTS `CasosAcad` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `CasosAcad`;
-- MySQL dump 10.13  Distrib 5.5.54, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: CasosAcad
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.21-MariaDB-1~jessie

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `caso`
--

DROP TABLE IF EXISTS `caso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `caso` (
  `id_caso` int(11) NOT NULL,
  `id_proceso` int(11) DEFAULT NULL,
  `id_solicitud` int(11) DEFAULT NULL,
  `fecha_inicio_caso` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_caso`),
  KEY `fk_id_proceso_idx` (`id_proceso`),
  KEY `fk_id_solicitud_idx` (`id_solicitud`),
  CONSTRAINT `fk_id_proceso` FOREIGN KEY (`id_proceso`) REFERENCES `proceso` (`id_proceso`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_id_solicitud` FOREIGN KEY (`id_solicitud`) REFERENCES `solicitud` (`id_solicitud`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caso`
--

LOCK TABLES `caso` WRITE;
/*!40000 ALTER TABLE `caso` DISABLE KEYS */;
/*!40000 ALTER TABLE `caso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `caso_detalle`
--

DROP TABLE IF EXISTS `caso_detalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `caso_detalle` (
  `id_caso_detalle` int(11) NOT NULL,
  `id_caso` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_caso_detalle`),
  KEY `fk_id_caso_idx` (`id_caso`),
  CONSTRAINT `fk_id_caso` FOREIGN KEY (`id_caso`) REFERENCES `caso` (`id_caso`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caso_detalle`
--

LOCK TABLES `caso_detalle` WRITE;
/*!40000 ALTER TABLE `caso_detalle` DISABLE KEYS */;
/*!40000 ALTER TABLE `caso_detalle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `caso_detalle_requisito`
--

DROP TABLE IF EXISTS `caso_detalle_requisito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `caso_detalle_requisito` (
  `id_caso_detalle_requisito` int(11) NOT NULL,
  `id_caso_detalle` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_caso_detalle_requisito`),
  KEY `fk_caso_detalle_idx` (`id_caso_detalle`),
  CONSTRAINT `fk_caso_detalle` FOREIGN KEY (`id_caso_detalle`) REFERENCES `caso_detalle` (`id_caso_detalle`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caso_detalle_requisito`
--

LOCK TABLES `caso_detalle_requisito` WRITE;
/*!40000 ALTER TABLE `caso_detalle_requisito` DISABLE KEYS */;
/*!40000 ALTER TABLE `caso_detalle_requisito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `caso_detalle_requisito_atestado`
--

DROP TABLE IF EXISTS `caso_detalle_requisito_atestado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `caso_detalle_requisito_atestado` (
  `idcaso_detalle_requisito_atestado` int(11) NOT NULL,
  `id_caso_detalle_requisito` int(11) DEFAULT NULL,
  PRIMARY KEY (`idcaso_detalle_requisito_atestado`),
  KEY `fk_caso_detalle_requisito_idx` (`id_caso_detalle_requisito`),
  CONSTRAINT `fk_caso_detalle_requisito` FOREIGN KEY (`id_caso_detalle_requisito`) REFERENCES `caso_detalle_requisito` (`id_caso_detalle_requisito`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caso_detalle_requisito_atestado`
--

LOCK TABLES `caso_detalle_requisito_atestado` WRITE;
/*!40000 ALTER TABLE `caso_detalle_requisito_atestado` DISABLE KEYS */;
/*!40000 ALTER TABLE `caso_detalle_requisito_atestado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paso`
--

DROP TABLE IF EXISTS `paso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paso` (
  `id_paso` int(11) NOT NULL,
  `id_tipo_paso` int(11) DEFAULT NULL,
  `nombre_paso` varchar(45) DEFAULT NULL,
  `descripcion` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`id_paso`),
  KEY `fk_tipo_paso_idx` (`id_tipo_paso`),
  CONSTRAINT `fk_tipo_paso` FOREIGN KEY (`id_tipo_paso`) REFERENCES `tipo_paso` (`id_tipo_paso`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paso`
--

LOCK TABLES `paso` WRITE;
/*!40000 ALTER TABLE `paso` DISABLE KEYS */;
/*!40000 ALTER TABLE `paso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paso_requisito`
--

DROP TABLE IF EXISTS `paso_requisito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paso_requisito` (
  `id_paso_requisito` int(11) NOT NULL,
  `id_paso` int(11) DEFAULT NULL,
  `id_requisito` int(11) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_paso_requisito`),
  KEY `fk_id_paso_idx` (`id_paso`),
  KEY `fk_id_paso_requisito_idx` (`id_requisito`),
  CONSTRAINT `fk_id_paso` FOREIGN KEY (`id_paso`) REFERENCES `paso` (`id_paso`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_id_paso_requisito` FOREIGN KEY (`id_requisito`) REFERENCES `requisito` (`id_requisito`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paso_requisito`
--

LOCK TABLES `paso_requisito` WRITE;
/*!40000 ALTER TABLE `paso_requisito` DISABLE KEYS */;
/*!40000 ALTER TABLE `paso_requisito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proceso`
--

DROP TABLE IF EXISTS `proceso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proceso` (
  `id_proceso` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`id_proceso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proceso`
--

LOCK TABLES `proceso` WRITE;
/*!40000 ALTER TABLE `proceso` DISABLE KEYS */;
/*!40000 ALTER TABLE `proceso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proceso_detalle`
--

DROP TABLE IF EXISTS `proceso_detalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proceso_detalle` (
  `idproceso_detalle` int(11) NOT NULL,
  `id_proceso` int(11) DEFAULT NULL,
  `id_paso` int(11) DEFAULT NULL,
  `id_padre` int(11) DEFAULT NULL,
  PRIMARY KEY (`idproceso_detalle`),
  KEY `fk_proceso_idx` (`id_proceso`),
  KEY `fk_paso_idx` (`id_paso`),
  KEY `fk_padre_idx` (`id_padre`),
  CONSTRAINT `fk_padre` FOREIGN KEY (`id_padre`) REFERENCES `proceso_detalle` (`idproceso_detalle`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_paso` FOREIGN KEY (`id_paso`) REFERENCES `paso` (`id_paso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_proceso` FOREIGN KEY (`id_proceso`) REFERENCES `proceso` (`id_proceso`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proceso_detalle`
--

LOCK TABLES `proceso_detalle` WRITE;
/*!40000 ALTER TABLE `proceso_detalle` DISABLE KEYS */;
/*!40000 ALTER TABLE `proceso_detalle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requisito`
--

DROP TABLE IF EXISTS `requisito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `requisito` (
  `id_requisito` int(11) NOT NULL,
  `id_tipo_requisito` int(11) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`id_requisito`),
  KEY `fk_tipo_requisito_idx` (`id_tipo_requisito`),
  CONSTRAINT `fk_tipo_requisito` FOREIGN KEY (`id_tipo_requisito`) REFERENCES `tipo_requisito` (`id_tipo_requisito`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requisito`
--

LOCK TABLES `requisito` WRITE;
/*!40000 ALTER TABLE `requisito` DISABLE KEYS */;
/*!40000 ALTER TABLE `requisito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solicitud`
--

DROP TABLE IF EXISTS `solicitud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `solicitud` (
  `id_solicitud` int(11) NOT NULL,
  `nombre_solicitud` varchar(45) DEFAULT NULL,
  `nombre_solicitante` varchar(45) DEFAULT NULL,
  `descripcion` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`id_solicitud`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitud`
--

LOCK TABLES `solicitud` WRITE;
/*!40000 ALTER TABLE `solicitud` DISABLE KEYS */;
/*!40000 ALTER TABLE `solicitud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_paso`
--

DROP TABLE IF EXISTS `tipo_paso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_paso` (
  `id_tipo_paso` int(11) NOT NULL,
  `nombre` varchar(20) DEFAULT NULL,
  `activo` tinyint(1) DEFAULT NULL,
  `descripcion` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id_tipo_paso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_paso`
--

LOCK TABLES `tipo_paso` WRITE;
/*!40000 ALTER TABLE `tipo_paso` DISABLE KEYS */;
INSERT INTO `tipo_paso` VALUES (1,'tipo paso 1',1,'tipo de paso numero 1'),(2,'tipo paso 2',1,'tipo de paso 2'),(3,'tipo paso 3',0,'tipo de paso 3'),(4,'tipo paso 4',1,'tipo de paso cuatro'),(5,'tipo paso 5',1,'tipo de paso cinco');
/*!40000 ALTER TABLE `tipo_paso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_requisito`
--

DROP TABLE IF EXISTS `tipo_requisito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_requisito` (
  `id_tipo_requisito` int(11) NOT NULL,
  `nombre` varchar(20) DEFAULT NULL,
  `descripcion` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id_tipo_requisito`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_requisito`
--

LOCK TABLES `tipo_requisito` WRITE;
/*!40000 ALTER TABLE `tipo_requisito` DISABLE KEYS */;
INSERT INTO `tipo_requisito` VALUES (1,'tipo 1','este es el tipo de requisito 1'),(2,'tipo 2','este es el tipo 2 de requisito'),(3,'tipo 3','este es el tipo de requisito 3');
/*!40000 ALTER TABLE `tipo_requisito` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-02 14:39:45
