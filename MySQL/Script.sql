--<ScriptOptions statementTerminator=";"/>

ALTER TABLE `tweetDB`.`hashtag` DROP PRIMARY KEY;

ALTER TABLE `tweetDB`.`tweet` DROP PRIMARY KEY;

ALTER TABLE `tweetDB`.`url` DROP PRIMARY KEY;

ALTER TABLE `tweetDB`.`user` DROP PRIMARY KEY;

ALTER TABLE `tweetDB`.`keyword` DROP PRIMARY KEY;

ALTER TABLE `tweetDB`.`tweet_keyword` DROP INDEX `tweetDB`.`fk_tweet_keyword_2_idx`;

ALTER TABLE `tweetDB`.`user` DROP INDEX `tweetDB`.`screen_name`;

ALTER TABLE `tweetDB`.`hashtag` DROP INDEX `tweetDB`.`fk_tweet_hashtag_2_idx`;

ALTER TABLE `tweetDB`.`tweet_url` DROP INDEX `tweetDB`.`fk_tweet_url_2_idx`;

ALTER TABLE `tweetDB`.`tweet_keyword` DROP INDEX `tweetDB`.`fk_tweet_keyword_1_idx`;

ALTER TABLE `tweetDB`.`tweet_url` DROP INDEX `tweetDB`.`fk_tweet_url_1_idx`;

ALTER TABLE `tweetDB`.`tweet` DROP INDEX `tweetDB`.`tweet_text`;

ALTER TABLE `tweetDB`.`url` DROP INDEX `tweetDB`.`fk_tweet_url_2_idx`;

ALTER TABLE `tweetDB`.`tweet` DROP INDEX `tweetDB`.`created_at`;

ALTER TABLE `tweetDB`.`tweet_hashtag` DROP INDEX `tweetDB`.`fk_tweet_hashtag_1_idx`;

ALTER TABLE `tweetDB`.`tweet_hashtag` DROP INDEX `tweetDB`.`fk_tweet_hashtag_2_idx`;

ALTER TABLE `tweetDB`.`tweet` DROP INDEX `tweetDB`.`lang_code`;

DROP TABLE `tweetDB`.`hashtag`;

DROP TABLE `tweetDB`.`tweet_hashtag`;

DROP TABLE `tweetDB`.`user`;

DROP TABLE `tweetDB`.`keyword`;

DROP TABLE `tweetDB`.`url`;

DROP TABLE `tweetDB`.`tweet_url`;

DROP TABLE `tweetDB`.`tweet`;

DROP TABLE `tweetDB`.`tweet_keyword`;

CREATE TABLE `tweetDB`.`url` (
	`url` VARCHAR(300) NOT NULL,
	`url_id` BIGINT NOT NULL,
	PRIMARY KEY (`url_id`)
) ENGINE=InnoDB;

CREATE TABLE `tweetDB`.`tweet_url` (
	`url_id` BIGINT NOT NULL,
	`tweet_id` BIGINT NOT NULL
) ENGINE=InnoDB;

CREATE TABLE `tweetDB`.`hashtag` (
	`hashtag` VARCHAR(140) NOT NULL,
	`hashtag_id` BIGINT NOT NULL,
	PRIMARY KEY (`hashtag_id`)
) ENGINE=InnoDB;

CREATE TABLE `tweetDB`.`tweet` (
	`tweet_id` BIGINT NOT NULL,
	`tweet_text` VARCHAR(300) NOT NULL,
	`created_at` DATETIME,
	`lang_code` VARCHAR(6),
	`user_id` BIGINT NOT NULL,
	PRIMARY KEY (`tweet_id`)
) ENGINE=InnoDB;

CREATE TABLE `tweetDB`.`tweet_hashtag` (
	`hashtag_id` BIGINT NOT NULL,
	`tweet_id` BIGINT NOT NULL
) ENGINE=InnoDB;

CREATE TABLE `tweetDB`.`tweet_keyword` (
	`key_id` BIGINT NOT NULL,
	`tweet_id` BIGINT NOT NULL
) ENGINE=InnoDB;

CREATE TABLE `tweetDB`.`user` (
	`user_id` BIGINT NOT NULL,
	`screen_name` VARCHAR(20),
	`profile_image_url` VARCHAR(200),
	`statuses_count` INT,
	PRIMARY KEY (`user_id`)
) ENGINE=InnoDB;

CREATE TABLE `tweetDB`.`keyword` (
	`key_id` BIGINT NOT NULL,
	`key_name` VARCHAR(45) NOT NULL,
	PRIMARY KEY (`key_id`)
) ENGINE=InnoDB;

CREATE INDEX `fk_tweet_keyword_2_idx` ON `tweetDB`.`tweet_keyword` (`tweet_id` ASC);

CREATE INDEX `screen_name` ON `tweetDB`.`user` (`screen_name` ASC);

CREATE INDEX `fk_tweet_hashtag_1_idx` ON `tweetDB`.`tweet_hashtag` (`hashtag_id` ASC);

CREATE INDEX `fk_tweet_hashtag_2_idx` ON `tweetDB`.`hashtag` (`hashtag` ASC);

CREATE INDEX `fk_tweet_hashtag_2_idx` ON `tweetDB`.`tweet_hashtag` (`tweet_id` ASC);

CREATE INDEX `fk_tweet_url_2_idx` ON `tweetDB`.`tweet_url` (`url_id` ASC);

CREATE INDEX `fk_tweet_keyword_1_idx` ON `tweetDB`.`tweet_keyword` (`key_id` ASC);

CREATE INDEX `fk_tweet_url_1_idx` ON `tweetDB`.`tweet_url` (`tweet_id` ASC);

CREATE INDEX `tweet_text` ON `tweetDB`.`tweet` (null);

CREATE INDEX `fk_tweet_url_2_idx` ON `tweetDB`.`url` (`url` ASC);

CREATE INDEX `lang_code` ON `tweetDB`.`tweet` (`lang_code` ASC);

CREATE INDEX `created_at` ON `tweetDB`.`tweet` (`created_at` ASC);

