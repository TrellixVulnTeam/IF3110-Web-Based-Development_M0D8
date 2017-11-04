CREATE TABLE `orderhistory` (
  `id_order` int(11) NOT NULL AUTO_INCREMENT,
  `id_customer` int(11) NOT NULL,
  `id_driver` int(11) NOT NULL,
  `rating` int(1) NOT NULL,
  `feedback` text NOT NULL,
  `order_date` date NOT NULL,
  `pickup` varchar(255) NOT NULL,
  `dest` varchar(255) NOT NULL,
  `hidden_c` tinyint(1) NOT NULL DEFAULT '0',
  `hidden_d` tinyint(1) NOT NULL DEFAULT '0', 
  PRIMARY KEY (`id_order`)
);

CREATE TABLE `preferredlocation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `location` varchar(255) NOT NULL,
  PRIMARY KEY (`id`,`location`)
);

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL UNIQUE,
  `email` varchar(255) NOT NULL UNIQUE,
  `phone_num` varchar(12) NOT NULL,
  `img_path` varchar(255) NOT NULL DEFAULT 'profiles/default.png',
  `fullname` varchar(20) NOT NULL,
  `is_driver` tinyint(1) NOT NULL DEFAULT '0',
  `star` decimal(2,1) NOT NULL DEFAULT '0.0',
  `vote` int(11) NOT NULL DEFAULT '0', 
  PRIMARY KEY (`id`)
);

ALTER TABLE `orderhistory`
  ADD CONSTRAINT `OrderHistory_fk0` FOREIGN KEY (`id_customer`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `OrderHistory_fk1` FOREIGN KEY (`id_driver`) REFERENCES `user` (`id`);

ALTER TABLE `preferredlocation`
  ADD CONSTRAINT `PreferredLocation_fk0` FOREIGN KEY (`id`) REFERENCES `user` (`id`);

