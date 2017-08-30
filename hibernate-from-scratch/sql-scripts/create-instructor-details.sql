CREATE DATABASE  IF NOT EXISTS `hb-01-one-to-one-uni`;
USE `hb-01-one-to-one-uni`;
create table instructor_details(
id int(11) NOT NULL AUTO_INCREMENT,
youtube_channel VARCHAR(45) DEFAULT NULL,
hobby VARCHAR(45) DEFAULT NULL,
PRIMARY KEY(id)
);