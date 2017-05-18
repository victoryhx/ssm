/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50625
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50625
File Encoding         : 65001

Date: 2017-05-18 11:13:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `login`
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `password` varchar(50) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of login
-- ----------------------------
INSERT INTO `login` VALUES ('123456', 'admin', '1');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(20) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'Tom', '11212');
INSERT INTO `users` VALUES ('2', 'jack', '16');
INSERT INTO `users` VALUES ('3', '无', '11');
INSERT INTO `users` VALUES ('4', 'Tom1', '23');
INSERT INTO `users` VALUES ('5', 'wuyuelong', '11');
INSERT INTO `users` VALUES ('6', 'wuyuelong1', '11');
INSERT INTO `users` VALUES ('7', 'wuyuelong1', '11');
INSERT INTO `users` VALUES ('8', 'wukk1111', '11');
INSERT INTO `users` VALUES ('10', 'wuyuelong1', '11');
INSERT INTO `users` VALUES ('11', 'wuyuelong1', '11');
INSERT INTO `users` VALUES ('12', 'wuyuelong1', '11');
INSERT INTO `users` VALUES ('13', 'wuyuelong', '444444');
INSERT INTO `users` VALUES ('14', '321312', '23');
INSERT INTO `users` VALUES ('15', 'u777', '4234');
INSERT INTO `users` VALUES ('16', 'e3123', '213213');
