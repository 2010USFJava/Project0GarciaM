create schema if not exists bankapp authorization aquamiguel;

create table customer(
user_ID serial primary key,
bank_ID serial,
firstName varchar(20),
lastName varchar(20),
email varchar(40),
userPassword varchar(20),
phone varchar (12)
);

create table bankaccount(
bank_account_ID serial primary key,
accountBalance double precision,
transactionCount int,
accountType varchar(20)
);

ALTER TABLE customer
ADD UNIQUE (bank_ID),
ADD FOREIGN KEY (bank_ID) REFERENCES bankaccount(bank_account_ID);

create table employee(
employeeNumber serial primary key,
fname varchar(20),
lname varchar(20),
email varchar(40),
employeePassword varchar(20)
)

create function bankapp.counts() 
  returns bigint as $$
	   select count (distinct bank_account_id) 
   from bankapp.bankaccount;
$$ language sql;
 
   





