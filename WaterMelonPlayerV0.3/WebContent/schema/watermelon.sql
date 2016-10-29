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

drop sequence artist_no;
drop sequence song_no;
drop sequence album_no;
drop SEQUENCE my_album_no;
drop sequence review_no;

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
  genre_code number primary key, -- 장르코드
  genre_name varchar2(30)	-- 장르
);


create sequence artist_no nocache;

create table artist(
	artist_no number primary key,	-- 아티스트별 코드
  artist_imgurl varchar2(100) not null, --아티스트 사진
	artist_name varchar2(25) not null, -- 아티스트 이름
	artist_gender number, 	--아티스트 성별 남 0 여 1
	artist_group number	-- 아티스트 그룹 구분
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
   song_name varchar2(25) not null, -- 곡 이름
  artist_code number references artist(artist_no), -- 가수 코드
  genre_code number references genre(genre_code) , -- 장르 코드
  album_code number references album(album_no), -- 앨범 코드
  album_imgurl varchar2(100) references album_image(album_imgurl), --이미지 url
  song_title number default 0 -- 0이면 없음 1이면 title
  ); 


create table song_url(
   song_url varchar2(100) primary key, -- 서버song url
   song_no number references song(song_no)
);

create sequence my_album_no nocache;

create table my_album(
     my_album_no number primary key,
     user_id varchar2(25) references user_table(user_id), -- 회원 아이디
     song_name number references song(song_no), -- 곡
     artist_name number references artist(artist_no), --가수명
     album_name number references album(album_no), --앨범명
     song_url varchar2(100) references song_url(song_url), -- url
     imgurl varchar2(50) references album_image(album_imgurl) -- 이미지 url
);


create sequence review_no nocache;

create table review(
  review_no number primary key, --리뷰 번호
  review_id varchar2(25) references user_table(user_id),  -- 유저테이블 user_id 참조
  review_contents varchar2(200), -- 리뷰 100자 이내로 저장
  review_date date   
);               

commit;
--관리자 생성 및 리뷰 확인
insert into user_table values('system', 'system', '라이츄', to_date('90-09-10', 'YY-MM-DD'), 0, 1);
insert into review values(review_no.nextval, 'system', '우아 짱이다',sysdate);

--데이터 삽입 계정은 하나로 쭉
insert into user_table values('watermelon', '1234', '수박', to_date('16-07-28', 'YY-MM-DD'), 1, 0);
insert into genre values(1, 'Rap/Hip-hop');
insert into artist values(artist_no.nextval, '../img/', 'BewhY(비와이)',1,0);
insert into album values(ALBUM_NO.nextval, '쇼미더머니 5 Episode 4', artist_no.currval, to_date('2016-07-09', 'YYYY-MM-DD'), 1);
insert into album_image values ('../img/', ALBUM_NO.currval);
insert into song values(song_no.nextval,  'Day Day (Feat. 박재범) (Prod. by GRAY)', artist_no.currval, 1, album_no.currval, '../img/',1);
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

insert into song values(song_no.nextval,  '우아해(woo ah)', artist_no.currval, 2, album_no.currval, '../img/',0);
insert into SONG_URL values('../mp3/', song_no.currval);

insert into album values(ALBUM_NO.nextval, '투유 프로젝트 - 슈가맨 Part.3', artist_no.currval, to_date('2016-05-06', 'YYYY-MM-DD'), 2);
insert into album_image values ('../img/', ALBUM_NO.currval);
insert into song values(song_no.nextval,  '아마도 그건', artist_no.currval, 2, album_no.currval, '../img/',0);
insert into SONG_URL values('../mp3/', song_no.currval);

insert into artist values(artist_no.nextval, '../img/', 'DEAN',1,0);
insert into album values(ALBUM_NO.nextval, '130 mood : TRBL', artist_no.currval, to_date('2016-03-24', 'YYYY-MM-DD'), 2);
insert into album_image values ('../img/', ALBUM_NO.currval);
insert into song values(song_no.nextval,  'D (half moon) (Feat. 개코)', artist_no.currval, 2, album_no.currval, '../img/',0);
insert into SONG_URL values('../mp3/', song_no.currval);

insert into artist values(artist_no.nextval, '../img/', '지코(ZICO)',1,0);
insert into album values(ALBUM_NO.nextval, 'Boys and Girls', artist_no.currval, to_date('2015-11-03', 'YYYY-MM-DD'), 2);
insert into album_image values ('../img/', ALBUM_NO.currval);
insert into song values(song_no.nextval,  'Boys And Girls (Feat. Babylon)', artist_no.currval, 2, album_no.currval, '../img/',0);
insert into SONG_URL values('../mp3/', song_no.currval);

insert into album values(ALBUM_NO.nextval, 'Break Up 2 Make Up', artist_no.currval, to_date('2016-01-25', 'YYYY-MM-DD'), 1);
insert into album_image values ('../img/', ALBUM_NO.currval);
insert into song values(song_no.nextval,  '너는 나 나는 너', artist_no.currval, 1, album_no.currval, '../img/',1);
insert into SONG_URL values('../mp3/', song_no.currval);

insert into album values(ALBUM_NO.nextval, 'GALLERY', artist_no.currval, to_date('2015-12-07', 'YYYY-MM-DD'), 1);
insert into album_image values ('../img/', ALBUM_NO.currval);
insert into song values(song_no.nextval,  '유레카 (Feat. Zion.T)', artist_no.currval, 1, album_no.currval, '../img/',1);
insert into SONG_URL values('../mp3/', song_no.currval);

insert into artist values(artist_no.nextval, '../img/', '백예린',0,0);
insert into album values(ALBUM_NO.nextval, 'Bye bye my blue', artist_no.currval, to_date('2016-06-20', 'YYYY-MM-DD'), 2);
insert into album_image values ('../img/', ALBUM_NO.currval);
insert into song values(song_no.nextval,  'Bye bye my blue', artist_no.currval, 2, album_no.currval, '../img/',1);
insert into SONG_URL values('../mp3/', song_no.currval);

insert into genre values(3, 'Ballad');
insert into artist values(artist_no.nextval, '../img/', '정은지',0,0);
insert into album values(ALBUM_NO.nextval, 'Dream', artist_no.currval, to_date('2016-04-18', 'YYYY-MM-DD'), 3);
insert into album_image values ('../img/', ALBUM_NO.currval);
insert into song values(song_no.nextval,  '하늘바라기 (Feat. 하림)', artist_no.currval, 3, album_no.currval, '../img/',1);
insert into SONG_URL values('../mp3/', song_no.currval);

insert into genre values(4, 'Dance');
insert into artist values(artist_no.nextval, '../img/', '가인',0,0);
insert into album values(ALBUM_NO.nextval, 'End Again', artist_no.currval, to_date('2016-09-09', 'YYYY-MM-DD'), 4);
insert into album_image values ('../img/', ALBUM_NO.currval);
insert into song values(song_no.nextval,  'Carnival (The Last Day)', artist_no.currval, 4, album_no.currval, '../img/',1);
insert into SONG_URL values('../mp3/', song_no.currval);

insert into genre values(5, 'Folk');
insert into artist values(artist_no.nextval, '../img/', '볼빨간사춘기',0,1);
insert into album values(ALBUM_NO.nextval, 'Full Album RED PLANET', artist_no.currval, to_date('2016-08-29', 'YYYY-MM-DD'), 5);
insert into album_image values ('../img/', ALBUM_NO.currval);
insert into song values(song_no.nextval,  '우주를 줄게', artist_no.currval, 5, album_no.currval, '../img/',1);
insert into SONG_URL values('../mp3/', song_no.currval);

insert into song values(song_no.nextval,  '나만 안되는 연애', artist_no.currval, 5, album_no.currval, '../img/',1);
insert into SONG_URL values('../mp3/', song_no.currval);

insert into artist values(artist_no.nextval, '../img/', '로꼬 (LOCO), GRAY (그레이)',1,1);
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

SELECT * FROM song WHERE song_name  LIKE '%좋은날%';

SELECT D.SONG_NAME, D.ARTIST_CODE, D.ALBUM_IMGURL, E.SONG_URL  --준일이형 세렉문(음악번호로 검색)
FROM SONG D join SONG_URL E 
ON D.SONG_NO=E.SONG_NO 
where D.SONG_NO = 1; 