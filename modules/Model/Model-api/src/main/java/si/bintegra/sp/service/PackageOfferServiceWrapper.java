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
 * Provides a wrapper for {@link PackageOfferService}.
 *
 * @author Brian Wing Shun Chan
 * @see PackageOfferService
 * @generated
 */
public class PackageOfferServiceWrapper
	implements PackageOfferService, ServiceWrapper<PackageOfferService> {

	public PackageOfferServiceWrapper() {
		this(null);
	}

	public PackageOfferServiceWrapper(PackageOfferService packageOfferService) {
		_packageOfferService = packageOfferService;
	}

	@Override
	public java.util.List<si.bintegra.sp.model.PackageOffer>
		findActiveByPackageId(Long id) {

		return _packageOfferService.findActiveByPackageId(id);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _packageOfferService.getOSGiServiceIdentifier();
	}

	@Override
	public PackageOfferService getWrappedService() {
		return _packageOfferService;
	}

	@Override
	public void setWrappedService(PackageOfferService packageOfferService) {
		_packageOfferService = packageOfferService;
	}

	private PackageOfferService _packageOfferService;

}