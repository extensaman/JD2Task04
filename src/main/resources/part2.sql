create database people;
use people;
create table person (
                        id int(11) primary key auto_increment,
                        age int check (age > 0 and age < 130),
                        salary decimal(8,2),
                        passport char(10) not null ,
                        address varchar(200),
                        dateOfBirthday date,
                        dateTimeCreate timestamp,
                        timeToLunch time,
                        letter mediumtext
);
insert into person (age, salary, passport, address, dateOfBirthday, dateTimeCreate, timeToLunch, letter) VALUES
(17,1000.90,'VC1773146','Minsk, str.Guri','2000-12-22', now(),'13:00','Lipsum ipsum1'),
(25,2305.45,'RT4347823','Minsk, str.Saperov','1990-10-09', now(),'12:00','Lipsum ipsum2'),
(18,956.80,'FG2373476','Minsk, str.Central','1999-09-12', now(),'12:30','Lipsum ipsum3'),
(24,3300.72,'PL1453345','Minsk, str.Apples','2000-04-30', now(),'13:00','Lipsum ipsum4'),
(23,5780.99,'DE8264921','Minsk, str.Goldovaya','2001-02-20', now(),'12:30','Lipsum ipsum5');
select * from person where age > 21 order by dateTimeCreate;