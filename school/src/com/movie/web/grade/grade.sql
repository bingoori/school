CREATE SEQUENCE hak
start with 09000000
increment BY 1

drop sequence hak;
create table Grade(
	hak number PRIMARY KEY,
	id VARCHAR2(30) NOT NULL,
	java number,
	sql number,
	jsp number,
	spring number
);
select * from Grade;

INSERT INTO Grade(hak,id,java,sql,jsp,spring) 
VALUES (hak.nextval,'hong',90,90,90,90);
INSERT INTO Grade(hak,id,java,sql,jsp,spring)  
VALUES (hak.nextval,'woo',80,80,80,80);
INSERT INTO Grade(hak,id,java,sql,jsp,spring) 
VALUES (hak.nextval,'ji',70,70,70,70);
INSERT INTO Grade(hak,id,java,sql,jsp,spring) 
VALUES (hak.nextval,'cho',60,60,60,60);
INSERT INTO Grade(hak,id,java,sql,jsp,spring) 
VALUES (hak.nextval,'choi',50,50,50,50);
INSERT INTO Grade(hak,id,java,sql,jsp,spring) 
VALUES (hak.nextval,'choi2',40,40,40,40);
update Grade set java = 20, sql = 30, jsp = 40, spring = 50
where hak = 9000002;
SELECT  * FROM Grade;
drop table Grade cascade constraints;;
 truncate table Grade;
 
 delete from Grade where id ='choi';
 