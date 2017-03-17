/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : shiro

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2017-02-17 14:47:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for shiro_permission
-- ----------------------------
DROP TABLE IF EXISTS `shiro_permission`;
CREATE TABLE `shiro_permission` (
  `_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `permission_code` varchar(50) NOT NULL DEFAULT '' COMMENT '权限CODE',
  `permission_value` varchar(200) NOT NULL DEFAULT '' COMMENT '权限路径',
  `permission_name` varchar(200) NOT NULL DEFAULT '' COMMENT '权限名称',
  `permission_description` varchar(100) NOT NULL DEFAULT '' COMMENT '权限描述',
  `permission_status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '权限状态(1-有效; 2-无效)',
  `create_user` varchar(50) NOT NULL DEFAULT '' COMMENT '记录创建者的用户ID',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',
  `update_user` varchar(50) NOT NULL DEFAULT 'admin' COMMENT '最近更新该记录的用户',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录更新时间',
  `is_deleted` tinyint(4) NOT NULL DEFAULT '1' COMMENT '记录是否删除(1-正常; 2-已删除)',
  PRIMARY KEY (`_id`,`permission_code`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of shiro_permission
-- ----------------------------
INSERT INTO `shiro_permission` VALUES ('1', 'index', '/index.jsp', '首页', '访问首页', '1', 'admin', '2017-01-13 18:46:48', 'admin', '2017-02-08 14:10:02', '0');

-- ----------------------------
-- Table structure for shiro_role
-- ----------------------------
DROP TABLE IF EXISTS `shiro_role`;
CREATE TABLE `shiro_role` (
  `_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_code` varchar(50) NOT NULL DEFAULT '' COMMENT '角色CODE',
  `role_name` varchar(50) NOT NULL DEFAULT '' COMMENT '角色中文名称',
  `role_grade` int(11) NOT NULL DEFAULT '500' COMMENT '该字段暂定为角色等级(以100为梯度,数值越大等级越低,500为普通,100为管理员)',
  `role_description` varchar(100) NOT NULL DEFAULT '' COMMENT '角色描述',
  `role_validity` datetime NOT NULL DEFAULT '2200-12-31 23:59:59' COMMENT '角色有效期至',
  `role_status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '角色状态(1-有效; 2-冻结;)',
  `create_user` varchar(50) NOT NULL DEFAULT 'admin' COMMENT '记录创建者的用户',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',
  `update_user` varchar(50) NOT NULL DEFAULT 'admin' COMMENT '最近更新该记录的用户',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录最近变更时间',
  `is_deleted` tinyint(4) NOT NULL DEFAULT '1' COMMENT '记录是否被删除(1-正常; 2-已删除)',
  PRIMARY KEY (`_id`,`role_code`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of shiro_role
-- ----------------------------
INSERT INTO `shiro_role` VALUES ('1', 'NORMAL', '普通用户', '500', '测试角色', '2200-12-31 23:59:59', '1', 'admin', '2017-01-13 18:44:25', 'admin', '2017-02-08 14:09:51', '0');

-- ----------------------------
-- Table structure for shiro_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `shiro_role_permission`;
CREATE TABLE `shiro_role_permission` (
  `_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_code` varchar(50) NOT NULL DEFAULT '' COMMENT '角色CODE',
  `permission_code` varchar(50) NOT NULL DEFAULT '' COMMENT '权限CODE',
  `role_permission_description` varchar(200) NOT NULL DEFAULT '' COMMENT '角色权限对应关系描述',
  `role_permission_status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '角色权限对应关系状态(1-有效; 2-无效)',
  `create_user` varchar(50) NOT NULL DEFAULT '' COMMENT '记录创建者的用户ID',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',
  `update_user` varchar(50) NOT NULL DEFAULT 'admin' COMMENT '最近更新该记录的用户',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录最近更新时间',
  `is_deleted` tinyint(4) NOT NULL DEFAULT '1' COMMENT '记录是否删除(1-正常; 2-删除)',
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='角色权限对应关系表';

-- ----------------------------
-- Records of shiro_role_permission
-- ----------------------------
INSERT INTO `shiro_role_permission` VALUES ('1', 'NORMAL', 'index', '普通用户拥有访问首页的权限', '1', 'admin', '2017-01-13 18:47:45', 'admin', '2017-02-08 14:10:15', '0');

-- ----------------------------
-- Table structure for shiro_user
-- ----------------------------
DROP TABLE IF EXISTS `shiro_user`;
CREATE TABLE `shiro_user` (
  `_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_name_en` varchar(50) NOT NULL DEFAULT '' COMMENT '用户英文名',
  `user_name` varchar(50) NOT NULL DEFAULT '' COMMENT '用户姓名',
  `user_loginname` varchar(50) NOT NULL DEFAULT '' COMMENT '用户登录名(用户注册使用的手机号码或者邮箱)',
  `user_password` varchar(50) NOT NULL DEFAULT '' COMMENT '用户密码(密文)',
  `user_lastloginip` varchar(50) NOT NULL DEFAULT '' COMMENT '用户最后登录的IP地址',
  `user_lastlogintime` datetime NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '用户最后登录时间',
  `user_alias` varchar(255) NOT NULL DEFAULT '' COMMENT '用户别名(职称)',
  `user_status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '用户状态(1-有效; 2-无效)',
  `create_user` varchar(50) NOT NULL DEFAULT '' COMMENT '记录创建者的用户ID',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',
  `update_user` varchar(50) NOT NULL DEFAULT 'admin' COMMENT '最近更新该记录的用户',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录最近更新时间',
  `is_deleted` tinyint(4) NOT NULL DEFAULT '1' COMMENT '记录是否删除(1-正常; 2-删除)',
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of shiro_user
-- ----------------------------
INSERT INTO `shiro_user` VALUES ('1', 'leo.zeng', '曾珍荣', '18720909754', '123456', '', '2000-01-01 00:00:00', 'ABC', '', 'Java开发', '1', 'admin', '2017-01-13 18:33:48', 'admin', '2017-02-08 13:58:54', '0');

-- ----------------------------
-- Table structure for shiro_user_role
-- ----------------------------
DROP TABLE IF EXISTS `shiro_user_role`;
CREATE TABLE `shiro_user_role` (
  `_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '用户ID',
  `role_code` varchar(50) NOT NULL DEFAULT '' COMMENT '角色CODE',
  `user_role_description` varchar(200) NOT NULL DEFAULT '' COMMENT '用户角色对应描述',
  `user_role_status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '该用户角色对应记录状态(1-有效; 2-无效)',
  `create_user` varchar(50) NOT NULL DEFAULT '' COMMENT '记录创建者用户ID',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录创建时间',
  `update_user` varchar(50) NOT NULL DEFAULT 'admin' COMMENT '最近更新改记录的用户',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录最近更新时间',
  `is_deleted` tinyint(4) NOT NULL DEFAULT '1' COMMENT '记录是否删除(1-正常; 2-删除)',
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户角色对应关系表';

-- ----------------------------
-- Records of shiro_user_role
-- ----------------------------
INSERT INTO `shiro_user_role` VALUES ('1', '1', 'NORMAL', '用户ID[1]拥有普通用户权限', '1', 'admin', '2017-02-08 14:09:47', 'admin', '2017-02-08 14:09:47', '0');
