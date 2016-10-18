--장르관리테이블 삭제
drop table genremgm;

--대출관리테이블 삭제
drop table libcard;

--도서관리테이블 삭제
drop table bookmgm;

--도서대출테이블 삭제
drop table bookloan;

--도서테이블 삭제
drop table book;

--장르테이블 삭제
drop table Genre;

--유저테이블 삭제
drop table userinfo;

--관리자테이블 삭제
drop table admin;

--장르테이블 확인
select * from genre;

--유저테이블 확인
select * from userinfo;

--관리자테이블 확인
select * from admin;

--도서테이블 확인
select * from book;

--도서대출테이블 확인
select * from bookloan;

--도서관리테이블 확인
select * from bookmgm;

--대출카드테이블 확인
select * from libcard;

--장르관리테이블 확인
select * from genremgm;

--장르테이블 생성
create table Genre
(
   GenreCode varchar2(50) primary key,
   GenreName varchar2(50)
);

--유저테이블 생성
CREATE TABLE UserInfo
(
   UserBarcode int primary key,
   UserId varchar2(50) not null,
   UserPw varchar2(50) not null,
   UserName varchar2(50) not null,
   UserAddr varchar2(50) not null,
   Usertel varchar2(50) not null,
   UserGender varchar2(50) not null,
   UserRegDate Date default sysdate
);

--관리자테이블 생성
create table admin
(
   AdminId varchar2(50) primary key,
   AdminPw varchar2(50) not null,
   AdminPos varchar2(50) not null,
   AdminName varchar2(50) not null
);

--도서테이블 생성
CREATE TABLE Book
(
   BookBarCode int primary key,
   BookName varchar2(50) not null,
   BookAuthor varchar2(50) not null,
   BookPublisher varchar2(20) not null,
   GenreCode varchar2(50) references Genre(GenreCode)
);

--도서대출테이블 생성
CREATE TABLE BookLoan
(
   LoanNumber int primary key,
   BookLoanTF varchar2(10) default 't',
   BookLoanDate Date default sysdate,
   AdminId varchar2(50) references Admin(adminId),
   UserBarCode int references UserInfo(UserBarcode),
   BookBarCode int references Book(BookBarCode)

);

--대출카드테이블 생성
create table LibCard
(
   LibCardBarcode int primary key,
   LibCardIssDate date default sysdate,
   LibCardExpDate date,
   AdminId varchar2(50) references Admin(AdminId),
   UserBarcode int references UserInfo(UserBarcode)
);

--장르관리테이블 생성
create table GenreMgm
(
   GenreMgmNumber int,
   GenreCode varchar2(50) references Genre(GenreCode),
   AdminId varchar2(50) references Admin(AdminId)
);

--도서관리테이블 생성
create table bookmgm
(
   BookMgmNumber int primary key,
   BookMgmDate date default sysdate,
   adminId varchar2(50) references Admin(adminId),
   BookBarcode int references Book(BookBarcode)
   
);

--도서검색테이블 생성
CREATE TABLE SEARCHBOOK(

  SEARCHBOOKNUMBER VARCHAR2(50) PRIMARY KEY,
  SEARCHBOOKNAME VARCHAR2(50) NOT NULL,
  SEARCHBOOKAUTHOR VARCHAR2(50) NOT NULL,
  SEARCHBOOKPUBLISHER VARCHAR2(50) NOT NULL,
  SEARCHBOOKPRICE INT NOT NULL
  );
  
--도서요청테이블 생성
CREATE TABLE REQUESTBOOK(

  REQUESTBOOKNUMBER INT PRIMARY KEY,
  REQUESTBOOKNAME VARCHAR2(50) NOT NULL,
  REQUESTBOOKAUTHOR VARCHAR2(50) NOT NULL,
  REQUESTBOOKPUBLISHER VARCHAR2(50) NOT NULL,
  REQUESTBOOKCOUNTNUMBER INT NOT NULL,
  REQUESTBOOKPRICE INT NOT NULL
  );
  
  --도서구매테이블 생성
 CREATE TABLE CARTBOOK(
  
  BOOKNUMBER INT PRIMARY KEY,
  BOOKNAME VARCHAR2(50) NOT NULL,
  BOOKAUTHOR VARCHAR2(50) NOT NULL,
  BOOKPUBLISHER VARCHAR2(50) NOT NULL,
  BOOKCOUNTNUMBER VARCHAR2(50) NOT NULL,
  BOOKPRICE INT NOT NULL,
  BOOKBUYDATE DATE DEFAULT SYSDATE  
);

--admin계정 삽입
insert into admin values('admin','admin','관장','김권식');
--장르 삽입
insert into genre values('g1','철학');
insert into genre values('g2 ','종교');
insert into genre values('g3 ','사회과학');
insert into genre values('g4 ','순수과학');
insert into genre values('g5 ','기술과학');
insert into genre values('g6 ','예술');
insert into genre values('g7 ','언어');
insert into genre values('g8 ','문학');
insert into genre values('g9 ','역사');
insert into genre values('g10 ','학문과 과학 ');
insert into genre values('g11 ','언어와 문학 ');

--도서검색테이블 값 삽입
insert into SEARCHBOOK values(1, '롤리폴리', '폴리', '롤리', '1000');
insert into SEARCHBOOK values(2, '미네랄워터', '미네랄', '워터', '1000');
insert into SEARCHBOOK values(3, '메모장', '메', '모장', '1000');
insert into SEARCHBOOK values(4, '아로니아', '아로', '니아', '1000');
insert into SEARCHBOOK values(5, '스프린트', '스', '프른트', '1000');
insert into SEARCHBOOK values(6, '지프로', '지', '프로', '1000');
insert into SEARCHBOOK values(7, '에이그레이트', '에이', '그레이트', '1000');
insert into SEARCHBOOK values(8, '마웃', '마', '우스', '1000');
insert into SEARCHBOOK values(9, '이슈리스크', '이슈', '리스크', '1000');
insert into SEARCHBOOK values(10, '생쥐와거미', '생쥐', '거미', '1000');
insert into SEARCHBOOK values(11, '롤미메', '폴미모', '니프', '1000');

--관리자 생성확인
select * from admin;
--장르 생성확인
select * from genre;
--도서검색 생성 확인
select * from searchbook;

commit;