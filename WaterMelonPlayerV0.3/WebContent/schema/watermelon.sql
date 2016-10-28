create user watermelon identified by 1234;

alter user watermelon account unlock;

grant connect, resource to watermelon;

grant create sequence to watermelon;

-- ��� ����
drop table my_album;
drop table song_url;
drop table review;
drop table user_table;
drop table song;
drop table album_image;
drop table album;
drop table artist;
drop table genre;


--���̺� ������ ���������� �ϸ��
create table user_table(
  user_id varchar2(50) primary key, --ȸ�� id �̸��Ͼ��
  user_password varchar2(20) not null, -- ȸ�� ��й�ȣ
  user_name varchar2(20) not null, -- ȸ�� �̸�
  user_birth date not null, -- ȸ�� �������
  user_gender number, -- ȸ�� ���� �� 0 �� 1
  user_check number default 0 --����, ������ ����
  ); 
  
create table genre(
  genre_code varchar2(30) primary key, -- �帣�ڵ�
  genre_name varchar2(30)	-- �帣
);


create sequence artist_no nocache;
drop sequence artist_no;
create table artist(
	artist_no number primary key,	-- ��Ƽ��Ʈ�� �ڵ�
  artist_imgurl varchar2(50) not null, --��Ƽ��Ʈ ����
	artist_name varchar2(25) not null, -- ��Ƽ��Ʈ �̸�
	artist_gender number, 	--��Ƽ��Ʈ ���� �� 0 �� 1
	artist_group number	-- ��Ƽ��Ʈ �׷� ����
);


create sequence album_no nocache;
drop sequence album_no;
create table album(
	album_no number primary key,
	album_name varchar2(25) not null,
	song_artist number references artist(artist_no),
	debut_date date,
	genre_code varchar2(50) references genre(genre_code)
);


create table album_image(
	album_imgurl varchar2(50) primary key,
	album_no number references album(album_no)
);


create sequence song_no nocache;
drop sequence song_no;
create table song(
   song_no number primary key,
   song_name varchar2(25) not null, -- �� �̸�
  artist_code number references artist(artist_no), -- ���� �ڵ�
  genre_code varchar2(50) references genre(genre_code) , -- �帣 �ڵ�
  album_code number references album(album_no), -- �ٹ� �ڵ�
  album_imgurl varchar2(50) references album_image(album_imgurl), --�̹��� url
  song_title number default 0 -- 0�̸� ���� 1�̸� title
  ); 


create table song_url(
   song_url varchar2(50) primary key, -- ����song url
   song_no number references song(song_no)
);

create sequence my_album_no nocache;
drop SEQUENCE my_album_no;
create table my_album(
     my_album_no number primary key,
     user_id varchar2(25) references user_table(user_id), -- ȸ�� ���̵�
     song_name number references song(song_no), -- ��
     artist_name number references artist(artist_no), --������
     album_name number references album(album_no), --�ٹ���
     song_url varchar2(50) references song_url(song_url), -- url
     imgurl varchar2(50) references album_image(album_imgurl) -- �̹��� url
);


create sequence review_no nocache;
drop sequence review_no;
create table review(
  review_no number primary key, --���� ��ȣ
  review_id varchar2(25) references user_table(user_id),  -- �������̺� user_id ����
  review_contents varchar2(100), -- ���� 100�� �̳��� ����
  review_date date   
);               

commit;

insert into user_table values('system', 'system', '������', to_date('90-09-10', 'YY-MM-DD'), 1, 1);
insert into genre values(1, '��/�߶��');
insert into artist values(artist_no.nextval, 'img¯', '������',1,0);
insert into album values(ALBUM_NO.nextval, '����', artist_no.currval, to_date('99-09-19', 'YY-MM-DD'), 1);
insert into album_image values ('1q2w3e', ALBUM_NO.currval);
insert into song values(song_no.nextval,  '����',artist_no.currval, 1, album_no.currval, '1q2w3e',1);
insert into SONG_URL values(1212, song_no.currval);
insert into MY_ALBUM values(my_album_no.nextval, 'system', song_no.currval, artist_no.currval, album_no.currval, 1212, '1q2w3e');
insert into review values(review_no.nextval, 'system', '��� ¯�̴�',sysdate);

select * from user_table;
select * from album_image;
select * from album;
select * from artist;
select * from genre;
select * from my_album;
select * from review;
select * from song;
select * from song_url;

SELECT * FROM song WHERE song_name  LIKE '%������%';

SELECT D.SONG_NAME, D.ARTIST_CODE, D.ALBUM_IMGURL, E.SONG_URL  --�������� ������(���ǹ�ȣ�� �˻�)
FROM SONG D join SONG_URL E 
ON D.SONG_NO=E.SONG_NO 
where D.SONG_NO = 1; 