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

drop sequence artist_no;
drop sequence song_no;
drop sequence album_no;
drop SEQUENCE my_album_no;
drop sequence review_no;

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
  genre_code number primary key, -- �帣�ڵ�
  genre_name varchar2(30)	-- �帣
);


create sequence artist_no nocache;

create table artist(
	artist_no number primary key,	-- ��Ƽ��Ʈ�� �ڵ�
  artist_imgurl varchar2(100) not null, --��Ƽ��Ʈ ����
	artist_name varchar2(25) not null, -- ��Ƽ��Ʈ �̸�
	artist_gender number, 	--��Ƽ��Ʈ ���� �� 0 �� 1
	artist_group number	-- ��Ƽ��Ʈ �׷� ����
);


create sequence album_no nocache;

create table album(
	album_no number primary key,
	album_name varchar2(25) not null,
	song_artist number references artist(artist_no),
	debut_date date,
	genre_code number references genre(genre_code)
);


create table album_image(
	album_imgurl varchar2(100) primary key,
	album_no number references album(album_no)
);


create sequence song_no nocache;

create table song(
   song_no number primary key,
   song_name varchar2(25) not null, -- �� �̸�
  artist_code number references artist(artist_no), -- ���� �ڵ�
  genre_code number references genre(genre_code) , -- �帣 �ڵ�
  album_code number references album(album_no), -- �ٹ� �ڵ�
  album_imgurl varchar2(100) references album_image(album_imgurl), --�̹��� url
  song_title number default 0 -- 0�̸� ���� 1�̸� title
  ); 


create table song_url(
   song_url varchar2(100) primary key, -- ����song url
   song_no number references song(song_no)
);

create sequence my_album_no nocache;

create table my_album(
     my_album_no number primary key,
     user_id varchar2(25) references user_table(user_id), -- ȸ�� ���̵�
     song_name number references song(song_no), -- ��
     artist_name number references artist(artist_no), --������
     album_name number references album(album_no), --�ٹ���
     song_url varchar2(100) references song_url(song_url), -- url
     imgurl varchar2(50) references album_image(album_imgurl) -- �̹��� url
);


create sequence review_no nocache;

create table review(
  review_no number primary key, --���� ��ȣ
  review_id varchar2(25) references user_table(user_id),  -- �������̺� user_id ����
  review_contents varchar2(200), -- ���� 100�� �̳��� ����
  review_date date   
);               

commit;
--������ ���� �� ���� Ȯ��
insert into user_table values('system', 'system', '������', to_date('90-09-10', 'YY-MM-DD'), 0, 1);
insert into review values(review_no.nextval, 'system', '��� ¯�̴�',sysdate);

--������ ���� ������ �ϳ��� ��
insert into user_table values('watermelon', '1234', '����', to_date('16-07-28', 'YY-MM-DD'), 1, 0);
insert into genre values(1, 'Rap/Hip-hop');
insert into artist values(artist_no.nextval, '../img/', 'BewhY(�����)',1,0);
insert into album values(ALBUM_NO.nextval, '��̴��Ӵ� 5 Episode 4', artist_no.currval, to_date('2016-07-09', 'YYYY-MM-DD'), 1);
insert into album_image values ('../img/', ALBUM_NO.currval);
insert into song values(song_no.nextval,  'Day Day (Feat. �����) (Prod. by GRAY)', artist_no.currval, 1, album_no.currval, '../img/',1);
insert into SONG_URL values('../mp3/', song_no.currval);
insert into MY_ALBUM values(my_album_no.nextval, 'watermelon', song_no.currval, artist_no.currval, album_no.currval, '../mp3/', '../img/');

insert into song values(song_no.nextval,  'Forever (Prod. By GRAY)', artist_no.currval, 1, album_no.currval, '../img/',1);
insert into SONG_URL values('../mp3/', song_no.currval);
insert into MY_ALBUM values(my_album_no.nextval, 'watermelon', song_no.currval, artist_no.currval, album_no.currval, '../mp3/', '../img/');

insert into song values(song_no.nextval,  'The Time Goes On', artist_no.currval, 1, album_no.currval, '../img/',1);
insert into SONG_URL values('../mp3/', song_no.currval);
insert into MY_ALBUM values(my_album_no.nextval, 'watermelon', song_no.currval, artist_no.currval, album_no.currval, '../mp3/', '../img/');

insert into genre values(2, 'R&B/Soul');
insert into artist values(artist_no.nextval, '../img/', 'Crush',1,0);
insert into album values(ALBUM_NO.nextval, 'Interlude', artist_no.currval, to_date('2016-05-06', 'YYYY-MM-DD'), 2);
insert into album_image values ('../img/', ALBUM_NO.currval);
insert into song values(song_no.nextval,  'In The Air', artist_no.currval, 2, album_no.currval, '../img/',0);
insert into SONG_URL values('../mp3/', song_no.currval);

insert into song values(song_no.nextval,  '�����(woo ah)', artist_no.currval, 2, album_no.currval, '../img/',0);
insert into SONG_URL values('../mp3/', song_no.currval);

insert into album values(ALBUM_NO.nextval, '���� ������Ʈ - ������ Part.3', artist_no.currval, to_date('2016-05-06', 'YYYY-MM-DD'), 2);
insert into album_image values ('../img/', ALBUM_NO.currval);
insert into song values(song_no.nextval,  '�Ƹ��� �װ�', artist_no.currval, 2, album_no.currval, '../img/',0);
insert into SONG_URL values('../mp3/', song_no.currval);

insert into artist values(artist_no.nextval, '../img/', 'DEAN',1,0);
insert into album values(ALBUM_NO.nextval, '130 mood : TRBL', artist_no.currval, to_date('2016-03-24', 'YYYY-MM-DD'), 2);
insert into album_image values ('../img/', ALBUM_NO.currval);
insert into song values(song_no.nextval,  'D (half moon) (Feat. ����)', artist_no.currval, 2, album_no.currval, '../img/',0);
insert into SONG_URL values('../mp3/', song_no.currval);

insert into artist values(artist_no.nextval, '../img/', '����(ZICO)',1,0);
insert into album values(ALBUM_NO.nextval, 'Boys and Girls', artist_no.currval, to_date('2015-11-03', 'YYYY-MM-DD'), 2);
insert into album_image values ('../img/', ALBUM_NO.currval);
insert into song values(song_no.nextval,  'Boys And Girls (Feat. Babylon)', artist_no.currval, 2, album_no.currval, '../img/',0);
insert into SONG_URL values('../mp3/', song_no.currval);

insert into album values(ALBUM_NO.nextval, 'Break Up 2 Make Up', artist_no.currval, to_date('2016-01-25', 'YYYY-MM-DD'), 1);
insert into album_image values ('../img/', ALBUM_NO.currval);
insert into song values(song_no.nextval,  '�ʴ� �� ���� ��', artist_no.currval, 1, album_no.currval, '../img/',1);
insert into SONG_URL values('../mp3/', song_no.currval);

insert into album values(ALBUM_NO.nextval, 'GALLERY', artist_no.currval, to_date('2015-12-07', 'YYYY-MM-DD'), 1);
insert into album_image values ('../img/', ALBUM_NO.currval);
insert into song values(song_no.nextval,  '����ī (Feat. Zion.T)', artist_no.currval, 1, album_no.currval, '../img/',1);
insert into SONG_URL values('../mp3/', song_no.currval);

insert into artist values(artist_no.nextval, '../img/', '�鿹��',0,0);
insert into album values(ALBUM_NO.nextval, 'Bye bye my blue', artist_no.currval, to_date('2016-06-20', 'YYYY-MM-DD'), 2);
insert into album_image values ('../img/', ALBUM_NO.currval);
insert into song values(song_no.nextval,  'Bye bye my blue', artist_no.currval, 2, album_no.currval, '../img/',1);
insert into SONG_URL values('../mp3/', song_no.currval);

insert into genre values(3, 'Ballad');
insert into artist values(artist_no.nextval, '../img/', '������',0,0);
insert into album values(ALBUM_NO.nextval, 'Dream', artist_no.currval, to_date('2016-04-18', 'YYYY-MM-DD'), 3);
insert into album_image values ('../img/', ALBUM_NO.currval);
insert into song values(song_no.nextval,  '�ϴùٶ�� (Feat. �ϸ�)', artist_no.currval, 3, album_no.currval, '../img/',1);
insert into SONG_URL values('../mp3/', song_no.currval);

insert into genre values(4, 'Dance');
insert into artist values(artist_no.nextval, '../img/', '����',0,0);
insert into album values(ALBUM_NO.nextval, 'End Again', artist_no.currval, to_date('2016-09-09', 'YYYY-MM-DD'), 4);
insert into album_image values ('../img/', ALBUM_NO.currval);
insert into song values(song_no.nextval,  'Carnival (The Last Day)', artist_no.currval, 4, album_no.currval, '../img/',1);
insert into SONG_URL values('../mp3/', song_no.currval);

insert into genre values(5, 'Folk');
insert into artist values(artist_no.nextval, '../img/', '�����������',0,1);
insert into album values(ALBUM_NO.nextval, 'Full Album RED PLANET', artist_no.currval, to_date('2016-08-29', 'YYYY-MM-DD'), 5);
insert into album_image values ('../img/', ALBUM_NO.currval);
insert into song values(song_no.nextval,  '���ָ� �ٰ�', artist_no.currval, 5, album_no.currval, '../img/',1);
insert into SONG_URL values('../mp3/', song_no.currval);

insert into song values(song_no.nextval,  '���� �ȵǴ� ����', artist_no.currval, 5, album_no.currval, '../img/',1);
insert into SONG_URL values('../mp3/', song_no.currval);

insert into artist values(artist_no.nextval, '../img/', '�β� (LOCO), GRAY (�׷���)',1,1);
insert into album values(ALBUM_NO.nextval, 'GOOD', artist_no.currval, to_date('2016-06-15', 'YYYY-MM-DD'), 1);
insert into album_image values ('../img/', ALBUM_NO.currval);
insert into song values(song_no.nextval,  'In The Air', artist_no.currval, 1, album_no.currval, '../img/',0);
insert into SONG_URL values('../mp3/', song_no.currval);


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