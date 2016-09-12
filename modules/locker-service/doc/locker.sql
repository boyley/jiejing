/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : locker

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2016-09-12 18:22:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for locker_box
-- ----------------------------
DROP TABLE IF EXISTS `locker_box`;
CREATE TABLE `locker_box` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '箱子名称',
  `code` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '箱子编号',
  `cabinet_id` int(11) DEFAULT NULL COMMENT '柜子外键',
  `box_size_id` int(11) DEFAULT NULL COMMENT '箱子规格（引用sys_dictionary）',
  `gate_lock_state` enum('OPEN','CLOSE','ERROR') COLLATE utf8_bin DEFAULT NULL COMMENT '门锁状态;OPEN:打开，CLOSE:关闭，ERROR：异常',
  `deposit_state` enum('Y','N','ERROR') COLLATE utf8_bin DEFAULT NULL COMMENT '存物状态Y:有存物，N：无存物，ERROR：异常',
  `box_state` enum('ZY','WY') COLLATE utf8_bin DEFAULT NULL COMMENT '箱子状态,ZY:占用，WY：未用',
  `created_by` int(11) DEFAULT NULL COMMENT '创建人',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_modified_by` int(11) DEFAULT NULL COMMENT '最后的更新人',
  `last_modified_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新时间',
  `description` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT '描述',
  `status` enum('ENABLE','DISENABLE','ERROR') COLLATE utf8_bin DEFAULT NULL COMMENT '是否禁用: ENABLE:启用，DISENABLE:禁用，ERROR:错误异常',
  `order_id` int(11) DEFAULT NULL COMMENT '订单id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='箱子信息表';

-- ----------------------------
-- Records of locker_box
-- ----------------------------
INSERT INTO `locker_box` VALUES ('1', '01', '01', '1', '2', 'OPEN', 'Y', 'WY', null, '2016-09-12 17:15:30', null, '2016-09-12 17:15:30', null, null, null);
INSERT INTO `locker_box` VALUES ('2', '02', '02', '1', '3', 'OPEN', 'N', 'WY', null, '2016-09-12 17:15:56', null, '2016-09-12 17:15:56', null, null, null);
INSERT INTO `locker_box` VALUES ('3', '03', '03', '1', '4', 'OPEN', 'Y', 'WY', null, '2016-09-12 17:16:16', null, '2016-09-12 17:16:16', null, null, null);
INSERT INTO `locker_box` VALUES ('4', '04', '04', '1', '5', 'CLOSE', 'N', 'WY', null, '2016-09-12 17:16:42', null, '2016-09-12 17:16:42', null, null, null);
INSERT INTO `locker_box` VALUES ('5', '05', '05', '1', '2', 'CLOSE', 'N', 'WY', null, '2016-09-12 17:19:24', null, '2016-09-12 17:19:24', null, null, null);
INSERT INTO `locker_box` VALUES ('6', '06', '06', '1', '3', 'CLOSE', 'N', 'ZY', null, '2016-09-12 17:19:38', null, '2016-09-12 17:19:38', null, null, null);
INSERT INTO `locker_box` VALUES ('7', '07', '07', '1', '4', 'OPEN', 'N', 'WY', null, '2016-09-12 17:19:54', null, '2016-09-12 17:19:54', null, null, null);
INSERT INTO `locker_box` VALUES ('8', '08', '08', '1', '5', 'CLOSE', 'N', 'WY', null, '2016-09-12 17:20:10', null, '2016-09-12 17:20:10', null, null, null);

-- ----------------------------
-- Table structure for locker_cabinet
-- ----------------------------
DROP TABLE IF EXISTS `locker_cabinet`;
CREATE TABLE `locker_cabinet` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '柜子编码',
  `name` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '柜子名称',
  `region_id` int(11) DEFAULT NULL COMMENT '地址：道路/小区 编码',
  `lon` decimal(10,5) DEFAULT NULL COMMENT '地理经度',
  `lat` decimal(10,5) DEFAULT NULL COMMENT '地理纬度',
  `status` enum('ENABLE','DISENABLE','ERROR') COLLATE utf8_bin DEFAULT NULL COMMENT '是否禁用: ENABLE:启用，DISENABLE:禁用，ERROR:错误异常',
  `multiple` tinyint(1) DEFAULT NULL COMMENT '可多次使用',
  `voucher_verify` tinyint(1) DEFAULT NULL COMMENT '是否证件验证',
  `description` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT '描述',
  `created_by` int(11) DEFAULT NULL COMMENT '创建人',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_modified_by` int(11) DEFAULT NULL COMMENT '最后的更新人',
  `last_modified_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新时间',
  `open_time` time NOT NULL COMMENT '开机时间',
  `close_time` time NOT NULL COMMENT '关机时间',
  `region_code` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '地址编码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='柜子信息表';

-- ----------------------------
-- Records of locker_cabinet
-- ----------------------------
INSERT INTO `locker_cabinet` VALUES ('1', 'code', 'name', '1', '3.00000', '3.00000', 'ENABLE', '0', '0', 'description', '0', '2016-09-01 15:02:42', '0', '2016-09-01 15:02:42', '15:02:42', '15:02:42', null);
INSERT INTO `locker_cabinet` VALUES ('2', '编码', '柜子名称', '2', null, '333.00000', 'ENABLE', '0', '1', null, '0', '2016-09-12 14:26:36', '0', '2016-09-12 14:26:36', '10:25:25', '21:25:25', null);
INSERT INTO `locker_cabinet` VALUES ('3', '编码', '柜子名称', '2', null, '333.00000', 'ENABLE', '0', '1', null, '0', '2016-09-12 14:30:38', '0', '2016-09-12 14:30:38', '10:25:25', '21:25:25', null);
INSERT INTO `locker_cabinet` VALUES ('4', '编码', '柜子名称', '2', null, '333.00000', 'ENABLE', '0', '1', null, '0', '2016-09-12 14:33:19', '0', '2016-09-12 14:33:19', '10:25:25', '21:25:25', null);

-- ----------------------------
-- Table structure for locker_cabinet_charge_standard
-- ----------------------------
DROP TABLE IF EXISTS `locker_cabinet_charge_standard`;
CREATE TABLE `locker_cabinet_charge_standard` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `cabinet_id` int(11) DEFAULT NULL COMMENT '箱子id',
  `box_size_id` int(11) DEFAULT NULL COMMENT '规格类型',
  `charge_standard_id` int(11) DEFAULT NULL COMMENT '收费标准id',
  `created_by` int(11) DEFAULT NULL COMMENT '创建人',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_modified_by` int(11) DEFAULT NULL COMMENT '最后的更新人',
  `last_modified_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='收费关联表';

-- ----------------------------
-- Records of locker_cabinet_charge_standard
-- ----------------------------
INSERT INTO `locker_cabinet_charge_standard` VALUES ('1', '1', '2', '1', null, '2016-09-12 16:54:12', null, '2016-09-12 16:54:12');
INSERT INTO `locker_cabinet_charge_standard` VALUES ('2', '1', '3', '2', null, '2016-09-12 16:54:45', null, '2016-09-12 16:54:45');
INSERT INTO `locker_cabinet_charge_standard` VALUES ('3', '1', '4', '3', null, '2016-09-12 16:54:55', null, '2016-09-12 16:54:55');
INSERT INTO `locker_cabinet_charge_standard` VALUES ('4', '2', '5', '4', null, '2016-09-12 16:55:04', null, '2016-09-12 16:55:04');

-- ----------------------------
-- Table structure for locker_charge_standard
-- ----------------------------
DROP TABLE IF EXISTS `locker_charge_standard`;
CREATE TABLE `locker_charge_standard` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `price` decimal(10,2) DEFAULT NULL COMMENT '价格',
  `charge_type` enum('TIME_HOUR','TIME_CYCLE') COLLATE utf8_bin DEFAULT NULL COMMENT '收费方式（TIME_HOUR:时间节点，TIME_CYCLE:时间段收费）',
  `cycle_time` int(11) DEFAULT NULL COMMENT '收费周期（小时）',
  `description` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT '描述',
  `created_by` int(11) DEFAULT NULL COMMENT '创建人',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_modified_by` int(11) DEFAULT NULL COMMENT '最后的更新人',
  `last_modified_date` datetime DEFAULT NULL COMMENT '最后一次更新时间',
  `default_box_size` int(11) DEFAULT NULL COMMENT '默认收费规格',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='收费标准';

-- ----------------------------
-- Records of locker_charge_standard
-- ----------------------------
INSERT INTO `locker_charge_standard` VALUES ('1', '30.00', 'TIME_CYCLE', '3', '小箱默认收费标准', '0', '2016-09-02 11:31:34', '0', '2016-09-02 11:31:34', '2');
INSERT INTO `locker_charge_standard` VALUES ('2', '40.00', 'TIME_CYCLE', '4', '中箱默认收费标准', '0', '2016-09-02 11:43:55', null, null, '3');
INSERT INTO `locker_charge_standard` VALUES ('3', '50.00', 'TIME_HOUR', '5', '大箱默认收费标准', '0', '2016-09-02 11:44:08', null, null, '4');
INSERT INTO `locker_charge_standard` VALUES ('4', '70.00', 'TIME_CYCLE', '5', '超大箱默认收费标准', '0', '2016-09-02 11:52:33', null, null, '5');

-- ----------------------------
-- Table structure for locker_keeplive
-- ----------------------------
DROP TABLE IF EXISTS `locker_keeplive`;
CREATE TABLE `locker_keeplive` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `type` enum('GZ','XZ') COLLATE utf8_bin DEFAULT NULL COMMENT '类型,GZ:柜子，XZ:箱子',
  `object_id` int(11) DEFAULT NULL COMMENT '柜子/箱子id',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '检测时间',
  `error_code` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '错误编码',
  `description` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT '描述',
  `keeplive_time` datetime DEFAULT NULL COMMENT '轮询时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='心跳信息';

-- ----------------------------
-- Records of locker_keeplive
-- ----------------------------
INSERT INTO `locker_keeplive` VALUES ('1', 'GZ', '1', null, 'ZC', '正常', null);

-- ----------------------------
-- Table structure for locker_lease_box
-- ----------------------------
DROP TABLE IF EXISTS `locker_lease_box`;
CREATE TABLE `locker_lease_box` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `created_by` int(11) DEFAULT NULL COMMENT '创建人',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_modified_by` int(11) DEFAULT NULL COMMENT '最后的更新人',
  `last_modified_date` datetime DEFAULT NULL COMMENT '最后一次更新时间',
  `cabinet_id` int(11) DEFAULT NULL COMMENT '存储柜id',
  `box_id` int(11) DEFAULT NULL COMMENT '存储箱id',
  `box_size_id` int(11) DEFAULT NULL COMMENT '存储箱规格id',
  `charge_standard_id` int(11) DEFAULT NULL COMMENT '计费标准id',
  `cabinet_name` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '存储柜名称',
  `cabinet_code` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '存储柜编码',
  `box_name` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '存储箱名称',
  `box_code` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '存储箱名称',
  `box_size_name` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '存储箱规格名称',
  `box_size_code` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '存储箱规格编码',
  `charge_type` enum('TIME_HOUR','TIME_CYCLE') COLLATE utf8_bin DEFAULT NULL COMMENT '收费方式（TIME_HOUR:时间节点，TIME_CYCLE:时间段收费）',
  `cycle_time` int(11) DEFAULT NULL COMMENT '收费周期（小时）',
  `price` decimal(9,2) DEFAULT NULL COMMENT '价格',
  `order_id` int(11) DEFAULT NULL COMMENT '订单id',
  `box_state` enum('DQ','YQ','ZY') COLLATE utf8_bin DEFAULT NULL COMMENT '箱状态DQ:待取，YQ：已取,ZY:占用',
  `check_type` int(11) DEFAULT NULL COMMENT '校验模式（引用sys_dictionary）',
  `timeout` int(11) DEFAULT NULL COMMENT '是否超时寄存,大于0表示超时，具体数值表示超时值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='租箱记录';

-- ----------------------------
-- Records of locker_lease_box
-- ----------------------------
INSERT INTO `locker_lease_box` VALUES ('1', '0', '2016-09-10 17:03:44', '0', '2016-09-10 17:03:44', '1', '5', '3', '2', 'name', 'code', 'box5', 'box5', '中', 'Medium', 'TIME_CYCLE', '4', '40.00', '1', 'ZY', '1', null);
INSERT INTO `locker_lease_box` VALUES ('2', '0', '2016-09-12 11:03:08', '0', '2016-09-12 11:03:08', '1', '5', '3', '2', 'name', 'code', 'box5', 'box5', '中', 'Medium', 'TIME_CYCLE', '4', '40.00', '5', 'ZY', '1', null);
INSERT INTO `locker_lease_box` VALUES ('3', '0', '2016-09-12 14:35:17', '0', '2016-09-12 14:35:17', '1', '1', '2', '2', 'name', 'code', 'box1', 'box1', '小', 'Small', 'TIME_CYCLE', '4', '40.00', '15', 'ZY', '1', null);

-- ----------------------------
-- Table structure for locker_lease_info
-- ----------------------------
DROP TABLE IF EXISTS `locker_lease_info`;
CREATE TABLE `locker_lease_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `info_type` int(11) DEFAULT NULL COMMENT '资料类型（引用sys_dictionary）',
  `code` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '证件类型code',
  `name` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '资料名称',
  `info_file` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT '资料文件',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='租/取箱资料';

-- ----------------------------
-- Records of locker_lease_info
-- ----------------------------
INSERT INTO `locker_lease_info` VALUES ('1', '7', 'SFZ', '身份证', null);
INSERT INTO `locker_lease_info` VALUES ('2', '8', 'HZ', '护照', null);
INSERT INTO `locker_lease_info` VALUES ('3', '7', 'SFZ', '身份证', null);
INSERT INTO `locker_lease_info` VALUES ('4', '8', 'HZ', '护照', null);
INSERT INTO `locker_lease_info` VALUES ('5', '7', 'SFZ', '身份证', null);

-- ----------------------------
-- Table structure for locker_lease_info_extra
-- ----------------------------
DROP TABLE IF EXISTS `locker_lease_info_extra`;
CREATE TABLE `locker_lease_info_extra` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `lease_info_id` int(11) DEFAULT NULL COMMENT '资料证件',
  `name` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '属性名称',
  `value` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '属性值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='资料信息扩展信息';

-- ----------------------------
-- Records of locker_lease_info_extra
-- ----------------------------
INSERT INTO `locker_lease_info_extra` VALUES ('1', '1', '姓名', '张家辉');
INSERT INTO `locker_lease_info_extra` VALUES ('2', '1', '身份证号', '44444444444444444444444444');
INSERT INTO `locker_lease_info_extra` VALUES ('3', '2', '名称', '梁家辉');
INSERT INTO `locker_lease_info_extra` VALUES ('4', '2', '护照号码', '5222222222222222');
INSERT INTO `locker_lease_info_extra` VALUES ('5', '3', '名称', '梁家辉');
INSERT INTO `locker_lease_info_extra` VALUES ('6', '3', '身份证号', '5xxxxxxxxxxxxxx');
INSERT INTO `locker_lease_info_extra` VALUES ('7', '4', '名称', '梁家辉');
INSERT INTO `locker_lease_info_extra` VALUES ('8', '4', '护照号码', '5222222222222222');
INSERT INTO `locker_lease_info_extra` VALUES ('9', '5', '名称', '梁家辉');
INSERT INTO `locker_lease_info_extra` VALUES ('10', '5', '身份证号', '5xxxxxxxxxxxxxx');

-- ----------------------------
-- Table structure for locker_lease_redeem_info
-- ----------------------------
DROP TABLE IF EXISTS `locker_lease_redeem_info`;
CREATE TABLE `locker_lease_redeem_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lease_box_id` int(11) DEFAULT NULL COMMENT '存箱记录id',
  `lease_info_id` int(11) DEFAULT NULL COMMENT '资料id',
  `redeem_luggage_id` int(11) DEFAULT NULL COMMENT '取箱id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='存箱，取箱和资料的中间表';

-- ----------------------------
-- Records of locker_lease_redeem_info
-- ----------------------------
INSERT INTO `locker_lease_redeem_info` VALUES ('1', '1', '1', null);
INSERT INTO `locker_lease_redeem_info` VALUES ('2', '2', '2', null);
INSERT INTO `locker_lease_redeem_info` VALUES ('3', '2', '3', null);
INSERT INTO `locker_lease_redeem_info` VALUES ('4', '3', '4', null);
INSERT INTO `locker_lease_redeem_info` VALUES ('5', '3', '5', null);

-- ----------------------------
-- Table structure for locker_media
-- ----------------------------
DROP TABLE IF EXISTS `locker_media`;
CREATE TABLE `locker_media` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(120) COLLATE utf8_bin DEFAULT NULL COMMENT '标题',
  `content` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT '内容',
  `target_url` varchar(256) COLLATE utf8_bin DEFAULT NULL COMMENT '跳转目标',
  `url` varchar(256) COLLATE utf8_bin DEFAULT NULL COMMENT '广告链接',
  `time` int(11) DEFAULT NULL COMMENT '停留时间(单位秒)',
  `seq` int(11) DEFAULT NULL COMMENT '排序(越大越前)',
  `start_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `type` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '文件类型',
  `created_by` int(11) DEFAULT NULL COMMENT '创建人',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_modified_by` int(11) DEFAULT NULL COMMENT '最后的更新人',
  `last_modified_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新时间',
  `enable` bit(1) DEFAULT NULL COMMENT '是否可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='广告传媒';

-- ----------------------------
-- Records of locker_media
-- ----------------------------
INSERT INTO `locker_media` VALUES ('1', null, null, null, 'http://', '3', '1', null, null, '1', null, '2016-09-12 16:53:34', null, '2016-09-12 16:53:34', null);
INSERT INTO `locker_media` VALUES ('2', null, null, null, 'http://', '5', '2', null, null, '1', null, '2016-09-12 16:53:46', null, '2016-09-12 16:53:46', null);
INSERT INTO `locker_media` VALUES ('3', null, null, null, 'http://1', '8', '3', null, null, '1', null, '2016-09-12 16:54:02', null, '2016-09-12 16:54:02', null);

-- ----------------------------
-- Table structure for locker_order_handle
-- ----------------------------
DROP TABLE IF EXISTS `locker_order_handle`;
CREATE TABLE `locker_order_handle` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `created_by` int(11) DEFAULT NULL COMMENT '创建人',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_modified_by` int(11) DEFAULT NULL COMMENT '最后的更新人',
  `last_modified_date` datetime DEFAULT NULL COMMENT '最后一次更新时间',
  `order_id` int(11) DEFAULT NULL COMMENT '订单id',
  `action_type` int(11) DEFAULT NULL COMMENT '动作类型，关联sys_dictionary表',
  `description` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='订单处理';

-- ----------------------------
-- Records of locker_order_handle
-- ----------------------------

-- ----------------------------
-- Table structure for locker_redeem_luggage
-- ----------------------------
DROP TABLE IF EXISTS `locker_redeem_luggage`;
CREATE TABLE `locker_redeem_luggage` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `order_id` int(11) DEFAULT NULL COMMENT '订单id',
  `result` enum('Y','N') COLLATE utf8_bin DEFAULT NULL COMMENT 'Y:成功，N失败',
  `retreat_id` int(11) DEFAULT NULL COMMENT '补单id',
  `timeout` int(11) DEFAULT NULL COMMENT '是否超时寄存,大于0表示超时，具体数值表示超时值',
  `description` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT '描述',
  `created_by` int(11) DEFAULT NULL COMMENT '创建人',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_modified_by` int(11) DEFAULT NULL COMMENT '最后的更新人',
  `last_modified_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='操作记录';

-- ----------------------------
-- Records of locker_redeem_luggage
-- ----------------------------

-- ----------------------------
-- Table structure for locker_region
-- ----------------------------
DROP TABLE IF EXISTS `locker_region`;
CREATE TABLE `locker_region` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '编码',
  `name` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '节点名称',
  `parent_id` int(11) DEFAULT NULL COMMENT '所属父节点id',
  `url` varchar(256) COLLATE utf8_bin DEFAULT NULL COMMENT '访问路径',
  `description` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT '描述',
  `created_by` int(11) DEFAULT NULL COMMENT '创建人',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_modified_by` int(11) DEFAULT NULL COMMENT '最后的更新人',
  `last_modified_date` datetime DEFAULT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='区域信息';

-- ----------------------------
-- Records of locker_region
-- ----------------------------
INSERT INTO `locker_region` VALUES ('1', 'GDS', '广东省', null, null, '广东省', null, '2016-09-12 14:19:47', null, null);
INSERT INTO `locker_region` VALUES ('2', 'GDS01', '广州市', '1', null, '广东省广州市', null, '2016-09-12 14:20:15', null, null);
INSERT INTO `locker_region` VALUES ('3', 'GDS0101', '白云区', '1', null, '广东省广州市白云区', null, '2016-09-12 14:20:36', null, null);
INSERT INTO `locker_region` VALUES ('4', 'GDS0102', '荔湾区', '1', null, '广东省广州市荔湾区', null, '2016-09-12 14:20:56', null, null);
INSERT INTO `locker_region` VALUES ('5', 'GDS0103', '天河区', '1', null, '广东省广州市天河区', null, '2016-09-12 14:21:17', null, null);
INSERT INTO `locker_region` VALUES ('6', 'GDS010301', '天信大厦', '5', null, '广东省广州市天河区天信大厦', null, '2016-09-12 14:21:45', null, null);
INSERT INTO `locker_region` VALUES ('7', 'GDS010101', '梅花园梅苑小区正门', '3', null, '广东省广州市白云区梅花园梅苑小区正门', null, '2016-09-12 14:22:20', null, null);
INSERT INTO `locker_region` VALUES ('8', 'GDS010102', '同沙路云东小区正门', '3', null, '广东省广州市白云区同沙路云东小区正门', null, '2016-09-12 14:22:44', null, null);
INSERT INTO `locker_region` VALUES ('9', 'GDS010103', '金圣大厦', '3', null, '广东省广州市白云区金圣大厦', null, '2016-09-12 14:23:08', null, null);

-- ----------------------------
-- Table structure for sys_account
-- ----------------------------
DROP TABLE IF EXISTS `sys_account`;
CREATE TABLE `sys_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `country_code` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '国家代码',
  `phone_no` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '手机号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='账号信息';

-- ----------------------------
-- Records of sys_account
-- ----------------------------

-- ----------------------------
-- Table structure for sys_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `sys_dictionary`;
CREATE TABLE `sys_dictionary` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '字典编码',
  `name` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '字典名称',
  `value_type` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '字典值类型',
  `value` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '字典值',
  `description` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT '描述',
  `created_by` int(11) DEFAULT NULL COMMENT '创建人',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_modified_by` int(11) DEFAULT NULL COMMENT '最后的更新人',
  `last_modified_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新时间',
  `parent_id` int(11) DEFAULT NULL COMMENT '父节点id',
  `parent_code` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '父节点code',
  `editable` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否可编辑',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='字典表';

-- ----------------------------
-- Records of sys_dictionary
-- ----------------------------
INSERT INTO `sys_dictionary` VALUES ('1', 'box_size', '箱子规格', 'array', 'BOX_SIZE', '箱子规格，大，小，中，超大', null, '2016-09-02 11:37:12', null, null, null, null, '\0');
INSERT INTO `sys_dictionary` VALUES ('2', 'Small', '小', 'String', 'Small', '35mm*15mm*10mm', null, '2016-09-02 11:38:11', null, null, '1', 'box_size', '\0');
INSERT INTO `sys_dictionary` VALUES ('3', 'Medium', '中', 'String', 'Medium', '55mm*35mm*20mm', null, '2016-09-02 11:38:33', null, null, '1', 'box_size', '\0');
INSERT INTO `sys_dictionary` VALUES ('4', 'Large', '大', 'String', 'Large', '75mm*55mm*40mm', null, '2016-09-02 11:38:54', null, null, '1', 'box_size', '\0');
INSERT INTO `sys_dictionary` VALUES ('5', 'XLarge', '超大', 'String', 'XLarge', '95mm*75mm*60mm', null, '2016-09-02 11:53:16', null, '2016-09-02 11:53:16', '1', 'box_size', '\0');
INSERT INTO `sys_dictionary` VALUES ('6', 'Info_type', '资料信息', 'String', 'Info', '护照，身份证，手机号，二维码等等资料信息', null, '2016-09-02 16:56:54', null, '2016-09-02 16:56:54', null, null, '\0');
INSERT INTO `sys_dictionary` VALUES ('7', 'SFZ', '身份证', 'String', 'SFZ', '身份证', null, '2016-09-02 16:57:36', null, '2016-09-02 16:57:36', '6', 'Info_type', '\0');
INSERT INTO `sys_dictionary` VALUES ('8', 'HZ', '护照', 'String', 'HZ', '护照', null, '2016-09-02 17:15:20', null, '2016-09-02 17:15:20', '6', 'Info_type', '\0');
INSERT INTO `sys_dictionary` VALUES ('9', 'RECEIPT', '小票', 'String', 'RECEIPT', '小票', null, '2016-09-02 17:15:36', null, '2016-09-02 17:15:36', '6', 'Info_type', '\0');
INSERT INTO `sys_dictionary` VALUES ('10', 'PWD', '密码', 'String', 'PWD', '密码', null, '2016-09-02 17:16:25', null, '2016-09-02 17:16:25', '6', 'Info_type', '\0');
INSERT INTO `sys_dictionary` VALUES ('11', 'SJH', '手机号', 'String', 'SJH', '手机号', null, '2016-09-05 14:00:17', null, '2016-09-05 14:00:17', '6', 'Info_type', '\0');
INSERT INTO `sys_dictionary` VALUES ('12', 'order_source', '下单渠道', 'String', 'order_source', '下单渠道', null, '2016-09-05 14:43:39', null, '2016-09-05 14:43:39', null, null, '\0');
INSERT INTO `sys_dictionary` VALUES ('13', 'APP', 'APP', 'String', 'APP', 'APP', null, '2016-09-05 14:44:19', null, '2016-09-05 14:44:19', '12', 'order_source', '\0');
INSERT INTO `sys_dictionary` VALUES ('14', 'WeChat', '微信', 'String', 'WeChat', '微信', null, '2016-09-05 14:44:39', null, '2016-09-05 14:44:39', '12', 'order_source', '\0');
INSERT INTO `sys_dictionary` VALUES ('15', 'GKD', '工控端', 'String', 'GKD', '工控端', null, '2016-09-05 14:44:50', null, '2016-09-05 14:44:50', '12', 'order_source', '\0');
INSERT INTO `sys_dictionary` VALUES ('16', 'pay_type', '支付类型', 'String', 'pay_type', '支付类型', null, '2016-09-05 14:46:26', null, '2016-09-05 14:46:26', null, null, '\0');
INSERT INTO `sys_dictionary` VALUES ('17', 'XJPAY', '现金支付', 'String', 'XJPAY', '现金支付', null, '2016-09-05 14:47:35', null, '2016-09-05 14:47:35', '16', 'pay_type', '\0');
INSERT INTO `sys_dictionary` VALUES ('18', 'WXPAY', '微信支付', 'String', 'WXPAY', '微信支付', null, '2016-09-05 14:48:13', null, '2016-09-05 14:48:13', '16', 'pay_type', '\0');
INSERT INTO `sys_dictionary` VALUES ('19', 'ALIPAY', '支付宝支付', 'String', 'ALIPAY', '支付宝支付', null, '2016-09-05 14:49:25', null, '2016-09-05 14:49:25', '16', 'pay_type', '\0');
INSERT INTO `sys_dictionary` VALUES ('20', 'fethc_type', '提取验证', 'String', 'fethc_type', '提取验证', null, '2016-09-05 15:14:01', null, '2016-09-05 15:14:01', null, null, '\0');
INSERT INTO `sys_dictionary` VALUES ('21', 'Receipt', '小票提取', 'String', 'Receipt', '小票提取', null, '2016-09-05 15:15:23', null, '2016-09-05 15:15:23', '20', 'fethc_type', '\0');
INSERT INTO `sys_dictionary` VALUES ('22', 'PWD', '密码提取', 'String', 'PWD', '密码提取', null, '2016-09-05 15:15:37', null, '2016-09-05 15:15:37', '20', 'fethc_type', '\0');
INSERT INTO `sys_dictionary` VALUES ('23', 'ID_Card', '证件提取', 'String', 'ID_Card', '证件提取', null, '2016-09-05 15:16:20', null, '2016-09-05 15:16:20', '20', 'fethc_type', '\0');
INSERT INTO `sys_dictionary` VALUES ('24', 'ORDER_TYPE', '订单类型', 'String', 'ORDER_TYPE', '订单类型', null, '2016-09-12 16:17:35', null, '2016-09-12 16:17:35', null, null, '\0');
INSERT INTO `sys_dictionary` VALUES ('25', 'CREATE_ORDER', '正常下单', 'String', 'CREATE_ORDER', '正常下单', null, '2016-09-12 16:18:44', null, '2016-09-12 16:18:44', '24', 'ORDER_TYPE', '\0');
INSERT INTO `sys_dictionary` VALUES ('26', 'RETREAT_ORDER', '补单', 'String', 'RETREAT_ORDER', '补单', null, '2016-09-12 16:22:31', null, '2016-09-12 16:22:31', '24', 'ORDER_TYPE', '\0');

-- ----------------------------
-- Table structure for sys_order
-- ----------------------------
DROP TABLE IF EXISTS `sys_order`;
CREATE TABLE `sys_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `order_num` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '订单号',
  `created_by` int(11) DEFAULT NULL COMMENT '创建人',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_modified_by` int(11) DEFAULT NULL COMMENT '最后的更新人',
  `last_modified_date` datetime DEFAULT NULL COMMENT '最后一次更新时间',
  `order_state` enum('DZF','YZF','YQX','YWC','YGB') COLLATE utf8_bin DEFAULT NULL COMMENT '订单状态DZF:待支付，YZF：已支付，YQX：已取消，YWC：已完成,YGB:已关闭',
  `order_source` int(11) DEFAULT NULL COMMENT '下单渠道',
  `price` decimal(9,2) DEFAULT NULL COMMENT '费用',
  `pay_price` decimal(9,2) DEFAULT NULL COMMENT '支付金额',
  `pay_type` int(11) DEFAULT NULL COMMENT '支付方式,关联sys_dictionary表',
  `create_type` enum('CREATE_ORDER','RETREAT_ORDER') COLLATE utf8_bin DEFAULT NULL COMMENT '创建方式,RETREAT_ORDER:取箱补单，CREATE_ORDER:租箱下单',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='订单表';

-- ----------------------------
-- Records of sys_order
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account_id` int(11) DEFAULT NULL COMMENT '账号id',
  `name` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '姓名',
  `sex` enum('F','M','N') COLLATE utf8_bin DEFAULT NULL COMMENT 'male 雄性,female 雌性,null:未知',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_modified_date` datetime DEFAULT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户信息';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('2', '1', 'name', 'M', '2016-08-30 10:13:01', '2016-08-30 10:13:01');
INSERT INTO `sys_user` VALUES ('3', '2', 'name', 'M', '2016-08-30 10:17:31', '2016-08-30 10:17:31');

-- ----------------------------
-- Table structure for sys_user_extra
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_extra`;
CREATE TABLE `sys_user_extra` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `cert_type` int(11) DEFAULT NULL COMMENT '证件类型（引用sys_dictionary）',
  `num` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '证件号',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_modified_date` datetime DEFAULT NULL COMMENT '最后一次更新时间',
  `url` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT '图片url',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户其他信息';

-- ----------------------------
-- Records of sys_user_extra
-- ----------------------------
