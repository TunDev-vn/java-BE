CREATE DATABASE  IF NOT EXISTS `insuranceclaim` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `insuranceclaim`;
-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: insuranceclaim
-- ------------------------------------------------------
-- Server version	8.4.0

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
-- Table structure for table `claim`
--

DROP TABLE IF EXISTS `claim`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `claim` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `amount` double NOT NULL,
  `claim_date` date DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `status_id` bigint DEFAULT NULL,
  `product_id` bigint DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `customer_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfkypqix42u6j9uj5a1kq2428n` (`status_id`),
  KEY `FK6k25jaynajdvvcmst08cphrwl` (`product_id`),
  KEY `FKlmon26is6b9p2wipdl88yn68y` (`customer_id`),
  CONSTRAINT `FK6k25jaynajdvvcmst08cphrwl` FOREIGN KEY (`product_id`) REFERENCES `insurance_product` (`id`),
  CONSTRAINT `FKfkypqix42u6j9uj5a1kq2428n` FOREIGN KEY (`status_id`) REFERENCES `claim_status` (`id`),
  CONSTRAINT `FKlmon26is6b9p2wipdl88yn68y` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `claim`
--

LOCK TABLES `claim` WRITE;
/*!40000 ALTER TABLE `claim` DISABLE KEYS */;
INSERT INTO `claim` VALUES (11,6290.2,'2024-04-28','tran.user1',_binary '\0','Yêu cầu bồi thường chi phí y tế','le.user2',7,9,'2024-07-27 23:28:43.000000','2024-07-27 23:28:43.000000','C001',7),(12,8217.87,'2023-08-12','tran.user1',_binary '\0','Yêu cầu bồi thường tai nạn xe','le.user2',9,10,'2024-07-27 23:28:43.000000','2024-07-27 23:28:43.000000','C002',8),(13,4063.26,'2024-07-04','tran.user1',_binary '\0','Yêu cầu bồi thường bảo hiểm du lịch','le.user2',12,11,'2024-07-27 23:28:43.000000','2024-07-27 23:28:43.000000','C003',9),(14,6963.71,'2024-03-30','nguyen.admin',_binary '\0','Yêu cầu bồi thường bảo hiểm du lịch','tran.user1',8,12,'2024-07-27 23:28:43.000000','2024-07-27 23:28:43.000000','C004',7),(15,1057.15,'2024-03-23','nguyen.admin',_binary '\0','Yêu cầu bồi thường bảo hiểm du lịch','nguyen.admin',8,9,'2024-07-27 23:28:43.000000','2024-07-27 23:28:43.000000','C005',8),(16,6963.71,'2024-03-30','kiennd',_binary '\0','Bảo hiểm sức khỏe','tran.user1',10,10,'2024-07-27 23:28:43.000000','2024-07-27 23:28:43.000000','C006',7),(17,1057.15,'2024-03-23','kiennd',_binary '\0','bảo hiểm y tế công','nguyen.admin',7,11,'2024-07-27 23:28:43.000000','2024-07-27 23:28:43.000000','C007',8);
/*!40000 ALTER TABLE `claim` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `claim_document`
--

DROP TABLE IF EXISTS `claim_document`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `claim_document` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `document_name` varchar(255) DEFAULT NULL,
  `document_type` varchar(255) DEFAULT NULL,
  `file_path` varchar(255) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `upload_date` date DEFAULT NULL,
  `claim_id` bigint DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK482n7wmh1ry39ewmqmailkpb8` (`claim_id`),
  CONSTRAINT `FK482n7wmh1ry39ewmqmailkpb8` FOREIGN KEY (`claim_id`) REFERENCES `claim` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `claim_document`
--

LOCK TABLES `claim_document` WRITE;
/*!40000 ALTER TABLE `claim_document` DISABLE KEYS */;
INSERT INTO `claim_document` VALUES (7,'nguyen.admin',_binary '\0','Giấy tờ liên quan bồi thường chi phí y tế','PDF','/path/to/medical_expense.pdf','nguyen.admin','2024-05-01',11,NULL,NULL),(8,'nguyen.admin',_binary '\0','Giấy tờ liên quan bồi thường tai nạn xe','Image','/path/to/car_accident.png','nguyen.admin','2023-08-15',12,NULL,NULL),(9,'nguyen.admin',_binary '\0','Giấy tờ liên quan bồi thường bảo hiểm du lịch','Image','/path/to/travel_insurance.png','nguyen.admin','2024-07-05',13,NULL,NULL);
/*!40000 ALTER TABLE `claim_document` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `claim_status`
--

DROP TABLE IF EXISTS `claim_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `claim_status` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `claim_status`
--

LOCK TABLES `claim_status` WRITE;
/*!40000 ALTER TABLE `claim_status` DISABLE KEYS */;
INSERT INTO `claim_status` VALUES (7,'admin',_binary '\0','admin','2024-07-27 23:27:02.000000','2024-07-27 23:27:02.000000','Khởi tạo','Init'),(8,'admin',_binary '\0','admin','2024-07-27 23:27:02.000000','2024-07-27 23:27:02.000000','Nhân viên đang xử lý','Process'),(9,'admin',_binary '\0','admin','2024-07-27 23:27:02.000000','2024-07-27 23:27:02.000000','Nhân viên đã xác minh','Verified'),(10,'admin',_binary '\0','admin','2024-07-27 23:27:02.000000','2024-07-27 23:27:02.000000','Thông tin chưa chính xác','Invalid'),(12,'admin',_binary '\0','admin','2024-07-27 23:27:02.000000','2024-07-27 23:27:02.000000','Chập nhận bồi thường','Approve');
/*!40000 ALTER TABLE `claim_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `bank_name` varchar(255) DEFAULT NULL,
  `bank_number` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (7,'123 Đường ABC, Quận 1, TP. HCM','Ngân hàng A','1234567890','nguyen.admin',_binary '\0','john.doe@example.com','nguyen.admin','John Doe','0123456789',NULL,NULL),(8,'456 Đường XYZ, Quận 2, TP. HCM','Ngân hàng B','0987654321','nguyen.admin',_binary '\0','jane.smith@example.com','nguyen.admin','Jane Smith','0987654321',NULL,NULL),(9,'789 Đường DEF, Quận 3, TP. HCM','Ngân hàng C','5555555555','nguyen.admin',_binary '\0','bob.johnson@example.com','nguyen.admin','Bob Johnson','0987654321',NULL,NULL);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `insurance_product`
--

DROP TABLE IF EXISTS `insurance_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `insurance_product` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `coverage` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `description` text,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `insurance_product`
--

LOCK TABLES `insurance_product` WRITE;
/*!40000 ALTER TABLE `insurance_product` DISABLE KEYS */;
INSERT INTO `insurance_product` VALUES (9,'Bảo hiểm toàn diện cho xe hơi','admin','2024-07-21 00:00:00.000000',_binary '\0','Bảo hiểm toàn diện cho xe hơi cung cấp sự bảo vệ tối ưu cho tất cả các loại rủi ro liên quan đến xe, bao gồm tai nạn, hư hỏng do thiên tai, và mất mát do trộm cắp. Đây là lựa chọn lý tưởng cho những ai muốn bảo vệ tài sản giá trị của mình.','admin','2024-07-21 00:00:00.000000','Bảo hiểm xe hơi'),(10,'Bảo hiểm sức khỏe toàn diện','admin','2024-07-21 00:00:00.000000',_binary '\0','Bảo hiểm sức khỏe toàn diện giúp bảo vệ sức khỏe của bạn khỏi các rủi ro bệnh tật, tai nạn và các chi phí y tế không lường trước. Nó bao gồm điều trị nội trú, ngoại trú, thuốc men và các dịch vụ y tế khẩn cấp, giúp bạn giảm bớt gánh nặng tài chính khi gặp phải sự cố sức khỏe.','admin','2024-07-21 00:00:00.000000','Bảo hiểm sức khỏe'),(11,'Bảo hiểm nhà toàn diện','admin','2024-07-21 00:00:00.000000',_binary '\0','Bảo hiểm nhà toàn diện bảo vệ ngôi nhà của bạn khỏi các sự cố như cháy nổ, thiên tai, trộm cắp, và thiệt hại do sự cố không mong muốn. Đây là lựa chọn tuyệt vời để đảm bảo an toàn tài sản và gia đình bạn khỏi những tình huống không lường trước được.','admin','2024-07-21 00:00:00.000000','Bảo hiểm nhà'),(12,'Bảo hiểm du lịch toàn diện','admin','2024-07-21 00:00:00.000000',_binary '\0','Bảo hiểm du lịch toàn diện giúp bảo vệ bạn khỏi các rủi ro trong suốt hành trình du lịch, bao gồm bảo hiểm tai nạn, mất mát hành lý, huỷ chuyến bay, và các chi phí y tế khẩn cấp. Đây là lựa chọn lý tưởng cho những ai yêu thích du lịch và muốn đảm bảo sự an tâm trong mỗi chuyến đi.','admin','2024-07-21 00:00:00.000000','Bảo hiểm du lịch');
/*!40000 ALTER TABLE `insurance_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `path_avatar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'admin','2024-10-27 10:36:11.000000',_binary '\0','admin','2024-10-27 10:36:11.000000','aaaaaaaaaaaaaaaaaaaaaaaaa','Soft Leather Jacket','http://localhost:8080/file/images-product/doremon.jpg'),(2,'admin','2024-10-27 10:36:11.000000',_binary '\0','admin','2024-10-27 10:36:11.000000','aaaaaaaaaaaaaaaaaaaaaaaaa','Classic Denim Jacket','http://localhost:8080/file/images-product/doremon.jpg'),(3,'admin','2024-10-27 10:36:11.000000',_binary '\0','admin','2024-10-27 10:36:11.000000','aaaaaaaaaaaaaaaaaaaaaaaaa','Vintage Bomber Jacket','http://localhost:8080/file/images-product/doremon.jpg'),(4,'admin','2024-10-27 10:36:11.000000',_binary '\0','admin','2024-10-27 10:36:11.000000','aaaaaaaaaaaaaaaaaaaaaaaaa','Elegant Trench Coat','http://localhost:8080/file/images-product/doremon.jpg'),(5,'admin','2024-10-27 10:36:11.000000',_binary '\0','admin','2024-10-27 10:36:11.000000','aaaaaaaaaaaaaaaaaaaaaaaaa','Out Crop Sweater','http://localhost:8080/file/images-product/doremon.jpg'),(6,'admin','2024-10-27 10:36:11.000000',_binary '\0','admin','2024-10-27 10:36:11.000000','aaaaaaaaaaaaaaaaaaaaaaaaa','Chic Blazer','http://localhost:8080/file/images-product/doremon.jpg');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'admin',_binary '\0','admin','Quản trị viên','ADMIN',NULL,NULL),(2,'admin',_binary '\0','admin','Nhân viên','USER',NULL,NULL);
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_roles` (
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKrhfovtciq1l558cw6udg0h0d3` (`role_id`),
  CONSTRAINT `FKh8ciramu9cc9q3qcqiv4ue8a6` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  CONSTRAINT `FKhfh9dx7w3ubf1co1vdev94g3f` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (1,1),(3,1),(1,2),(2,2),(3,2),(4,2);
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `path_avatar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin',_binary '\0','admin','$2a$10$f6p5TLa9sDZzuTzRgnQAFewEMqU843QaSQqjjy56Fmk.UjgNkqTs2','admin','A0001','admin@fpt.com','Nguyen','Kien',NULL,NULL,'2024-09-29 17:26:51.000000','2025-03-15 14:52:27.464743','http://localhost:8080/file/avatar/avatar_admin_1.jpg'),(2,'admin',_binary '\0','user','$2a$10$YhEkhRJJLorfpWrDhV6huuwHoHuIgDNS1rkuwwHfq44EgNO7n2KCq','user','U0001','tuan@gmail.com','Le ','Tuan',NULL,NULL,NULL,'2024-10-27 16:22:16.907475','http://localhost:8080/file/avatar/avatar_user_2.jpg'),(3,'admin',_binary '\0','2024-07-27 12:25:58.000000 +00:00','$2a$10$byCzxLRFdGo9Y2qau4RXyOm/D92ZZZL1m7iiLxf0QIShwDw78Q7gy','admin2','A0002','admin@gmail.comaaaaaaaaaaaa','Nguyenaaaaaaaaaaaa','Kienaaaaaaaaaaaaaaa','0925334772aaaaaaaaaaaa','HaNoiaaaaaaaaaaaaaaa','2024-09-29 17:26:51.000000','2024-09-30 22:27:04.845038',NULL),(4,'admin',_binary '\0','2024-07-27 12:25:58.000000 +00:00','$2a$10$O4FGIqrpX.ZRhnIVE.bO8ODv66rufTP2zWRNJnLfkvRM3T2mrAtHS','user2','U0002','user@gmail.com','Nguyen','/','0925334772','HaNoi',NULL,NULL,NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'insuranceclaim'
--

--
-- Dumping routines for database 'insuranceclaim'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-03-17 21:21:48
