-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: monaca
-- ------------------------------------------------------
-- Server version	8.2.0

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
-- Table structure for table `candy_point`
--

DROP TABLE IF EXISTS `candy_point`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `candy_point` (
  `attendance_id` bigint NOT NULL,
  `candy_id` bigint NOT NULL,
  `candy_point_time_stamp` datetime(6) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `use_history` int NOT NULL,
  `attendance_attendance_id` bigint DEFAULT NULL,
  `candy_candy_id` bigint DEFAULT NULL,
  `examination_examination_id` bigint DEFAULT NULL,
  `item_shop_item_shop_id` bigint DEFAULT NULL,
  PRIMARY KEY (`attendance_id`,`candy_id`),
  KEY `FKmbxhbk1uw2cldfwqoqmdlp0by` (`candy_id`),
  KEY `FKtbf3mwydy8e25yv1j41knbd4h` (`attendance_attendance_id`),
  KEY `FK3mbot9l9we6vo80i1uvl0vffh` (`candy_candy_id`),
  KEY `FK65waqpbp8b5uxk8ol8ps7anxl` (`examination_examination_id`),
  KEY `FK4gk0y36aln811mee1w9ll9xjc` (`item_shop_item_shop_id`),
  CONSTRAINT `FK3mbot9l9we6vo80i1uvl0vffh` FOREIGN KEY (`candy_candy_id`) REFERENCES `candy` (`candy_id`),
  CONSTRAINT `FK4gk0y36aln811mee1w9ll9xjc` FOREIGN KEY (`item_shop_item_shop_id`) REFERENCES `item_shop` (`item_shop_id`),
  CONSTRAINT `FK65waqpbp8b5uxk8ol8ps7anxl` FOREIGN KEY (`examination_examination_id`) REFERENCES `examination` (`examination_id`),
  CONSTRAINT `FKgt5hcv41mosl5gv1jlmkuhwtu` FOREIGN KEY (`attendance_id`) REFERENCES `attendance` (`attendance_id`),
  CONSTRAINT `FKmbxhbk1uw2cldfwqoqmdlp0by` FOREIGN KEY (`candy_id`) REFERENCES `candy` (`candy_id`),
  CONSTRAINT `FKtbf3mwydy8e25yv1j41knbd4h` FOREIGN KEY (`attendance_attendance_id`) REFERENCES `attendance` (`attendance_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `candy_point`
--

LOCK TABLES `candy_point` WRITE;
/*!40000 ALTER TABLE `candy_point` DISABLE KEYS */;
/*!40000 ALTER TABLE `candy_point` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-09 14:25:11
