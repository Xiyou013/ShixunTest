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
  `Pleave` int(31) DEFAULT '0',
  `Pregleave` varchar(31) DEFAULT '无',
  PRIMARY KEY (`Sno`),
  KEY `Sno` (`Sno`),
  CONSTRAINT `attendance_ibfk_1` FOREIGN KEY (`Sno`) REFERENCES `staff` (`Sno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `attendance` */

insert  into `attendance`(`Sno`,`Psignin`,`Pleave`,`Pregleave`) values 
('010111',15,0,'无'),
('010112',15,0,'无'),
('011110',15,0,'无'),
('011120',13,2,'生病'),
('011121',15,0,'无'),
('013110',12,3,'出差'),
('013111',15,0,'无'),
('013112',15,0,'无'),
('015111',20,3,'无'),
('015112',20,3,'无'),
('017111',20,0,'无'),
('017112',20,3,'无'),
('018111',0,0,'无'),
('021111',2,5,'探亲'),
('021112',15,0,'无'),
('021113',0,0,'无');

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
('015','123','13345627896',5500),
('017','741','15978966541',3500),
('020','020','13312345678',1000),
('021','021','13312345679',3300),
('023','023','13312345687',3400);

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
('013112','013',3600,250,3850),
('015111','015',5500,0,0),
('015112','015',5500,0,0),
('017111','017',3500,0,0),
('017112','017',3500,0,0),
('018111','013',3600,0,3600),
('021111','021',4500,33.333333,4533.333333),
('021112','021',3300,250,3550),
('021113','021',3300,0,0);

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
('015111','015110','女',20,'15545962156','015','2020-07-19 23:08:04','123456'),
('015112','015110','男',21,'13378522698','015','2020-07-19 21:56:11','123456'),
('017111','01711','女',20,'15578523698','017','2020-07-20 10:24:53','123456'),
('017112','01722','男',21,'15878966541','017','2020-07-19 21:57:56','123456'),
('018111','ceshi','女',50,'15578522145','013','2020-07-20 10:44:57','123456'),
('021111','ceshi','男',33,'13312345678','021','2020-07-20 11:28:28','123456'),
('021112','02122','女',22,'13312345679','021','2020-07-20 11:34:00','123456'),
('021113','02133','女',32,'13345612378','021','2020-07-20 15:08:34','123456');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `uname` varchar(20) NOT NULL,
  `upass` varchar(20) NOT NULL,
  PRIMARY KEY (`uname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`uname`,`upass`) values 
('jack','123456'),
('rose','123123'),
('unique','01234+'),
('一一','000111'),
('尔尔','111222');

/* Trigger structure for table `attendance` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `Signin` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `Signin` AFTER UPDATE ON `attendance` FOR EACH ROW BEGIN
DECLARE psign INT;
SELECT new.psignin INTO psign
FROM attendance
WHERE sno=new.sno;
IF new.psignin>=0 THEN
update pay set pay.aattwage=(psign/30)*500 where pay.sno=new.sno;
END IF;
    END */$$


DELIMITER ;

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
