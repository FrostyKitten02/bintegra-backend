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

package si.bintegra.sp.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ConsultantCustomer}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ConsultantCustomer
 * @generated
 */
public class ConsultantCustomerWrapper
	extends BaseModelWrapper<ConsultantCustomer>
	implements ConsultantCustomer, ModelWrapper<ConsultantCustomer> {

	public ConsultantCustomerWrapper(ConsultantCustomer consultantCustomer) {
		super(consultantCustomer);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("consultantId", getConsultantId());
		attributes.put("customerId", getCustomerId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long consultantId = (Long)attributes.get("consultantId");

		if (consultantId != null) {
			setConsultantId(consultantId);
		}

		Long customerId = (Long)attributes.get("customerId");

		if (customerId != null) {
			setCustomerId(customerId);
		}
	}

	@Override
	public ConsultantCustomer cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the consultant ID of this consultant customer.
	 *
	 * @return the consultant ID of this consultant customer
	 */
	@Override
	public Long getConsultantId() {
		return model.getConsultantId();
	}

	/**
	 * Returns the customer ID of this consultant customer.
	 *
	 * @return the customer ID of this consultant customer
	 */
	@Override
	public Long getCustomerId() {
		return model.getCustomerId();
	}

	/**
	 * Returns the ID of this consultant customer.
	 *
	 * @return the ID of this consultant customer
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the primary key of this consultant customer.
	 *
	 * @return the primary key of this consultant customer
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the consultant ID of this consultant customer.
	 *
	 * @param consultantId the consultant ID of this consultant customer
	 */
	@Override
	public void setConsultantId(Long consultantId) {
		model.setConsultantId(consultantId);
	}

	/**
	 * Sets the customer ID of this consultant customer.
	 *
	 * @param customerId the customer ID of this consultant customer
	 */
	@Override
	public void setCustomerId(Long customerId) {
		model.setCustomerId(customerId);
	}

	/**
	 * Sets the ID of this consultant customer.
	 *
	 * @param id the ID of this consultant customer
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the primary key of this consultant customer.
	 *
	 * @param primaryKey the primary key of this consultant customer
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected ConsultantCustomerWrapper wrap(
		ConsultantCustomer consultantCustomer) {

		return new ConsultantCustomerWrapper(consultantCustomer);
	}

}