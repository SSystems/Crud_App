drop table user_master;
drop table login_master;

create table user_master(
id VARCHAR2(64) primary key,
first_name VARCHAR2(64),
last_name VARCHAR2(64),
email VARCHAR2(128),
gender VARCHAR2(64),
active SMALLINT,
created_by VARCHAR2(128),
creation_date TIMESTAMP,
last_update_by VARCHAR2(128),
last_update_date TIMESTAMP,
status SMALLINT
);

create table login_master (
 id VARCHAR2(64) primary key,
 user_id VARCHAR2(64) REFERENCES user_master(id),
 username VARCHAR2(128) UNIQUE,
 password VARCHAR2(128),
 active SMALLINT,
 security_question VARCHAR2(128),
 security_answer VARCHAR2(128),
 last_login_time TIMESTAMP,
 created_by VARCHAR2(128),
creation_date TIMESTAMP,
last_update_by VARCHAR2(128),
last_update_date TIMESTAMP,
status SMALLINT
);

create table roles_master(
id,
role_name,
);

create table roles_priviledges();

create table case_master(
id VARCHAR2(64) primary key,
ucr varchar2(16) unique,
owner_id varchar2(64) references user_master(id),
created_by VARCHAR2(128),
creation_date TIMESTAMP,
last_update_by VARCHAR2(128),
last_update_date TIMESTAMP,
status SMALLINT
);

create table case_files(
id VARCHAR2(64) primary key,
file_name varchar2(64),
content blob,
case_id varchar2(64) references case_master(id),
created_by VARCHAR2(128),
creation_date TIMESTAMP,
last_update_by VARCHAR2(128),
last_update_date TIMESTAMP,
status SMALLINT
);

