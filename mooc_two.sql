/*
Navicat MySQL Data Transfer

Source Server         : 本地数据库
Source Server Version : 50640
Source Host           : localhost:3306
Source Database       : mooc_two

Target Server Type    : MYSQL
Target Server Version : 50640
File Encoding         : 65001

Date: 2019-01-13 17:06:39
*/

SET FOREIGN_KEY_CHECKS=0;
create table `order_record` (
	`id` int(11) not null auto_increment comment '主键',
	`item_id` int(11) not null comment '商品ID',
	`total` int(11) not null comment '数量',
	`customer_name` varchar(255) not null default '' comment '客户姓名',
	`order_time` datetime default null comment '下单时间',
	`is_active` int(255) not null default '1' comment '是否有效',
	`update_time` timestamp null default null on update current_timestamp comment '更新时间',
	primary key (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='下单记录表';