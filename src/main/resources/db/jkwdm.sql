/*
Navicat MySQL Data Transfer

Source Server         : 本机
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : jkwdm

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2020-06-18 17:01:52
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `t_matter`
-- ----------------------------
DROP TABLE IF EXISTS `t_matter`;
CREATE TABLE `t_matter` (
  `matter_key` varchar(32) NOT NULL COMMENT '主键',
  `user_key` varchar(32) NOT NULL COMMENT '用户key',
  `content` varchar(2000) DEFAULT NULL COMMENT '内容html',
  `status` tinyint(1) DEFAULT '0' COMMENT '状态0-未办，1-已办',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`matter_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='事项表';

-- ----------------------------
-- Records of t_matter
-- ----------------------------

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_key` varchar(32) NOT NULL COMMENT '用户key 主键',
  `login_name` varchar(32) NOT NULL COMMENT '用户名',
  `passwd` varchar(32) NOT NULL COMMENT '密码',
  `role_key` varchar(32) DEFAULT NULL COMMENT '角色key',
  `login_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '登录时间',
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`,`user_key`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of t_user
-- ----------------------------

-- ----------------------------
-- Table structure for `t_week_report`
-- ----------------------------
DROP TABLE IF EXISTS `t_week_report`;
CREATE TABLE `t_week_report` (
  `report_key` varchar(32) NOT NULL COMMENT '主键',
  `user_key` varchar(32) NOT NULL COMMENT '用户key',
  `content` varchar(2000) DEFAULT NULL COMMENT '内容html',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `tag` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`report_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='周报表';

-- ----------------------------
-- Records of t_week_report
-- ----------------------------
