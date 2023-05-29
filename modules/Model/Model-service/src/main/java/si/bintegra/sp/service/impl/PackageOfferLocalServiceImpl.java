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


import com.sun.tools.javac.util.Pair;
import org.osgi.service.component.annotations.Component;

import org.osgi.service.component.annotations.Reference;
import si.bintegra.sp.exception.NoSuchOfferException;
import si.bintegra.sp.exception.NoSuchPackageOfferException;
import si.bintegra.sp.model.Offer;
import si.bintegra.sp.model.PackageOffer;
import si.bintegra.sp.service.PackageOfferService;
import si.bintegra.sp.service.base.PackageOfferLocalServiceBaseImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=si.bintegra.sp.model.PackageOffer",
	service = AopService.class
)
public class PackageOfferLocalServiceImpl
	extends PackageOfferLocalServiceBaseImpl {
	@Reference
	private OfferLocalServiceImpl offerLocalService;

	public List<PackageOffer> findActiveByOfferId(Long id) {
		return packageOfferPersistence.findByofferIdAndActive(id, true);
	}

	public PackageOffer findById(Long id) throws NoSuchPackageOfferException {
		return packageOfferPersistence.findByid(id);
	}

	public List<PackageOffer> findActiveByOfferType(String type) throws NoSuchOfferException {
		List<PackageOffer> allActive  = packageOfferPersistence.findByactive(true);
		List<PackageOffer> result = new ArrayList<>(allActive.size());

		for (PackageOffer p : allActive) {
			if (offerLocalService.findById(p.getOfferId()).getType().equals(type)) {
				result.add(p);
			}
		}

		return result;
	}

	public PackageOffer createPackageOffer(Long offerId, Long fullDuration, Long discountDuration, Double discountPrice, Double basePrice, Boolean active) throws NoSuchOfferException {
		offerLocalService.findById(offerId);//checking if offer exists
		PackageOffer packageOffer = createPackageOffer(counterLocalService.increment(PackageOffer.class.getName()));

		packageOffer.setOfferId(offerId);
		packageOffer.setFullDuration(fullDuration);
		packageOffer.setDiscountDuration(discountDuration);
		packageOffer.setDiscountPrice(discountPrice);
		packageOffer.setBasePrice(basePrice);
		packageOffer.setActive(active);

		return packageOffer;
	}

}