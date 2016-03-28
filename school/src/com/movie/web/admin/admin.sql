CREATE TABLE Admin(
	id VARCHAR2(30) PRIMARY KEY,
	password VARCHAR2(30) NOT NULL,
	name VARCHAR2(26) NOT NULL,
	addr VARCHAR2(100),
	birth NUMBER,
	role varchar2(30) default 'admin'
);

INSERT INTO Admin(id,password,name,addr,birth,role) 
VALUES ('admin','1','관리자','서울',800101,'admin');

select * from Admin;