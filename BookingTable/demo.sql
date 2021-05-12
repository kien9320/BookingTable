-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: app
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `baby`
--

DROP TABLE IF EXISTS `baby`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `baby` (
  `id` int NOT NULL,
  `sl` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `baby`
--

LOCK TABLES `baby` WRITE;
/*!40000 ALTER TABLE `baby` DISABLE KEYS */;
INSERT INTO `baby` VALUES (1,0),(2,1),(3,2),(4,3),(5,4),(6,5),(7,6),(8,7),(9,8),(10,9),(11,10),(12,11),(13,12),(14,13),(15,14),(16,15),(17,16),(18,17),(19,18),(20,19),(21,20);
/*!40000 ALTER TABLE `baby` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `branch`
--

DROP TABLE IF EXISTS `branch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `branch` (
  `id` int NOT NULL,
  `name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `branch`
--

LOCK TABLES `branch` WRITE;
/*!40000 ALTER TABLE `branch` DISABLE KEYS */;
INSERT INTO `branch` VALUES (1,'TÔ NGỌC VÂN'),(2,'THẢO ĐIỀN'),(3,'ĐIỆN BIÊN PHỦ'),(4,'NGUYỄN ĐÌNH CHIỂU'),(5,'SAIGON PEARL'),(6,'TÔN ĐỨC THẮNG'),(7,'GIGAMALL'),(8,'NGUYỄN OANH'),(9,'TRẦN QUỐC THẢO'),(11,'HOÀNG HOA THÁM');
/*!40000 ALTER TABLE `branch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pax`
--

DROP TABLE IF EXISTS `pax`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pax` (
  `id` int NOT NULL,
  `sl` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pax`
--

LOCK TABLES `pax` WRITE;
/*!40000 ALTER TABLE `pax` DISABLE KEYS */;
INSERT INTO `pax` VALUES (1,1),(2,2),(3,3),(4,4),(5,5),(6,6),(7,7),(8,8),(9,9),(10,10),(11,11),(12,12),(13,13),(14,14),(15,15),(16,16),(17,17),(18,18),(19,19),(20,20);
/*!40000 ALTER TABLE `pax` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservation` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `customer_name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `customer_phone` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `note` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `customer_email` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `time` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `pax` int NOT NULL,
  `branch_name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `baby` int DEFAULT NULL,
  `senior` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation`
--

LOCK TABLES `reservation` WRITE;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
INSERT INTO `reservation` VALUES (8,'2021-05-11','Ngoc Le','0933880597','any','tgngoc12@gmail.com','11:30 AM',8,'TÔN ĐỨC THẮNG',4,4),(9,'2021-05-10','Ngoc Le','0933880597','Any','tgngoc12@gmail.com','11:30 AM',7,'GIGAMALL',2,1),(10,'2021-05-10','Ngoc Le','0933880597','Any','tgngoc12@gmail.com','11:30 AM',7,'GIGAMALL',2,1),(11,'2021-05-10','Ngoc Le','0933880597','Any','tgngoc12@gmail.com','11:30 AM',7,'GIGAMALL',2,1),(12,'2021-05-19','Ngoc Le','0933880597','Any','tgngoc12@gmail.com','12 PM',2,'GIGAMALL',1,2),(13,'2021-05-19','Ngoc Le','0933880597','Any','tgngoc12@gmail.com','2 PM',20,'TÔ NGỌC VÂN',1,1);
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `senior`
--

DROP TABLE IF EXISTS `senior`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `senior` (
  `id` int NOT NULL,
  `sl` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `senior`
--

LOCK TABLES `senior` WRITE;
/*!40000 ALTER TABLE `senior` DISABLE KEYS */;
INSERT INTO `senior` VALUES (1,0),(2,1),(3,2),(4,3),(5,4),(6,5),(7,6),(8,7),(9,8),(10,9),(11,10),(12,11),(13,12),(14,13),(15,14),(16,15),(17,16),(18,17),(19,18),(20,19),(21,20);
/*!40000 ALTER TABLE `senior` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `time`
--

DROP TABLE IF EXISTS `time`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `time` (
  `id` int NOT NULL,
  `gio` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `time`
--

LOCK TABLES `time` WRITE;
/*!40000 ALTER TABLE `time` DISABLE KEYS */;
INSERT INTO `time` VALUES (1,'10 AM'),(2,'10:30 AM'),(3,'11 AM'),(4,'11:30 AM'),(5,'12 PM'),(6,'12:30 PM'),(7,'1 PM'),(8,'1:30 PM'),(9,'2 PM'),(10,'2:30 PM'),(11,'3 PM'),(12,'3:30 PM'),(13,'4 PM'),(14,'4:30 PM'),(15,'5 PM'),(16,'5:30 PM'),(17,'6 PM'),(18,'6:30 PM'),(19,'7 PM'),(20,'7:30 PM'),(21,'8 PM'),(22,'8:30 PM'),(23,'9 PM'),(24,'9:30 PM'),(25,'10 PM');
/*!40000 ALTER TABLE `time` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-12 23:25:17
