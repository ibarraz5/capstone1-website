CREATE DATABASE  IF NOT EXISTS `alert_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `alert_db`;
-- MySQL dump 10.13  Distrib 8.0.31, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: alert_db
-- ------------------------------------------------------
-- Server version	8.0.31-0ubuntu0.22.04.1

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
-- Table structure for table `cmac_alert`
--

DROP TABLE IF EXISTS `cmac_alert`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cmac_alert` (
  `CMACSenderName` varchar(180) NOT NULL,
  `CMACExpiresDateTime` datetime NOT NULL,
  `CMACMessageNumber` varchar(16) NOT NULL,
  `CMACCapIdentifier` varchar(180) NOT NULL,
  KEY `FK_CMACMessageNumber1` (`CMACMessageNumber`),
  CONSTRAINT `FK_CMACMessageNumber1` FOREIGN KEY (`CMACMessageNumber`) REFERENCES `cmac_message` (`CMACMessageNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cmac_alert`
--

LOCK TABLES `cmac_alert` WRITE;
/*!40000 ALTER TABLE `cmac_alert` DISABLE KEYS */;
INSERT INTO `cmac_alert` VALUES ('NWS San Angelo TX','2022-10-19 21:48:38','00001056','NOAA-NWS-ALERTS Texas 2017-06-01:32:50Z'),('NWS San Angelo TX','2022-10-19 21:48:38','00001056','NOAA-NWS-ALERTS Texas 2017-06-01:32:50Z'),('NWS San Angelo TX','2022-10-19 21:48:38','00001057','NOAA-NWS-ALERTS Texas 2017-06-01:32:50Z'),('NWS San Angelo TX','2022-10-19 21:48:38','00001058','NOAA-NWS-ALERTS Texas 2017-06-01:32:50Z'),('NWS San Angelo TX','2022-10-19 21:48:38','00001059','NOAA-NWS-ALERTS Texas 2017-06-01:32:50Z');
/*!40000 ALTER TABLE `cmac_alert` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cmac_area_description`
--

DROP TABLE IF EXISTS `cmac_area_description`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cmac_area_description` (
  `CMACMessageNumber` varchar(16) NOT NULL,
  `AreaName` varchar(30) NOT NULL,
  `CMASGeocode` int NOT NULL,
  KEY `FK_CMACMessageNumber5` (`CMACMessageNumber`),
  CONSTRAINT `FK_CMACMessageNumber5` FOREIGN KEY (`CMACMessageNumber`) REFERENCES `cmac_message` (`CMACMessageNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cmac_area_description`
--

LOCK TABLES `cmac_area_description` WRITE;
/*!40000 ALTER TABLE `cmac_area_description` DISABLE KEYS */;
INSERT INTO `cmac_area_description` VALUES ('00001056','Fisher',48151),('00001056','Jones',48253),('00001056','Taylor',48441),('00001056','Callahan',48059);
/*!40000 ALTER TABLE `cmac_area_description` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cmac_circle_coordinates`
--

DROP TABLE IF EXISTS `cmac_circle_coordinates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cmac_circle_coordinates` (
  `CMACMessageNumber` varchar(16) NOT NULL,
  `Latitude` decimal(5,2) NOT NULL,
  `Longitude` decimal(5,2) NOT NULL,
  KEY `FK_CMACMessageNumber4` (`CMACMessageNumber`),
  CONSTRAINT `FK_CMACMessageNumber4` FOREIGN KEY (`CMACMessageNumber`) REFERENCES `cmac_message` (`CMACMessageNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cmac_circle_coordinates`
--

LOCK TABLES `cmac_circle_coordinates` WRITE;
/*!40000 ALTER TABLE `cmac_circle_coordinates` DISABLE KEYS */;
/*!40000 ALTER TABLE `cmac_circle_coordinates` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cmac_message`
--

DROP TABLE IF EXISTS `cmac_message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cmac_message` (
  `CMACMessageNumber` varchar(16) NOT NULL,
  `CMACCapIdentifier` varchar(180) NOT NULL,
  `CMACSender` varchar(180) NOT NULL,
  `CMACDateTime` datetime NOT NULL,
  `CMACMessageType` varchar(165) NOT NULL,
  PRIMARY KEY (`CMACMessageNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cmac_message`
--

LOCK TABLES `cmac_message` WRITE;
/*!40000 ALTER TABLE `cmac_message` DISABLE KEYS */;
INSERT INTO `cmac_message` VALUES ('00001056','NOAA-NWS-ALERTS Texas 2017-06-01:32:50Z','w-nws.webmaster@noaa.gov','2017-06-03 01:32:50','Alert'),('00001057','NOAA-NWS-ALERTS Texas 2017-06-01:32:50Z','w-nws.webmaster@noaa.gov','2017-06-03 01:32:50','Alert'),('00001058','NOAA-NWS-ALERTS Texas 2017-06-01:32:50Z','w-nws.webmaster@noaa.gov','2017-06-03 01:32:50','Alert'),('00001059','NOAA-NWS-ALERTS Texas 2017-06-01:32:50Z','w-nws.webmaster@noaa.gov','2017-06-03 01:32:50','Alert');
/*!40000 ALTER TABLE `cmac_message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cmac_polygon_coordinates`
--

DROP TABLE IF EXISTS `cmac_polygon_coordinates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cmac_polygon_coordinates` (
  `CMACMessageNumber` varchar(16) NOT NULL,
  `Latitude` decimal(5,2) NOT NULL,
  `Longitude` decimal(5,2) NOT NULL,
  KEY `FK_CMACMessageNumber3` (`CMACMessageNumber`),
  CONSTRAINT `FK_CMACMessageNumber3` FOREIGN KEY (`CMACMessageNumber`) REFERENCES `cmac_message` (`CMACMessageNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cmac_polygon_coordinates`
--

LOCK TABLES `cmac_polygon_coordinates` WRITE;
/*!40000 ALTER TABLE `cmac_polygon_coordinates` DISABLE KEYS */;
INSERT INTO `cmac_polygon_coordinates` VALUES ('00001056',32.21,-99.62),('00001056',32.27,-100.15),('00001056',32.52,-100.15),('00001056',32.52,-100.16),('00001056',32.72,-100.17),('00001056',32.85,-99.61),('00001056',32.21,-99.62);
/*!40000 ALTER TABLE `cmac_polygon_coordinates` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `device`
--

DROP TABLE IF EXISTS `device`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `device` (
  `CMACMessageNumber` varchar(16) NOT NULL,
  `InternalDeviceID` int NOT NULL AUTO_INCREMENT,
  `DeviceOS` varchar(180) DEFAULT NULL,
  `DeviceOSVersion` varchar(180) DEFAULT NULL,
  `DeviceModel` varchar(180) DEFAULT NULL,
  `LocationReceived` int DEFAULT NULL,
  `LocationDisplayed` int DEFAULT NULL,
  `TimeReceived` datetime DEFAULT NULL,
  `TimeDisplayed` datetime DEFAULT NULL,
  PRIMARY KEY (`InternalDeviceID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `device`
--

LOCK TABLES `device` WRITE;
/*!40000 ALTER TABLE `device` DISABLE KEYS */;
INSERT INTO `device` VALUES ('00001056',1,NULL,NULL,NULL,48151,48151,'2017-06-03 05:37:50','2017-06-03 05:38:01'),('00001056',2,NULL,NULL,NULL,48151,48152,'2017-06-03 05:37:50','2017-06-03 05:38:50');
/*!40000 ALTER TABLE `device` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-29 12:56:37
