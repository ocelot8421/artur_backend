create database IF NOT EXISTS  test1_db;
create user IF NOT EXISTS 'test1User'@'%' identified by 'test1Password';
grant all on test1_db.* to 'test1User'@'%';

create database IF NOT EXISTS  test2_db;
create user IF NOT EXISTS 'test2User'@'%' identified by 'test2Password';
grant all on test2_db.* to 'test1User'@'%';