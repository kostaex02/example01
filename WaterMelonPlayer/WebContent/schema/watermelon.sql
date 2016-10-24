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
  
create table song(
    song_name varchar2(20) not null, -- �� �̸�
    song_artist varchar2(20) not null, -- ���� �̸�
    genre_code varchar2(10) references song_genre(genre_code) , -- �帣s
    song_album varchar2(20) not null, -- �ٹ� �̸�
    song_url varchar2(50) primary key, --url
    song_imgurl varchar2(50), -- �̹��� url
    song_title number default 0); -- Ÿ��Ʋ�� 0�̸� �Ϲݰ�, 1�̸� Ÿ��Ʋ��

drop table song;

create table song_genre(
  genre_code varchar2(10) primary key,
  genre_name varchar2(15)
);

create sequence my_album_no_sequence nocache;

create table my_album(
     my_album_no number primary key,
     id varchar2(20) references user_table(user_id),
     url varchar2(20) references song(song_url)
);

drop table my_album;

create sequence review_no_sequence nocache;

create table review(
  review_no number primary key,
  review_id varchar2(25) references user_table(user_id),  -- �������̺� user_id ����
  review_contents varchar2(100));         -- ���� 100�� �̳��� ����

drop table review;
  