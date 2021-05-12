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
-- Dumping data for table `baby`
--

LOCK TABLES `baby` WRITE;
/*!40000 ALTER TABLE `baby` DISABLE KEYS */;
INSERT INTO `baby` VALUES (1,'1 NGƯỜI'),(2,'2 NGƯỜI'),(3,'3 NGƯỜI'),(4,'4 NGƯỜI '),(5,'5 NGƯỜI'),(6,'6 NGƯỜI'),(7,'7 NGƯỜI'),(8,'8 NGƯỜI'),(9,'9 NGƯỜI'),(10,'10 NGƯỜI');
/*!40000 ALTER TABLE `baby` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `branch`
--

LOCK TABLES `branch` WRITE;
/*!40000 ALTER TABLE `branch` DISABLE KEYS */;
INSERT INTO `branch` VALUES (1,'TÔ NGỌC VÂN'),(2,'THẢO ĐIỀN'),(3,'ĐIỆN BIÊN PHỦ'),(4,'NGUYỄN ĐÌNH CHIỂU'),(5,'SAIGON PEARL'),(6,'TÔN ĐỨC THẮNG'),(7,'GIGAMALL'),(8,'NGUYỄN OANH'),(9,'TRẦN QUỐC THẢO'),(11,'HOÀNG HOA THÁM');
/*!40000 ALTER TABLE `branch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `old`
--

LOCK TABLES `old` WRITE;
/*!40000 ALTER TABLE `old` DISABLE KEYS */;
INSERT INTO `old` VALUES (1,'1 NGƯỜI'),(2,'2 NGƯỜI'),(3,'3 NGƯỜI'),(4,'4 NGƯỜI'),(5,'5 NGƯỜI'),(6,'6 NGƯỜI'),(7,'7 NGƯỜI'),(8,'8 NGƯỜI'),(9,'9 NGƯỜI'),(10,'10 NGƯỜI'),(11,'11 NGƯỜI');
/*!40000 ALTER TABLE `old` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `pax`
--

LOCK TABLES `pax` WRITE;
/*!40000 ALTER TABLE `pax` DISABLE KEYS */;
INSERT INTO `pax` VALUES (1,1),(2,2),(3,3),(4,4),(5,5),(6,6),(7,7),(8,8),(9,9),(10,10),(11,11),(12,12),(13,13),(14,14),(15,15),(16,16),(17,17),(18,18),(19,19),(20,20);
/*!40000 ALTER TABLE `pax` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `reservation`
--

LOCK TABLES `reservation` WRITE;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
INSERT INTO `reservation` VALUES (1,'2021-04-30','Ngoc','0933880597',NULL,'tgngoc12@gmail.com','3 PM',5,'TÔ NGỌC VÂN',0,0),(2,'2021-04-29','NGỌC','0123987456',NULL,'ngoc12@gmail.com','10 PM',29,'ĐIỆN BIÊN PHỦ',0,0),(3,'2021-05-12','Nhiên','1235497965',NULL,'tgngoc12@gmail.com','19 PM',29,'ĐIỆN BIÊN PHỦ',0,0),(4,'2021-05-12','any l','0123456789','any','tgngoc12@gmail.com','12 PM',6,'NGUYỄN ĐÌNH CHIỂU',4,4),(5,'2021-05-12','any l','0123456789','any','tgngoc12@gmail.com','12 PM',6,'NGUYỄN ĐÌNH CHIỂU',4,4);
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;
UNLOCK TABLES;

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

-- Dump completed on 2021-05-05 16:20:00
