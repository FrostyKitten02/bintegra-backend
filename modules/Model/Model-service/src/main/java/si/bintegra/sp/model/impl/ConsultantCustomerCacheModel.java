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

import si.bintegra.sp.model.ConsultantCustomer;

/**
 * The cache model class for representing ConsultantCustomer in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ConsultantCustomerCacheModel
	implements CacheModel<ConsultantCustomer>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ConsultantCustomerCacheModel)) {
			return false;
		}

		ConsultantCustomerCacheModel consultantCustomerCacheModel =
			(ConsultantCustomerCacheModel)object;

		if (id == consultantCustomerCacheModel.id) {
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
		StringBundler sb = new StringBundler(7);

		sb.append("{id=");
		sb.append(id);
		sb.append(", consultantId=");
		sb.append(consultantId);
		sb.append(", customerId=");
		sb.append(customerId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ConsultantCustomer toEntityModel() {
		ConsultantCustomerImpl consultantCustomerImpl =
			new ConsultantCustomerImpl();

		consultantCustomerImpl.setId(id);
		consultantCustomerImpl.setConsultantId(consultantId);
		consultantCustomerImpl.setCustomerId(customerId);

		consultantCustomerImpl.resetOriginalValues();

		return consultantCustomerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		consultantId = objectInput.readLong();

		customerId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(consultantId);

		objectOutput.writeLong(customerId);
	}

	public long id;
	public long consultantId;
	public long customerId;

}