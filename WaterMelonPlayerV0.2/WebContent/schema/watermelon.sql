create user watermelon identified by 1234;

alter user watermelon account unlock;

grant connect, resource to watermelon;

grant create sequence to watermelon;


create table user_table(
  user_id varchar2(20) primary key, --회원 id 이메일양식
  user_password varchar2(20) not null, -- 회원 비밀번호
  user_name varchar2(20) not null, -- 회원 이름
  user_birth date not null, -- 회원 생년월일
  user_gender number, -- 회원 성별 남 0 여 1
  user_check number default 0); --유저, 관리자 구별
  
  drop table user_table;

create table genre(
  genre_code varchar2(10) primary key, -- 장르코드
  genre_name varchar2(15)	not null-- 장르
);
drop table genre;

create sequence artist_no_sequence nocache;

create table artist(
	artist_no number primary key,	-- 아티스트별 코드
	artist_name varchar2(25) not null, -- 아티스트 이름
	artist_gender number, 	--아티스트 성별 남 0 여 1
	artist_group number	-- 아티스트 그룹 구분
);

drop table artist;

create table artist_image(
  artist_imgurl varchar2(50) primary key,
  artist_no number references artist(artist_no)
);
drop table artist_image;

create sequence album_no_sequence nocache;

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

create sequence song_no_sequence nocache;

create table song(
	song_no number primary key,
	song_name varchar2(20) not null, -- 곡 이름
  artist_code number references artist(artist_no), -- 가수 코드
  genre_code varchar2(10) references genre(genre_code) , -- 장르 코드
  album_code number references album(album_no), -- 앨범 코드
  album_imgurl varchar2(50) references album_image(album_imgurl), --이미지 url
  song_title number default 0); -- 타이틀곡 0이면 일반곡, 1이면 타이틀곡

drop table song;

create table song_url(
	song_url varchar2(50) primary key, -- song url
	song_no number references song(song_no)
);

drop table song_url;

create sequence my_album_no_sequence nocache;

create table my_album(
     my_album_no number primary key,
     user_id varchar2(20) references user_table(user_id), -- 회원 아이디
     song_name number references song(song_no), -- 곡
     artist_name number references artist(artist_no), --가수명
     album_name number references album(album_no), --앨범명
     song_url varchar2(20) references song_url(song_url), -- url
     imgurl varchar2(20) references album_image(album_imgurl) -- 이미지 url
);

drop table my_album;

create sequence review_no nocache;

create table review(
  review_no number primary key, --리뷰 번호
  review_id varchar2(25) references user_table(user_id),  -- 유저테이블 user_id 참조
  review_contents varchar2(100), -- 리뷰내용
  review_date date	 -- 리뷰 100자 이내로 저장
);        
drop table review;

commit;

select * from user_table;
select * from review;
insert into review values(REVIEW_NO.nextval,'mirugt','노래 좋아s요',sysdate);
insert into review values(review_no.nextval,'kim','잘 들었습니다.',sysdate);