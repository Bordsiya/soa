
create sequence if not exists address_id_seq;
alter sequence address_id_seq restart with 16;
create sequence if not exists coordinates_id_seq;
alter sequence coordinates_id_seq restart with 16;
create sequence if not exists employee_id_seq;
alter sequence employee_id_seq restart with 104;
create sequence if not exists organization_id_seq;
alter sequence organization_id_seq restart with 16;
create sequence if not exists organization_type_id_seq;
alter sequence organization_type_id_seq restart with 4;