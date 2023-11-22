alter table doctors add status tinyint;

update doctors set status = 1;
update doctors set phone = "000000";