/*
Navicat MySQL Data Transfer

Source Server         : 腾讯云
Source Server Version : 50718
Source Host           : cdb-qx0xu3qi.cd.tencentcdb.com:10015
Source Database       : job

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2019-11-27 14:49:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for application
-- ----------------------------
DROP TABLE IF EXISTS `application`;
CREATE TABLE `application` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `job_id` int(11) DEFAULT NULL COMMENT '工作id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for job
-- ----------------------------
DROP TABLE IF EXISTS `job`;
CREATE TABLE `job` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `workplace` varchar(255) DEFAULT NULL COMMENT '工作地点',
  `salary` varchar(10) DEFAULT NULL COMMENT '月薪',
  `education` varchar(255) DEFAULT NULL COMMENT '学历限制',
  `detail` varchar(255) DEFAULT NULL COMMENT '详细介绍',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for resume
-- ----------------------------
DROP TABLE IF EXISTS `resume`;
CREATE TABLE `resume` (
  `id` varchar(40) NOT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `sex` varchar(255) DEFAULT NULL COMMENT '性别',
  `education` varchar(255) DEFAULT NULL COMMENT '教育程度',
  `telephone` varchar(255) DEFAULT NULL COMMENT '联系方式',
  `age` int(11) DEFAULT NULL,
  `major` varchar(255) DEFAULT NULL COMMENT '专业',
  `university` varchar(255) DEFAULT NULL COMMENT '大学',
  `workexperience` varchar(255) DEFAULT NULL COMMENT '工作经历',
  `projectexperience` varchar(255) DEFAULT NULL COMMENT '项目经历',
  `imgurl` varchar(255) DEFAULT NULL COMMENT '简历照片',
  `evaluation` varchar(255) DEFAULT NULL COMMENT '自我评价',
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `resumeId` varchar(255) DEFAULT NULL COMMENT '简历id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
