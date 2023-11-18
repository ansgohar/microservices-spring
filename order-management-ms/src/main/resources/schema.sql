CREATE TABLE IF NOT EXISTS `orders` (
  `order_id` int AUTO_INCREMENT  PRIMARY KEY,
  `user_id` int NOT NULL,
  `QTY` int NOT NULL,
  `discount` DOUBLE NOT NULL,
  `total` varchar(200) NOT NULL,
  `payment_id` int NOT NULL,
  `created_at` date NOT NULL,
  `created_by` varchar(20) NOT NULL,
  `updated_at` date DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL
);


CREATE TABLE IF NOT EXISTS `order_items` (
	`order_item_id` int AUTO_INCREMENT  PRIMARY KEY,
	`order_id` int NOT NULL,
	`product_id` int NOT NULL,
	`product_QTY` int NOT NULL,
	`created_at` date NOT NULL,
	`created_by` varchar(20) NOT NULL,
	`updated_at` date DEFAULT NULL,
	`updated_by` varchar(20) DEFAULT NULL
);