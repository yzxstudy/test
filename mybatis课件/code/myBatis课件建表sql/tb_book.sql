/*
Navicat MySQL Data Transfer

Source Server         : study
Source Server Version : 50636
Source Host           : localhost:3306
Source Database       : bookstore

Target Server Type    : MYSQL
Target Server Version : 50636
File Encoding         : 65001

Date: 2017-10-30 20:01:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_book
-- ----------------------------
DROP TABLE IF EXISTS `tb_book`;
CREATE TABLE `tb_book` (
  `book_id` varchar(50) NOT NULL,
  `book_name` varchar(255) DEFAULT NULL,
  `book_type_id` int(11) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `img` varchar(50) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_book
-- ----------------------------
INSERT INTO `tb_book` VALUES ('bffde556-b7c4-11e7-b54f-20cf305fb5ca', '九鼎记1', null, null, null, null);
INSERT INTO `tb_book` VALUES ('e5ccd4f2-ba23-11e7-9903-20cf305fb5ca', '九鼎记', null, null, null, null);
