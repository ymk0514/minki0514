--아이등록 테이블
create table Kids(
    kid_seq varchar2(10) primary key,
    kid_name varchar2(20)  not null,
    kid_password varchar2(10) not null,
    kid_point varchar2(20)  
       	
)
insert into Kids(kid_seq,kid_name,kid_password) values (kid_seq.nextval,'aaa','111')

create sequence kid_seq


--낱말카드 테이블
create table Voca(
 voca_name varchar(20)

)


insert into Voca values ('가위');
insert into Voca values ('거울');
insert into Voca values ('우산');

insert into Voca values  ('안경');
insert into Voca values  ('가방');
insert into Voca values  ('겨울');
insert into Voca values  ('나비');
insert into Voca values  ('눈');
insert into Voca values  ('다리');
insert into Voca values  ('자동차');
insert into Voca values  ('사다리');
insert into Voca values  ('물');
insert into Voca values  ('도토리');
insert into Voca values  ('지우개');
insert into Voca values  ('딸기');
insert into Voca values  ('시계');
insert into Voca values  ('해바라기');
insert into Voca values  ('자전거');
insert into Voca values  ('경찰차');
insert into Voca values  ('배');
insert into Voca values  ('사탕');
insert into Voca values  ('선풍기');
insert into Voca values  ('옥수수');
insert into Voca values  ('참외');
insert into Voca values  ('우유');
insert into Voca values  ('모자');
insert into Voca values  ('아기');
insert into Voca values  ('피아노');
insert into Voca values  ('풍선');
insert into Voca values  ('구두');
insert into Voca values  ('바지');
insert into Voca values  ('인형');
insert into Voca values  ('비행기');
insert into Voca values  ('당근');
insert into Voca values  ('기차');
insert into Voca values  ('별');
insert into Voca values  ('숟가락');
insert into Voca values  ('젓가락');
insert into Voca values  ('나무');
insert into Voca values  ('라디오');
insert into Voca values  ('그네');
insert into Voca values  ('시소');
insert into Voca values  ('파도');
insert into Voca values  ('카메라');
insert into Voca values  ('장난감');
insert into Voca values  ('과자');
insert into Voca values  ('지구');
insert into Voca values  ('연필');
insert into Voca values  ('한복');

select * from KIDS

select * from VOCA
delete kids
where kid_seq=101