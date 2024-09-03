/*
Navicat MySQL Data Transfer

Source Server         : 数据库
Source Server Version : 50562
Source Host           : localhost:3306
Source Database       : 001903spshyyfwxt

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2024-03-15 18:19:39
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `beijianxinxi`
-- ----------------------------
DROP TABLE IF EXISTS `beijianxinxi`;
CREATE TABLE `beijianxinxi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `wangdianbianhao` varchar(50) DEFAULT NULL,
  `wangdianmingcheng` varchar(50) DEFAULT NULL,
  `beijianmingcheng` varchar(50) DEFAULT NULL,
  `beijiankucun` varchar(50) DEFAULT NULL,
  `beijianjine` varchar(50) DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of beijianxinxi
-- ----------------------------
INSERT INTO `beijianxinxi` VALUES ('2', '008', 'D网点', 'H备件', '15', '94', '2024-03-11 14:19:28');
INSERT INTO `beijianxinxi` VALUES ('3', '001', 'M网点', 'X备件', '45', '94', '2024-03-11 14:19:28');
INSERT INTO `beijianxinxi` VALUES ('4', '031', 'J网点', 'C备件', '59', '99', '2024-03-11 14:19:28');
INSERT INTO `beijianxinxi` VALUES ('5', '031', 'J网点', 'Y备件', '55', '92', '2024-03-11 14:19:28');
INSERT INTO `beijianxinxi` VALUES ('6', '008', 'D网点', 'P备件', '23', '27', '2024-03-11 14:19:28');
INSERT INTO `beijianxinxi` VALUES ('7', '020', 'E网点', 'F备件', '15', '71', '2024-03-11 14:19:28');
INSERT INTO `beijianxinxi` VALUES ('8', '004', 'B网点', 'D备件', '23', '44', '2024-03-11 14:19:28');
INSERT INTO `beijianxinxi` VALUES ('9', '031', 'J网点', 'A备件', '48', '41', '2024-03-11 14:19:28');
INSERT INTO `beijianxinxi` VALUES ('10', '020', 'E网点', 'L备件', '45', '92', '2024-03-11 14:19:28');
INSERT INTO `beijianxinxi` VALUES ('11', '008', 'D网点', 'J备件', '55', '99', '2024-03-11 14:19:28');

-- ----------------------------
-- Table structure for `bianhuantu`
-- ----------------------------
DROP TABLE IF EXISTS `bianhuantu`;
CREATE TABLE `bianhuantu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mingcheng` varchar(50) DEFAULT NULL,
  `tupian` varchar(50) DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of bianhuantu
-- ----------------------------
INSERT INTO `bianhuantu` VALUES ('1', 'P名称', '/files/download/1', '2024-03-11 14:19:28');
INSERT INTO `bianhuantu` VALUES ('2', 'C名称', '/files/download/2', '2024-03-11 14:19:28');
INSERT INTO `bianhuantu` VALUES ('3', 'N名称', '/files/download/3', '2024-03-11 14:19:28');
INSERT INTO `bianhuantu` VALUES ('4', 'Q名称', '/files/download/4', '2024-03-11 14:19:28');
INSERT INTO `bianhuantu` VALUES ('5', 'H名称', '/files/download/5', '2024-03-11 14:19:28');

-- ----------------------------
-- Table structure for `collect`
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `shangpinxinxiID` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of collect
-- ----------------------------

-- ----------------------------
-- Table structure for `file`
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `originName` varchar(255) DEFAULT NULL,
  `fileName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of file
-- ----------------------------
INSERT INTO `file` VALUES ('1', 'bht1.jpg', 'bht1.jpg');
INSERT INTO `file` VALUES ('2', 'bht2.jpg', 'bht2.jpg');
INSERT INTO `file` VALUES ('3', 'bht3.jpg', 'bht3.jpg');
INSERT INTO `file` VALUES ('4', 'bht4.jpg', 'bht4.jpg');
INSERT INTO `file` VALUES ('5', 'bht5.jpg', 'bht5.jpg');
INSERT INTO `file` VALUES ('6', 'wangdianxinxi1.jpg', 'wangdianxinxi1.jpg');
INSERT INTO `file` VALUES ('7', 'wangdianxinxi2.jpg', 'wangdianxinxi2.jpg');
INSERT INTO `file` VALUES ('8', 'wangdianxinxi3.jpg', 'wangdianxinxi3.jpg');
INSERT INTO `file` VALUES ('9', 'wangdianxinxi4.jpg', 'wangdianxinxi4.jpg');
INSERT INTO `file` VALUES ('10', 'wangdianxinxi5.jpg', 'wangdianxinxi5.jpg');
INSERT INTO `file` VALUES ('11', 'wangdianxinxi6.jpg', 'wangdianxinxi6.jpg');
INSERT INTO `file` VALUES ('12', 'wangdianxinxi7.jpg', 'wangdianxinxi7.jpg');
INSERT INTO `file` VALUES ('13', 'wangdianxinxi8.jpg', 'wangdianxinxi8.jpg');
INSERT INTO `file` VALUES ('14', 'wangdianxinxi9.jpg', 'wangdianxinxi9.jpg');
INSERT INTO `file` VALUES ('15', 'wangdianxinxi10.jpg', 'wangdianxinxi10.jpg');
INSERT INTO `file` VALUES ('16', '0bda598a52824fcff3b6d6480db0e2e.jpg', '0bda598a52824fcff3b6d6480db0e2e1710143671116.jpg');
INSERT INTO `file` VALUES ('17', '01d34f9bb16d98619e725d71cdf71a5.jpg', '01d34f9bb16d98619e725d71cdf71a51710143675158.jpg');
INSERT INTO `file` VALUES ('18', '6b84d45147790cbb4d239c9d6c3e345.jpg', '6b84d45147790cbb4d239c9d6c3e3451710143679024.jpg');
INSERT INTO `file` VALUES ('19', 'd06a762f48657d93354a8d6cf5bbdb6.jpg', 'd06a762f48657d93354a8d6cf5bbdb61710143682507.jpg');
INSERT INTO `file` VALUES ('20', 'ded90b53ce1e6829dc5a2155757c9cb.jpg', 'ded90b53ce1e6829dc5a2155757c9cb1710143685497.jpg');
INSERT INTO `file` VALUES ('21', '79563adbdfb67d6ef5d911346d42d58.jpg', '79563adbdfb67d6ef5d911346d42d581710143691772.jpg');
INSERT INTO `file` VALUES ('22', '5e5e5aa423b67bb5404d61d27b2840a.jpg', '5e5e5aa423b67bb5404d61d27b2840a1710143696559.jpg');
INSERT INTO `file` VALUES ('23', 'f774ab8c2a00ee715a389fa77a06f27.jpg', 'f774ab8c2a00ee715a389fa77a06f271710143699798.jpg');
INSERT INTO `file` VALUES ('24', 'a09ae68d9fc427e5d5550020c09a3e9.jpg', 'a09ae68d9fc427e5d5550020c09a3e91710143706288.jpg');
INSERT INTO `file` VALUES ('25', '6b84d45147790cbb4d239c9d6c3e345.jpg', '6b84d45147790cbb4d239c9d6c3e3451710145992303.jpg');
INSERT INTO `file` VALUES ('26', 'f774ab8c2a00ee715a389fa77a06f27.jpg', 'f774ab8c2a00ee715a389fa77a06f271710146163082.jpg');
INSERT INTO `file` VALUES ('27', 'd06a762f48657d93354a8d6cf5bbdb6.jpg', 'd06a762f48657d93354a8d6cf5bbdb61710154812325.jpg');
INSERT INTO `file` VALUES ('28', 'shebeixinxi1.jpg', 'shebeixinxi1.jpg');
INSERT INTO `file` VALUES ('29', 'shebeixinxi2.jpg', 'shebeixinxi2.jpg');
INSERT INTO `file` VALUES ('30', 'shebeixinxi3.jpg', 'shebeixinxi3.jpg');
INSERT INTO `file` VALUES ('31', 'shebeixinxi4.jpg', 'shebeixinxi4.jpg');
INSERT INTO `file` VALUES ('32', 'shebeixinxi5.jpg', 'shebeixinxi5.jpg');
INSERT INTO `file` VALUES ('33', 'shebeixinxi6.jpg', 'shebeixinxi6.jpg');
INSERT INTO `file` VALUES ('34', 'shebeixinxi7.jpg', 'shebeixinxi7.jpg');
INSERT INTO `file` VALUES ('35', 'shebeixinxi8.jpg', 'shebeixinxi8.jpg');
INSERT INTO `file` VALUES ('36', 'shebeixinxi9.jpg', 'shebeixinxi9.jpg');
INSERT INTO `file` VALUES ('37', 'shebeixinxi10.jpg', 'shebeixinxi10.jpg');
INSERT INTO `file` VALUES ('38', '10007.jpg', '100071710492224750.jpg');
INSERT INTO `file` VALUES ('39', '10005.jpg', '100051710496604109.jpg');
INSERT INTO `file` VALUES ('40', '10014.jpg', '100141710497765176.jpg');

-- ----------------------------
-- Table structure for `guanliyuan`
-- ----------------------------
DROP TABLE IF EXISTS `guanliyuan`;
CREATE TABLE `guanliyuan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `yonghuming` varchar(50) DEFAULT NULL,
  `mima` varchar(50) DEFAULT NULL,
  `status` varchar(10) DEFAULT '0',
  `level` varchar(10) DEFAULT '管理员',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of guanliyuan
-- ----------------------------
INSERT INTO `guanliyuan` VALUES ('1', 'admin', '21232f297a57a5a743894a0e4a801fc3', '0', '管理员', '2024-03-11 14:19:28');

-- ----------------------------
-- Table structure for `leixingxinxi`
-- ----------------------------
DROP TABLE IF EXISTS `leixingxinxi`;
CREATE TABLE `leixingxinxi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `leixingmingcheng` varchar(50) DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of leixingxinxi
-- ----------------------------
INSERT INTO `leixingxinxi` VALUES ('2', 'E类型', '2024-03-11 14:19:28');
INSERT INTO `leixingxinxi` VALUES ('3', 'Y类型', '2024-03-11 14:19:28');
INSERT INTO `leixingxinxi` VALUES ('4', 'A类型', '2024-03-11 14:19:28');
INSERT INTO `leixingxinxi` VALUES ('5', 'G类型', '2024-03-11 14:19:28');
INSERT INTO `leixingxinxi` VALUES ('6', 'D类型', '2024-03-11 14:19:28');
INSERT INTO `leixingxinxi` VALUES ('7', 'S类型', '2024-03-11 14:19:28');
INSERT INTO `leixingxinxi` VALUES ('8', 'L类型', '2024-03-11 14:19:28');
INSERT INTO `leixingxinxi` VALUES ('9', 'B类型', '2024-03-11 14:19:28');
INSERT INTO `leixingxinxi` VALUES ('10', 'N类型', '2024-03-11 14:19:28');
INSERT INTO `leixingxinxi` VALUES ('11', 'X类型', '2024-03-11 14:19:28');

-- ----------------------------
-- Table structure for `liuyanban`
-- ----------------------------
DROP TABLE IF EXISTS `liuyanban`;
CREATE TABLE `liuyanban` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `yonghuming` varchar(50) DEFAULT NULL,
  `cheng` varchar(50) DEFAULT NULL,
  `touxiang` varchar(50) DEFAULT NULL,
  `biaoti` varchar(50) DEFAULT NULL,
  `neirong` varchar(500) DEFAULT NULL,
  `huifu` varchar(500) DEFAULT NULL,
  `status` varchar(10) DEFAULT '0',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `parent` int(11) DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of liuyanban
-- ----------------------------

-- ----------------------------
-- Table structure for `pinglun`
-- ----------------------------
DROP TABLE IF EXISTS `pinglun`;
CREATE TABLE `pinglun` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pinglunneirong` varchar(500) DEFAULT NULL,
  `pingfen` varchar(50) DEFAULT NULL,
  `biao` varchar(50) DEFAULT NULL,
  `pinglunren` varchar(50) DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `shujuid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of pinglun
-- ----------------------------
INSERT INTO `pinglun` VALUES ('33', 'asd ', '5', 'shequxinxi', '001', '2024-03-11 17:42:38', '2');
INSERT INTO `pinglun` VALUES ('34', 'asd', '5', 'shequxinxi', '001', '2024-03-11 17:43:27', '2');
INSERT INTO `pinglun` VALUES ('35', '212', '5', 'shequxinxi', '001', '2024-03-11 17:45:52', '2');
INSERT INTO `pinglun` VALUES ('36', '1213', '5', 'shequxinxi', '001', '2024-03-11 18:58:33', '4');

-- ----------------------------
-- Table structure for `shebeixinxi`
-- ----------------------------
DROP TABLE IF EXISTS `shebeixinxi`;
CREATE TABLE `shebeixinxi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shebeimingcheng` varchar(50) DEFAULT NULL,
  `shebeitupian` varchar(50) DEFAULT NULL,
  `yonghuming` varchar(50) DEFAULT NULL,
  `fangweima` varchar(50) DEFAULT NULL,
  `shebeicanshu` varchar(50) DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of shebeixinxi
-- ----------------------------
INSERT INTO `shebeixinxi` VALUES ('2', 'X设备', '/files/download/39', '022', '', '', '2024-03-15 15:25:07');
INSERT INTO `shebeixinxi` VALUES ('3', 'C设备', '', '005', '', '', '2024-03-15 15:25:07');
INSERT INTO `shebeixinxi` VALUES ('4', 'L设备', '', '027', '', '', '2024-03-15 15:25:07');
INSERT INTO `shebeixinxi` VALUES ('5', 'A设备', '', '008', '', '', '2024-03-15 15:25:07');
INSERT INTO `shebeixinxi` VALUES ('6', 'H设备', '', '006', '', '', '2024-03-15 15:25:07');
INSERT INTO `shebeixinxi` VALUES ('7', 'J设备', '', '015', '', '', '2024-03-15 15:25:07');
INSERT INTO `shebeixinxi` VALUES ('8', 'Y设备', '', '024', '', '', '2024-03-15 15:25:07');
INSERT INTO `shebeixinxi` VALUES ('9', 'B设备', '', '025', '', '', '2024-03-15 15:25:07');
INSERT INTO `shebeixinxi` VALUES ('11', 'K设备', '', '001', '', '', '2024-03-15 15:25:07');
INSERT INTO `shebeixinxi` VALUES ('12', '飞行器', '/files/download/38', '001', '123123123', '123123', '2024-03-15 16:45:26');

-- ----------------------------
-- Table structure for `shequxinxi`
-- ----------------------------
DROP TABLE IF EXISTS `shequxinxi`;
CREATE TABLE `shequxinxi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `wangdianmingcheng` varchar(50) DEFAULT NULL,
  `wangdianlianxifangshi` varchar(50) DEFAULT NULL,
  `wangdianweizhi` varchar(50) DEFAULT NULL,
  `wangdianleixing` varchar(50) DEFAULT NULL,
  `beijianmingcheng` varchar(50) DEFAULT NULL,
  `huafeijine` varchar(50) DEFAULT NULL,
  `yonghuming` varchar(50) DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of shequxinxi
-- ----------------------------
INSERT INTO `shequxinxi` VALUES ('2', 'D网点', '1234567892', '1111', 'Y类型', 'J备件,H备件', '193', '001', '2024-03-11 17:33:29');
INSERT INTO `shequxinxi` VALUES ('4', 'E网点', '1234561512', '444', 'N类型', 'L备件,F备件', '163', '001', '2024-03-11 18:58:22');

-- ----------------------------
-- Table structure for `wangdianxinxi`
-- ----------------------------
DROP TABLE IF EXISTS `wangdianxinxi`;
CREATE TABLE `wangdianxinxi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `wangdianbianhao` varchar(50) DEFAULT NULL,
  `wangdianmingcheng` varchar(50) DEFAULT NULL,
  `wangdianweizhi` varchar(50) DEFAULT NULL,
  `wangdianlianxifangshi` varchar(50) DEFAULT NULL,
  `dianmiantupian` varchar(50) DEFAULT NULL,
  `leixingmingcheng` varchar(50) DEFAULT NULL,
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of wangdianxinxi
-- ----------------------------
INSERT INTO `wangdianxinxi` VALUES ('2', '008', 'D网点', '1111', '1234567892', '/files/download/16', 'Y类型', '2024-03-11 14:19:28');
INSERT INTO `wangdianxinxi` VALUES ('3', '012', 'C网点', '222', '1234567812', '/files/download/17', 'E类型', '2024-03-11 14:19:28');
INSERT INTO `wangdianxinxi` VALUES ('4', '031', 'J网点', '333', '1234561234', '/files/download/18', 'G类型', '2024-03-11 14:19:28');
INSERT INTO `wangdianxinxi` VALUES ('5', '020', 'E网点', '444', '1234561512', '/files/download/20', 'N类型', '2024-03-11 14:19:28');
INSERT INTO `wangdianxinxi` VALUES ('6', '006', 'S网点', '555', '1234561254', '/files/download/21', 'N类型', '2024-03-11 14:19:28');
INSERT INTO `wangdianxinxi` VALUES ('7', '004', 'B网点', '666', '1234578565', '/files/download/22', 'X类型', '2024-03-11 14:19:28');
INSERT INTO `wangdianxinxi` VALUES ('8', '018', 'G网点', '777', '1234573345', '/files/download/23', 'D类型', '2024-03-11 14:19:28');
INSERT INTO `wangdianxinxi` VALUES ('9', '015', 'K网点', '888', '1234585456', '/files/download/24', 'A类型', '2024-03-11 14:19:28');
INSERT INTO `wangdianxinxi` VALUES ('10', '022', 'P网点', '999', '1234512545', '', 'D类型', '2024-03-11 14:19:28');
INSERT INTO `wangdianxinxi` VALUES ('11', '001', 'M网点', '0000', '1234592345', '', 'Y类型', '2024-03-11 14:19:28');

-- ----------------------------
-- Table structure for `xinwentongzhi`
-- ----------------------------
DROP TABLE IF EXISTS `xinwentongzhi`;
CREATE TABLE `xinwentongzhi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `biaoti` varchar(50) DEFAULT NULL,
  `leibie` varchar(50) DEFAULT NULL,
  `neirong` longtext,
  `dianjilv` varchar(50) DEFAULT NULL,
  `dianzan_d` int(11) DEFAULT '0',
  `dianzan_c` int(11) DEFAULT '0',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of xinwentongzhi
-- ----------------------------
INSERT INTO `xinwentongzhi` VALUES ('10', '大朋友习近平这样寄语少年儿童', '站内新闻', '<div class=\"content5_xq17896_180426 red\" style=\"margin:0px;padding:0px;color:#333333;font-family:&quot;background-color:#FFFFFF;\">\r\n	<p style=\"font-size:16px;color:#000000;text-indent:2em;font-family:SimSun !important;\">\r\n		<strong>央视网消息：</strong>少年强则中国强。\r\n	</p>\r\n	<p style=\"font-size:16px;color:#000000;text-indent:2em;font-family:SimSun !important;\">\r\n		一直以来，“大朋友”习近平牵挂着少年儿童的成长，关注儿童的教育问题，在多个场合表达对少年儿童的关怀和期望。\r\n	</p>\r\n	<p style=\"font-size:16px;color:#000000;text-indent:2em;font-family:SimSun !important;\">\r\n		在“六一”国际儿童节即将来临之际，央视网梳理了习近平对少年儿童的殷切希望，以飨读者。\r\n	</p>\r\n</div>\r\n<div class=\"content5_xq17896_180426 red\" style=\"margin:0px;padding:0px;color:#333333;font-family:&quot;background-color:#FFFFFF;\">\r\n	<p class=\"text_span1\" style=\"font-size:16px;color:#000000;font-family:SimSun !important;\">\r\n		<span class=\"text_span2\" style=\"color:#800000;\"><span class=\"text_span3\"><strong>学习做人</strong></span></span>\r\n	</p>\r\n	<p style=\"font-size:16px;color:#000000;text-indent:2em;font-family:SimSun !important;\">\r\n		<strong>把社会主义核心价值观牢记在心</strong>\r\n	</p>\r\n	<p style=\"font-size:16px;color:#000000;text-indent:2em;font-family:SimSun !important;\">\r\n		由于大家还在学习阶段，社会阅历不多，对社会主义核心价值观的涵义不一定能理解得很深，但只要牢记在心，随着自己年龄、知识、阅历不断增长，会明白得更多、更深、更透。\r\n	</p>\r\n	<p style=\"font-size:16px;color:#000000;text-indent:2em;font-family:SimSun !important;\">\r\n		――2014年5月30日，习近平在北京市海淀区民族小学主持召开座谈会时的讲话\r\n	</p>\r\n	<p style=\"font-size:16px;color:#000000;text-indent:2em;font-family:SimSun !important;\">\r\n		<strong>学习英雄榜样</strong>\r\n	</p>\r\n	<p style=\"font-size:16px;color:#000000;text-indent:2em;font-family:SimSun !important;\">\r\n		心有榜样，就是要学习英雄人物、先进人物、美好事物，在学习中养成好的思想品德追求。\r\n	</p>\r\n	<p style=\"font-size:16px;color:#000000;text-indent:2em;font-family:SimSun !important;\">\r\n		――2014年5月30日，习近平在北京市海淀区民族小学主持召开座谈会时的讲话\r\n	</p>\r\n	<p style=\"font-size:16px;color:#000000;text-indent:2em;font-family:SimSun !important;\">\r\n		<strong>严格要求自己、虚心接受批评</strong>\r\n	</p>\r\n	<p style=\"font-size:16px;color:#000000;text-indent:2em;font-family:SimSun !important;\">\r\n		不要嫌父母说得多，不要嫌老师管得严，不要嫌同学们管得宽，首先要想想说得管得对不对、是不是为自己好，对了就要听。有些事没有做好，这不要紧，只要自己意识到、愿意改就是进步。自己没有意识到，父母、老师、同学指出来了，使自己意识到、愿意改也是进步。良药苦口利于病，忠言逆耳利于行。我们要养成严格要求自己、虚心接受批评帮助的习惯。\r\n	</p>\r\n	<p style=\"font-size:16px;color:#000000;text-indent:2em;font-family:SimSun !important;\">\r\n		――2014年5月30日，习近平在北京市海淀区民族小学主持召开座谈会时的讲话\r\n	</p>\r\n	<p style=\"font-size:16px;color:#000000;text-indent:2em;font-family:SimSun !important;\">\r\n		<strong>坚持品德为先</strong>\r\n	</p>\r\n	<p style=\"font-size:16px;color:#000000;text-indent:2em;font-family:SimSun !important;\">\r\n		世界上最难的事情，就是怎样做人、怎样做一个好人。要做一个好人，就要有品德、有知识、有责任，要坚持品德为先。\r\n	</p>\r\n	<p style=\"font-size:16px;color:#000000;text-indent:2em;font-family:SimSun !important;\">\r\n		――2015年6月1日，习近平会见中国少年先锋队第七次全国代表大会代表\r\n	</p>\r\n</div>\r\n<div class=\"content5_xq17896_180426 red\" style=\"margin:0px;padding:0px;color:#333333;font-family:&quot;background-color:#FFFFFF;\">\r\n	<p class=\"text_span1\" style=\"font-size:16px;color:#000000;font-family:SimSun !important;\">\r\n		<span class=\"text_span2\" style=\"color:#800000;\"><span class=\"text_span3\"><strong>学习立志</strong></span></span>\r\n	</p>\r\n	<p style=\"font-size:16px;color:#000000;text-indent:2em;font-family:SimSun !important;\">\r\n		<strong>要敢于有梦</strong>\r\n	</p>\r\n	<p style=\"font-size:16px;color:#000000;text-indent:2em;font-family:SimSun !important;\">\r\n		青少年要敢于有梦。从西游记到凡尔纳科幻小说，飞船、潜艇今天不都有了吗？有梦想，还要脚踏实地，好好读书，才能梦想成真。\r\n	</p>\r\n	<p style=\"font-size:16px;color:#000000;text-indent:2em;font-family:SimSun !important;\">\r\n		――2013年5月21日，习近平在四川芦山地震灾区看望慰问受灾群众期间，在龙门乡兴隆中心校参加五（2）班主题班会\r\n	</p>\r\n	<p style=\"font-size:16px;color:#000000;text-indent:2em;font-family:SimSun !important;\">\r\n		<strong>从小就要立志向</strong>\r\n	</p>\r\n	<p style=\"font-size:16px;color:#000000;text-indent:2em;font-family:SimSun !important;\">\r\n		实现我们的梦想，靠我们这一代，更靠下一代。少年儿童从小就要立志向、有梦想，爱学习、爱劳动、爱祖国，德智体美全面发展，长大后做对祖国建设有用的人才。\r\n	</p>\r\n	<p style=\"font-size:16px;color:#000000;text-indent:2em;font-family:SimSun !important;\">\r\n		――2013年5月29日，习近平在北京市少年宫参加“快乐童年　放飞希望”主题队日活动\r\n	</p>\r\n	<p style=\"font-size:16px;color:#000000;text-indent:2em;font-family:SimSun !important;\">\r\n		<strong>培养追求真理、报效祖国的志向</strong>\r\n	</p>\r\n	<p style=\"font-size:16px;color:#000000;text-indent:2em;font-family:SimSun !important;\">\r\n		你们要注意培养追求真理、报效祖国的志向，爱祖国、爱人民、爱劳动、爱科学、爱社会主义，时刻把祖国和人民放在心中，从小听党的话、跟着党走，努力做祖国和人民需要的好孩子，做祖国和人民事业发展的接班人。\r\n	</p>\r\n	<p style=\"font-size:16px;color:#000000;text-indent:2em;font-family:SimSun !important;\">\r\n		――2015年6月1日，习近平会见中国少年先锋队第七次全国代表大会代表\r\n	</p>\r\n</div>\r\n<div class=\"content5_xq17896_180426 red\" style=\"margin:0px;padding:0px;color:#333333;font-family:&quot;background-color:#FFFFFF;\">\r\n	<p class=\"text_span1\" style=\"font-size:16px;color:#000000;font-family:SimSun !important;\">\r\n		<span class=\"text_span2\" style=\"color:#800000;\"><span class=\"text_span3\"><strong>学习创造</strong></span></span>\r\n	</p>\r\n</div>', '92', '0', '0', '2024-03-11 14:19:28');
INSERT INTO `xinwentongzhi` VALUES ('11', '卫生部禁医院统计用药量 受贿医生或取消资格', '站内新闻', '<STRONG>查当事人，更要查相关领导</STRONG>\r\n<P>　　11月16日，卫生部有关负责人指出，最近一段时间，在一些地方和单位，医药购销领域商业贿赂出现了反弹现象。据此，卫生部强调，严禁医院为商业目的“统方”。</P><!--advertisement code begin--><!--none--><!--advertisement code end-->\r\n<P>　　“统方”是医院对医生用药信息量的统计。卫生部要求，对于违反规定，未经批准擅自“统方”或者为商业目的“统方”的，不仅要对当事人从严处理，还要严肃追究医院有关领导和科室负责人的责任。</P>\r\n<P>　　据悉，卫生部将加大查办医药购销领域商业贿赂案件力度，坚决惩处商业贿赂行为。</P>\r\n<P>　　医药购销领域的商业贿赂行为，一般被人们称作医生拿回扣。而所谓为商业目的“统方”，是指医院中个人或部门为医药营销人员提供医生或部门一定时期内临床用药量信息，供其发放药品回扣的行为。</P>\r\n<P>　　卫生部要求，各级卫生行政部门和各类医疗机构加强医院信息系统药品、高值耗材统计功能管理，避免为不正当商业目的统计医师个人和临床科室有关药品、高值耗材用量信息。要对医院信息系统中有关药品、高值耗材使用等信息实行专人负责、加密管理，严格“统方”权限和审批程序，未经批准不得“统方”，严禁为商业目的“统方”。</P>\r\n<P>　　各级卫生行政部门要加大对辖区内医疗机构“统方”行为的监督检查力度。对未落实“统方”管理要求的医疗机构，要责令其限期整改，尽快建立健全有关管理制度。</P>\r\n<P>　　<STRONG>受贿医师，或被取消执业资格</STRONG></P>\r\n<P>　　卫生部有关负责人指出，从近段时间发现和查处的商业贿赂问题来看，医药购销领域商业贿赂在一些地方和单位出现了反弹，而且形式更加多样，手段更加隐蔽，严重损害了人民群众的利益和卫生行业形象，影响十分恶劣。</P>\r\n<P>　　今年，卫生部将加大查办医药购销领域商业贿赂案件力度，坚决惩处商业贿赂行为，有针对性地建章立制，从源头上防范腐败问题的发生。</P>\r\n<P>　　卫生部要求，各级卫生行政部门和各级各类医疗卫生机构要进一步加大查办案件的力度，拓宽案件信息与举报渠道，认真分析近年来医药购销领域商业贿赂行为变化的规律、特点，对典型的商业贿赂案件，发现一起，查办一起，决不姑息，决不手软。</P>\r\n<P>　　卫生部有关负责人强调，对收受商业贿赂的有关人员，要依纪依法严肃处理。对于收受商业贿赂但尚未触犯刑律的从业人员，由卫生行政部门或所在单位视情节给予通报批评、取消当年评优、评职称资格或缓聘、解职待聘，直至解聘，以及相应的党纪政纪处分。</P>\r\n<P>　　对于收受商业贿赂数额较大、时间较长、情节比较严重的，依据《执业医师法》等有关规定，视情节给予警告、责令暂停执业活动，直至吊销执业证书。构成犯罪的，要及时移送司法机关，坚决依法追究其刑事责任。</P>\r\n<P>　　<STRONG>行贿企业，两年不得参加招标</STRONG></P>\r\n<P>　　卫生部要求，建立医药购销领域商业贿赂不良记录，坚决打击商业贿赂行贿行为。</P>\r\n<P>　　各省级卫生行政部门对本行政区域医药购销领域商业贿赂不良记录要实行动态管理，对经执法执纪机关认定，在药品购销活动中存在行贿行为的企业或个人，都要及时列入本地商业贿赂不良记录，予以公布。</P>\r\n<P>　　对列入不良记录的药品生产经营企业，省级卫生行政部门在药品集中采购工作中要坚决取消其所有产品的入围资格，2年内不得接受其任何产品参加集中采购的申请；本省(区、市)医疗机构2年内也不得以任何名义、任何形式购入其药品、医用设备和医用耗材，坚决打击医药购销领域商业贿赂行贿行为，努力促进诚信体系建设。</P>\r\n<P>　　卫生部有关负责人指出，制度建设在防治商业贿赂中具有根本性和长期性。各地要切实抓好长效机制各项制度规定的落实，提高制度的执行力。</P>\r\n<P>　　对容易滋生商业贿赂的重点部门和重点岗位的人员，要定期交流轮岗，并形成制度。</P>', '27', '0', '0', '2024-03-11 14:19:28');
INSERT INTO `xinwentongzhi` VALUES ('12', '艺龙第二季度再现巨亏 低价抢客策略还能撑多久', '站内新闻', '<P style=\"TEXT-INDENT: 30px; MARGIN: 0px 3px 15px\">艺龙旅行网8月15日发布了2013年第二季度财报，艺龙的酒店预订量同比增长58%、酒店预订营收增长了29%，不过艺龙第二季度再次出现7610.8万元人民币巨额净亏损。可见在线酒店价格战的形势依然可以以惨烈来形容，第二季度各主要在线旅游服务商(OTA)对在线酒店的促销力度持续加强，也令这个市场的竞争态势趋于相对的平衡。</P>\r\n<P style=\"TEXT-INDENT: 30px; MARGIN: 0px 3px 15px\"><STRONG>艺龙酒店业务营收出现放缓迹象 携程保持稳定增势</STRONG></P>\r\n<P align=center>&nbsp;</P>\r\n<P align=center><A href=\"content_29786921_2.htm\"><IMG style=\"WIDTH: 500px; HEIGHT: 450px\" id=23195468 title=\"艺龙第二季度再现巨亏 低价抢客策略还能撑多久\" border=0 alt=\"艺龙第二季度再现巨亏 低价抢客策略还能撑多久\" align=center src=\"http://images.china.cn/attachement/jpg/site1000/20130821/0019b91ebfe2137edee308.jpg\" md5=\"\" sourcedescription=\"编辑提供的本地文件\" sourcename=\"本地文件\"></A></P>\r\n<P align=center>&nbsp;</P>\r\n<P style=\"TEXT-ALIGN: center; TEXT-INDENT: 30px; MARGIN: 0px 3px 15px\" align=center>图1：近6个季度携程旅行网与艺龙旅行网酒店预订业务营收对比</P>\r\n<P style=\"TEXT-ALIGN: center; TEXT-INDENT: 30px; MARGIN: 0px 3px 15px\" align=center>&nbsp;</P>\r\n<P style=\"TEXT-INDENT: 30px; MARGIN: 0px 3px 15px\">通过对比携程旅行网与艺龙旅行网近几个季度酒店预订业务营收的状况，艺龙在此前已经保持了连续几个季度增长幅度高于携程一倍以上的态势，但在2013年第二季度，艺龙的增速回落到了29%，仅略高于携程增幅的不到5个百分点。而携程方面，自2012年第三季度，强势参与到在线酒店价格战后，已经扭转了此前的增速持续减慢的颓势，连续3个季度保持提速状态。</P>\r\n<P align=center>&nbsp;</P>\r\n<P align=center><A href=\"content_29786921_2.htm\"><IMG style=\"WIDTH: 500px; HEIGHT: 349px\" id=23195470 title=\"艺龙第二季度再现巨亏 低价抢客策略还能撑多久\" border=0 alt=\"艺龙第二季度再现巨亏 低价抢客策略还能撑多久\" align=center src=\"http://images.china.cn/attachement/jpg/site1000/20130821/0019b91ebfe2137edef009.jpg\" md5=\"\" sourcedescription=\"编辑提供的本地文件\" sourcename=\"本地文件\"></A></P>\r\n<P align=center>&nbsp;</P>\r\n<P style=\"TEXT-ALIGN: center; TEXT-INDENT: 30px; MARGIN: 0px 3px 15px\" align=center>图2：携程旅行网与艺龙旅行网酒店预订间夜量对比</P>\r\n<P style=\"TEXT-ALIGN: center; TEXT-INDENT: 30px; MARGIN: 0px 3px 15px\" align=center>&nbsp;</P>\r\n<P style=\"TEXT-INDENT: 30px; MARGIN: 0px 3px 15px\">通过在线酒店价格战，主要OTA都在快速提升着各自的酒店预订量。受益于在线酒店大规模返现促销，艺龙旅行网保持了数个季度的50%以上的增长率，而携程也在2012年第三季度加入价格战后，令其酒店预订量的增幅由此前的10-20%提升到了30-40%，并遏制了被艺龙快速拉近距离的趋势。通过图2所示，艺龙旅行网酒店预订量占携程预订量的比例由2011年初的不到40%，快速拉升到了60%以上，不过，近3个季度数据显示，艺龙在酒店业务上追赶携程的步伐已现明显减缓的迹象。</P>', '65', '0', '0', '2024-03-11 14:19:28');
INSERT INTO `xinwentongzhi` VALUES ('13', '县“绿色苍南、美丽家园”活动领导小组办公室召开成员工作会议', '站内新闻', '&nbsp;&nbsp;&nbsp; 2月13日消息：2月12日，县“绿色苍南、美丽家园”活动领导小组办公室（简称县绿美办）召开成员工作会议，以深入贯彻1月7日举行的全县“绿色苍南、美丽家园”活动动员大会精神。县委常委、宣传部长戴嘉宝要求与会人员进一步以各种形式扩大宣传，积极营造氛围，并要认真树立典型，快速推进，确保“绿色苍南、美丽家园”活动取得阶段性成果。\r\n<P>&nbsp;&nbsp;&nbsp; 为切实加强对“绿色苍南、美丽家园”活动的具体领导，富有成效地组织、统筹、协调各项工作，根据县委、县政府《关于成立县“绿色苍南、美丽家园”活动领导小组的通知》精神，我县特成立以戴嘉宝为主任，县文明办、林业局、水利局、民政局、国土局、清洁办等主要负责人为副主任的县绿美办。该办成员由相关部门业务处室负责人组成，内设综合协调组、宣传报通组和督查指导组。</P><!--advertisement code begin--><!--advertisement code end-->\r\n<P>&nbsp;&nbsp;&nbsp; 在当天的会议上，县文明办、林业局、清洁办、水利局、国土局、民政局先后汇报了本单位的工作进展情况，并分析了存在的问题。戴嘉宝在听取汇报后，对各单位前段时间的工作表示肯定。同时指出，“绿色苍南、美丽家园”活动进展不平衡，离既定目标尚有距离。对绿化过程中存在黄泥挖掘混乱且价格偏高问题，同意勘测后实行定点采挖，以防山体滑波和水土流失，造成生态破坏。关于青山白化工作，他要求“先礼后兵”，政策法规宣传先行，而后依法处理。对于下一步的全县创建活动，戴嘉宝要求扩大宣传，大力营造氛围。各有关部门和乡镇要通过悬挂横幅、张贴标语等形式开展宣传。报纸、新闻网站、电视台要马上设立专栏、专刊、专题，从正反两个方面多渠道、全方位深入开展宣传报道，做到舆论先行、舆论引导、舆论监督，提振创建信心，表明创建决心和力度，打响开春创建活动第一仗。绿化、清洁、拆违等职能部门要精心设计好周报表、月报表，及时上报各项工作进展情况。戴嘉宝强调，各部门单位要切实树立典型，打造品牌，做到典型引路，以点带面，保质保量快速推进各项活动。同时要加强督查，县里已成立督查指导组，各个单位也要相应成立督查组，还可以发动老人协会、志愿者组织等开展群众性监督，发挥群众在创建活动中的主体作用。戴嘉宝最后还就“绿色苍南、美丽家园”创建活动的调研工作、例会制度和信息快捷报送进行强调。</P>\r\n<P>&nbsp;&nbsp;&nbsp; 又讯 同日下午，戴嘉宝率领县文明办、林业局、清洁办等单位领导前往灵溪镇调研、督查“绿色苍南、美化家园”活动。在详细听取灵溪镇有关负责人的各项工作汇报后，戴嘉宝对该镇将投入1500万元开展活动表示肯定。他要求灵溪镇和有关部门单位树立信心，抓住时机，加强沟通，克服困难，破除矛盾，加快推进“绿色苍南、美丽家园”活动。他强调，要突出重点，突破难点，顾全大局，杜绝纠结于细枝末节、互相扯皮现象的发生。要多方联动，形成合力，快速推进创建活动的深入开展，从根本上改变县城灵溪的文明创建面貌，营造一个美好的生活生产环境。（记者 郑法群）</P><!--function: content() parse end  0ms cost! -->\r\n<DIV class=\"clear_div padd8\"></DIV>\r\n<P></P>\r\n<P></P>\r\n<P><SPAN style=\"PADDING-RIGHT: 2px; FLOAT: right; PADDING-BOTTOM: 10px; COLOR: #5f5f5f; TEXT-ALIGN: right\">【编辑：李甫仓】</SPAN></P>', '34', '0', '0', '2024-03-11 14:19:28');
INSERT INTO `xinwentongzhi` VALUES ('14', '深化法治建设 促进转型发展', '站内新闻', '<P>&nbsp;&nbsp;&nbsp; 苍南新闻网6月16日消息：6月14日下午，县委书记黄寿龙在县委建设“法治苍南”工作领导小组（扩大）会议会上强调，法治建设是经济社会发展的基础性工作。要把建设“法治苍南”与加快科学发展、转型发展结合起来，与深化对台合作、加大投资、统筹城乡、优化环境等重点工作结合起来，扎实推进、勇于创新，为全县全面实施“双海双区”战略创造良好的法治环境。县领导苏庆明、张传君、麻胜聪、陈孝沈、于春华等参加会议。</P>\r\n<P>&nbsp;&nbsp;&nbsp; 据了解，去年以来，全县法治建设取得了积极进展，特别是各地各部门运用法治理念和方式，推进依法拆违、拔钉清障、化解历史遗留问题、化解经济金融风险等各项工作，为服务县委中心工作提供了法治保障。同时，还在民主政治建设、法治政府建设、公正司法能力、社会管理创新，以及法制宣传教育等多个方面实现突破，全县法治化水平逐步提升。</P><!--advertisement code begin--><!--advertisement code end-->\r\n<P>&nbsp;&nbsp;&nbsp; “抓法治，就是优化发展环境，就是维护社会公平正义，就是促进社会和谐稳定，就是践行执政为民。”黄寿龙指出，法治建设是推进经济转型的制度支撑，是促进社会转型的重要保障，是实现政府转型的有效途径。各级各部门一定要站在全局和战略的高度，充分认识建设“法治苍南”的重大意义，切实增强推进“法治苍南”建设的责任感、使命感和紧迫感，坚持把“法治苍南”建设作为一项重要战略工程，通过法治的引导、规范、保障作用，为转型发展营造良好的环境。</P>\r\n<P>&nbsp;&nbsp;&nbsp; 黄寿龙强调，法治建设是经济社会发展的基础性工作，要切实以“法治苍南”建设成效来保障经济社会发展。各地各部门要紧紧围绕主动服务于保发展这个首要任务，从法治的层面突破制约经济发展方式转变和经济转型升级的体制机制，善于用法治的手段调节经济社会关系。要坚持把实施创新驱动发展战略与新型城市化战略有机统一起来，深入推进统筹城乡综合改革，制定新型城市化政策体系，大力推进创新型城市建设。要持续开展环境综合整治，突出抓好“四边三化”、浙江南大门打造等重点工作，依法出重拳打击污染行为和污染企业，从源头上改变苍南环境“脏、乱、差”面貌。还要深化九大改革，努力破解行政效率“低”、干部队伍“软”、审批速度“慢”、社会管理“乱”等群众关注的问题，建立健全保证司法公正的良性机制，提升司法公信力。</P>\r\n<P>&nbsp;&nbsp;&nbsp; 建设“法治苍南”是一项基础性、长期性、战略性的重要工作。黄寿龙要求，各乡镇、各部门要切实把思想统一到县委的决策部署上来，把建设“法治苍南”作为一项重要任务，纳入党委工作大局。建立和完善“法治苍南”建设工作责任制，明确职责、相互配合、上下联动，健全机制、形成合力，不断取得“法治苍南”建设的实效。同时，还要充分调动人民群众参与“法治苍南”建设的积极性，发挥其在建设“法治苍南”中的主体作用，创新载体、强化宣传，营造法治建设良好环境，推动“法治苍南”建设不断迈上新台阶，为建设浙南闽东北最具活力的工贸生态滨海城市提供强有力的法治保障。（记者 陈薇拉）</P>', '11', '0', '0', '2024-03-11 14:19:28');
INSERT INTO `xinwentongzhi` VALUES ('15', '新国八条政下浙江有多少地流拍', '站内新闻', '<p align=\"center\">\r\n	<strong>文/住在杭州网记者 卢丹</strong>\r\n</p>\r\n<p>\r\n	<span><span> </span>兔年伊始，楼市调控政策不断加码。1月26日，新“国八条”政策落地；随后上海、重庆房产税试点成为事实；在国务院的要求之下，全国各地限购政策纷纷出台。</span>\r\n</p>\r\n<!--advertisement code begin--><!--advertisement code end-->\r\n<p>\r\n	<span> 限购、限贷、加息、银行收紧银根……一方面，开发商资金回流压力增大；另一方面，中央实施紧缩性货币政策，上调存款准备金率，房地产开发贷款受到限制。</span>\r\n</p>\r\n<p>\r\n	<span> 作为土地市场的买方――开发企业，不得不对土地市场表露出谨慎慢行的态度。</span>\r\n</p>\r\n<p>\r\n	<span> 而作为土地市场的供给方――地方政府部门，在中央增大土地市场供给的压力之下，于2011年加大了土地出让力度。</span>\r\n</p>\r\n<p>\r\n	<span> 流拍、底价成交……这些字眼，在近期浙江省土地市场上出现得非常频繁。住在杭州网记者统计发现，浙江省的11个地市中，温州、宁波、绍兴、湖州、金华、舟山等地均有土地出现流拍现象，也即是说，浙江省一半以上的地市在近期遭受了土地流拍。</span>\r\n</p>\r\n<p>\r\n	<span> 2011年，在楼市政策之下曲折求存的房地产市场和土地出让市场，值得我们期待和关注！</span>\r\n</p>', '34', '0', '0', '2024-03-11 14:19:28');
INSERT INTO `xinwentongzhi` VALUES ('16', '我市商品房供应步伐不减', '站内新闻', '<P>　　继去年底我市大批项目上市后，今年1月份楼市仍然延续了大供应的势头。根据市房管局商品房网上销售系统的数据显示，1月份，我市共有除现房外的19个项目上市，不过其中有一项目延期至二月份开盘，供应房源4504套，供应面积约达591180平方米，其中商品房住宅3704套，面积509495平方米。</P>\r\n<P>　　记者发现，在这批上市项目中，有7个是之前开盘项目的后期房源，包括万科龙湾花园三期、龙港财富中心二期等，以及几个包含商铺的项目，如泰顺新城茶文化城、乐清御景园商住楼等。此外，还有5个现房项目，主要集中在市区，供应体量普遍不大。</P>\r\n<P>　　从本月商品房供应的区域来看，平阳和苍南占据主力，分别有6个和5个项目，乐清3个，文成、泰顺各一个，而市区仅有龙湾区的两个项目，其中仅金御湾家园为新开盘项目。</P>\r\n<P>　　由此可见，过去几年土地出让不足的并发症正在显现，虽然在刚刚过去的12月份，我市共计推地34宗，总出让面积564669平方米，总建筑面积约134万平方米，其中成交土地31宗，成交面积516141平方米，成交金额413381万元，土地出让宗数和出让面积均创下2012年最高记录。市区方面，12月份共计推地9宗，均达成成交，成交面积149247平方米，可建面积438389平方米，共计成交金额198531万元。可见，市区依然是温州市土地出让的主力区域。</P>\r\n<P>　　但是，由于新出让土地都需要至少10个月的开发周期，加上市场已经从过去的暴利经营转向理性竞争，为此，有业内人士指出，今年上半年市区楼市恐难再现开盘潮。</P>\r\n<P>　　反观平阳、苍南、乐清等县市，近段时间以来，不单在开盘项目数量与供应房源量上保持领先，成交量也紧追市区。根据商品房网上销售系统的每日网签数据显示，截至1月27日，1月份全市共计网签成交房产项目2946套，其中住宅项目成交2234套，市区1238套，乐清259套，平阳541套，苍南746套，四个地区分别占房产项目总网签数的42%、8.8%，18.4%和25.3%。</P>\r\n<P>　　各个县市相对突出的成交量，得益于部分地方项目的自身品质和促销力度，如苍南钱皇绿都项目推出主要面积为110平方米-130平方米，均价在8500元/平方米左右的刚需户型；财富中心项目借力目前风生水起的商业地产，按照国际先进理念打造一站式商业街区；平阳的缇香锦园则推出多重优惠方案，包括参与活动、诚意金报名、预存、首付、签约等各方面的购房优惠。总体而言，苍南县1月份入市的几个项目均有不俗的表现，平阳县则更多依靠之前开盘的项目支撑成交量。</P>\r\n<META name=ContentEnd><!--ZJEG_RSS.content.end--><!--<$[信息内容]>end-->', '67', '0', '0', '2024-03-11 14:19:28');
INSERT INTO `xinwentongzhi` VALUES ('17', '关于钱库广播电视站评选先进单位、先进个人和优秀中层干部的通知', '站内新闻', '<DIV align=center>&nbsp;</DIV>\r\n<DIV align=center>&nbsp;</DIV>\r\n<DIV align=center>&nbsp;</DIV>\r\n<DIV align=center>&nbsp;</DIV>\r\n<DIV align=center>苍钱广电<B>〔2009〕1</B>号</DIV>\r\n<DIV>&nbsp;</DIV>\r\n<DIV align=center>关于钱库广播电视站评选先进单位、先进</DIV>\r\n<DIV align=center>个人和优秀中层干部的通知</DIV>\r\n<DIV align=center>&nbsp;</DIV>\r\n<DIV>各分站、各部办：</DIV>\r\n<DIV>2007年，我站在县台的正确领导下，在全体干部职工共同努力下，各项工作取得显著成绩，涌现出了一大批爱岗敬业、服务百姓的先进集体和先进个人，为表彰、宣传先进，进一步激励广电团队活动，提高广大干部职工的积极性，发挥先锋模范作用，经站长办公会议决定，在全站范围内开展评选活动，现将有关事项通知如下：</DIV>\r\n<DIV>一、评选对象</DIV>\r\n<DIV>工作一年以上，在本职岗位上恪尽职守，兢兢业业的并取得一定业绩的干部职工。（含计划外用工）</DIV>\r\n<DIV>二、评选条件</DIV>\r\n<DIV>（一）先进集体</DIV>\r\n<DIV>1、深入学习贯彻邓小平理论和“三个代表”重要思想，坚决执行党的路线、方针和政策，模范遵守法律法规和行业规定；</DIV>\r\n<DIV>2、被评选的部门要在规章制度建设、新闻宣传、有线电视维护、网络安全、收支情况等方面开展了内容丰富、形式多样的活动、并取得一事实上的工作业绩，为本站提供了先进经验；</DIV>\r\n<DIV>3、被评选的部门要业绩突出，取得了一定的社会效益、经济效益，是本站的先进典型。</DIV>\r\n<DIV>（二）先进个人：</DIV>\r\n<DIV>1、认真学习贯彻邓小平理论和“三个代表”重要思想，政治思想过硬、工作作风优良，能认真落实本站的各项规章制度；</DIV>\r\n<DIV>2、在本职岗位上能充分激发和调动其他职工的创造热情，积极参与技术创新、管理创新、服务创新，为本站做出一定贡献的；</DIV>\r\n<DIV>3、本职工作认真负责，敬业精业，业绩突出，具有开拓创新精神，在全体干部职工中有较高威信的，是岗位的典范。</DIV>\r\n<DIV>（三）优秀中层干部</DIV>\r\n<DIV>1、认真学习贯彻邓小平理论和“三个代表”重要思想，政治思想过硬、工作作风优良，能认真贯彻落实上级的各项指令；</DIV>\r\n<DIV>2、在本分站、部办能充分激发和调动其他职工的创造热情，积极参与技术创新、管理创新、服务创新，为本岗位做出一定贡献的；</DIV>\r\n<DIV>3、在本分站、部办工作认真负责，敬业精业，业绩突出，具有开拓创新精神，在全体干部职工中有较高威信、起表率带头作用的。</DIV>\r\n<DIV>三、评选程序</DIV>\r\n<DIV>1、推荐并产生：</DIV>\r\n<DIV>①先进个人（包括县台先进），由各分站分别推荐一名候选人，本级站宣传口、事业口、办公室各推荐两名候选人，经分站站长、部办主任和站领导班子无记名投票后，本级站和分站所推荐的候选人得票第一为本系统先进个人，本级站得票2-4名次为站先进个人，分站得票2-3名次为站先进个人，再报站长办公会议确定。</DIV>\r\n<DIV>②先进集体根据年度目标考核办法进行考核后，经分站站长、部办主任和管理站站长无记名投票产生，再报站长办公会议确定。</DIV>\r\n<DIV>③优秀中层干部，直接经分站站长、部办主任和管理站站长无记名投票产生，再报站长办公会议确定。</DIV>\r\n<DIV>2、公示。按照有关程序产生的先进集体、先进个人和优秀中层干部的人员进行公示。</DIV>\r\n<DIV>3、表彰。本站将于对荣获先进集体、先进个人进行隆重表彰。</DIV>\r\n<DIV>&nbsp;</DIV>\r\n<DIV>四、相关要求</DIV>\r\n<DIV>1、高度重视，认真组织。此次评选表彰活动是我站创建文明单位活动的重要内容，各分站、各部门要高度重视评选表彰活动，精心组织，认真落实，确保活动的顺利开展。</DIV>\r\n<DIV>2、严格把关，保证质量。各分站、各部门在选拔、推荐过程中，一定要严格程序，认真把关，真正把符合条件的先进集体和先进个人推荐上来。</DIV>\r\n<DIV>3、加强宣传，扩大影响。各分站、各部门要抓住时机，通过此次评选表彰活动，树立一项工作业绩显著、说服力强的典型进行宣传，积极营造有利于创建文明单位活动开展的良好氛围，努力把创建文明单位活动不断引向深入。</DIV>\r\n<DIV>附件：1、钱库广播电视管理站评选先进个人推荐表</DIV>\r\n<DIV>2、钱库广播电视管理站评选先进集体、先进个人、优秀中层干部和县台“先进个人”名额分配表</DIV>\r\n<DIV>&nbsp;</DIV>\r\n<DIV>&nbsp;</DIV>\r\n<DIV>&nbsp;</DIV>\r\n<DIV>&nbsp;</DIV>\r\n<DIV>&nbsp;</DIV>\r\n<DIV>&nbsp;</DIV>\r\n<DIV>&nbsp;</DIV>\r\n<DIV align=left>&nbsp;</DIV>\r\n<DIV align=left>&nbsp;</DIV>\r\n<DIV>钱库广播电视站</DIV>\r\n<DIV align=right>二00八年一月十八日</DIV>\r\n<DIV align=right>&nbsp;</DIV>\r\n<DIV align=right>&nbsp;</DIV><BR clear=all>\r\n<DIV>抄报：县广播电视台、镇委、镇政府</DIV>\r\n<DIV>钱库广电站办公室&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2008年1月18日印发</DIV>\r\n<DIV>附件１：</DIV>\r\n<DIV align=center>钱库广播电视管理站评选先进个人推荐表</DIV>\r\n<DIV align=center>&nbsp;</DIV>\r\n<TABLE border=1 cellSpacing=0 cellPadding=0>\r\n<TBODY>\r\n<TR>\r\n<TD width=101 colSpan=2>\r\n<DIV align=center>姓名</DIV></TD>\r\n<TD width=101>\r\n<DIV align=center>&nbsp;</DIV></TD>\r\n<TD width=101>\r\n<DIV align=center>性别</DIV></TD>\r\n<TD width=101>\r\n<DIV align=center>&nbsp;</DIV></TD>\r\n<TD width=101>\r\n<DIV align=center>出生年月</DIV></TD>\r\n<TD width=101>\r\n<DIV align=center>&nbsp;</DIV></TD></TR>\r\n<TR>\r\n<TD width=101 colSpan=2>\r\n<DIV align=center>文化程度</DIV></TD>\r\n<TD width=101>\r\n<DIV align=center>&nbsp;</DIV></TD>\r\n<TD width=101>\r\n<DIV align=center>部门</DIV></TD>\r\n<TD width=101>\r\n<DIV align=center>&nbsp;</DIV></TD>\r\n<TD width=101>\r\n<DIV align=center>工作岗位</DIV></TD>\r\n<TD width=101>\r\n<DIV align=center>&nbsp;</DIV></TD></TR>\r\n<TR>\r\n<TD width=43>\r\n<DIV align=center>主</DIV>\r\n<DIV align=center>要</DIV>\r\n<DIV align=center>事</DIV>\r\n<DIV align=center>迹</DIV></TD>\r\n<TD width=561 colSpan=6>\r\n<DIV align=center>&nbsp;</DIV>\r\n<DIV align=center>&nbsp;</DIV>\r\n<DIV align=center>&nbsp;</DIV>\r\n<DIV align=center>&nbsp;</DIV>\r\n<DIV align=center>&nbsp;</DIV>\r\n<DIV align=center>&nbsp;</DIV>\r\n<DIV align=center>&nbsp;</DIV>\r\n<DIV align=center>&nbsp;</DIV>\r\n<DIV align=center>&nbsp;</DIV>\r\n<DIV align=center>&nbsp;</DIV>\r\n<DIV align=center>&nbsp;</DIV>\r\n<DIV align=center>&nbsp;</DIV></TD></TR>\r\n<TR>\r\n<TD width=43>\r\n<DIV align=center>管理站意见</DIV></TD>\r\n<TD width=561 colSpan=6>\r\n<DIV align=center>&nbsp;</DIV></TD></TR>\r\n<TR height=0>\r\n<TD width=43></TD>\r\n<TD width=57></TD>\r\n<TD width=101></TD>\r\n<TD width=101></TD>\r\n<TD width=101></TD>\r\n<TD width=101></TD>\r\n<TD width=101></TD></TR></TBODY></TABLE>\r\n<DIV>附件2：</DIV>\r\n<DIV align=center>钱库广播电视管理站评选先进集体、先进个人、优秀中层干部和县台“先进个人”名额分配表</DIV>\r\n<DIV align=center>&nbsp;</DIV>\r\n<DIV align=center>（一）先进个人</DIV>\r\n<DIV align=center>1、5个分站评选出两名先进个人；</DIV>\r\n<DIV align=center>2、办公室评选出一名先进个人；</DIV>\r\n<DIV align=center>3、新闻口评选出一名先进个人；</DIV>\r\n<DIV align=center>4、事业口评选出一名先进个人。</DIV>\r\n<DIV align=center>（二）先进集体</DIV>\r\n<DIV align=center>1、5个分站评选出一个先进集体；</DIV>\r\n<DIV align=center>2、本级站各部门评选出一个先进集体。</DIV>\r\n<DIV align=center>（三）优秀中层干部</DIV>\r\n<DIV align=center>1、5个分站评选出一名优秀中层干部；</DIV>\r\n<DIV align=center>2、本级站各部门评选出一名优秀中层干部。</DIV>\r\n<DIV align=center>（四）县台“先进个人”</DIV>\r\n<DIV align=center>1、5个分站评选出一名“先进个人”；</DIV>\r\n<DIV align=center>2、本级站各部门评选出一名“先进个人”。</DIV>\r\n<DIV>&nbsp;</DIV>\r\n<DIV>&nbsp;</DIV>', '95', '0', '0', '2024-03-11 14:19:28');
INSERT INTO `xinwentongzhi` VALUES ('18', '钱库拆除4000多平米违章棚屋', '站内新闻', '<P>&nbsp;&nbsp;&nbsp; 10月27日，钱库镇对公园路和文鑫路沿街的六处4000多平方米违章棚屋进行拆除，并决定一周内清理绿化完毕，美化钱库的“门面路”。</P>\r\n<P>&nbsp;&nbsp;&nbsp;&nbsp; 据了解，公园路和文鑫路位于车头村，是四方宾客由龙金路进入钱库主城区的必经道路，可以说是钱库的“形象路，门面路”。近几年来，随着新城区建设步伐加快，当地少数村民陆续在街道两侧乱建棚屋，进行大理石加工、水泥销售、废品收购等，严重影响了市容市貌，并且经常占道经营，造成交通拥堵。据两侧的居民反映，大理石加工时造成的噪声和粉尘、水泥搬运时形成的灰尘及运输车辆进出时导致整个地面的振动，让人无法生活。(缪克梯)<BR></P>', '36', '0', '0', '2024-03-11 14:19:28');
INSERT INTO `xinwentongzhi` VALUES ('19', '浙江苍南设专区吸引台商', '站内新闻', '　　新华社杭州8月17日电（记者谢云挺）浙江在温州苍南县规划260平方公里空间平台吸引台商开发，承接台湾先进产业转移。日前正式成立浙台（苍南）经贸合作区党工委管委会，并将推出系列吸引台商和各路资本的优惠政策和措施，构筑海峡西岸经济区东北翼增长极。 \r\n<P></P>\r\n<P>&nbsp;&nbsp;&nbsp; 苍南地处浙闽边界，与台湾隔海相望，是浙江距离台湾最近的县市。全县128万人中，讲闽南（台）话的人口占到6成多。相通的闽南文化、妈祖文化，以及两岸经济发展的互补性，为苍南融入“海西”对接台湾提供了坚实的基础。</P><!--advertisement code begin--><!--advertisement code end-->\r\n<P>&nbsp;&nbsp;&nbsp; 记者从浙江省政府办公厅了解到，2011年5月，省政府批准在苍南县设立浙台（苍南）经贸合作区，列入省级开发区管理序列。允许在规划建设、用地用海、港口贸易、通关便捷、税费减免、金融支持、利益保护、准入门槛等方面实行更加优惠和更加方便的政策措施。</P>\r\n<P>&nbsp;&nbsp;&nbsp; 作为浙江惟一的省级对台经贸交流合作平台，苍南县整合县域优势资源，目前已在当地闻名遐迩的“中国第一座农民城”龙港镇推出规划用地1万亩的“台北小镇”，其中，4500亩的产业园区，对接台湾的装备制造、电子信息、软件开发等产业。吸纳台商在此集中投资兴办产业和生活。同时还获批国家级\"台湾农民创业园\"，创业园涉及6个乡镇，总面积约21.2平方公里，包括“一区五园”，将打造成台湾现代农业在华东地区的一个示范区。</P>\r\n<P>&nbsp;&nbsp;&nbsp; 苍南县委书记黄寿龙说，去年以来，台湾华威联合股份有限公司、台湾肥料股份有限公司、台湾远雄集团等一批知名企业纷纷前来考察洽谈项目。目前，苍南县正积极推进与台湾主要行业和主要县（市）的定期联系和沟通，不断提高浙台（苍南）经贸合作区在台湾的美誉度和认同感。（完）</P>', '12', '0', '0', '2024-03-11 14:19:28');
INSERT INTO `xinwentongzhi` VALUES ('20', '县领导到气象局调研：提升监测预警能力', '站内新闻', '<P>&nbsp;&nbsp;&nbsp; 昨天，副县长邵潘锋到县气象局调研气象工作，了解气象部门在工作中存在的困难和问题。</P>\r\n<P>&nbsp;&nbsp;&nbsp; 今年来，县气象局坚持以提高预报准确率和服务经济社会发展为中心，以建设气象现代化体系为重点，深化气象服务职能，推动气象工作向“大众化、专业化、现代化”方向发展。下一步，该局将狠抓基层台站建设，全面推进气象基础设施建设，大力提升气象监测预警能力。在原来已建15个自动站的基础上，计划完成5~10个自动站选址和安装工作，并在部分重点乡镇和试点村安装气象信息电子显示器5~8个。</P><!--advertisement code begin--><!--advertisement code end-->\r\n<P>&nbsp;&nbsp;&nbsp; 调研中，县领导要求依法加强气象预报的精准性和预见性，切实提升气象工作服务大局、服务社会的能力，狠抓人才队伍建设，提高队伍整体素质。（记者 董少芬） </P>', '31', '0', '0', '2024-03-11 14:19:28');
INSERT INTO `xinwentongzhi` VALUES ('21', '104国道瓯海段焕然一新', '站内新闻', '<DIV id=zoom>\r\n<TABLE align=center>\r\n<TBODY>\r\n<TR>\r\n<TD><IMG src=\"http://www.wenzhou.gov.cn/picture/0/101210053838939.jpg\" border=0></TD></TR></TBODY></TABLE><!--<$[信息内容]>begin--><!--ZJEG_RSS.content.begin-->\r\n<META name=ContentStart>\r\n<P>　　<FONT face=楷体_GB2312 color=#004080>经过5个月修复的104国道瓯海段去掉了以前“最差路况”的名称，如今整洁而又平坦的道路车来车往畅通无阻。（曹益民 蒋小超 摄）</FONT></P>\r\n<P>　　严重破损长达5年之久的104国道瓯海段，经过5个月时间的“整容”，终于焕然一新。记者12月9日在现场看到，104国道大修主体工程已经完成，现在正在完善附属设施。 </P>\r\n<P>　　9日上午，记者乘车体验修复后的104国道瓯海段，看到崭新的黑色柏油路十分平坦，交通标志线整齐清晰，工人正在路边种植行道树和安装钢制护栏。而在修复前，这段公路破烂不堪，曾被戏称为“全省最差路段”之一。</P>\r\n<P>　　104国道是我市交通主干道之一。其中，瓯海段长约9.4公里，起于瓯海南白象街道鹅湖村，止于瓯海仙岩镇沈岙村，2009年日车流量达5万辆。</P>\r\n<P>　　104国道瓯海段大修工程于今年6月14日开工，投资额为5000余万元，对路面进行翻修，同时完善绿化、护栏、边沟等附属设施。11月底，作为主体工程，路面翻修工作全部完成。附属设施建设的扫尾工程也将于本月结束。</P>\r\n<P>　　据悉，今年是全国干线公路养护管理检查年，根据全省统一部署，我市开展了路面专项整治工作。到11月底，全市完成国省道大中修工程96.62公里，国道应急养护工程13.9公里，国道桥头跳车应急专项整治工程30座，国省道桥隧维修加固改造5座，百米桩、里程碑更换726公里。（林乃鹏 项宁宇） </P>\r\n<META name=ContentEnd><!--ZJEG_RSS.content.end--><!--<$[信息内容]>end--></DIV>', '84', '0', '0', '2024-03-11 14:19:28');

-- ----------------------------
-- Table structure for `yonghuxinxi`
-- ----------------------------
DROP TABLE IF EXISTS `yonghuxinxi`;
CREATE TABLE `yonghuxinxi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `yonghuming` varchar(50) DEFAULT NULL,
  `mima` varchar(50) DEFAULT NULL,
  `lianxifangshi` varchar(50) DEFAULT NULL,
  `level` varchar(10) DEFAULT '用户',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of yonghuxinxi
-- ----------------------------
INSERT INTO `yonghuxinxi` VALUES ('2', '022', 'dc5c7986daef50c1e02ab09b442ee34f', '18759640002', '用户', '2024-03-11 14:19:28');
INSERT INTO `yonghuxinxi` VALUES ('3', '004', 'dc5c7986daef50c1e02ab09b442ee34f', '13025896548', '用户', '2024-03-11 14:19:28');
INSERT INTO `yonghuxinxi` VALUES ('4', '002', 'dc5c7986daef50c1e02ab09b442ee34f', '13623256544', '用户', '2024-03-11 14:19:28');
INSERT INTO `yonghuxinxi` VALUES ('5', '011', 'dc5c7986daef50c1e02ab09b442ee34f', '13052154877', '用户', '2024-03-11 14:19:28');
INSERT INTO `yonghuxinxi` VALUES ('6', '021', 'dc5c7986daef50c1e02ab09b442ee34f', '13489665487', '用户', '2024-03-11 14:19:28');
INSERT INTO `yonghuxinxi` VALUES ('7', '005', 'dc5c7986daef50c1e02ab09b442ee34f', '13184865998', '用户', '2024-03-11 14:19:28');
INSERT INTO `yonghuxinxi` VALUES ('8', '009', 'dc5c7986daef50c1e02ab09b442ee34f', '18956482221', '用户', '2024-03-11 14:19:28');
INSERT INTO `yonghuxinxi` VALUES ('9', '024', 'dc5c7986daef50c1e02ab09b442ee34f', '13769548711', '用户', '2024-03-11 14:19:28');
INSERT INTO `yonghuxinxi` VALUES ('10', '003', 'dc5c7986daef50c1e02ab09b442ee34f', '13544655202', '用户', '2024-03-11 14:19:28');
INSERT INTO `yonghuxinxi` VALUES ('11', '001', 'dc5c7986daef50c1e02ab09b442ee34f', '13159863241', '用户', '2024-03-11 14:19:28');
INSERT INTO `yonghuxinxi` VALUES ('12', '333', '310dcbbf4cce62f762a2aaa148d556bd', null, '用户', '2024-03-11 18:23:36');

-- ----------------------------
-- Table structure for `yuyuexinxi`
-- ----------------------------
DROP TABLE IF EXISTS `yuyuexinxi`;
CREATE TABLE `yuyuexinxi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `wangdianmingcheng` varchar(50) DEFAULT NULL,
  `wangdianlianxifangshi` varchar(50) DEFAULT NULL,
  `wangdianweizhi` varchar(50) DEFAULT NULL,
  `leixingmingcheng` varchar(50) DEFAULT NULL,
  `yuyueriqi` timestamp NULL DEFAULT NULL,
  `beijianmingcheng` varchar(50) DEFAULT NULL,
  `yujihuafei` varchar(50) DEFAULT NULL,
  `yonghuming` varchar(50) DEFAULT NULL,
  `shebeimingcheng` varchar(50) DEFAULT NULL,
  `fangweima` varchar(50) DEFAULT NULL,
  `issh` varchar(10) DEFAULT '0',
  `iszf` varchar(10) DEFAULT '否',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of yuyuexinxi
-- ----------------------------
INSERT INTO `yuyuexinxi` VALUES ('2', 'D网点', '1234567892', '1111', 'Y类型', '2024-03-12 00:00:00', 'J备件,H备件', '193', '001', null, null, '1', '否', '2024-03-11 15:43:35');
INSERT INTO `yuyuexinxi` VALUES ('3', 'D网点', '1234567892', '1111', 'Y类型', '2024-03-13 00:00:00', 'P备件,H备件', '121', '333', null, null, '1', '是', '2024-03-11 18:28:41');
INSERT INTO `yuyuexinxi` VALUES ('4', 'E网点', '1234561512', '444', 'N类型', '2024-03-14 00:00:00', 'L备件,F备件', '163', '001', null, null, '1', '是', '2024-03-11 18:57:23');
INSERT INTO `yuyuexinxi` VALUES ('5', 'D网点', '1234567892', '1111', 'Y类型', '2024-03-15 00:00:00', 'P备件', '27', '001', null, null, '1', '是', '2024-03-15 14:23:28');
INSERT INTO `yuyuexinxi` VALUES ('6', 'J网点', '1234561234', '333', 'G类型', '2024-03-15 14:33:42', 'Y备件,C备件', '191', '001', null, null, '1', '否', '2024-03-15 14:33:43');
INSERT INTO `yuyuexinxi` VALUES ('11', 'D网点', '1234567892', '1111', 'Y类型', '2024-03-15 17:25:58', 'J备件,P备件', '126', '001', '飞行器', '123123123', '1', '否', '2024-03-15 17:26:22');
