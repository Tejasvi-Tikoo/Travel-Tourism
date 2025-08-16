create database traveldb;
show databases;
use traveldb;
create table account(username varchar(20),name varchar(20),password varchar(20),securityQ varchar(100), answer varchar(50));
show tables;
select * from account;
use traveldb;
create table customer(username varchar(20),id varchar(30),number varchar(30),name varchar(20),gender varchar(20),country varchar(30), address varchar(50), phone varchar(15),email varchar(40));
show tables;
use traveldb;
select * from account;
select * from customer;

select * from package;
drop table package;

create table package (username varchar(20),packagetype varchar(30),totalheads varchar(1),id varchar(30), email varchar(40),phone varchar(15),price varchar(20));
create table hotel(username varchar(20),hotelname varchar(20),totalheads varchar(1),Nod varchar(1),ac varchar(20),id varchar(30),email varchar(40),phone varchar(15),price varchar(20));
create table hotelinfo(hotelname varchar(20),costpp varchar(20),acroom varchar(10));
insert into hotelinfo values("JWMarriot","5000","4000");
insert into hotelinfo values("Raddison Blue","3800","4200");
insert into hotelinfo values("Chilly","2000","2000");
insert into hotelinfo values("Classio","3000","2000");
insert into hotelinfo values("The SeaView","19000","3000");
select * from hotelinfo;
select * from hotel;
