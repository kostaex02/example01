create user watermelon identified by 1234;

alter user watermelon account unlock;

grant connect, resource to watermelon;

grant create sequence to watermelon;


create table user_table(
  user_id varchar2(20) primary key, --ȸ�� id �̸��Ͼ��
  user_password varchar2(20) not null, -- ȸ�� ��й�ȣ
  user_name varchar2(20) not null, -- ȸ�� �̸�
  user_birth date not null, -- ȸ�� �������
  user_gender number, -- ȸ�� ���� �� 0 �� 1
  user_check number default 0); --����, ������ ����
  
  drop table user_table;

create table genre(
  genre_code varchar2(10) primary key, -- �帣�ڵ�
  genre_name varchar2(15)	-- �帣
);

create sequence artist_no nocache;

create table artist(
	artist_no number primary key,	-- ��Ƽ��Ʈ�� �ڵ�
	artist_name varchar2(25) not null, -- ��Ƽ��Ʈ �̸�
	artist_gender number, 	--��Ƽ��Ʈ ���� �� 0 �� 1
	artist_group number	-- ��Ƽ��Ʈ �׷� ����
);

drop table artist;

create sequence album_no nocache;


-- �������

create table album(
	album_no number primary key,
	album_name varchar2(25) not null,
	song_artist number references artist(artist_no),
	debut_date date,
	genre_code varchar2(10) references genre(genre_code)
);

drop table album;

create table album_image(
	album_imgurl varchar2(50) primary key,
	album_no number references album(album_no)
);

drop table album_image;

create sequence song_no nocache;

create table song(
   song_no number primary key,
   song_name varchar2(20) not null, -- �� �̸�
  artist_code number references artist(artist_no), -- ���� �ڵ�
  genre_code varchar2(10) references genre(genre_code) , -- �帣 �ڵ�
  album_code number references album(album_no), -- �ٹ� �ڵ�
  album_imgurl varchar2(50) references album_image(album_imgurl), --�̹��� url
  song_title number default 0); 



drop table song_url;

create table song_url(
   song_url varchar2(50) primary key, -- song url
   song_no number references song(song_no)
);

create sequence my_album_no nocache;

create table my_album(
     my_album_no number primary key,
     user_id varchar2(20) references user_table(user_id), -- ȸ�� ���̵�
     song_name number references song(song_no), -- ��
     artist_name number references artist(artist_no), --������
     album_name number references album(album_no), --�ٹ���
     song_url varchar2(20) references song_url(song_url), -- url
     imgurl varchar2(20) references album_image(album_imgurl) -- �̹��� url
);

drop table my_album;

create sequence review_no nocache;

create table review(
  review_no number primary key, --���� ��ȣ
  review_id varchar2(25) references user_table(user_id),  -- �������̺� user_id ����
  review_contents varchar2(100), -- ���䳻��
  review_date date    -- ���� 100�� �̳��� ����
);               
drop table review;

commit

select * from user_table;
select * from album_image;
select * from album;
select * from artist;
select * from genre;

insert into album_image values (1,1);
insert into genre values (1,'Ballad');
insert into album values (1,'Real',1,null,1);
insert into artist values (artist_no.nextval,'������',1,0);

insert into song values (song_no.nextval,'������',1,1,1,1,1);  


SELECT * FROM song WHERE song_name  LIKE '%������%';

