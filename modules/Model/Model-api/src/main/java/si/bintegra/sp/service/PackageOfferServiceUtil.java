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

import si.bintegra.sp.model.PackageOffer;

/**
 * Provides the remote service utility for PackageOffer. This utility wraps
 * <code>si.bintegra.sp.service.impl.PackageOfferServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see PackageOfferService
 * @generated
 */
public class PackageOfferServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>si.bintegra.sp.service.impl.PackageOfferServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static PackageOffer createPackageOffer(
			Long offerId, Long fullDuration, Long discountDuration,
			Double discountPrice, Double basePrice, Boolean active)
		throws si.bintegra.sp.exception.NoSuchOfferException {

		return getService().createPackageOffer(
			offerId, fullDuration, discountDuration, discountPrice, basePrice,
			active);
	}

	public static List<PackageOffer> findActiveByOfferId(Long id) {
		return getService().findActiveByOfferId(id);
	}

	public static List<PackageOffer> findActiveByOfferType(String type)
		throws si.bintegra.sp.exception.NoSuchOfferException {

		return getService().findActiveByOfferType(type);
	}

	public static PackageOffer findById(Long id)
		throws si.bintegra.sp.exception.NoSuchPackageOfferException {

		return getService().findById(id);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static PackageOfferService getService() {
		return _service;
	}

	private static volatile PackageOfferService _service;

}