create table bbs(
bbs_no int primary key
,bbs_name varchar2(20) not null
,bbs_title varchar2(50) not null
,bbs_cont varchar2(4000) not null
,bbs_pwd varchar2(15) not null
,bbs_hit int default 0
,bbs_date date
);

create sequence bbs_no_seq increment by  1 start with 1 nocache;

select * from bbs;