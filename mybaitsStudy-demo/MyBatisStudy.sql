/*
Navicat MySQL Data Transfer

Source Server         : 192.168.1.110
Source Server Version : 50158
Source Host           : 192.168.1.110:3306
Source Database       : MyBatisStudy

Target Server Type    : MYSQL
Target Server Version : 50158
File Encoding         : 65001

Date: 2017-02-09 19:46:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for Class
-- ----------------------------
DROP TABLE IF EXISTS `Class`;
CREATE TABLE `Class` (
  `Class_ID` varchar(26) NOT NULL,
  `Class_Name` varchar(100) NOT NULL,
  `HeadMaster_ID` varchar(26) NOT NULL,
  PRIMARY KEY (`Class_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Class
-- ----------------------------
INSERT INTO `Class` VALUES ('1', '软件一班', '1');

-- ----------------------------
-- Table structure for Student
-- ----------------------------
DROP TABLE IF EXISTS `Student`;
CREATE TABLE `Student` (
  `Student_ID` varchar(26) NOT NULL,
  `Student_Name` varchar(50) NOT NULL,
  `Birthday` date NOT NULL,
  `Class_ID` varchar(26) NOT NULL,
  `HeadMaster_ID` varchar(26) NOT NULL,
  PRIMARY KEY (`Student_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Student
-- ----------------------------
INSERT INTO `Student` VALUES ('1', '赵勇', '1992-01-07', '1', '1');

-- ----------------------------
-- Table structure for Teacher
-- ----------------------------
DROP TABLE IF EXISTS `Teacher`;
CREATE TABLE `Teacher` (
  `Teacher_ID` varchar(26) NOT NULL,
  `Teacher_Name` varchar(100) NOT NULL,
  `Birthday` date NOT NULL,
  PRIMARY KEY (`Teacher_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Teacher
-- ----------------------------
INSERT INTO `Teacher` VALUES ('1', 'zzl', '2017-02-01');
