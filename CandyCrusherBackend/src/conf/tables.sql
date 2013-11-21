drop table transactions;
drop table accounts;
drop table customer_group;
drop table groups;
drop table banktellers;
drop table customers;
drop sequence customer_seq restrict;
drop sequence bankteller_seq restrict;
drop sequence account_seq restrict;
drop sequence transaction_seq restrict;

--------


Create sequence customer_seq start with 1000;


create table groups (
    group_name varchar(20) not null primary key,
    group_desc varchar(200) default null
);

create table customers (
    customer_id int not null primary key,
    first_name varchar(40) not null,
    last_name varchar(40) not null,
    email varchar(100) not null unique,
    password varchar(150) not null,
    customer_role int
);

Create sequence bankteller_seq start with 1000;

create table banktellers (
    bankteller_id int primary key,
    first_name varchar(40) not null,
    last_name varchar(40) not null,
    email varchar(40) not null,
    password varchar(150) not null,
    bankteller_role int
);


create table customer_group (
    email varchar(100) not null,
    group_name varchar(20) not null,
    primary key (email, group_name),
    constraint fk_email foreign key (email)
    references customers(email),
    constraint fk_group_name foreign key (group_name)
    references groups(group_name)
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

