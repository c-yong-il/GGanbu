CREATE TABLE member_table (
    mem_id VARCHAR(50) NOT NULL COMMENT '아이디 pk',
    mem_pass VARCHAR(1000) NOT NULL COMMENT '비밀번호',
    mem_name VARCHAR(30) NOT NULL COMMENT '이름',
    mem_email1 VARCHAR(30) NOT NULL COMMENT '이메일1',
    mem_email2 VARCHAR(30) NOT NULL COMMENT '이메일2',
    mem_hp VARCHAR(30) NOT NULL COMMENT '핸드폰번호',
    mem_birth date NOT NULL COMMENT '생년월일',
    mem_gender ENUM('M', 'F') NOT NULL COMMENT '성별',
    mem_date date NULL COMMENT '가입일',
    mem_status ENUM('Y', 'N') not NULL DEFAULT 'N' COMMENT '가입상태',
    PRIMARY KEY (mem_id)
)  COMMENT '회원정보';

select * from member_table;
update member_table set mem_pass='pass' where mem_id='id1';

desc member_table ;
drop table member_table;

CREATE TABLE photo_table (
   photo_num   INT NOT NULL AUTO_INCREMENT COMMENT '사진첩 게시글 번호 pk',
   mem_id   varchar(50)   NOT NULL COMMENT '작성자 fk',
   photo_content   longtext   null COMMENT '사진첩 게시글 내용',
   photo_date   date   null COMMENT '등록일',
   photo_updatedate   date   null COMMENT '수정일',
   photo_status   ENUM('Y', 'N') NULL DEFAULT 'N' COMMENT '삭제여부',
   photo_open int not null default 0 COMMENT '전체/비밀/깐부공개여부',
   PRIMARY KEY (photo_num),
    FOREIGN KEY (mem_id) REFERENCES member_table(mem_id)
) COMMENT '사진첩' ;

insert into photo_table values(photo_num,'asdf1234','사진/글',now(),now(),'n');
insert into photo_table values(photo_num,'id2','content',now(),now(),'n');
INSERT INTO photo_table  VALUES (photo_num,'최용일','dddd', NOW(), NOW(), 'N');
select * from photo_table;
update photo_table set photo_content='aa' where photo_num = 1;
UPDATE photo_table set photo_content = '11', photo_updatedate = NOW() where photo_num = 1;
delete from photo_table where photo_num = 3;
drop table photo_table;

select * from (select @rownum:=@rownum+1 as rownum, photo_table.*
from photo_table, (select @rownum:=0) r where mem_id='id2'order by photo_date)sub order by sub.rownum desc limit 0,5;

CREATE TABLE photo_comment_table (
	photo_comment_num	INT NOT NULL AUTO_INCREMENT COMMENT '사진첩 댓글 번호 pk',
	mem_id	varchar(50)	NOT NULL COMMENT '사진첩 작성자 fk',
	comment_content	varchar(1000)	NULL COMMENT '댓글 내용',
	comment_date	date	NULL COMMENT '작성일',
	comment_updatedate	date	NULL COMMENT '수정일',
	comment_status	ENUM('Y', 'N') NULL DEFAULT 'N' COMMENT '삭제여부',
	photo_num	int	NOT NULL COMMENT '사진첩 게시글 번호 fk',
	mem_id2	varchar(50)	NOT null COMMENT '사진첩 댓글 작성자 fk',
	PRIMARY KEY (photo_comment_num),
    FOREIGN KEY (mem_id) REFERENCES member_table(mem_id),
    FOREIGN KEY (mem_id2) REFERENCES member_table(mem_id),
    FOREIGN KEY (photo_num) REFERENCES photo_table(photo_num)
) COMMENT '사진첩 댓글';

insert into photo_comment_table values(photo_comment_num, mem_id, '댓글2',now(),now(),'n', photo_num, mem_id2);
insert into photo_comment_table values(photo_comment_num,'id2','댓글1',now(),now(),'n',1,'id1');
select * from photo_comment_table;
drop table photo_comment_table;

select * from (select @rownum:=@rownum+1 as rownum, photo_table.*
		from photo_table, (select @rownum:=0) r where mem_id='id2' and photo_status='n' order by photo_date)sub 
		order by sub.rownum desc;

CREATE TABLE diary_table (
	diary_num	INT NOT NULL AUTO_INCREMENT COMMENT '다이어리 글 번호 pk',
	mem_id	varchar(50)	NOT NULL COMMENT '작성자 fk',
	diary_content	varchar(1000)	NULL COMMENT '다이어리 글 내용',
	diary_secret ENUM('Y', 'N') NULL DEFAULT 'N' COMMENT '비밀글여부',
	diary_date	date	NULL COMMENT '작성일',
	diary_updatedate	date	NULL COMMENT '수정일',
	diary_status	ENUM('Y', 'N') NULL DEFAULT 'N' COMMENT '삭제여부',
	PRIMARY KEY (diary_num),
    FOREIGN KEY (mem_id) REFERENCES member_table(mem_id)
);

insert into diary_table values(diary_num,'id2','content',"20020101",null,'N');
select * from diary_table;
drop table diary_table;

CREATE TABLE guest_book_table (
	book_num	INT NOT NULL AUTO_INCREMENT COMMENT '방명록 글 번호 pk',
	mem_id	varchar(50)	NOT NULL COMMENT '주인장 아이디 fk',
	mem_id2	varchar(50)	NOT null  COMMENT '작성자 fk',
	book_content	varchar(1000)	NULL COMMENT '방명록 글 내용',
	book_date	date	NULL COMMENT '작성일',
	book_updatedate	date	NULL COMMENT '수정일',
	book_secret ENUM('Y', 'N') null DEFAULT 'N' COMMENT '비밀여부',
	book_status	ENUM('Y', 'N') NULL DEFAULT 'N' COMMENT '삭제여부',
	PRIMARY KEY (book_num),
	FOREIGN KEY (mem_id) REFERENCES member_table(mem_id),
    FOREIGN KEY (mem_id2) REFERENCES member_table(mem_id)
);

insert into guest_book_table values(book_num,'id2','asdf1234','content',"20020101",null,'N','N');
insert into guest_book_table values(book_num,'id2','asdf1234','안녕?',"20020101",null,'N','N');
insert into guest_book_table values(book_num,'id2','asdf1234','잘 보다감',"20020101",null,'N','N');
insert into guest_book_table values(book_num,'id2','asdf1234','안농 잘지내지?',"20220225",null,'N','N');
insert into guest_book_table values(book_num,'asdf1234','id2','안농농 잘지내지? 보구싶엉',"20220225",null,'N','N');
select * from guest_book_table;
drop table guest_book_table;

CREATE TABLE profile_table (
	mem_id	varchar(50)	NOT NULL COMMENT '작성자 pk,fk',
	profile_photo	longtext	NULL COMMENT '프로필 사진',
	profile_content	varchar(1000)	NULL COMMENT '프로필 글 내용',
	profile_date	date	NULL COMMENT '작성일',
	profile_updatedate	date	null COMMENT '수정일',
	PRIMARY KEY (mem_id),
    FOREIGN KEY (mem_id) REFERENCES member_table(mem_id)
);

insert into profile_table values('id','photo','content',"20020101",null);
select * from profile_table;
drop table profile_table;

CREATE TABLE main_profile_table (
	mem_id	varchar(50)	NOT NULL COMMENT '작성자 pk,fk',
	main_photo	longtext	NULL COMMENT '메인 프로필 사진',
	main_content	varchar(1000)	NULL COMMENT '메인 프로필 글 내용',
	main_date	date	NULL COMMENT '작성일',
	main_updatedate	date	NULL COMMENT '수정일',
	PRIMARY KEY (mem_id),
    FOREIGN KEY (mem_id) REFERENCES member_table(mem_id)
);

insert into main_profile_table values('id','photo','content',"20020101",null);
select * from main_profile_table;
drop table main_profile_table;

CREATE TABLE gganbu_table (
	mem_id	varchar(50)	NOT NULL COMMENT '요청자',
	mem_id2	varchar(50)	NOT NULL COMMENT '응답자',
	gganbu_acceptdate date null comment '깐부 맺은 날',
	gganbu_requestdate date null comment '깐부 요청 날',
	gganbu_relation	int	null COMMENT '깐부관계- 0:신청, 1:깐부O, 2:깐부X',
	PRIMARY KEY (mem_id,mem_id2),
	FOREIGN KEY (mem_id) REFERENCES member_table(mem_id),
	FOREIGN KEY (mem_id2) REFERENCES member_table(mem_id)
);

insert into gganbu_table values('id1','id2',now(),now(),1);
select * from gganbu_table;
drop table gganbu_table;
select mem_id,mem_id2 from gganbu_table where mem_id='최용일' or mem_id2='최용일';
update gganbu_table set gganbu_relation = 0 where mem_id='id1' and mem_id2='최용일';

CREATE TABLE gganbu_comment_table (
   mem_id   varchar(50)   NOT NULL COMMENT '주인장',
   mem_id2   varchar(50)   NOT NULL COMMENT '작성자',
   gganbu_comment_content   varchar(1000)   NULL COMMENT '일촌평 글 내용',
   gganbu_comment_date   date   NULL COMMENT '작성일',
   gganbu_comment_updatedate date NULL COMMENT '수정일',
   gganbu_comment_status   ENUM('Y', 'N') NULL DEFAULT 'N' COMMENT '삭제여부',
   PRIMARY KEY (mem_id,mem_id2),
    FOREIGN KEY (mem_id) REFERENCES member_table(mem_id),
    FOREIGN KEY (mem_id2) REFERENCES member_table(mem_id)
);

insert into gganbu_comment_table values('id','id2','content',now(),'1');
select * from gganbu_comment_table;
drop table gganbu_comment_table;

commit;