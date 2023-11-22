create table doctors(

    id bigint not null auto_increment,
    name varchar(100) not null,
    mail varchar(100) not null unique,
    code varchar(6) not null unique,
    category varchar(100) not null,
    street varchar(100) not null,
    zip_code varchar(10) not null,
    region varchar(30) not null,
    number varchar(30),
    more varchar(100),
    city varchar(60) not null,

    primary key(id)
);