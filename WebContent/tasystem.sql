/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : tasystem

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2018-05-15 14:38:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(20) DEFAULT NULL,
  `loginName` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `mobile` varchar(20) NOT NULL,
  `email` varchar(200) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', 'admin', 'admin', '13808567523', 'admin@126.com', '1');
INSERT INTO `admin` VALUES ('2', 'admin1', 'admin1', 'admin1', '14567901234', 'admin1@126.com', '1');
INSERT INTO `admin` VALUES ('3', 'admin2', 'admin2', 'admin2', '1234526789', 'admin2@126.com', '1');
INSERT INTO `admin` VALUES ('4', 'admin3', 'admin3', 'admin3', '13678922345', 'admin3@126.com', '1');
INSERT INTO `admin` VALUES ('5', 'admin4', 'admin4', 'admin4', '14567894321', 'admin4@126.com', '1');
INSERT INTO `admin` VALUES ('6', 'admin5', 'admin5', '88888888', '18965661198', 'admin5@126.com', '1');

-- ----------------------------
-- Table structure for `assess`
-- ----------------------------
DROP TABLE IF EXISTS `assess`;
CREATE TABLE `assess` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `target_teacher` int(11) DEFAULT NULL COMMENT '评价老师Id',
  `criteria_list` varchar(255) DEFAULT NULL COMMENT '评测列表',
  `scorce` float(6,2) DEFAULT NULL,
  `usertype` tinyint(4) DEFAULT NULL COMMENT '用户类型1学生2老师3督导',
  `createtime` date DEFAULT NULL,
  `remarks` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of assess
-- ----------------------------

-- ----------------------------
-- Table structure for `classes`
-- ----------------------------
DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `classes_name` varchar(100) NOT NULL,
  `depart_id` int(11) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of classes
-- ----------------------------
INSERT INTO `classes` VALUES ('1', '2015物联网工程1班', '1', '1');
INSERT INTO `classes` VALUES ('2', '2015软件工程1班', '1', '1');
INSERT INTO `classes` VALUES ('3', '2015软件工程(金融服务方向)1班', '1', '1');
INSERT INTO `classes` VALUES ('4', '2015软件工程(金融服务方向)2班', '1', '1');
INSERT INTO `classes` VALUES ('5', '2015数字媒体艺术1班', '3', '1');
INSERT INTO `classes` VALUES ('6', '2015数字媒体艺术2班', '3', '1');

-- ----------------------------
-- Table structure for `config`
-- ----------------------------
DROP TABLE IF EXISTS `config`;
CREATE TABLE `config` (
  `id` smallint(6) unsigned NOT NULL AUTO_INCREMENT COMMENT '表id',
  `name` varchar(50) DEFAULT NULL COMMENT '配置的key键名',
  `value` varchar(512) DEFAULT NULL COMMENT '配置的val值',
  `inc_type` varchar(64) DEFAULT NULL COMMENT '配置分组',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of config
-- ----------------------------
INSERT INTO `config` VALUES ('1', 'school_url', '#', 'qxy_info', '1');
INSERT INTO `config` VALUES ('2', 'record_no', '闽ICP备05015349号', 'qxy_info', '1');
INSERT INTO `config` VALUES ('3', 'school_name', '泉州信息工程学院教师评测系统', 'qxy_info', '1');
INSERT INTO `config` VALUES ('4', 'school_logo', '/public/images/newLogo.png', 'qxy_info', '1');
INSERT INTO `config` VALUES ('5', 'school_title', '教师评测系统|泉州信息工程学院 教师评测系统| 泉州信息工程学院--国家教育部设立的应用型本科院校', 'qxy_info', '1');
INSERT INTO `config` VALUES ('6', 'school_desc', '教师评测系统|泉州信息工程学院 教师评测系统| 泉州信息工程学院--国家教育部设立的应用型本科院校', 'qxy_info', '1');
INSERT INTO `config` VALUES ('7', 'school_keyword', '教师评测系统|泉州信息工程学院 教师评测系统| 泉州信息工程学院--国家教育部设立的应用型本科院校', 'qxy_info', '1');
INSERT INTO `config` VALUES ('8', 'contact', '联系人', 'qxy_info', '1');
INSERT INTO `config` VALUES ('9', 'phone', '0595-22789708|0595-22789808', 'qxy_info', '1');
INSERT INTO `config` VALUES ('10', 'address', '福建省泉州市丰泽区博东路249号', 'shop_info', '1');
INSERT INTO `config` VALUES ('11', 'starttime', '2018-6-1', 'qxy_info', '1');
INSERT INTO `config` VALUES ('12', 'endtime', '2018-6-30', 'qxy_info', '1');
INSERT INTO `config` VALUES ('13', '优秀', '95', 'qxy_criteria', '1');
INSERT INTO `config` VALUES ('14', '良好', '85', 'qxy_criteria', '1');
INSERT INTO `config` VALUES ('15', '中等', '75', 'qxy_criteria', '1');
INSERT INTO `config` VALUES ('16', '合格', '65', 'qxy_criteria', '1');
INSERT INTO `config` VALUES ('17', '差', '55', 'qxy_criteria', '1');

-- ----------------------------
-- Table structure for `criteria`
-- ----------------------------
DROP TABLE IF EXISTS `criteria`;
CREATE TABLE `criteria` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) DEFAULT NULL,
  `criteria_name` varchar(255) DEFAULT NULL,
  `level` tinyint(4) DEFAULT NULL COMMENT '一级栏目的分数是二级栏目分数之和，一级栏目分数之和是获得的总分',
  `weight` tinyint(4) DEFAULT NULL COMMENT '权重小于等于=100',
  `status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of criteria
-- ----------------------------
INSERT INTO `criteria` VALUES ('1', '0', '学生标准', '1', null, '1');
INSERT INTO `criteria` VALUES ('2', '0', '教师标准', '1', null, '1');
INSERT INTO `criteria` VALUES ('3', '0', '专家标准', '1', null, '1');
INSERT INTO `criteria` VALUES ('6', '1', '课堂教学(含体育)', '2', '100', '1');
INSERT INTO `criteria` VALUES ('7', '1', '实验教学（含课堂设计）', '2', '100', '1');
INSERT INTO `criteria` VALUES ('8', '1', '毕业论文(设计)', '2', '100', '1');
INSERT INTO `criteria` VALUES ('9', '1', '实习', '2', '100', '1');
INSERT INTO `criteria` VALUES ('10', '2', '教学能力', '2', '100', '1');
INSERT INTO `criteria` VALUES ('11', '2', '教学组织', '2', '100', '1');
INSERT INTO `criteria` VALUES ('12', '2', '语言教态', '2', '100', '1');
INSERT INTO `criteria` VALUES ('13', '2', '教学文档建设情况', '2', '100', '1');
INSERT INTO `criteria` VALUES ('18', '3', '教学能力', '2', '100', '1');
INSERT INTO `criteria` VALUES ('19', '3', '教学组织', '2', '100', '1');
INSERT INTO `criteria` VALUES ('20', '3', '语言教态', '2', '100', '1');
INSERT INTO `criteria` VALUES ('21', '3', '教学文档建设情况', '2', '100', '1');
INSERT INTO `criteria` VALUES ('22', '6', '教学内容与效果', '3', '30', '1');
INSERT INTO `criteria` VALUES ('23', '6', '课堂互动', '3', '10', '1');
INSERT INTO `criteria` VALUES ('24', '6', '课堂管理与作业批改', '3', '15', '1');
INSERT INTO `criteria` VALUES ('25', '7', '实验(资料)准备', '3', '10', '1');
INSERT INTO `criteria` VALUES ('26', '7', '实验(设计)讲解与指导', '3', '25', '1');
INSERT INTO `criteria` VALUES ('27', '7', '实验(设计)过程管理', '3', '15', '1');
INSERT INTO `criteria` VALUES ('28', '7', '实验(设计)报告批改', '3', '15', '1');
INSERT INTO `criteria` VALUES ('29', '7', '总体收获', '3', '35', '1');
INSERT INTO `criteria` VALUES ('30', '8', '论文选题', '3', '10', '1');
INSERT INTO `criteria` VALUES ('31', '8', '文献综述与外文翻译指导', '3', '10', '1');
INSERT INTO `criteria` VALUES ('32', '8', '过程指导', '3', '25', '1');
INSERT INTO `criteria` VALUES ('33', '8', '论文(设计)文本修改', '3', '20', '1');
INSERT INTO `criteria` VALUES ('34', '9', '实习任务安排', '3', '15', '1');
INSERT INTO `criteria` VALUES ('35', '18', '教学内容符合教学目标要求，有一定广度和深度', '3', null, '1');
INSERT INTO `criteria` VALUES ('36', '18', '教学内容精炼充实，基本概念准确，科学性强', '3', null, '1');
INSERT INTO `criteria` VALUES ('37', '18', '理论联系实际紧密，反映学科发展新思想、新概念、新成果', '3', null, '1');
INSERT INTO `criteria` VALUES ('38', '18', '教学信息量大，课堂教学饱满', '3', null, '1');
INSERT INTO `criteria` VALUES ('39', '18', '重点突出，条理清楚，内容承前启后，循序渐进', '3', null, '1');
INSERT INTO `criteria` VALUES ('40', '19', '教学设计方案体现完整，内容安排合理，教学时间利用有效', '3', null, '1');
INSERT INTO `criteria` VALUES ('41', '19', '注意启发性、研究性教学，培养学生独立思考和解决问题能力', '3', null, '1');
INSERT INTO `criteria` VALUES ('42', '19', '有效调动学生积极思维，师生互动效果明显', '3', null, '1');
INSERT INTO `criteria` VALUES ('43', '19', '方法运用灵活、恰当，有效地运用多媒体等现代教学手段，增强课堂教学效果', '3', null, '1');
INSERT INTO `criteria` VALUES ('44', '19', '板书设计与教学内容紧密联系、结构合理，板书与多媒体相配合，简洁、工整、美观、大小适当', '3', null, '1');
INSERT INTO `criteria` VALUES ('45', '20', '普通话讲课，声音清晰、语言准确，语速节奏恰当', '3', null, '1');
INSERT INTO `criteria` VALUES ('46', '20', '教态自然大方，精神饱满，上课感染力强', '3', null, '1');
INSERT INTO `criteria` VALUES ('47', '20', '结合课堂教学教书育人', '3', null, '1');
INSERT INTO `criteria` VALUES ('48', '20', '教学理念先进、风格突出、感染力强、教学效果好、教学有特色', '3', null, '1');
INSERT INTO `criteria` VALUES ('49', '21', '教学大纲规范，教学目标明确', '3', null, '1');
INSERT INTO `criteria` VALUES ('50', '21', '教案内容充实，既能理论联系实质，又反映学术前沿', '3', null, '1');
INSERT INTO `criteria` VALUES ('51', '21', '教学反思从教学理念、教学方法、教学过程三方面着手，做到联系实际、思路清晰、观点明确、文理通顺，有感而发', '3', null, '1');
INSERT INTO `criteria` VALUES ('52', '21', '教学思路清晰，重点、难点描述清楚，针对性强', '3', null, '1');
INSERT INTO `criteria` VALUES ('53', '21', '教学组织有序，时间安排合理，方法手段运用恰当有效。文字表达准确、简洁，阐述清楚', '3', null, '1');
INSERT INTO `criteria` VALUES ('54', '10', '教学内容符合教学目标要求，有一定广度和深度', '3', null, '1');
INSERT INTO `criteria` VALUES ('55', '10', '教学内容精炼充实，基本概念准确，科学性强', '3', null, '1');
INSERT INTO `criteria` VALUES ('56', '10', '理论联系实际紧密，反映学科发展新思想、新概念、新成果', '3', null, '1');
INSERT INTO `criteria` VALUES ('57', '10', '教学信息量大，课堂教学饱满', '3', null, '1');
INSERT INTO `criteria` VALUES ('58', '10', '重点突出，条理清楚，内容承前启后，循序渐进', '3', null, '1');
INSERT INTO `criteria` VALUES ('59', '11', '教学设计方案体现完整，内容安排合理，教学时间利用有效', '3', null, '1');
INSERT INTO `criteria` VALUES ('60', '11', '注意启发性、研究性教学，培养学生独立思考和解决问题能力', '3', null, '1');
INSERT INTO `criteria` VALUES ('61', '11', '有效调动学生积极思维，师生互动效果明显', '3', null, '1');
INSERT INTO `criteria` VALUES ('62', '11', '方法运用灵活、恰当，有效地运用多媒体等现代教学手段，增强课堂教学效果', '3', null, '1');
INSERT INTO `criteria` VALUES ('63', '11', '板书设计与教学内容紧密联系、结构合理，板书与多媒体相配合，简洁、工整、美观、大小适当', '3', null, '1');
INSERT INTO `criteria` VALUES ('64', '12', '普通话讲课，声音清晰、语言准确，语速节奏恰当', '3', null, '1');
INSERT INTO `criteria` VALUES ('65', '12', '教态自然大方，精神饱满，上课感染力强', '3', null, '1');
INSERT INTO `criteria` VALUES ('66', '12', '结合课堂教学教书育人', '3', null, '1');
INSERT INTO `criteria` VALUES ('67', '12', '教学理念先进、风格突出、感染力强、教学效果好、教学有特色', '3', null, '1');
INSERT INTO `criteria` VALUES ('68', '13', '教学大纲规范，教学目标明确', '3', null, '1');
INSERT INTO `criteria` VALUES ('69', '13', '教案内容充实，既能理论联系实质，又反映学术前沿', '3', null, '1');
INSERT INTO `criteria` VALUES ('70', '13', '教学反思从教学理念、教学方法、教学过程三方面着手，做到联系实际、思路清晰、观点明确、文理通顺，有感而发', '3', null, '1');
INSERT INTO `criteria` VALUES ('71', '13', '教学思路清晰，重点、难点描述清楚，针对性强', '3', null, '1');
INSERT INTO `criteria` VALUES ('72', '13', '教学组织有序，时间安排合理，方法手段运用恰当有效。文字表达准确、简洁，阐述清楚', '3', null, '1');
INSERT INTO `criteria` VALUES ('73', '6', '教学方法创新', '3', '10', '1');
INSERT INTO `criteria` VALUES ('74', '6', '总体收获', '3', '35', '1');
INSERT INTO `criteria` VALUES ('75', '8', '总体收获', '3', '35', '1');
INSERT INTO `criteria` VALUES ('76', '9', '实习岗位落实', '3', '10', '1');
INSERT INTO `criteria` VALUES ('77', '9', '实习指导与管理', '3', '25', '1');
INSERT INTO `criteria` VALUES ('78', '9', '实习报告批改', '3', '15', '1');
INSERT INTO `criteria` VALUES ('79', '9', '总体收获', '3', '35', '1');

-- ----------------------------
-- Table structure for `department`
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(10) DEFAULT NULL COMMENT '学院|处室',
  `depart_name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '学院', '软件学院');
INSERT INTO `department` VALUES ('2', '处室', '教务处');
INSERT INTO `department` VALUES ('3', '学院', '创意学院');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) NOT NULL,
  `userNo` varchar(30) NOT NULL,
  `password` varchar(20) NOT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `classes_id` int(11) DEFAULT NULL,
  `type` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('2', '测试学生', '100003', '88888888', '1', '1', null);
INSERT INTO `student` VALUES ('3', '测试学生1', '100032', '99999999', '1', '2', null);

-- ----------------------------
-- Table structure for `supervisor`
-- ----------------------------
DROP TABLE IF EXISTS `supervisor`;
CREATE TABLE `supervisor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) NOT NULL,
  `userNo` varchar(20) NOT NULL COMMENT '工号',
  `password` varchar(20) NOT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `type` tinyint(4) DEFAULT NULL,
  `major` varchar(30) DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL,
  `ranks` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of supervisor
-- ----------------------------
INSERT INTO `supervisor` VALUES ('1', '测试督导', '19990022', '88888888', '1', null, '电子', '2', '副教授');
INSERT INTO `supervisor` VALUES ('2', '测试督导1', '1000034', '88888888', '1', null, '文学', '2', '副教授');
INSERT INTO `supervisor` VALUES ('3', '测试督导2', '100089', '88888888', '1', null, '动漫专业', '3', '教授');

-- ----------------------------
-- Table structure for `system_menu`
-- ----------------------------
DROP TABLE IF EXISTS `system_menu`;
CREATE TABLE `system_menu` (
  `id` smallint(6) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '权限名字',
  `group` varchar(20) DEFAULT NULL COMMENT '所属分组',
  `right` text COMMENT '权限码(控制器+动作)',
  `is_del` tinyint(1) DEFAULT '0' COMMENT '删除状态 1删除,0正常',
  `type` tinyint(2) DEFAULT '0' COMMENT '所属模块类型 0admin 1home 2mobile 3api',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of system_menu
-- ----------------------------
INSERT INTO `system_menu` VALUES ('4', '广告管理', 'content', 'Article@notice_list', '0', '0');
INSERT INTO `system_menu` VALUES ('5', '网站设置', 'system', 'System@index,System@handle', '0', '0');
INSERT INTO `system_menu` VALUES ('6', '权限资源', 'system', 'System@right_list,System@edit_right', '0', '0');
INSERT INTO `system_menu` VALUES ('7', '前台导航设置', 'system', 'System@navigationList,System@addEditNav,System@delNav', '0', '0');
INSERT INTO `system_menu` VALUES ('8', '管理员管理', 'system', 'Admin@index,Admin@admin_info,Admin@adminHandle', '0', '0');
INSERT INTO `system_menu` VALUES ('9', '角色管理', 'system', 'Admin@role,Admin@role_info,Admin@roleSave,Admin@roleDel', '0', '0');
INSERT INTO `system_menu` VALUES ('10', '供应商管理', 'system', 'Admin@supplier,Admin@supplier_info,Admin@supplierHandle', '0', '0');
INSERT INTO `system_menu` VALUES ('11', '会员管理', 'member', 'User@index,User@ajaxindex,User@detail,User@address,User@delete', '0', '0');
INSERT INTO `system_menu` VALUES ('12', '会员资金', 'member', 'User@account_log,User@account_edit', '0', '0');
INSERT INTO `system_menu` VALUES ('13', '会员管理', 'member', 'User@index,User@ajaxindex,User@detail,User@address,User@delete,User@search_user', '0', '0');
INSERT INTO `system_menu` VALUES ('14', '会员等级', 'member', 'User@level,User@levelList,User@levelHandle', '0', '0');
INSERT INTO `system_menu` VALUES ('15', '商品类型', 'goods', 'Goods@goodsTypeList,Goods@addEditGoodsType,Goods@delGoodsType', '0', '0');
INSERT INTO `system_menu` VALUES ('16', '商品编辑', 'goods', 'Goods@addEditGoods,Goods@delGoods,Goods@del_goods_images', '0', '0');
INSERT INTO `system_menu` VALUES ('17', '商品列表', 'goods', 'Goods@goodsList,Goods@ajaxGoodsList,Goods@updateField', '0', '0');
INSERT INTO `system_menu` VALUES ('18', '商品规格', 'goods', 'Goods@ajaxGetSpecList,Goods@delGoodsSpec,Goods@addEditSpec,Goods@ajaxSpecList,Goods@specList,Goods@ajaxGetSpecSelect', '0', '0');
INSERT INTO `system_menu` VALUES ('19', '商品分类', 'goods', 'Goods@categoryList,Goods@addEditCategory,Goods@delGoodsCategory', '0', '0');
INSERT INTO `system_menu` VALUES ('20', '商品属性', 'goods', 'Goods@ajaxGetAttrList,Goods@goodsAttributeList,Goods@ajaxGoodsAttributeList,Goods@addEditGoodsAttribute,Goods@ajaxGetAttrInput', '0', '0');
INSERT INTO `system_menu` VALUES ('21', '商品品牌', 'goods', 'Goods@brandList,Goods@delBrand,Goods@addEditBrand', '0', '0');
INSERT INTO `system_menu` VALUES ('22', '广告列表', 'content', 'Ad@adList,Ad@adHandle,Ad@ad,Ad@changeAdField', '0', '0');
INSERT INTO `system_menu` VALUES ('23', '广告位', 'content', 'Ad@position,Ad@positionList,Ad@positionHandle', '0', '0');
INSERT INTO `system_menu` VALUES ('24', '团购管理', 'marketing', 'Promotion@group_buy,Promotion@group_buy_list,Promotion@groupbuyHandle', '0', '0');
INSERT INTO `system_menu` VALUES ('25', '限时抢购', 'marketing', 'Promotion@flash_sale,Promotion@flash_sale_info,Promotion@flash_sale_del', '0', '0');
INSERT INTO `system_menu` VALUES ('26', '促销管理', 'marketing', 'Promotion@prom_goods_list,Promotion@prom_goods_info,Promotion@prom_goods_save,Promotion@prom_goods_del,Promotion@get_goods,Promotion@search_goods', '0', '0');
INSERT INTO `system_menu` VALUES ('27', '订单列表', 'order', 'Order@index,Order@ajaxindex,Order@detail', '0', '0');
INSERT INTO `system_menu` VALUES ('28', '订单发货', 'order', 'Order@deliveryHandle,Order@delivery_info,Order@delivery_list', '0', '0');
INSERT INTO `system_menu` VALUES ('29', '退换货处理', 'order', 'Order@return_del,Order@return_info,Order@add_return_goods,Order@ajax_return_list,Order@return_list', '0', '0');
INSERT INTO `system_menu` VALUES ('30', '拆分订单', 'order', 'Order@split_order,Order@search_goods', '0', '0');
INSERT INTO `system_menu` VALUES ('31', '修改订单', 'system', 'Order@edit_order,Order@search_goods', '0', '0');
INSERT INTO `system_menu` VALUES ('32', '添加订单', 'order', 'Order@add_order,Order@search_goods', '0', '0');
INSERT INTO `system_menu` VALUES ('33', '处理订单', 'order', 'Order@pay_cancel,Order@delete_order,Order@order_action,Order@editprice,Order@order_log', '0', '0');
INSERT INTO `system_menu` VALUES ('34', '导出订单', 'order', 'Order@export_order', '0', '0');
INSERT INTO `system_menu` VALUES ('35', '打印订单', 'order', 'Order@order_print,Order@shipping_print', '0', '0');
INSERT INTO `system_menu` VALUES ('36', '插件列表', 'tools', 'Plugin@index,Plugin@install,Plugin@setting', '0', '0');
INSERT INTO `system_menu` VALUES ('37', '打印设置', 'tools', 'Plugin@shipping_list,Plugin@shipping_desc,Plugin@shipping_print,Plugin@edit_shipping_print,Plugin@shipping_list_edit,Plugin@del_area', '0', '0');
INSERT INTO `system_menu` VALUES ('38', '数据备份', 'tools', 'Tools@index,Tools@backup,Tools@optimize,Tools@repair', '0', '0');
INSERT INTO `system_menu` VALUES ('39', '数据还原', 'tools', 'Tools@restore,Tools@restoreData,Tools@restoreUpload,Tools@downFile,Tools@delSqlFiles', '0', '0');
INSERT INTO `system_menu` VALUES ('40', '地区管理', 'tools', 'Tools@region,Tools@regionHandle', '0', '0');
INSERT INTO `system_menu` VALUES ('41', '公众号设置', 'marketing', 'Wechat@index,Wechat@setting,Wechat@get_access_token,Wechat@select_goods', '0', '0');
INSERT INTO `system_menu` VALUES ('42', '文本回复', 'tools', 'Wechat@text,Wechat@add_text,Wechat@del_text', '0', '0');
INSERT INTO `system_menu` VALUES ('43', '微信菜单', 'tools', 'Wechat@menu,Wechat@del_menu,Wechat@pub_menu', '0', '0');
INSERT INTO `system_menu` VALUES ('44', '图文回复', 'tools', 'Wechat@img,Wechat@add_img,Wechat@del_img,Wechat@preview', '0', '0');
INSERT INTO `system_menu` VALUES ('45', '模板管理', 'system', 'Template@templateList,Template@changeTemplate', '0', '0');
INSERT INTO `system_menu` VALUES ('46', '销售概况', 'count', 'Report@index,Report@finance,Report@user', '0', '0');
INSERT INTO `system_menu` VALUES ('47', '销售排行', 'count', 'Report@saleTop,Report@userTop,Report@saleList', '0', '0');
INSERT INTO `system_menu` VALUES ('48', '专题管理', 'content', 'Topic@topic,Topic@topicList,Topic@topicHandle', '0', '0');
INSERT INTO `system_menu` VALUES ('49', '操作日志', 'system', 'Admin@log,Order@order_log', '0', '0');
INSERT INTO `system_menu` VALUES ('50', '评论咨询', 'goods', 'Comment@index,Comment@detail,Comment@ask_list,Comment@ajax_ask_list,Comment@del,Comment@op,Comment@consult_info,Comment@ask_handle', '0', '0');
INSERT INTO `system_menu` VALUES ('51', '优惠券', 'marketing', 'Coupon@coupon_info,Coupon@index,Coupon@make_coupon,Coupon@ajax_get_user,Coupon@send_coupon,Coupon@send_cancel,Coupon@del_coupon,Coupon@coupon_list,Coupon@coupon_list_del', '0', '0');
INSERT INTO `system_menu` VALUES ('52', '友情链接', 'content', 'Article@link,Article@linkList,Article@linkHandle', '0', '0');
INSERT INTO `system_menu` VALUES ('53', '分销管理', 'marketing', 'Distribut@set,Distribut@remittance,Distribut@tree,Distribut@rebate_log,Distribut@ajax_lower,Distribut@withdrawals,Distribut@editRebate,Distribut@delWithdrawals,Distribut@editWithdrawals', '0', '0');
INSERT INTO `system_menu` VALUES ('60', '自提点管理', 'system', 'Pickup@index,Pickup@ajaxPickupList,Pickup@add,Pickup@edit_address', '0', '0');
INSERT INTO `system_menu` VALUES ('61', '刷新缓存', 'system', 'System@cleanCache,System@ClearGoodsHtml,System@ClearGoodsThumb,System@ClearAritcleHtml', '0', '0');
INSERT INTO `system_menu` VALUES ('62', '修改管理员密码', 'system', 'Admin@modify_pwd', '0', '0');

-- ----------------------------
-- Table structure for `system_module`
-- ----------------------------
DROP TABLE IF EXISTS `system_module`;
CREATE TABLE `system_module` (
  `mod_id` smallint(6) unsigned NOT NULL AUTO_INCREMENT,
  `module` varchar(20) DEFAULT 'module',
  `level` tinyint(4) DEFAULT '2',
  `controller` varchar(20) DEFAULT '',
  `action` varchar(30) DEFAULT '',
  `title` varchar(20) DEFAULT '',
  `visible` tinyint(4) DEFAULT '1',
  `parent_id` smallint(6) DEFAULT '0',
  `orderby` smallint(6) DEFAULT '50',
  `icon` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`mod_id`)
) ENGINE=InnoDB AUTO_INCREMENT=164 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of system_module
-- ----------------------------
INSERT INTO `system_module` VALUES ('1', 'menu', '1', '', '', '管理员管理', '1', '0', '50', null);
INSERT INTO `system_module` VALUES ('2', 'menu', '1', '', '', '部门管理', '1', '0', '50', null);
INSERT INTO `system_module` VALUES ('3', 'menu', '1', '', '', '班级管理', '1', '0', '50', null);
INSERT INTO `system_module` VALUES ('4', 'menu', '1', '', '', '学生管理', '1', '0', '50', null);
INSERT INTO `system_module` VALUES ('5', 'menu', '1', '', '', '教师管理', '1', '0', '50', null);
INSERT INTO `system_module` VALUES ('6', 'menu', '1', '', '', '督导管理', '1', '0', '50', null);
INSERT INTO `system_module` VALUES ('7', 'module', '1', 'admin', 'index.do', '管理员管理', '1', '1', '2', '');
INSERT INTO `system_module` VALUES ('8', 'module', '1', 'admin', 'toedit.do', '管理员添加', '1', '1', '3', '');
INSERT INTO `system_module` VALUES ('9', 'module', '1', 'depart', 'index.do', '部门管理', '1', '2', '50', '');
INSERT INTO `system_module` VALUES ('10', 'module', '1', 'classes', 'index.do', '班级管理', '1', '3', '50', '');
INSERT INTO `system_module` VALUES ('11', 'module', '1', 'student', 'index.do', '学生管理', '1', '4', '50', '');
INSERT INTO `system_module` VALUES ('12', 'module', '1', 'teacher', 'index.do', '教师管理', '1', '5', '50', '');
INSERT INTO `system_module` VALUES ('13', 'module', '1', 'supervisor', 'index.do', '督导管理', '1', '6', '50', '');
INSERT INTO `system_module` VALUES ('14', 'module', '1', 'student', 'toedit.do', '学生添加', '1', '4', '50', '');
INSERT INTO `system_module` VALUES ('15', 'module', '1', 'supervisor', 'toedit.do', '督导添加', '1', '6', '20', '');
INSERT INTO `system_module` VALUES ('16', 'menu', '1', '', '', '菜单管理', '1', '0', '50', null);
INSERT INTO `system_module` VALUES ('17', 'module', '1', 'classes', 'toedit.do', '班级添加', '1', '3', '50', '');
INSERT INTO `system_module` VALUES ('18', 'module', '3', 'Comment', 'index', '评论管理', '1', '10', '50', '0');
INSERT INTO `system_module` VALUES ('19', 'module', '3', 'Admin', 'role', '角色管理', '1', '7', '50', '0');
INSERT INTO `system_module` VALUES ('20', 'module', '3', 'Admin', 'index', '管理员列表', '1', '7', '50', '0');
INSERT INTO `system_module` VALUES ('21', 'module', '3', 'System', 'menu', '菜单管理', '1', '8', '50', '0');
INSERT INTO `system_module` VALUES ('22', 'module', '3', 'System', 'module', '模块管理', '1', '8', '50', '0');
INSERT INTO `system_module` VALUES ('23', 'module', '3', 'Admin', 'log', '管理员日志', '1', '7', '50', '0');
INSERT INTO `system_module` VALUES ('24', 'module', '3', 'Goods', 'categoryList', '商品分类', '1', '11', '50', '0');
INSERT INTO `system_module` VALUES ('25', 'module', '3', 'Goods', 'goodsList', '商品列表', '1', '11', '50', '0');
INSERT INTO `system_module` VALUES ('26', 'module', '3', 'Goods', 'goodsTypeList', '商品类型', '1', '11', '50', '0');
INSERT INTO `system_module` VALUES ('27', 'module', '3', 'Goods', 'specList', '商品规格', '1', '11', '50', '0');
INSERT INTO `system_module` VALUES ('28', 'module', '3', 'Goods', 'goodsAttributeList', '商品属性', '1', '11', '50', '0');
INSERT INTO `system_module` VALUES ('29', 'module', '3', 'Goods', 'brandList', '商品品牌', '1', '11', '50', '0');
INSERT INTO `system_module` VALUES ('30', 'module', '3', 'Order', 'index', '订单列表', '1', '17', '50', '0');
INSERT INTO `system_module` VALUES ('31', 'module', '3', 'Order', 'delivery_list', '发货单列表', '1', '17', '50', '0');
INSERT INTO `system_module` VALUES ('32', 'module', '3', 'Order', 'return_list', '退货单列表', '1', '17', '50', '0');
INSERT INTO `system_module` VALUES ('33', 'module', '3', 'User', 'levelList', '会员等级', '1', '10', '50', '0');
INSERT INTO `system_module` VALUES ('34', 'module', '3', 'User', 'index', '会员列表', '1', '10', '50', '0');
INSERT INTO `system_module` VALUES ('35', 'module', '3', 'System', 'index', '网站设置', '1', '9', '50', '0');
INSERT INTO `system_module` VALUES ('36', 'module', '3', 'System', 'navigationList', '导航设置', '1', '9', '50', '0');
INSERT INTO `system_module` VALUES ('37', 'module', '3', 'Ad', 'positionList', '广告位', '1', '13', '50', '0');
INSERT INTO `system_module` VALUES ('38', 'module', '3', 'Ad', 'adList', '广告列表', '1', '13', '50', '0');
INSERT INTO `system_module` VALUES ('39', 'module', '3', 'Article', 'categoryList', '文章分类', '1', '12', '50', '0');
INSERT INTO `system_module` VALUES ('40', 'module', '3', 'Article', 'articleList', '文章列表', '1', '12', '50', '0');
INSERT INTO `system_module` VALUES ('41', 'module', '3', 'Article', 'linkList', '友情链接', '1', '12', '50', '0');
INSERT INTO `system_module` VALUES ('42', 'module', '3', 'Topic', 'topicList', '专题列表', '1', '12', '50', '0');
INSERT INTO `system_module` VALUES ('43', 'module', '3', 'Coupon', 'index', '优惠券', '1', '14', '50', '0');
INSERT INTO `system_module` VALUES ('44', 'module', '2', 'menu', 'index', '菜单管理', '1', '16', '50', null);
INSERT INTO `system_module` VALUES ('46', 'module', '2', 'menu', 'toedit', '菜单添加', '1', '16', '50', null);
INSERT INTO `system_module` VALUES ('49', 'module', '3', 'Plugin', 'index', '插件列表', '1', '15', '50', '0');
INSERT INTO `system_module` VALUES ('50', 'module', '3', 'Promotion', 'index', '组合促销', '0', '14', '50', '0');
INSERT INTO `system_module` VALUES ('51', 'module', '1', 'depart', 'toedit.do', '部门添加', '1', '2', '50', '');
INSERT INTO `system_module` VALUES ('52', 'module', '3', 'Template', 'templateList?t=pc', 'PC端模板', '1', '51', '50', '0');
INSERT INTO `system_module` VALUES ('53', 'module', '3', 'Template', 'templateList?t=mobile', '手机端模板', '1', '51', '50', '0');
INSERT INTO `system_module` VALUES ('54', 'module', '3', 'Tools', 'index', '数据备份', '1', '15', '50', null);
INSERT INTO `system_module` VALUES ('56', 'module', '3', 'report', 'index', '销售概况', '1', '55', '50', null);
INSERT INTO `system_module` VALUES ('57', 'module', '3', 'report', 'saleTop', '销售排行', '1', '55', '50', null);
INSERT INTO `system_module` VALUES ('58', 'module', '3', 'report', 'userTop', '会员排行', '1', '55', '50', null);
INSERT INTO `system_module` VALUES ('59', 'module', '3', 'Promotion', 'group_buy_list', '团购管理', '1', '14', '50', null);
INSERT INTO `system_module` VALUES ('60', 'module', '3', 'report', 'saleList', '销售明细', '1', '55', '50', null);
INSERT INTO `system_module` VALUES ('61', 'module', '3', 'report', 'user', '会员统计', '1', '55', '50', null);
INSERT INTO `system_module` VALUES ('62', 'module', '3', 'Promotion', 'flash_sale', '限时抢购', '1', '14', '50', null);
INSERT INTO `system_module` VALUES ('63', 'module', '3', 'Tools', 'restore', '数据还原', '1', '15', '50', null);
INSERT INTO `system_module` VALUES ('64', 'module', '3', 'Order', 'add_order', '添加订单', '1', '17', '50', null);
INSERT INTO `system_module` VALUES ('65', 'module', '3', 'report', 'finance', '财务统计', '1', '55', '50', null);
INSERT INTO `system_module` VALUES ('66', 'module', '3', 'Admin', 'role_info', '编辑角色', '0', '7', '50', null);
INSERT INTO `system_module` VALUES ('67', 'module', '3', 'Admin', 'role_save', '保存角色', '0', '7', '50', null);
INSERT INTO `system_module` VALUES ('68', 'module', '3', 'Admin', 'roleDel', '删除角色', '0', '7', '50', null);
INSERT INTO `system_module` VALUES ('69', 'module', '3', 'Admin', 'admin_info', '编辑管理员', '0', '7', '50', null);
INSERT INTO `system_module` VALUES ('70', 'module', '3', 'Admin', 'adminHandle', '保存管理员', '0', '7', '50', null);
INSERT INTO `system_module` VALUES ('71', 'module', '3', 'System', 'create_menu', '添加菜单', '0', '8', '50', null);
INSERT INTO `system_module` VALUES ('72', 'module', '3', 'System', 'menuSave', '保存菜单', '0', '8', '50', null);
INSERT INTO `system_module` VALUES ('73', 'module', '3', 'System', 'ctl_detail', '添加控制模块', '0', '8', '50', null);
INSERT INTO `system_module` VALUES ('74', 'module', '3', 'System', 'ctlSave', '保存控制模块', '0', '8', '50', null);
INSERT INTO `system_module` VALUES ('75', 'module', '3', 'System', 'handle', '保存设置', '0', '9', '50', null);
INSERT INTO `system_module` VALUES ('76', 'module', '3', 'System', 'addEditNav', '保存导航', '0', '9', '50', null);
INSERT INTO `system_module` VALUES ('77', 'module', '3', 'Template', 'changeTemplate', '切换模板', '0', '51', '50', null);
INSERT INTO `system_module` VALUES ('78', 'module', '3', 'System', 'delNav', '删除导航', '0', '9', '50', null);
INSERT INTO `system_module` VALUES ('79', 'module', '3', 'Comment', 'detail', '评论详情', '0', '10', '50', null);
INSERT INTO `system_module` VALUES ('80', 'module', '3', 'Comment', 'op', '评论回复', '0', '10', '50', null);
INSERT INTO `system_module` VALUES ('81', 'module', '3', 'Comment', 'del', '删除评论', '0', '10', '50', null);
INSERT INTO `system_module` VALUES ('82', 'module', '3', 'User', 'level', '新增等级', '0', '10', '50', null);
INSERT INTO `system_module` VALUES ('83', 'module', '3', 'User', 'levelHandle', '保存等级', '0', '10', '50', null);
INSERT INTO `system_module` VALUES ('84', 'module', '3', 'User', 'detail', '查看会员', '0', '10', '50', null);
INSERT INTO `system_module` VALUES ('85', 'module', '3', 'User', 'account_log', '会员消费记录', '0', '10', '50', null);
INSERT INTO `system_module` VALUES ('86', 'module', '3', 'User', 'account_edit', '会员资金调节', '0', '10', '50', null);
INSERT INTO `system_module` VALUES ('87', 'module', '3', 'User', 'address', '会员收货地址', '0', '10', '50', null);
INSERT INTO `system_module` VALUES ('88', 'module', '3', 'Goods', 'addEditGoods', '新增商品', '0', '11', '50', null);
INSERT INTO `system_module` VALUES ('89', 'module', '3', 'Goods', 'addEditCategory', '编辑商品分类', '0', '11', '50', null);
INSERT INTO `system_module` VALUES ('90', 'module', '3', 'Goods', 'delGoodsCategory', '删除商品分类', '0', '11', '50', null);
INSERT INTO `system_module` VALUES ('91', 'module', '3', 'Goods', 'changeGoodsField', '修改商品字段', '0', '11', '50', null);
INSERT INTO `system_module` VALUES ('92', 'module', '3', 'Goods', 'addEditGoodsType', '编辑商品类型', '0', '11', '50', null);
INSERT INTO `system_module` VALUES ('93', 'module', '3', 'Goods', 'addEditGoodsAttribute', '编辑商品属性', '0', '11', '50', null);
INSERT INTO `system_module` VALUES ('94', 'module', '3', 'Goods', 'delGoods', '删除商品', '0', '11', '50', null);
INSERT INTO `system_module` VALUES ('95', 'module', '3', 'Goods', 'delGoodsType', '删除商品类型', '0', '11', '50', null);
INSERT INTO `system_module` VALUES ('96', 'module', '3', 'Goods', 'delGoodsAttribute', '删除商品属性', '0', '11', '50', null);
INSERT INTO `system_module` VALUES ('97', 'module', '3', 'Goods', 'delGoodsSpec', '删除商品规格', '0', '11', '50', null);
INSERT INTO `system_module` VALUES ('98', 'module', '3', 'Goods', 'addEditSpec', '编辑商品规格', '0', '11', '50', null);
INSERT INTO `system_module` VALUES ('99', 'module', '3', 'Goods', 'addEditBrand', '编辑品牌', '0', '11', '50', null);
INSERT INTO `system_module` VALUES ('100', 'module', '3', 'Goods', 'delBrand', '删除品牌', '0', '11', '50', null);
INSERT INTO `system_module` VALUES ('101', 'module', '3', 'Coupon', 'coupon_info', '添加优惠券', '0', '14', '50', null);
INSERT INTO `system_module` VALUES ('102', 'module', '3', 'Promotion', 'group_buy', '添加团购', '0', '14', '50', null);
INSERT INTO `system_module` VALUES ('103', 'module', '3', 'Promotion', 'groupbuyHandle', '保存团购', '0', '14', '50', null);
INSERT INTO `system_module` VALUES ('104', 'module', '3', 'Promotion', 'get_goods', '选择商品', '0', '14', '50', null);
INSERT INTO `system_module` VALUES ('105', 'module', '3', 'Coupon', 'coupon_info', '编辑优惠券', '0', '14', '50', null);
INSERT INTO `system_module` VALUES ('106', 'module', '3', 'Coupon', 'del_coupon', '删除优惠券', '0', '14', '50', null);
INSERT INTO `system_module` VALUES ('107', 'module', '3', 'Coupon', 'send_coupon', '发放优惠券', '0', '14', '50', null);
INSERT INTO `system_module` VALUES ('108', 'module', '3', 'Order', 'edit_order', '编辑订单', '0', '17', '50', null);
INSERT INTO `system_module` VALUES ('109', 'module', '3', 'Order', 'split_order', '拆分订单', '0', '17', '50', null);
INSERT INTO `system_module` VALUES ('110', 'module', '3', 'Order', 'deatil', '订单详情', '0', '17', '50', null);
INSERT INTO `system_module` VALUES ('111', 'module', '3', 'Order', 'editprice', '修改订单金额', '0', '17', '50', null);
INSERT INTO `system_module` VALUES ('112', 'module', '3', 'Order', 'delete_order', '删除订单', '0', '17', '50', null);
INSERT INTO `system_module` VALUES ('113', 'module', '3', 'Order', 'pay_cancel', '取消付款', '0', '17', '50', null);
INSERT INTO `system_module` VALUES ('114', 'module', '3', 'Order', 'order_print', '订单打印', '0', '17', '50', null);
INSERT INTO `system_module` VALUES ('115', 'module', '3', 'Order', 'shipping_print', '打印快递', '0', '17', '50', null);
INSERT INTO `system_module` VALUES ('116', 'module', '3', 'Order', 'deliveryHandle', '发货处理', '0', '17', '50', null);
INSERT INTO `system_module` VALUES ('117', 'module', '3', 'Order', 'delivery_info', '发货单详情', '0', '17', '50', null);
INSERT INTO `system_module` VALUES ('118', 'module', '3', 'Order', 'return_info', '退货单信息', '0', '17', '50', null);
INSERT INTO `system_module` VALUES ('119', 'module', '3', 'Order', 'return_del', '删除退货单', '0', '17', '50', null);
INSERT INTO `system_module` VALUES ('120', 'module', '3', 'Order', 'order_action', '订单流程处理', '0', '17', '50', null);
INSERT INTO `system_module` VALUES ('121', 'module', '3', 'Order', 'export_order', '导出订单', '0', '17', '50', null);
INSERT INTO `system_module` VALUES ('122', 'module', '3', 'Order', 'search_goods', '搜索商品', '0', '17', '50', null);
INSERT INTO `system_module` VALUES ('123', 'module', '3', 'Order', 'add_return_goods', '生成退货单', '0', '17', '50', null);
INSERT INTO `system_module` VALUES ('124', 'module', '3', 'Article', 'category', '编辑文章分类', '0', '12', '50', null);
INSERT INTO `system_module` VALUES ('125', 'module', '3', 'Article', 'categoryHandle', '保存文章分类', '0', '12', '50', null);
INSERT INTO `system_module` VALUES ('126', 'module', '3', 'Article', 'article', '编辑文章', '0', '12', '50', null);
INSERT INTO `system_module` VALUES ('127', 'module', '3', 'Article', 'aticleHandle', '保存文章', '0', '12', '50', null);
INSERT INTO `system_module` VALUES ('128', 'module', '3', 'Article', 'link', '编辑友情链接', '0', '12', '50', null);
INSERT INTO `system_module` VALUES ('129', 'module', '3', 'Article', 'linkHandle', '保存友情链接', '0', '12', '50', null);
INSERT INTO `system_module` VALUES ('130', 'module', '3', 'Topic', 'topic', '新增专题', '0', '12', '50', null);
INSERT INTO `system_module` VALUES ('131', 'module', '3', 'Topic', 'topicHandle', '保存专题', '0', '12', '50', null);
INSERT INTO `system_module` VALUES ('132', 'module', '3', 'Ad', 'position', '添加广告位', '0', '13', '50', null);
INSERT INTO `system_module` VALUES ('133', 'module', '3', 'Ad', 'positionHandle', '保存广告位', '0', '13', '50', null);
INSERT INTO `system_module` VALUES ('134', 'module', '3', 'Ad', 'ad', '添加广告', '0', '13', '50', null);
INSERT INTO `system_module` VALUES ('135', 'module', '3', 'Ad', 'adHandle', '保存广告', '0', '13', '50', null);
INSERT INTO `system_module` VALUES ('136', 'module', '3', 'Tools', 'backup', '生成备份文件', '0', '15', '50', null);
INSERT INTO `system_module` VALUES ('137', 'module', '3', 'Tools', 'restoreData', '还原SQL文件', '0', '15', '50', null);
INSERT INTO `system_module` VALUES ('138', 'module', '3', 'Tools', 'optimize', '优化数据表', '0', '15', '50', null);
INSERT INTO `system_module` VALUES ('139', 'module', '3', 'Tools', 'repair', '修改数据表', '0', '15', '50', null);
INSERT INTO `system_module` VALUES ('140', 'module', '3', 'Tools', 'restoreUpload', '上传SQL文件', '0', '15', '50', null);
INSERT INTO `system_module` VALUES ('141', 'module', '3', 'Tools', 'downFile', '下载SQL文件', '0', '15', '50', null);
INSERT INTO `system_module` VALUES ('142', 'module', '3', 'Tools', 'delSqlFiles', '删除SQL文件', '0', '15', '50', null);
INSERT INTO `system_module` VALUES ('143', 'module', '3', 'Promotion', 'prom_order_list', '订单促销', '1', '14', '50', null);
INSERT INTO `system_module` VALUES ('144', 'module', '3', 'Promotion', 'bargain', '砍价管理', '0', '14', '50', null);
INSERT INTO `system_module` VALUES ('146', 'module', '3', 'Promotion', 'prom_goods_list', '商品促销', '1', '14', '50', null);
INSERT INTO `system_module` VALUES ('148', 'module', '3', 'Distribut', 'tree', '分销关系', '1', '145', '50', null);
INSERT INTO `system_module` VALUES ('149', 'module', '3', 'Distribut', 'set', '分销设置', '1', '145', '50', null);
INSERT INTO `system_module` VALUES ('150', 'module', '3', 'Distribut', 'withdrawals', '提现申请记录', '1', '145', '50', null);
INSERT INTO `system_module` VALUES ('151', 'module', '3', 'Distribut', 'remittance', '汇款记录', '1', '145', '50', null);
INSERT INTO `system_module` VALUES ('152', 'module', '3', 'Distribut', 'rebate_log', '分成记录', '1', '145', '50', null);
INSERT INTO `system_module` VALUES ('153', 'module', '3', 'Tools', 'region', '地区管理', '1', '15', '50', null);
INSERT INTO `system_module` VALUES ('154', 'module', '3', 'Comment', 'ask_list', '商品咨询', '1', '10', '50', null);
INSERT INTO `system_module` VALUES ('155', 'menu', '1', '', '', '标准管理', '1', '0', '50', '');
INSERT INTO `system_module` VALUES ('156', 'module', '1', 'criteria', 'index.do?pid=1', '学生标准', '1', '155', '50', '');
INSERT INTO `system_module` VALUES ('157', 'module', '1', 'criteria', 'toedit.do', '标准添加', '1', '155', '50', '');
INSERT INTO `system_module` VALUES ('158', 'menu', '1', '', '', '系统配置', '1', '0', '50', '');
INSERT INTO `system_module` VALUES ('159', 'module', '1', 'config', 'index.do', '配置管理', '1', '158', '50', '');
INSERT INTO `system_module` VALUES ('160', 'module', '1', 'config', 'toedit.do', '配置添加', '1', '158', '50', '');
INSERT INTO `system_module` VALUES ('161', 'module', '1', 'teacher', 'toedit.do', '教师添加', '1', '5', '50', '');
INSERT INTO `system_module` VALUES ('162', 'module', '1', 'criteria', 'index.do?pid=2', '教师标准', '1', '155', '50', '');
INSERT INTO `system_module` VALUES ('163', 'module', '1', 'criteria', 'index.do?pid=3', '专家标准', '1', '155', '50', '');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) NOT NULL,
  `userNo` varchar(20) NOT NULL,
  `password` varchar(50) NOT NULL,
  `major` varchar(30) DEFAULT NULL,
  `departId` int(11) DEFAULT NULL,
  `ranks` varchar(20) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `type` tinyint(4) DEFAULT NULL,
  `classesId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=147 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('67', '刘莉', '20150871', 'FF2A694460A86BFA017009C753BF286D', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('68', '陈佩霞', '20151092', '7B9DD6F70FC3B51E39908B72AA3A5861', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('69', '蒋吓女', '20151221', '90E132F1DE44208A7CA7C746A7760155', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('70', '许丽美', '20151224', '17023DBDA2AD99707AB9206B72BA3BAD', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('71', '钟玲', '20151226', '105937F4D67DDAC5DF18D8121A0532BF', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('72', '陈婧', '20151234', 'C8D33171C6E5010B6FD157DFA9347B51', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('73', '曹漫飞', '20151239', 'E2EBB9A8853EB159C4FFFAE1721D8A63', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('74', '郑凤娟', '20151329', '4089BA80162AFAD497B5E33D1AE3DD20', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('75', '寿柯飞', '20151335', 'EA5664AF2C9199A579093364BAAC6B59', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('76', '金怡沁', '20151337', '69D909DABB807C17856185F97833CDD0', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('77', '李依依', '20151339', '1B0522F767310A788CB75FDD61C88412', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('78', '陈楚君', '20151491', 'D3F066DA9AB961EC179BDB53BC609D6F', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('79', '王蕤', '20151505', '2ED9145E29A7E63D1227A90C31B252F9', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('80', '林婷婷', '20151516', '92261C66303D014CB4C8ACBCA7E340E1', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('81', '冯婷', '20151584', '1A2C0DBCB96D3C26FEAAC60CB4892F7E', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('82', '柯思瀛', '20151633', 'B9144BB7BF3B4B597036F8ADB385962E', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('83', '吴雪兰', '20151701', 'BD56DCFE9E72775C3192ABD911041A02', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('84', '苏达金', '20151718', 'AD31A7B28C0D589022A000B8507F7F17', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('85', '张璟婷', '20151732', '2C72026EFB959780DFDB6C9E1539A44D', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('86', '陈玲招', '20151785', '01AB4A6A575AD07ACDAB5B1D3F99EA52', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('87', '黄小银', '20151830', '71CEB7ACE8AC6548FFC24E8843F43BB4', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('88', '缪楚', '20151842', '2B4438658BDD61473D2244DA30CDEE22', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('89', '吴丽妃', '20151852', 'D20F534EC68DE93C04642CABC51A1035', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('90', '张梦媛', '20151879', 'AE0C58E8E9A6EBDF002DD8FBBB5F5235', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('91', '李月文', '20152035', '72A5A7AF758DF859E77494FC8AF8327A', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('92', '包谢辉', '20150858', 'D7465BA75AD9E7ECCEF5423E85957E3D', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('93', '陈志坤', '20150862', '0BEABA3973A18D497EF60DE09E44D33E', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('94', '官铖涵', '20150866', 'A826A4076D406703776D79BEF699292B', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('95', '林中钰', '20150869', 'C6518FA6A58CA71D68B151F71A754F24', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('96', '赖小武', '20150872', 'B6ED1D8ADB1208ABF0C0882F8C4F16A4', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('97', '池文标', '20150874', 'A11ACC540BD4C9C0173189DF4F7D1B0D', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('98', '陈彬', '20150876', '08941883E624BE7B51C07F18C5FB3697', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('99', '林方杰', '20150878', '5D340A596390B41D540553426B1DD73F', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('100', '刘晓祁', '20150880', '6FF5ED1CC2FE13BE2FE1490C1C697172', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('101', '王敬皓', '20151074', '46B1B3A8FD884C039B2472AFE27711DF', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('102', '高相州', '20151222', '34DC2968193711A2F4E42D2346855779', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('103', '唐晓亮', '20151229', '57DC41EE3B171EDDC4BB182DBF90418D', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('104', '华沛德', '20151231', '1299F2AA27B9EB09F7351E27D2C81284', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('105', '杨元超', '20151236', '6D10864CBB5AF6D1275DA26BD72D53B9', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('106', '徐文达', '20151319', 'E824974C3DEEF12E7D8D0DBD6B034B0F', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('107', '虞纯淼', '20151322', '6E5DEEA5FACD4CA71E7D3E08EF052034', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('108', '罗灵杰', '20151324', 'F3F98E0804CC5D1E4ADA44ACDB2732AF', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('109', '范志铖', '20151326', '76290E206A68581DB241B1CC11C5916C', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('110', '滕佳杰', '20151328', 'B97AFFE914965B29CE8AEE09D3F9A877', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('111', '李昊鹏', '20151332', '66D26917E2CE548611B443FC13F334B8', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('112', '黎根深', '20151334', 'A8E57671B5EC612E444A745DF48C39FD', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('113', '刘用品', '20151442', 'A3A6D3222DEC8611444EB2A119A7668B', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('114', '陈约华', '20151492', 'EC63BC233DCFB239F067300F989B0186', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('115', '何海健', '20151551', 'EE69B90E4858B01F71C8A740F935BCC5', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('116', '魏伟明', '20151565', '81B25B3B9652161DA3874AA8B8114FD0', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('117', '黄裕华', '20151654', '25E62D17DA3DA4CA08CFB17C1F363720', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('118', '黄伟光', '20151662', 'BE445E6B16A1DA6CC8353A112531CE42', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('119', '林汉艺', '20151690', '62D4E61B3B8E5BC572911FB44FB53732', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('120', '方思远', '20151713', 'A4DE246496885ABD4F8B52CABB09E3F0', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('121', '张昊然', '20151721', '91DFCF50D295CD70DB9B11EF89C868F1', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('122', '周雨晨', '20151736', 'EDD20C542E6205567751E1B75E1B1991', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('123', '刘又嘉', '20151761', '05B9ABAD633F95BC76A932483B22C262', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('124', '潘平平', '20151855', '2BC1FC3C1E6C0071A5FE506CB3F5899B', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('125', '陈福', '20151886', '95AEB3C60C1046283B24663C5EA46308', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('126', '李跃林', '20151936', '0FA6CB554EC0AF2D7FB8ACA5D8BC21AC', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('127', '范和雍', '20152018', '317F0CB60FFE5F494E8EFBBB23E34699', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('128', '曾仲豪', '20150860', 'B9370129409E3712C7059F76E9CEF6A4', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('129', '王文豪', '20150879', 'B235F6BD1C810AFC871B694BD8465738', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('130', '金天星', '20151072', 'F562CE6B95E2CEAC297FF5FB20DEAD92', null, '1', null, '1', '1', '3');
INSERT INTO `user` VALUES ('131', '许瑞斌', '04003', '4C8751AB476E16A759DDA6E32AB85888', '计算机技术', '1', '讲师', '1', '2', null);
INSERT INTO `user` VALUES ('132', '许戈静', '05001', '0733203973A947DA0A4A49A6632AE85F', '计算机技术', '1', '讲师', '1', '2', null);
INSERT INTO `user` VALUES ('133', '林玉梅', '05006', '393B021D46845B8DE3E5D3F6EDBAFC70', '计算机技术', '1', '讲师', '1', '2', null);
INSERT INTO `user` VALUES ('134', '郭新华', '05007', 'FA51D924136767D6AE3633E38DCE1815', '计算机技术', '1', '讲师', '1', '2', null);
INSERT INTO `user` VALUES ('135', '杨秀菊', '06001', 'F7952DD6481227CECFF529D8222FABC3', '计算机技术', '1', '讲师', '1', '2', null);
INSERT INTO `user` VALUES ('136', '林博艺', '06004', '069B2726F4CA89C9DB37CED7B6BDDDB2', '计算机技术', '1', '讲师', '1', '2', null);
INSERT INTO `user` VALUES ('137', '杨岚', '06005', '722A96A56CCC9E99EBB6DA31A2A37421', '计算机技术', '1', '讲师', '1', '2', null);
INSERT INTO `user` VALUES ('138', '张梅娇', '06006', 'D189FBB376015EFA4D813C968BD89899', '计算机技术', '1', '讲师', '1', '2', null);
INSERT INTO `user` VALUES ('139', '苏乐辉', '07004', '3891753326E02F1599C3BDBF483DCB3F', '计算机技术', '1', '讲师', '1', '2', null);
INSERT INTO `user` VALUES ('140', '付长凤', '07006', '1DB4944195242321AFE528A7AA9FA0BC', '计算机技术', '1', '讲师', '1', '2', null);
INSERT INTO `user` VALUES ('141', '黄丽凤', '08002', '149257188AB16797C8776944DBD6E2F4', '计算机技术', '1', '讲师', '1', '2', null);
INSERT INTO `user` VALUES ('142', '苏延平', '08003', 'C13A90EB34E2BB45A4BFF8778CFB43DC', '计算机技术', '1', '讲师', '1', '2', null);
INSERT INTO `user` VALUES ('143', '苏荣辉', '09003', '14BE2AC8B1EF0593C8CAA724F89FB176', '计算机技术', '1', '讲师', '1', '2', null);
INSERT INTO `user` VALUES ('144', '吴宗波', '09010', 'B881EE0186C56A53AB7FB8A9D9788964', '计算机技术', '1', '讲师', '1', '2', null);
INSERT INTO `user` VALUES ('145', '何天兰', '09011', '948B962877DD5DD20F423060717D0037', '计算机技术', '1', '讲师', '1', '2', null);
INSERT INTO `user` VALUES ('146', '测试督导', '100910', '50589E2E7CEA5C528BE316C3F1123FB7', '计算机技术', '2', '教授', '1', '3', null);

-- ----------------------------
-- Table structure for `user_classes`
-- ----------------------------
DROP TABLE IF EXISTS `user_classes`;
CREATE TABLE `user_classes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `classes_id` int(11) DEFAULT NULL,
  `ceatetime` date DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_classes
-- ----------------------------
INSERT INTO `user_classes` VALUES ('9', '144', '4', '2018-05-01');
INSERT INTO `user_classes` VALUES ('12', '144', '3', '2018-05-01');
INSERT INTO `user_classes` VALUES ('16', '144', '1', '2018-05-01');
INSERT INTO `user_classes` VALUES ('17', '144', '2', '2018-05-01');
