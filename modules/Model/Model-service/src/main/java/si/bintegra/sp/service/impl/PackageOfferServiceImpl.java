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
import si.bintegra.sp.exception.NoSuchPackageOfferException;
import si.bintegra.sp.model.PackageOffer;
import si.bintegra.sp.service.base.PackageOfferServiceBaseImpl;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=sp",
		"json.web.service.context.path=PackageOffer"
	},
	service = AopService.class
)
public class PackageOfferServiceImpl extends PackageOfferServiceBaseImpl {
	public List<PackageOffer> findActiveByOfferId(Long id) {
		//TODO check premissions!!!
		return packageOfferLocalService.findActiveByOfferId(id);
	}

	public PackageOffer findById(Long id) throws NoSuchPackageOfferException {
		//TODO check premissions!!!
		return packageOfferLocalService.findById(id);
	}

	public List<PackageOffer> findActiveByOfferType(String type) throws NoSuchOfferException {
		//TODO check premissions!!!
		return packageOfferLocalService.findActiveByOfferType(type);
	}

	public PackageOffer createPackageOffer(Long offerId, Long fullDuration, Long discountDuration, Double discountPrice, Double basePrice, Boolean active) throws NoSuchOfferException {
		//TODO check premissions!!!
		return packageOfferLocalService.createPackageOffer(offerId, fullDuration, discountDuration, discountPrice, basePrice, active);
	}


}