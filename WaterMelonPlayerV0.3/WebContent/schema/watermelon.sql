create user watermelon identified by 1234;

alter user watermelon account unlock;

grant connect, resource to watermelon;

grant create sequence to watermelon;

-- 드랍 순서
drop table my_album;
drop table song_url;
drop table review;
drop table user_table;
drop table song;
drop table album_image;
drop table album;
drop table artist;
drop table genre;


--테이블 생성은 순차적으로 하면됨
create table user_table(
  user_id varchar2(50) primary key, --회원 id 이메일양식
  user_password varchar2(20) not null, -- 회원 비밀번호
  user_name varchar2(20) not null, -- 회원 이름
  user_birth date not null, -- 회원 생년월일
  user_gender number, -- 회원 성별 남 0 여 1
  user_check number default 0 --유저, 관리자 구별
  ); 
  
create table genre(
  genre_code varchar2(30) primary key, -- 장르코드
  genre_name varchar2(30)	-- 장르
);


create sequence artist_no nocache;
drop sequence artist_no;
create table artist(
	artist_no number primary key,	-- 아티스트별 코드
  artist_imgurl varchar2(50) not null, --아티스트 사진
	artist_name varchar2(25) not null, -- 아티스트 이름
	artist_gender number, 	--아티스트 성별 남 0 여 1
	artist_group number	-- 아티스트 그룹 구분
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
   song_name varchar2(25) not null, -- 곡 이름
  artist_code number references artist(artist_no), -- 가수 코드
  genre_code varchar2(50) references genre(genre_code) , -- 장르 코드
  album_code number references album(album_no), -- 앨범 코드
  album_imgurl varchar2(50) references album_image(album_imgurl), --이미지 url
  song_title number default 0 -- 0이면 없음 1이면 title
  ); 


create table song_url(
   song_url varchar2(50) primary key, -- 서버song url
   song_no number references song(song_no)
);

create sequence my_album_no nocache;
drop SEQUENCE my_album_no;
create table my_album(
     my_album_no number primary key,
     user_id varchar2(25) references user_table(user_id), -- 회원 아이디
     song_name number references song(song_no), -- 곡
     artist_name number references artist(artist_no), --가수명
     album_name number references album(album_no), --앨범명
     song_url varchar2(50) references song_url(song_url), -- url
     imgurl varchar2(50) references album_image(album_imgurl) -- 이미지 url
);


create sequence review_no nocache;
drop sequence review_no;
create table review(
  review_no number primary key, --리뷰 번호
  review_id varchar2(25) references user_table(user_id),  -- 유저테이블 user_id 참조
  review_contents varchar2(100), -- 리뷰 100자 이내로 저장
  review_date date   
);               

commit;

insert into user_table values('system', 'system', '라이츄', to_date('90-09-10', 'YY-MM-DD'), 1, 1);
insert into genre values(1, '댄스/발라드');
insert into artist values(artist_no.nextval, 'img짱', '아이유',1,0);
insert into album values(ALBUM_NO.nextval, '제제', artist_no.currval, to_date('99-09-19', 'YY-MM-DD'), 1);
insert into album_image values ('1q2w3e', ALBUM_NO.currval);
insert into song values(song_no.nextval,  '제제',artist_no.currval, 1, album_no.currval, '1q2w3e',1);
insert into SONG_URL values(1212, song_no.currval);
insert into MY_ALBUM values(my_album_no.nextval, 'system', song_no.currval, artist_no.currval, album_no.currval, 1212, '1q2w3e');
insert into review values(review_no.nextval, 'system', '우아 짱이다',sysdate);

select * from user_table;
select * from album_image;
select * from album;
select * from artist;
select * from genre;
select * from my_album;
select * from review;
select * from song;
select * from song_url;

SELECT * FROM song WHERE song_name  LIKE '%좋은날%';

SELECT D.SONG_NAME, D.ARTIST_CODE, D.ALBUM_IMGURL, E.SONG_URL  --준일이형 세렉문(음악번호로 검색)
FROM SONG D join SONG_URL E 
ON D.SONG_NO=E.SONG_NO 
where D.SONG_NO = 1; 