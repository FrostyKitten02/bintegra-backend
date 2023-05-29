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
 * This class is a wrapper for {@link Subscription}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Subscription
 * @generated
 */
public class SubscriptionWrapper
	extends BaseModelWrapper<Subscription>
	implements ModelWrapper<Subscription>, Subscription {

	public SubscriptionWrapper(Subscription subscription) {
		super(subscription);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("packageOffer", getPackageOffer());
		attributes.put("startDate", getStartDate());
		attributes.put("userId", getUserId());
		attributes.put("phoneId", getPhoneId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long packageOffer = (Long)attributes.get("packageOffer");

		if (packageOffer != null) {
			setPackageOffer(packageOffer);
		}

		Long startDate = (Long)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long phoneId = (Long)attributes.get("phoneId");

		if (phoneId != null) {
			setPhoneId(phoneId);
		}
	}

	@Override
	public Subscription cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the ID of this subscription.
	 *
	 * @return the ID of this subscription
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the package offer of this subscription.
	 *
	 * @return the package offer of this subscription
	 */
	@Override
	public Long getPackageOffer() {
		return model.getPackageOffer();
	}

	/**
	 * Returns the phone ID of this subscription.
	 *
	 * @return the phone ID of this subscription
	 */
	@Override
	public Long getPhoneId() {
		return model.getPhoneId();
	}

	/**
	 * Returns the primary key of this subscription.
	 *
	 * @return the primary key of this subscription
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the start date of this subscription.
	 *
	 * @return the start date of this subscription
	 */
	@Override
	public Long getStartDate() {
		return model.getStartDate();
	}

	/**
	 * Returns the user ID of this subscription.
	 *
	 * @return the user ID of this subscription
	 */
	@Override
	public Long getUserId() {
		return model.getUserId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the ID of this subscription.
	 *
	 * @param id the ID of this subscription
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the package offer of this subscription.
	 *
	 * @param packageOffer the package offer of this subscription
	 */
	@Override
	public void setPackageOffer(Long packageOffer) {
		model.setPackageOffer(packageOffer);
	}

	/**
	 * Sets the phone ID of this subscription.
	 *
	 * @param phoneId the phone ID of this subscription
	 */
	@Override
	public void setPhoneId(Long phoneId) {
		model.setPhoneId(phoneId);
	}

	/**
	 * Sets the primary key of this subscription.
	 *
	 * @param primaryKey the primary key of this subscription
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the start date of this subscription.
	 *
	 * @param startDate the start date of this subscription
	 */
	@Override
	public void setStartDate(Long startDate) {
		model.setStartDate(startDate);
	}

	/**
	 * Sets the user ID of this subscription.
	 *
	 * @param userId the user ID of this subscription
	 */
	@Override
	public void setUserId(Long userId) {
		model.setUserId(userId);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected SubscriptionWrapper wrap(Subscription subscription) {
		return new SubscriptionWrapper(subscription);
	}

}