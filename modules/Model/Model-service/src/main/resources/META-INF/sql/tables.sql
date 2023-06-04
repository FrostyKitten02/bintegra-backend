create table SP_Offer (
	id_ LONG not null primary key,
	type_ VARCHAR(75) null,
	title VARCHAR(75) null,
	description VARCHAR(75) null,
	mobileData LONG,
	mobileMinutes LONG,
	mobileSms LONG,
	programsNumber LONG,
	defaultNumberOfTvs LONG,
	downloadSpeed LONG,
	uploadSpeed LONG,
	active_ BOOLEAN,
	fullDurationMonths LONG,
	discountDurationMonths LONG,
	basePrice DOUBLE,
	discountPrice DOUBLE
);

create table SP_Subscription (
	id_ LONG not null primary key,
	offerId LONG,
	startDate LONG,
	userId LONG,
	phoneId LONG,
	contractSubscription BOOLEAN
);