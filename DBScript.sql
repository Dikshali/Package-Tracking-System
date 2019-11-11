-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: himanshu
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `center_list`
--

DROP TABLE IF EXISTS `center_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `center_list` (
  `center_id` int(11) NOT NULL AUTO_INCREMENT,
  `center name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`center_id`),
  UNIQUE KEY `center_id_UNIQUE` (`center_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `center_list`
--

LOCK TABLES `center_list` WRITE;
/*!40000 ALTER TABLE `center_list` DISABLE KEYS */;
INSERT INTO `center_list` VALUES (1,'Northborough, MA'),(2,'Edison, NJ'),(3,'Pittsburgh, PA'),(4,'Allentown, PABD Strap Endlinksth'),(5,'Martinsburg, WV'),(6,'Charlotte, NC'),(7,'Atlanta, GA'),(8,'Orlando, FL'),(9,'Memphis, TN'),(10,'Grove City, OH'),(11,'Indianapolis, IN'),(12,'Detroit, MI'),(13,'New Berlin, WI'),(14,'Minneapolis, MN'),(15,'St. Louis, MO'),(16,'Kansas, KS'),(17,'Dallas, TX'),(18,'Houston, TX'),(19,'Denver, CO'),(20,'Salt Lake City, UT'),(21,'Phoenix, AZ'),(22,'Los Angeles, CA'),(23,'Chino, CA'),(24,'Sacramento, CA'),(25,'Seattle, WA');
/*!40000 ALTER TABLE `center_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `package_details`
--

DROP TABLE IF EXISTS `package_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `package_details` (
  `tracking_number` int(11) NOT NULL AUTO_INCREMENT,
  `weight` varchar(100) NOT NULL,
  `signature_required` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `package_type` varchar(45) DEFAULT 'package',
  `service` varchar(200) DEFAULT 'FedEx Home Delivery',
  `quantity` varchar(45) NOT NULL,
  `senderName` varchar(100) NOT NULL,
  `receiverName` varchar(100) NOT NULL,
  `source` varchar(100) NOT NULL,
  `destination` varchar(100) NOT NULL,
  `specialServices` varchar(200) DEFAULT NULL,
  `currentDate` varchar(45) NOT NULL,
  `updateDate` varchar(45) NOT NULL,
  PRIMARY KEY (`tracking_number`),
  UNIQUE KEY `tracking_number_UNIQUE` (`tracking_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `package_details`
--

LOCK TABLES `package_details` WRITE;
/*!40000 ALTER TABLE `package_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `package_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `track_package`
--

DROP TABLE IF EXISTS `track_package`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `track_package` (
  `tracking_number` int(11) DEFAULT NULL,
  `center_name` varchar(100) DEFAULT NULL,
  `arrivalTime` varchar(100) DEFAULT NULL,
  `departureTime` varchar(100) DEFAULT NULL,
  KEY `tracking_number` (`tracking_number`),
  CONSTRAINT `tracking_number` FOREIGN KEY (`tracking_number`) REFERENCES `package_details` (`tracking_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `track_package`
--

LOCK TABLES `track_package` WRITE;
/*!40000 ALTER TABLE `track_package` DISABLE KEYS */;
/*!40000 ALTER TABLE `track_package` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-28 17:05:21
