create index IX_B74B97F4 on SP_Offer (type_[$COLUMN_LENGTH:75$], active_);

create index IX_FE68DFC2 on SP_Subscription (offerId);
create index IX_78B1B71F on SP_Subscription (userId);