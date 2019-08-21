-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: events
-- ------------------------------------------------------
-- Server version	8.0.16

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(80) NOT NULL,
  `fullName` varchar(50) NOT NULL,
  `DoB` datetime NOT NULL,
  `phone` varchar(30) NOT NULL,
  `email` varchar(100) NOT NULL,
  `address` varchar(100) NOT NULL,
  `image` text NOT NULL,
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_edited_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'hai123','hai123','Nguyễn Vũ Hồ Hải','1999-01-01 00:00:00','0835566236','hai@gmail.com','26 nguyễn tri phương','https://scontent.fsgn2-2.fna.fbcdn.net/v/t1.0-9/54798176_2155011671261847_3959002623255773184_n.jpg?_nc_cat=100&_nc_oc=AQnDqt4-xBMrJoIv8m-bqJGWR1FgmDwrO3iDP93RvW1w68AUeQGDbjwOcUKRH7KYCa0&_nc_ht=scontent.fsgn2-2.fna&oh=e5d0d935ca3f1b40359c3b5c0c8bfe3b&oe=5DBF6F2D','2019-07-03 11:46:55','2019-07-03 11:46:55'),(2,'nhat111','nhat111','Ngô Phan Anh Nhật','1999-01-01 00:00:00','0835566236','nhat@gmail.com','26 nguyễn tri phương','https://scontent.fhan2-4.fna.fbcdn.net/v/t1.0-1/46337865_2083486041698122_6445709479852900352_n.jpg?_nc_cat=104&_nc_oc=AQmqrvaYJlzqN5jNr5dMTYhZGoHLqZ5kL3Cut9PN2H19MhVQm_WeHfTP0DpFm7TZ2BI&_nc_ht=scontent.fhan2-4.fna&oh=a3e1ff3744e61b74d56ffc20f94e6e33&oe=5DC2C1F4','2019-07-03 11:46:55','2019-07-03 11:46:55'),(3,'thanhtin','thanhtin123','Trần Thanh Tín','1999-01-01 00:00:00','0835566236','thanhtin123@gmail.com','26 nguyễn tri phương','http://www.pxleyes.com/images/contests/avatar%20wars/fullsize/avatar%20wars_4a5f5b501b376_hires.jpg','2019-07-03 11:46:55','2019-07-03 11:46:55'),(4,'achihoang','hoang123','Nguyễn Đức Thanh Hoàng','1999-01-01 00:00:00','0835566236','achihoang@gmail.com','26 nguyễn tri phương','https://scontent.fsgn2-3.fna.fbcdn.net/v/t1.0-9/36585486_2158466447756128_7622169492595933184_n.jpg?_nc_cat=108&_nc_oc=AQnowvNTSaD-ONJUTAhxQXZtEwacyTN5LGZC2qZs3c_JwakOEum0aDqWRo57eurJA94&_nc_ht=scontent.fsgn2-3.fna&oh=0d3cbcc480bb339dbf2ba083fb3941c8&oe=5DBAAB55','2019-07-03 11:46:55','2019-07-03 11:46:55'),(5,'ducanh','anhken123','Nguyễn Đức Anh','1999-01-01 00:00:00','0835566236','anhken238@gmail.com','26 nguyễn tri phương','https://scontent.fsgn2-2.fna.fbcdn.net/v/t1.0-1/c0.0.580.580a/55244448_2233288523601348_2745591705490161664_n.jpg?_nc_cat=100&_nc_oc=AQlHT-emJY_hiuXtmF313niSeLISgKfY9R45v1u5paj7A3OvpymEYLwU9m0pZhPbeQU&_nc_ht=scontent.fsgn2-2.fna&oh=9eaa1ea6b41756f71e37585dcaf2057f&oe=5DC557DD','2019-07-03 11:46:55','2019-07-03 11:46:55');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name_category` varchar(100) NOT NULL,
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_edited_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'technology','2019-07-03 11:46:55','2019-07-03 11:46:55'),(2,'sport','2019-07-03 11:46:55','2019-07-03 11:46:55'),(3,'fashion','2019-07-03 11:46:55','2019-07-03 11:46:55'),(4,'society','2019-07-03 11:46:55','2019-07-03 11:46:55'),(5,'art','2019-07-03 11:46:55','2019-07-03 11:46:55');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `event` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name_event` varchar(250) NOT NULL,
  `image` text NOT NULL,
  `image_note` varchar(100) NOT NULL,
  `place` varchar(100) NOT NULL,
  `day_organize` datetime NOT NULL,
  `organizer` varchar(50) NOT NULL,
  `introduce` text NOT NULL,
  `detailed_program` text NOT NULL,
  `is_delete` tinyint(1) NOT NULL DEFAULT '0',
  `post_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_edited_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `id_Category` int(11) NOT NULL,
  `id_Admin` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_Category` (`id_Category`),
  KEY `id_Admin` (`id_Admin`),
  CONSTRAINT `event_ibfk_1` FOREIGN KEY (`id_Category`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `event_ibfk_2` FOREIGN KEY (`id_Admin`) REFERENCES `admin` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` VALUES (1,'The 13th Int l Conference on Research, Innovation and Vision for the Future','https://rivfconference.files.wordpress.com/2019/05/saigon-south_l_1220px_72dpi.jpg','RMIT Vietnam – SaiGon South Campus','Da Nang, Vietnam.','2019-02-22 00:00:00','IEEE, UDN','note','​RIVF 2020 is the 14th conference in this series. RMIT University Vietnam is hosting the conference for April 6-7, 2020 in HoChiMinh city, Vietnam. It continues to offer an opportunity for researchers and innovators to discuss problems, share results, identify emerging issues, and establish academic collaborations in various disciplines of computing and communications.',0,'2019-07-03 11:46:55','2019-07-03 11:46:55',1,1),(2,'The 23rd Pacific-Asia Conference on Knowledge Discovery and Data Mining','http://pakdd2019.medmeeting.org/upload/meeting/7566/Banner/201806/2018622492610_big.jpg','note','DMacau, China.','2019-04-17 00:00:00','IEEE','note','The Pacific-Asia Conference on Knowledge Discovery and Data Mining (PAKDD) ',0,'2019-07-03 11:46:55','2019-07-03 11:46:55',2,1),(3,'ội nghị khoa học quốc gia lần thứ XII về \"Nghiên cứu cơ bản và ứng dụng Công nghệ thông tin','https://rivfconference.files.wordpress.com/2019/05/saigon-south_l_1220px_72dpi.jpg','RMIT Vietnam – SaiGon South Campus','Da Nang, Vietnam.','2019-07-22 00:00:00','IEEE, UDN','note','​RIVF 2020 is the 14th conference in this series. RMIT University Vietnam is hosting the conference for April 6-7, 2020 in HoChiMinh city, Vietnam. It continues to offer an opportunity for researchers and innovators to discuss problems, share results, identify emerging issues, and establish academic collaborations in various disciplines of computing and communications.',0,'2019-07-03 11:46:55','2019-07-03 11:46:55',3,1),(4,'The 11th International Conference on Knowledge and Systems Engineering','https://rivfconference.files.wordpress.com/2019/05/saigon-south_l_1220px_72dpi.jpg','RMIT Vietnam – SaiGon South Campus','Da Nang, Vietnam.','2019-09-17 00:00:00','IEEE, UDN','note','​RIVF 2020 is the 14th conference in this series. RMIT University Vietnam is hosting the conference for April 6-7, 2020 in HoChiMinh city, Vietnam. It continues to offer an opportunity for researchers and innovators to discuss problems, share results, identify emerging issues, and establish academic collaborations in various disciplines of computing and communications.',0,'2019-07-03 11:46:55','2019-07-03 11:46:55',5,1),(5,'The 19th International Symposium on Communications and Information Technologies (ISCIT)','https://rivfconference.files.wordpress.com/2019/05/saigon-south_l_1220px_72dpi.jpg','RMIT Vietnam – SaiGon South Campus','Da Nang, Vietnam.','2019-09-25 00:00:00','IEEE, UDN','note','​RIVF 2020 is the 14th conference in this series. RMIT University Vietnam is hosting the conference for April 6-7, 2020 in HoChiMinh city, Vietnam. It continues to offer an opportunity for researchers and innovators to discuss problems, share results, identify emerging issues, and establish academic collaborations in various disciplines of computing and communications.',0,'2019-07-03 11:46:55','2019-07-03 11:46:55',4,1);
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registrationdetail`
--

DROP TABLE IF EXISTS `registrationdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `registrationdetail` (
  `id_subscriber` int(11) NOT NULL,
  `id_event` int(11) NOT NULL,
  `time_registration` datetime NOT NULL,
  `content_registration` varchar(250) NOT NULL,
  PRIMARY KEY (`id_event`,`id_subscriber`),
  KEY `id_subscriber` (`id_subscriber`),
  CONSTRAINT `registrationdetail_ibfk_1` FOREIGN KEY (`id_event`) REFERENCES `event` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `registrationdetail_ibfk_2` FOREIGN KEY (`id_subscriber`) REFERENCES `subscriber` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registrationdetail`
--

LOCK TABLES `registrationdetail` WRITE;
/*!40000 ALTER TABLE `registrationdetail` DISABLE KEYS */;
INSERT INTO `registrationdetail` VALUES (1,1,'2019-07-03 00:00:00','note'),(2,1,'2019-07-03 00:00:00','note'),(3,1,'2019-07-03 00:00:00','note'),(4,1,'2019-07-03 00:00:00','note'),(5,1,'2019-07-03 00:00:00','note'),(1,2,'2019-07-03 00:00:00','note'),(2,2,'2019-07-03 00:00:00','note'),(3,2,'2019-07-03 00:00:00','note'),(4,2,'2019-07-03 00:00:00','note'),(5,2,'2019-07-03 00:00:00','note'),(1,3,'2019-07-03 00:00:00','note'),(2,3,'2019-07-03 00:00:00','note'),(3,3,'2019-07-03 00:00:00','note'),(4,3,'2019-07-03 00:00:00','note'),(5,3,'2019-07-03 00:00:00','note');
/*!40000 ALTER TABLE `registrationdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subscriber`
--

DROP TABLE IF EXISTS `subscriber`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `subscriber` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fullname` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phone` varchar(30) NOT NULL,
  `address` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subscriber`
--

LOCK TABLES `subscriber` WRITE;
/*!40000 ALTER TABLE `subscriber` DISABLE KEYS */;
INSERT INTO `subscriber` VALUES (1,'Nguyễn Văn Hải Đức','haiduc1120@gmail.com','0834821540','Huế'),(2,'Lê Tường Phúc','phuc.le@codegym.vn','0834821540','Huế'),(3,'Lê Quốc Khánh','khanh.le@codegym.vn','0834821540','Huế'),(4,'Phạm Văn Hoài Phụng','hoaiphungcntt@gmail.com','0834821540','Huế'),(5,'Nguyễn Duy Tài','nguyenduytai945@gmail.com','0834821540','Huế');
/*!40000 ALTER TABLE `subscriber` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-03 17:18:39
