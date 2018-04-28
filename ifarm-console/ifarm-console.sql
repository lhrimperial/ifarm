/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50628
Source Host           : localhost:3306
Source Database       : ifarm-console

Target Server Type    : MYSQL
Target Server Version : 50628
File Encoding         : 65001

Date: 2018-04-28 15:44:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_console_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_console_permission`;
CREATE TABLE `t_console_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `resource_id` int(11) DEFAULT NULL,
  `permission` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_console_permission
-- ----------------------------
INSERT INTO `t_console_permission` VALUES ('1', '1', 'ALL', '2018-04-14 20:33:22');
INSERT INTO `t_console_permission` VALUES ('2', '2', 'ALL', '2018-04-14 20:33:22');
INSERT INTO `t_console_permission` VALUES ('3', '3', 'ALL', '2018-04-14 20:33:22');
INSERT INTO `t_console_permission` VALUES ('4', '4', 'ALL', '2018-04-14 20:33:22');
INSERT INTO `t_console_permission` VALUES ('5', '5', 'ALL', '2018-04-14 20:33:22');
INSERT INTO `t_console_permission` VALUES ('6', '6', 'ALL', '2018-04-14 20:33:22');
INSERT INTO `t_console_permission` VALUES ('7', '7', 'ALL', '2018-04-14 20:33:22');

-- ----------------------------
-- Table structure for t_console_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_console_resource`;
CREATE TABLE `t_console_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `resource_code` varchar(50) NOT NULL,
  `resource_name` varchar(100) NOT NULL,
  `router` varchar(100) DEFAULT NULL,
  `component` varchar(100) DEFAULT NULL,
  `parent_code` varchar(50) DEFAULT NULL,
  `resource_level` tinyint(4) DEFAULT NULL,
  `resource_type` tinyint(4) DEFAULT NULL,
  `display_order` tinyint(4) DEFAULT NULL,
  `node_icon` varchar(100) DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  `leaf_flag` char(1) DEFAULT NULL,
  `active` char(1) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_console_resource
-- ----------------------------
INSERT INTO `t_console_resource` VALUES ('1', 'console_1', 'console系统', null, null, null, '1', '1', '1', null, null, 'N', 'Y', '2018-04-14 19:55:02', '2018-04-14 19:55:05');
INSERT INTO `t_console_resource` VALUES ('2', 'console_101', '综合管理', '', null, 'console_1', '2', '2', '1', 'el-icon-setting', null, 'N', 'Y', '2018-04-14 20:06:21', '2018-04-14 20:06:21');
INSERT INTO `t_console_resource` VALUES ('3', 'console_102', '基础数据', '', null, 'console_1', '2', '2', '2', 'el-icon-menu', null, 'N', 'Y', '2018-04-14 20:06:21', '2018-04-14 20:06:21');
INSERT INTO `t_console_resource` VALUES ('4', 'console_103', '系统设置', '', null, 'console_1', '2', '2', '3', 'el-icon-date', null, 'N', 'Y', '2018-04-14 20:06:21', '2018-04-14 20:06:21');
INSERT INTO `t_console_resource` VALUES ('5', 'console_10201', '词条管理', 'termsCodeManagement', 'setting/termsCodeManagement', 'console_102', '3', '3', '1', '', null, 'Y', 'Y', '2018-04-14 20:06:21', '2018-04-14 20:06:21');
INSERT INTO `t_console_resource` VALUES ('6', 'console_10301', '用户管理', 'userManagement', 'setting/userManagement', 'console_103', '3', '3', '1', '', null, 'Y', 'Y', '2018-04-14 20:06:21', '2018-04-14 20:06:21');
INSERT INTO `t_console_resource` VALUES ('7', 'console_10302', '角色管理', 'roleManagement', 'setting/roleManagement', 'console_103', '3', '3', '2', '', null, 'Y', 'Y', '2018-04-14 20:06:21', '2018-04-14 20:06:21');

-- ----------------------------
-- Table structure for t_console_role
-- ----------------------------
DROP TABLE IF EXISTS `t_console_role`;
CREATE TABLE `t_console_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_code` varchar(50) NOT NULL,
  `role_name` varchar(100) NOT NULL,
  `notes` varchar(255) DEFAULT NULL,
  `active` char(1) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_console_role
-- ----------------------------
INSERT INTO `t_console_role` VALUES ('1', 'admin', 'admin', null, 'Y', '2018-04-14 20:12:16', '2018-04-14 20:12:19');

-- ----------------------------
-- Table structure for t_console_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_console_role_permission`;
CREATE TABLE `t_console_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `permission_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_console_role_permission
-- ----------------------------
INSERT INTO `t_console_role_permission` VALUES ('1', '1', '1', '2018-04-14 20:35:38');
INSERT INTO `t_console_role_permission` VALUES ('2', '1', '2', '2018-04-14 20:35:38');
INSERT INTO `t_console_role_permission` VALUES ('3', '1', '3', '2018-04-14 20:35:38');
INSERT INTO `t_console_role_permission` VALUES ('4', '1', '4', '2018-04-14 20:35:38');
INSERT INTO `t_console_role_permission` VALUES ('5', '1', '5', '2018-04-14 20:35:38');
INSERT INTO `t_console_role_permission` VALUES ('6', '1', '6', '2018-04-14 20:35:38');
INSERT INTO `t_console_role_permission` VALUES ('7', '1', '7', '2018-04-14 20:35:38');

-- ----------------------------
-- Table structure for t_console_user
-- ----------------------------
DROP TABLE IF EXISTS `t_console_user`;
CREATE TABLE `t_console_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `nick_name` varchar(100) DEFAULT NULL,
  `salt` varchar(100) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `mobile_no` varchar(50) DEFAULT NULL,
  `emp_code` varchar(50) DEFAULT NULL,
  `dept_code` varchar(50) DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  `active` char(1) DEFAULT NULL COMMENT '是否可用Y:N',
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_console_user
-- ----------------------------
INSERT INTO `t_console_user` VALUES ('1', 'admin', '88212F91E2E9CF36981A91B6C518AF5C', null, 'YWRtaW4=', null, null, null, null, null, 'Y', '2018-04-14 12:39:10', '2018-04-14 12:39:10');

-- ----------------------------
-- Table structure for t_console_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_console_user_role`;
CREATE TABLE `t_console_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_console_user_role
-- ----------------------------
INSERT INTO `t_console_user_role` VALUES ('1', '1', '1', '2018-04-14 20:12:08');
