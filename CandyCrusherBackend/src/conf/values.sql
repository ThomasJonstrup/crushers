delete from transactions;
delete from MONEY_MARKET_ACCOUNTS;
delete from TIME_DEPOSIT_ACCOUNTS;
delete from accounts;
delete from customers;
delete from banktellers;
delete from person_groups;
delete from persons;
delete from groups;

--------

insert into groups values ('Banktellers', 'Banktellers');
insert into groups values ('Customers', 'Bank customers');

--Customers--
insert into persons (email, password)
values('ph@cph.dk', '9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08');

insert into person_groups values('ph@cph.dk', 'Customers');

insert into persons (email, password)
values('mh@cph.dk', 'q');

insert into person_groups values ('mh@cph.dk', 'Customers');

insert into persons (email, password)
values('lh@cph.dk', 'q');

insert into person_groups values ('lh@cph.dk', 'Customers');

insert into customers (customer_id, first_name, last_name, email)
values (1,'Pia', 'Holm', 'ph@cph.dk');
----
insert into customers (customer_id, first_name, last_name, email)
values (2,'Mogens', 'Holm', 'mh@cph.dk');

insert into customers (customer_id, first_name, last_name, email)
values (3,'Lasse', 'Holm', 'lh@cph.dk');

--Banktellers--

insert into persons (email, password)
values('hl@cph.dk', 'q');

insert into person_groups values ('hl@cph.dk', 'Banktellers');

insert into persons (email, password)
values('mah@cph.dk', '9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08');

insert into person_groups values ('mah@cph.dk', 'Banktellers');

insert into persons (email, password)
values('tl@cph.dk', '9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08');

insert into person_groups values ('tl@cph.dk', 'Banktellers');


insert into banktellers (bankteller_id, first_name, last_name, email)
values (1,'Hans', 'Larsen', 'hl@cph.dk');

insert into banktellers (bankteller_id, first_name, last_name, email)
values (2,'Mads', 'Larsen', 'mah@cph.dk');

insert into banktellers (bankteller_id, first_name, last_name, email)
values (3,'Thomas', 'Larsen', 'tl@cph.dk');


--Accounts-----

insert into accounts(account_id, dtype, account_type, balance, owner)
values (1, 'MoneyMarketAccount', 'Savings', 100, 1);

insert into money_market_accounts(account_id, min_balance) values (1, 500000.0);

insert into accounts(account_id,  dtype, account_type, balance, owner)
values (2, 'MoneyMarketAccount', 'Pension', 500, 2);

insert into money_market_accounts(account_id, min_balance) values (2, 500000.0);

insert into accounts(account_id,  dtype, account_type, balance, owner)
values (3, 'MoneyMarketAccount', 'MULLE', 700000, 3);

insert into accounts(account_id, dtype, account_type, balance, owner)
values  (4, 'TimeDepositAccount','Time', 70000, 1); 
insert into accounts(account_id, dtype, account_type, balance, owner)
values  (5, 'TimeDepositAccount','Deposit',75000, 3); 

insert into money_market_accounts(account_id, min_balance) 
values (3, 300000.0);


insert into TIME_DEPOSIT_ACCOUNTS(ACCOUNT_ID,START_DATE,END_DATE) 
values (4,'2013-12-14', '2014-03-18');

insert into TIME_DEPOSIT_ACCOUNTS(ACCOUNT_ID,START_DATE,END_DATE)
values (5,'2013-12-18', '2014-04-10');
--Transactions----

insert into transactions(transaction_id, transaction_date, ammount, balance, info, message, source_account_id, target_account_id)
values (1, '2013-11-18', 100, 10000, 'money','overførsel', 1, 2);