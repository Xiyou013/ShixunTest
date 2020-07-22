/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 5.5.59 : Database - rsxxgl
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`rsxxgl` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `rsxxgl`;

/*Table structure for table `attendance` */

DROP TABLE IF EXISTS `attendance`;

CREATE TABLE `attendance` (
  `Sno` char(10) NOT NULL,
  `Psignin` int(31) NOT NULL DEFAULT '0',
  `Psigninflag` int(10) DEFAULT '0',
  `Pleave` int(31) DEFAULT '0',
  `Pleaveflag` int(10) DEFAULT '0',
  `Pregleave` varchar(31) DEFAULT '无',
  `Ptime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  KEY `Sno` (`Sno`),
  KEY `Ptime` (`Ptime`),
  CONSTRAINT `attendance_ibfk_1` FOREIGN KEY (`Sno`) REFERENCES `staff` (`Sno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `attendance` */

insert  into `attendance`(`Sno`,`Psignin`,`Psigninflag`,`Pleave`,`Pleaveflag`,`Pregleave`,`Ptime`) values 
('010111',1,1,0,0,'无','2020-07-21 11:47:47'),
('010111',1,1,0,0,'无','2020-07-21 11:47:53'),
('010111',1,1,0,0,'无','2020-07-20 11:47:58'),
('010111',0,0,1,1,'无','2020-07-19 11:48:05'),
('010111',0,0,1,1,'无','2020-07-21 11:48:09'),
('010111',1,0,0,0,'无','2020-07-21 11:48:14'),
('010111',1,1,0,0,'无','2020-07-21 11:48:23'),
('011121',0,0,1,0,'无','2020-07-21 12:19:49'),
('010112',1,0,0,1,'无','2020-07-20 13:09:55'),
('013111',0,0,1,0,'挂水','2020-07-23 14:19:21'),
('013112',0,0,1,1,'打针','2020-07-23 08:00:00'),
('013112',1,1,0,0,'无','2020-07-19 08:00:00'),
('013110',1,1,0,0,'无','2020-07-21 17:57:15'),
('013110',1,0,0,0,'无','2020-07-19 08:00:00'),
('013110',0,0,1,1,'挂水','2020-07-18 08:00:00'),
('033111',1,1,0,0,'无','2020-07-21 23:33:17'),
('033111',0,0,1,0,'111','2020-07-21 23:33:35'),
('032111',1,0,0,0,'无','2020-07-21 08:00:00'),
('032111',0,0,1,1,'无','2020-07-20 08:00:00'),
('032111',1,1,0,0,'无','2020-07-18 08:00:00'),
('032111',0,0,1,1,'222','2020-07-15 08:00:00'),
('032111',1,0,0,0,'无','2020-07-22 08:44:31'),
('032111',0,0,1,0,'333','2020-07-22 08:44:57'),
('033113',1,1,0,0,'无','2020-07-22 09:31:00'),
('033113',1,1,0,0,'无','2020-07-22 09:31:40'),
('033113',0,0,1,1,'011','2020-07-22 09:31:53'),
('033111',1,1,0,0,'无','2020-07-22 10:15:42'),
('033111',0,0,1,1,'002','2020-07-22 10:16:07'),
('033113',1,1,0,0,'无','2020-07-22 10:18:38'),
('033113',1,0,0,0,'无','2020-07-22 08:00:00');

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `Dno` char(8) NOT NULL,
  `Dname` varchar(20) NOT NULL,
  `Dphone` char(20) NOT NULL,
  `Abasicwage` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`Dno`),
  UNIQUE KEY `Dname` (`Dname`),
  UNIQUE KEY `Dphone` (`Dphone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `department` */

insert  into `department`(`Dno`,`Dname`,`Dphone`,`Abasicwage`) values 
('010','策划部','15546500100',4500),
('011','技术部','15546500110',5000),
('012','测试部','15546500120',3600),
('013','物流部','15546500130',3600),
('020','002','13345632112',1000),
('021','021','13312345679',3300),
('023','023','13312345687',3400),
('032','222','13312345663',2000),
('033','001','15512345678',4000);

/*Table structure for table `pay` */

DROP TABLE IF EXISTS `pay`;

CREATE TABLE `pay` (
  `Sno` char(10) NOT NULL,
  `Dno` char(8) NOT NULL,
  `Abasicwage` double NOT NULL DEFAULT '0',
  `Aattwage` double NOT NULL DEFAULT '0',
  `Atotalwage` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`Sno`,`Dno`),
  KEY `Dno` (`Dno`),
  CONSTRAINT `pay_ibfk_1` FOREIGN KEY (`Sno`) REFERENCES `staff` (`Sno`),
  CONSTRAINT `pay_ibfk_2` FOREIGN KEY (`Dno`) REFERENCES `department` (`Dno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `pay` */

insert  into `pay`(`Sno`,`Dno`,`Abasicwage`,`Aattwage`,`Atotalwage`) values 
('010111','010',4500,250,4750),
('010112','010',4500,250,4750),
('011110','011',5000,250,5250),
('011120','011',5000,215,5215),
('011121','011',5000,250,5250),
('013110','013',3600,200,3800),
('013111','013',3600,250,3850),
('013112','013',3000,200,3200),
('032111','032',2000,50,2050),
('033111','020',1000,33.33,1033.33),
('033113','033',4000,50,4050);

/*Table structure for table `staff` */

DROP TABLE IF EXISTS `staff`;

CREATE TABLE `staff` (
  `Sno` char(8) NOT NULL,
  `Sname` varchar(20) NOT NULL,
  `Ssex` enum('男','女') NOT NULL,
  `Sage` int(11) NOT NULL,
  `Sphone` char(20) NOT NULL,
  `Dno` char(8) NOT NULL,
  `Stime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `spass` char(10) NOT NULL DEFAULT '123456',
  PRIMARY KEY (`Sno`),
  UNIQUE KEY `Sphone` (`Sphone`),
  KEY `Dno` (`Dno`),
  CONSTRAINT `staff_ibfk_1` FOREIGN KEY (`Dno`) REFERENCES `department` (`Dno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `staff` */

insert  into `staff`(`Sno`,`Sname`,`Ssex`,`Sage`,`Sphone`,`Dno`,`Stime`,`spass`) values 
('010111','一一','女',32,'13378921136','010','2001-01-01 00:00:00','123456'),
('010112','散散','男',28,'13345601346','010','2005-05-05 00:00:00','234567'),
('011110','尔尔','女',30,'15537541982','011','2003-03-03 00:00:00','345678'),
('011120','王也','男',26,'15976324561','011','2007-07-07 00:00:00','456789'),
('011121','诸葛青','男',27,'15976322498','011','2006-06-06 00:00:00','567890'),
('013110','Jack','男',36,'19145678911','013','2001-02-02 00:00:00','011123'),
('013111','岩一','男',30,'19145612337','013','2007-08-08 00:00:00','123000'),
('013112','团子','女',24,'13378965412','013','2010-10-10 00:00:00','456222'),
('032111','ceshi','男',2,'15512345679','032','2020-07-22 08:17:36','123456'),
('033111','yijie','男',23,'13345632178','020','2020-07-21 23:19:47','012345'),
('033113','quan','女',36,'13378945632','033','2020-07-21 23:12:36','123456');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `uname` varchar(20) NOT NULL,
  `uphone` char(30) NOT NULL,
  `upass` varchar(20) NOT NULL,
  PRIMARY KEY (`uname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`uname`,`uphone`,`upass`) values 
('jack','13312345678','123456'),
('rose','13312345679','123123'),
('unique','13312345687','01234+'),
('一一','13312345697','000111'),
('尔尔','13312345696','111222');

/* Trigger structure for table `pay` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `Totwage` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `Totwage` BEFORE UPDATE ON `pay` FOR EACH ROW BEGIN
DECLARE abaswage DOUBLE;
DECLARE attwage DOUBLE;
SELECT new.abasicwage INTO abaswage
FROM pay
WHERE sno=new.sno;
SELECT new.aattwage INTO attwage
FROM pay
WHERE sno=new.sno;
IF new.abasicwage<>0 THEN
SET new.atotalwage=abaswage+attwage;
END IF;
    END */$$


DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
