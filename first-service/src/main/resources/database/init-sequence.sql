
create sequence if not exists soa.address_id_seq;
alter sequence soa.address_id_seq restart with 16;
create sequence if not exists soa.coordinates_id_seq;
alter sequence soa.coordinates_id_seq restart with 16;
create sequence if not exists soa.employee_id_seq;
alter sequence soa.employee_id_seq restart with 104;
create sequence if not exists soa.organization_id_seq;
alter sequence soa.organization_id_seq restart with 16;
create sequence if not exists soa.organization_type_id_seq;
alter sequence soa.organization_type_id_seq restart with 4;