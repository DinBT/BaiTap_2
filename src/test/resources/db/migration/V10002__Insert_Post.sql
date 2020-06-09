CREATE TABLE `tbl_post` (
	`post_id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `post_code` VARCHAR(7) NOT NULL UNIQUE,
    `update_show` INT NOT NULL DEFAULT 0,
    `change_reason` INT NOT NULL DEFAULT 0,
    `multi_area` INT NOT NULL DEFAULT 0
);
INSERT INTO `tbl_post`(`post_code`,`update_show`,`change_reason`, `multi_area`)
VALUES ('9-99-99',0,0,0);
INSERT INTO `tbl_post`(`post_code`,`update_show`,`change_reason`, `multi_area`)
VALUES ('8-88-88',0,0,0);