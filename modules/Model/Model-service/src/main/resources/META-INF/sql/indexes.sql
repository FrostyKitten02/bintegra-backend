create index IX_B74B97F4 on SP_Offer (type_[$COLUMN_LENGTH:75$], active_);

create index IX_DF3A6A8B on SP_PackageOffer (active_);
create index IX_33193BA0 on SP_PackageOffer (offerId, active_);

create index IX_EE4C654F on SP_Subscription (packageOffer);
create index IX_78B1B71F on SP_Subscription (userId);