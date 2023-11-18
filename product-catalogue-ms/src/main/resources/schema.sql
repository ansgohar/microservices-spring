CREATE TABLE IF NOT EXISTS `product_category` (
  `id` int AUTO_INCREMENT  PRIMARY KEY,
  `name` varchar(200) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `created_at` date DEFAULT NOT NULL,
  `created_by` varchar(20) NOT NULL,
  `updated_at` date DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS `product` (
  `product_id` int AUTO_INCREMENT  PRIMARY KEY,
  `name` varchar(200) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `SKU` varchar(100) NOT NULL,
  `product_category_id` int  NOT NULL,
  `price` DOUBLE NOT NULL,
  `discount` DOUBLE ,
  `created_at` date NOT NULL,
  `created_by` varchar(20) NOT NULL,
  `updated_at` date DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL
);




