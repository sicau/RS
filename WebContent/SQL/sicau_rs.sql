/*
SQLyog 企业版 - MySQL GUI v7.14 
MySQL - 5.5.20 : Database - sicau_rs
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

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

/*Table structure for table `tb_news` */

DROP TABLE IF EXISTS `tb_news`;

CREATE TABLE `tb_news` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `subject` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `createtime` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `content` longtext CHARACTER SET utf8,
  `author` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `type` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `tb_news` */

insert  into `tb_news`(`ID`,`subject`,`createtime`,`content`,`author`,`type`) values (1,'dfdsf','sdfds','<strong>HTML内容dsfds</strong>','dsfsd',NULL),(2,'first','','<p>\r\n	来事啦 发的<strong>说法发的</strong>是范德萨 &nbsp;地方是多少\r\n</p>\r\n<p>\r\n	&nbsp; &nbsp; &nbsp;的<em>说法的</em>份上\r\n</p>',' 冷鑫',2),(3,'通知通知','now','<div style=\"text-align:left;\">\r\n	<b>通告士大夫</b>飞<strong>发的说法</strong> 的冯绍峰 反倒是辅导 反倒<img name=\"img\" src=\"http://xgy.sicau.edu.cn/UploadImages/1271559442093.jpg\" width=\"436\" height=\"249\" />是 飞\r\n</div>','冷in',0),(4,'招生啦','2012-03-28','<b> DSF(也叫desenfu)，1987年注册于<a href=\"http://baike.baidu.com/view/64741.htm\" target=\"_blank\">法国</a>首都<a href=\"http://baike.baidu.com/view/11269.htm\" target=\"_blank\">巴黎</a>，崇尚天然、自由。最早由发现并提取甘蓝菊作用于皮肤抗敏而轰动巴黎，继而风靡法国。1992年成为巴黎年度国际时尚文化艺术节首家妆前皮肤护理唯一指定供应商；1995年，甘蓝菊系列产品成为<a href=\"http://baike.baidu.com/view/1883713.htm\" target=\"_blank\">巴黎时装周</a>官方指定护肤品，与法国顶级彩妆品牌BlackUp、法国顶级香水品牌chanel共同演绎舞台神话。\r\n<div class=\"spctrl\">\r\n</div>\r\n2011年，授权杭州吉维尼化妆品有限公司负责<a href=\"http://baike.baidu.com/view/327945.htm\" target=\"_blank\">中国大陆</a>经营权。　DSF(也叫desenfu)，1987年注册于<a href=\"http://baike.baidu.com/view/64741.htm\" target=\"_blank\">法国</a>首都<a href=\"http://baike.baidu.com/view/11269.htm\" target=\"_blank\">巴黎</a>，崇尚天然、自由。最早由发现并提取甘蓝菊作用于皮肤抗敏而轰动巴黎，继而风靡法国。1992年成为巴黎年度国际时尚文化艺术节首家妆前皮肤护理唯一指定供应商；1995年，甘蓝菊系列产品成为<a href=\"http://baike.baidu.com/view/1883713.htm\" target=\"_blank\">巴黎时装周</a>官方指定护肤品，与法国顶级彩妆品牌BlackUp、法国顶级香水品牌chanel共同演绎舞台神话。\r\n<div class=\"spctrl\">\r\n</div>\r\n2011年，授权杭州吉维尼化妆品有限公司负责<a href=\"http://baike.baidu.com/view/327945.htm\" target=\"_blank\">中国大陆</a>经营权。<img class=\"editorImg log-set-param\" title=\"\" src=\"http://imgsrc.baidu.com/baike/abpic/item/808a27db3c176e0ad1164ef3.jpg\" log-set-param=\"img_view\" /><br />\r\n</b>','冷鑫',1),(5,'新闻标题','','<b>\r\n<p style=\"text-indent:28pt;\">\r\n	<span style=\"line-height:200%;font-size:14pt;\"><span>3</span></span><span style=\"line-height:200%;font-family:宋体;font-size:14pt;\">月</span><span style=\"line-height:200%;font-size:14pt;\"><span>25</span></span><span style=\"line-height:200%;font-family:宋体;font-size:14pt;\">日</span><span style=\"line-height:200%;font-family:宋体;font-size:14pt;\">，经过充分准备，<a href=\"http://jiaowu.sicau.edu.cn/\" target=\"_blank\">教务处</a>组织开展的第二届学生教学信息员招聘宣传活动在雅安校区</span><span style=\"line-height:200%;font-family:宋体;font-size:14pt;\"><a href=\"http://jiaowu.sicau.edu.cn/\" target=\"_blank\"></a><u>杏苑餐厅门口</u></span><span style=\"line-height:200%;font-family:宋体;font-size:14pt;\">举行。活动首次对学生教学信息员的工作职责和首届学生教学信息员所做的相关工作进<s>行了广泛</s><s>的宣传，广大同学对此表现出了极大的兴趣，纷纷前来询问相关问题。</s></span>\r\n</p>\r\n<p style=\"text-indent:28pt;\">\r\n	<span style=\"line-height:200%;font-family:宋体;font-size:14pt;\">本次活动</span><span style=\"line-height:200%;font-family:宋体;font-size:14pt;\">扩大了学生教学信息员的影响度，达到了预期效果，为正在进行的新一届学生教学信息员招聘工作做好铺垫。<span></span></span>\r\n</p>\r\n<br />\r\n</b>','作者',NULL);

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
  `birthday` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
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
  `src` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `type` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=latin1;

/*Data for the table `tb_user` */

insert  into `tb_user`(`ID`,`signumber`,`username`,`password`,`truename`,`testnumber`,`sex`,`birthday`,`politics`,`identity`,`subject`,`school`,`phone`,`mphone`,`SA`,`spostcode`,`HA`,`hpostcode`,`lang`,`category`,`prize`,`speciality`,`src`,`type`) values (1,NULL,'张三','123456','张三',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(2,NULL,'asfd','1234','哈哈','123446',NULL,'呵呵','活活','嘿嘿','','啦啦','','',NULL,'',NULL,'',NULL,'','','',NULL,NULL),(3,NULL,'流放多少 ','12345',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(4,NULL,'冷鑫','123','冷鑫','123446',NULL,'1992-02-28','团员','51382219910128183X','理科','华山中学','0996-4367082','18728153638',NULL,'',NULL,'',NULL,'','','',NULL,NULL),(5,NULL,'刘先','123','åå','123446',NULL,'156','','åå','','åå','åå','',NULL,'åå',NULL,'',NULL,'','åå','åå',NULL,NULL),(12,'冷','鑫','刘','冷鑫','123446',NULL,'金','山','迅','雷','华山中学','件','半',NULL,'批',NULL,'设',NULL,'说','但','标',NULL,0),(13,NULL,'','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(14,NULL,'了','123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(15,NULL,'鑫','刘','先','暴','风','金','山','迅','雷','事','件','半','件','批','配','设','及','说','但','标','里',NULL),(16,NULL,'鑫','刘','先','暴','风','金','山','迅','雷','事','件','半','件','批','配','设','及','说','但','标','里',NULL),(17,NULL,'鑫','刘','先','暴','风','金','山','迅','雷','事','件','半','件','批','配','设','及','说','但','标','里',NULL),(18,NULL,'鑫','刘','先','暴','风','金','山','迅','雷','事','件','半','件','批','配','设','及','说','但','标','里',NULL),(19,NULL,'鑫','刘','先','暴','风','金','山','迅','雷','事','件','半','件','批','配','设','及','说','但','标','里',NULL),(20,NULL,'鑫','刘','先','暴','风','金','山','迅','雷','事','件','半','件','批','配','设','及','说','但','标','里',NULL),(21,NULL,'鑫','刘','先','暴','风','金','山','迅','雷','事','件','半','件','批','配','设','及','说','但','标','里',NULL),(22,NULL,'鑫','刘','先','暴','风','金','山','迅','雷','事','件','半','件','批','配','设','及','说','但','标','里',NULL),(23,NULL,'鑫','刘','先','暴','风','金','山','迅','雷','事','件','半','件','批','配','设','及','说','但','标','里',NULL),(24,NULL,'鑫','刘','先','暴','风','金','山','迅','雷','事','件','半','件','批','配','设','及','说','但','标','里',NULL),(25,NULL,'鑫','刘','先','暴','风','金','山','迅','雷','事','件','半','件','批','配','设','及','说','但','标','里',NULL),(26,NULL,'鑫','刘','先','暴','风','金','山','迅','雷','事','件','半','件','批','配','设','及','说','但','标','里',NULL),(27,NULL,'鑫','刘','先','暴','风','金','山','迅','雷','事','件','半','件','批','配','设','及','说','但','标','里',NULL),(28,NULL,'鑫','刘','先','暴','风','金','山','迅','雷','事','件','半','件','批','配','设','及','说','但','标','里',NULL),(29,NULL,'鑫','刘','先','暴','风','金','山','迅','雷','事','件','半','件','批','配','设','及','说','但','标','里',NULL),(30,NULL,'鑫','刘','先','暴','风','金','山','迅','雷','事','件','半','件','批','配','设','及','说','但','标','里',NULL),(31,NULL,'鑫','刘','先','暴','风','金','山','迅','雷','事','件','半','件','批','配','设','及','说','但','标','里',NULL),(32,NULL,'鑫','刘','先','暴','风','金','山','迅','雷','事','件','半','件','批','配','设','及','说','但','标','里',NULL),(33,NULL,'鑫','刘','先','暴','风','金','山','迅','雷','事','件','半','件','批','配','设','及','说','但','标','里',NULL),(34,NULL,'鑫','刘','先','暴','风','金','山','迅','雷','事','件','半','件','批','配','设','及','说','但','标','里',NULL),(35,NULL,'鑫','刘','先','暴','风','金','山','迅','雷','事','件','半','件','批','配','设','及','说','但','标','里',NULL),(36,NULL,'鑫','刘','先','暴','风','金','山','迅','雷','事','件','半','件','批','配','设','及','说','但','标','里',NULL),(37,NULL,'鑫','刘','先','暴','风','金','山','迅','雷','事','件','半','件','批','配','设','及','说','但','标','里',NULL),(38,NULL,'鑫','刘','先','暴','风','金','山','迅','雷','事','件','半','件','批','配','设','及','说','但','标','里',NULL),(39,NULL,'鑫','刘','先','暴','风','金','山','迅','雷','事','件','半','件','批','配','设','及','说','但','标','里',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
