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

import si.bintegra.sp.model.PackageOffer;

/**
 * The cache model class for representing PackageOffer in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PackageOfferCacheModel
	implements CacheModel<PackageOffer>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PackageOfferCacheModel)) {
			return false;
		}

		PackageOfferCacheModel packageOfferCacheModel =
			(PackageOfferCacheModel)object;

		if (id == packageOfferCacheModel.id) {
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
		StringBundler sb = new StringBundler(15);

		sb.append("{id=");
		sb.append(id);
		sb.append(", offerId=");
		sb.append(offerId);
		sb.append(", fullDuration=");
		sb.append(fullDuration);
		sb.append(", discountDuration=");
		sb.append(discountDuration);
		sb.append(", basePrice=");
		sb.append(basePrice);
		sb.append(", discountPrice=");
		sb.append(discountPrice);
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PackageOffer toEntityModel() {
		PackageOfferImpl packageOfferImpl = new PackageOfferImpl();

		packageOfferImpl.setId(id);
		packageOfferImpl.setOfferId(offerId);
		packageOfferImpl.setFullDuration(fullDuration);
		packageOfferImpl.setDiscountDuration(discountDuration);
		packageOfferImpl.setBasePrice(basePrice);
		packageOfferImpl.setDiscountPrice(discountPrice);
		packageOfferImpl.setActive(active);

		packageOfferImpl.resetOriginalValues();

		return packageOfferImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		offerId = objectInput.readLong();

		fullDuration = objectInput.readLong();

		discountDuration = objectInput.readLong();

		basePrice = objectInput.readDouble();

		discountPrice = objectInput.readDouble();

		active = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(offerId);

		objectOutput.writeLong(fullDuration);

		objectOutput.writeLong(discountDuration);

		objectOutput.writeDouble(basePrice);

		objectOutput.writeDouble(discountPrice);

		objectOutput.writeBoolean(active);
	}

	public long id;
	public long offerId;
	public long fullDuration;
	public long discountDuration;
	public double basePrice;
	public double discountPrice;
	public boolean active;

}