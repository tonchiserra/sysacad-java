CREATE DATABASE  IF NOT EXISTS `tpsysacad` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `tpsysacad`;
-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: tpsysacad
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Table structure for table `carrera`
--

DROP TABLE IF EXISTS `carrera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carrera` (
  `idCarrera` int unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`idCarrera`),
  UNIQUE KEY `idCarrera_UNIQUE` (`idCarrera`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrera`
--

LOCK TABLES `carrera` WRITE;
/*!40000 ALTER TABLE `carrera` DISABLE KEYS */;
INSERT INTO `carrera` VALUES (1,'ISI','Ingeniería en Sistemas de Información'),(2,'IQ','Ingeniería Química'),(3,'IM','Ingeniería Mecánica'),(4,'IE','Ingeniería Eléctrica'),(5,'IC','Ingeniería Civil');
/*!40000 ALTER TABLE `carrera` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comision`
--

DROP TABLE IF EXISTS `comision`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comision` (
  `codigoComision` varchar(50) NOT NULL,
  `cupoTotal` int unsigned NOT NULL,
  PRIMARY KEY (`codigoComision`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comision`
--

LOCK TABLES `comision` WRITE;
/*!40000 ALTER TABLE `comision` DISABLE KEYS */;
INSERT INTO `comision` VALUES ('101',100),('102',80),('103',80),('104',90),('105',80),('201',60),('202',60),('203',50),('204',55),('205',65),('301',40),('302',45),('303',50),('304',45),('305',40),('401',30),('402',30),('403',30),('404',30),('405',30),('501',30),('502',25),('503',25),('504',30),('505',25);
/*!40000 ALTER TABLE `comision` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `examen`
--

DROP TABLE IF EXISTS `examen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `examen` (
  `legajo` int unsigned NOT NULL,
  `idMateria` int unsigned NOT NULL,
  `fecha` date NOT NULL,
  `estado` varchar(45) NOT NULL,
  `nota` int unsigned NOT NULL,
  PRIMARY KEY (`legajo`,`idMateria`,`fecha`),
  KEY `FK_examen_materia_idx` (`idMateria`),
  CONSTRAINT `FK_examen_materia` FOREIGN KEY (`idMateria`) REFERENCES `materia` (`idMateria`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `FK_examen_usuario` FOREIGN KEY (`legajo`) REFERENCES `usuario` (`legajo`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `examen`
--

LOCK TABLES `examen` WRITE;
/*!40000 ALTER TABLE `examen` DISABLE KEYS */;
INSERT INTO `examen` VALUES (47064,1,'2022-06-30','Aprobado',10);
/*!40000 ALTER TABLE `examen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materia`
--

DROP TABLE IF EXISTS `materia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `materia` (
  `idMateria` int unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `año` varchar(45) NOT NULL,
  `idCarrera` int unsigned NOT NULL,
  PRIMARY KEY (`idMateria`),
  KEY `idCarrera_idx` (`idCarrera`),
  CONSTRAINT `FK_materia_carrera` FOREIGN KEY (`idCarrera`) REFERENCES `carrera` (`idCarrera`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materia`
--

LOCK TABLES `materia` WRITE;
/*!40000 ALTER TABLE `materia` DISABLE KEYS */;
INSERT INTO `materia` VALUES (1,'Análisis Matemático 1','funciones, derivadas, integrales','2008',1),(2,'Algebra y Geometría Analítica',NULL,'2008',1),(3,'Matemátoca Discreta',NULL,'2008',1),(4,'Sistemas y Organizaciones',NULL,'2008',1),(5,'Algoritmos y Estructuras de Datos',NULL,'2008',1),(6,'Arquitectura de Computadoras',NULL,'2008',1),(7,'Física 1',NULL,'2008',1),(8,'Inglés Técnico 1',NULL,'2008',1),(9,'Química General',NULL,'2008',1),(10,'Análisis Matemático 2',NULL,'2008',1),(11,'Física 2',NULL,'2008',1),(12,'Análisis de Sistemas',NULL,'2008',1),(13,'Sintaxis y Semántica de Lenguajes',NULL,'2008',1),(14,'Paradigmas de Programación',NULL,'2008',1),(15,'Sistemas Operativos',NULL,'2008',1),(16,'Sistemas de Representación',NULL,'2008',1),(17,'Probabilidad y Estadística',NULL,'2008',1),(18,'Diseño de Sistemas',NULL,'2008',1),(19,'Comunicaciones',NULL,'2008',1),(20,'Matemática Superior',NULL,'2008',1),(21,'Gestión de Datos',NULL,'2008',1),(22,'Ingeniería y Sociedad',NULL,'2008',1),(23,'Economía',NULL,'2008',1),(24,'Inglés Técnico 2',NULL,'2008',1),(25,'Redes de Información',NULL,'2008',1),(26,'Administración de Recursos',NULL,'2008',1),(27,'Investigación Operativa',NULL,'2008',1),(28,'Simulación',NULL,'2008',1),(29,'Ingeniería del Software',NULL,'2008',1),(30,'Teoría de Control',NULL,'2008',1),(31,'Legislación',NULL,'2008',1),(32,'Proyecto Final',NULL,'2008',1),(33,'Inteligencia Artificial',NULL,'2008',1),(34,'Administración Gerencial',NULL,'2008',1),(35,'Sistemas de Gestión',NULL,'2008',1),(36,'Int. a la Práctica Profesional',NULL,'2008',1),(37,'Algoritmos Genéticos',NULL,'2008',1),(38,'Lenguaje COBOL',NULL,'2008',1),(39,'Lenguaje Programación JAVA',NULL,'2008',1),(40,'Gestión Ingenieril',NULL,'2008',1),(41,'Tecnología de Desarrollo de Software IDE (.NET)',NULL,'2008',1),(42,'Infraestructura Tecnológica',NULL,'2008',1),(43,'Formación de Emprendedores',NULL,'2008',1),(44,'Entornos Gráficos',NULL,'2008',1),(45,'Soporte a la Gestión de Datos con Programación Visual',NULL,'2008',1),(46,'Dirección de Recursos Humanos',NULL,'2008',1),(47,'Informática en la Administración Pública',NULL,'2008',1),(48,'Metodología de la Investigación',NULL,'2008',1),(49,'Sistemas de Inf. Integrados para la Industria',NULL,'2008',1),(50,'Minería de Datos',NULL,'2008',1);
/*!40000 ALTER TABLE `materia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mesa`
--

DROP TABLE IF EXISTS `mesa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mesa` (
  `idMateria` int unsigned NOT NULL,
  `fechaHora` datetime NOT NULL,
  `llamado` int NOT NULL,
  PRIMARY KEY (`idMateria`,`fechaHora`),
  CONSTRAINT `FK_mesa_materia` FOREIGN KEY (`idMateria`) REFERENCES `materia` (`idMateria`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mesa`
--

LOCK TABLES `mesa` WRITE;
/*!40000 ALTER TABLE `mesa` DISABLE KEYS */;
INSERT INTO `mesa` VALUES (1,'2022-10-15 14:00:00',5);
/*!40000 ALTER TABLE `mesa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prof_mat_com`
--

DROP TABLE IF EXISTS `prof_mat_com`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prof_mat_com` (
  `legajo` int unsigned NOT NULL,
  `idMateria` int unsigned NOT NULL,
  `codigoComision` varchar(45) NOT NULL,
  `horarioCursado` datetime DEFAULT NULL,
  PRIMARY KEY (`legajo`,`idMateria`,`codigoComision`),
  KEY `FK_idMateria_idx` (`idMateria`),
  KEY `FK_PMC_comision_idx` (`codigoComision`),
  CONSTRAINT `FK_PMC_comision` FOREIGN KEY (`codigoComision`) REFERENCES `comision` (`codigoComision`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `FK_PMC_materia` FOREIGN KEY (`idMateria`) REFERENCES `materia` (`idMateria`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `FK_PMC_usuario` FOREIGN KEY (`legajo`) REFERENCES `usuario` (`legajo`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prof_mat_com`
--

LOCK TABLES `prof_mat_com` WRITE;
/*!40000 ALTER TABLE `prof_mat_com` DISABLE KEYS */;
INSERT INTO `prof_mat_com` VALUES (10000,1,'101','2016-00-00 00:00:00');
/*!40000 ALTER TABLE `prof_mat_com` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `legajo` int unsigned NOT NULL,
  `contraseña` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `dni` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `sueldo` double unsigned DEFAULT NULL,
  `idCarrera` int unsigned NOT NULL,
  PRIMARY KEY (`legajo`),
  UNIQUE KEY `legajo_UNIQUE` (`legajo`),
  KEY `FK_idCarrera_idx` (`idCarrera`),
  CONSTRAINT `FK_usuario_carrera` FOREIGN KEY (`idCarrera`) REFERENCES `carrera` (`idCarrera`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (10000,'profesorx','Charles','Xavier','78198278','carlitos@xmen.com',300,1),(20000,'contraseña','Adrian','Mecca','28918939','adrianmecca@gmail.com',250,1),(47064,'gonza123','Gonzalo','Serra','43235374','tonchiserra@gmail.com',NULL,1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-13 19:11:28