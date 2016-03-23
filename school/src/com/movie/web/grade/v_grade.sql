CREATE OR REPLACE VIEW GradeMember
AS
SELECT 
g.score_seq AS score_seq,
g.id AS id,
g.java AS java,
g.jsp AS jsp,
g.sql AS sql,
g.spring AS spring,
m.password AS password,
m.name AS name,
m.addr AS addr,
m.birth AS birth
FROM Member m, Grade g
WHERE m.id = g.id;

select * from GradeMember;
select * from GradeMember
where name = '홍길동';

INSERT INTO GradeMember(hak, id, java,jsp,sql,spring,password,name,addr,birth) 
     VALUES (hak.nextval, 'park', 30,31,32,67,'1','박길동','북한',540101);
SELECT * FROM GradeMember WHERE hak = 9000127;
SELECT * FROM GradeMember WHERE name = '우길동';

select count(*) from GradeMember;