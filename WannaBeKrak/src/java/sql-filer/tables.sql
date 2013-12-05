
DROP TABLE Person;

CREATE TABLE Person (
  FIRST_NAME varchar(50) default NULL,
  LAST_NAME varchar(60) default NULL,
  ADDRESS varchar(100) default NULL,
  CITY varchar(100) default NULL,
  ZIP varchar(4) default NULL,
  EMAIL varchar(100) default NULL,
  PHONE_1 varchar(12) default NULL primary key,
  PHONE_2 varchar(12) default NULL
);