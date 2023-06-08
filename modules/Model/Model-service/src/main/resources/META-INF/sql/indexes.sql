create index IX_6629CF7D on SP_Consultant (userId);

create index IX_588E156B on SP_ConsultantCustomer (consultantId);
create index IX_470B9A0E on SP_ConsultantCustomer (customerId);

create index IX_B74B97F4 on SP_Offer (type_[$COLUMN_LENGTH:75$], active_);

create index IX_FE68DFC2 on SP_Subscription (offerId);
create index IX_78B1B71F on SP_Subscription (userId);