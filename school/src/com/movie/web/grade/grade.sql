CREATE SEQUENCE score_seq
start with 1
increment BY 1

drop sequence score_seq;
create table Grade(
	score_seq number PRIMARY KEY,
	id VARCHAR2(30) NOT NULL,
	java number,
	sql number,
	jsp number,
	spring number
);
select * from Grade;

INSERT INTO Grade(score_seq,id,java,sql,jsp,spring) 
VALUES (score_seq.nextval,'hong',90,90,90,90);
INSERT INTO Grade(score_seq,id,java,sql,jsp,spring)  
VALUES (score_seq.nextval,'woo',80,80,80,80);
INSERT INTO Grade(score_seq,id,java,sql,jsp,spring) 
VALUES (score_seq.nextval,'ji',70,70,70,70);
INSERT INTO Grade(score_seq,id,java,sql,jsp,spring) 
VALUES (score_seq.nextval,'cho',60,60,60,60);
INSERT INTO Grade(score_seq,id,java,sql,jsp,spring) 
VALUES (score_seq.nextval,'choi',50,50,50,50);
INSERT INTO Grade(score_seq,id,java,sql,jsp,spring) 
VALUES (score_seq.nextval,'choi2',40,40,40,40);
update Grade set java = 20, sql = 30, jsp = 40, spring = 50
where hak = 9000002;
SELECT  * FROM Grade;
drop table Grade cascade constraints;
 truncate table Grade;
 
 delete from Grade where id ='choi';
 