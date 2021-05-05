/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50649
 Source Host           : localhost:3306
 Source Schema         : covid

 Target Server Type    : MySQL
 Target Server Version : 50649
 File Encoding         : 65001

 Date: 03/05/2021 17:30:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '会员id',
  `mobile` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '手机号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '密码',
  `nickname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '昵称',
  `sex` tinyint(2) UNSIGNED DEFAULT NULL COMMENT '性别 1 女，2 男',
  `age` tinyint(3) UNSIGNED DEFAULT NULL COMMENT '年龄',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户头像',
  `is_disabled` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否禁用 1（true）已禁用，  0（false）未禁用',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '会员表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '13700000001', '96e79218965eb72c92a549dd5a330112', '小三123', 1, 5, 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', 0, 0, '2019-01-01 12:11:33', '2019-11-08 11:56:01');
INSERT INTO `user` VALUES ('1080736474267144193', '13700000011', '96e79218965eb72c92a549dd5a330112', '用户XJtDfaYeKk', 1, 19, 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', 0, 0, '2019-01-02 12:12:45', '2019-01-02 12:12:56');
INSERT INTO `user` VALUES ('1080736474355224577', '13700000002', '96e79218965eb72c92a549dd5a330112', '用户wUrNkzAPrc', 1, 27, 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', 0, 0, '2019-01-02 12:13:56', '2019-01-02 12:14:07');
INSERT INTO `user` VALUES ('1086387099449442306', '13520191388', '96e79218965eb72c92a549dd5a330112', '用户XTMUeHDAoj', 2, 20, 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', 0, 0, '2019-01-19 06:17:23', '2019-01-19 06:17:23');
INSERT INTO `user` VALUES ('1086387099520745473', '13520191389', '96e79218965eb72c92a549dd5a330112', '用户vSdKeDlimn', 1, 21, 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', 0, 0, '2019-01-19 06:17:23', '2019-01-19 06:17:23');
INSERT INTO `user` VALUES ('1086387099608825858', '13520191381', '96e79218965eb72c92a549dd5a330112', '用户EoyWUVXQoP', 1, 18, 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', 0, 0, '2019-01-19 06:17:23', '2019-01-19 06:17:23');
INSERT INTO `user` VALUES ('1086387099701100545', '13520191382', '96e79218965eb72c92a549dd5a330112', '用户LcAYbxLNdN', 2, 24, 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', 0, 0, '2019-01-19 06:17:23', '2019-01-19 06:17:23');
INSERT INTO `user` VALUES ('1086387099776598018', '13520191383', '96e79218965eb72c92a549dd5a330112', '用户dZdjcgltnk', 2, 25, 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', 0, 0, '2019-01-19 06:17:23', '2019-01-19 06:17:23');
INSERT INTO `user` VALUES ('1086387099852095490', '13520191384', '96e79218965eb72c92a549dd5a330112', '用户wNHGHlxUwX', 2, 23, 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', 0, 0, '2019-01-19 06:17:23', '2019-01-19 06:17:23');
INSERT INTO `user` VALUES ('1106746895272849410', NULL, NULL, '檀梵\'', NULL, NULL, 'http://thirdwx.qlogo.cn/mmopen/vi_32/zZfLXcetf2Rpsibq6HbPUWKgWSJHtha9y1XBeaqluPUs6BYicW1FJaVqj7U3ozHd3iaodGKJOvY2PvqYTuCKwpyfQ/132', 0, 0, '2019-03-16 10:39:57', '2019-03-16 10:39:57');
INSERT INTO `user` VALUES ('1106822699956654081', NULL, NULL, NULL, NULL, NULL, 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', 0, 0, '2019-03-16 15:41:10', '2019-03-16 15:41:10');
INSERT INTO `user` VALUES ('1106823035660357634', NULL, NULL, 'GaoSir', NULL, NULL, 'http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJI53RcCuc1no02os6ZrattWGiazlPnicoZQ59zkS7phNdLEWUPDk8fzoxibAnXV1Sbx0trqXEsGhXPw/132', 0, 0, '2019-03-16 15:42:30', '2019-03-16 15:42:30');
INSERT INTO `user` VALUES ('1106823041599492098', NULL, NULL, NULL, NULL, NULL, 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', 0, 0, '2019-03-16 15:42:32', '2019-03-16 15:42:32');
INSERT INTO `user` VALUES ('1106823115788341250', NULL, NULL, '换个网名哇、', NULL, NULL, 'http://thirdwx.qlogo.cn/mmopen/vi_32/jJHyeM0EN2jhB70LntI3k8fEKe7W6CwykrKMgDJM4VZqCpcxibVibX397p0vmbKURGkLS4jxjGB0GpZfxCicgt07w/132', 0, 0, '2019-03-16 15:42:49', '2019-03-16 15:42:49');
INSERT INTO `user` VALUES ('1106826046730227714', NULL, NULL, '我是Helen', NULL, NULL, 'http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKDRfib8wy7A2ltERKh4VygxdjVC1x5OaOb1t9hot4JNt5agwaVLdJLcD9vJCNcxkvQnlvLYIPfrZw/132', 0, 0, '2019-03-16 15:54:28', '2019-03-16 15:54:28');
INSERT INTO `user` VALUES ('1106828185829490690', NULL, NULL, ' 虎头', NULL, NULL, 'http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKxCqRzuYWQmpwiaqQEjNxbC7WicebicXQusU306jgmfoOzUcFg1qaDq5BStiblwBjw5dUOblQ2gUicQOQ/132', 0, 0, '2019-03-16 16:02:58', '2019-03-16 16:02:58');
INSERT INTO `user` VALUES ('1106830599651442689', NULL, NULL, '是吴啊', NULL, NULL, 'http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ9CsqApybcs7f3Dyib9IxIh0sBqJb7LicbjU4WticJFF0PVwFvHgtbFdBwfmk3H2t3NyqmEmVx17tRA/132', 0, 0, '2019-03-16 16:12:34', '2019-03-16 16:12:34');
INSERT INTO `user` VALUES ('1106830976199278593', NULL, NULL, '我才是Helen', NULL, NULL, 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83epMicP9UT6mVjYWdno0OJZkOXiajG0sllJTbGJ9DYiceej2XvbDSGCK8LCF7jv1PuG2uoYlePWic9XO8A/132', 0, 0, '2019-03-16 16:14:03', '2019-03-16 16:14:03');
INSERT INTO `user` VALUES ('1106831936900415490', NULL, NULL, '文若姬', NULL, NULL, 'http://thirdwx.qlogo.cn/mmopen/vi_32/3HEmJwpSzguqqAyzmBwqT6aicIanswZibEOicQInQJI3ZY1qmu59icJC6N7SahKqWYv24GvX5KH2fibwt0mPWcTJ3fg/132', 0, 0, '2019-03-16 16:17:52', '2019-03-16 16:17:52');
INSERT INTO `user` VALUES ('1106832491064442882', NULL, NULL, 'Peanut', NULL, NULL, 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', 0, 0, '2019-03-16 16:20:04', '2019-03-16 16:20:04');
INSERT INTO `user` VALUES ('1106833021442510849', NULL, NULL, '食物链终结者', NULL, NULL, 'http://thirdwx.qlogo.cn/mmopen/vi_32/MQ7qUmCprK9am16M1Ia1Cs3RK0qiarRrl9y8gsssBjIZeS2GwKSrnq7ZYhmrzuzDwBxSMMAofrXeLic9IBlW4M3Q/132', 0, 0, '2019-03-16 16:22:11', '2019-03-16 16:22:11');
INSERT INTO `user` VALUES ('1191600824445046786', '15210078344', '96e79218965eb72c92a549dd5a330112', 'IT妖姬', 1, 5, 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', 0, 0, '2019-11-05 14:19:10', '2019-11-08 18:04:43');
INSERT INTO `user` VALUES ('1191616288114163713', '17866603606', '96e79218965eb72c92a549dd5a330112', 'xiaowu', NULL, NULL, 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', 0, 0, '2019-11-05 15:20:37', '2019-11-05 15:20:37');
INSERT INTO `user` VALUES ('1195187659054329857', '15010546384', '96e79218965eb72c92a549dd5a330112', 'qy', NULL, NULL, 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', 0, 0, '2019-11-15 11:51:58', '2019-11-15 11:51:58');
INSERT INTO `user` VALUES ('1378663773325258753', '18934880352', '96e79218965eb72c92a549dd5a330112', '2222', NULL, NULL, 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', 0, 0, '2021-04-04 19:00:33', '2021-04-04 19:00:33');

SET FOREIGN_KEY_CHECKS = 1;
