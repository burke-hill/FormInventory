create database projectInventory;

use projectInventory;

create table clients (
    clientID integer,
    clientName varchar(20) not null,
    companyType varchar(20) not null,
    state varchar(20) not null,
    numFiles integer,
    primary key (clientID)
);


insert into clients values (12345, 'Amazon', 'Sales', 'Washington', 5);