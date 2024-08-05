-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: travelmanagementsystem
-- ------------------------------------------------------
-- Server version	8.0.34

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

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `username` varchar(20) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `question` varchar(500) DEFAULT NULL,
  `answer` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bookhotel`
--

DROP TABLE IF EXISTS `bookhotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bookhotel` (
  `username` varchar(20) DEFAULT NULL,
  `hotel` varchar(30) DEFAULT NULL,
  `persons` varchar(20) DEFAULT NULL,
  `days` varchar(10) DEFAULT NULL,
  `acfacility` varchar(10) DEFAULT NULL,
  `food` varchar(10) DEFAULT NULL,
  `id` varchar(20) DEFAULT NULL,
  `idnumber` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `totalprice` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookhotel`
--

LOCK TABLES `bookhotel` WRITE;
/*!40000 ALTER TABLE `bookhotel` DISABLE KEYS */;
/*!40000 ALTER TABLE `bookhotel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bookpackage`
--

DROP TABLE IF EXISTS `bookpackage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bookpackage` (
  `username` varchar(30) DEFAULT NULL,
  `package` varchar(20) DEFAULT NULL,
  `persons` varchar(10) DEFAULT NULL,
  `id` varchar(20) DEFAULT NULL,
  `idnumber` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `price` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookpackage`
--

LOCK TABLES `bookpackage` WRITE;
/*!40000 ALTER TABLE `bookpackage` DISABLE KEYS */;
/*!40000 ALTER TABLE `bookpackage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `username` varchar(30) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `id` varchar(30) DEFAULT NULL,
  `idnumber` varchar(30) DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `country` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotel`
--

DROP TABLE IF EXISTS `hotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hotel` (
  `name` varchar(30) DEFAULT NULL,
  `costperperson` varchar(20) DEFAULT NULL,
  `acroom` varchar(10) DEFAULT NULL,
  `foodincluded` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel`
--

LOCK TABLES `hotel` WRITE;
/*!40000 ALTER TABLE `hotel` DISABLE KEYS */;
INSERT INTO `hotel` VALUES ('Hotel Classico Inn','3400','1000','1700'),('Hotel Superioro','5400','2000','3700'),('GW Bajaj Hotel','3600','1700','4700'),('VK Shah Hotel','5400','2000','3700'),('Maximo The Hotel','3400','1000','1700'),('SK Twins Hotel','3400','1000','1700'),('Sharma Enterprises','5400','2000','3700'),('Propero Delgo Hotel','3600','1700','4700'),('Joseph Heart Hotel','5400','2000','3700'),('Merry Queens Hotel','3600','1700','4700');
/*!40000 ALTER TABLE `hotel` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-05 18:35:16
