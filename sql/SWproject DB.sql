-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: swproject
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `family`
--

DROP TABLE IF EXISTS `family`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `family` (
  `idFamily` varchar(10) NOT NULL,
  `idFamilyMaster` varchar(10) NOT NULL,
  PRIMARY KEY (`idFamily`,`idFamilyMaster`),
  UNIQUE KEY `idFamily_UNIQUE` (`idFamily`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `family`
--

LOCK TABLES `family` WRITE;
/*!40000 ALTER TABLE `family` DISABLE KEYS */;
INSERT INTO `family` VALUES ('1','1'),('2','6'),('3','11'),('4','15'),('5','17'),('6','20'),('7','21');
/*!40000 ALTER TABLE `family` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jobname`
--

DROP TABLE IF EXISTS `jobname`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jobname` (
  `idJob` varchar(10) NOT NULL,
  `jobName` varchar(100) NOT NULL,
  PRIMARY KEY (`idJob`),
  UNIQUE KEY `idJob_UNIQUE` (`idJob`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobname`
--

LOCK TABLES `jobname` WRITE;
/*!40000 ALTER TABLE `jobname` DISABLE KEYS */;
INSERT INTO `jobname` VALUES ('1','Tổ trường'),('2','Tổ phó'),('3','Nhân viên hành chính');
/*!40000 ALTER TABLE `jobname` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `managerjob`
--

DROP TABLE IF EXISTS `managerjob`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `managerjob` (
  `idPerson` varchar(10) NOT NULL,
  `idJob` varchar(10) NOT NULL,
  `startDateTerm` varchar(20) NOT NULL,
  `endDateTerm` varchar(20) NOT NULL,
  PRIMARY KEY (`idPerson`),
  UNIQUE KEY `idPerson_UNIQUE` (`idPerson`),
  KEY `idJob_idx` (`idJob`),
  CONSTRAINT `idJob` FOREIGN KEY (`idJob`) REFERENCES `jobname` (`idJob`),
  CONSTRAINT `idPersonJob` FOREIGN KEY (`idPerson`) REFERENCES `person` (`idPerson`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `managerjob`
--

LOCK TABLES `managerjob` WRITE;
/*!40000 ALTER TABLE `managerjob` DISABLE KEYS */;
INSERT INTO `managerjob` VALUES ('1','1','20/03/2017','19/03/2021'),('4','3','20/03/2017','19/03/2021'),('7','2','20/03/2017','19/03/2021');
/*!40000 ALTER TABLE `managerjob` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meeting`
--

DROP TABLE IF EXISTS `meeting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `meeting` (
  `idMeeting` varchar(10) NOT NULL,
  `date` varchar(20) NOT NULL,
  `place` varchar(200) NOT NULL,
  `topic` varchar(200) NOT NULL,
  PRIMARY KEY (`idMeeting`),
  UNIQUE KEY `idMeeting_UNIQUE` (`idMeeting`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meeting`
--

LOCK TABLES `meeting` WRITE;
/*!40000 ALTER TABLE `meeting` DISABLE KEYS */;
/*!40000 ALTER TABLE `meeting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person` (
  `idPerson` varchar(10) NOT NULL,
  `idFamily` varchar(10) NOT NULL,
  `lastName` varchar(100) NOT NULL,
  `firstName` varchar(100) NOT NULL,
  `relationship` varchar(45) NOT NULL,
  `birth` varchar(20) NOT NULL,
  `address` varchar(200) NOT NULL,
  `gender` varchar(20) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `job` varchar(100) DEFAULT NULL,
  `identityID` varchar(20) DEFAULT NULL,
  `education` varchar(100) DEFAULT NULL,
  `phoneNum` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`idPerson`),
  UNIQUE KEY `idPerson_UNIQUE` (`idPerson`),
  KEY `idFamily_idx` (`idFamily`),
  CONSTRAINT `idFamily` FOREIGN KEY (`idFamily`) REFERENCES `family` (`idFamily`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES ('1','1','Nguyễn Thiên','Nam','Chủ hộ','7/3/2000','91 ClareMẹnt Center','Nam','','Làm ruộng','184356296','Cấp 3',NULL),('10','2','Đặng Hải','Long','Con','7/9/2006','34 Gateway Court','Nam','','Làm ruộng','184383305','Cấp 3',NULL),('11','3','Hoàng Cao','Lộc','Chủ hộ','3/2/1950','41314 SulliVợn Center','Nam','','Làm ruộng','184386306','Cấp 3',NULL),('12','3','Phan Bảo','Luân','Chồng','21/03/1966','4 Larry Park','Nam','','Làm ruộng','184389307','Cấp 3',NULL),('13','3','Trần Vợn','Nam','Con','23/02/1962','8 Golden Leaf Lane','Nam','','Làm ruộng','184392308','Cấp 3',NULL),('14','3','Nguyễn Thị Kim','Nga','Con','15/01/1953','48760 Mẹyer Way','Nữ','','Làm ruộng','184395309','Cấp 3',NULL),('15','4','Bùi','Phát','Chủ hộ','16/02/1961','4 RaMẹey Circle','Nam','','Làm ruộng','184398310','Cấp 3',NULL),('16','4','Tou Tiang Sam','Pô','Vợ','30/03/1953','6 East Parkway','Nam','','Làm ruộng','184401311','Cấp 3',NULL),('17','5','Trương Vợệt','Quang','Chủ hộ','3/1/1946','87356 Mẹnley Plaza','Nam','','Làm ruộng','184404312','Cấp 3',NULL),('18','5','PhạMẹTrường','Sơn','Vợ','18/12/2004','874 Mẹrquette Place','Nam','','Làm ruộng','184407313','Cấp 3',NULL),('19','5','Nguyễn Đình','Trọng','Con','19/06/1998','08621 John Wall Center','Nam','','Làm ruộng','184410314','Cấp 3',NULL),('2','1','Phan Trần Bảo','Tuấn','Mẹ','3/4/1977','72174 BluesteMẹCircle','Nam','','Làm ruộng','184359297','Cấp 3',NULL),('20','6','Mai Văn','Tiến','Chủ hộ','13/05/2015','0 Carey Circle','Nam','','Sinh viên','184413315','Cấp 3',NULL),('21','7','Phan Nguyễn Nhựt','Trường','Chủ hộ','23/09/1986','3003 Burning Wood Way','Nam','','Kinh Doanh','184416316','Cấp 3',NULL),('3','1','Trần Duy','Bảo','Con','13/02/1995','10 Hudson Lane','Nam','','Làm ruộng','184362298','Cấp 3',NULL),('4','1','Nguyễn Mẹnh','Hội','Vợ','22/08/1998','2471 Warner Road','Nam','','Làm ruộng','184365299','Cấp 3',NULL),('5','1','Bùi Trần Thiên','Hoan','Con','15/11/1949','077 Anhalt Center','Nam','','Làm ruộng','184368300','Cấp 3',NULL),('6','2','Huỳnh Lê','Khang','Chủ hộ','27/07/1986','82674 Cordelia Point','Nam','','Làm ruộng','184371301','Cấp 3',NULL),('7','2','Phan Mẹnh Anh','Khoa','Vợ','27/09/1953','659 Dexter Circle','Nam','','Làm ruộng','184374302','Cấp 3',NULL),('8','2','Điệp Vợn','Lâm','Con','1/4/1984','5820 Petterle Center','Nam','','Làm ruộng','184377303','Cấp 3',NULL),('9','2','Hồ Ngọc','Linh','Con','21/08/1971','899 Northland Center','Nữ','','Làm ruộng','184380304','Cấp 3',NULL);
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `renter`
--

DROP TABLE IF EXISTS `renter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `renter` (
  `idRenter` varchar(10) NOT NULL,
  `idPerson` varchar(10) NOT NULL,
  `homeTown` varchar(200) NOT NULL,
  `startLiving` varchar(20) NOT NULL,
  PRIMARY KEY (`idRenter`,`idPerson`),
  UNIQUE KEY `idRenter_UNIQUE` (`idRenter`),
  UNIQUE KEY `idPerson_UNIQUE` (`idPerson`),
  CONSTRAINT `idPersonRenter` FOREIGN KEY (`idPerson`) REFERENCES `person` (`idPerson`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `renter`
--

LOCK TABLES `renter` WRITE;
/*!40000 ALTER TABLE `renter` DISABLE KEYS */;
INSERT INTO `renter` VALUES ('1','21','Hà Tĩnh','13/05/2019');
/*!40000 ALTER TABLE `renter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `idsSudent` varchar(10) NOT NULL,
  `idPerson` varchar(10) NOT NULL,
  `hometown` varchar(200) NOT NULL,
  `university` varchar(200) NOT NULL,
  `startLiving` varchar(20) NOT NULL,
  PRIMARY KEY (`idsSudent`,`idPerson`),
  UNIQUE KEY `idsSudent_UNIQUE` (`idsSudent`),
  UNIQUE KEY `idPerson_UNIQUE` (`idPerson`),
  CONSTRAINT `idPersonStudent` FOREIGN KEY (`idPerson`) REFERENCES `person` (`idPerson`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('1','20','Hà Tĩnh','Bách khoa Hà Nội','20/8/2018');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-22 14:38:58
