CREATE TABLE `account` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL UNIQUE,
  `email` varchar(255) NOT NULL UNIQUE,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `account_token` (
  `id` INT NOT NULL,
  `token` varchar(255) NOT NULL,
  `expiry_time` datetime NOT NULL,
  PRIMARY KEY (`token`)
);

ALTER TABLE `account_token` 
  ADD CONSTRAINT `account_token_fk0` FOREIGN KEY (`id`) REFERENCES `account`(`id`);
