create table Genre
(
   GenreCode varchar2(50) primary key,
   GenreName varchar2(50)
);

select * from Genre;

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

select * from UserInfo;

create table admin
(
   AdminId varchar2(50) primary key,
   AdminPw varchar2(50) not null,
   AdminPos varchar2(50) not null,
   AdminName varchar2(50) not null
);

select * from admin;

CREATE TABLE Book
(
   BookBarCode int primary key,
   BookName varchar2(50) not null,
   BookAuthor varchar2(50) not null,
   BookPublisher varchar2(20) not null,
   GenreCode varchar2(50) references Genre(GenreCode)
);

select * from Book;

insert into Book values(3, '스타코' , '스타코', '스타코', null);
insert into Book values(2,'kosta',1,1,null);
insert into Book values(1,'코스타', '코스타', '코스타', null);


CREATE TABLE BookLoan
(
   LoanNumber int primary key,
   BookLoanTF varchar2(10) default 'f',
   BookLoanDate Date default sysdate,
   AdminId varchar2(50) references Admin(adminId),
   UserBarCode int references UserInfo(UserBarcode),
   BookBarCode int references Book(BookBarCode)

);

select * from BookLoan;

create table bookmgm
(
   BookMgmNumber int primary key,
   BookMgmDate date default sysdate,
   adminId varchar2(50) references Admin(adminId),
   BookBarcode int references Book(BookBarcode)
   
);

select * from bookmgm;

create table LibCard
(
   LibCardBarcode int primary key,
   LibCardIssDate date default sysdate,
   LibCardExpDate date,
   AdminId varchar2(50) references Admin(AdminId),
   UserBarcode int references UserInfo(UserBarcode)
);

select * from LibCard;

create table GenreMgm
(
   GenreMgmNumber int,
   GenreCode varchar2(50) references Genre(GenreCode),
   AdminId varchar2(50) references Admin(AdminId)
);

select * from GenreMgm;

drop table GenreMgm;
drop table LibCard;
drop table bookmgm;
drop table BookLoan;
drop table Book;
drop table admin;
drop table UserInfo;
drop table Genre;

select * from GenreMgm;



