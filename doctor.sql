/*
Navicat MySQL Data Transfer

Source Server         : localmysql
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : doctor

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2016-06-08 09:52:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `community_hospital`
-- ----------------------------
DROP TABLE IF EXISTS `community_hospital`;
CREATE TABLE `community_hospital` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `description` varchar(512) DEFAULT NULL COMMENT '社区医院简介',
  `address` varchar(256) DEFAULT NULL COMMENT '小区地址',
  `phoneNumber` bigint(20) DEFAULT NULL COMMENT '电话',
  `createTime` datetime DEFAULT NULL,
  `modifyTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of community_hospital
-- ----------------------------
INSERT INTO `community_hospital` VALUES ('11', 'name', 'description', 'address', '15757115929', '2016-05-18 13:02:33', '2016-05-18 13:02:33');
INSERT INTO `community_hospital` VALUES ('22', 'name', 'description', 'address', '15757115929', '2016-05-18 13:02:39', '2016-05-18 13:02:39');
INSERT INTO `community_hospital` VALUES ('40', '按时打的对对对', '顶顶顶', '按时打算', '15757115929', '2016-05-18 17:50:36', '2016-05-18 17:50:36');
INSERT INTO `community_hospital` VALUES ('41', '第一个医院', '这个医院很牛逼', '杭州市', '15757111111', '2016-05-18 21:06:17', '2016-05-18 21:06:17');
INSERT INTO `community_hospital` VALUES ('42', '李正超', '123', '按时打算', '15757115929', '2016-05-20 16:55:58', '2016-05-20 16:55:58');
INSERT INTO `community_hospital` VALUES ('43', '阿达', '按时打算', '阿达', '15757115929', '2016-05-22 16:23:26', '2016-05-22 16:23:26');
INSERT INTO `community_hospital` VALUES ('44', '按时打算', '按时打算', '按时打算', '15757115929', '2016-05-22 16:24:02', '2016-05-22 16:24:02');
INSERT INTO `community_hospital` VALUES ('45', '123', null, null, null, '2016-05-22 16:25:53', '2016-05-22 16:25:53');

-- ----------------------------
-- Table structure for `doctor`
-- ----------------------------
DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '此表为医生表',
  `name` varchar(256) DEFAULT NULL,
  `identificationId` bigint(32) DEFAULT NULL COMMENT '身份证号',
  `phoneNumber` bigint(20) DEFAULT NULL,
  `phyQuaCerCode` varchar(64) DEFAULT NULL COMMENT '医师资格证书编码',
  `phyPraCerCode` varchar(64) DEFAULT NULL COMMENT '医师执业证书编码',
  `title` int(11) DEFAULT NULL COMMENT '职称：0医师；1主管医师；2副主任医师；3主任医师',
  `practiceType` int(11) DEFAULT NULL COMMENT '执业类别:0临床；1公共卫生；2口腔；3中医',
  `description` varchar(512) DEFAULT NULL COMMENT '医生简介',
  `specialty` varchar(64) DEFAULT NULL COMMENT '擅长方向',
  `comHosId` int(11) DEFAULT NULL COMMENT '所属机构id',
  `createTime` datetime DEFAULT NULL,
  `modifyTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of doctor
-- ----------------------------
INSERT INTO `doctor` VALUES ('2', 'lizhengcha1', '330481199401156200', '15757115911', '11', 'asddas', '0', '2', '我是第一个系统建哒医生', '哦吼吼，啥都会', '11', '2016-06-01 17:06:21', '2016-06-02 11:39:14');
INSERT INTO `doctor` VALUES ('4', '李早', '330382199401012350', '15757116394', '111111111', '111111111', '1', '1', '浙江工业大学毕业', '口腔', '11', '2016-06-01 17:41:53', '2016-06-02 11:13:33');

-- ----------------------------
-- Table structure for `home_service_record`
-- ----------------------------
DROP TABLE IF EXISTS `home_service_record`;
CREATE TABLE `home_service_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '上门服务记录表',
  `comHosId` int(11) DEFAULT NULL,
  `resId` int(11) DEFAULT NULL,
  `docId` int(11) DEFAULT NULL,
  `requestInfo` varchar(512) DEFAULT NULL COMMENT '上门请求工作内容',
  `phoneNumber` int(11) DEFAULT NULL COMMENT '患者联系方式',
  `homeAddress` varchar(256) DEFAULT NULL COMMENT '患者地址',
  `medicalRecId` int(11) DEFAULT NULL COMMENT '完善至电子病历的id',
  `requestTime` datetime DEFAULT NULL COMMENT '请求时间',
  `solveTime` datetime DEFAULT NULL COMMENT '就诊完成时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of home_service_record
-- ----------------------------

-- ----------------------------
-- Table structure for `medical_record`
-- ----------------------------
DROP TABLE IF EXISTS `medical_record`;
CREATE TABLE `medical_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `resId` int(11) DEFAULT NULL,
  `docId` int(11) DEFAULT NULL COMMENT '就诊医生id',
  `resHeaDatId` int(11) DEFAULT NULL COMMENT '体检记录id',
  `chiefComplaint` varchar(512) DEFAULT NULL COMMENT '病人主诉',
  `suggest` varchar(512) DEFAULT NULL COMMENT '诊疗建议',
  `medicationRecIds` varchar(512) DEFAULT NULL COMMENT '所有用药记录id',
  `createTime` datetime DEFAULT NULL,
  `modifyTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of medical_record
-- ----------------------------
INSERT INTO `medical_record` VALUES ('1', '8', '2', '1', '我感觉很难受', '吃药吧', '1', '2016-05-24 15:11:06', '2016-05-24 15:11:06');
INSERT INTO `medical_record` VALUES ('2', '1', '2', '1', '12213', '12312', '1', '2016-05-24 18:33:26', '2016-05-24 18:33:26');
INSERT INTO `medical_record` VALUES ('3', '1', '2', '1', 'lizcz', '1221231', '1', '2016-05-24 18:44:30', '2016-05-24 18:44:30');
INSERT INTO `medical_record` VALUES ('4', '1', '2', '1', 'lizcz', '1221231', '1', '2016-05-24 18:45:18', '2016-05-24 18:45:18');
INSERT INTO `medical_record` VALUES ('5', '1', '2', null, 'asdas', 'asdasd', null, '2016-05-24 18:49:25', '2016-05-24 18:49:25');
INSERT INTO `medical_record` VALUES ('6', '1', '2', null, '111', '1111', null, '2016-05-24 18:51:57', '2016-05-24 18:51:57');
INSERT INTO `medical_record` VALUES ('7', '7', '2', null, 'qeqw', 'ada', null, '2016-05-24 19:29:05', '2016-05-24 19:29:05');
INSERT INTO `medical_record` VALUES ('8', '1', '2', null, '难受', '没事', null, '2016-05-24 22:00:32', '2016-05-24 22:00:32');
INSERT INTO `medical_record` VALUES ('9', null, '2', null, '', '', null, '2016-05-24 22:03:47', '2016-05-24 22:03:47');
INSERT INTO `medical_record` VALUES ('10', '1', '2', null, '', '', null, '2016-05-24 22:05:06', '2016-05-24 22:05:06');
INSERT INTO `medical_record` VALUES ('11', '1', '2', null, '', '', null, '2016-05-24 22:09:08', '2016-05-24 22:09:08');
INSERT INTO `medical_record` VALUES ('12', '1', '2', null, '11', '11', null, '2016-05-24 22:16:07', '2016-05-24 22:16:07');
INSERT INTO `medical_record` VALUES ('13', '1', '2', null, '122', '213213', null, '2016-05-24 22:22:52', '2016-05-24 22:22:52');
INSERT INTO `medical_record` VALUES ('14', '1', '2', null, '122', '213213', null, '2016-05-24 22:22:53', '2016-05-24 22:22:53');
INSERT INTO `medical_record` VALUES ('15', '1', '2', null, '122', '213213', null, '2016-05-24 22:23:07', '2016-05-24 22:23:07');
INSERT INTO `medical_record` VALUES ('16', '1', '2', null, '111', '111', null, '2016-05-24 22:37:41', '2016-05-24 22:37:41');
INSERT INTO `medical_record` VALUES ('17', '1', '2', null, '11', '11', null, '2016-05-24 22:39:34', '2016-05-24 22:39:34');
INSERT INTO `medical_record` VALUES ('18', '1', '2', null, '111', 'asda', null, '2016-05-24 22:41:50', '2016-05-24 22:41:50');
INSERT INTO `medical_record` VALUES ('19', '1', '2', null, '阿斯顿', 'asda', null, '2016-05-24 22:43:33', '2016-05-24 22:43:33');
INSERT INTO `medical_record` VALUES ('20', '1', '2', null, '11', '111', null, '2016-05-24 22:51:07', '2016-05-24 22:51:07');
INSERT INTO `medical_record` VALUES ('21', '1', '2', null, '11', '111', null, '2016-05-24 22:54:41', '2016-05-24 22:54:41');
INSERT INTO `medical_record` VALUES ('22', '1', '2', null, 'asd ', 'adadd ', null, '2016-05-24 23:11:52', '2016-05-24 23:11:52');
INSERT INTO `medical_record` VALUES ('23', '1', '2', null, '111', '1111', null, '2016-05-24 23:13:37', '2016-05-24 23:13:37');
INSERT INTO `medical_record` VALUES ('24', '1', '2', null, '阿达', '阿萨德', null, '2016-05-24 23:34:09', '2016-05-24 23:34:09');
INSERT INTO `medical_record` VALUES ('25', '1', '2', null, '请问', '阿达', null, '2016-05-24 23:42:55', '2016-05-24 23:42:55');
INSERT INTO `medical_record` VALUES ('26', '1', '2', null, '阿萨德', '阿萨德', null, '2016-05-24 23:44:22', '2016-05-24 23:44:22');
INSERT INTO `medical_record` VALUES ('27', '1', '2', null, '啥的', '阿达', null, '2016-05-24 23:45:52', '2016-05-24 23:45:52');
INSERT INTO `medical_record` VALUES ('28', '1', '2', null, '11', '111', null, '2016-05-24 23:48:08', '2016-05-24 23:48:08');
INSERT INTO `medical_record` VALUES ('29', '1', '2', null, '阿萨德', '阿达', null, '2016-05-24 23:49:43', '2016-05-24 23:49:43');
INSERT INTO `medical_record` VALUES ('30', '1', '2', null, '阿萨德', '阿达', null, '2016-05-24 23:53:08', '2016-05-24 23:53:08');
INSERT INTO `medical_record` VALUES ('31', '1', '2', null, '阿萨德', '啥的', null, '2016-05-24 23:54:24', '2016-05-24 23:54:24');
INSERT INTO `medical_record` VALUES ('32', '1', '2', null, '阿萨德', '安大厦', null, '2016-05-24 23:55:05', '2016-05-24 23:55:05');
INSERT INTO `medical_record` VALUES ('33', '1', '2', null, '阿萨德', '俺都是大的 ', null, '2016-05-24 23:58:35', '2016-05-24 23:58:35');
INSERT INTO `medical_record` VALUES ('34', '1', '2', null, '我很难受', '没事的', null, '2016-05-28 03:23:46', '2016-05-28 03:23:46');
INSERT INTO `medical_record` VALUES ('35', '1', '2', null, '11', '11', null, '2016-05-30 13:41:52', '2016-05-30 13:41:52');
INSERT INTO `medical_record` VALUES ('36', '1', '2', null, 'qasd', 'asdda', null, '2016-06-01 13:42:13', '2016-06-01 13:42:13');
INSERT INTO `medical_record` VALUES ('37', '3', '2', null, '111', '11', null, '2016-06-01 13:50:08', '2016-06-01 13:50:08');
INSERT INTO `medical_record` VALUES ('38', '1', '2', null, 'asdasd', 'asdasd', null, '2016-06-06 10:31:51', '2016-06-06 10:31:51');
INSERT INTO `medical_record` VALUES ('39', '1', '2', null, 'asdasd', 'asdasd', null, '2016-06-06 10:31:51', '2016-06-06 10:31:51');
INSERT INTO `medical_record` VALUES ('40', '1', '2', null, 'asda', 'adsa', null, '2016-06-06 11:52:09', '2016-06-06 11:52:09');
INSERT INTO `medical_record` VALUES ('41', '1', '2', null, '11', '11', null, '2016-06-06 13:47:51', '2016-06-06 13:47:51');
INSERT INTO `medical_record` VALUES ('42', '1', '2', null, '11', '11', null, '2016-06-06 13:50:32', '2016-06-06 13:50:32');

-- ----------------------------
-- Table structure for `medication_record`
-- ----------------------------
DROP TABLE IF EXISTS `medication_record`;
CREATE TABLE `medication_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '此表为用药记录表',
  `medicalRecId` int(11) DEFAULT NULL COMMENT '该用药记录所属的就诊id',
  `medicineId` int(11) DEFAULT NULL COMMENT '药品id',
  `amount` int(11) DEFAULT NULL COMMENT '数量',
  `medicationRule` varchar(512) DEFAULT NULL COMMENT '用药规则',
  `createTime` datetime DEFAULT NULL,
  `modifyTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of medication_record
-- ----------------------------
INSERT INTO `medication_record` VALUES ('1', '1', '1', '2', '随便用', '2016-05-24 18:48:59', '2016-05-24 18:48:59');
INSERT INTO `medication_record` VALUES ('2', '2', '1', '111', '阿斯顿', '2016-05-24 22:43:12', '2016-05-24 22:43:12');
INSERT INTO `medication_record` VALUES ('3', '19', '1', '11', 'asda', '2016-05-24 22:43:48', '2016-05-24 22:43:48');
INSERT INTO `medication_record` VALUES ('4', '21', '1', '11', '111', '2016-05-24 22:51:23', '2016-05-24 22:51:23');
INSERT INTO `medication_record` VALUES ('5', '21', '1', '11', '111', '2016-05-24 22:54:53', '2016-05-24 22:54:53');
INSERT INTO `medication_record` VALUES ('6', '21', '1', '111', 'asda', '2016-05-24 23:12:05', '2016-05-24 23:12:05');
INSERT INTO `medication_record` VALUES ('7', '21', '1', '1', 'dsadfs', '2016-05-24 23:13:50', '2016-05-24 23:13:50');
INSERT INTO `medication_record` VALUES ('8', '41', '1', '111', '11', '2016-06-06 13:47:59', '2016-06-06 13:47:59');

-- ----------------------------
-- Table structure for `medicine`
-- ----------------------------
DROP TABLE IF EXISTS `medicine`;
CREATE TABLE `medicine` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `spellingName` varchar(64) DEFAULT NULL COMMENT '英文名',
  `type` int(11) DEFAULT NULL,
  `supplyUnit` varchar(255) DEFAULT NULL,
  `factory` varchar(64) DEFAULT NULL COMMENT '厂商',
  `price` int(11) DEFAULT NULL,
  `number` int(11) DEFAULT NULL COMMENT '库存',
  `createTime` datetime DEFAULT NULL,
  `modifyTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of medicine
-- ----------------------------
INSERT INTO `medicine` VALUES ('1', '感冒药1', 'ganmaoyao', '0', '瓶', '哈尔滨制药厂', '100', '10', '2016-05-24 17:37:21', '2016-05-24 17:37:21');
INSERT INTO `medicine` VALUES ('2', '发烧药1', 'fashaoyao', '1', '瓶', '海宁制药厂', '100', '10', '2016-05-24 17:37:39', '2016-05-24 17:37:39');
INSERT INTO `medicine` VALUES ('3', '咳嗽药1', 'kesouyao', '1', '瓶', '江西制药厂', '100', '10', '2016-05-24 17:37:59', '2016-05-24 17:37:59');

-- ----------------------------
-- Table structure for `medicine_record`
-- ----------------------------
DROP TABLE IF EXISTS `medicine_record`;
CREATE TABLE `medicine_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '药品出入库记录表',
  `medicine_id` int(11) DEFAULT NULL COMMENT '药品id',
  `type` int(11) DEFAULT NULL COMMENT '出库，1；入库，0',
  `amount` int(11) DEFAULT NULL COMMENT '出入库数量',
  `doctor_id` int(11) DEFAULT NULL COMMENT '操作人员id',
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of medicine_record
-- ----------------------------

-- ----------------------------
-- Table structure for `message_record`
-- ----------------------------
DROP TABLE IF EXISTS `message_record`;
CREATE TABLE `message_record` (
  `id` int(11) NOT NULL DEFAULT '0' COMMENT '此表为留言记录表',
  `resId` int(11) DEFAULT NULL,
  `comHosId` int(11) DEFAULT NULL COMMENT '留言至哪家医院',
  `docId` int(11) DEFAULT NULL COMMENT '解答医生id',
  `requestMessage` varchar(512) DEFAULT NULL COMMENT '患者留言内容',
  `answerMessage` varchar(255) DEFAULT NULL COMMENT '医生解答内容',
  `requestTime` datetime DEFAULT NULL COMMENT '留言时间',
  `answerTime` datetime DEFAULT NULL COMMENT '解答时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message_record
-- ----------------------------

-- ----------------------------
-- Table structure for `resident`
-- ----------------------------
DROP TABLE IF EXISTS `resident`;
CREATE TABLE `resident` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `sex` tinyint(4) DEFAULT NULL COMMENT '0，男;1，女',
  `identificationId` varchar(32) DEFAULT NULL COMMENT '身份证号码',
  `birthday` varchar(32) DEFAULT NULL,
  `homeAddress` varchar(64) DEFAULT NULL,
  `phoneNumber` varchar(11) DEFAULT NULL,
  `familyMembers` varchar(256) DEFAULT NULL COMMENT '家庭成员，以逗号分隔',
  `comHosId` int(11) DEFAULT NULL COMMENT '所属社区医院',
  `createTime` datetime DEFAULT NULL,
  `modifyTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resident
-- ----------------------------
INSERT INTO `resident` VALUES ('1', '李正超11', '1', '330481196803031234', '2016-05-12', '浙江工业大学', '15757115929', '1,3', '11', '2016-05-22 20:41:00', '2016-05-23 22:39:19');
INSERT INTO `resident` VALUES ('2', '李文浩11', '1', '330481196803031234', '1968-03-03', '浙江海宁', '13706971851', '2', '11', '2016-05-22 20:42:55', '2016-05-23 20:20:03');
INSERT INTO `resident` VALUES ('3', '牛迎南', '1', '522225198012084423', '1971-09-09', '浙江海宁', '13706597185', '1,2', '11', '2016-05-22 21:09:27', '2016-05-30 14:26:51');
INSERT INTO `resident` VALUES ('5', '李文浩', '0', '330481196803031234', '1968-03-03', '浙江海宁', '13706971851', '', '11', '2016-05-23 02:04:47', '2016-05-23 22:39:48');
INSERT INTO `resident` VALUES ('7', 'adsa', '1', '330481199401151211', '2016-05-12', '浙江工业大学', '15757115929', null, null, '2016-05-23 19:55:12', '2016-05-23 19:55:12');
INSERT INTO `resident` VALUES ('8', '李正超1111a', '1', '330481199401151234', '2016-05-12', '浙江工业大学', '15757115929', '', '11', '2016-05-23 20:03:09', '2016-05-23 20:03:09');
INSERT INTO `resident` VALUES ('9', '阿迪萨斯', '1', '12132', '', '请问而且我', '15757115929', '', '11', '2016-05-23 20:09:12', '2016-05-23 20:09:12');
INSERT INTO `resident` VALUES ('10', 'asda', '1', '', '2016-05-11', '', '15757115929', null, '11', '2016-05-30 15:50:16', '2016-05-30 15:50:16');
INSERT INTO `resident` VALUES ('11', 'asd', '1', '', '', '', '15757115929', null, '11', '2016-05-30 15:52:02', '2016-05-30 15:52:02');
INSERT INTO `resident` VALUES ('12', 'asd', '1', '123', '2016-05-04', '', '15757115929', null, '11', '2016-05-30 15:52:26', '2016-05-30 15:52:26');

-- ----------------------------
-- Table structure for `resident_health_data`
-- ----------------------------
DROP TABLE IF EXISTS `resident_health_data`;
CREATE TABLE `resident_health_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `medicalRecId` int(11) DEFAULT NULL COMMENT '居民id',
  `statutre` int(11) DEFAULT NULL COMMENT '身高',
  `weight` int(11) DEFAULT NULL,
  `temperature` int(11) DEFAULT NULL COMMENT '体温',
  `systolic` int(11) DEFAULT NULL COMMENT '收缩压',
  `diastolic` int(11) DEFAULT NULL COMMENT '舒张压',
  `oxygen` int(11) DEFAULT NULL COMMENT '血氧',
  `sphygmus` int(11) DEFAULT NULL COMMENT '脉搏',
  `breath` int(11) DEFAULT NULL COMMENT '呼吸',
  `boold` int(11) DEFAULT NULL COMMENT '血型',
  `comment` varchar(256) DEFAULT NULL COMMENT '备注',
  `reporPtictureURL` varchar(512) DEFAULT NULL COMMENT '体检报告照片URL',
  `createTime` date DEFAULT NULL,
  `modifyTime` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of resident_health_data
-- ----------------------------
INSERT INTO `resident_health_data` VALUES ('1', null, null, null, null, null, null, null, null, null, null, '111', null, '2016-05-20', '2016-05-20');
INSERT INTO `resident_health_data` VALUES ('2', null, null, null, null, null, null, null, null, null, null, '111', null, '2016-05-20', '2016-05-20');
INSERT INTO `resident_health_data` VALUES ('3', '2', '11', '11', '11', '11', '111', '11', '11', '11', '11', '上大三', null, '2016-05-24', '2016-05-24');
INSERT INTO `resident_health_data` VALUES ('4', '26', null, null, null, null, null, null, null, null, null, '阿萨德', null, '2016-05-24', '2016-05-24');
INSERT INTO `resident_health_data` VALUES ('5', '27', null, null, null, null, null, null, null, null, null, '', null, '2016-05-24', '2016-05-24');
INSERT INTO `resident_health_data` VALUES ('6', '28', null, null, null, null, null, null, null, null, null, '1', null, '2016-05-24', '2016-05-24');
INSERT INTO `resident_health_data` VALUES ('7', '29', null, null, null, null, null, null, null, null, null, '', null, '2016-05-24', '2016-05-24');
INSERT INTO `resident_health_data` VALUES ('8', '29', null, null, null, null, null, null, null, null, null, '', null, '2016-05-24', '2016-05-24');
INSERT INTO `resident_health_data` VALUES ('9', '30', null, null, null, null, null, null, null, null, null, '', null, '2016-05-24', '2016-05-24');
INSERT INTO `resident_health_data` VALUES ('10', '30', null, null, null, null, null, null, null, null, null, '', null, '2016-05-24', '2016-05-24');
INSERT INTO `resident_health_data` VALUES ('11', '31', null, null, null, null, null, null, null, null, null, '', null, '2016-05-24', '2016-05-24');
INSERT INTO `resident_health_data` VALUES ('12', '31', null, null, null, null, null, null, null, null, null, '', null, '2016-05-24', '2016-05-24');
INSERT INTO `resident_health_data` VALUES ('13', '32', null, null, null, null, null, null, null, null, null, '', null, '2016-05-24', '2016-05-24');
INSERT INTO `resident_health_data` VALUES ('14', '33', '11', '11', null, null, null, null, null, null, null, '阿达', null, '2016-05-24', '2016-05-24');

-- ----------------------------
-- Table structure for `resident_inverstigation`
-- ----------------------------
DROP TABLE IF EXISTS `resident_inverstigation`;
CREATE TABLE `resident_inverstigation` (
  `id` int(11) NOT NULL DEFAULT '0' COMMENT '此表为既往病史表',
  `resId` int(11) DEFAULT NULL COMMENT '患者id',
  `disease` varchar(32) DEFAULT NULL,
  `type` int(11) DEFAULT NULL COMMENT '是否治愈：1，是；0，否',
  `time1` varchar(32) DEFAULT NULL COMMENT '确诊日期',
  `time2` varchar(32) DEFAULT NULL COMMENT '治愈日期',
  `create_time` date DEFAULT NULL,
  `modify_time` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resident_inverstigation
-- ----------------------------

-- ----------------------------
-- Table structure for `test`
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` int(11) NOT NULL DEFAULT '0',
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES ('0', '123');
INSERT INTO `test` VALUES ('11', 'name');
INSERT INTO `test` VALUES ('12', 'name');
INSERT INTO `test` VALUES ('14', 'qwe');
INSERT INTO `test` VALUES ('123', 'qwe');

-- ----------------------------
-- Table structure for `user_table`
-- ----------------------------
DROP TABLE IF EXISTS `user_table`;
CREATE TABLE `user_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '此表为用户表',
  `userType` int(11) DEFAULT NULL COMMENT '用户类型：0,管理员；1，医生；2，患者',
  `identificationId` bigint(20) DEFAULT NULL COMMENT '身份证号',
  `resDocId` int(11) DEFAULT NULL COMMENT '绑定的患者或医生id',
  `nickname` varchar(32) DEFAULT NULL COMMENT '昵称，用于登录',
  `password` varchar(64) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `modifyTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_table
-- ----------------------------
INSERT INTO `user_table` VALUES ('1', '2', '522225198012084423', '3', 'lzc0', '1234567', '2016-05-17 15:45:23', '2016-06-07 15:32:27');
INSERT INTO `user_table` VALUES ('2', '1', null, '2', 'lzc1', '1234567', null, null);
INSERT INTO `user_table` VALUES ('9', '0', null, null, 'lzc8', '1234567', '2016-05-17 22:16:34', '2016-05-17 22:16:34');
INSERT INTO `user_table` VALUES ('10', '2', '330481199401156211', '1', 'lzc2', '1234567', '2016-06-01 17:06:21', '2016-06-01 17:06:21');
INSERT INTO `user_table` VALUES ('11', '1', '330382199401012356', '8', '李早', '1234567', '2016-06-01 17:41:53', '2016-06-01 17:41:53');
INSERT INTO `user_table` VALUES ('12', '1', '330481199401156200', '5', 'lizhengcha1', '1234567', '2016-06-01 17:43:59', '2016-06-01 17:43:59');
