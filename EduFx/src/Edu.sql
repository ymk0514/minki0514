--���̵�� ���̺�
create table Kids(
    kid_seq varchar2(10) primary key,
    kid_name varchar2(20)  not null,
    kid_password varchar2(10) not null,
    kid_point varchar2(20)  
       	
)
insert into Kids(kid_seq,kid_name,kid_password) values (kid_seq.nextval,'aaa','111')

create sequence kid_seq


--����ī�� ���̺�
create table Voca(
 voca_name varchar(20)

)


insert into Voca values ('����');
insert into Voca values ('�ſ�');
insert into Voca values ('���');

insert into Voca values  ('�Ȱ�');
insert into Voca values  ('����');
insert into Voca values  ('�ܿ�');
insert into Voca values  ('����');
insert into Voca values  ('��');
insert into Voca values  ('�ٸ�');
insert into Voca values  ('�ڵ���');
insert into Voca values  ('��ٸ�');
insert into Voca values  ('��');
insert into Voca values  ('���丮');
insert into Voca values  ('���찳');
insert into Voca values  ('����');
insert into Voca values  ('�ð�');
insert into Voca values  ('�عٶ��');
insert into Voca values  ('������');
insert into Voca values  ('������');
insert into Voca values  ('��');
insert into Voca values  ('����');
insert into Voca values  ('��ǳ��');
insert into Voca values  ('������');
insert into Voca values  ('����');
insert into Voca values  ('����');
insert into Voca values  ('����');
insert into Voca values  ('�Ʊ�');
insert into Voca values  ('�ǾƳ�');
insert into Voca values  ('ǳ��');
insert into Voca values  ('����');
insert into Voca values  ('����');
insert into Voca values  ('����');
insert into Voca values  ('�����');
insert into Voca values  ('���');
insert into Voca values  ('����');
insert into Voca values  ('��');
insert into Voca values  ('������');
insert into Voca values  ('������');
insert into Voca values  ('����');
insert into Voca values  ('����');
insert into Voca values  ('�׳�');
insert into Voca values  ('�ü�');
insert into Voca values  ('�ĵ�');
insert into Voca values  ('ī�޶�');
insert into Voca values  ('�峭��');
insert into Voca values  ('����');
insert into Voca values  ('����');
insert into Voca values  ('����');
insert into Voca values  ('�Ѻ�');

select * from KIDS

select * from VOCA
delete kids
where kid_seq=101