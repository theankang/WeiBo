/*
Navicat MySQL Data Transfer

Source Server         : connection
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : weibo_db

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2016-12-06 17:02:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for attention_group_member_table
-- ----------------------------
DROP TABLE IF EXISTS `attention_group_member_table`;
CREATE TABLE `attention_group_member_table` (
  `user_id` char(11) NOT NULL,
  `ag_id` char(12) NOT NULL,
  PRIMARY KEY (`user_id`,`ag_id`),
  CONSTRAINT `att_grp_tbl_fk1` FOREIGN KEY (`user_id`) REFERENCES `user_table` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for attention_group_table
-- ----------------------------
DROP TABLE IF EXISTS `attention_group_table`;
CREATE TABLE `attention_group_table` (
  `ag_id` char(12) NOT NULL,
  `ag_member_sum` int(11) NOT NULL,
  `ag_name` varchar(20) NOT NULL,
  PRIMARY KEY (`ag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for favorite_table
-- ----------------------------
DROP TABLE IF EXISTS `favorite_table`;
CREATE TABLE `favorite_table` (
  `favorite_id` char(11) NOT NULL,
  `user_id` char(11) NOT NULL,
  `message_id` char(11) NOT NULL,
  PRIMARY KEY (`favorite_id`),
  KEY `fav_tbl_fk1` (`user_id`),
  KEY `fav_tbl_fk2` (`message_id`),
  CONSTRAINT `fav_tbl_fk1` FOREIGN KEY (`user_id`) REFERENCES `user_table` (`user_id`),
  CONSTRAINT `fav_tbl_fk2` FOREIGN KEY (`message_id`) REFERENCES `message_table` (`message_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for forward_table
-- ----------------------------
DROP TABLE IF EXISTS `forward_table`;
CREATE TABLE `forward_table` (
  `forward_id` char(11) NOT NULL,
  `user_id` char(11) NOT NULL,
  `source_message_id` char(11) NOT NULL,
  `source_user_id` char(11) NOT NULL,
  PRIMARY KEY (`forward_id`),
  KEY `fod_tbl_fk1` (`source_message_id`),
  KEY `fod_tbl_fk2` (`user_id`),
  KEY `fod_tbl_fk3` (`source_user_id`),
  CONSTRAINT `fod_tbl_fk1` FOREIGN KEY (`source_message_id`) REFERENCES `message_table` (`message_id`),
  CONSTRAINT `fod_tbl_fk2` FOREIGN KEY (`user_id`) REFERENCES `user_table` (`user_id`),
  CONSTRAINT `fod_tbl_fk3` FOREIGN KEY (`source_user_id`) REFERENCES `user_table` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for message_reply_table
-- ----------------------------
DROP TABLE IF EXISTS `message_reply_table`;
CREATE TABLE `message_reply_table` (
  `reply_id` char(11) NOT NULL,
  `message_id` char(11) NOT NULL,
  `user_id` char(11) NOT NULL,
  `reply_time` datetime NOT NULL,
  `reply_content` varchar(255) NOT NULL,
  PRIMARY KEY (`reply_id`),
  KEY `msg_rpy_fk1` (`message_id`),
  KEY `msg_rpy_fk2` (`user_id`),
  CONSTRAINT `msg_rpy_fk1` FOREIGN KEY (`message_id`) REFERENCES `message_table` (`message_id`),
  CONSTRAINT `msg_rpy_fk2` FOREIGN KEY (`user_id`) REFERENCES `user_table` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for message_table
-- ----------------------------
DROP TABLE IF EXISTS `message_table`;
CREATE TABLE `message_table` (
  `message_id` char(16) NOT NULL,
  `message_content` varchar(255) NOT NULL,
  `links` varchar(150) DEFAULT NULL,
  `message_favorite` int(11) NOT NULL,
  `message_reply` int(11) NOT NULL,
  `message_forward` int(11) NOT NULL,
  `message_published_time` datetime NOT NULL,
  `user_id` char(11) NOT NULL,
  `topic_id` char(11) DEFAULT NULL,
  `forward_id` char(11) DEFAULT NULL,
  PRIMARY KEY (`message_id`),
  KEY `message_table_fk3` (`forward_id`),
  KEY `FKstf0qodk5vapq4via4wj9k1p5` (`user_id`),
  KEY `FKlrus1ud0m8i3bs56bsgnk37x9` (`topic_id`),
  CONSTRAINT `FKlrus1ud0m8i3bs56bsgnk37x9` FOREIGN KEY (`topic_id`) REFERENCES `topic_table` (`topic_id`),
  CONSTRAINT `FKstf0qodk5vapq4via4wj9k1p5` FOREIGN KEY (`user_id`) REFERENCES `user_table` (`user_id`),
  CONSTRAINT `message_table_fk1` FOREIGN KEY (`user_id`) REFERENCES `user_table` (`user_id`),
  CONSTRAINT `message_table_fk2` FOREIGN KEY (`topic_id`) REFERENCES `topic_table` (`topic_id`),
  CONSTRAINT `message_table_fk3` FOREIGN KEY (`forward_id`) REFERENCES `forward_table` (`forward_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for topic_table
-- ----------------------------
DROP TABLE IF EXISTS `topic_table`;
CREATE TABLE `topic_table` (
  `topic_id` char(11) NOT NULL,
  `topic_sum` int(11) NOT NULL,
  `topic_name` varchar(20) NOT NULL,
  `topic_content` varchar(255) NOT NULL,
  PRIMARY KEY (`topic_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for topic_table_message_table
-- ----------------------------
DROP TABLE IF EXISTS `topic_table_message_table`;
CREATE TABLE `topic_table_message_table` (
  `Topic_topic_id` varchar(11) NOT NULL,
  `messageSet_message_id` varchar(16) NOT NULL,
  PRIMARY KEY (`Topic_topic_id`,`messageSet_message_id`),
  UNIQUE KEY `UK_d0kgtmkiceyqj498mdpe6f2jx` (`messageSet_message_id`),
  CONSTRAINT `FK5hl8yrtikp97ny90hg0hont6l` FOREIGN KEY (`messageSet_message_id`) REFERENCES `message_table` (`message_id`),
  CONSTRAINT `FKq0446esxuxrqeyvvhiuxpr2y9` FOREIGN KEY (`Topic_topic_id`) REFERENCES `topic_table` (`topic_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_attention_table
-- ----------------------------
DROP TABLE IF EXISTS `user_attention_table`;
CREATE TABLE `user_attention_table` (
  `ag_id` char(12) NOT NULL,
  `user_id` char(11) NOT NULL,
  PRIMARY KEY (`ag_id`,`user_id`),
  KEY `att_grp_meb_tbl_fk1` (`user_id`) USING BTREE,
  CONSTRAINT `fk` FOREIGN KEY (`ag_id`) REFERENCES `attention_group_table` (`ag_id`),
  CONSTRAINT `fk2` FOREIGN KEY (`user_id`) REFERENCES `user_table` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_table
-- ----------------------------
DROP TABLE IF EXISTS `user_table`;
CREATE TABLE `user_table` (
  `user_id` char(11) NOT NULL,
  `user_name` varchar(20) DEFAULT NULL,
  `user_nickname` varchar(20) NOT NULL,
  `user_profile_photo` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `school` varchar(255) DEFAULT NULL,
  `work` varchar(255) DEFAULT NULL,
  `phone_number` decimal(13,0) DEFAULT NULL,
  `user_info` varchar(255) DEFAULT NULL,
  `registration_date` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `user_password` varchar(20) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_table_message_table
-- ----------------------------
DROP TABLE IF EXISTS `user_table_message_table`;
CREATE TABLE `user_table_message_table` (
  `User_user_id` varchar(11) NOT NULL,
  `messageSet_message_id` varchar(16) NOT NULL,
  PRIMARY KEY (`User_user_id`,`messageSet_message_id`),
  UNIQUE KEY `UK_8fx3dubof0qe088ln4twpb6e7` (`messageSet_message_id`),
  CONSTRAINT `FKk70dtnkh0if99gudk1jyou8se` FOREIGN KEY (`messageSet_message_id`) REFERENCES `message_table` (`message_id`),
  CONSTRAINT `FKlcjuiq8huy7dld2pfjx1v1xb5` FOREIGN KEY (`User_user_id`) REFERENCES `user_table` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
SET FOREIGN_KEY_CHECKS=1;
