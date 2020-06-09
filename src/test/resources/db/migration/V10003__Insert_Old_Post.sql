CREATE TABLE `tbl_old_post` (
	`old_post_id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `old_post_code` VARCHAR(5) NOT NULL UNIQUE
);
INSERT INTO `tbl_old_post`(`old_post_code`) VALUES ('060');