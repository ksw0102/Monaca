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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `activated` bit(1) DEFAULT NULL,
  `birth_date` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `image` varchar(500) DEFAULT NULL,
  `login_id` varchar(15) DEFAULT NULL,
  `name` varchar(6) DEFAULT NULL,
  `nickname` varchar(50) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone_num` varchar(30) DEFAULT NULL,
  `professor_intro` varchar(50) DEFAULT NULL,
  `professor_resume` varchar(50) DEFAULT NULL,
  `lecture_category_lecture_category_id` bigint DEFAULT NULL,
  `user_item_user_item_id` bigint DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UK_6ntlp6n5ltjg6hhxl66jj5u0l` (`login_id`),
  KEY `FK904maevhw17vkle6fy9mx4kbv` (`lecture_category_lecture_category_id`),
  KEY `FKcpho6peadhfin9vawtwx6i4q7` (`user_item_user_item_id`),
  CONSTRAINT `FK904maevhw17vkle6fy9mx4kbv` FOREIGN KEY (`lecture_category_lecture_category_id`) REFERENCES `lecture_category` (`lecture_category_id`),
  CONSTRAINT `FKcpho6peadhfin9vawtwx6i4q7` FOREIGN KEY (`user_item_user_item_id`) REFERENCES `user_item` (`user_item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (2,_binary '','2001-01-02','claxn123@gmail.com','남성',NULL,'claxn123','김선욱','student','$2a$10$rTn8xVuk5fZrct6Tt1i4aOthNSkr4agVT2rcLvWnNDDFWiOd3BaDa','01012341234',NULL,NULL,NULL,NULL),(3,_binary '','2000-01-01','monaca123@gmail.com','남성',NULL,'monaca123','모나카','monaca','$2a$10$cCJhw/iEgBzfLz36ZjNWPO580TFHs70vqfD3rAXY0sHlm.5azdW4y','01000010002',NULL,NULL,NULL,NULL),(4,_binary '','1998-01-01','kimpro123@gmail.com','남성',NULL,'professor123','김교수','professor','$2a$10$6yZbs4sxPPqG.nJ1OQxGMe4hBK0GSLqlJBWA8mxN5IRGXHt6vrLqq','01045671234',NULL,NULL,NULL,NULL),(5,_binary '','2001-03-14','rladpdms123@gmail.com','여성',NULL,'rladpdms123','김학생','dpdms','$2a$10$8hjKzsC/MMmQlJaaX1KYk.zjfijifY07fpowkRzAZ9ntXFOhEBFjK','01012341234',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-10 10:00:03
