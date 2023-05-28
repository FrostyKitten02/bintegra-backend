create index IX_DF3A6A8B on SP_PackageOffer (active_);
create index IX_35B26DF6 on SP_PackageOffer (packageId, active_);

create index IX_EE4C654F on SP_Subscription (packageOffer);
create index IX_78B1B71F on SP_Subscription (userId);