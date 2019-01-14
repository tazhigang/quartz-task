create table cron(
  id int PRIMARY KEY auto_increment,
  cron varchar(30)
);
INSERT INTO cron(id,cron) VALUES (null,'0 15 15 14 1 ?');'