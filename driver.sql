/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : driver

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 04/07/2020 01:51:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `id` int(11) NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `carType` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `carnum` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nowstate` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `joinTime` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (10002, '钱柜', '1642124', '女', '兰博基尼', '42325', 'ture', '2019-06-27');
INSERT INTO `employee` VALUES (10003, '骚鸡', '1573873274', '女', '法拉利', '345w', 'false', '2019-06-27');
INSERT INTO `employee` VALUES (10004, '傻杰', '1273972972', '男', '五菱宏光', 'bb', 'ture', '2019-06-28');
INSERT INTO `employee` VALUES (10005, '鸭王', '1439452647', '男', '兰博基尼', '川a12244', 'ture', '2019-06-11');
INSERT INTO `employee` VALUES (10006, '松尔', '123642', '男', '杀马特', '川A12343', 'ture', '2019-06-11');
INSERT INTO `employee` VALUES (10007, '刘能', '1', '男', '现代', '京56756', 'ture', '2019-06-11');
INSERT INTO `employee` VALUES (10008, '陈独秀', '243546', '男', '宝马', '京68768', 'false', '2019-05-27');
INSERT INTO `employee` VALUES (10010, '小红', '12364243', '男', '兰博基尼', 'asdf', 'false', '2019-06-18');
INSERT INTO `employee` VALUES (10011, '小兰', '92732', '女', '兰博基尼', '川A 23432', 'false', '2019-06-28');
INSERT INTO `employee` VALUES (10011, 'qqq', '123412', '女', '法拉利', '川A 12321', 'ture', '2019-06-28');
INSERT INTO `employee` VALUES (100013, 'xiaojuju', '222222', '女', '法拉利', '京', 'ture', '2019-06-20');
INSERT INTO `employee` VALUES (10014, '小小', '12345631', '男', '宝马', '川A 78121', 'ture', '2019-06-28');
INSERT INTO `employee` VALUES (10016, 'pp', '19214314', '女', '宝马', '川a 12345', '在线', '2020-06-30');

-- ----------------------------
-- Table structure for upart
-- ----------------------------
DROP TABLE IF EXISTS `upart`;
CREATE TABLE `upart`  (
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of upart
-- ----------------------------
INSERT INTO `upart` VALUES ('小明', '123');
INSERT INTO `upart` VALUES ('asd', '123');
INSERT INTO `upart` VALUES ('123', '111');
INSERT INTO `upart` VALUES ('zhu', 'zhu');
INSERT INTO `upart` VALUES ('ooo', 'ooo');
INSERT INTO `upart` VALUES ('pp', '111111');
INSERT INTO `upart` VALUES ('大大', '111111');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` int(11) NOT NULL,
  `email` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `newpassword` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('小明', 12345, '123@qq.com', '123', '123');
INSERT INTO `user` VALUES ('asd', 12345, '123@qq.com', '123', '123');

SET FOREIGN_KEY_CHECKS = 1;
