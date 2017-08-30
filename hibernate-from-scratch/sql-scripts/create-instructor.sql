create table instructor(
id int(11) NOT NULL AUTO_INCREMENT,
first_name VARCHAR(45),
last_name VARCHAR(45),
email VARCHAR(45),
instructor_details_id int(11) NOT NULL,
PRIMARY KEY(id),
KEY FK_DETAIL_idx (instructor_details_id),
CONSTRAINT FK_DETAIL FOREIGN KEY (instructor_details_id) REFERENCES instructor_details(id)
ON DELETE NO ACTION ON UPDATE NO ACTION
);