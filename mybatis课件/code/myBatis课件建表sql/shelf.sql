/*
Navicat MySQL Data Transfer

Source Server         : study
Source Server Version : 50636
Source Host           : localhost:3306
Source Database       : bookstore

Target Server Type    : MYSQL
Target Server Version : 50636
File Encoding         : 65001

Date: 2017-10-30 20:02:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for shelf
-- ----------------------------
DROP TABLE IF EXISTS `shelf`;
CREATE TABLE `shelf` (
  `shelfid` int(11) NOT NULL AUTO_INCREMENT,
  `shelfname` varchar(255) DEFAULT NULL,
  `shelfaddress` varchar(255) DEFAULT NULL,
  `booktypeid` int(32) DEFAULT NULL,
  PRIMARY KEY (`shelfid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shelf
-- ----------------------------
INSERT INTO `shelf` VALUES ('1', '文史书架', '第一排', '1');
INSERT INTO `shelf` VALUES ('2', '艺术书架', '第二排', '2');
