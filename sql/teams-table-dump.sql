-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: test_nbastatsfun
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
-- Table structure for table `team`
--

DROP TABLE IF EXISTS `team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `team` (
  `id` int NOT NULL,
  `team_name` varchar(35) NOT NULL,
  `city` varchar(35) NOT NULL,
  `state` varchar(35) NOT NULL,
  `conference` varchar(15) NOT NULL,
  `division` varchar(15) NOT NULL,
  `full_name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team`
--

LOCK TABLES `team` WRITE;
/*!40000 ALTER TABLE `team` DISABLE KEYS */;
INSERT INTO `team` VALUES (1,'Celtics','Boston','Massachusetts','Eastern','Atlantic','Boston Celtics'),(2,'Nets','Brooklyn','New York','Eastern','Atlantic','Brooklyn Nets'),(3,'Knicks','New York','New York','Eastern','Atlantic','New York Knicks'),(4,'76ers','Philadelphia','Pennsylvania','Eastern','Atlantic','Philadelphia 76ers'),(5,'Raptors','Toronto','Ontario','Eastern','Atlantic','Toronto Raptors'),(6,'Bulls','Chicago','Illinois','Eastern','Central','Chicago Bulls'),(7,'Cavaliers','Cleveland','Ohio','Eastern','Central','Cleveland Cavaliers'),(8,'Pistons','Detroit','Michigan','Eastern','Central','Detroit Pistons'),(9,'Pacers','Indianapolis','Indiana','Eastern','Central','Indiana Pacers'),(10,'Bucks','Milwaukee','Wisconsin','Eastern','Central','Milwaukee Bucks'),(11,'Hawks','Atlanta','Georgia','Eastern','Southeast','Atlanta Hawks'),(12,'Hornets','Charlotte','North Carolina','Eastern','Southeast','Charlotte Hornets'),(13,'Heat','Miami','Florida','Eastern','Southeast','Miami Heat'),(14,'Magic','Orlando','Florida','Eastern','Southeast','Orlando Magic'),(15,'Wizards','Washington','D.C.','Eastern','Southeast','Washington Wizards'),(16,'Nuggets','Denver','Colorado','Western','Northwest','Denver Nuggets'),(17,'Timberwolves','Minneapolis','Minnesota','Western','Northwest','Minnesota Timberwolves'),(18,'Thunder','Oklahoma City','Oklahoma','Western','Northwest','Oklahoma City Thunder'),(19,'Trail Blazers','Portland','Oregon','Western','Northwest','Portland Trail Blazers'),(20,'Jazz','Salt Lake City','Utah','Western','Northwest','Utah Jazz'),(21,'Warriors','San Francisco','California','Western','Pacific','Golden State Warriors'),(22,'Clippers','Los Angeles','California','Western','Pacific','Los Angeles Clippers'),(23,'Lakers','Los Angeles','California','Western','Pacific','Los Angeles Lakers'),(24,'Suns','Phoenix','Arizona','Western','Pacific','Phoenix Suns'),(25,'Kings','Sacramento','California','Western','Pacific','Sacramento Kings'),(26,'Mavericks','Dallas','Texas','Western','Southwest','Dallas Mavericks'),(27,'Rockets','Houston','Texas','Western','Southwest','Houston Rockets'),(28,'Grizzlies','Memphis','Tennessee','Western','Southwest','Memphis Grizzlies'),(29,'Pelicans','New Orleans','Louisiana','Western','Southwest','New Orleans Pelicans'),(30,'Spurs','San Antonio','Texas','Western','Southwest','San Antonio Spurs');
/*!40000 ALTER TABLE `team` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-05 13:59:50
