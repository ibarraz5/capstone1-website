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
-- Table structure for table `cmac_area_description`
--

DROP TABLE IF EXISTS `cmac_area_description`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cmac_area_description` (
  `CMACMessageNumber` varchar(16) NOT NULL,
  `AreaName` varchar(30) NOT NULL,
  `CMASGeocode` int NOT NULL,
  KEY `CMACMessageNumber` (`CMACMessageNumber`),
  CONSTRAINT `cmac_area_description_ibfk_1` FOREIGN KEY (`CMACMessageNumber`) REFERENCES `cmac_message` (`CMACMessageNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cmac_area_description`
--

LOCK TABLES `cmac_area_description` WRITE;
/*!40000 ALTER TABLE `cmac_area_description` DISABLE KEYS */;
INSERT INTO `cmac_area_description` VALUES ('00001056','Fisher',48151),('00001056','Jones',48253),('00001056','Taylor',48441),('00001056','Callahan',48059),('00001057','Fisher',48151),('00001057','Jones',48253),('00001057','Taylor',48441),('00001057','Callahan',48059),('00001058','Fisher',48151),('00001058','Jones',48253),('00001058','Taylor',48441),('00001058','Callahan',48059),('00001059','Fisher',48151),('00001059','Jones',48253),('00001059','Taylor',48441),('00001059','Callahan',48059),('0000105A','Fisher',48151),('0000105A','Jones',48253),('0000105A','Taylor',48441),('0000105A','Callahan',48059),('0000105B','Fisher',48151),('0000105B','Jones',48253),('0000105B','Taylor',48441),('0000105B','Callahan',48059),('0000105C','Fisher',48151),('0000105C','Jones',48253),('0000105C','Taylor',48441),('0000105C','Callahan',48059),('0000105D','Fisher',48151),('0000105D','Jones',48253),('0000105D','Taylor',48441),('0000105D','Callahan',48059),('0000105E','Fisher',48151),('0000105E','Jones',48253),('0000105E','Taylor',48441),('0000105E','Callahan',48059),('0000105F','Fisher',48151),('0000105F','Jones',48253),('0000105F','Taylor',48441),('0000105F','Callahan',48059),('00001060','Fisher',48151),('00001060','Jones',48253),('00001060','Taylor',48441),('00001060','Callahan',48059);
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
  KEY `CMACMessageNumber` (`CMACMessageNumber`),
  CONSTRAINT `cmac_circle_coordinates_ibfk_1` FOREIGN KEY (`CMACMessageNumber`) REFERENCES `cmac_message` (`CMACMessageNumber`)
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
  `CMACSenderName` varchar(180) NOT NULL,
  `CMACExpiresDateTime` datetime NOT NULL,
  PRIMARY KEY (`CMACMessageNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cmac_message`
--

LOCK TABLES `cmac_message` WRITE;
/*!40000 ALTER TABLE `cmac_message` DISABLE KEYS */;
INSERT INTO `cmac_message` VALUES ('00001056','NOAA-NWS-ALERTS Texas 2017-06-01:32:50Z','w-nws.webmaster@noaa.gov','2017-06-03 01:32:50','Alert','NWS San Angelo TX','2017-06-03 02:30:00'),('00001057','NOAA-NWS-ALERTS Texas 2017-06-01:32:50Z','w-nws.webmaster@noaa.gov','2017-06-03 01:32:50','Alert','NWS San Angelo TX','2017-06-03 02:30:00'),('00001058','NOAA-NWS-ALERTS Texas 2017-06-01:32:50Z','w-nws.webmaster@noaa.gov','2017-06-03 01:32:50','Alert','NWS San Angelo TX','2017-06-03 02:30:00'),('00001059','NOAA-NWS-ALERTS Texas 2017-06-01:32:50Z','w-nws.webmaster@noaa.gov','2017-06-03 01:32:50','Alert','NWS San Angelo TX','2017-06-03 02:30:00'),('0000105A','NOAA-NWS-ALERTS Texas 2022-11-02:04:24Z','w-nws.webmaster@noaa.gov','2022-11-11 02:04:24','Alert','NWS San Angelo TX','2022-11-11 04:00:00'),('0000105B','NOAA-NWS-ALERTS Texas 2022-11-08:29:59Z','w-nws.webmaster@noaa.gov','2022-11-12 08:29:59','Alert','NWS San Angelo TX','2022-11-12 12:00:00'),('0000105C','NOAA-NWS-ALERTS Texas 2022-11-11:48:01Z','w-nws.webmaster@noaa.gov','2022-11-13 11:48:01','Alert','NWS San Angelo TX','2022-11-13 16:30:00'),('0000105D','NOAA-NWS-ALERTS Texas 2022-11-17:18:31Z','w-nws.webmaster@noaa.gov','2022-11-12 17:18:31','Alert','NWS San Angelo TX','2022-11-13 17:18:31'),('0000105E','NOAA-NWS-ALERTS Texas 2022-11-17:18:31Z','w-nws.webmaster@noaa.gov','2022-11-13 17:18:31','Alert','NWS San Angelo TX','2022-11-13 18:18:31'),('0000105F','NOAA-NWS-ALERTS Texas 2022-10-17:18:31Z','w-nws.webmaster@noaa.gov','2022-10-13 17:18:31','Alert','NWS San Angelo TX','2022-10-13 18:18:31'),('00001060','NOAA-NWS-ALERTS Texas 2022-10-17:18:31Z','w-nws.webmaster@noaa.gov','2022-10-13 17:18:31','Alert','NWS San Angelo TX','2022-10-13 18:18:31');
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
  KEY `CMACMessageNumber` (`CMACMessageNumber`),
  CONSTRAINT `cmac_polygon_coordinates_ibfk_1` FOREIGN KEY (`CMACMessageNumber`) REFERENCES `cmac_message` (`CMACMessageNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cmac_polygon_coordinates`
--

LOCK TABLES `cmac_polygon_coordinates` WRITE;
/*!40000 ALTER TABLE `cmac_polygon_coordinates` DISABLE KEYS */;
INSERT INTO `cmac_polygon_coordinates` VALUES ('00001056',32.21,-99.62),('00001056',32.27,-100.15),('00001056',32.52,-100.15),('00001056',32.52,-100.16),('00001056',32.72,-100.17),('00001056',32.85,-99.61),('00001056',32.21,-99.62),('00001057',32.21,-99.62),('00001057',32.27,-100.15),('00001057',32.52,-100.15),('00001057',32.52,-100.16),('00001057',32.72,-100.17),('00001057',32.85,-99.61),('00001057',32.21,-99.62),('00001058',32.21,-99.62),('00001058',32.27,-100.15),('00001058',32.52,-100.15),('00001058',32.52,-100.16),('00001058',32.72,-100.17),('00001058',32.85,-99.61),('00001058',32.21,-99.62),('00001059',32.21,-99.62),('00001059',32.27,-100.15),('00001059',32.52,-100.15),('00001059',32.52,-100.16),('00001059',32.72,-100.17),('00001059',32.85,-99.61),('00001059',32.21,-99.62),('0000105A',32.21,-99.62),('0000105A',32.27,-100.15),('0000105A',32.52,-100.15),('0000105A',32.52,-100.16),('0000105A',32.72,-100.17),('0000105A',32.85,-99.61),('0000105A',32.21,-99.62),('0000105B',32.21,-99.62),('0000105B',32.27,-100.15),('0000105B',32.52,-100.15),('0000105B',32.52,-100.16),('0000105B',32.72,-100.17),('0000105B',32.85,-99.61),('0000105B',32.21,-99.62),('0000105C',32.21,-99.62),('0000105C',32.27,-100.15),('0000105C',32.52,-100.15),('0000105C',32.52,-100.16),('0000105C',32.72,-100.17),('0000105C',32.85,-99.61),('0000105C',32.21,-99.62),('0000105D',32.21,-99.62),('0000105D',32.27,-100.15),('0000105D',32.52,-100.15),('0000105D',32.52,-100.16),('0000105D',32.72,-100.17),('0000105D',32.85,-99.61),('0000105D',32.21,-99.62),('0000105E',32.21,-99.62),('0000105E',32.27,-100.15),('0000105E',32.52,-100.15),('0000105E',32.52,-100.16),('0000105E',32.72,-100.17),('0000105E',32.85,-99.61),('0000105E',32.21,-99.62),('0000105F',32.21,-99.62),('0000105F',32.27,-100.15),('0000105F',32.52,-100.15),('0000105F',32.52,-100.16),('0000105F',32.72,-100.17),('0000105F',32.85,-99.61),('0000105F',32.21,-99.62),('00001060',32.21,-99.62),('00001060',32.27,-100.15),('00001060',32.52,-100.15),('00001060',32.52,-100.16),('00001060',32.72,-100.17),('00001060',32.85,-99.61),('00001060',32.21,-99.62);
/*!40000 ALTER TABLE `cmac_polygon_coordinates` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `device_upload_data`
--

DROP TABLE IF EXISTS `device_upload_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `device_upload_data` (
  `CMACMessageNumber` varchar(16) NOT NULL,
  `UploadID` int NOT NULL AUTO_INCREMENT,
  `DeviceOS` varchar(180) DEFAULT NULL,
  `DeviceOSVersion` varchar(180) DEFAULT NULL,
  `DeviceModel` varchar(180) DEFAULT NULL,
  `LocationReceived` int DEFAULT NULL,
  `LocationDisplayed` int DEFAULT NULL,
  `TimeReceived` datetime DEFAULT NULL,
  `TimeDisplayed` datetime DEFAULT NULL,
  `ReceivedOutsideArea` bit(1) DEFAULT b'0',
  `DisplayedOutsideArea` bit(1) DEFAULT b'0',
  `ReceivedAfterExpired` bit(1) DEFAULT b'0',
  `DisplayedAfterExpired` bit(1) DEFAULT b'0',
  PRIMARY KEY (`UploadID`),
  KEY `CMACMessageNumber` (`CMACMessageNumber`),
  CONSTRAINT `device_upload_data_ibfk_1` FOREIGN KEY (`CMACMessageNumber`) REFERENCES `cmac_message` (`CMACMessageNumber`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `device_upload_data`
--

LOCK TABLES `device_upload_data` WRITE;
/*!40000 ALTER TABLE `device_upload_data` DISABLE KEYS */;
INSERT INTO `device_upload_data` VALUES ('00001056',1,NULL,NULL,NULL,48151,48151,'2017-06-03 01:41:47','2017-06-03 01:42:14',_binary '\0',_binary '\0',_binary '\0',_binary '\0'),('00001056',2,NULL,NULL,NULL,48151,48152,'2017-06-03 01:37:50','2017-06-03 01:38:21',_binary '\0',_binary '',_binary '\0',_binary '\0'),('00001057',3,NULL,NULL,NULL,48441,48441,'2017-06-03 01:33:50','2017-06-03 01:36:01',_binary '\0',_binary '\0',_binary '\0',_binary '\0'),('00001057',4,NULL,NULL,NULL,48253,48253,'2017-06-03 02:01:12','2017-06-03 02:01:59',_binary '\0',_binary '\0',_binary '\0',_binary '\0'),('00001057',5,NULL,NULL,NULL,48254,48253,'2017-06-03 02:00:32','2017-06-03 02:03:59',_binary '',_binary '\0',_binary '\0',_binary '\0'),('00001058',6,NULL,NULL,NULL,48441,48441,'2017-06-03 01:36:24','2017-06-03 01:38:01',_binary '\0',_binary '\0',_binary '\0',_binary '\0'),('00001058',7,NULL,NULL,NULL,48059,48441,'2017-06-03 01:34:10','2017-06-03 01:34:12',_binary '\0',_binary '\0',_binary '\0',_binary '\0'),('00001058',8,NULL,NULL,NULL,48059,48059,'2017-06-03 02:01:01','2017-06-03 02:01:59',_binary '\0',_binary '\0',_binary '\0',_binary '\0'),('00001058',9,NULL,NULL,NULL,48060,48060,'2017-06-03 01:45:16','2017-06-03 01:47:09',_binary '',_binary '',_binary '\0',_binary '\0'),('00001059',10,NULL,NULL,NULL,48151,48441,'2017-06-03 01:33:01','2017-06-03 01:33:14',_binary '\0',_binary '\0',_binary '\0',_binary '\0'),('00001059',11,NULL,NULL,NULL,48441,48151,'2017-06-03 01:33:18','2017-06-03 01:33:22',_binary '\0',_binary '\0',_binary '\0',_binary '\0'),('00001059',12,NULL,NULL,NULL,48253,48253,'2017-06-03 01:33:29','2017-06-03 01:33:36',_binary '\0',_binary '\0',_binary '\0',_binary '\0');
/*!40000 ALTER TABLE `device_upload_data` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-13 14:20:22
