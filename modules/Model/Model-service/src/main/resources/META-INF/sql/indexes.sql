create index IX_A1AD3476 on SP_Foo (field2);
create index IX_9267ADFE on SP_Foo (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_A55F9C00 on SP_Foo (uuid_[$COLUMN_LENGTH:75$], groupId);