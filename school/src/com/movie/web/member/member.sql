SELECT * FROM Test;
CREATE TABLE Member(
	id VARCHAR2(30) PRIMARY KEY,
	password VARCHAR2(30) NOT NULL,
	name VARCHAR2(26) NOT NULL,
	addr VARCHAR2(100),
	birth NUMBER	
);


SELECT * FROM Member;
INSERT INTO Member(id,password,name,addr,birth) 
VALUES ('hong','1','홍길동','서울',800101);
INSERT INTO Member(id,password,name,addr,birth) 
VALUES ('woo','1','우길동','인천',900101);
INSERT INTO Member(id,password,name,addr,birth) 
VALUES ('ji','1','지길동','단양',880101);
INSERT INTO Member(id,password,name,addr,birth) 
VALUES ('cho','1','조길동','가양',700101);
INSERT INTO Member(id,password,name,addr,birth) 
VALUES ('choi','1','최길동','구로',950101);
INSERT INTO Member(id,password,name,addr,birth) 
VALUES ('choi2','1','최길동','종로',840101);

drop table Member cascade constraint;
SELECT * FROM Member;
SELECT * FROM Member 
WHERE id = 'choi';
SELECT id AS id , password AS password FROM Member WHERE id ='choi' AND password='1';
SELECT * FROM Member where id = 'woo';

SELECT * FROM Member WHERE id ='woo';
 delete from Member where id ='bingoori';
DELETE  FROM Member WHERE id = 'woo';
truncate table Member;