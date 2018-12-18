CREATE DATABASE IF NOT EXISTS `muspro`;
USE `muspro`;

--
-- Table structure for table `admin_credentials`
--

DROP TABLE IF EXISTS `admin_credentials`;
CREATE TABLE `admin_credentials` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) DEFAULT NULL,
  `password_salt` varchar(255) DEFAULT NULL,
  `password_hash` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name_UNIQUE` (`user_name`)
) ENGINE=InnoDB;

--
-- Table structure for table `user_details`
--

DROP TABLE IF EXISTS `user_details`;
CREATE TABLE `user_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password_salt` varchar(255) DEFAULT NULL,
  `password_hash` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

--
-- Table structure for table `user_account`
--

DROP TABLE IF EXISTS `user_account`;
CREATE TABLE `user_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `screen_user_name` varchar(45) DEFAULT NULL,
  `user_details_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_details_id_UNIQUE` (`user_details_id`),
  UNIQUE KEY `screen_user_name_UNIQUE` (`screen_user_name`),
  FOREIGN KEY (`user_details_id`) REFERENCES `user_details` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;

--
-- Table structure for table `async_operation_status_type`
--

DROP TABLE IF EXISTS `async_operation_status_type`;
CREATE TABLE `async_operation_status_type` (
  `id` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

--
-- Table structure for table `external_authentication_provider`
--

DROP TABLE IF EXISTS `external_authentication_provider`;
CREATE TABLE `external_authentication_provider` (
  `id` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

--
-- Table structure for table `user_external_login`
--

DROP TABLE IF EXISTS `user_external_login`;
CREATE TABLE `user_external_login` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_account_id` int(11) DEFAULT NULL,
  `external_authentication_provider_id` int(11) DEFAULT NULL,
  `external_user_id` varchar(255) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `login_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `external_authentication_provider_id` (`external_authentication_provider_id`),
  KEY `user_account_id` (`user_account_id`),
  FOREIGN KEY (`external_authentication_provider_id`) REFERENCES `external_authentication_provider` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`user_account_id`) REFERENCES `user_account` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;

--
-- Table structure for table `async_operation`
--

DROP TABLE IF EXISTS `async_operation`;
CREATE TABLE `async_operation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `external_authentication_provider_id` int(11) DEFAULT NULL,
  `async_operation_status_type_id` int(11) DEFAULT NULL,
  `user_external_login_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `async_operation_status_type_id` (`async_operation_status_type_id`),
  KEY `external_authentication_provider_id` (`external_authentication_provider_id`),
  KEY `user_external_login_id` (`user_external_login_id`),
  FOREIGN KEY (`async_operation_status_type_id`) REFERENCES `async_operation_status_type` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`external_authentication_provider_id`) REFERENCES `external_authentication_provider` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`user_external_login_id`) REFERENCES `user_external_login` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;

--
-- Table structure for table `link_external_item`
--

DROP TABLE IF EXISTS `link_external_item`;
CREATE TABLE `link_external_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_account_id` int(11) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `is_done` tinyint(4) DEFAULT NULL,
  `creation_date` date DEFAULT NULL,
  `deadline_date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_account_id` (`user_account_id`),
  FOREIGN KEY (`user_account_id`) REFERENCES `user_account` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;
