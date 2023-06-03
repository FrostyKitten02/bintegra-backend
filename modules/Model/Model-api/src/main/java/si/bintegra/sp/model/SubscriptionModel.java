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

import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Subscription service. Represents a row in the &quot;SP_Subscription&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>si.bintegra.sp.model.impl.SubscriptionModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>si.bintegra.sp.model.impl.SubscriptionImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Subscription
 * @generated
 */
@ProviderType
public interface SubscriptionModel extends BaseModel<Subscription> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a subscription model instance should use the {@link Subscription} interface instead.
	 */

	/**
	 * Returns the primary key of this subscription.
	 *
	 * @return the primary key of this subscription
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this subscription.
	 *
	 * @param primaryKey the primary key of this subscription
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this subscription.
	 *
	 * @return the ID of this subscription
	 */
	public long getId();

	/**
	 * Sets the ID of this subscription.
	 *
	 * @param id the ID of this subscription
	 */
	public void setId(long id);

	/**
	 * Returns the offer ID of this subscription.
	 *
	 * @return the offer ID of this subscription
	 */
	public Long getOfferId();

	/**
	 * Sets the offer ID of this subscription.
	 *
	 * @param offerId the offer ID of this subscription
	 */
	public void setOfferId(Long offerId);

	/**
	 * Returns the start date of this subscription.
	 *
	 * @return the start date of this subscription
	 */
	public Long getStartDate();

	/**
	 * Sets the start date of this subscription.
	 *
	 * @param startDate the start date of this subscription
	 */
	public void setStartDate(Long startDate);

	/**
	 * Returns the user ID of this subscription.
	 *
	 * @return the user ID of this subscription
	 */
	public Long getUserId();

	/**
	 * Sets the user ID of this subscription.
	 *
	 * @param userId the user ID of this subscription
	 */
	public void setUserId(Long userId);

	/**
	 * Returns the phone ID of this subscription.
	 *
	 * @return the phone ID of this subscription
	 */
	public Long getPhoneId();

	/**
	 * Sets the phone ID of this subscription.
	 *
	 * @param phoneId the phone ID of this subscription
	 */
	public void setPhoneId(Long phoneId);

	@Override
	public Subscription cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}