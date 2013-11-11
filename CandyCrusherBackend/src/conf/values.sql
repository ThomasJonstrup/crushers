delete from customers;
delete from banktellers;
delete from groups;

--------



--Customers--

insert into customers (customer_id, first_name, last_name, email, password, customer_role)
values (1,'Pia', 'Holm', 'ph@cph.dk', 'q', 1);

insert into customers (customer_id, first_name, last_name, email, password, customer_role)
values (2,'Mogens', 'Holm', 'mh@cph.dk', 'q', 1);

insert into customers (customer_id, first_name, last_name, email, password, customer_role)
values (3,'Lasse', 'Holm', 'lh@cph.dk','q', 1);

--Banktellers--

insert into banktellers (bankteller_id, first_name, last_name, email, password, bankteller_role)
values (1,'Hans', 'Larsen', 'ph@cph.dk', 'q', 1);

insert into banktellers (bankteller_id, first_name, last_name, email, password, bankteller_role)
values (2,'Mads', 'Larsen', 'mh@cph.dk', 'q', 1);

insert into banktellers (bankteller_id, first_name, last_name, email, password, bankteller_role)
values (3,'Thomas', 'Larsen', 'lh@cph.dk','q', 1);


--Groups----

insert into groups (group_name, group_desc)
values ('Customers', 'Bank customers');

insert into groups (group_name, group_desc)
values ('Banktellers', 'Banktellers');

insert into customer_group(email, group_name)
values ('ph@cph.dk', 'Customers')


