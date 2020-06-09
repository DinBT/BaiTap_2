CREATE TABLE `tbl_area` (
	`area_id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `area_kana` VARCHAR(100) NOT NULL,
    `area` VARCHAR(100) NOT NULL,
    `city_id` INT NOT NULL,
    `chome_area` INT NOT NULL DEFAULT 0,
    `koaza_area` INT NOT NULL DEFAULT 0,
    `multi_post_area` INT NOT NULL DEFAULT 0,
    `post_id` INT NOT NULL,
    `old_post_id` INT NOT NULL,
    FOREIGN KEY (`city_id`) REFERENCES `tbl_city`(`city_id`),
    FOREIGN KEY (`post_id`) REFERENCES `tbl_post`(`post_id`),
    FOREIGN KEY (`old_post_id`) REFERENCES `tbl_old_post`(`old_post_id`)
);
INSERT INTO `tbl_area`(`area_kana`,`area`,`city_id`,`chome_area`,`koaza_area`,`multi_post_area`,
`post_id`, `old_post_id`)
VALUES ('ｲｲﾀﾞ','飯田',1,0,0,1,1,1);