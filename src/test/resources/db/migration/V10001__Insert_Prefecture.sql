CREATE TABLE `tbl_prefecture` (
	prefecture_id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    prefecture_kana VARCHAR(100) NOT NULL UNIQUE,
    prefecture VARCHAR(100) NOT NULL UNIQUE,
    prefecture_code VARCHAR(2) NOT NULL UNIQUE
);
INSERT INTO `tbl_prefecture`(`prefecture_code`,`prefecture_kana`,`prefecture`)
VALUES ('01','ｼｽﾞｵｶｹﾝ','静岡県');
