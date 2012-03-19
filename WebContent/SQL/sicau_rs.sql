/*
SQLyog Ultimate v8.71 
MySQL - 5.5.20 : Database - sicau_rs
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`sicau_rs` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `sicau_rs`;

/*Table structure for table `tb_admin` */

DROP TABLE IF EXISTS `tb_admin`;

CREATE TABLE `tb_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adminname` varchar(16) DEFAULT NULL,
  `password` varchar(16) DEFAULT NULL,
  `type` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `tb_admin` */

insert  into `tb_admin`(`id`,`adminname`,`password`,`type`) values (3,'wj1','123',1);

/*Table structure for table `tb_user` */

DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `ID` int(4) NOT NULL AUTO_INCREMENT,
  `signumber` varchar(11) CHARACTER SET utf8 DEFAULT NULL,
  `username` varchar(8) CHARACTER SET utf8 NOT NULL,
  `password` varchar(16) CHARACTER SET utf8 NOT NULL,
  `truename` varchar(8) CHARACTER SET utf8 DEFAULT NULL,
  `testnumber` varchar(11) CHARACTER SET utf8 DEFAULT NULL,
  `sex` char(2) CHARACTER SET utf8 DEFAULT NULL,
  `birthday` varchar(20) DEFAULT NULL,
  `politics` char(6) CHARACTER SET utf8 DEFAULT NULL,
  `identity` char(18) CHARACTER SET utf8 DEFAULT NULL,
  `subject` char(4) CHARACTER SET utf8 DEFAULT NULL,
  `school` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `phone` varchar(15) CHARACTER SET utf8 DEFAULT NULL,
  `mphone` varchar(15) CHARACTER SET utf8 DEFAULT NULL,
  `SA` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `spostcode` char(6) CHARACTER SET utf8 DEFAULT NULL,
  `HA` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `hpostcode` char(6) CHARACTER SET utf8 DEFAULT NULL,
  `lang` varchar(8) CHARACTER SET utf8 DEFAULT NULL,
  `category` varchar(8) CHARACTER SET utf8 DEFAULT NULL,
  `prize` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `speciality` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `type` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `tb_user` */

insert  into `tb_user`(`ID`,`signumber`,`username`,`password`,`truename`,`testnumber`,`sex`,`birthday`,`politics`,`identity`,`subject`,`school`,`phone`,`mphone`,`SA`,`spostcode`,`HA`,`hpostcode`,`lang`,`category`,`prize`,`speciality`,`type`) values (1,NULL,'张三','123456','æ','123446',NULL,'','','','','','','',NULL,'',NULL,'',NULL,'','','',0),(2,NULL,'asfd','1234','李四',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,NULL,'流放多少 ','12345',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(4,NULL,'冷鑫','123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
