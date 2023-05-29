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
 * Provides a wrapper for {@link OfferService}.
 *
 * @author Brian Wing Shun Chan
 * @see OfferService
 * @generated
 */
public class OfferServiceWrapper
	implements OfferService, ServiceWrapper<OfferService> {

	public OfferServiceWrapper() {
		this(null);
	}

	public OfferServiceWrapper(OfferService offerService) {
		_offerService = offerService;
	}

	@Override
	public si.bintegra.sp.model.Offer addOffer(
		String title, String type, String description, Boolean active,
		Long mobileData, Long mobileMinutes, Long mobileSms,
		Long programsNumber, Long defaultNumberOfTvs, Long downloadSpeed,
		Long uploadSpeed) {

		return _offerService.addOffer(
			title, type, description, active, mobileData, mobileMinutes,
			mobileSms, programsNumber, defaultNumberOfTvs, downloadSpeed,
			uploadSpeed);
	}

	@Override
	public java.util.List<si.bintegra.sp.model.Offer> findActiveByType(
		String type) {

		return _offerService.findActiveByType(type);
	}

	@Override
	public si.bintegra.sp.model.Offer findById(Long id)
		throws si.bintegra.sp.exception.NoSuchOfferException {

		return _offerService.findById(id);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _offerService.getOSGiServiceIdentifier();
	}

	@Override
	public OfferService getWrappedService() {
		return _offerService;
	}

	@Override
	public void setWrappedService(OfferService offerService) {
		_offerService = offerService;
	}

	private OfferService _offerService;

}