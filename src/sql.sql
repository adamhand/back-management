CREATE DATABASE backmanagement;
use backmanagement

CREATE TABLE t_user(
  user_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  user_name VARCHAR(255) NOT NULL ,
  password VARCHAR(255) NOT NULL ,
  phone VARCHAR(255) NOT NULL
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE t_book(
  book_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  book_name VARCHAR(255) NOT NULL ,
  book_author VARCHAR(255) NOT NULL ,
  book_price FLOAT NOT NULL ,
  book_amount INT NOT NULL,
  book_category VARCHAR(255) NOT NULL
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE t_record(
  record_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  record_type VARCHAR(255) NULL ,
  record_start_time datetime NULL ,
  record_stop_time  datetime NULL
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

`
insert into t_book values(1,''《围城》'',''钱钟书'',30,10000,''文学'');
insert into t_book values(2,''《白夜行》'',''东野圭吾'',50,10000,''文学'');
insert into t_book values(3,''《死神的精确度》'',''伊坂幸太郎'',50,10000,''文学'');
insert into t_book values(4,''《重力小丑》'',''伊坂幸太郎'',40,10000,''文学'');
insert into t_book values(5,''《哥伦比亚的倒影》'',''木心'',20,10000,''文学'');
insert into t_book values(6,''《Java并发编程实战》'',''Brian Goetz'',60,10000,''计算机'');
insert into t_book values(7,''《深入理解Java虚拟机》'',''周志明'',60,10000,''计算机'');
insert into t_book values(8,''《Netty实战》'',''Norman Maurer'',50,10000,''计算机'');
insert into t_book values(9,''《C和指针》'',''Kenneth A. Reek'',50,10000,''计算机'');
insert into t_book values(10,''《Go程序设计语言》'',''Alan A.A. Donovan'',45,10000,''计算机'');

insert into t_user values(1,''adamhand'',''123456'',''1996xxxxx35'');
insert into t_user values(2,''Bob'',''123456'',''1043xxxxx43'');
`