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
  
create table song(
    song_name varchar2(20) not null, -- 곡 이름
    song_artist varchar2(20) not null, -- 가수 이름
    genre_code varchar2(10) references song_genre(genre_code) , -- 장르
    song_album varchar2(20) not null, -- 앨범 이름
    song_url varchar2(50) primary key, --url
    song_imgurl varchar2(50), -- 이미지 url
    song_title number default 0); -- 타이틀곡 0이면 일반곡, 1이면 타이틀곡

drop table song;

create table song_genre(
  genre_code varchar2(10) primary key,
  genre_name varchar2(15)
);

create sequence my_album_no_sequence nocache;

create table my_album(
     my_album_no number primary key,
     user_name varchar2(20) references user_table(user_name), -- 회원 이름
     song_name varchar2(20) references song(song_name), -- 곡명
     song_artist varchar2(20) references song(song_artist), --가수명
     song_album varchar2(20) references song(song_album), --앨범명
     url varchar2(20) references song(song_url), -- url
     imgurl varchar2(20) references song(song_imgurl) -- 이미지 url
);

drop table my_album;

create sequence review_no_sequence nocache;

create table review(
  review_no number primary key,
  review_id varchar2(25) references user_table(user_id),  -- 유저테이블 user_id 참조
  review_contents varchar2(100));         -- 리뷰 100자 이내로 저장

drop table review;

create table song_artist(
	artist varchar2(25) primary key,
	gender number,
	group number
);

drop table song_artist;

create table song_album(
	song_album varchar2(25) primary key,
	song_artist varchar2(25) references song_artist(artist),
	debut_date date,
	genre_code varchar2(10) references song_genre(genre_code)
);

drop table song_album;

commit

select * from bank1;
select * from user_table;