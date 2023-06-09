/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package si.bintegra.sp.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import si.bintegra.sp.model.Subscription;

/**
 * The cache model class for representing Subscription in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SubscriptionCacheModel
	implements CacheModel<Subscription>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SubscriptionCacheModel)) {
			return false;
		}

		SubscriptionCacheModel subscriptionCacheModel =
			(SubscriptionCacheModel)object;

		if (id == subscriptionCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{id=");
		sb.append(id);
		sb.append(", offerId=");
		sb.append(offerId);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", phoneId=");
		sb.append(phoneId);
		sb.append(", contractSubscription=");
		sb.append(contractSubscription);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Subscription toEntityModel() {
		SubscriptionImpl subscriptionImpl = new SubscriptionImpl();

		subscriptionImpl.setId(id);
		subscriptionImpl.setOfferId(offerId);
		subscriptionImpl.setStartDate(startDate);
		subscriptionImpl.setUserId(userId);
		subscriptionImpl.setPhoneId(phoneId);
		subscriptionImpl.setContractSubscription(contractSubscription);

		subscriptionImpl.resetOriginalValues();

		return subscriptionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		offerId = objectInput.readLong();

		startDate = objectInput.readLong();

		userId = objectInput.readLong();

		phoneId = objectInput.readLong();

		contractSubscription = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(offerId);

		objectOutput.writeLong(startDate);

		objectOutput.writeLong(userId);

		objectOutput.writeLong(phoneId);

		objectOutput.writeBoolean(contractSubscription);
	}

	public long id;
	public long offerId;
	public long startDate;
	public long userId;
	public long phoneId;
	public boolean contractSubscription;

}