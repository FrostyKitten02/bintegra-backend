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

package si.bintegra.sp.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SubscriptionService}.
 *
 * @author Brian Wing Shun Chan
 * @see SubscriptionService
 * @generated
 */
public class SubscriptionServiceWrapper
	implements ServiceWrapper<SubscriptionService>, SubscriptionService {

	public SubscriptionServiceWrapper() {
		this(null);
	}

	public SubscriptionServiceWrapper(SubscriptionService subscriptionService) {
		_subscriptionService = subscriptionService;
	}

	@Override
	public si.bintegra.sp.model.Subscription addSubscription(
		Long packageOfferId, Long userId, Long phoneId) {

		return _subscriptionService.addSubscription(
			packageOfferId, userId, phoneId);
	}

	@Override
	public java.util.List<si.bintegra.sp.model.Subscription>
		findSubscriptionsByUserId(Long userId) {

		return _subscriptionService.findSubscriptionsByUserId(userId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _subscriptionService.getOSGiServiceIdentifier();
	}

	@Override
	public SubscriptionService getWrappedService() {
		return _subscriptionService;
	}

	@Override
	public void setWrappedService(SubscriptionService subscriptionService) {
		_subscriptionService = subscriptionService;
	}

	private SubscriptionService _subscriptionService;

}