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

import java.util.List;

import si.bintegra.sp.model.Subscription;

/**
 * Provides the remote service utility for Subscription. This utility wraps
 * <code>si.bintegra.sp.service.impl.SubscriptionServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see SubscriptionService
 * @generated
 */
public class SubscriptionServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>si.bintegra.sp.service.impl.SubscriptionServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Subscription addSubscription(
		Long packageOfferId, Long userId, Long phoneId, Long startDate) {

		return getService().addSubscription(
			packageOfferId, userId, phoneId, startDate);
	}

	public static List<Subscription> findSubscriptionsByUserId(Long userId) {
		return getService().findSubscriptionsByUserId(userId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static SubscriptionService getService() {
		return _service;
	}

	private static volatile SubscriptionService _service;

}