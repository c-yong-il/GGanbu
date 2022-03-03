CREATE TABLE member_table (
    mem_id VARCHAR(50) NOT NULL COMMENT '���̵� pk',
    mem_pass VARCHAR(1000) NOT NULL COMMENT '��й�ȣ',
    mem_name VARCHAR(30) NOT NULL COMMENT '�̸�',
    mem_email1 VARCHAR(30) NOT NULL COMMENT '�̸���1',
    mem_email2 VARCHAR(30) NOT NULL COMMENT '�̸���2',
    mem_hp VARCHAR(30) NOT NULL COMMENT '�ڵ�����ȣ',
    mem_birth date NOT NULL COMMENT '�������',
    mem_gender ENUM('M', 'F') NOT NULL COMMENT '����',
    mem_date date NULL COMMENT '������',
    mem_status ENUM('Y', 'N') not NULL DEFAULT 'N' COMMENT '���Ի���',
    PRIMARY KEY (mem_id)
)  COMMENT 'ȸ������';

select * from member_table;
update member_table set mem_pass='pass' where mem_id='id1';

desc member_table ;
drop table member_table;

CREATE TABLE photo_table (
   photo_num   INT NOT NULL AUTO_INCREMENT COMMENT '����ø �Խñ� ��ȣ pk',
   mem_id   varchar(50)   NOT NULL COMMENT '�ۼ��� fk',
   photo_content   longtext   null COMMENT '����ø �Խñ� ����',
   photo_date   date   null COMMENT '�����',
   photo_updatedate   date   null COMMENT '������',
   photo_status   ENUM('Y', 'N') NULL DEFAULT 'N' COMMENT '��������',
   photo_open int not null default 0 COMMENT '��ü/���/��ΰ�������',
   PRIMARY KEY (photo_num),
    FOREIGN KEY (mem_id) REFERENCES member_table(mem_id)
) COMMENT '����ø' ;

insert into photo_table values(photo_num,'asdf1234','����/��',now(),now(),'n');
insert into photo_table values(photo_num,'id2','content',now(),now(),'n');
INSERT INTO photo_table  VALUES (photo_num,'�ֿ���','dddd', NOW(), NOW(), 'N');
select * from photo_table;
update photo_table set photo_content='aa' where photo_num = 1;
UPDATE photo_table set photo_content = '11', photo_updatedate = NOW() where photo_num = 1;
delete from photo_table where photo_num = 3;
drop table photo_table;

select * from (select @rownum:=@rownum+1 as rownum, photo_table.*
from photo_table, (select @rownum:=0) r where mem_id='id2'order by photo_date)sub order by sub.rownum desc limit 0,5;

CREATE TABLE photo_comment_table (
	photo_comment_num	INT NOT NULL AUTO_INCREMENT COMMENT '����ø ��� ��ȣ pk',
	mem_id	varchar(50)	NOT NULL COMMENT '����ø �ۼ��� fk',
	comment_content	varchar(1000)	NULL COMMENT '��� ����',
	comment_date	date	NULL COMMENT '�ۼ���',
	comment_updatedate	date	NULL COMMENT '������',
	comment_status	ENUM('Y', 'N') NULL DEFAULT 'N' COMMENT '��������',
	photo_num	int	NOT NULL COMMENT '����ø �Խñ� ��ȣ fk',
	mem_id2	varchar(50)	NOT null COMMENT '����ø ��� �ۼ��� fk',
	PRIMARY KEY (photo_comment_num),
    FOREIGN KEY (mem_id) REFERENCES member_table(mem_id),
    FOREIGN KEY (mem_id2) REFERENCES member_table(mem_id),
    FOREIGN KEY (photo_num) REFERENCES photo_table(photo_num)
) COMMENT '����ø ���';

insert into photo_comment_table values(photo_comment_num, mem_id, '���2',now(),now(),'n', photo_num, mem_id2);
insert into photo_comment_table values(photo_comment_num,'id2','���1',now(),now(),'n',1,'id1');
select * from photo_comment_table;
drop table photo_comment_table;

select * from (select @rownum:=@rownum+1 as rownum, photo_table.*
		from photo_table, (select @rownum:=0) r where mem_id='id2' and photo_status='n' order by photo_date)sub 
		order by sub.rownum desc;

CREATE TABLE diary_table (
	diary_num	INT NOT NULL AUTO_INCREMENT COMMENT '���̾ �� ��ȣ pk',
	mem_id	varchar(50)	NOT NULL COMMENT '�ۼ��� fk',
	diary_content	varchar(1000)	NULL COMMENT '���̾ �� ����',
	diary_secret ENUM('Y', 'N') NULL DEFAULT 'N' COMMENT '��бۿ���',
	diary_date	date	NULL COMMENT '�ۼ���',
	diary_updatedate	date	NULL COMMENT '������',
	diary_status	ENUM('Y', 'N') NULL DEFAULT 'N' COMMENT '��������',
	PRIMARY KEY (diary_num),
    FOREIGN KEY (mem_id) REFERENCES member_table(mem_id)
);

insert into diary_table values(diary_num,'id2','content',"20020101",null,'N');
select * from diary_table;
drop table diary_table;

CREATE TABLE guest_book_table (
	book_num	INT NOT NULL AUTO_INCREMENT COMMENT '���� �� ��ȣ pk',
	mem_id	varchar(50)	NOT NULL COMMENT '������ ���̵� fk',
	mem_id2	varchar(50)	NOT null  COMMENT '�ۼ��� fk',
	book_content	varchar(1000)	NULL COMMENT '���� �� ����',
	book_date	date	NULL COMMENT '�ۼ���',
	book_updatedate	date	NULL COMMENT '������',
	book_secret ENUM('Y', 'N') null DEFAULT 'N' COMMENT '��п���',
	book_status	ENUM('Y', 'N') NULL DEFAULT 'N' COMMENT '��������',
	PRIMARY KEY (book_num),
	FOREIGN KEY (mem_id) REFERENCES member_table(mem_id),
    FOREIGN KEY (mem_id2) REFERENCES member_table(mem_id)
);

insert into guest_book_table values(book_num,'id2','asdf1234','content',"20020101",null,'N','N');
insert into guest_book_table values(book_num,'id2','asdf1234','�ȳ�?',"20020101",null,'N','N');
insert into guest_book_table values(book_num,'id2','asdf1234','�� ���ٰ�',"20020101",null,'N','N');
insert into guest_book_table values(book_num,'id2','asdf1234','�ȳ� ��������?',"20220225",null,'N','N');
insert into guest_book_table values(book_num,'asdf1234','id2','�ȳ�� ��������? �����;�',"20220225",null,'N','N');
select * from guest_book_table;
drop table guest_book_table;

CREATE TABLE profile_table (
	mem_id	varchar(50)	NOT NULL COMMENT '�ۼ��� pk,fk',
	profile_photo	longtext	NULL COMMENT '������ ����',
	profile_content	varchar(1000)	NULL COMMENT '������ �� ����',
	profile_date	date	NULL COMMENT '�ۼ���',
	profile_updatedate	date	null COMMENT '������',
	PRIMARY KEY (mem_id),
    FOREIGN KEY (mem_id) REFERENCES member_table(mem_id)
);

insert into profile_table values('id','photo','content',"20020101",null);
select * from profile_table;
drop table profile_table;

CREATE TABLE main_profile_table (
	mem_id	varchar(50)	NOT NULL COMMENT '�ۼ��� pk,fk',
	main_photo	longtext	NULL COMMENT '���� ������ ����',
	main_content	varchar(1000)	NULL COMMENT '���� ������ �� ����',
	main_date	date	NULL COMMENT '�ۼ���',
	main_updatedate	date	NULL COMMENT '������',
	PRIMARY KEY (mem_id),
    FOREIGN KEY (mem_id) REFERENCES member_table(mem_id)
);

insert into main_profile_table values('id','photo','content',"20020101",null);
select * from main_profile_table;
drop table main_profile_table;

CREATE TABLE gganbu_table (
	mem_id	varchar(50)	NOT NULL COMMENT '��û��',
	mem_id2	varchar(50)	NOT NULL COMMENT '������',
	gganbu_acceptdate date null comment '��� ���� ��',
	gganbu_requestdate date null comment '��� ��û ��',
	gganbu_relation	int	null COMMENT '��ΰ���- 0:��û, 1:���O, 2:���X',
	PRIMARY KEY (mem_id,mem_id2),
	FOREIGN KEY (mem_id) REFERENCES member_table(mem_id),
	FOREIGN KEY (mem_id2) REFERENCES member_table(mem_id)
);

insert into gganbu_table values('id1','id2',now(),now(),1);
select * from gganbu_table;
drop table gganbu_table;
select mem_id,mem_id2 from gganbu_table where mem_id='�ֿ���' or mem_id2='�ֿ���';
update gganbu_table set gganbu_relation = 0 where mem_id='id1' and mem_id2='�ֿ���';

CREATE TABLE gganbu_comment_table (
   mem_id   varchar(50)   NOT NULL COMMENT '������',
   mem_id2   varchar(50)   NOT NULL COMMENT '�ۼ���',
   gganbu_comment_content   varchar(1000)   NULL COMMENT '������ �� ����',
   gganbu_comment_date   date   NULL COMMENT '�ۼ���',
   gganbu_comment_updatedate date NULL COMMENT '������',
   gganbu_comment_status   ENUM('Y', 'N') NULL DEFAULT 'N' COMMENT '��������',
   PRIMARY KEY (mem_id,mem_id2),
    FOREIGN KEY (mem_id) REFERENCES member_table(mem_id),
    FOREIGN KEY (mem_id2) REFERENCES member_table(mem_id)
);

insert into gganbu_comment_table values('id','id2','content',now(),'1');
select * from gganbu_comment_table;
drop table gganbu_comment_table;

commit;