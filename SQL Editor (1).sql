create table Genre
(
   GenreCode varchar2(50) primary key,
   GenreName varchar2(50)
);

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

create table admin
(
   AdminId varchar2(50) primary key,
   AdminPw varchar2(50) not null,
   AdminPos varchar2(50) not null,
   AdminName varchar2(50) not null
);

<<<<<<< HEAD
=======
insert into admin values(1, 1, 1, 1);
commit;

select * from admin;

>>>>>>> origin/master
CREATE TABLE Book
(
   BookBarCode int primary key,
   BookName varchar2(50) not null,
   BookAuthor varchar2(50) not null,
   BookPublisher varchar2(20) not null,
   GenreCode varchar2(50) references Genre(GenreCode)
);

<<<<<<< HEAD
=======
select * from Book;

insert into Book values(3, '스타코' , '스타코', '스타코', null);
insert into Book values(2,'kosta',1,1,null);
insert into Book values(1,'코스타', '코스타', '코스타', null);
commit;


>>>>>>> origin/master
CREATE TABLE BookLoan
(

   LoanNumber int primary key,
   BookLoanTF varchar2(10) default 'f',
   BookLoanDate Date default sysdate,
   AdminId varchar2(50) references Admin(adminId),
   UserBarCode int references UserInfo(UserBarcode),
   BookBarCode int references Book(BookBarCode)

);

<<<<<<< HEAD
=======
select * from BookLoan;

--TOP5 대출 순위 리스트 sql문
select rownum, book.BOOKNAME
from (
select count(bookbarcode) tt ,bookbarcode 
from bookloan
where bookbarcode is not null
group by bookbarcode
order by tt desc ) tmp, book
where book.bookbarcode = tmp.bookbarcode
and rownum <=5;

>>>>>>> origin/master
create table bookmgm
(
   BookMgmNumber int primary key,
   BookMgmDate date default sysdate,
   adminId varchar2(50) references Admin(adminId),
   BookBarcode int references Book(BookBarcode)
   
);

create table LibCard
(
   LibCardBarcode int primary key,
   LibCardIssDate date default sysdate,
   LibCardExpDate date,
   AdminId varchar2(50) references Admin(AdminId),
   UserBarcode int references UserInfo(UserBarcode)
);

create table GenreMgm
(
   GenreMgmNumber int,
   GenreCode varchar2(50) references Genre(GenreCode),
   AdminId varchar2(50) references Admin(AdminId)
);

<<<<<<< HEAD
=======
select * from GenreMgm;

--희망도서 신청
CREATE TABLE SEARCHBOOK(

  SEARCHBOOKNUMBER VARCHAR2(50) PRIMARY KEY,
  SEARCHBOOKNAME VARCHAR2(50) NOT NULL,
  SEARCHBOOKAUTHOR VARCHAR2(50) NOT NULL,
  SEARCHBOOKPUBLISHER VARCHAR2(50) NOT NULL,
  SEARCHBOOKPRICE INT NOT NULL
  );
  
CREATE TABLE REQUESTBOOK(

  REQUESTBOOKNUMBER INT PRIMARY KEY,
  REQUESTBOOKNAME VARCHAR2(50) NOT NULL,
  REQUESTBOOKAUTHOR VARCHAR2(50) NOT NULL,
  REQUESTBOOKPUBLISHER VARCHAR2(50) NOT NULL,
  REQUESTBOOKCOUNTNUMBER INT NOT NULL,
  REQUESTBOOKPRICE INT NOT NULL
  );
  
 CREATE TABLE CARTBOOK(
  
  BOOKNUMBER INT PRIMARY KEY,
  BOOKNAME VARCHAR2(50) NOT NULL,
  BOOKAUTHOR VARCHAR2(50) NOT NULL,
  BOOKPUBLISHER VARCHAR2(50) NOT NULL,
  BOOKCOUNTNUMBER VARCHAR2(50) NOT NULL,
  BOOKPRICE INT NOT NULL,
  BOOKBUYDATE DATE DEFAULT SYSDATE
  
);

>>>>>>> origin/master
drop table GenreMgm;
drop table LibCard;
drop table bookmgm;
drop table BookLoan;
drop table Book;
drop table admin;
drop table UserInfo;
drop table Genre;
<<<<<<< HEAD

<<<<<<< HEAD


=======
select * from GenreMgm;
>>>>>>> origin/master
=======
drop table SEARCHBOOK;
drop table REQUESTBOOK;
drop table CARTBOOK;
>>>>>>> origin/master
