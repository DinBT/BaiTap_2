CREATE TABLE `tbl_city` (
	`city_id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	`code` VARCHAR(5) NOT NULL UNIQUE,
    `city_kana` VARCHAR(100) NOT NULL UNIQUE,
    `city` VARCHAR(100) NOT NULL UNIQUE,
    `prefecture_id` INT NOT NULL,
    FOREIGN KEY (`prefecture_id`) REFERENCES `tbl_prefecture`(`prefecture_id`)
);
INSERT INTO `tbl_city`(`code`,`city_kana`,`city`, `prefecture_id`)
VALUES ('01101','ｼｭｳﾁｸﾞﾝﾓﾘﾏﾁ','周智郡森町',1);