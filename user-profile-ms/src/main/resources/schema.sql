CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int AUTO_INCREMENT  PRIMARY KEY,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `mobile_number` varchar(20) NOT NULL,
  `created_at` date DEFAULT NOT NULL,
  `created_by` varchar(20) NOT NULL,
  `updated_at` date DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS `user_address` (
  `user_id` int NOT NULL,
  `address_id` int AUTO_INCREMENT  PRIMARY KEY,
  `address` varchar(100) NOT NULL,
  `address2` varchar(200) NOT NULL,
  `district` varchar(200) NOT NULL,
  `city` int ,
  `state` int NOT NULL,
  `postal_code` varchar(20) NOT NULL,
  `created_at` date NOT NULL,
  `created_by` varchar(20) NOT NULL,
  `updated_at` date DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS `user_payment` (
  `user_id` int NOT NULL,
  `payment_id` int AUTO_INCREMENT  PRIMARY KEY,
  `payment_type` varchar(100) NOT NULL,
  `provider` varchar(200) NOT NULL,
  `account_number` varchar(200) NOT NULL,
  `created_at` date NOT NULL,
  `created_by` varchar(20) NOT NULL,
  `updated_at` date DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL
);



