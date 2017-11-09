/*
Navicat MySQL Data Transfer

Source Server         : study
Source Server Version : 50636
Source Host           : localhost:3306
Source Database       : bookstore

Target Server Type    : MYSQL
Target Server Version : 50636
File Encoding         : 65001

Date: 2017-10-30 20:02:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for booktype
-- ----------------------------
DROP TABLE IF EXISTS `booktype`;
CREATE TABLE `booktype` (
  `booktypeid` int(32) NOT NULL,
  `booktypename` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`booktypeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of booktype
-- ----------------------------
INSERT INTO `booktype` VALUES ('1', '玄幻');
INSERT INTO `booktype` VALUES ('2', '武侠');
INSERT INTO `booktype` VALUES ('3', '都市');
INSERT INTO `booktype` VALUES ('4', '军事');
INSERT INTO `booktype` VALUES ('5', '历史');
INSERT INTO `booktype` VALUES ('6', '言情');
