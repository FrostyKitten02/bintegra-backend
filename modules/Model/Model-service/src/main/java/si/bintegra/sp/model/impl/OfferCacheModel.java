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

import si.bintegra.sp.model.Offer;

/**
 * The cache model class for representing Offer in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class OfferCacheModel implements CacheModel<Offer>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof OfferCacheModel)) {
			return false;
		}

		OfferCacheModel offerCacheModel = (OfferCacheModel)object;

		if (id == offerCacheModel.id) {
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
		StringBundler sb = new StringBundler(33);

		sb.append("{id=");
		sb.append(id);
		sb.append(", type=");
		sb.append(type);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", mobileData=");
		sb.append(mobileData);
		sb.append(", mobileMinutes=");
		sb.append(mobileMinutes);
		sb.append(", mobileSms=");
		sb.append(mobileSms);
		sb.append(", programsNumber=");
		sb.append(programsNumber);
		sb.append(", defaultNumberOfTvs=");
		sb.append(defaultNumberOfTvs);
		sb.append(", downloadSpeed=");
		sb.append(downloadSpeed);
		sb.append(", uploadSpeed=");
		sb.append(uploadSpeed);
		sb.append(", active=");
		sb.append(active);
		sb.append(", fullDurationMonths=");
		sb.append(fullDurationMonths);
		sb.append(", discountDurationMonths=");
		sb.append(discountDurationMonths);
		sb.append(", basePrice=");
		sb.append(basePrice);
		sb.append(", discountPrice=");
		sb.append(discountPrice);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Offer toEntityModel() {
		OfferImpl offerImpl = new OfferImpl();

		offerImpl.setId(id);

		if (type == null) {
			offerImpl.setType("");
		}
		else {
			offerImpl.setType(type);
		}

		if (title == null) {
			offerImpl.setTitle("");
		}
		else {
			offerImpl.setTitle(title);
		}

		if (description == null) {
			offerImpl.setDescription("");
		}
		else {
			offerImpl.setDescription(description);
		}

		offerImpl.setMobileData(mobileData);
		offerImpl.setMobileMinutes(mobileMinutes);
		offerImpl.setMobileSms(mobileSms);
		offerImpl.setProgramsNumber(programsNumber);
		offerImpl.setDefaultNumberOfTvs(defaultNumberOfTvs);
		offerImpl.setDownloadSpeed(downloadSpeed);
		offerImpl.setUploadSpeed(uploadSpeed);
		offerImpl.setActive(active);
		offerImpl.setFullDurationMonths(fullDurationMonths);
		offerImpl.setDiscountDurationMonths(discountDurationMonths);
		offerImpl.setBasePrice(basePrice);
		offerImpl.setDiscountPrice(discountPrice);

		offerImpl.resetOriginalValues();

		return offerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		type = objectInput.readUTF();
		title = objectInput.readUTF();
		description = objectInput.readUTF();

		mobileData = objectInput.readLong();

		mobileMinutes = objectInput.readLong();

		mobileSms = objectInput.readLong();

		programsNumber = objectInput.readLong();

		defaultNumberOfTvs = objectInput.readLong();

		downloadSpeed = objectInput.readLong();

		uploadSpeed = objectInput.readLong();

		active = objectInput.readBoolean();

		fullDurationMonths = objectInput.readLong();

		discountDurationMonths = objectInput.readLong();

		basePrice = objectInput.readDouble();

		discountPrice = objectInput.readDouble();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		if (type == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(type);
		}

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(mobileData);

		objectOutput.writeLong(mobileMinutes);

		objectOutput.writeLong(mobileSms);

		objectOutput.writeLong(programsNumber);

		objectOutput.writeLong(defaultNumberOfTvs);

		objectOutput.writeLong(downloadSpeed);

		objectOutput.writeLong(uploadSpeed);

		objectOutput.writeBoolean(active);

		objectOutput.writeLong(fullDurationMonths);

		objectOutput.writeLong(discountDurationMonths);

		objectOutput.writeDouble(basePrice);

		objectOutput.writeDouble(discountPrice);
	}

	public long id;
	public String type;
	public String title;
	public String description;
	public long mobileData;
	public long mobileMinutes;
	public long mobileSms;
	public long programsNumber;
	public long defaultNumberOfTvs;
	public long downloadSpeed;
	public long uploadSpeed;
	public boolean active;
	public long fullDurationMonths;
	public long discountDurationMonths;
	public double basePrice;
	public double discountPrice;

}