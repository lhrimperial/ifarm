/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : ifarm-console

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 15/04/2018 07:24:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_console_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_console_permission`;
CREATE TABLE `t_console_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `resource_id` int(11) NULL DEFAULT NULL,
  `permission` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_console_permission
-- ----------------------------
INSERT INTO `t_console_permission` VALUES (1, 1, 'ALL', '2018-04-14 20:33:22');
INSERT INTO `t_console_permission` VALUES (2, 2, 'ALL', '2018-04-14 20:33:22');
INSERT INTO `t_console_permission` VALUES (3, 3, 'ALL', '2018-04-14 20:33:22');
INSERT INTO `t_console_permission` VALUES (4, 4, 'ALL', '2018-04-14 20:33:22');
INSERT INTO `t_console_permission` VALUES (5, 5, 'ALL', '2018-04-14 20:33:22');
INSERT INTO `t_console_permission` VALUES (6, 6, 'ALL', '2018-04-14 20:33:22');
INSERT INTO `t_console_permission` VALUES (7, 7, 'ALL', '2018-04-14 20:33:22');

-- ----------------------------
-- Table structure for t_console_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_console_resource`;
CREATE TABLE `t_console_resource`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `resource_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `resource_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `entry_url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parent_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `resource_level` tinyint(4) NULL DEFAULT NULL,
  `resource_type` tinyint(4) NULL DEFAULT NULL,
  `display_order` tinyint(4) NULL DEFAULT NULL,
  `node_icon` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `notes` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `leaf_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `active` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `modify_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_console_resource
-- ----------------------------
INSERT INTO `t_console_resource` VALUES (1, 'console_1', 'console系统', NULL, NULL, 1, 1, 1, NULL, NULL, 'N', 'Y', '2018-04-14 19:55:02', '2018-04-14 19:55:05');
INSERT INTO `t_console_resource` VALUES (2, 'console_101', '综合管理', NULL, 'console_1', 2, 2, 1, 'el-icon-setting', NULL, 'N', 'Y', '2018-04-14 20:06:21', '2018-04-14 20:06:21');
INSERT INTO `t_console_resource` VALUES (3, 'console_102', '基础数据', NULL, 'console_1', 2, 2, 2, 'el-icon-menu', NULL, 'N', 'Y', '2018-04-14 20:06:21', '2018-04-14 20:06:21');
INSERT INTO `t_console_resource` VALUES (4, 'console_103', '系统设置', NULL, 'console_1', 2, 2, 3, 'el-icon-date', NULL, 'N', 'Y', '2018-04-14 20:06:21', '2018-04-14 20:06:21');
INSERT INTO `t_console_resource` VALUES (5, 'console_10201', '词条管理', NULL, 'console_102', 3, 3, 1, '', NULL, 'Y', 'Y', '2018-04-14 20:06:21', '2018-04-14 20:06:21');
INSERT INTO `t_console_resource` VALUES (6, 'console_10301', '用户管理', NULL, 'console_103', 3, 3, 1, '', NULL, 'Y', 'Y', '2018-04-14 20:06:21', '2018-04-14 20:06:21');
INSERT INTO `t_console_resource` VALUES (7, 'console_10302', '角色管理', NULL, 'console_103', 3, 3, 2, '', NULL, 'Y', 'Y', '2018-04-14 20:06:21', '2018-04-14 20:06:21');

-- ----------------------------
-- Table structure for t_console_role
-- ----------------------------
DROP TABLE IF EXISTS `t_console_role`;
CREATE TABLE `t_console_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `notes` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `active` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `modify_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_console_role
-- ----------------------------
INSERT INTO `t_console_role` VALUES (1, 'admin', 'admin', NULL, 'Y', '2018-04-14 20:12:16', '2018-04-14 20:12:19');

-- ----------------------------
-- Table structure for t_console_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_console_role_permission`;
CREATE TABLE `t_console_role_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NULL DEFAULT NULL,
  `permission_id` int(11) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_console_role_permission
-- ----------------------------
INSERT INTO `t_console_role_permission` VALUES (1, 1, 1, '2018-04-14 20:35:38');
INSERT INTO `t_console_role_permission` VALUES (2, 1, 2, '2018-04-14 20:35:38');
INSERT INTO `t_console_role_permission` VALUES (3, 1, 3, '2018-04-14 20:35:38');
INSERT INTO `t_console_role_permission` VALUES (4, 1, 4, '2018-04-14 20:35:38');
INSERT INTO `t_console_role_permission` VALUES (5, 1, 5, '2018-04-14 20:35:38');
INSERT INTO `t_console_role_permission` VALUES (6, 1, 6, '2018-04-14 20:35:38');
INSERT INTO `t_console_role_permission` VALUES (7, 1, 7, '2018-04-14 20:35:38');

-- ----------------------------
-- Table structure for t_console_user
-- ----------------------------
DROP TABLE IF EXISTS `t_console_user`;
CREATE TABLE `t_console_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nick_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `salt` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mobile_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `emp_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dept_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `notes` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `active` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否可用Y:N',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `modify_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_console_user
-- ----------------------------
INSERT INTO `t_console_user` VALUES (1, 'admin', '88212F91E2E9CF36981A91B6C518AF5C', NULL, 'YWRtaW4=', NULL, NULL, NULL, NULL, NULL, 'Y', '2018-04-14 12:39:10', '2018-04-14 12:39:10');

-- ----------------------------
-- Table structure for t_console_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_console_user_role`;
CREATE TABLE `t_console_user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_console_user_role
-- ----------------------------
INSERT INTO `t_console_user_role` VALUES (1, 1, 1, '2018-04-14 20:12:08');

SET FOREIGN_KEY_CHECKS = 1;
