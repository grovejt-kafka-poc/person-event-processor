drop table member if exists;
drop table person_event if exists;
drop sequence if exists hibernate_sequence;
create sequence hibernate_sequence start with 1 increment by 1;

create table MEMBER (
	id bigint not null, 

	first_name varchar(255), 
	middle_name varchar(255), 
	last_name varchar(255), 
	email varchar(255) not null, 
	birth_date timestamp, 

	address_line1 varchar(255), 
	address_line2 varchar(255), 
	city varchar(255), 
	state varchar(255), 
	
	primary key (id)
);

create table PERSON_EVENT (
	id bigint not null, 
	event_type varchar(255), 
	person_id bigint, 
	event_status varchar(255), 
	processing_failure_exception varchar(255),
	created_timestamp timestamp,
	primary key (id)
);
