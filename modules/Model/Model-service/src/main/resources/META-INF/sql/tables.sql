create table SP_PackageOffer (
	id_ LONG not null primary key,
	packageId LONG,
	fullDuration LONG,
	discountDuration LONG,
	basePrice DOUBLE,
	discountPrice DOUBLE,
	active_ BOOLEAN
);

create table SP_Subscription (
	id_ LONG not null primary key,
	packageOffer LONG,
	userId LONG,
	phoneId LONG
);