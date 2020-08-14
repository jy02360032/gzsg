/*
Navicat MySQL Data Transfer

Source Server         : MySQL_Server3
Source Server Version : 80016
Source Host           : 192.168.0.110:3306
Source Database       : gzsg

Target Server Type    : MYSQL
Target Server Version : 80016
File Encoding         : 65001

Date: 2020-08-14 12:14:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for b_article
-- ----------------------------
DROP TABLE IF EXISTS `b_article`;
CREATE TABLE `b_article` (
  `id` int(11) NOT NULL COMMENT '文章主键',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章标题',
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文章作者',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '文章内容',
  `videourl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '视频地址',
  `category` int(11) DEFAULT NULL COMMENT '类别',
  `createdate` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `istop` int(11) DEFAULT '0' COMMENT '是否置顶',
  `isdel` int(11) DEFAULT '0' COMMENT '是否删除',
  `describes` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '描述',
  `last_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of b_article
-- ----------------------------

-- ----------------------------
-- Table structure for b_article_category
-- ----------------------------
DROP TABLE IF EXISTS `b_article_category`;
CREATE TABLE `b_article_category` (
  `id` int(11) NOT NULL COMMENT 'id主键',
  `articleid` int(11) DEFAULT NULL COMMENT '文章id',
  `filetype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文件类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of b_article_category
-- ----------------------------
INSERT INTO `b_article_category` VALUES ('2', '64', 'mp4');
INSERT INTO `b_article_category` VALUES ('3', '70', 'mp4');
INSERT INTO `b_article_category` VALUES ('4', '75', 'pdf');
INSERT INTO `b_article_category` VALUES ('5', '76', 'mp4');
INSERT INTO `b_article_category` VALUES ('6', '77', 'pdf');
INSERT INTO `b_article_category` VALUES ('7', '78', 'pdf');
INSERT INTO `b_article_category` VALUES ('8', '83', 'pdf');
INSERT INTO `b_article_category` VALUES ('9', '84', 'pdf');
INSERT INTO `b_article_category` VALUES ('10', '85', 'mp4');
INSERT INTO `b_article_category` VALUES ('11', '86', 'pdf');
INSERT INTO `b_article_category` VALUES ('12', '87', 'pdf');
INSERT INTO `b_article_category` VALUES ('13', '88', 'pdf');
INSERT INTO `b_article_category` VALUES ('14', '90', 'pdf');
INSERT INTO `b_article_category` VALUES ('15', '91', 'pdf');
INSERT INTO `b_article_category` VALUES ('17', '92', 'pdf');
INSERT INTO `b_article_category` VALUES ('18', '93', 'mp4');
INSERT INTO `b_article_category` VALUES ('19', '95', 'pdf');
INSERT INTO `b_article_category` VALUES ('20', '96', 'pdf');
INSERT INTO `b_article_category` VALUES ('21', '97', 'pdf');
INSERT INTO `b_article_category` VALUES ('22', '101', 'pdf');

-- ----------------------------
-- Table structure for b_book
-- ----------------------------
DROP TABLE IF EXISTS `b_book`;
CREATE TABLE `b_book` (
  `id` int(11) NOT NULL COMMENT '书籍ID',
  `bookname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '书籍名称',
  `bookdescript` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '书籍描述',
  `bookisdn` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '中图分类号',
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '作者',
  `publisher` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '出版商',
  `frequency` int(255) DEFAULT NULL COMMENT '借阅次数',
  `remark` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `bookisdn` (`bookisdn`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of b_book
-- ----------------------------

-- ----------------------------
-- Table structure for b_category
-- ----------------------------
DROP TABLE IF EXISTS `b_category`;
CREATE TABLE `b_category` (
  `id` int(11) NOT NULL COMMENT '文章类别主键',
  `category` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文章类别名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of b_category
-- ----------------------------
INSERT INTO `b_category` VALUES ('1', '新闻公告');
INSERT INTO `b_category` VALUES ('2', '动态要闻');
INSERT INTO `b_category` VALUES ('3', '活动资讯');
INSERT INTO `b_category` VALUES ('4', '十九大报告');
INSERT INTO `b_category` VALUES ('5', '法律');
INSERT INTO `b_category` VALUES ('6', '政策');
INSERT INTO `b_category` VALUES ('7', '科技');
INSERT INTO `b_category` VALUES ('8', '文化');
INSERT INTO `b_category` VALUES ('9', '理论');
INSERT INTO `b_category` VALUES ('10', '学习指南');
INSERT INTO `b_category` VALUES ('11', '\r\n在线答题');
INSERT INTO `b_category` VALUES ('12', '互动社区');

-- ----------------------------
-- Table structure for b_interaction
-- ----------------------------
DROP TABLE IF EXISTS `b_interaction`;
CREATE TABLE `b_interaction` (
  `id` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '讨论标题',
  `text` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '帖子内容',
  `cont` int(11) DEFAULT NULL COMMENT '点击计数器',
  `status` int(11) DEFAULT '0' COMMENT '是否置顶：是-1，否-0',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `userid` (`userid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of b_interaction
-- ----------------------------
INSERT INTO `b_interaction` VALUES ('2', '1', '2019-03-01 17:08:20', '防守打法防守打法防守打法防守打法防守打法防守打法防守打法防守打法防守打法防守打法防守打法防守打法防守打法防守打法', '              村上春树，村上春树，村上春树，村上春树，村上春树，村上春树，村上春树，村上春树，村上春树，村上春树，村上春树，村上春树，村上春树，村上春树，村上春树，村上春树，村上春树，村上春树，村上春树，村上春树，村上春树，村上春树，村上春树，村上春树，村上春树，村上春树，村上春树，村上春树，村上春树，村上春树，村上春树，村上春树，村上春树，村上春树，村上春树，村上春树，村上春树，村上春树，村上春树，村上春树，村上春树，村上春树，村上春树，村上春树，村上春树，村上春树，村上春树，村上春树，村上春树，村上春树。', null, '0');
INSERT INTO `b_interaction` VALUES ('5', '1', '2019-03-04 16:04:13', 'weh', 'wa4tgsejysjt', null, '1');
INSERT INTO `b_interaction` VALUES ('6', '1', '2019-03-05 12:47:51', 'wt43453', 'ehtnxxngn', null, '0');
INSERT INTO `b_interaction` VALUES ('7', '1', '2019-03-05 12:48:01', '4yjdmg', 'efcgmjhxdgnf', null, '0');
INSERT INTO `b_interaction` VALUES ('8', '1', '2019-03-05 12:48:09', '45ysryjmvfmkuyf', 'erhdjymdtuj', null, '0');
INSERT INTO `b_interaction` VALUES ('9', '1', '2019-03-05 12:48:44', 'gnxgdxgn xdgndb', 'wrgneg442535yws5ysw', '1', '0');
INSERT INTO `b_interaction` VALUES ('10', '1', '2019-03-05 12:49:33', 'eth35t', '35hrsgheshhhsth', null, '0');
INSERT INTO `b_interaction` VALUES ('11', '1', '2019-03-05 13:05:01', '神佛那个神佛那个神佛那个神佛那个', '神佛那个神佛那个神佛那个神佛那个神佛那个神佛那个神佛那个神佛那个神佛那个', null, '0');
INSERT INTO `b_interaction` VALUES ('12', '1', '2019-03-05 13:05:19', '推荐人页面的', '推荐人页面的推荐人页面的推荐人页面的推荐人页面的推荐人页面的', null, '0');
INSERT INTO `b_interaction` VALUES ('13', '1', '2019-03-05 13:05:27', '推荐人页面的', '推荐人页面的推荐人页面的推荐人页面的推荐人页面的推荐人页面的', '9', '0');
INSERT INTO `b_interaction` VALUES ('14', '1', '2019-03-05 13:05:37', '推荐人页面的推荐人页面的推荐人页面的推荐人页面的', '推荐人页面的推荐人页面的推荐人页面的推荐人页面的推荐人页面的推荐人页面的推荐人页面的推荐人页面的推荐人页面的推荐人页面的推荐人页面的', '27', '0');
INSERT INTO `b_interaction` VALUES ('16', '14', '2019-03-20 10:36:31', '测试互动社区2', '测试互动社区2', '3', '0');
INSERT INTO `b_interaction` VALUES ('17', '14', '2019-03-20 10:47:44', '测试互动社区3', '测试互动社区3', '18', '0');

-- ----------------------------
-- Table structure for b_interaction_reply
-- ----------------------------
DROP TABLE IF EXISTS `b_interaction_reply`;
CREATE TABLE `b_interaction_reply` (
  `id` int(11) NOT NULL,
  `userid` int(11) DEFAULT NULL COMMENT '用户ID',
  `interactionid` int(11) DEFAULT NULL,
  `reply` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '回复时间',
  `state` int(11) DEFAULT '0' COMMENT '审核状态，0，未审核，1，通过，2不通过',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of b_interaction_reply
-- ----------------------------
INSERT INTO `b_interaction_reply` VALUES ('3', '1', '2', 'sbgnbghn', '2019-03-04 18:25:33', '1');
INSERT INTO `b_interaction_reply` VALUES ('4', '1', '13', '测试回复内容。', '2019-03-05 15:40:03', '1');
INSERT INTO `b_interaction_reply` VALUES ('5', '1', '13', '34的善解人意的', '2019-03-05 15:41:32', '1');
INSERT INTO `b_interaction_reply` VALUES ('6', '1', '14', 'Arnold', '2019-03-05 15:57:34', '1');
INSERT INTO `b_interaction_reply` VALUES ('7', '2', '14', '回复测试测试', '2019-03-05 16:22:24', '1');
INSERT INTO `b_interaction_reply` VALUES ('8', '23', '9', 'gfsdgfsd ', '2019-03-19 16:25:46', '2');
INSERT INTO `b_interaction_reply` VALUES ('13', '14', '16', '测试回复1\r\n', '2019-03-20 10:36:48', '1');
INSERT INTO `b_interaction_reply` VALUES ('14', '14', '17', '回复测试', '2019-03-20 13:25:30', '0');
INSERT INTO `b_interaction_reply` VALUES ('15', '14', '17', '测试回复', '2019-03-27 14:55:38', '0');

-- ----------------------------
-- Table structure for b_lend
-- ----------------------------
DROP TABLE IF EXISTS `b_lend`;
CREATE TABLE `b_lend` (
  `id` int(11) NOT NULL COMMENT '借阅表主键',
  `bookid` int(11) DEFAULT NULL COMMENT '书籍ID',
  `lendtime` datetime DEFAULT NULL COMMENT '借出时间',
  `regaintime` datetime DEFAULT NULL COMMENT '收回时间',
  `remark` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `bookid` (`bookid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of b_lend
-- ----------------------------

-- ----------------------------
-- Table structure for b_menu
-- ----------------------------
DROP TABLE IF EXISTS `b_menu`;
CREATE TABLE `b_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单主键',
  `text` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名称',
  `href` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '连接地址',
  `Fatherid` int(11) DEFAULT NULL COMMENT '父节点ID',
  `authstr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '权限匹配字符串',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '图标',
  `last_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of b_menu
-- ----------------------------
INSERT INTO `b_menu` VALUES ('1', '基础信息维护', null, null, '', 'glyphicon glyphicon-wrench', '2019-04-29 12:45:13');
INSERT INTO `b_menu` VALUES ('2', '用户信息维护', '/userManager/userList.html', '1', '', 'glyphicon glyphicon-user', '2019-05-07 17:37:09');
INSERT INTO `b_menu` VALUES ('3', '权限信息维护', '/authManager/authList.html', '1', '', 'glyphicon glyphicon-cog', '2019-05-15 17:44:38');
INSERT INTO `b_menu` VALUES ('4', '内容管理', null, null, null, null, '2019-04-29 12:45:13');
INSERT INTO `b_menu` VALUES ('5', '文章内容管理', '/articleManager/articleList.html', '4', '/articleManager/**', 'glyphicon glyphicon-file', '2019-04-29 12:45:13');
INSERT INTO `b_menu` VALUES ('6', '学习中心', null, null, null, null, '2019-04-29 12:45:13');
INSERT INTO `b_menu` VALUES ('7', '在线答题', '/testquestionManager/testquestionList.html', '6', '/testquestionManager/**', 'glyphicon glyphicon-question-sign', '2019-04-29 12:45:13');
INSERT INTO `b_menu` VALUES ('8', '互动社区', '/interactionManager/interactionList.html', '4', '/interactionManager/**', 'glyphicon glyphicon-comment', '2019-04-29 12:45:13');
INSERT INTO `b_menu` VALUES ('9', '查看', 'authNode', '2', '/userManager/userList*', 'glyphicon glyphicon-search', '2019-05-15 17:37:19');
INSERT INTO `b_menu` VALUES ('10', '添加', 'authNode', '2', '/userManager/userAdd*', 'glyphicon glyphicon-plus', '2019-05-11 16:29:20');
INSERT INTO `b_menu` VALUES ('11', '修改', 'authNode', '2', '/userManager/userUpdate*', 'glyphicon glyphicon-edit', '2019-05-11 16:29:24');
INSERT INTO `b_menu` VALUES ('12', '删除', 'authNode', '2', '/userManager/userDel*', 'glyphicon glyphicon-remove', '2019-05-15 17:37:15');
INSERT INTO `b_menu` VALUES ('13', '查看', 'authNode', '3', '/authManager/authList*', 'glyphicon glyphicon-search', '2019-05-15 17:39:06');
INSERT INTO `b_menu` VALUES ('14', '添加', 'authNode', '3', '/authManager/authAdd*', 'glyphicon glyphicon-plus', '2019-05-15 17:39:10');
INSERT INTO `b_menu` VALUES ('15', '修改', 'authNode', '3', '/authManager/authUpdate*', 'glyphicon glyphicon-edit', '2019-05-15 17:39:13');
INSERT INTO `b_menu` VALUES ('16', '删除', 'authNode', '3', '/authManager/authDel*', 'glyphicon glyphicon-remove', '2019-05-15 17:39:41');

-- ----------------------------
-- Table structure for b_role
-- ----------------------------
DROP TABLE IF EXISTS `b_role`;
CREATE TABLE `b_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限主键',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '权限名称',
  `text` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '权限说明',
  `remark` text COMMENT '备注',
  `last_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `name` (`name`) USING BTREE,
  UNIQUE KEY `text` (`text`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of b_role
-- ----------------------------
INSERT INTO `b_role` VALUES ('1', 'ROLE_ADMIN', '管理员', '', '2019-05-17 14:55:30');
INSERT INTO `b_role` VALUES ('2', 'ROLE_USER', '用户', '', '2019-11-27 14:45:14');
INSERT INTO `b_role` VALUES ('3', 'ROLE_11931', '角色-梁雪峰-C', '专门为梁雪峰个人设置的角色-U', '2019-05-17 12:52:33');

-- ----------------------------
-- Table structure for b_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `b_role_menu`;
CREATE TABLE `b_role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `roleid` int(11) NOT NULL COMMENT '权限ID',
  `menuid` int(11) NOT NULL COMMENT '菜单ID',
  `last_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `roleid` (`roleid`) USING BTREE,
  KEY `menuid` (`menuid`) USING BTREE,
  CONSTRAINT `b_role_menu_ibfk_1` FOREIGN KEY (`roleid`) REFERENCES `b_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `b_role_menu_ibfk_2` FOREIGN KEY (`menuid`) REFERENCES `b_menu` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of b_role_menu
-- ----------------------------
INSERT INTO `b_role_menu` VALUES ('26', '3', '4', '2019-05-17 12:52:44');
INSERT INTO `b_role_menu` VALUES ('27', '3', '3', '2019-05-17 12:52:44');
INSERT INTO `b_role_menu` VALUES ('28', '3', '1', '2019-05-17 12:52:44');
INSERT INTO `b_role_menu` VALUES ('29', '3', '16', '2019-05-17 12:52:44');
INSERT INTO `b_role_menu` VALUES ('30', '3', '15', '2019-05-17 12:52:44');
INSERT INTO `b_role_menu` VALUES ('31', '3', '14', '2019-05-17 12:52:44');
INSERT INTO `b_role_menu` VALUES ('32', '3', '13', '2019-05-17 12:52:44');
INSERT INTO `b_role_menu` VALUES ('33', '3', '8', '2019-05-17 12:52:44');
INSERT INTO `b_role_menu` VALUES ('34', '3', '5', '2019-05-17 12:52:44');
INSERT INTO `b_role_menu` VALUES ('63', '1', '2', '2019-06-17 17:10:58');
INSERT INTO `b_role_menu` VALUES ('64', '1', '1', '2019-06-17 17:10:58');
INSERT INTO `b_role_menu` VALUES ('65', '1', '16', '2019-06-17 17:10:58');
INSERT INTO `b_role_menu` VALUES ('66', '1', '15', '2019-06-17 17:10:58');
INSERT INTO `b_role_menu` VALUES ('67', '1', '14', '2019-06-17 17:10:58');
INSERT INTO `b_role_menu` VALUES ('68', '1', '13', '2019-06-17 17:10:58');
INSERT INTO `b_role_menu` VALUES ('69', '1', '12', '2019-06-17 17:10:58');
INSERT INTO `b_role_menu` VALUES ('70', '1', '11', '2019-06-17 17:10:58');
INSERT INTO `b_role_menu` VALUES ('71', '1', '10', '2019-06-17 17:10:58');
INSERT INTO `b_role_menu` VALUES ('72', '1', '9', '2019-06-17 17:10:58');
INSERT INTO `b_role_menu` VALUES ('73', '1', '3', '2019-06-17 17:10:58');
INSERT INTO `b_role_menu` VALUES ('91', '2', '2', '2019-12-04 12:14:16');
INSERT INTO `b_role_menu` VALUES ('92', '2', '1', '2019-12-04 12:14:16');
INSERT INTO `b_role_menu` VALUES ('93', '2', '10', '2019-12-04 12:14:16');
INSERT INTO `b_role_menu` VALUES ('94', '2', '9', '2019-12-04 12:14:16');

-- ----------------------------
-- Table structure for b_sequence
-- ----------------------------
DROP TABLE IF EXISTS `b_sequence`;
CREATE TABLE `b_sequence` (
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `current_value` int(11) NOT NULL,
  `increment` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of b_sequence
-- ----------------------------
INSERT INTO `b_sequence` VALUES ('b_article', '102', '1');
INSERT INTO `b_sequence` VALUES ('b_menu', '12', '1');
INSERT INTO `b_sequence` VALUES ('b_permission', '2', '1');
INSERT INTO `b_sequence` VALUES ('b_role', '2', '1');
INSERT INTO `b_sequence` VALUES ('b_role_menu', '7', '1');
INSERT INTO `b_sequence` VALUES ('b_user', '37', '1');
INSERT INTO `b_sequence` VALUES ('b_user_role', '203', '1');

-- ----------------------------
-- Table structure for b_testpaper
-- ----------------------------
DROP TABLE IF EXISTS `b_testpaper`;
CREATE TABLE `b_testpaper` (
  `id` int(11) NOT NULL COMMENT '试卷主键',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '试卷题目',
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '作者',
  `createdate` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifydate` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `istop` int(11) DEFAULT '0' COMMENT '是否置顶',
  `isdel` int(11) DEFAULT '0' COMMENT '是否删除',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of b_testpaper
-- ----------------------------
INSERT INTO `b_testpaper` VALUES ('1', '试题1', '试题1', '2019-03-05 11:53:23', '2019-03-06 10:37:59', '0', '0', '试卷简介');
INSERT INTO `b_testpaper` VALUES ('2', 'aaa1', null, '2019-03-06 16:13:55', '2019-03-06 16:13:55', '0', '0', 'aaa');
INSERT INTO `b_testpaper` VALUES ('3', 'aaa2', null, '2019-03-06 16:14:32', '2019-03-06 16:14:32', '0', '0', 'aaa');
INSERT INTO `b_testpaper` VALUES ('4', 'aaa3', null, '2019-03-06 16:16:09', '2019-03-06 16:16:09', '0', '0', 'aaa');
INSERT INTO `b_testpaper` VALUES ('5', 'aaa4', null, '2019-03-06 16:19:19', '2019-03-06 16:19:19', '0', '0', 'aaa');
INSERT INTO `b_testpaper` VALUES ('6', 'aaa5', null, '2019-03-06 16:22:50', '2019-03-06 16:22:50', '0', '0', 'aaa');
INSERT INTO `b_testpaper` VALUES ('7', 'aaa6', null, '2019-03-07 09:29:53', '2019-03-07 09:29:53', '0', '0', 'aaa');
INSERT INTO `b_testpaper` VALUES ('8', 'aaa7', null, '2019-03-07 10:46:56', '2019-03-07 12:17:16', '0', '1', 'aaa');
INSERT INTO `b_testpaper` VALUES ('9', 'aaaaaa8', null, '2019-03-07 12:36:13', '2019-03-19 17:17:50', '0', '0', 'aaaaaa');
INSERT INTO `b_testpaper` VALUES ('10', '测试标题3', null, '2019-03-19 16:31:12', '2019-03-19 16:31:12', '0', '0', '测试简介3');

-- ----------------------------
-- Table structure for b_testquestion
-- ----------------------------
DROP TABLE IF EXISTS `b_testquestion`;
CREATE TABLE `b_testquestion` (
  `id` int(11) NOT NULL COMMENT '试题主键',
  `subject` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '题目',
  `optionA` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '选项A',
  `optionB` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '选项B',
  `optionC` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '选项C',
  `optionD` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '选项D',
  `rightkey` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '正确答案',
  `pid` int(11) DEFAULT NULL COMMENT '所属试卷id',
  `isdel` int(11) DEFAULT '0' COMMENT '是否删除',
  `score` int(11) DEFAULT NULL COMMENT '题目分数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of b_testquestion
-- ----------------------------
INSERT INTO `b_testquestion` VALUES ('1', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', '选项b', '选项c', '选项d', 'A', '1', '0', null);
INSERT INTO `b_testquestion` VALUES ('2', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', 'optionB', 'optionC', 'optionD', 'B', '8', '0', null);
INSERT INTO `b_testquestion` VALUES ('3', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', 'optionB', 'optionC', 'optionD', 'C', '1', '0', null);
INSERT INTO `b_testquestion` VALUES ('4', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', 'optionB', 'optionC', 'optionD', 'D', '1', '0', null);
INSERT INTO `b_testquestion` VALUES ('5', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', 'optionB', 'optionC', 'optionD', 'D', '5', '0', null);
INSERT INTO `b_testquestion` VALUES ('6', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', 'optionB', 'optionC', 'optionD', 'B', '6', '0', null);
INSERT INTO `b_testquestion` VALUES ('7', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', 'optionB', 'optionC', 'optionDd', 'B', '6', '0', null);
INSERT INTO `b_testquestion` VALUES ('8', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', 'optionB', 'optionC', 'optionD', 'B', '6', '0', null);
INSERT INTO `b_testquestion` VALUES ('9', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', 'optionB', 'optionC', 'optionD', 'C', '6', '0', null);
INSERT INTO `b_testquestion` VALUES ('10', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', 'optionB', 'optionC', 'optionD', 'C', '6', '0', null);
INSERT INTO `b_testquestion` VALUES ('11', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', '选项B', '选项C', '选项D', 'B', '6', '0', null);
INSERT INTO `b_testquestion` VALUES ('12', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', '选项B', '选项C', '选项D', 'B', '7', '0', null);
INSERT INTO `b_testquestion` VALUES ('13', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', '选项B', '选项C', '选项D', 'A', '7', '0', null);
INSERT INTO `b_testquestion` VALUES ('14', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', '选项B', '选项C', '选项D', 'A', '7', '0', null);
INSERT INTO `b_testquestion` VALUES ('15', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', '选项B', '选项C', '选项D', 'B', '6', '0', null);
INSERT INTO `b_testquestion` VALUES ('16', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', '选项B', '选项C', '选项D', 'C', '6', '0', null);
INSERT INTO `b_testquestion` VALUES ('17', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', '选项B', '选项C', '选项D', 'B', '6', '0', null);
INSERT INTO `b_testquestion` VALUES ('18', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', '选项B', '选项C', '选项D', 'B', '6', '0', null);
INSERT INTO `b_testquestion` VALUES ('19', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', '选项B', '选项C', '选项D', 'D', '6', '0', null);
INSERT INTO `b_testquestion` VALUES ('20', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', '选项B', '选项C', '选项D', 'D', '6', '0', null);
INSERT INTO `b_testquestion` VALUES ('21', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', '选项B', '选项C', '选项D', 'B', '7', '0', null);
INSERT INTO `b_testquestion` VALUES ('22', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', '选项B', '选项C', '选项D', 'B', '7', '0', null);
INSERT INTO `b_testquestion` VALUES ('23', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', '选项B', '选项C', '选项D', 'A', '7', '0', null);
INSERT INTO `b_testquestion` VALUES ('24', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', '选项B', '选项C', '选项D', 'D', '7', '0', null);
INSERT INTO `b_testquestion` VALUES ('25', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', '选项B', '选项C', '选项D', 'C', '7', '0', null);
INSERT INTO `b_testquestion` VALUES ('26', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', '选项B', '选项C', '选项D', 'B', '7', '0', null);
INSERT INTO `b_testquestion` VALUES ('27', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', '选项B', '选项C', '选项D', 'C', '7', '0', null);
INSERT INTO `b_testquestion` VALUES ('28', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', '选项B', '选项C', '选项D', 'A', '7', '0', null);
INSERT INTO `b_testquestion` VALUES ('29', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', '选项B', '选项C', '选项D', 'B', '7', '0', null);
INSERT INTO `b_testquestion` VALUES ('30', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', '选项B', '选项C', '选项D', 'C', '7', '0', null);
INSERT INTO `b_testquestion` VALUES ('31', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', '选项B', '选项C', '选项D', 'B', '7', '0', null);
INSERT INTO `b_testquestion` VALUES ('32', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', '选项B', '选项C', '选项D', 'B', '7', '0', null);
INSERT INTO `b_testquestion` VALUES ('33', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', '选项B', '选项C', '选项D', '', '7', '0', null);
INSERT INTO `b_testquestion` VALUES ('34', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', '选项B', '选项C', '选项D', '', '7', '0', null);
INSERT INTO `b_testquestion` VALUES ('35', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', '选项B', '选项C', '选项D', '', '7', '0', null);
INSERT INTO `b_testquestion` VALUES ('36', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', '选项B', '选项C', '选项D', 'B', '7', '0', null);
INSERT INTO `b_testquestion` VALUES ('37', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', '选项B', '选项C', '选项D', 'B', '7', '0', null);
INSERT INTO `b_testquestion` VALUES ('38', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', '选项B', '选项C', '选项D', 'C', '7', '0', null);
INSERT INTO `b_testquestion` VALUES ('39', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', '选项B', '选项C', '选项D', 'C', '7', '0', null);
INSERT INTO `b_testquestion` VALUES ('40', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', '选项B', '选项C', '选项D', 'A', '6', '0', null);
INSERT INTO `b_testquestion` VALUES ('41', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', '选项B', '选项C', '选项D', 'B', '6', '0', null);
INSERT INTO `b_testquestion` VALUES ('42', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', '选项B', '选项C', '选项D', 'C', '6', '0', null);
INSERT INTO `b_testquestion` VALUES ('43', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', '选项B', '选项C', '选项D', 'D', '6', '0', null);
INSERT INTO `b_testquestion` VALUES ('44', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', 'a选项A', '选项B', '选项C', '选项D', 'D', '6', '0', null);
INSERT INTO `b_testquestion` VALUES ('45', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', 'a选项A', '选项B', '选项C', '选项D', 'B', '6', '0', null);
INSERT INTO `b_testquestion` VALUES ('46', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', 'a选项A', '选项B', '选项C', '选项D', 'D', '6', '0', null);
INSERT INTO `b_testquestion` VALUES ('47', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', 'a选项A', '选项B', '选项C', '选项D', 'B', '6', '0', null);
INSERT INTO `b_testquestion` VALUES ('48', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', 'a选项A', '选项B', '选项C', '选项D', 'D', '1', '0', null);
INSERT INTO `b_testquestion` VALUES ('49', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', 'a选项A', '选项B', '选项C', '选项D', 'D', '1', '0', null);
INSERT INTO `b_testquestion` VALUES ('50', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', 'a选项A', '选项B', '选项C', '选项D', 'D', '1', '0', null);
INSERT INTO `b_testquestion` VALUES ('51', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', 'a选项A', '选项B', '选项C', '选项D', 'D', '1', '0', null);
INSERT INTO `b_testquestion` VALUES ('52', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', 'a选项A', '选项B', '选项C', '选项D', 'D', '1', '0', null);
INSERT INTO `b_testquestion` VALUES ('53', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', 'a选项A', '选项B', '选项C', '选项D', 'B', '1', '0', null);
INSERT INTO `b_testquestion` VALUES ('54', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', 'a选项A', '选项B', '选项C', '选项D', 'B', '1', '0', null);
INSERT INTO `b_testquestion` VALUES ('55', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', 'a选项A', '选项B', '选项C', '选项D', 'B', '1', '0', null);
INSERT INTO `b_testquestion` VALUES ('56', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', 'a选项A', '选项B', '选项C', '选项D', 'C', '1', '0', null);
INSERT INTO `b_testquestion` VALUES ('57', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', 'a选项A', '选项B', '选项C', '选项D', 'B', '5', '0', null);
INSERT INTO `b_testquestion` VALUES ('58', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', 'a选项A', '选项B', '选项C', '选项D', 'B', '5', '0', null);
INSERT INTO `b_testquestion` VALUES ('59', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', '选项B', '选项C', '选项D', 'B', '5', '0', null);
INSERT INTO `b_testquestion` VALUES ('60', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', '选项B', '选项C', '选项D', 'B', '5', '0', null);
INSERT INTO `b_testquestion` VALUES ('61', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', '选项B', '选项C', '选项D', 'D', '5', '0', null);
INSERT INTO `b_testquestion` VALUES ('62', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', '选项B', '选项C', '选项D', 'B', '5', '0', null);
INSERT INTO `b_testquestion` VALUES ('63', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', '选项B', '选项C', '选项D', 'B', '5', '0', null);
INSERT INTO `b_testquestion` VALUES ('64', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', '选项B', '选项C', '选项D', 'B', '5', '0', null);
INSERT INTO `b_testquestion` VALUES ('65', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', '选项B', '选项C', '选项D', 'C', '8', '0', null);
INSERT INTO `b_testquestion` VALUES ('66', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', '选项B', '选项C', '选项D', 'B', '8', '0', null);
INSERT INTO `b_testquestion` VALUES ('67', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', '选项B', '选项C', '选项D', 'B', '8', '0', null);
INSERT INTO `b_testquestion` VALUES ('68', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', '选项B', '选项C', '选项D', 'B', '8', '0', null);
INSERT INTO `b_testquestion` VALUES ('69', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', '选项B', '选项C', '选项D', 'B', '8', '0', null);
INSERT INTO `b_testquestion` VALUES ('70', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', '选项B', '选项C', '选项D', 'B', '8', '0', null);
INSERT INTO `b_testquestion` VALUES ('71', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', '选项B', '选项C', '选项D', 'A', '8', '0', null);
INSERT INTO `b_testquestion` VALUES ('72', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', '选项B', '选项C', '选项D', 'B', '8', '0', null);
INSERT INTO `b_testquestion` VALUES ('73', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', '选项B', '选项C', '选项D', 'B', '8', '0', null);
INSERT INTO `b_testquestion` VALUES ('74', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', '选项B', '选项C', '选项D', 'B', '8', '0', null);
INSERT INTO `b_testquestion` VALUES ('75', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', '选项B', '选项C', '选项D', 'A', '8', '0', null);
INSERT INTO `b_testquestion` VALUES ('76', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', '选项B', '选项C', '选项D', 'B', '9', '0', null);
INSERT INTO `b_testquestion` VALUES ('77', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', '选项B', '选项C', '选项D', 'D', '9', '0', null);
INSERT INTO `b_testquestion` VALUES ('78', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', '选项B', '选项C', '选项D', 'D', '9', '0', null);
INSERT INTO `b_testquestion` VALUES ('79', '测试试题测试试题测试试题测试试题测试试题测试试题测试试题测试试题', '选项A', '选项B', '选项C', '选项D', 'B', '9', '0', null);
INSERT INTO `b_testquestion` VALUES ('80', 'aaa', 'a', 'b', 'c', 'd', 'B', '10', '0', null);
INSERT INTO `b_testquestion` VALUES ('81', 'aaa', 'a', 'b', 'c', 'd', 'C', '10', '0', null);

-- ----------------------------
-- Table structure for b_user
-- ----------------------------
DROP TABLE IF EXISTS `b_user`;
CREATE TABLE `b_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户主键',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户中文名称',
  `tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '联系方式',
  `enable` enum('启用','禁用') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '启用' COMMENT '是否可用',
  `createdate` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `mail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮箱',
  `file` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '头像',
  `delete` int(255) NOT NULL DEFAULT '0' COMMENT '删除标记：0未删除，1已删除',
  `last_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of b_user
-- ----------------------------
INSERT INTO `b_user` VALUES ('1', 'admin', '$2a$10$C2XGSol3TrglsYc3khpfcuF62uJndA1T9Is8Qxv3LdhRiFZhcj6CK', '梁雪峰', '18626933292', '启用', '2019-01-16 00:00:00', '1234@qq.com', '1551855346938微信截图_20190306144610.png', '0', '2019-05-17 13:56:48');
INSERT INTO `b_user` VALUES ('2', 'user', '$2a$10$C2XGSol3TrglsYc3khpfcuF62uJndA1T9Is8Qxv3LdhRiFZhcj6CK', '用户', '18709118932', '启用', '2019-01-16 00:00:00', '1234@qq.com', '1551855620445微信截图_20190306144610.png', '0', '2019-05-15 14:45:28');
INSERT INTO `b_user` VALUES ('9', 'aaaaaaaaaa', null, '梁雪峰', '1223321221', '启用', '2019-05-03 20:33:42', '12we4@qq.com', null, '0', '2019-05-15 14:45:28');
INSERT INTO `b_user` VALUES ('12', 'wukong', '$2a$10$TYPK925fBXnELsfmkKEfquwaIvbR4jX7DQelnGAIDSj7WVyX4FQMO', '悟空', '15754367366', '启用', '2019-02-21 17:23:43', '1234@qq.com', null, '0', '2019-05-15 14:45:28');
INSERT INTO `b_user` VALUES ('13', 'bajie', '$2a$10$TegZa6SgNQ1d0SN/WdO.vudpXNp9k3ETpgs3ygO64I4U2ldu7d/ai', '八戒', '12345878787', '启用', '2019-02-21 17:24:38', '1234@qq.com', null, '0', '2019-05-15 14:45:28');
INSERT INTO `b_user` VALUES ('14', 'aaaaa1', '$2a$10$nIte89MhGuwzD7uhXSSXoe5er9dwVbdx.IGVVIiRW7TmOI4lxDgQ.', 'aaa1', '123', '启用', '2019-02-22 09:32:50', '1234@qq.com', '1553675425166测试图片1.PNG', '0', '2019-05-15 14:45:28');
INSERT INTO `b_user` VALUES ('15', 'aaaaa4', '$2a$10$u7ny0CDS62BdSKUq1Hy0deopZ283.jrY50MOpoMyPAGBGSvDlljIG', 'aaaaa4', '123', '启用', '2019-02-22 09:34:23', '1234@qq.com', null, '0', '2019-05-15 14:45:28');
INSERT INTO `b_user` VALUES ('16', 'aaaaaa2', '$2a$10$abiFZNrHRyiXpoxt4SFXouuW4BjcDNeg1BYogbNOxA/O6ez9Z/Gki', 'aaa2', '123', '启用', '2019-02-22 09:35:43', '1234@qq.com', null, '0', '2019-05-15 14:45:28');
INSERT INTO `b_user` VALUES ('17', 'aaaaaa5', '$2a$10$EDw4nbFGqc5RoJK2VzB2ROwMf5uC.wz2RhOlbjmfopDeP2fGDwESO', 'aaa5', '123', '启用', '2019-02-22 09:36:54', '1234@qq.com', null, '0', '2019-05-15 14:45:28');
INSERT INTO `b_user` VALUES ('18', 'bfdrg', '', '5rsn', 'hyrn', '启用', '2019-02-26 18:08:08', '123667777777@qq.com', null, '0', '2019-05-15 14:45:28');
INSERT INTO `b_user` VALUES ('19', 'dftikjbkcfyjk', '$2a$10$6S4Y7pzwgMbOfVTOWiJOgu2tmLvX39xX5bRwOr1DoP9yzVDvuFrq2', '547d', '4d6uiyl', '启用', '2019-02-26 18:08:35', '123@qq.com', null, '0', '2019-05-15 14:45:28');
INSERT INTO `b_user` VALUES ('20', 'admin1', '$2a$10$C2XGSol3TrglsYc3khpfcuF62uJndA1T9Is8Qxv3LdhRiFZhcj6CK', 'ersbtrn', null, '启用', '2019-02-27 13:56:51', '12223@qq.com', null, '0', '2019-05-15 14:45:28');
INSERT INTO `b_user` VALUES ('21', 'admin2', '$2a$10$ws5LfxvD6/1yKj0wtAL8Xu5kowfGi6oFxmJzNrQLxH4tR9YJKjvy6', '', '', '启用', '2019-02-27 13:58:09', '123321@qq.com', null, '0', '2019-12-04 12:13:52');
INSERT INTO `b_user` VALUES ('22', 'adm123', '$2a$10$03vAjsmuYCzFMS79Zek.SuJacETD9WoCGo45pkNRL7JHaLhfidQtK', '测试1', '123456789', '启用', '2019-03-19 16:24:36', '123456@qq.com', null, '0', '2019-05-15 14:45:28');
INSERT INTO `b_user` VALUES ('23', 'suzhan', '$2a$10$KrUSHIeFQZuDvmIXp0QQj.V8wGIewu5j9M8eFL9Z1XFA/DUgvYvhO', '苏展', '15754367386', '启用', '2019-03-19 16:25:15', '594256854@qq.com', null, '0', '2019-05-15 14:45:28');
INSERT INTO `b_user` VALUES ('24', 'admin3', '$2a$10$l.2kTmKD7/wU6HdKba/LDeCob1Hc7RpREkSCBXb/CkkBMod1LyeyS', 'admin3', '123', '启用', '2019-03-19 16:30:04', '123456@qq.com', null, '0', '2019-05-15 14:45:28');
INSERT INTO `b_user` VALUES ('25', '测试aaa1', '$2a$10$Zc4rBZWuKMU0cwyEHHDVf.lFMaU9RbVOnAhIgHDecLASIG.hrCR0C', '测试aaa1', '123456', '启用', '2019-03-20 08:44:47', '123456@qq.com', null, '0', '2019-11-27 14:44:56');
INSERT INTO `b_user` VALUES ('26', '测试aaa2', '$2a$10$97jc4Kw3RKWRpan3kBK2CesyQyFKuAUjrDx0hzqEpZR6h.AVgheDu', '测试aaa2', '12356', '启用', '2019-03-20 16:37:00', '123456@qq.com', null, '0', '2019-05-15 14:45:28');
INSERT INTO `b_user` VALUES ('28', 'admin123', '$2a$10$kw650G4DfGuiJeP9xzFDZe8hGJti1AnQGwpL.myiPQdiv/YSi6oZi', 'aaa1', '123', '启用', '2019-03-27 13:24:58', '12345@qq.com', null, '0', '2019-05-15 14:45:28');
INSERT INTO `b_user` VALUES ('37', 'Adminssc', '$2a$10$FvreHH.2XLQKEygwvFaZteXw7WDpNQOdyKJ69/0xkw5djUjWRr9fW', '连续性', '', '启用', '2019-05-07 17:51:27', '', null, '0', '2019-05-15 14:45:28');
INSERT INTO `b_user` VALUES ('38', '插入用户尝试', '$2a$10$4rP8ZHxSxY6knitFhiL6vO9xb0FwO2Sr6TvH862GcrIoV4cnOHwk.', '梁雪峰', '', '启用', '2019-05-09 14:40:01', '', null, '0', '2019-05-15 14:45:28');

-- ----------------------------
-- Table structure for b_userconnection
-- ----------------------------
DROP TABLE IF EXISTS `b_userconnection`;
CREATE TABLE `b_userconnection` (
  `userId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `providerId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `providerUserId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `rank` int(255) NOT NULL,
  `displayName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `profileUrl` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `imageUrl` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `accessToken` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `secret` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `refreshToken` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `expireTime` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`userId`,`providerId`,`providerUserId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of b_userconnection
-- ----------------------------

-- ----------------------------
-- Table structure for b_user_role
-- ----------------------------
DROP TABLE IF EXISTS `b_user_role`;
CREATE TABLE `b_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户权限关联表',
  `userid` int(11) DEFAULT NULL COMMENT '用户ID',
  `roleid` int(11) DEFAULT NULL COMMENT '权限ID',
  `last_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `userid` (`userid`) USING BTREE,
  KEY `roleid` (`roleid`) USING BTREE,
  CONSTRAINT `b_user_role_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `b_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `b_user_role_ibfk_2` FOREIGN KEY (`roleid`) REFERENCES `b_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=240 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of b_user_role
-- ----------------------------
INSERT INTO `b_user_role` VALUES ('7', '9', '2', '2019-04-29 12:44:06');
INSERT INTO `b_user_role` VALUES ('14', '13', '2', '2019-04-29 12:44:06');
INSERT INTO `b_user_role` VALUES ('15', '12', '2', '2019-04-29 12:44:06');
INSERT INTO `b_user_role` VALUES ('18', '15', '2', '2019-04-29 12:44:06');
INSERT INTO `b_user_role` VALUES ('19', '16', '2', '2019-04-29 12:44:06');
INSERT INTO `b_user_role` VALUES ('20', '17', '2', '2019-04-29 12:44:06');
INSERT INTO `b_user_role` VALUES ('23', '19', '2', '2019-04-29 12:44:06');
INSERT INTO `b_user_role` VALUES ('28', '23', '2', '2019-04-29 12:44:06');
INSERT INTO `b_user_role` VALUES ('32', '22', '2', '2019-04-29 12:44:06');
INSERT INTO `b_user_role` VALUES ('33', '2', '1', '2019-05-06 12:22:16');
INSERT INTO `b_user_role` VALUES ('40', '26', '2', '2019-04-29 12:44:06');
INSERT INTO `b_user_role` VALUES ('118', '28', '2', '2019-04-29 12:44:06');
INSERT INTO `b_user_role` VALUES ('193', '14', '1', '2019-04-29 12:44:06');
INSERT INTO `b_user_role` VALUES ('194', '14', '2', '2019-04-29 12:44:06');
INSERT INTO `b_user_role` VALUES ('195', '14', '1', '2019-04-29 12:44:06');
INSERT INTO `b_user_role` VALUES ('196', '14', '2', '2019-04-29 12:44:06');
INSERT INTO `b_user_role` VALUES ('197', '14', '1', '2019-04-29 12:44:06');
INSERT INTO `b_user_role` VALUES ('198', '14', '2', '2019-04-29 12:44:06');
INSERT INTO `b_user_role` VALUES ('199', '14', '1', '2019-04-29 12:44:06');
INSERT INTO `b_user_role` VALUES ('200', '14', '2', '2019-04-29 12:44:06');
INSERT INTO `b_user_role` VALUES ('203', '37', '1', '2019-05-07 17:51:27');
INSERT INTO `b_user_role` VALUES ('204', '38', '1', '2019-05-09 14:40:42');
INSERT INTO `b_user_role` VALUES ('207', '18', '2', '2019-05-12 16:42:15');
INSERT INTO `b_user_role` VALUES ('212', '1', '1', '2019-05-15 11:26:32');
INSERT INTO `b_user_role` VALUES ('213', '1', '2', '2019-05-15 11:26:32');
INSERT INTO `b_user_role` VALUES ('214', '24', '1', '2019-05-22 16:45:28');
INSERT INTO `b_user_role` VALUES ('215', '24', '2', '2019-05-22 16:45:28');
INSERT INTO `b_user_role` VALUES ('238', '25', '2', '2019-11-27 14:44:56');
INSERT INTO `b_user_role` VALUES ('239', '21', '2', '2019-12-04 12:13:53');

-- ----------------------------
-- Table structure for b_user_score
-- ----------------------------
DROP TABLE IF EXISTS `b_user_score`;
CREATE TABLE `b_user_score` (
  `id` int(11) NOT NULL COMMENT '答题结果主键',
  `userid` int(11) DEFAULT NULL COMMENT '用户id',
  `testpageid` int(11) DEFAULT NULL COMMENT '试卷id',
  `score` int(11) DEFAULT NULL COMMENT '试卷得分',
  `createdate` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of b_user_score
-- ----------------------------
INSERT INTO `b_user_score` VALUES ('1', '14', '9', '0', '2019-03-12 10:17:42');
INSERT INTO `b_user_score` VALUES ('2', '14', '9', '2', '2019-03-12 10:18:55');
INSERT INTO `b_user_score` VALUES ('3', '14', '9', '0', '2019-03-12 10:19:34');
INSERT INTO `b_user_score` VALUES ('4', '14', '9', '0', '2019-03-12 10:34:43');
INSERT INTO `b_user_score` VALUES ('5', '14', '9', '1', '2019-03-12 10:34:54');
INSERT INTO `b_user_score` VALUES ('6', '14', '9', '0', '2019-03-14 15:13:39');
INSERT INTO `b_user_score` VALUES ('7', '14', '9', '1', '2019-03-14 15:39:32');
INSERT INTO `b_user_score` VALUES ('8', '14', '10', '0', '2019-03-20 10:57:14');
INSERT INTO `b_user_score` VALUES ('9', '14', '10', '1', '2019-03-20 13:00:44');
INSERT INTO `b_user_score` VALUES ('10', '14', '10', '1', '2019-03-27 14:53:59');

-- ----------------------------
-- Table structure for persistent_logins
-- ----------------------------
DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins` (
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `series` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `token` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of persistent_logins
-- ----------------------------

-- ----------------------------
-- Function structure for currval
-- ----------------------------
DROP FUNCTION IF EXISTS `currval`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `currval`(seq_name VARCHAR(50)) RETURNS int(11)
    DETERMINISTIC
BEGIN
         DECLARE value INTEGER;
         SET value = 0;
         SELECT current_value INTO value
                   FROM b_sequence
                   WHERE name = seq_name;
         RETURN value;
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for nextval
-- ----------------------------
DROP FUNCTION IF EXISTS `nextval`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `nextval`(seq_name VARCHAR(50)) RETURNS int(11)
    DETERMINISTIC
BEGIN
         UPDATE b_sequence
                   SET current_value = current_value + increment
                   WHERE name = seq_name;
         RETURN currval(seq_name);
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for setval
-- ----------------------------
DROP FUNCTION IF EXISTS `setval`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `setval`(seq_name VARCHAR(50), value INTEGER) RETURNS int(11)
    DETERMINISTIC
BEGIN
         UPDATE b_sequence
                   SET current_value = value
                   WHERE name = seq_name;
         RETURN currval(seq_name);
END
;;
DELIMITER ;
