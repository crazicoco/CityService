DROP TABLE IF EXISTS city;

CREATE TABLE city (
  id INT(10) NOT NULL AUTO_INCREMENT,
  province_id INT(10) NOT NULL,
  city_name varchar(100),
  description text,
  PRIMARY KEY(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;