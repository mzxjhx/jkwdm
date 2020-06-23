/*
Navicat MySQL Data Transfer

Source Server         : 本机
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : wdmrayzer_irl

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2020-06-23 17:23:49
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `irl_config`
-- ----------------------------
DROP TABLE IF EXISTS `irl_config`;
CREATE TABLE `irl_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL COMMENT '配置名称',
  `type` tinyint(1) NOT NULL COMMENT '1-RL 2-IL',
  `levelA` float(5,2) DEFAULT NULL COMMENT 'RL等级A',
  `levelB` float(5,2) DEFAULT NULL COMMENT 'RL等级B',
  `port_c` tinyint(1) DEFAULT NULL COMMENT '端口c可选',
  `port_p` tinyint(1) DEFAULT NULL COMMENT '端口p可选',
  `port_r` tinyint(1) DEFAULT NULL COMMENT '端口r可选',
  `c_1310` tinyint(1) DEFAULT NULL COMMENT 'c波长1310可选',
  `c_1490` tinyint(1) DEFAULT NULL COMMENT 'c波长1490可选',
  `c_1550` tinyint(1) DEFAULT NULL COMMENT 'c波长1550可选',
  `p_1310` tinyint(1) DEFAULT NULL COMMENT 'p波长1310可选',
  `p_1490` tinyint(1) DEFAULT NULL COMMENT 'p波长1490可选',
  `p_1550` tinyint(1) DEFAULT NULL COMMENT 'p波长1550可选',
  `r_1310` tinyint(1) DEFAULT NULL COMMENT 'r波长1310可选',
  `r_1490` tinyint(1) DEFAULT NULL COMMENT 'r波长1490可选',
  `r_1550` tinyint(1) DEFAULT NULL COMMENT 'r波长1550可选',
  `il_type` varchar(8) DEFAULT NULL COMMENT 'IL/RL/DIR',
  `both_port` tinyint(1) DEFAULT NULL COMMENT '是否测两根',
  `il_port_p` tinyint(1) DEFAULT NULL COMMENT 'pass端口可选',
  `il_1` float(5,2) DEFAULT NULL COMMENT '通道1合格',
  `il_port_r` tinyint(1) DEFAULT NULL COMMENT 'ref端口可选',
  `il_2` float(5,2) DEFAULT NULL COMMENT '通道2合格',
  `create_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='wdm工艺配置表';

-- ----------------------------
-- Records of irl_config
-- ----------------------------

-- ----------------------------
-- Table structure for `t_il`
-- ----------------------------
DROP TABLE IF EXISTS `t_il`;
CREATE TABLE `t_il` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `serial_number` varchar(32) NOT NULL COMMENT 'SN',
  `primitive_sn` varchar(32) NOT NULL COMMENT '原始sn，不唯一',
  `batch_number` varchar(32) NOT NULL COMMENT '批次号',
  `table` varchar(32) DEFAULT NULL COMMENT '工位',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `staff` varchar(15) NOT NULL COMMENT '工号',
  `level` varchar(10) NOT NULL COMMENT '合格与不合格',
  `type` varchar(5) NOT NULL COMMENT '测试类型 IL/RL/DIR',
  `wave1` int(4) DEFAULT NULL COMMENT '测试波长',
  `il1` float(5,1) DEFAULT NULL COMMENT '透射值',
  `wave2` int(4) DEFAULT NULL COMMENT '反射波长',
  `il2` float(5,1) DEFAULT NULL COMMENT '反射值',
  `ref_1` float(5,2) DEFAULT NULL COMMENT '参考值1',
  `ref_2` float(5,2) DEFAULT NULL COMMENT '参考值2',
  `config` varchar(64) DEFAULT NULL COMMENT '测试工艺配置',
  PRIMARY KEY (`id`,`serial_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='插损表';

-- ----------------------------
-- Records of t_il
-- ----------------------------

-- ----------------------------
-- Table structure for `t_irl`
-- ----------------------------
DROP TABLE IF EXISTS `t_irl`;
CREATE TABLE `t_irl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `serial_number` varchar(32) NOT NULL,
  `batch_number` varchar(32) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `staff` varchar(15) NOT NULL,
  `level` varchar(15) NOT NULL COMMENT '等级',
  `IL1` float(5,1) NOT NULL,
  `IL2` float(5,1) NOT NULL,
  `IL3` float(5,1) DEFAULT NULL,
  `IL4` float(5,1) DEFAULT NULL,
  `RL1` float(5,1) NOT NULL,
  `RL2` float(5,1) NOT NULL,
  `RL3` float(5,1) DEFAULT NULL,
  `RL4` float(5,1) DEFAULT NULL,
  `port_type` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`,`serial_number`),
  KEY `sn` (`serial_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_irl
-- ----------------------------

-- ----------------------------
-- Table structure for `t_mod`
-- ----------------------------
DROP TABLE IF EXISTS `t_mod`;
CREATE TABLE `t_mod` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `serial_number` varchar(32) NOT NULL,
  `batch_number` varchar(32) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `staff` varchar(15) NOT NULL,
  `level` tinyint(1) NOT NULL COMMENT '等级:0-不合格，1-合格。默认合格',
  `wave1` int(11) NOT NULL,
  `wave2` int(11) NOT NULL,
  `wave3` int(11) DEFAULT NULL,
  `wave4` int(11) DEFAULT NULL,
  `wave5` int(11) DEFAULT NULL,
  `wave6` int(11) DEFAULT NULL,
  `RL1` float(5,1) NOT NULL,
  `RL2` float(5,1) NOT NULL,
  `RL3` float(5,1) DEFAULT NULL,
  `RL4` float(5,1) DEFAULT NULL,
  `RL5` float(5,1) DEFAULT NULL,
  `RL6` float(5,1) DEFAULT NULL,
  `port_type` varchar(20) DEFAULT NULL COMMENT '端口类型',
  PRIMARY KEY (`id`,`serial_number`),
  KEY `sn` (`serial_number`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='模组数据';

-- ----------------------------
-- Records of t_mod
-- ----------------------------
INSERT INTO t_mod VALUES ('6', 'wefwefwef', 'we', '2020-05-13 10:36:14', '001', '0', '0', '0', '0', '0', '0', '0', '0.0', '0.0', '0.0', '0.0', '0.0', '0.0', null);
INSERT INTO t_mod VALUES ('7', 'wefwefwef', 'we', '2020-05-13 10:43:12', '001', '0', '0', '0', '0', '0', '0', '0', '0.0', '0.0', '0.0', '0.0', '0.0', '0.0', '1*6');

-- ----------------------------
-- Table structure for `t_rl`
-- ----------------------------
DROP TABLE IF EXISTS `t_rl`;
CREATE TABLE `t_rl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `serial_number` varchar(32) NOT NULL COMMENT '带后缀sn，唯一',
  `primitive_sn` varchar(32) NOT NULL COMMENT '原始sn，不唯一',
  `batch_number` varchar(32) NOT NULL,
  `table` varchar(32) DEFAULT NULL COMMENT '工位',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `staff` varchar(15) NOT NULL,
  `level` varchar(15) NOT NULL COMMENT '等级',
  `t_1310` float(5,1) DEFAULT NULL COMMENT 't端1310 RL值',
  `t_1490` float(5,1) DEFAULT NULL COMMENT 't端1490 RL值',
  `t_1550` float(5,1) DEFAULT NULL COMMENT 't端1550 RL值',
  `r_1310` float(5,1) DEFAULT NULL COMMENT 'r端1310 RL值',
  `r_1490` float(5,1) DEFAULT NULL COMMENT 'r端1490 RL值',
  `r_1550` float(5,1) DEFAULT NULL COMMENT 'r端1550 RL值',
  `c_1310` float(5,1) DEFAULT NULL COMMENT 'c端1310 RL值',
  `c_1490` float(5,1) DEFAULT NULL COMMENT 'c端1490 RL值',
  `c_1550` float(5,1) DEFAULT NULL COMMENT 'c端1550 RL值',
  `rl_c` float(5,1) DEFAULT NULL COMMENT 'c端三波长RL最小值',
  `rl_t` float(5,1) DEFAULT NULL COMMENT 't端三波长RL最小值',
  `rl_r` float(5,1) DEFAULT NULL COMMENT 'r端三波长RL最小值',
  `config` varchar(64) DEFAULT NULL COMMENT '测试工艺配置',
  PRIMARY KEY (`id`,`serial_number`),
  KEY `sn` (`serial_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='回损表';

-- ----------------------------
-- Records of t_rl
-- ----------------------------

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(32) NOT NULL COMMENT '用户名',
  `passwd` varchar(32) NOT NULL COMMENT '密码',
  `role` tinyint(4) DEFAULT '2' COMMENT '权限，1-管理员，2-员工',
  `login_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '登录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='员工表，登录使用';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO t_user VALUES ('1', 'rz0012', '123456', '2', '2020-05-13 13:36:30');
INSERT INTO t_user VALUES ('2', 'rz0001', '123456', '2', '2020-05-13 13:36:30');
INSERT INTO t_user VALUES ('3', 'rz0002', '123456', '2', '2020-05-13 13:36:30');
INSERT INTO t_user VALUES ('4', 'rz0003', '123456', '2', '2020-05-13 13:36:30');
INSERT INTO t_user VALUES ('5', 'rz0004', '123456', '2', '2020-05-13 13:36:30');
INSERT INTO t_user VALUES ('6', 'rz0005', '123456', '2', '2020-05-13 13:36:30');
INSERT INTO t_user VALUES ('7', 'rz0006', '123456', '2', '2020-05-13 13:36:30');
INSERT INTO t_user VALUES ('8', 'rz0007', '123456', '2', '2020-05-13 13:36:30');
INSERT INTO t_user VALUES ('9', 'rz0008', '123456', '2', '2020-05-13 13:36:30');
INSERT INTO t_user VALUES ('10', 'rz0009', '123456', '2', '2020-05-13 13:36:30');
INSERT INTO t_user VALUES ('11', 'rz0010', '123456', '2', '2020-05-13 13:36:30');
INSERT INTO t_user VALUES ('12', 'rz0011', '123456', '2', '2020-05-13 13:36:30');

-- ----------------------------
-- Table structure for `wdm_config`
-- ----------------------------
DROP TABLE IF EXISTS `wdm_config`;
CREATE TABLE `wdm_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL COMMENT '配置名称',
  `type` tinyint(1) NOT NULL COMMENT '1-RL 2-IL',
  `levelA` float(5,2) DEFAULT NULL COMMENT 'RL等级A',
  `levelB` float(5,2) DEFAULT NULL COMMENT 'RL等级B',
  `port_c` tinyint(1) DEFAULT NULL COMMENT '端口c可选',
  `port_p` tinyint(1) DEFAULT NULL COMMENT '端口p可选',
  `port_r` tinyint(1) DEFAULT NULL COMMENT '端口r可选',
  `wave_1310` tinyint(1) DEFAULT NULL COMMENT '波长1310可选',
  `wave_1490` tinyint(1) DEFAULT NULL COMMENT '波长1490可选',
  `wave_1550` tinyint(1) DEFAULT NULL COMMENT '波长1550可选',
  `il_type` varchar(8) DEFAULT NULL COMMENT 'IL/RL/DIR',
  `both_port` tinyint(1) DEFAULT NULL COMMENT '是否测两根',
  `il_port_p` tinyint(1) DEFAULT NULL COMMENT 'pass端口可选',
  `il_1` float(5,2) DEFAULT NULL COMMENT '通道1合格',
  `il_port_r` tinyint(1) DEFAULT NULL COMMENT 'ref端口可选',
  `il_2` float(5,2) DEFAULT NULL COMMENT '通道2合格',
  `create_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='wdm工艺配置表';

-- ----------------------------
-- Records of wdm_config
-- ----------------------------
