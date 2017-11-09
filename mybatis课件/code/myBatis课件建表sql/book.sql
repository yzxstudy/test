/*
Navicat MySQL Data Transfer

Source Server         : study
Source Server Version : 50636
Source Host           : localhost:3306
Source Database       : bookstore

Target Server Type    : MYSQL
Target Server Version : 50636
File Encoding         : 65001

Date: 2017-10-30 20:01:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `bookid` int(32) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `booktypeid` int(11) DEFAULT NULL,
  `price` double(6,2) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`bookid`),
  KEY `typeforeign` (`booktypeid`),
  CONSTRAINT `book_ibfk_1` FOREIGN KEY (`booktypeid`) REFERENCES `booktype` (`booktypeid`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', '九天', '1', '50.00', '90.jpg', 'h');
INSERT INTO `book` VALUES ('2', '穿越者', '2', '25.00', '91.jpg', '这是我的第二本书');
INSERT INTO `book` VALUES ('3', '九天1', '2', '60.00', '90.jpg', 'sds');
INSERT INTO `book` VALUES ('4', '九天2', '2', '60.00', '90.jpg', 'sds');
INSERT INTO `book` VALUES ('5', '九天3', '2', '60.00', '90.jpg', 'sds');
INSERT INTO `book` VALUES ('6', '九天4', '2', '60.00', '90.jpg', 'sds');
INSERT INTO `book` VALUES ('7', '九天5', '2', '60.00', '90.jpg', 'sds');
INSERT INTO `book` VALUES ('8', '九天6', '2', '60.00', '90.jpg', 'sds');
INSERT INTO `book` VALUES ('9', '九天7', '2', '60.00', '90.jpg', 'sds');
INSERT INTO `book` VALUES ('10', '九天8', '2', '60.00', '90.jpg', 'sds');
INSERT INTO `book` VALUES ('11', '九天9', '2', '60.00', '90.jpg', 'sds');
INSERT INTO `book` VALUES ('12', '九天10', '1', '66.00', '91.jpg', 'dddd');
INSERT INTO `book` VALUES ('15', '倚天屠龙记1', '2', '58.80', '55.png', '这是二本书');
INSERT INTO `book` VALUES ('16', '倚天屠龙记1', '2', '58.80', '55.png', '这是二本书');
INSERT INTO `book` VALUES ('17', '倚天屠龙记12', '2', '58.80', '57.png', '这是12本书');
INSERT INTO `book` VALUES ('18', '倚天屠龙记12', '2', '58.80', '57.png', '这是12本书');
INSERT INTO `book` VALUES ('19', '倚天屠龙记12', '2', '58.80', '57.png', '这是12本书');
INSERT INTO `book` VALUES ('21', '倚天屠龙记12', '2', '58.80', '57.png', '这是12本书');
INSERT INTO `book` VALUES ('22', '倚天屠龙记12', '2', '58.80', '57.png', '这是12本书');
INSERT INTO `book` VALUES ('23', '倚天屠龙记1', '2', '58.80', '55.png', '这是二本书');
INSERT INTO `book` VALUES ('24', '倚天屠龙记1', '2', '58.80', '55.png', '这是二本书');
INSERT INTO `book` VALUES ('25', '倚天屠龙记1', '2', '58.80', '55.png', '这是二本书');
INSERT INTO `book` VALUES ('26', '倚天屠龙记1', '2', '58.80', '55.png', '这是二本书');
INSERT INTO `book` VALUES ('27', '倚天屠龙记12', '2', '58.80', '57.png', '这是12本书');
