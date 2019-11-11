CREATE TABLE `Bolg`.`question`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NULL,
  `description` text NULL,
  `gmt_create` bigint(255) NULL,
  `gmt_modify` varchar(255) NULL,
  `creator` int(255) NULL,
  `comment_count` int(255) NULL DEFAULT 0,
  `like_count` int(255) NULL DEFAULT 0,
  `tag` varchar(255) NULL,
  PRIMARY KEY (`id`)
);