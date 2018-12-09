CREATE DATABASE  IF NOT EXISTS `muspro` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `muspro`;
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: muspro
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `async_operation`
--

DROP TABLE IF EXISTS `async_operation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `async_operation` (
  `id` int(11) NOT NULL,
  `external_authentication_provider_id` int(11) DEFAULT NULL,
  `async_operation_status_type_id` int(11) DEFAULT NULL,
  `user_external_login_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ext_auth_pro_id_idx` (`external_authentication_provider_id`),
  KEY `fk_async_op_status_type_id_idx` (`async_operation_status_type_id`),
  KEY `fk_user_ext_login_id_idx` (`user_external_login_id`),
  CONSTRAINT `fk_async_op_status_type_id` FOREIGN KEY (`async_operation_status_type_id`) REFERENCES `async_operation_status_type` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_ext_auth_pro_id` FOREIGN KEY (`external_authentication_provider_id`) REFERENCES `external_authentication_provider` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_user_ext_login_id` FOREIGN KEY (`user_external_login_id`) REFERENCES `user_external_login` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `async_operation`
--

LOCK TABLES `async_operation` WRITE;
/*!40000 ALTER TABLE `async_operation` DISABLE KEYS */;
/*!40000 ALTER TABLE `async_operation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `async_operation_status_type`
--

DROP TABLE IF EXISTS `async_operation_status_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `async_operation_status_type` (
  `id` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `async_operation_status_type`
--

LOCK TABLES `async_operation_status_type` WRITE;
/*!40000 ALTER TABLE `async_operation_status_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `async_operation_status_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `external_authentication_provider`
--

DROP TABLE IF EXISTS `external_authentication_provider`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `external_authentication_provider` (
  `id` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `external_authentication_provider`
--

LOCK TABLES `external_authentication_provider` WRITE;
/*!40000 ALTER TABLE `external_authentication_provider` DISABLE KEYS */;
/*!40000 ALTER TABLE `external_authentication_provider` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `link_external_item`
--

DROP TABLE IF EXISTS `link_external_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `link_external_item` (
  `id` int(11) NOT NULL,
  `user_account_id` int(11) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `is_done` tinyint(4) DEFAULT NULL,
  `creation_date` date DEFAULT NULL,
  `deadline_date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_account_id_idx` (`user_account_id`),
  KEY `fk_user_account_id_idx1` (`user_account_id`),
  CONSTRAINT `fk_user_account_id1` FOREIGN KEY (`user_account_id`) REFERENCES `user_account` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `link_external_item`
--

LOCK TABLES `link_external_item` WRITE;
/*!40000 ALTER TABLE `link_external_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `link_external_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_account`
--

DROP TABLE IF EXISTS `user_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_account` (
  `id` int(11) NOT NULL,
  `screen_user_name` varchar(45) DEFAULT NULL,
  `user_details_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_details_id_UNIQUE` (`user_details_id`),
  CONSTRAINT `fk_user_det_id` FOREIGN KEY (`user_details_id`) REFERENCES `user_details` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_account`
--

LOCK TABLES `user_account` WRITE;
/*!40000 ALTER TABLE `user_account` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_details`
--

DROP TABLE IF EXISTS `user_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_details` (
  `id` int(11) NOT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password_salt` varchar(255) DEFAULT NULL,
  `password_hash` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_details`
--

LOCK TABLES `user_details` WRITE;
/*!40000 ALTER TABLE `user_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_external_login`
--

DROP TABLE IF EXISTS `user_external_login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_external_login` (
  `id` int(11) NOT NULL,
  `user_account_id` int(11) DEFAULT NULL,
  `external_authentication_provider_id` int(11) DEFAULT NULL,
  `external_user_id` varchar(255) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `login_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_account_id_idx` (`user_account_id`),
  KEY `fk_external_authentication_provider_id_idx` (`external_authentication_provider_id`),
  CONSTRAINT `fk_external_authentication_provider_id` FOREIGN KEY (`external_authentication_provider_id`) REFERENCES `external_authentication_provider` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_user_account_id` FOREIGN KEY (`user_account_id`) REFERENCES `user_account` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_external_login`
--

LOCK TABLES `user_external_login` WRITE;
/*!40000 ALTER TABLE `user_external_login` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_external_login` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-09 15:05:40
