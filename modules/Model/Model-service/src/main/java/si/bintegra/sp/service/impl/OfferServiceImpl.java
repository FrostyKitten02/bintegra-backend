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

package si.bintegra.sp.service.impl;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

import si.bintegra.sp.exception.NoSuchOfferException;
import si.bintegra.sp.model.Offer;
import si.bintegra.sp.service.base.OfferServiceBaseImpl;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=sp",
		"json.web.service.context.path=Offer"
	},
	service = AopService.class
)
public class OfferServiceImpl extends OfferServiceBaseImpl {
	public List<Offer> findActiveByType(String type) {
		//todo premisisons check!!!
		return offerLocalService.findActiveByType(type);
	}

	public Offer findById(Long id) throws NoSuchOfferException {
		//todo premisisons check!!!
		return offerLocalService.findById(id);
	}

	public Offer addOffer(String title, String type, String description, Boolean active, Long mobileData, Long mobileMinutes, Long mobileSms, Long programsNumber, Long defaultNumberOfTvs, Long downloadSpeed, Long uploadSpeed) {
		//todo premisisons check!!!
		return offerLocalService.addOffer(title, type, description, active, mobileData, mobileMinutes, mobileSms, programsNumber, defaultNumberOfTvs, downloadSpeed, uploadSpeed);
	}
}