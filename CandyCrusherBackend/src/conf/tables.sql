drop table transactions;
drop table accounts;
drop table banktellers;
drop table customers;
drop table person_groups;
drop table groups;
drop table persons;
drop sequence customer_seq restrict;
drop sequence bankteller_seq restrict;
drop sequence account_seq restrict;
drop sequence transaction_seq restrict;

--------


Create sequence customer_seq start with 1000;


create table groups (
    group_name varchar(20) primary key,
    group_desc varchar(200)
);

create table persons (
    email varchar(100) primary key,
    password varchar(150) not null
);

create table person_groups(
    email varchar(100) references persons(email),
    group_name varchar(20) references groups(group_name),
    primary key(email, group_name)
);

create table customers (
    customer_id int not null primary key,
    first_name varchar(40) not null,
    last_name varchar(40) not null,
    email varchar(100) not null unique references persons(email)
);

Create sequence bankteller_seq start with 1000;

create table banktellers (
    bankteller_id int primary key,
    first_name varchar(40) not null,
    last_name varchar(40) not null,
    email varchar(100) not null unique references persons(email)
);

Create sequence account_seq start with 1000;

create table accounts (
    account_id int primary key,
    account_type varchar(40) not null,
    balance double,
    owner int not null,
    constraint fk_customer_id foreign key (owner)
    references customers(customer_id)
);

create sequence transaction_seq start with 1000;

create table transactions (
    transaction_id int primary key,
    transaction_date date,
    ammount double,
    balance double,
    info varchar(250),
    message varchar(250),
    source_account_id int not null references accounts(account_id),
    target_account_id int not null references accounts(account_id)
);

