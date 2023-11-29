create table patients(

    id bigint not null auto_increment,
    name varchar(100) not null,
    mail varchar(100) not null unique,
    document varchar(14) not null unique,
    street varchar(100) not null,
    zip_code varchar(10) not null,
    region varchar(30) not null,
    number varchar(30),
    more varchar(100),
    city varchar(60) not null,
    phone varchar(20) not null,
    status tinyint not null,

    primary key(id)

);