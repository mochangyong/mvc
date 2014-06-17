
create table board(
board_no int primary key
,board_name varchar2(20) not null
,board_title varchar2(50) not null
,board_cont varchar2(4000) not null
,board_pwd varchar2 (15) not null
,board_hit int default 0
,board_date date
);

create sequence board_no_seq increment by 1 start with 1 nocache;

select * from BOARD;